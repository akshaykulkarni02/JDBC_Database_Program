package com.akshay.databse;

public class Entity {
	public static void main(String[] args) {
		Student student = new Student();

		student.createDatabase();
		student.createTable();
		student.createData();
		student.updateData();
		student.readData();

	}
}
