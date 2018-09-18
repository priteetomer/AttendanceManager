$(document).ready(init);

function init(){
	$("#loader").css("display","none");
	$("input[name='btn']").click(checkLogin);
}

function checkLogin(){
	
	var id = $("input[name='txtid']").val();
	var password = $("input[name='txtpassword']").val();
	var usertype = $("input[name='usertype']:checked").val();

	var ur;
	
	if(usertype=="admin")
		ur = "login";
	else
		ur = "facultylogin";
	
	var valid = true;
	
	$(".msg").html("");
	
	if(id.length==0){
		valid = false;
		$("#msgid").html("?");
	}

	if(password.length==0){
		valid = false;
		$("#msgpassword").html("?");
	}
		
	if(valid){
		
		var frm = $("#frm").serialize();
		$("#loader").css("display","block");
		
		$.ajax({
			url: ur,
			type: 'POST',
			data: frm,
			success: function(res){
				$("#loader").css("display","none");
				if(res.indexOf("logged")>-1){
					if(usertype=="admin")
						window.location.replace("adminsection.jsp");
					else
						window.location.replace("facultysection.jsp");
				}
				else
					$("#msgresult").html("Invalid id or password...");
			}
		});
	}
}