<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    

<div class="facultyheader">
	<c:if test='${param.msg eq "error"}'>
		Error submitting attendance...
	</c:if>
	<c:if test='${param.msg eq "failed"}'>
		Failed to submit attendance...
	</c:if>
	<c:if test='${param.msg eq "done"}'>
		Attendance submitted...
	</c:if>
</div>