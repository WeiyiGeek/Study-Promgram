package top.weiyigeek.service;

import java.sql.SQLException;

import top.weiyigeek.main.pagePerson;

/**
 * 分页服务层声明
 * @author WeiyiGeek
 */
public interface pagePersonService {
	pagePerson pageShow(int page,int count) throws SQLException;
}
