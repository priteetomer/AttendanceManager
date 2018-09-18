<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:useBean id="ob" class="com.am.beans.StudentAttendanceBean"/>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance Manager 1.0</title>

<link type="text/css" rel="stylesheet" href="css/common.css"/>
<link type="text/css" rel="stylesheet" href="css/faculty.css"/>

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/faculty.js"></script>

</head>
<body>

	<div class="box">

		<jsp:include page="facultyheader.jsp"/>
		
		<div class="content">
		
			<div class="adminmenu">
				<jsp:include page="facultymenu.jsp"/>
			</div>
			
			<div class="content">
				<div class="history">
					
					<form id="frmhistory" method="post">
					
						<div class="row">
							<div class="label">For</div>
							<div class="control">
								<select name="currentmonth">
									<option value="1">January</option>
									<option value="2">February</option>
									<option value="3">March</option>
									<option value="4">April</option>
									<option value="5">May</option>
									<option value="6">June</option>
									<option value="7">July</option>
									<option value="8">August</option>
									<option value="9">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">Decemter</option>
								</select>
								&nbsp;&nbsp;
								<select name="currentyear">
									<option value="2000">2000</option>
									<option value="2001">2001</option>
									<option value="2002">2002</option>
									<option value="2003">2003</option>
									<option value="2004">2004</option>
									<option value="2005">2005</option>
									<option value="2006">2006</option>
									<option value="2007">2007</option>
									<option value="2008">2008</option>
									<option value="2009">2009</option>
									<option value="2010">2010</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
								</select>
							</div>
							<div class="clear"></div>
						</div>

						<div class="row">
							<div class="label">Rollno</div>
							<div class="control">
								<input type="text" name="rollno" class="txt"/>
							</div>
							<div class="clear"></div>
						</div>

						<div class="row">
							<div class="label">Class</div>
							<div class="control">
								<select name="classname">
									<option value="B.Tech. Civil">B.Tech. Civil</option>
									<option value="B.Tech. CS">B.Tech. CS</option>
									<option value="B.Tech. EC">B.Tech. EC</option>
									<option value="B.Tech. IT">B.Tech. IT</option>
									<option value="B.Tech. Mech.">B.Tech. Mech.</option>
								</select>
							</div>
							<div class="clear"></div>
						</div>
				
						<div class="row">
							<div class="label">Year</div>
							<div class="control">
								<select name="classyear">
									<option value="I">I</option>
									<option value="II">II</option>
									<option value="III">III</option>
									<option value="IV">IV</option>
								</select>
							</div>
							<div class="clear"></div>
						</div>
				
						<div class="row">
							<div class="label">Semester</div>
							<div class="control">
								<select name="semester">
									<option value="I">I</option>
									<option value="II">II</option>
								</select>
							</div>
							<div class="clear"></div>
						</div>
				
						<div class="row">
							<div class="label">&nbsp;</div>
							<div class="control">
								<input type="submit" value=" Get History " class="btn btnaddclass""/>
							</div>
							<div class="clear"></div>
						</div>
					</form>
					
					<hr/>
					
					<div class="row" id="historydata">
						<c:if test="${param.currentmonth ne null}">
							<jsp:setProperty name="ob" property="currentmonth" value="${param.currentmonth}"/>
							<jsp:setProperty name="ob" property="currentyear" value="${param.currentyear}"/>
							<jsp:setProperty name="ob" property="classname" value="${param.classname}"/>
							<jsp:setProperty name="ob" property="classyear" value="${param.classyear}"/>
							<jsp:setProperty name="ob" property="semester" value="${param.semester}"/>
							<jsp:setProperty name="ob" property="rollno" value="${param.rollno}"/>
							
							Attendance for the month : ${ob.monthAttendance}
							<br/><br/>
							Attendance total : ${ob.totalAttendance}
						</c:if>
					</div>
					
				</div>

			</div>			
		
			<div class="clear"></div>
		</div>
	
	</div>

</body>
</html>
				