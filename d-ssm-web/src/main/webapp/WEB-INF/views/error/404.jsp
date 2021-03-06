<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title>404</title>
    </head>
    <body>
        <div class="page-header">
            <h1 class="center">404</h1>
        </div>

        <h2 class="center">The page cannot be found.</h2>

        <div class="center">
            <a href="javascript: history.go(-1)" class="btn" style="margin-right:10px;"><span class="icon16 typ-icon-back"></span>Go back</a>
            <a href="${ctx}/index" class="btn"><span class="icon16 cut-icon-screen"></span>Dashboard</a>
        </div>
    </body>
</html>