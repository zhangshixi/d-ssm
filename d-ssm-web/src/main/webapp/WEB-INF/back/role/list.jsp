<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="listDiv">
	<table id="dataTable" class="dataTable" style="width: 100%;">
		<tbody>
			<tr>
				<th>ID</th>
				<th>名称</th>
				<th>编码</th>
				<th>描述</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${resultList}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.code}</td>
					<td>${item.description}</td>
					<td>
						<shiro:hasPermission name="role:show">
							<a href="${ctx}/role/${item.id}" id="editLink-${item.name}">查看</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="role:edit">
							<a href="${ctx}/role/${item.id}/edit" id="editLink-${item.name}">编辑</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="role:remove">
							<a href="${ctx}/role/${item.id}" title="删除" onclick="return doDelete(this);">删除</a>
						</shiro:hasPermission>
						<a href="${ctx}/role/${item.id}/authorize" title="分配权限">分配权限</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="../layout/page.jsp" />