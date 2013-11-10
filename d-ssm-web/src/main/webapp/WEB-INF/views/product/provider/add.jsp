<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>provider add</title>
		<script type="text/javascript" charset="utf-8" src="${ctx}/editor/kindeditor.js"></script>
    	<script type="text/javascript">
	    	createEditor("description");
		</script>
	</head>
	
	<body>
	
		<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">
					<a href="${ctx}/provider">权限管理</a> &gt;&gt; 添加
				</span>
				<span class="right add_t"><a href="${ctx}/provider" title="添加">返回列表</a></span>
			</div>
			
			<div class="clear"></div>
			
			<div class=" title_row dark_blue">
				<form id="addForm" name="addForm" method="post" action="${ctx}/provider">
				
					<table width="100%" cellspacing="1" cellpadding="3">
						<tbody>
							<tr>
								<td width="40%" class="label dark_blue">供应商名称</td>
								<td width="60%">
									<input type="text" class="inputBorder" name="name" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">供应商编码</td>
								<td>
									<input type="text" class="inputBorder" name="code" />
									<span class="red_dian">*</span>
								</td>
							</tr>
							<tr>
								<td class="label dark_blue">描述</td>
								<td><input type="text" class="inputBorder" name="description" /></td>
							</tr>
							<tr>
								<td class="label dark_blue">公司名称</td>
								<td><input type="text" class="inputBorder" name="companyName" /></td>
							</tr>
							<tr>
								<td class="label dark_blue">公司地址</td>
								<td><input type="text" class="inputBorder" name="companyAddress" /></td>
							</tr>
							<tr>
								<td class="label dark_blue">联系人</td>
								<td><input type="text" class="inputBorder" name="contactName" /></td>
							</tr>
							<tr>
								<td class="label dark_blue">联系人QQ</td>
								<td><input type="text" class="inputBorder" name="contactQq" /></td>
							</tr>
							<tr>
								<td class="label dark_blue">联系人电话</td>
								<td><input type="text" class="inputBorder" name="contactTel" /></td>
							</tr>
							<tr>
								<td class="label dark_blue">联系人电邮</td>
								<td><input type="text" class="inputBorder" name="contactEmail" /></td>
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
						},
	                    code: {
	                        required: true,
							remote: "${ctx}/provider/check/code"
	                    }
	                },
	                messages: {
	                    name: {
	                        required: "Fill me please",
	                    },
	                    code: {
	                        required: "Fill me please",
							remote: "User Name Exists"
	                    }
	                }   
	            });
	        });
	    </script>
	
	</body>
</html>