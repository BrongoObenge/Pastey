package manager;


public class SessionManager {
	public static String UID = null;
	public static String USERNAME = null;
	public static String LASTONLINE = null;
	public static int GROUPID = -1;
	
	public static Boolean LOGGEDIN = false;
	public static Boolean COOKIES = false;
	
	public void setSession(String uid, String username, String lastonline, int groupid, Boolean loggedin, Boolean cookies){
		this.UID = uid;
		this.USERNAME = username;
		this.LASTONLINE = lastonline;
		this.GROUPID = groupid;
		
		this.LOGGEDIN = loggedin;
		this.COOKIES = cookies;
	}
	public void deleteSession(){
		this.UID = null;
		this.USERNAME = null;
		this.LASTONLINE = null;
		this.GROUPID = -1;
		
		this.LOGGEDIN = null;
		this.COOKIES = null;
	}
	
}
