$(document).ready(function(){
	
	$("#home").click(gethome);
	$("#attendance").click(attendance);
	$("#history").click(history);
	
	gethome();
});

function gethome(){
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'facultyhome.jsp',
		success: function(result){
			if(isLoggedIn(result)){
				$("#loader").css("display","none");
				$("#data").html(result);
			}
			else
				window.location.replace("index.jsp");
		}
	});
}

function attendance(){
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'attendance',
		success: function(result){
			if(isLoggedIn(result)){
				$("#loader").css("display","none");
				$("#data").html(result);
			}
			else
				window.location.replace("index.jsp");
		}
	});
}

function history(){
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'history.jsp',
		success: function(result){
			if(isLoggedIn(result)){
				$("#loader").css("display","none");
				$("#data").html(result);
			}
			else
				window.location.replace("index.jsp");
		}
	});
}

function submitattendance(){
	
	$("#loader").css("display","block");

	var frm = $("#frmsubmitattendance").serialize();
	
	$.ajax({
		url: 'addattendance',
		type: 'POST',
		data: frm,
		success: function(result){
			if(isLoggedIn(result)){
				$("#loader").css("display","none");
				$("#data").html(result);
			}
			else
				window.location.replace("index.jsp");
		}
	});
}

function submithistoryform(){
	
	$("#loader").css("display","block");

	var frm = $("#frmhistory").serialize();
	
	$.ajax({
		url: 'gethistory.jsp',
		type: 'POST',
		data: frm,
		success: function(result){
			if(isLoggedIn(result)){
				$("#loader").css("display","none");
				$("#historydata").html(result);
			}
			else
				window.location.replace("index.jsp");
		}
	});
}

function isLoggedIn(status){
	return status.indexOf("notloggedin")==-1;
}