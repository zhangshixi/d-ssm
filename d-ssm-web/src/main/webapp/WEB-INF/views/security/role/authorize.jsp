<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Authorize</title>
		
		<script type="text/javascript" src="${ctx}/scripts/page.js"></script>
	</head>
	
	<body>
		
		<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">
					<a href="${ctx}/role">角色管理</a> &gt;&gt; 分配权限
				</span>
				<span class="right add_t">
					<shiro:hasPermission name="role:show">
						<a href="${ctx}/role" title="添加">返回列表</a>
					</shiro:hasPermission>
				</span>
			</div>
			
			<div class="clear"></div>
			
			<div id="searchPanel" class="search_row dark_blue">
			
				<form id="searchForm" name="searchForm" method="post" action="${ctx}/permission/list">
					<input type="hidden" name="pageIndex" value="1" />
					<input type="hidden" name="pageSize" value="20" />
					
					<div class="search_row_element">
		    			编码: <input type="text" class="enterQuery input black" name="code" />
		            </div>
					<div class="search_row_element">
		    			名称: <input type="text" class="enterQuery input black" name="name" />
		            </div>

					<input type="button" class="button" value="搜索" onclick="javascript:searchPage();" />
				</form>
			</div>
			
			<div class="clear"></div>
			
			<div id="listDiv">
				<form method="post" action="${ctx}/role/${target.id}/authorize">
					<input type="hidden" name="_method" value="PUT" />
			
					<table id="dataTable" class="dataTable" style="width: 100%;">
						<tbody>
							<tr>
								<th>ID</th>
								<th>权限名称</th>
								<th>权限编码</th>
								<th>权限描述</th>
								<th>是否已分配</th>
							</tr>
							
							<c:forEach items="${allPermissionList}" var="item">
								<tr>
									<td>${item.id}</td>
									<td>${item.name}</td>
									<td>${item.code}</td>
									<td>${item.description}</td>
									<td>
										<input type="checkbox" name="permissionId[]" value="${item.id}" 
											<c:forEach items="${ownPermissionList}" var="permission">
												<c:if test="${item.code == permission.code}">checked="checked"</c:if> 
											</c:forEach>	
										/>
									</td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
					<div id="pageDiv" class="list_b">
						<div class="right list_bottom list_b">
							<input type="submit" class="button" value="提交" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>