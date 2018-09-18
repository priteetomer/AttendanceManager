package com.am.beans;


import com.am.dao.StudentDAO;
import com.am.pojo.Student;

public class StudentBean {
	
	private String rollno;
	private String className;
	private String classyear;
	private String semester;

	public boolean checkDuplicateStudent(Student student){
		return new StudentDAO().checkDuplicateStudent(student);
	}

	public String addStudent(Student student) {
		return new StudentDAO().addStudent(student);
	}

	public Student getStudent() {
		return new StudentDAO().getStudent(rollno, className, classyear, semester);
	}
	
	public void setRollnoToDelete(String rollno, String className) {
		new StudentDAO().removeStudent(rollno, className);
	}
	
	public void setStudentByRollno(Student student) {
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getRollNoToDelete(){
		return rollno;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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
}
