<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h4>Error page</h4>
	${ex}


	<f:form action="${pageContext.request.contextPath}/employeeHandler/emp" method="POST" modelAttribute="employee">
		<f:errors path="*"></f:errors>
	</f:form>

</body>
</html>