package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import manager.MySqlManager;
import model.Paste;
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
			result.first();
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
			rs.first();
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
			rs.first();
			int iduser = rs.getInt("iduser"); 
			int groupid = rs.getInt("groupid");
			
			return new User(Integer.toString(iduser), username, "", groupid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public String addPaste(String title, String paste, String password, Timestamp timestamp){
		//Add password and do a check
		String location = "";
		String query = this.addPasteQueryBuilder(title, paste, password, timestamp);
		System.out.println(query);
		mysqlMan.addPaste(query);
		//Select the just added paste (not working atm)
		String selectQuery = this.selectPasteQueryBuilder(title, paste, password, timestamp);
		ResultSet rs = mysqlMan.executeQuery(selectQuery);
		return location;
	}

	public String addPasteQueryBuilder(String title, String paste, String password, Timestamp timestamp){
		String insert = "INSERT INTO "+MySqlManager.PASTE_TABLE+" (";
		String values = "VALUES (";
		if(title.length() >= 1){
			insert += "`"+MySqlManager.PASTE_TABLE_NAME+"`, ";
			values += "\""+title+"\", ";
		}
		if(password.length() >= 1){
			insert += "`"+MySqlManager.PASTE_TABLE_PASSWORD+"`, ";
			values += "\""+password+"\", ";
		}
		if(paste.length() >= 1){
			insert += "`"+MySqlManager.PASTE_TABLE_TEXT+"`, ";
			values += "\""+paste+"\", ";
		}
		
		insert += "`"+MySqlManager.PASTE_TABLE_TIMEADDED+"`) ";
		values += "\""+timestamp.toString()+"\");";
		insert += values;
		return insert;
	}
	public String selectPasteQueryBuilder(String title, String paste, String password, Timestamp timestamp){
		String select = "SELECT * FROM "+MySqlManager.PASTE_TABLE+" WHERE ";
		int i = 0;
		if(title.length() >= 1){
			if(i == 0)
				select += "`"+MySqlManager.PASTE_TABLE_NAME+"` = \""+title+"\" ";	
			else
				select += "AND `"+MySqlManager.PASTE_TABLE_NAME+"` = \""+title+"\" ";
			i++;
		}
		if(password.length() >= 1){
			if (i == 0)
				select += "`"+MySqlManager.PASTE_TABLE_PASSWORD+"` = \""+password+"\" ";
			else
				select += "AND `"+MySqlManager.PASTE_TABLE_PASSWORD+"` = \""+password+"\" ";
			i++;
		}
		if(paste.length() >= 1){
			if(i == 0)
				select += "`"+MySqlManager.PASTE_TABLE_TEXT+"` = \""+paste+"\" ";
			else
				select += "AND `"+MySqlManager.PASTE_TABLE_TEXT+"` = \""+paste+"\" ";
			i++;
		}
		select += "AND `"+MySqlManager.PASTE_TABLE_TIMEADDED+"` = \""+timestamp.toString()+"\";";
		return select;
	}
	private void getPasteId(){
		
	}
	public ArrayList<Paste> getAllPastesLim20(){
		ArrayList<Paste> pastes = new ArrayList<Paste>();
		String query = "SELECT * FROM "+MySqlManager.PASTE_TABLE+" ORDER BY "+MySqlManager.PASTE_TABLE_TIMEADDED+" DESC LIMIT 20;";
		System.out.println(query);
		ResultSet rs = mysqlMan.executeQuery(query);
		try {
			rs.first();
			do{
				Paste p = new Paste();
				p.setId(rs.getInt("idpaste"));
				p.setTitle(rs.getString("name"));
				p.setPassword(rs.getString("password"));
				p.setText(rs.getString("text"));
				p.setTime(rs.getString("timeadded"));
				pastes.add(p);
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pastes;
	}
	public ArrayList<Paste> getAllPastes(){
		ArrayList<Paste> pastes = new ArrayList<Paste>();
		String query = "SELECT * FROM "+MySqlManager.PASTE_TABLE+" ORDER BY "+MySqlManager.PASTE_TABLE_TIMEADDED+" DESC;";
		System.out.println(query);
		ResultSet rs = mysqlMan.executeQuery(query);
		try {
			rs.first();
			do{
				Paste p = new Paste();
				p.setId(rs.getInt("idpaste"));
				p.setTitle(rs.getString("name"));
				p.setPassword(rs.getString("password"));
				p.setText(rs.getString("text"));
				p.setTime(rs.getString("timeadded"));
				pastes.add(p);
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pastes;
	}
	public ArrayList<model.Paste> getPasteById(String id){
		ArrayList<Paste> pastes = new ArrayList<Paste>();
		String query = "SELECT * FROM "+MySqlManager.PASTE_TABLE+" WHERE idpaste = "+Integer.parseInt(id)+" LIMIT 20;";
		System.out.println(query);
		ResultSet rs = mysqlMan.executeQuery(query);
		try {
			rs.first();
			Paste p = new Paste();
			p.setId(rs.getInt("idpaste"));
			p.setTitle(rs.getString("name"));
			p.setPassword(rs.getString("password"));
			p.setText(rs.getString("text"));
			p.setTime(rs.getString("timeadded"));
			pastes.add(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pastes;
	}
	
}
