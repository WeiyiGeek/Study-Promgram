package top.weiyigeek.dao;

import java.sql.SQLException;

import top.weiyigeek.main.LoginBean;
import top.weiyigeek.main.Person;
import top.weiyigeek.main.registerBean;

public interface User {
    Person userlogin(LoginBean user) throws SQLException;
    int userregister(registerBean user) throws SQLException; 
}
