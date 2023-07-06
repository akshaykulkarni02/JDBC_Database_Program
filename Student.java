package com.akshay.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Student {

	public void createDatabase() {
		try {
		
			//Driver loading
			
		String url = "jdbc:mysql://localhost:3306/";
		String userName = "root";
		String password = "root";
		
		//Establish the Connection
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		String query = "create database StudentDB";
		System.out.println("Database is Created");
		statement.execute(query);
		
		connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public void createTable() {
		try {
			
			//Driver loading
			
		Strimng url = "jdbc:mysql://localhost:3306/StudentDB";
		String userName = "root";
		String password = "root";
		
		//Establish the Connection
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		String query = "create table students (SID int(3), STUDENT_NAME varchar(100), Email varchar(50))";
		System.out.println("Table is Created");
		statement.execute(query);
		
		connection.close();
		} catch (Exception e) {
			System.out.println("Table is not Created");
		}
	}
	
public void createData() {
	try {
		
		//Driver loading
		
	String url = "jdbc:mysql://localhost:3306/StudentDB";
	String userName = "root";
	String password = "root";
	
	//Establish the Connection
	
	Connection connection = DriverManager.getConnection(url, userName, password);
	
	String query = "INSERT INTO STUDENTS VALUES(?,?,?)";
	PreparedStatement statement = connection.prepareStatement(query);
	statement.setInt(1, 1);
	statement.setString(2, "Akshay");
	statement.setString(3, "akshay@gmail.com");
	System.out.println("Data Inserted");
	statement.execute();
	
	connection.close();
	} catch (Exception e) {
		System.out.println("Data is not Inserted");
	}
}

	
}

