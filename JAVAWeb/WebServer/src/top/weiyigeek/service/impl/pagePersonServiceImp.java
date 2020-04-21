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
		//实例化对象（父类引用指向子类对象）
		pagePersonDao ppd = new pagePersonDaoImp();
		pagePerson pp = new pagePerson();
		
		//存储从Dao模型中实现数据库查询的所返回的信息
		List<Person> person = ppd.pagePersonData(page,count);
		int resultCount = ppd.dataCount();
		
		//将值存储进分页自定义类中
		pp.setLp(person);         //查询到数据（List 集合）
		pp.setCurrentPage(page);  //查询第几页
		pp.setShowCount(count);    //每页显示多少条
		pp.setTotal(resultCount); //数据总条数
		pp.setPageTotal(resultCount % count == 0 ? resultCount / count : (resultCount / count) + 1 ); //总页数 (看是否可以除尽，否则+1)
 		
		return pp;
	}

}
