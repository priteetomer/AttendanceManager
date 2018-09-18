package com.am.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.am.pojo.Attendance;
import com.am.pojo.CurrentAttendance;
import com.am.pojo.Student;


public class AttendanceDAO {

	public String addAttendance(String[] rollnos, Attendance attendance) {

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

		boolean added = true;

		try {
			
			int i = -1;
			for(String trollno : rollnos){
				String qry = "insert into attendance(rollno,classname,entrydate,faculty,classyear,semester,status) values(?,?,?,?,?,?,?)";
	
				attendance.setRollno(trollno);
				
				String cur_rollno = rollnos[++i];

				int pos = cur_rollno.indexOf(":");
				String rno = cur_rollno.substring(0,pos);
				String status = cur_rollno.substring(pos+1);
				
				st = con.prepareStatement(qry);
				st.setString(1, rno);
				st.setString(2, attendance.getClassname());
				st.setString(3, attendance.getEntryDate());
				st.setString(4, attendance.getFaculty());
				st.setString(5, attendance.getClassyear());
				st.setString(6, attendance.getSemester());
				st.setString(7, status);
				
				added = added && st.executeUpdate()>0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Query error : " + e.getMessage());
			return "error";
		} finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
			}
		}

		if (added)
			result = "added";
		else
			result = "failed";

		return result;
	}

	public ArrayList<Attendance> getAttendance(String rollno, String classname, String classyear, String semester) {

		ArrayList<Attendance> attendances = new ArrayList<Attendance>();
		
		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null;

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

			String qry = null;
			
			qry = "select entryid,entrydate,faculty from attendance where rollno=? and classname=? and classyear=? and semester=?";

			st = con.prepareStatement(qry);
			st.setString(1, rollno);
			st.setString(2, classname);
			st.setString(3, classyear);
			st.setString(4, semester);
			
			rs = st.executeQuery();
			
			if(rs.next()){
			
				do{
					Attendance att = new Attendance();
					
					att.setRollno(rollno);
					att.setClassname(classname);
					att.setClassyear(classyear);
					att.setSemester(semester);
					att.setEntryId(rs.getInt("entryid"));
					att.setEntryDate(rs.getString("entrydate"));
					att.setFaculty(rs.getString("faculty"));
					
					attendances.add(att);
					
				}while(rs.next());
				
			}
			else 
				attendances = null;

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
			}
		}
		
		return attendances;
	}

	public boolean attendanceAlreadyDone(String classname, String classyear, String semester) {
		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null;

		boolean alreadyDone = false;
		
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

			String qry = null;
			
			qry = "select entryid from attendance where day(entrydate)=? and month(entrydate)=? and year(entrydate)=? and classname=? and classyear=? and semester=?";

			Calendar c = Calendar.getInstance();
			int day = c.get(Calendar.DATE);
			int month = c.get(Calendar.MONTH)+1;
			int year = c.get(Calendar.YEAR);
			
			st = con.prepareStatement(qry);
			st.setInt(1, day);
			st.setInt(2, month);
			st.setInt(3, year);
			st.setString(4, classname);
			st.setString(5, classyear);
			st.setString(6, semester);
			
			rs = st.executeQuery();
			
			alreadyDone = rs.next();

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return false;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
			}
		}
		
		return alreadyDone;
	}

	public ArrayList<Student> getAttendanceData(String className,
			String semester, String classyear) {


		ArrayList<Student> students = new ArrayList<Student>();
		
		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null;

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

			String qry = null;
			
			qry = "select rollno,name from student where classname=? and semester=? and classyear=?";

			st = con.prepareStatement(qry);
			st.setString(1, className);
			st.setString(2, semester);
			st.setString(3, classyear);
			
			rs = st.executeQuery();
			
			if(rs.next()){
			
				do{
					Student student = new Student();
					
					student.setRollno(rs.getString("rollno"));
					student.setName(rs.getString("name"));
					
					students.add(student);
					
				}while(rs.next());
				
			}
			else 
				students = null;

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
			}
		}
		
		return students;
	}

	public ArrayList<CurrentAttendance> getDayAttendance(String currentdate,
			String classname, String classyear, String semester) {

		ArrayList<CurrentAttendance> attendances = new ArrayList<CurrentAttendance>();
		
		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null;

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

		int pos1 = currentdate.indexOf("-");
		int pos2 = currentdate.lastIndexOf("-");
		
		int year = Integer.parseInt(currentdate.substring(0,pos1));
		int month = Integer.parseInt(currentdate.substring(pos1+1,pos2));
		int day = Integer.parseInt(currentdate.substring(pos2+1));
		
		try {
			String qry = "select a.rollno,b.name,a.status from attendance a,student b where a.classname=? and a.classyear=? and a.semester=? and day(a.entrydate)=? and month(a.entrydate)=? and year(a.entrydate)=? and a.rollno=b.rollno";

			st = con.prepareStatement(qry);
			st.setString(1, classname);
			st.setString(2, classyear);
			st.setString(3, semester);
			st.setInt(4, day);
			st.setInt(5, month);
			st.setInt(6, year);
			
			rs = st.executeQuery();
			
			if(rs.next()){
			
				do{
					CurrentAttendance att = new CurrentAttendance();
					
					att.setRollno(rs.getString("rollno"));
					att.setName(rs.getString("name"));
					att.setStatus(rs.getString("status"));
					
					attendances.add(att);
					
				}while(rs.next());
				
			}
			else 
				attendances = null;

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return null;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
			}
		}
		
		return attendances;
	}

	public int getMonthAttendance(String rollno, String classname,
			String semester, String classyear, int currentmonth, int currentyear) {

		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null;
		
		int totalformonth = 0;
		
		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return 0;
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return 0;
		}

		try {

			String qry = null;
			
			qry = "select count(*) from attendance where rollno=? and month(entrydate)=? and year(entrydate)=? and classname=? and classyear=? and semester=? and status='present'";

			st = con.prepareStatement(qry);
			st.setString(1, rollno);
			st.setInt(2, currentmonth);
			st.setInt(3, currentyear);
			st.setString(4, classname);
			st.setString(5, classyear);
			st.setString(6, semester);
			
			rs = st.executeQuery();
			
			if(rs.next()){
				try {
					totalformonth = rs.getInt(1);
				} catch (Exception e) {
				}				
			}

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return 0;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
			}
		}
		
		return totalformonth;
	}

	public int getTotalAttendance(String rollno, String classname,
			String semester, String classyear, int currentmonth) {
		
		Connection con = null; // to connect with database
		PreparedStatement st = null; // to execute queries
		ResultSet rs = null;
		
		int total = 0;
		
		// load the driver
		try {
			Class.forName(DB.driver);
			con = DriverManager.getConnection(DB.url, DB.user, DB.password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : " + e.getMessage());
			return 0;
		} catch (SQLException e) {
			System.out.println("DSN error : " + e.getMessage());
			return 0;
		}

		try {

			String qry = null;
			
			qry = "select count(*) from attendance where rollno=? and month(entrydate)=? and classname=? and classyear=? and semester=?";

			st = con.prepareStatement(qry);
			st.setString(1, rollno);
			st.setInt(2, currentmonth);
			st.setString(3, classname);
			st.setString(4, classyear);
			st.setString(5, semester);
			
			rs = st.executeQuery();
			
			if(rs.next()){
				try {
					total = rs.getInt(1);
				} catch (Exception e) {
				}
			}

		} catch (Exception e) {
			System.out.println("Query error : " + e.getMessage());
			return 0;
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
			}
		}

		return total;
	}
}