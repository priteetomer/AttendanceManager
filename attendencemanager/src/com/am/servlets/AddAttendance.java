package com.am.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.am.beans.AttendanceBean;
import com.am.beans.FacultyBean;
import com.am.pojo.Attendance;

@WebServlet("/addattendance")
public class AddAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int lastindex = Integer.parseInt(request.getParameter("lastindex"));
		
		String[] rollnos = new String[lastindex+1];
		
		for(int i=0;i<=lastindex;i++){
			rollnos[i] = request.getParameter("attendance" + i);
		}

		FacultyBean fbean = new FacultyBean();
		fbean.setLoginid(request.getSession().getAttribute("faculty").toString());
		String classname = fbean.getFacultyClass().getClassname();
		String classyear = fbean.getFacultyClass().getClassyear();
		String semester = fbean.getFacultyClass().getSemester();

		String faculty = request.getSession().getAttribute("faculty").toString();
		
		Attendance attendance = new Attendance();
		
		String currentDate = new SimpleDateFormat("yyyy-M-dd").format(new Date());
		
		attendance.setEntryDate(currentDate);
		attendance.setClassname(classname);
		attendance.setFaculty(faculty);
		attendance.setSemester(semester);
		attendance.setClassyear(classyear);
		
		AttendanceBean bean = new AttendanceBean();
		String added = bean.addAttendance(rollnos, attendance);
		
		if(added.equals("added"))
			response.sendRedirect("attendancedone.jsp?msg=done");
		else if(added.equals("failed"))
			response.sendRedirect("attendancedone.jsp?msg=failed");
		else if(added.equals("error"))
			response.sendRedirect("attendancedone.jsp?msg=error");
	}
}
