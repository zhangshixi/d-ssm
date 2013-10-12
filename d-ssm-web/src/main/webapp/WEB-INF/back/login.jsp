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
		
		<form id="loginForm" name="loginForm" method="post" action="${ctx}/login">
			Username: <input type="text" name="username" /><br />
			Password: <input type="password" name="password" /><br />
			Captcha: <input type="text" name="captcha" /><img src="${ctx}/images/captcha.jpg" /><br />
			<input type="checkbox" name="rememberMe" value="true" checked="checked" />Remember Me?<br />
			
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