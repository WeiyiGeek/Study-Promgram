package top.weiyigeek.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import top.weiyigeek.dao.PersonDao;
import top.weiyigeek.main.Person;
import top.weiyigeek.utils.DB;

public class PersonDaoImpl implements PersonDao {

	/*
	 * Desc:返回查询的所有人员信息
	 */
	@Override
	public List<Person> findall() throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		return runner.query("SELECT * FROM person", new BeanListHandler<Person>(Person.class));
	}
	
	/*
	 * @Desc: 执行人员插入擦操作
	 */
	@Override
	public void insert(Person person) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		int flag = runner.update("INSERT INTO person VALUES (NULL,?,?,?,?,?,?)", person.getSname(),person.getGender(),person.getTelephone(),person.getJob(),person.getInfo(),person.getJointime());
		if(flag > 0) {
			System.out.println("#插入成功");
		}else {
			System.out.println("#添加失败");
		}
	}

	/*
	 * @Desc: 执行人员删除操作
	 */
	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		int flag = runner.update("DELETE FROM person WHERE sid = ?", sid );
		if(flag > 0) {
			System.out.println("#删除成功");
		}else {
			System.out.println("#删除失败");
		}
	}

	/**
	 * @throws SQLException 
	 * @Desc ： 以ID为条件进行查找
	 */
	@Override
	public Person getInfoById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		return runner.query("SELECT * FROM person WHERE sid = ?", new BeanHandler<Person>(Person.class) ,sid);
	}

	/**
	 * @throws SQLException 
	 * @Desc:更新人员的修改
	 */
	@Override
	public void updatePerson(Person person) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		int flag = runner.update("UPDATE person SET sname = ?,gender = ?,telephone = ?, job = ? , jointime = ?, info = ? WHERE sid = ?", person.getSname(), person.getGender(),person.getTelephone(),person.getJob(),person.getJointime(),person.getInfo(),person.getSid());		
		if(flag > 0) {
			System.out.println("#更新成功");
		}else {
			System.out.println("#更新失败");
		}
	}

	public List<Person> searchPerson(String sname, String gender) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		//情况1.如果姓名和性别都没选择时候默认显示全部
		String sql = "SELECT * FROM person WHERE 1 = 1";
		List<String> param = new ArrayList<String> (); //采用数组集合

// 		判断传入的参数是否为空;
//		public static boolean isEmpty(CharSequence s){
//			return s==null || s.length() == 0;
//		}
		
		//判断有没有姓名， 如果有，就组拼到sql语句里面
		if(sname.length()>0){
			sql = sql + "  and sname like ?";
			param.add("%"+sname+"%"); //模糊查询精妙之处
		}
		
		//判断有没有性别，有的话，就组拼到sql语句里面。
		if(gender.length()>0){
			sql = sql + " and gender = ?";
			param.add(gender);
		}
		System.out.println("执行的SQL: " + sql);
		runner.getDataSource().getLogWriter();
		return runner.query(sql , new BeanListHandler<Person>(Person.class) ,param.toArray());
	}
}
