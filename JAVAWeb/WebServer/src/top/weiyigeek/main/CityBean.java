package top.weiyigeek.main;
/***
 * @Desc: 城市信息基础类
 * @author WeiyiGeek
 *
 */
public class CityBean {
    private int cid;
    private int pid;
    private String cname;
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    @Override
    public String toString() {
        return "CityBean [cid=" + cid + ", pid=" + pid + ", cname=" + cname + "]";
    }
 
}
