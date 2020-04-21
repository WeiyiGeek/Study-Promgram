package top.weiyigeek.service.impl;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.dao.SearchDao;
import top.weiyigeek.dao.impl.SearchDaoimpl;
import top.weiyigeek.main.SearchBean;
import top.weiyigeek.service.SearchService;

public class SearchServiceImpl implements SearchService {
    @Override
    public List<SearchBean> findWords(String keys) throws SQLException {
        SearchDao sd = new SearchDaoimpl();
        return sd.findWords(keys);
    }
}
