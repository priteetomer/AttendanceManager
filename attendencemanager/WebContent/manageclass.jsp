<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

				<form id="frmmanageclass" method="post">
					<div class="row">
						<div class="label">Class</div>
						<div class="control">
							<select name="selectclass">
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
							<select name="selectyear">
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
							<select name="selectsemester">
								<option value="I">I</option>
								<option value="II">II</option>
							</select>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row">
						<div class="label">&nbsp;</div>
						<div class="control">
							<input type="button" value=" Add Class " class="btn btnaddclass" onclick="submitclassform()"/>
						</div>
						<div class="clear"></div>
					</div>

					<div class="row" id="msgmanageclass">&nbsp;</div>
				</form>
