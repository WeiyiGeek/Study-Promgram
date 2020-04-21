package top.weiyigeek.service.impl;

import java.sql.SQLException;

import top.weiyigeek.dao.UserDao;
import top.weiyigeek.dao.impl.UserDaoimpl;
import top.weiyigeek.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public int checkUser(String name) throws SQLException {
        UserDao ud = new UserDaoimpl();
        return ud.checkUser(name);
    }
}
