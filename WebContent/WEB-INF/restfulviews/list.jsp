<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#delete").click(function(){
			var href = $("#delete").attr("href");
			$("#deleteForm").attr("action", href).submit();
			return false;
		});
	})
</script>
<body>

	<form action="" method="post" id="deleteForm">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>	

	<c:if test="${empty requestScope.employees}">
		没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employees}">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>员工姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>邮箱</th>
				<th>职位信息</th>
				<th>生日</th>
				<th>float</th>
				<th>操作栏</th>
			</tr>
			<c:forEach items="${requestScope.employees}" var="empl">
				<tr>
					<td>${empl.id}</td>
					<td>${empl.employeeName}</td>
					<td>${empl.age}</td>
					<td>${empl.gender == 0 ? 'male' : 'female'}</td>
					<td>${empl.email}</td>
					<td>${empl.department.departmentName}</td>
					<td>${empl.birth}</td>
					<td>${empl.salary}</td>
					<td>
						<a href="${pageContext.request.contextPath}/employeeHandler/emp/${empl.id}">Edit</a>
						<a href="${pageContext.request.contextPath}/employeeHandler/emp/${empl.id}" id="delete">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>