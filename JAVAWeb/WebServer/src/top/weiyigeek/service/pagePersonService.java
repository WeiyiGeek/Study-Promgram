package top.weiyigeek.service;

import java.sql.SQLException;

import top.weiyigeek.main.pagePerson;

/**
 * ��ҳ���������
 * @author WeiyiGeek
 */
public interface pagePersonService {
	pagePerson pageShow(int page,int count) throws SQLException;
}
