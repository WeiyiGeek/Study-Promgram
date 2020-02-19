package com.weiyi.dao;
public interface userDao {
	/**
	 * Dao模型-接口
	    *     定义操作数据库的方法
	 */
	void findAll();
	void psLogin(String user,String pass,int x);
	void psInsert(String user,String pass);
	void psUpdate(String user,int id);
	void psDelete(String user,String pass);
}
