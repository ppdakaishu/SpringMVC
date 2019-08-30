<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function jsonTestO(){
		$.ajax({
			type : "post",
			cache : false,
			url : "employeeHandler/jsonTestO",
			data : {"employeeId" : 1101},
		    dataType : "json",
			success : function(result){
				console.dir(result);
				for(var i = 0; i < result.length; i++){
					alert(result[i].employeeName);
				}
			},
			error : function(){
				alert("test json error");
			}
		});
	}
	
	function jsonTestT(){
		var jsonArray = [{name : "c", password : "cc"},{name : "d", password : "dd"}];
		$.ajax({
			type : "post",
			cache : false,
			url : "employeeHandler/jsonTestT",
			data : JSON.stringify(jsonArray),
			//预期服务器返回类型
		    dataType : "json", 
			//发送至服务器的类型
		    //@RequestBody根据contentType确定需要使用jsonHttpMessageConverter
		    contentType :"application/json", 
			success : function(result){
				alert(result.name);
			},
			error : function(){
				alert("test json error");
			}
		});
	}
</script>
<body>

	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th align="center">Hello...</th>
			<th align="center">Restful...</th>
		</tr>
		<tr>
			<td>
				<table border="1" cellpadding="10" cellspacing="0">
					<tr><td>
						<a href="springmvc/hello?username='cbw'&password='123'">hello springMVC</a>
					</td></tr>
					<tr><td>
						<a href="springmvc/antStyle/springMVC">Ant Style</a>
					</td></tr>
					<tr><td>
						<a href="springmvc/pathVariable/cbw">PathVariable test</a>
					</td></tr>
					<tr><td>
						<a href="springmvc/restGet/cbw">RestGet</a>
						<form action="springmvc/restPost" method="post">
							<input type="submit" value="RestPost"/>
						</form>
						<form action="springmvc/restDelete/cbw" method="post">
							<input type="hidden" name="_method" value="DELETE"/>
							<input type="submit" value="RestDelete"/>
						</form>
						<form action="springmvc/restPut/cbw" method="post">
							<input type="hidden" name="_method" value="PUT"/>
							<input type="submit" value="RestPut"/>
						</form>
					</td></tr>
					<tr><td>
						<a href="springmvc/requestParam?username=chenbowen">requestParam</a>
						<form action="springmvc/requestParam" method="post">
							username ： <input type="text" name="username"/><br/>
							password ： <input type="password" name="password"/><br/>
							<input type="submit" value="requestParam"/>
						</form>
					</td></tr>
					<tr><td>
						<a href="springmvc/requestHeader">requestHeader</a>
					</td></tr>
					<tr><td>
						<a href="springmvc/cookieValue">cookieValue</a>
					</td></tr>
					<tr><td>
						<form action="springmvc/pojo" method="post">
							<input type="hidden" name="userId" value="1"/><br/>
							username ： <input type="text" name="username"/><br/>
							password ： <input type="password" name="password"/><br/>
							email ： <input type="text" name="email"/><br/>
							city ： <input type="text" name="address.city"/><br/>
							province ： <input type="text" name="address.province"/><br/>
							<input type="submit" value="pojo"/>
						</form>
					</td></tr>
					<tr><td>
						<a href="springmvc/servletAPI?id=1025">servletAPI</a>
					</td></tr>
					<tr><td>
						<a href="springmvc/modelAndView">modelAndView</a>	
					</td></tr>
					<tr><td>
						<a href="springmvc/map">map</a>
					</td></tr>
					<tr><td>
						<a href="springmvc/model">model</a>	
					</td></tr>
					<tr><td>
						<a href="springmvc/modelMap">modelMap</a>	
					</td></tr>
					<tr><td>
						<a href="springmvc/sessionAttributes">sessionAttributes</a>	
					</td></tr>
					<tr><td>
						<form action="springmvc/modelAttribute" method="post">
							<input type="hidden" name="userId" value="1"/><br/>
							username ： <input type="text" name="username" value="chenbowen"/><br/>
							email ： <input type="text" name="email" value="70129526@qq.com"/><br/>
							<input type="submit" value="modelAttribute"/>
						</form>
					</td></tr>
					<tr><td>
						<a href="springmvc/beanNameViewResolver">beanNameViewResolver</a>	
					</td></tr>
					<tr><td>
						<a href="springmvc/excelView">excelView</a>	
					</td></tr>
					<tr><td>
						<a href="springmvc/redirect">redirect</a>	
					</td></tr>
					<tr><td>
						<a href="springmvc/forward">forward</a>	
					</td></tr>
				</table>
			</td>
			<td valign="top">
				<table border="1" cellpadding="10" cellspacing="0">
					<tr><td>
						<a href="employeeHandler/emps">list all employees</a>
					</td></tr>
					<tr><td>
						<input type="hidden" name="_method" value="DELETE"/>
						<a href="employeeHandler/emp">save new employee</a>	
					</td></tr>
					<tr><td>
						<a href="javascript:void(0)" onclick="jsonTestO()">jsonTestO</a>
						<br/>
						<a href="#" onclick="jsonTestT()">jsonTestT</a>	
					</td></tr>
					<tr><td>
						<form action="employeeHandler/httpMessageConverter" method="post" enctype="multipart/form-data">
							File : <input type="file" name="file" />
							<br/>
							Desc : <input type="text" name="desc" />
							<br/>
							<input type="submit" value="Submit" />
						</form>
					</td></tr>
					<tr><td>
						<a href="employeeHandler/responseEntity">responseEntity</a>	
					</td></tr>
					<tr><td>
						<a href="employeeHandler/i18n">i18n</a>	
					</td></tr>
					<tr><td>
						<form action="employeeHandler/multipart" method="post" enctype="multipart/form-data">
							File : <input type="file" name="file" />
							<br/>
							Desc : <input type="text" name="desc" />
							<br/>
							<input type="submit" value="Submit" />
						</form>
					</td></tr>
					<tr><td>
						<a href="employeeHandler/exceptionHandler?val=cbw">exceptionHandler</a>	
					</td></tr>
					<tr><td>
						<a href="employeeHandler/responseStatus?val=10">responseStatus</a>	
					</td></tr>
					<tr><td>
						<a href="employeeHandler/simpleMappingException?val=10">simpleMappingException</a>	
					</td></tr>
				</table>
			</td>
		</tr>
	</table>
	
</body>
</html>