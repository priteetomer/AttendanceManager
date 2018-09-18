package com.am.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.am.beans.ClassDataBean;
import com.am.pojo.ClassData;

@WebServlet("/addclass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String semester = request.getParameter("selectsemester");
		String classyear = request.getParameter("selectyear");
		String classname = request.getParameter("selectclass");
		
		ClassData data = new ClassData();
		data.setClassname(classname);
		data.setClassyear(classyear);
		data.setSemester(semester);
		
		ClassDataBean bean = new ClassDataBean();
		
		boolean duplicate = bean.checkDuplicateClassData(data);
		
		if(duplicate){
			response.getWriter().print("Duplicate...");
		}
		else{
			String added = bean.addClassData(data);
			
			if(added.equals("added"))
				response.getWriter().print("Class added...");
			else if(added.equals("failed"))
				response.getWriter().print("Failed...");
			else if(added.equals("error"))
				response.getWriter().print("Error...");
		}					
	}
}
