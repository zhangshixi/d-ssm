<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title><decorator:title /></title>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="Cache-Control" content="no-store" />
        <meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />

	    <meta name="keywords" content="keywords" />
	    <meta name="description" content="Description" />
	    
    	<link href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon" rel="shortcut icon" />
    	
  		<link href="${pageContext.request.contextPath}/styles/main.css" rel="stylesheet" type="text/css" /> 
    	
	    <link href="${pageContext.request.contextPath}/styles/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
	    <link href="${pageContext.request.contextPath}/styles/bootstrap/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
	    <link href="${pageContext.request.contextPath}/styles/supr-theme/jquery.ui.supr.css" rel="stylesheet" type="text/css" />
	    <link href="${pageContext.request.contextPath}/styles/icons.css" rel="stylesheet" type="text/css" />
	    <link href="${pageContext.request.contextPath}/plugins/uniform/uniform.default.css" type="text/css" rel="stylesheet" />
		
		<decorator:head />
    </head>
	
    <body class="loginPage">
    
        <jsp:include page="/WEB-INF/views/layout/single_header.jsp" />

		<decorator:body />
		
		<jsp:include page="/WEB-INF/views/layout/single_footer.jsp" />
		
    </body>
	
</html>