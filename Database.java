package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
	private static String HOST = "127.0.0.1";
	private static int PORT = 3306; 
  
	public static Connection connectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/admiin","root","");
			return connect;
			
			
			
		}catch(Exception e) {e.printStackTrace();}
			
		return null;
		
		
	}
	  
}

