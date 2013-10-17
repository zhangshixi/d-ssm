<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>menu add</title>
	</head>
	
	<body>
	
		<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">
					<a href="${ctx}/menu">菜单管理</a> &gt;&gt; 添加
				</span>
				<span class="right add_t"><a href="${ctx}/menu" title="添加">返回列表</a></span>
			</div>
			
			<div class="clear"></div>
			
			<div class=" title_row dark_blue">
				<form id="addForm" name="addForm" method="post" action="${ctx}/menu">
				
					<table width="100%" cellspacing="1" cellpadding="3">
						<tbody>
							<tr>
								<td width="40%" class="label dark_blue">parent.id</td>
								<td width="60%">
									<input type="text" class="inputBorder" name="parent.id" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td width="40%" class="label dark_blue">Name</td>
								<td width="60%">
									<input type="text" class="inputBorder" name="name" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td width="40%" class="label dark_blue">Code</td>
								<td width="60%">
									<input type="text" class="inputBorder" name="code" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">Link</td>
								<td>
									<input type="text" class="inputBorder" name="link" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">sequence</td>
								<td>
									<input type="text" class="inputBorder" name="sequence" />
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
	            $("input[name=name]").focus();
				
	            $("#addForm").validate({
	                rules: {
						name: {
							required: true,
						}
	                },
	                messages: {
	                    name: {
	                        required: "Fill me please",
	                    }
	                }   
	            });
	        });
	    </script>
	
	</body>
</html>