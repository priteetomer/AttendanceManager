package com.am.beans;

import com.am.dao.AttendanceDAO;

public class StudentAttendanceBean {
	
	private String rollno;
	private String classname;
	private String classyear;
	private String semester;
	private int currentmonth;
	private int currentyear;

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

	public int getMonthAttendance() {
		return new AttendanceDAO().getMonthAttendance(rollno, classname, semester, classyear, currentmonth, currentyear);
	}

	public int getTotalAttendance() {
		return new AttendanceDAO().getTotalAttendance(rollno, classname, semester, classyear, currentmonth);
	}

	public int getCurrentmonth() {
		return currentmonth;
	}

	public void setCurrentmonth(int currentmonth) {
		this.currentmonth = currentmonth;
	}

	public int getCurrentyear() {
		return currentyear;
	}

	public void setCurrentyear(int currentyear) {
		this.currentyear = currentyear;
	}
}
