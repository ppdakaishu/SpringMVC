<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h5>sessionAttributes page...</h5>
	<br/><br/>

	<h5>sessionAttributes requestScope : ${requestScope.sessionAttributes }</h5>
	<h5>sessionAttributes pageScope : ${pageScope.sessionAttributes }</h5> <!-- 获取不到sessionAttributes的模型数据 -->
	<h5>sessionAttributes sessionScope : ${sessionScope.sessionAttributes }</h5>
	<h5>sessionAttributes applicationScope : ${applicationScope.sessionAttributes }</h5><!-- 获取不到sessionAttributes的模型数据 -->

</body>
</html>