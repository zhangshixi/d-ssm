<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title><sitemesh:title /></title>
    	
		<sitemesh:head />
    </head>
	
    <body class="">
    
		<jsp:include page="/WEB-INF/back/layout/header.jsp" />

		<sitemesh:body />
		
		<jsp:include page="/WEB-INF/back/layout/footer.jsp" />
		
    </body>
	
</html>