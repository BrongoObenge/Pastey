package controller;

import java.sql.ResultSet;

import manager.MySqlManager;
import user.User;

public class MySqlController {
	MySqlManager mysqlMan = new MySqlManager();
	
	public Boolean checkAuth(String user, String pass){
		String query = "SELECT * FROM binit.user WHERE username =\'"+user+"\';";
		ResultSet result = mysqlMan.executeQuery(query);
		if(result == null)
			return false;
		
		Boolean returnVal = false;
		try{
			if(result.getString("password").equals(pass))
				returnVal = true;
			}catch (Exception e){
				returnVal = false;
			}
		//Set cookies
		return returnVal;
	}
	public User getUserByUid(String uid){
		ResultSet rs = mysqlMan.getUserByUid(uid);
		try{
			int iduser = rs.getInt("iduser"); 
			String username = rs.getString("username");
			int groupid = rs.getInt("groupid");
			
			return new User(Integer.toString(iduser), username, "", groupid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public User getUserByUsername(String username){
		ResultSet rs = mysqlMan.getUserByUsername(username);
		try{
			int iduser = rs.getInt("iduser"); 
			int groupid = rs.getInt("groupid");
			
			return new User(Integer.toString(iduser), username, "", groupid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
