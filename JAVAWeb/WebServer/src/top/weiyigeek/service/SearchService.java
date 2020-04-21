package top.weiyigeek.service;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.main.SearchBean;

public interface SearchService {
    List<SearchBean> findWords(String keys) throws SQLException;
}
