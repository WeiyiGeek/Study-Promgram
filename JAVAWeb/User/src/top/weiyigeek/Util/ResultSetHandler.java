package top.weiyigeek.Util;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {
	/**
	 * @�û����нӿ�ʵ�������(ʵ�ֻ�ȡ��ѯ������ݰ��յ����ߵ���Ը���з�װ)
	 * @param rs
	 * @return
	 */
	T sethandler(ResultSet rs);
}
