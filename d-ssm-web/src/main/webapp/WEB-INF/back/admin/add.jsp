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
	
		<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">
					<a href="${ctx}/admin">管理员管理</a> >> 添加
				</span>
				<span class="right add_t"><a href="${ctx}/admin" title="添加">返回列表</a></span>
			</div>
			
			<div class="clear"></div>
			
			<div class=" title_row dark_blue">
				<form id="addForm" name="addForm" method="post" action="${ctx}/admin">
				
					<table width="100%" cellspacing="1" cellpadding="3">
						<tbody>
							<tr>
								<td width="40%" class="label dark_blue">Login name</td>
								<td width="60%">
									<input type="text" class="inputBorder" name="loginName" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">Password</td>
								<td>
									<input type="text" class="inputBorder" id="password" name="password" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">Password confirm</td>
								<td>
									<input class="inputBorder" type="text" name="passwordConfirm" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">Real name</td>
								<td>
									<input type="text" class="inputBorder" name="realName" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">Email</td>
								<td>
									<input type="text" class="inputBorder" name="email" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">Mobile</td>
								<td>
									<input type="text" class="inputBorder" name="mobile" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">Remark</td>
								<td>
									<input type="text" class="inputBorder" name="remark" />
								</td>
							</tr>
							<tr>
								<td align="center" colspan="2">
									<input type="submit" class="button" value="Submit" />
									<input type="reset" class="button" value="Reset" />
								</td>
							</tr>
						</tbody>
					</table>

				</form>
			
			</div>
		</div>
		
	
		<script type="text/javascript">
	        $().ready(function() {
	            $("input[name=loginName]").focus();
				
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