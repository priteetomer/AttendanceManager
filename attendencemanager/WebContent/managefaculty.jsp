<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

				<form id="frmmanagefaculty" method="post">

					<div class="row">
						<div class="label">Name</div>
						<div class="control">
							<input type="text" id="txtfacultyname" name="txtfacultyname" class="txt"/>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">Login Id</div>
						<div class="control">
							<input type="text" id="txtfacultyloginid" name="txtfacultyloginid" class="txt"/>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">Password</div>
						<div class="control">
							<input type="password" id="txtfacultypassword" name="txtfacultypassword" class="txt"/>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">Re-enter Password</div>
						<div class="control">
							<input type="password" id="txtfacultyrepassword" class="txt"/>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">&nbsp;</div>
						<div class="control">
							<input type="button" value=" Add Faculty " class="btn btnaddclass" onclick="submitfacultyform()"/>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row" id="msgmanagefaculty">&nbsp;</div>
				</form>
