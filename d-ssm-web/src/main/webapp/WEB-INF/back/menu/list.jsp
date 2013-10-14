<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="listDiv">
	<table id="dataTable" class="dataTable" style="width: 100%;">
		<tbody>
			<tr>
				<th>ID</th>
				<th>parent ID</th>
				<th>名称</th>
				<th>link</th>
				<th>sequence</th>
				<th>display</th>
				<th>update admin</th>
				<th>update time</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${resultList}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.parent.id}</td>
					<td>${item.name}</td>
					<td>${item.link}</td>
					<td>${item.sequence}</td>
					<td>${item.display}</td>
					<td>${item.updateAid}</td>
					<td>${item.updateTime}</td>
					<td>
						<shiro:hasPermission name="menu:show">
							<a href="${ctx}/menu/${item.id}" id="editLink-${item.name}">查看</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="menu:edit">
							<a href="${ctx}/menu/${item.id}/edit" id="editLink-${item.name}">编辑</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="menu:remove">
							<a href="${ctx}/menu/${item.id}" title="删除" onclick="return doDelete(this);">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
