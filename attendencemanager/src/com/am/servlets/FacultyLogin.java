package com.am.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.am.beans.LoginBean;

@WebServlet("/facultylogin")
public class FacultyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("txtid");
		String password = request.getParameter("txtpassword");
		
		LoginBean bean = new LoginBean();
		bean.setId(id);
		bean.setPassword(password);
		
		String result = bean.checkTeacherLogin();
		
		if(result.equals("correct")){
			request.getSession(true).setAttribute("faculty", id);
			response.getWriter().print("logged");
		}
		else if(result.equals("unkown") || result.equals("error"))
			response.getWriter().print("incorrect");
	}
}
