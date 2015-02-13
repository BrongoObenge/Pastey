package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.CookieManager;
import manager.CryptionManager;
import manager.SessionManager;
import user.User;
 
public class SessionController {
	private CookieManager cm = new CookieManager();
	private CryptionManager crypt = new CryptionManager();
	MySqlController mysqlCon = new MySqlController();
	SessionManager sm = new SessionManager();
	
	public Boolean checkLogin(HttpServletRequest request){	//Cookie login
		String uid = cm.checkLogin(request);
		if(uid != null){
			//Cookies already exist
			uid = crypt.decryptUid(uid);
			this.setSessionByUid(uid);
			return true;
		}else{
			//not logged in
			return false;
		}
	}
	public void setSessionByUid(String uid){
		User u = mysqlCon.getUserByUid(uid);
		if(u != null){
			sm.setSession(u.getUid(), u.getUsername(), u.getLastOnline(), u.getGroupId(), 
					true, true);
		}
	}
	public HttpServletResponse authorizeUser(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		if(!mysqlCon.checkAuth(username, request.getParameter("password")))
			return null;
		User u = mysqlCon.getUserByUsername(username);
		//Sets cookies
		response = cm.setCookiesByUid(u.getUid(), response);
		//Set Session
		sm.setSession(u.getUid(), u.getUsername(), u.getLastOnline(), u.getGroupId(), 
				true, true);
		return response;
	}
	
}
