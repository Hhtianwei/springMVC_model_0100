<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h1>自定义授权</h1>
	<p>你确定要授权给 '${authorizationRequest.clientId}' 来访问你的受保护资源？ </p>
	<form id='confirmationForm' name='confirmationForm'
		action='<%=path %>/oauth/authorize' method='post'>
		<input name='user_oauth_approval' value='true' type='hidden' /><input
			type='hidden' name='${_csrf.parameterName}' value='${_csrf.token}' /><label><input
			name='authorize' value='我愿意' type='submit' /></label>
	</form>
	<form id='denialForm' name='denialForm'
		action='<%=path %>/oauth/authorize' method='post'>
		<input name='user_oauth_approval' value='false' type='hidden' /><input
			type='hidden' name='${_csrf.parameterName}' value='${_csrf.token}' /><label><input
			name='deny' value='一边玩去' type='submit' /></label>
	</form>
</body>
</html>