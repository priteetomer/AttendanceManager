$(document).ready(function(){
	
	$("#home").click(gethome);
	$("#manageclass").click(manageclass);
	$("#managefaculty").click(managefaculty);
	$("#managestudent").click(managestudent);
	$("#assignclass").click(assignfaculty);
	
	gethome();
});

function gethome(){
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'adminhome.jsp',
		success: function(result){
			$("#loader").css("display","none");
			$("#data").html(result);
		}
	});
}

function manageclass(){
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'manageclass.jsp',
		success: function(result){
			$("#loader").css("display","none");
			$("#data").html(result);
		}
	});
}

function assignfaculty(){
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'assignfaculty.jsp',
		success: function(result){
			$("#loader").css("display","none");
			$("#data").html(result);
		}
	});
}

function managefaculty(){
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'managefaculty.jsp',
		success: function(result){
			$("#loader").css("display","none");
			$("#data").html(result);
		}
	});
}

function managestudent(){
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'managestudent.jsp',
		success: function(result){
			$("#loader").css("display","none");
			$("#data").html(result);
		}
	});
}

function submitclassform(){
	
	$("#loader").css("display","block");

	var frm = $("#frmmanageclass").serialize();
	
	$.ajax({
		url: 'addclass',
		type: 'POST',
		data: frm,
		success: function(result){
			$("#loader").css("display","none");
			$("#msgmanageclass").html(result);
		}
	});
}

function submitassignfaculty(){
	
	$("#loader").css("display","block");

	var frm = $("#frmassignfaculty").serialize();
	
	$.ajax({
		url: 'assignfaculty',
		type: 'POST',
		data: frm,
		success: function(result){
			$("#loader").css("display","none");
			$("#msgassignfaculty").html(result);
		}
	});
}

function submitfacultyform(){

	var facultyname = $("#txtfacultyname").val();
	var facultyid = $("#txtfacultyloginid").val();
	var password = $("#txtfacultypassword").val();
	var cpassword = $("#txtfacultyrepassword").val();
	
	if(facultyname.length==0){
		alert("Provide faculty name...");
		return;
	}
	
	if(facultyid.length==0){
		alert("Provide faculty id...");
		return;
	}
	
	if(password.length==0){
		alert("Provide password...");
		return;
	}
	
	if(password!=cpassword){
		alert("Password mismatch!");
		return;
	}
	
	var frm = $("#frmmanagefaculty").serialize();
	
	$("#loader").css("display","block");

	$.ajax({
		url: 'addfaculty',
		type: 'POST',
		data: frm,
		success: function(result){
			$("#loader").css("display","none");
			$("#msgmanagefaculty").html(result);
			$("#txtfacultyname").val("");
			$("#txtfacultyloginid").val("");
			$("#txtfacultypassword").val("");
			$("#txtfacultyrepassword").val("");
		}
	});
}


function submitstudentform(){

	var rollno = $("#txtrollno").val();
	var stname = $("#txtstudentname").val();
	
	if(rollno.length==0){
		alert("Provide student roll number...");
		return;
	}
	
	if(stname.length==0){
		alert("Provide student name...");
		return;
	}

	var frm = $("#frmmanagestudent").serialize();
	
	$("#loader").css("display","block");
	
	$.ajax({
		url: 'addstudent',
		type: 'POST',
		data: frm,
		success: function(result){
			$("#loader").css("display","none");
			$("#msgmanagestudent").html(result);
			$("#txtrollno").val("");
			$("#txtstudentname").val("");
		}
	});
}