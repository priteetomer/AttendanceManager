<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
    
<c:if test="${sessionScope.admin ne null}">    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance Manager 1.0</title>

<link type="text/css" rel="stylesheet" href="css/common.css"/>
<link type="text/css" rel="stylesheet" href="css/admin.css"/>

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/admin.js"></script>

</head>
<body>

	<div class="box">

		<jsp:include page="adminheader.jsp"/>
		
		<div class="content">
		
			<div class="adminmenu">
				<jsp:include page="adminmenu.jsp"/>
			</div>
			
			<div class="content">

				<div class="loader"><img src="images/indicator.gif" id="loader" alt=""/>&nbsp;</div>
				
				<div id="data">&nbsp;</div>

			</div>			
		
			<div class="clear"></div>
		</div>
	
	</div>

</body>
</html>

</c:if>
<c:if test="${sessionScope.admin eq null}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>