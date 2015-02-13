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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeDb(conn);
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
}
