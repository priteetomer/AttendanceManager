package com.am.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.am.beans.AttendanceBean;
import com.am.beans.FacultyBean;

@WebServlet("/attendance")
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("faculty")!=null){
			FacultyBean bean = new FacultyBean();
			bean.setLoginid(request.getSession().getAttribute("faculty").toString());
			String classname = bean.getFacultyClass().getClassname();
			String classyear = bean.getFacultyClass().getClassyear();
			String semester = bean.getFacultyClass().getSemester();
			
			boolean attendancedone = new AttendanceBean().attendanceAlreadyDone(classname, classyear, semester);
			
			if(attendancedone)
				response.sendRedirect("attendancealreadydone.jsp");
			else
				response.sendRedirect("attendance.jsp");
		}
		else
			response.sendRedirect("notloggedin.jsp");
	}
}
