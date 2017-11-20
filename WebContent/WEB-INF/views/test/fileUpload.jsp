<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>test page</title>
</head>
<body>
	message:${message }
	<br> -----test----
	<br>
	<c:url var="homePage" value="/" />
	<a href="${homePage }">返回主页</a>
	<hr>
	<br> test upload file:
	<br>

	<c:url var="upload" value="/testUpload" />
	<form action="${upload }" enctype="multipart/form-data" method="POST">
		名称：<input type="text" name="name" /><br> 
		上传文件：<input type="file" name="myFile" multiple="true" /><br> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> <br>
			<input type="submit" value="提交">
	</form>
</body>
</html>