package top.weiyigeek.dao;

import java.sql.SQLException;

public interface UserDao {
    int checkUser(String name) throws SQLException; 
}
