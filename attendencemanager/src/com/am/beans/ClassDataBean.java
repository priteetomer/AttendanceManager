package com.am.beans;


import com.am.dao.ClassDataDAO;
import com.am.pojo.ClassData;
import com.am.pojo.ClassTeacher;

public class ClassDataBean {
	
	public boolean checkDuplicateClassData(ClassData classData){
		return new ClassDataDAO().checkDuplicateClassData(classData);
	}

	public String addClassData(ClassData classData) {
		return new ClassDataDAO().addClassData(classData);
	}

	public boolean checkDuplicateFacultyAssign(ClassTeacher data) {
		return new ClassDataDAO().checkDuplicateFacultyAssign(data);
	}

	public String assignFaculty(ClassTeacher data) {
		return new ClassDataDAO().assignFaculty(data);
	}
}
