package com.akshay.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

	public void createDatabase() {
		try {

			// Driver loading

			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String password = "root";

			// Establish the Connection

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

			// Driver loading

			String url = "jdbc:mysql://localhost:3306/StudentDB";
			String userName = "root";
			String password = "root";

			// Establish the Connection

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

			// Driver loading

			String url = "jdbc:mysql://localhost:3306/StudentDB";
			String userName = "root";
			String password = "root";

			// Establish the Connection

			Connection connection = DriverManager.getConnection(url, userName, password);

			String query = "INSERT INTO STUDENTS VALUES(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, 2);
			statement.setString(2, "Pranali");
			statement.setString(3, "pranali@gmail.com");
			System.out.println("Data Inserted");
			statement.executeUpdate();

			connection.close();
		} catch (Exception e) {
			System.out.println("Data is not Inserted");
		}
	}

	public void readData() {

		try {

			// Driver loading

			String url = "jdbc:mysql://localhost:3306/StudentDB";
			String userName = "root";
			String password = "root";

			// Establish the Connection

			Connection connection = DriverManager.getConnection(url, userName, password);

			String query = "SELECT * FROM STUDENTS";
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println(" ID: " + resultSet.getInt(1));
				System.out.println(" NAME: " + resultSet.getString(2));
				System.out.println(" EMAIL: " + resultSet.getString(3));
			}

			connection.close();
		} catch (Exception e) {
			System.out.println("Cannot read..!!");
		}

	}

	public void updateData() {
		try {
			String url = "jdbc:mysql://localhost:3306/StudentDB";
			String userName = "root";
			String password = "root";

			// Establish the Connection

			Connection connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE STUDENTS SET STUDENT_Name = ?  WHERE SID = ?";

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, "Pranali");
			statement.setInt(2, 2);

			System.out.println("Data Updated");
			statement.executeUpdate();

			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
