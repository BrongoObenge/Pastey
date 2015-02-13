package manager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	CryptionManager crypt = new CryptionManager();
	
	//Dont use
	public String checkLogin(HttpServletRequest request){	//Checks if uid cookie exists
		String uid = this.checkUidCookie(request);
		if(uid == null){
			return null;
		}else{
			System.out.print(uid);
			return uid;
		}
	}
	public String checkUidCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			System.out.println(cookie.getName());
		    if(cookie.getName() == "uid")
		    	return cookie.getName();
		}
		return null;
	}
	
	public HttpServletResponse setCookiesByUid(String uid, HttpServletResponse response){
		return this.setCookies("uid", crypt.encryptUid(uid), response);
	}
	
	private HttpServletResponse setCookies(String key, String value, HttpServletResponse response){
		Cookie cookie = new Cookie(key, value);
		response.addCookie(cookie);
		return response;
	}

}	
