package com.am.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.am.pojo.ClassData;
import com.am.pojo.ClassTeacher;


public class ClassDataDAO {

	public String addClassData(ClassData classData) {

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

			String qry = "insert into classData(classname,classyear,semester) values(?,?,?)";

			st = con.prepareStatement(qry);
			st.setString(1, classData.getClassname());
			st.setString(2, classData.getClassyear());
			st.setString(3, classData.getSemester());

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

	public boolean checkDuplicateClassData(ClassData classData) {

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

			String qry = "select classname from classData where classname=? and classyear=? and semester=?";
			st = con.prepareStatement(qry);

			st.setString(1, classData.getClassname());
			st.setString(2, classData.getClassyear());
			st.setString(3, classData.getSemester());
			
			rs = st.executeQuery();

			duplicate = rs.next();
			
		} catch (Exception e) {
			System.out.println("Error checking duplicate classData : " + e.getMessage());
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

	public boolean checkDuplicateFacultyAssign(ClassTeacher data) {

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

			String qry = "select faculty from classteacher where classname=? and classyear=? and semester=? and faculty=?";
			st = con.prepareStatement(qry);

			st.setString(1, data.getClassname());
			st.setString(2, data.getClassyear());
			st.setString(3, data.getSemester());
			st.setString(4, data.getFaculty());
			
			rs = st.executeQuery();

			duplicate = rs.next();
			
		} catch (Exception e) {
			System.out.println("Error checking duplicate classData : " + e.getMessage());
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

	public String assignFaculty(ClassTeacher data) {

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

			String qry = "insert into classteacher(faculty,classname,classyear,semester) values(?,?,?,?)";

			st = con.prepareStatement(qry);
			st.setString(1, data.getFaculty());
			st.setString(2, data.getClassname());
			st.setString(3, data.getClassyear());
			st.setString(4, data.getSemester());

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
}
