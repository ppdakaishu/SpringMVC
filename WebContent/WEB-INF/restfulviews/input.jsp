<%@page import="org.springframework.web.context.request.RequestAttributes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/employeeHandler/conversionService">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr><td>
				<!-- 输入字符串格式为 ： employeeName,age,gender,email,department.id -->
				<input type="text" name="employeeStr"/>
			</td></tr>
			<tr><td>
				<input type="submit" value="Submit" />
			</td></tr>
		</table>
	</form>

	<!-- 
		1.使用 form 标签可以更快速的开发出表单页面, 而且可以更方便的进行表单值的回显
		2.注意 ： 
			可以通过 modelAttribute 属性指定绑定的模型数据,
			若没有指定该属性, 则默认从 request 域对象中读取 command 的表单bean
			如果该属性值也不存在, 则会发生错误
	 -->
	<f:form action="${pageContext.request.contextPath}/employeeHandler/emp" method="POST" modelAttribute="employee">
		<!-- path 属性对应 html 标签的 name 属性值 -->
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td colspan="3"><f:errors path="*"></f:errors></td>
			</tr>
			<tr>
				<td>employeeName</td>
				<td>
					<c:if test="${employee.id != null}">
						<f:hidden path="id"/>
						<f:input path="employeeName" disabled="true"/>
						<%-- 对于 _method 不能使用  <f:hidden> 标签 --%>
						<%-- 因为 modelAttribute 对应的 Bean 中没有 _mothod 这个属性 --%>
						<input type="hidden" name="_method" value="PUT" />
					</c:if>
					<c:if test="${employee.id == null}">
						<f:input path="employeeName"/>
					</c:if>
				</td>
				<td><f:errors path="employeeName"></f:errors></td>
			</tr>
			<tr>
				<td>age</td>
				<td><f:input path="age"/></td>
				<td><f:errors path="age"></f:errors></td>
			</tr>
			<tr>
				<td>email</td>
				<td><f:input path="email"/></td>
				<td><f:errors path="email"></f:errors></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><f:radiobuttons path="gender" items="${genders}"/></td>
				<td></td>
			</tr>
			<tr>
				<td>birth</td>
				<td><f:input path="birth"/></td>
				<td><f:errors path="birth"></f:errors></td>
			</tr>
			<tr>
				<td>float</td>
				<td><f:input path="salary"/></td>
				<td></td>
			</tr>
			<tr>
				<td>department</td>
				<td>
					<f:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"></f:select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
				<td></td>
			</tr>
		</table>
	</f:form>

</body>
</html>