package top.weiyigeek.main;

import java.util.Date;

public class Person {
	private int sid;
	private String sname;
	private String gender;
	private String telephone;
	private String job;
	private String info;
	private Date jointime;
	
	//构造方法
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	//插入指定的sid
	public Person(int sid, String sname, String gender, String telephone, String job, String info, Date jointime) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.telephone = telephone;
		this.job = job;
		this.info = info;
		this.jointime = jointime;
	}
	
	public Person(String sname, String gender, String telephone, String job, String info, Date jointime) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.telephone = telephone;
		this.job = job;
		this.info = info;
		this.jointime = jointime;
	}
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getJointime() {
		return jointime;
	}
	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}
	
	@Override
	public String toString() {
		return "Works [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", telephone=" + telephone + ", job="
				+ job + ", info=" + info + ", jointime=" + jointime + "]";
	}
	
}
