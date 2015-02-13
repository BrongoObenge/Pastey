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
		try{
			for(Cookie cookie : cookies){
			System.out.println(cookie.getName());
		    if(cookie.getName().equals("uid"))
		    	return cookie.getName();
			}
		}catch(Exception e){
			return null;
		}
		return null;
	}
	
	public HttpServletResponse setCookiesByUid(String uid, HttpServletResponse response){
		String encryptedUid = crypt.encryptUid(uid);
		response = this.setCookies("uid", encryptedUid, response);
		return response; 
	}
	
	private HttpServletResponse setCookies(String key, String value, HttpServletResponse response){
		Cookie cookie = new Cookie(key, value);
		response.addCookie(cookie);
		return response;
	}

}	
