package top.weiyigeek.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import top.weiyigeek.dao.UserDao;
import top.weiyigeek.utils.DB;

public class UserDaoimpl implements UserDao {
    @Override
    public int checkUser(String name) throws SQLException {
        //1.建立数据连接、
        QueryRunner runner = new QueryRunner(DB.getConn());
        Long result = (Long) runner.query("SELECT COUNT(*) FROM person WHERE sname = ?",new ScalarHandler(), name);
        System.out.println("查询完成");
        return result.intValue();
    }
}
