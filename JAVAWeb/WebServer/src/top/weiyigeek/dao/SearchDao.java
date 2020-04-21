package top.weiyigeek.dao;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.main.SearchBean;

public interface SearchDao {
    List<SearchBean> findWords(String key) throws SQLException;
}
