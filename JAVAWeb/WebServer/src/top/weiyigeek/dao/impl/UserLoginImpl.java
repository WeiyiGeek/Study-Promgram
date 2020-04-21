package top.weiyigeek.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import top.weiyigeek.dao.User;
import top.weiyigeek.main.LoginBean;
import top.weiyigeek.main.Person;
import top.weiyigeek.main.registerBean;
import top.weiyigeek.utils.DB;

public class UserLoginImpl implements User {

    @Override
    public Person userlogin(LoginBean user) throws SQLException {
        QueryRunner qr = new QueryRunner(DB.getConn());
        Person res = qr.query("SELECT sid,sname,gender,telephone,job,info,jointime FROM person WHERE sname = ? and spass = ?", new BeanHandler<Person>(Person.class) , user.getUsername() , user.getPassword());
        return res;
    }

    @Override
    public int userregister(registerBean user) throws SQLException {
        QueryRunner runner = new QueryRunner(DB.getConn());
        int flag = runner.update("INSERT INTO person VALUES (NULL,?,?,?,?,?,?,?)",user.getUsername(),user.getPassword(),user.getGender(),user.getTelephone(),user.getJob(),user.getInfo(),user.getJointime());
        if(flag > 0) {
            System.out.println("#插入成功");
        }else {
            System.out.println("#添加失败");
        }
        return flag;
    }
}
