<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addUser" method="POST" commandName="user">
		<label for="error">错误信息：</label>
		<form:errors path="*" id="error"/><br>
		<label for="username">姓名：</label>
		<form:input path="username" id="username"/><br>
		<label for="password">密码：</label>
		<form:input path="password" id="password"/><br>
		<label for="age">年龄：</label>
		<form:input path="age" id="age"/><br>
		<label for="birth">生日：</label>
		<form:input path="birth" id="birth"/><br>
		<input type="submit" value="提交">
	</form:form>
</body>
</html>