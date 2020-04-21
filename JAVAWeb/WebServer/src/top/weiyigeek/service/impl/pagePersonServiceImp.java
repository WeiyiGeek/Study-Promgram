package top.weiyigeek.service.impl;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.dao.pagePersonDao;
import top.weiyigeek.dao.impl.pagePersonDaoImp;
import top.weiyigeek.main.Person;
import top.weiyigeek.main.pagePerson;
import top.weiyigeek.service.pagePersonService;

public class pagePersonServiceImp implements pagePersonService{

	@Override
	public pagePerson pageShow(int page, int count) throws SQLException {
		//ʵ�������󣨸�������ָ���������
		pagePersonDao ppd = new pagePersonDaoImp();
		pagePerson pp = new pagePerson();
		
		//�洢��Daoģ����ʵ�����ݿ��ѯ�������ص���Ϣ
		List<Person> person = ppd.pagePersonData(page,count);
		int resultCount = ppd.dataCount();
		
		//��ֵ�洢����ҳ�Զ�������
		pp.setLp(person);         //��ѯ�����ݣ�List ���ϣ�
		pp.setCurrentPage(page);  //��ѯ�ڼ�ҳ
		pp.setShowCount(count);    //ÿҳ��ʾ������
		pp.setTotal(resultCount); //����������
		pp.setPageTotal(resultCount % count == 0 ? resultCount / count : (resultCount / count) + 1 ); //��ҳ�� (���Ƿ���Գ���������+1)
 		
		return pp;
	}

}
