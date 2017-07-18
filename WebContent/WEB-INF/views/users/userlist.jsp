<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
<link href="<%=path%>/ui/css/main.css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/ui/javascript/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/ui/javascript/userlist.js"></script>

</head>
<body>
	所有用户信息：
	<br>
	<c:forEach var="user" items="${users }">
		----${user.id }<br>
	</c:forEach>
	
</body>
</html>