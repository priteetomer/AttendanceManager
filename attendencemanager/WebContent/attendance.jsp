<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
    
<jsp:useBean id="ob" class="com.am.beans.AttendanceBean"/>    
<jsp:useBean id="fb" class="com.am.beans.FacultyBean"/>    
    
<jsp:setProperty name="fb" property="loginid" value="${sessionScope.faculty}"/>    
<c:set var="classTeacher" value="${fb.facultyClass}"/>    

<jsp:setProperty name="ob" property="classname" value="${classTeacher.classname}"/>    
<jsp:setProperty name="ob" property="classyear" value="${classTeacher.classyear}"/>    
<jsp:setProperty name="ob" property="semester" value="${classTeacher.semester}"/>    
    
<link href="css/attendance.css" type="text/css" rel="stylesheet"/>    
    
<div class="attendance">
	
	<form id="frmsubmitattendance">
	<c:set var="i" value="-1"/>
	<c:forEach items="${ob.attendanceData}" var="att">
		<c:set var="i" value="${i+1}"/>
		<div class="row">
			<div class="rollno">${att.rollno}</div>
			<div class="name">${att.name}</div>
			<div class="atttype">
				<input type="radio" id="rdpresent${i}" name="attendance${i}" value="${att.rollno}:Present"><label for="rdpresent${i}">Present</label>
				&nbsp;&nbsp;
				<input type="radio" id="rdabsent${i}" name="attendance${i}" value="${att.rollno}:Absent"><label for="rdabsent${i}">Absent</label>
			</div>
			<div class="clear"></div>
		</div>	
	</c:forEach>
	
	<div class="row">
		<input type="hidden" name="lastindex" value="${i}"/>
		<input type="button" id="btnattendance" value="Submit" onclick="submitattendance()"/>
	</div>
	</form>
	
</div>
