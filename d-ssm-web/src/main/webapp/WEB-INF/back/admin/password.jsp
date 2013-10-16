<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<title>Admin edit Password</title>
    </head>
    
    <body>
    	
    	<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">修改密码</span>
			</div>
			
			<div class="clear"></div>
			
			<div class=" title_row dark_blue">
				<form id="editForm" name="editForm" method="post" action="${ctx}/admin/${target.id}">
					<input type="hidden" name="_method" value="PUT" />
					
					<table width="100%" cellspacing="1" cellpadding="3">
						<tbody>
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
	            $("input[name=password]").focus();
				
	            $("#editForm").validate({
	                rules: {
	                    password: {
	                        required: true,
	                        minlength: 6
	                    },
						passwordConfirm: {
	                        required: true,
							equalTo: "#password"
	                    }
	                },
	                messages: {
	                    password: {
	                        required: "Please provide a password",
	                        minlength: "My password is more that 6 chars"
	                    },
						passwordConfirm: {
	                        equalTo: "Input the same password as above"
	                    }
	                }   
	            });
	        });
	    </script>
    	
    </body>
</html>