package com.weiyi.Jdbc;
import com.weiyi.dao.userDao;
import com.weiyi.dao.impl.userDaoImpl;
/**
 * 调用 dao 模型 实现的接口方法
 * @author WeiyiGeek
 *
 */
public class Demo4 {
	//注意:这里测试也可以采用Junit单元测试
	public static void main(String[] args) {
		//Step1.父类指向子类实现的接口
		userDao dao = new userDaoImpl();
		//Step2.直接调用其方法不用管具体的实现
		dao.findAll();
	}
}
