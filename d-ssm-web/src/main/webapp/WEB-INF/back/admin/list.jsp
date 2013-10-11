<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<table>
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

${page}