<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="listDiv">
	<table id="dataTable" class="dataTable" width="100%" cellpadding="0" cellspacing="0">
		<tbody>
			<tr>
				<th>ID</th>
				<th>登录名</th>
				<th>真实姓名</th>
				<th>电邮</th>
				<th>手机</th>
				<th>最后登录时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${adminList}" var="admin">
				<tr>
					<td>${admin.id}</td>
					<td>${admin.loginName}</td>
					<td>${admin.realName}</td>
					<td>${admin.email}</td>
					<td>${admin.mobile}</td>
					<td>${admin.lastLoginTime}</td>
					<td>
						<shiro:hasPermission name="admin:show">
							<a href="${ctx}/admin/${admin.id}" id="editLink-${admin.loginName}">查看</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="admin:edit">
							<a href="${ctx}/admin/${admin.id}/edit" id="editLink-${admin.loginName}">编辑</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="admin:delete">
							<a href="${ctx}/admin/${admin.id}" title="删除" onclick="return doDelete(this);">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div id="pageDiv" class="list_b">
	<div class="left">
		第<span class="bold red">${page.pageIndex}</span>页，
		共<span class="bold red" id="totalPages">${page.totalPage}</span>页，
		<span class="bold red">${page.totalData}</span>条，
		每页显示
		<select id="selePageSize" onchange="changePageSize();">
			<option value="10">10</option>
			<option value="20" selected="selected">20</option>
			<option value="50">50</option>
		</select>
	</div>
	<div class="right list_bottom list_b">
    	<a class="gray">首页</a>
		<a class="gray">上一页</a>
        <a class="gray">下一页</a>
		<a class="gray">尾页</a>
        <input type="text" class="input" id="pageTo" style="width:30px;">
    	<a href="javascript:jumpPageTo()" class="button">GO</a>
	</div>
</div>