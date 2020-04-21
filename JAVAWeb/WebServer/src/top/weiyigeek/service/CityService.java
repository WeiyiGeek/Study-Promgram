package top.weiyigeek.service;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.main.CityBean;

public interface CityService {
    List<CityBean> findCity(int pid) throws SQLException;
}
