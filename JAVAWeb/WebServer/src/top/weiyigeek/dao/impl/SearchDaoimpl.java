package top.weiyigeek.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import top.weiyigeek.dao.SearchDao;
import top.weiyigeek.main.SearchBean;
import top.weiyigeek.utils.DB;

public class SearchDaoimpl implements SearchDao {
    @Override
    public List<SearchBean> findWords(String key) throws SQLException {
        QueryRunner runner = new QueryRunner(DB.getConn());
        return runner.query("SELECT * FROM page WHERE title like ? limit ?", new BeanListHandler<SearchBean>(SearchBean.class), key+"%",5);
    }
}
