package com.am.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.am.pojo.ClassTeacher;
import com.am.pojo.Faculty;


public class FacultyDAO {

	public String addFaculty(Faculty faculty) {

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
			String qry = "insert into faculty(loginid,password,name) values(?,?,?)";

			st = con.prepareStatement(qry);
			st.setString(1, faculty.getLoginid());
			st.setString(2, faculty.getPassword());
			st.setString(3, faculty.getName());

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

	public String updateFaculty(Faculty faculty) {

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

			String qry = "update faculty set name=?,password=? where loginid=?";

			st = con.prepareStatement(qry);
			st.setString(1, faculty.getName());
			st.setString(2, faculty.getPassword());
			st.setString(3, faculty.getLoginid());

			if (st.executeUpdate() > 0)
				result = "updated";
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

	public boolean checkDuplicateFaculty(Faculty faculty) {

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

			String qry = "select loginid from faculty where loginid=?";
			st = con.prepareStatement(qry);

			st.setString(1, faculty.getLoginid());
			
			rs = st.executeQuery();

			duplicate = rs.next();
			
		} catch (Exception e) {
			System.out.println("Error checking duplicate faculty : " + e.getMessage());
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

	public void removeFaculty(String loginid) {
		
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
			String qry = "delete from faculty where loginid=?";
			st = con.prepareStatement(qry);
			st.setString(1, loginid);
			
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error removing faculty : " + e.getMessage());
			return;
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
	}

	public Faculty getFaculty(String loginid) {
	
		Faculty faculty = null;

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

			String qry = "select name,password from faculty where loginid=?";
			st = con.prepareStatement(qry);
			st.setString(1, loginid);
			
			rs = st.executeQuery();

			if( rs.next() ){
				faculty = new Faculty();
				
				faculty.setEntryid(rs.getInt("entryid"));
				faculty.setLoginid(loginid);
				faculty.setName(rs.getString("name"));
				faculty.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			System.out.println("Error reading faculty : " + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
		return faculty;
	}

	public ClassTeacher getFacultyClass(String loginid) {
		
		ClassTeacher faculty = null;

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

			String qry = "select entryid,classname,classyear,semester from classteacher where faculty=?";
			st = con.prepareStatement(qry);
			st.setString(1, loginid);
			
			rs = st.executeQuery();

			if( rs.next() ){
				faculty = new ClassTeacher();
				
				faculty.setEntryid(rs.getInt("entryid"));
				faculty.setClassname(rs.getString("classname"));
				faculty.setClassyear(rs.getString("classyear"));
				faculty.setSemester(rs.getString("semester"));
				faculty.setFaculty(loginid);
			}
			
		} catch (Exception e) {
			System.out.println("Error reading faculty : " + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
		return faculty;
	}

	public ArrayList<Faculty> getFaculties() {
		
		ArrayList<Faculty> faculties = new ArrayList<Faculty>();
		
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

			String qry = "select loginid,name from faculty order by loginid";
			st = con.prepareStatement(qry);
			
			rs = st.executeQuery();

			while( rs.next() ){
				Faculty faculty = new Faculty();
				
				faculty.setLoginid(rs.getString("loginid"));
				faculty.setName(rs.getString("name"));
				
				faculties.add(faculty);
			}
			
		} catch (Exception e) {
			System.out.println("Error reading faculty : " + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}
		
		
		return faculties;
	}
}
