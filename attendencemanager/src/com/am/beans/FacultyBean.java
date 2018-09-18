package com.am.beans;


import java.util.ArrayList;

import com.am.dao.FacultyDAO;
import com.am.pojo.ClassTeacher;
import com.am.pojo.Faculty;

public class FacultyBean {
	
	private String loginid;

	public boolean checkDuplicateFaculty(Faculty faculty){
		return new FacultyDAO().checkDuplicateFaculty(faculty);
	}

	public String addFaculty(Faculty faculty) {
		return new FacultyDAO().addFaculty(faculty);
	}

	public String updateFaculty(Faculty faculty) {
		return new FacultyDAO().updateFaculty(faculty);
	}

	public Faculty getFaculty() {
		return new FacultyDAO().getFaculty(loginid);
	}

	public ClassTeacher getFacultyClass() {
		return new FacultyDAO().getFacultyClass(loginid);
	}

	public ArrayList<Faculty> getFaculties(){
		return new FacultyDAO().getFaculties();
	}
	
/*------------------ getter / setter --------------------*/	
	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
/*------------------ getter / setter --------------------*/	
}
