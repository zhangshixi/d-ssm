<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Admin login</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="Cache-Control" content="no-store" />
        <meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />

	    <meta name="keywords" content="keywords" />
	    <meta name="description" content="Description" />
	    
		<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/jquery/jquery.form.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/jquery/jquery.validate.js"></script>
		
    	<link type="text/css" rel="stylesheet" href="${ctx}/styles/main.css" />
	</head>

	<body>
		
		${errorMsg}
		
		<form id="loginForm" name="loginForm" method="POST" action="${ctx}/login">
			Username: <input type="text" name="username" /><br />
			Password: <input type="password" name="password" /><br />
			Captcha: <input type="text" name="captcha" /><img src="${ctx}/images/captcha.jpg" /><br />
			<input type="checkbox" name="rememberMe" value="true" checked />Remember Me?<br />
			
			<input type="submit" value="Submit" />
			<input type="reset" value="Reset" />
		</form>
	
		<script type="text/javascript">
	        $().ready(function() {
	            $("#name").focus();
				
	            $("#loginForm").validate({
	                rules: {
	                    username: {
						required: true,
	                        minlength: 4
	                    },
	                    password: {
						required: true,
	                        minlength: 6
	                    }
	                },
	                messages: {
	                    username: {
	                        minlength: "My name is bigger"
	                    },
	                    password: {
	                        minlength: "My password is more that 6 chars"
	                    }
	                }   
	            });
	        });
	    </script>
	
	</body>
</html>


<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<th>登录名</th>
			<th>姓名</th>
			<th>电邮</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${adminList}" var="admin">
			<tr>
				<td>${admin.loginName}&nbsp;</td>
				<td>${admin.realName}&nbsp;</td>
				<td>${admin.email}&nbsp;</td>
				<td>${admin.mobile}&nbsp;</td>
				<td>
					<shiro:hasPermission name="user:edit">
						<a href="${ctx}/account/user/update/${user.id}" id="editLink-${user.loginName}">修改</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
	</tbody>		
</table>