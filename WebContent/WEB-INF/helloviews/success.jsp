<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h5>Success page...</h5>
	<br/><br/>
	
	<h5>ModelAndView requestScope : ${requestScope.name }</h5>
	<h5>ModelAndView pageScope : ${pageScope.name }</h5> <!-- 获取不到ModelAndView的模型数据 -->
	<h5>ModelAndView sessionScope : ${sessionScope.name }</h5><!-- 获取不到ModelAndView的模型数据 -->
	<h5>ModelAndView applicationScope : ${applicationScope.name }</h5><!-- 获取不到ModelAndView的模型数据 -->
	<br/><br/>
	
	<h5>map requestScope : ${requestScope.usernameMap }</h5>
	<h5>map pageScope : ${pageScope.usernameMap }</h5> <!-- 获取不到map的模型数据 -->
	<h5>map sessionScope : ${sessionScope.usernameMap }</h5><!-- 获取不到map的模型数据 -->
	<h5>map applicationScope : ${applicationScope.usernameMap }</h5><!-- 获取不到map的模型数据 -->
	<br/><br/>
	
	<h5>model requestScope : ${requestScope.usernameModel }</h5>
	<h5>model requestScope : ${requestScope.usernameModels }</h5>
	<h5>model pageScope : ${pageScope.usernameModel }</h5> <!-- 获取不到model的模型数据 -->
	<h5>model sessionScope : ${sessionScope.usernameModel }</h5><!-- 获取不到model的模型数据 -->
	<h5>model applicationScope : ${applicationScope.usernameModel }</h5><!-- 获取不到model的模型数据 -->
	<br/><br/>
	
	<h5>modelMap requestScope : ${requestScope.usernameModelMap }</h5>
	<h5>modelMap requestScope : ${requestScope.usernameModelMaps }</h5>
	<h5>modelMap pageScope : ${pageScope.usernameModelMap }</h5> <!-- 获取不到modelMap的模型数据 -->
	<h5>modelMap sessionScope : ${sessionScope.usernameModelMap }</h5><!-- 获取不到modelMap的模型数据 -->
	<h5>modelMap applicationScope : ${applicationScope.usernameModelMap }</h5><!-- 获取不到modelMap的模型数据 -->
	<br/><br/>
	
	<h5>sessionAttributes requestScope : ${requestScope.sessionAttributes }</h5>
	<h5>sessionAttributes pageScope : ${pageScope.sessionAttributes }</h5> <!-- 获取不到sessionAttributes的模型数据 -->
	<h5>sessionAttributes sessionScope : ${sessionScope.sessionAttributes }</h5>
	<h5>sessionAttributes applicationScope : ${applicationScope.sessionAttributes }</h5><!-- 获取不到sessionAttributes的模型数据 -->
	<a href="sessionAttributesJump">sessionAttributes</a>
	<br/><br/>
	
	<!-- 未实现 -->
	<!--
	<fmt:message key="message.username"></fmt:message>
	<fmt:message key="message.password"></fmt:message>
	<br/><br/>
	-->
	
</body>
</html>