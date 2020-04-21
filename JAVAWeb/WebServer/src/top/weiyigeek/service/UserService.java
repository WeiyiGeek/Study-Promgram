package top.weiyigeek.service;

import java.sql.SQLException;

public interface UserService {
    int checkUser(String name) throws SQLException;
}
