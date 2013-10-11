<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Admin add</title>
	</head>
	
	<body>
	
		<form id="addForm" name="addForm" method="POST" action="${ctx}/admin">
			Login name: <input type="text" id="loginName" name="loginName" /><br />
			Password: <input type="text" id="password" name="password" /><br />
			Password confirm: <input type="text" name="passwordConfirm" /><br /><br />
			
			Real name: <input type="text" name="realName" /><br />
			Email: <input type="text" name="email" /><br />
			Mobile: <input type="text" name="mobile" /><br />
			
			<input type="submit" value="Submit" />
			<input type="reset" value="Reset" />
		</form>
	
		<script type="text/javascript">
	        $().ready(function() {
	            $("#loginName").focus();
				
	            $("#addForm").validate({
	                rules: {
	                    loginName: {
	                        required: true,
	                        minlength: 4,
							remote: "${ctx}/admin/check/name"
	                    },
	                    password: {
	                        required: true,
	                        minlength: 6
	                    },
						passwordConfirm: {
	                        required: true,
							equalTo: "#password"
	                    },
						email: {
							required: true,
							email: true
						},
						mobile: {
							required: true,
							mobile: true
						}
	                },
	                messages: {
	                    loginName: {
	                        required: "Fill me please",
	                        minlength: "My name is bigger",
							remote: "User Name Exists"
	                    },
	                    password: {
	                        required: "Please provide a password",
	                        minlength: "My password is more that 6 chars"
	                    },
						passwordConfirm: {
	                        equalTo: "Input the same password as above"
	                    },
						email: {
							required: "Fill me please",
							email: "I'm a email address"
						},
						mobile: {
							required: "Fill me please",
							mobile: "I'm a mobile number"
						}
	                }   
	            });
	        });
	    </script>
	
	</body>
</html>