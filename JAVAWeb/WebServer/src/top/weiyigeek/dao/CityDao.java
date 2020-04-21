package top.weiyigeek.dao;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.main.CityBean;

public interface CityDao {
    List<CityBean> findCity(int pid) throws SQLException;
}
