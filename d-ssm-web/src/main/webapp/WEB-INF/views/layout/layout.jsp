<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title>SiteMesh-Velocity: <decorator:title /></title>

		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta http-equiv="Cache-Control" content="no-store" />
        <meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />

    	<link href="/images/favicon.ico" type="image/x-icon" rel="shortcut icon" />
    	
    	<link href="/styles/common.css" type="text/css" rel="stylesheet" />
    	
		<script src="/scripts/jquery/jquery.js" type="text/javascript"></script>
    	<script src="/scripts/common.js" type="text/javascript"></script>
    	<script src="/scripts/mjee.js" type="text/javascript"></script>
		
		<decorator:head />
    </head>
	
    <body>
        <jsp:include page="/WEB-INF/views/layout/header.jsp" />
        <jsp:include page="/WEB-INF/views/layout/left.jsp" />
		<div id="body">
			<decorator:body />
		</div>
		<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
		
		<%-- 
		<script src="${STATIC_DOMAIN}/scripts/bootstrap.min.js" type="text/javascript"></script>
		--%>
    </body>
	
</html>