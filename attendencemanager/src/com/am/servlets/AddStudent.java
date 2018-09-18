package com.am.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.am.beans.StudentBean;
import com.am.pojo.Student;

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rollno = request.getParameter("txtrollno");
		String name = request.getParameter("txtstudentname");
		String classyear = request.getParameter("selectyear");
		String className = request.getParameter("selectclass");
		String gender = request.getParameter("gender");
		String semester = request.getParameter("selectsemester");
		
		Student student = new Student();
		student.setRollno(rollno);
		student.setName(name);
		student.setClassName(className);
		student.setSemester(semester);
		student.setGender(gender);
		student.setClassyear(classyear);
		
		StudentBean bean = new StudentBean();
		
		boolean duplicate = bean.checkDuplicateStudent(student);
		
		if(duplicate){
			response.getWriter().print("Duplicate...");
		}
		else{
			String added = bean.addStudent(student);
			
			if(added.equals("added"))
				response.getWriter().print("Student added...");
			else if(added.equals("failed"))
				response.getWriter().print("Failed...");
			else if(added.equals("error"))
				response.getWriter().print("Error...");
		}					
	}
}
