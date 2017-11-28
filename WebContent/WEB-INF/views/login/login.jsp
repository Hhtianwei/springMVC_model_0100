<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>

<link href="<%=path%>/ui/css/main.css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/ui/javascript/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("a.getSMScode").on("click",function(){
			$.ajax({
				url:"createSMScode",
				type:"get",
				success:function(){
					
				}
			});
		});
	});
</script>
</head>
<body>
	test message:<spring:message code="first.message"/>
	
<br>
 登录页面:
 		<c:if test="${not empty errorMsg}">
 			<font color="red">${errorMsg }</font>
 		</c:if>
 		
 		<hr>
 		<br>
 		
 	<c:url var="login" value="/login"/>
	<form id="login-form" method="post" action="${login}">
		userName:<input type="text" name="uname"/><br>
		password:<input type="password" name="password"/><br>
		<br><br>
		remember-me:<input type="checkbox" name="remember-me"/>
		<br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" name="提交"/>
		
		<br>
	</form>
	<br>
<hr>
<br>
	<h2>短信登录</h2>

	<c:url var="smsLogin" value="/smsLogin"/>
	<c:url var="createSMScode" value="/createSMScode"/>
	
	<form action="${smsLogin }" method="post">
		手机号:<input type="text" name="mobile" value="18201997620"/><a class="getSMScode" href="javascript:void();">获取验证码</a><br>
		短信验证码：<input type="text" name="smsCode"/><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="登录"/>
	</form>
<hr>
<br>
	
</body>
</html>