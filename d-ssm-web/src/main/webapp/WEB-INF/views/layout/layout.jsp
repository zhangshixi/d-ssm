<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title><sitemesh:title /></title>
    	
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Cache-Control" content="no-store" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		
		<meta name="keywords" content="keywords" />
		<meta name="description" content="Description" />
		
		<link type="text/css" rel="stylesheet" href="${ctx}/styles/core.css" />
		<link type="text/css" rel="stylesheet" href="${ctx}/styles/main.css" />
		<link type="text/css" rel="stylesheet" href="${ctx}/styles/common.css" />
			    
		<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
		<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.form.js"></script>
		<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.validate.js"></script>
		
		<!-- <link href="${ctx}/images/favicon.ico" type="image/x-icon" rel="shortcut icon" /> -->

		<sitemesh:head />
    </head>
	
    <body class="">
    
		<jsp:include page="header.jsp" />

		<sitemesh:body />
		
		<jsp:include page="footer.jsp" />
		
    </body>
	
</html>