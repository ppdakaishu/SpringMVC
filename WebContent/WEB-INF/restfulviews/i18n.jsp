<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fmt:message key="i18n.user"></fmt:message>
	<br>
	<fmt:message key="i18n.password"></fmt:message>
	<p>
	<a href="i18n?locale=zh_CN">中文</a>
	<br>
	<a href="i18n?locale=en_US">英文</a>
</body>
</html>