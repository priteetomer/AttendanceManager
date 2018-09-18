<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
    
<jsp:useBean id="ob" class="com.am.beans.AttendanceBean"/>    
    
<jsp:setProperty name="ob" property="classname" value="${param.selectclass}"/>    
<jsp:setProperty name="ob" property="classyear" value="${param.selectyear}"/>    
<jsp:setProperty name="ob" property="semester" value="${param.selectsemester}"/>    
<jsp:setProperty name="ob" property="currentdate" value="${param.currentdate}"/>    
    
<link href="css/attendance.css" type="text/css" rel="stylesheet"/>    
    
<div class="attendance">
	
	<c:forEach items="${ob.dayAttendance}" var="att">
		<div class="row">
			<div class="rollno">${att.rollno}</div>
			<div class="name">${att.name}</div>
			<div class="atttype">${att.status}</div>
			<div class="clear"></div>
		</div>	
	</c:forEach>
</div>
