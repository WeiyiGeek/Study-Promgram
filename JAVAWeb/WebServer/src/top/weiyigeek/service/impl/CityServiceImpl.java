package top.weiyigeek.service.impl;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.dao.CityDao;
import top.weiyigeek.dao.impl.CityDaoImpl;
import top.weiyigeek.main.CityBean;
import top.weiyigeek.service.CityService;

public class CityServiceImpl implements CityService {
    @Override
    public List<CityBean> findCity(int pid) throws SQLException {
        CityDao cd = new CityDaoImpl();
        return cd.findCity(pid);
    }
}
