<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<title>Admin edit</title>
    </head>
    
    <body>
    
    	<form id="editForm" name="editForm" method="post" action="${ctx}/admin/${target.id}">
    		<input type="hidden" name="_method" value="PUT" />
    		LoginName: ${target.loginName}<br />
    		Real name: <input type="text" name="realName" value="${target.realName}" /><br />
    		Email: <input type="text" name="email" value="${target.email}" /><br />
    		mobile: <input type="text" name="mobile" value="${target.mobile}" /><br />
    		
    		<input type="submit" value="Submit" />
    		<input type="reset" value="Reset" />
    	</form>
    
    </body>
</html>