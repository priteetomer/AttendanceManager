package com.am.beans;

import java.util.ArrayList;

import com.am.dao.AttendanceDAO;
import com.am.pojo.Attendance;
import com.am.pojo.CurrentAttendance;
import com.am.pojo.Student;

public class AttendanceBean {
	
	private String rollno;
	private String classname;
	private String classyear;
	private String semester;
	private String currentdate;

/*----------------- getters / setters ----------------------*/	
	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String className) {
		this.classname = className;
	}

	public String getClassyear() {
		return classyear;
	}

	public void setClassyear(String classyear) {
		this.classyear = classyear;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
/*----------------- getters / setters ----------------------*/	

	public ArrayList<Student> getAttendanceData() {
		return new AttendanceDAO().getAttendanceData(classname, semester, classyear);
	}

	public ArrayList<Attendance> getStudentAttendance() {
		return new AttendanceDAO().getAttendance(rollno,classname,classyear,semester);
	}

	public ArrayList<CurrentAttendance> getDayAttendance() {
		return new AttendanceDAO().getDayAttendance(currentdate,classname,classyear,semester);
	}

	public String addAttendance(String[] rollnos, Attendance attendance) {
		return new AttendanceDAO().addAttendance(rollnos, attendance);
	}

	public boolean attendanceAlreadyDone(String classname, String classyear, String semester) {
		return new AttendanceDAO().attendanceAlreadyDone(classname, classyear, semester);
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}
}
