package top.weiyigeek.main;

import java.util.List;

public class pagePerson {
	private int currentPage; //��ʾ�ڼ�ҳ
	private int showCount; //ÿҳ��ʾ����
	private int pageTotal; //һ����ҳ
	private int total; //��Ϣ������
	private List<Person> lp; //��ѯ���ĵ�����
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Person> getLp() {
		return lp;
	}
	public void setLp(List<Person> lp) {
		this.lp = lp;
	}
}
