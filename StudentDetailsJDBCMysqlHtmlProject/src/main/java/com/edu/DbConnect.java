package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	
	// connection with database
	
	
			 static String driver="com.mysql.cj.jdbc.Driver";
			 static String url="jdbc:mysql://localhost:3306/serdb";
			 static String un="root";
			 static String pass="root";
			 static Connection con;
			 
			 public static Connection getConnection() {
				
				 try {
					 Class.forName(driver);
					 con=DriverManager.getConnection(url,un,pass);
					 if(con==null) {
						 System.out.println("Connection is null");
					 }
				 }//try
				 catch(Exception e) {
					 e.printStackTrace();
				 }
				 return con;
	}
}
