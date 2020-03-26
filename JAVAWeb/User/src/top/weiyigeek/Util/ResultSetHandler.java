package top.weiyigeek.Util;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {
	/**
	 * @用户进行接口实现类对象(实现获取查询后的数据按照调用者的意愿进行封装)
	 * @param rs
	 * @return
	 */
	T sethandler(ResultSet rs);
}
