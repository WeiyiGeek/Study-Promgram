package top.weiyigeek.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {

//	Cookie: JSESSIONID=373D65E0C30C5E3BB327D8ED538FFE5E; auto_login=itheima#itheima#10010
	public static Cookie findCookie(Cookie [] cookies , String name){
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())){
					return cookie;
				}
			}
		}
		return null;
	}
}
