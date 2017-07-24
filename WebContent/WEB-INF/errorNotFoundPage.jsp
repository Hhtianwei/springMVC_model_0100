<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page pageEncoding="UTF-8"%>

<c:url value="/" var="homePageUrl" />
<div class="item_container_holder_error">
<div class="system_msg">
   <div class="info cf">
   		<div class="col-md-6 col-sm-12">
   			<p class="imgError"><img src="/lynxgcrstorefront/_ui/responsive/theme-blue/images/imgs/sys_error.png"></p>
   		</div>
   		<div class="col-md-6 col-sm-12">
	   		<div class="errorDetails">
	          <p class="imgSorry">
	           	<img src="/lynxgcrstorefront/_ui/responsive/theme-blue/images/imgs/sys_error2.png">
	          </p>
	          <p class="errorMessage">404</p>
	          <a href="${homePageUrl}" title="button" class="sorryBtn">home page </a>
	       </div>
   		</div>
   </div>
 </div>
 </div>
