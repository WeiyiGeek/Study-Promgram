package top.weiyigeek.main;

import java.util.Date;

public class registerBean {
    private String username;
    private String password;
    private String gender;
    private String telephone;
    private String job;
    private String info;
    private Date jointime;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
        return "registerBean [username=" + username + ", password=" + password + ", gender=" + gender + ", telephone=" + telephone
                + ", job=" + job + ", info=" + info + ", jointime=" + jointime + "]";
    }
       
}
