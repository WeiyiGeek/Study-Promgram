package top.weiyigeek.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import top.weiyigeek.dao.CityDao;
import top.weiyigeek.main.CityBean;
import top.weiyigeek.utils.DB;

public class CityDaoImpl implements CityDao {
    @Override
    public List<CityBean> findCity(int pid) throws SQLException {
        QueryRunner qr = new QueryRunner(DB.getConn());
        return qr.query("SELECT * FROM city WHERE pid = ? ", new BeanListHandler<CityBean>(CityBean.class), pid);
    }
}
