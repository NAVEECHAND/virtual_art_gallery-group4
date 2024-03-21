package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {

	 private static Connection conn;
	 //load the driver
	 public static Connection getdbConnect() {
		    String usernameDb="root";
			String passwordDb="";
			String urlDb="jdbc:mysql://localhost:3306/art_galary";
			String driverName="com.mysql.jdbc.Driver";
	 try {
	 Class.forName(driverName);
	 System.out.println("Driver loaded successfully");
	 } catch (ClassNotFoundException e) {
	 System.out.println("Driver not loaded successfully");
	 e.printStackTrace();
	 }
	 //establish connection
	 try {
	 conn=DriverManager.getConnection(urlDb, usernameDb, passwordDb);
	 System.out.println("connection established successfully");
	 } catch (SQLException e) {
	 System.out.println("connection  not established successfully");
	 e.printStackTrace();
	 }
	 return conn;
	 }
	 public static void dbClose()
	 {
	 try {
	 conn.close();
	 System.out.println("connection closed");
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 }

}


