package com.am.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.am.pojo.Student;


public class StudentDAO {

	public String addStudent(Student student) {

		String result = "";

		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return "error";
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return "error";
		}

		try {

			String qry = "insert into student(name,gender,rollno,classname,semester,classyear) values(?,?,?,?,?,?)";

			st = con.prepareStatement(qry);
			st.setString(1, student.getName());
			st.setString(2, student.getGender());
			st.setString(3, student.getRollno());
			st.setString(4, student.getClassName());
			st.setString(5, student.getSemester());
			st.setString(6, student.getClassyear());

			if (st.executeUpdate() > 0)
				result = "added";
			else
				result = "failed";

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return "error";
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}

		return result;
	}

	public boolean checkDuplicateStudent(Student student) {

		boolean duplicate = false;

		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null; // to read data from table

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return false;
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return false;
		}

		try {

			String qry = "select rollno from student where rollno=? and classname=?";
			st = con.prepareStatement(qry);

			st.setString(1, student.getRollno());
			st.setString(2, student.getClassName());
			
			rs = st.executeQuery();

			duplicate = rs.next();
			
		} catch (Exception e) {
			System.out.println("Error checking duplicate student : " + e.getMessage());
			return false;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}

		return duplicate;
	}

	public void removeStudent(String rollno, String className) {
		
		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return;
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return;
		}

		try {
			String qry = "delete from student where rollno=? and classname=?";
			st = con.prepareStatement(qry);
			st.setString(1, rollno);
			st.setString(2, className);
			
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error removing student : " + e.getMessage());
			return;
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
	}

	public Student getStudent(String rollno, String className, String classyear, String semester) {
	
		Student student = null;

		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null; // to read data from table

		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return null;
		}
		
		try {

			String qry = "select name,gender from student where rollno=? and className=? and classyear=? and semester=?";
			st = con.prepareStatement(qry);
			st.setString(1, rollno);
			st.setString(2, className);
			st.setString(3, classyear);
			st.setString(4, semester);
			
			rs = st.executeQuery();

			if( rs.next() ){
				student = new Student();
				
				student.setRollno(rollno);
				student.setClassName(className);
				student.setClassyear(classyear);
				student.setSemester(semester);
				student.setName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
			}
			
		} catch (Exception e) {
			System.out.println("Error reading student : " + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
		return student;
	}
}
