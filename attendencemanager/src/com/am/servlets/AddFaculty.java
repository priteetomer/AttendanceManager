package com.am.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.am.beans.FacultyBean;
import com.am.pojo.Faculty;

@WebServlet("/addfaculty")
public class AddFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginid = request.getParameter("txtfacultyloginid");
		String password = request.getParameter("txtfacultypassword");
		String name = request.getParameter("txtfacultyname");
		
		Faculty faculty = new Faculty();
		faculty.setLoginid(loginid);
		faculty.setName(name);
		faculty.setPassword(password);
		
		FacultyBean bean = new FacultyBean();
		
		boolean duplicate = bean.checkDuplicateFaculty(faculty);
		
		if(duplicate){
			response.getWriter().print("Duplicate...");
		}
		else{
			String added = bean.addFaculty(faculty);
			
			if(added.equals("added"))
				response.getWriter().print("Faculty added...");
			else if(added.equals("failed"))
				response.getWriter().print("Faculty cannot be added...");
			else if(added.equals("error"))
				response.getWriter().print("Error in adding faculty...");
		}					
	}
}
