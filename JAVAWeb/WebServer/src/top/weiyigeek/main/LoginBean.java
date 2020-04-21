package top.weiyigeek.main;

public class LoginBean {
    private String username;
    private String password;
    private Object autoLogin;
    
    public LoginBean(String username, String password,Object autoLogin) {
        // TODO Auto-generated constructor stub
        this.username = username;
        this.password = password;
        this.autoLogin = (String)autoLogin;
    }
    public LoginBean() {
        // TODO Auto-generated constructor stub
    }
   
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
    public String getAutoLogin() {
        return (String) autoLogin;
    }
    public void setAutoLogin(String autoLogin) {
        this.autoLogin = autoLogin;
    }
    @Override
    public String toString() {
        return "LoginBean [username=" + username + ", password=" + password + ", autoLogin=" + autoLogin + "]";
    }
  
    
}
