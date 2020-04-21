package top.weiyigeek.main;

import java.util.List;

public class pagePerson {
	private int currentPage; //显示第几页
	private int showCount; //每页显示几条
	private int pageTotal; //一共几页
	private int total; //信息总条数
	private List<Person> lp; //查询到的的数据
	
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
