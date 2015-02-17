package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlManager {
	//Create config
	private String URL = "jdbc:mysql://localhost:3306/binit";
	private String USER = "user1";
	private String PASSWORD = "user1";
	
	public static String SCHEMA = "binit";
	
	public static String PASTE_TABLE = SCHEMA + ".paste";
	public static String PASTE_TABLE_PASTEID = "idpaste";
	public static String PASTE_TABLE_USERID = "iduser";
	public static String PASTE_TABLE_NAME = "name";
	public static String PASTE_TABLE_PASSWORD = "password";
	public static String PASTE_TABLE_TEXT = "text";
	public static String PASTE_TABLE_TIMEADDED = "timeadded";
	
	public static String IMAGE_TABLE = SCHEMA + ".image";
	public static String IMAGE_TABLE_IMAGEID = "idimage";
	public static String IMAGE_TABLE_NAME = "name";
	public static String IMAGE_TABLE_PASSWORD = "password";
	public static String IMAGE_TABLE_LOCATION = "location";
	public static String IMAGE_TABLE_TIMEADDED = "timeadded";
	
	public Connection openDb(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void closeDb(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet executeQuery(String query){
		Connection conn = this.openDb();
		ResultSet result = null;
		try {
			Statement statement = conn.createStatement();
			statement.execute(query);
			result = statement.getResultSet();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{ 
		}
		return result;
	}
	public ResultSet getUserByUid(String uid){
		 String query = "SELECT * FROM binit.user WHERE iduser =\'"+uid+"\';";
		 return this.executeQuery(query);
	}
	public ResultSet getUserByUsername(String username){
		 String query = "SELECT * FROM binit.user WHERE username =\'"+username+"\';";
		 return this.executeQuery(query);
	}
	public ResultSet addPaste(String query){
		 return this.executeQuery(query);
	}

}
