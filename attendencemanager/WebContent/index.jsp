<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance Manager 1.0</title>

<link type="text/css" rel="stylesheet" href="css/common.css"/>
<link type="text/css" rel="stylesheet" href="css/index.css"/>

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/login.js"></script>

</head>
<body>

	<div class="box">

		<jsp:include page="header.jsp"/>			
		
		<div class="content">
		
			<div class="leftimage">
				<img src="images/92.png"/>
			</div>
			
			<div class="loginbox">
				<form id="frm" onsubmit="return false">
			
				<div class="row">
					<div class="label">Id</div>
					<div class="control">
						<input type="text" class="txt" name="txtid"/>
					</div>
					<div class="msg" id="msgid">&nbsp;</div>
					<div class="clear"></div>
				</div>
			
				<div class="row">
					<div class="label">Password</div>
					<div class="control">
						<input type="password" class="txt" name="txtpassword"/>
					</div>
					<div class="msg" id="msgpassword">&nbsp;</div>
					<div class="clear"></div>
				</div>
			
				<div class="row">
					<div class="label">&nbsp;</div>
					<div class="control">
						<input type="radio" name="usertype" id="rdadmin" checked="checked" value="admin"/><label for="rdadmin">Admin</label>
						&nbsp;&nbsp;
						<input type="radio" name="usertype" id="rdteacher" value="teacher"/><label for="rdteacher">Faculty</label>
					</div>
					<div class="msg" id="msgpassword">&nbsp;</div>
					<div class="clear"></div>
				</div>
			
				<div class="row">
					<div class="label">&nbsp;</div>
					<div class="control">
						<input type="button" name="btn" value="  Login  " class="btn"/>
					</div>
					<div class="clear"></div>
				</div>
			
				<div class="row" id="msgresult">&nbsp;</div>
				
				<div class="row" id="loader"><img src="images/indicator.gif" alt=""/></div>
				
				<div class="row"><a href="monthhistory.jsp">Attendance Status</a></div>
				</form>
				
			</div>
			
			<div class="clear"></div>
		
		</div>
	
	</div>

</body>
</html>