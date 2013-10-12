<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<title>Signup</title>
    </head>
	
    <body>
        <form name="addForm" action="${ctx}/signup" method="post">
    		name: <input type="text" name="name" />
    		<br/>
    		password: <input type="password" name="password" />
    		<br/>
    		email: <input type="text" name="email" />
			<input type="submit" />
			<input type="reset" />
		</form>
    </body>
</html>