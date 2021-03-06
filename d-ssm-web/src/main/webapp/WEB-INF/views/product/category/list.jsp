<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="listDiv">
	<table id="dataTable" class="dataTable" style="width: 100%;">
		<tbody>
			<tr>
				<th>+/-</th>
				<th>ID</th>
				<th>名称</th>
				<th>编码</th>
				<th>描述</th>
				<th>最后更新人</th>
				<th>最后更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${resultList}" var="item">
				<tr>
					<td>+</td>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.code}</td>
					<td>${item.description}</td>
					<td>${item.updateAdmin.loginName}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.updateTime}" /></td>
					<td>
						<shiro:hasPermission name="category:show">
							<a href="${ctx}/category/${item.id}" id="editLink-${item.name}">查看</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="category:edit">
							<a href="${ctx}/category/${item.id}/edit" id="editLink-${item.name}">编辑</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="category:remove">
							<a href="${ctx}/category/${item.id}" title="删除" onclick="return doDelete(this);">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
				
				<c:forEach items="${item.childList}" var="childItem">
					<tr>
						<td></td>
						<td>${childItem.id}</td>
						<td>${childItem.name}</td>
						<td>${childItem.code}</td>
						<td>${childItem.description}</td>
						<td>${childItem.updateAdmin.loginName}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${childItem.updateTime}" /></td>
						<td>
							<shiro:hasPermission name="category:show">
								<a href="${ctx}/category/${childItem.id}" id="editLink-${childItem.name}">查看</a>
							</shiro:hasPermission>
							<shiro:hasPermission name="category:edit">
								<a href="${ctx}/category/${childItem.id}/edit" id="editLink-${childItem.name}">编辑</a>
							</shiro:hasPermission>
							<shiro:hasPermission name="category:remove">
								<a href="${ctx}/category/${childItem.id}" title="删除" onclick="return doDelete(this);">删除</a>
							</shiro:hasPermission>
						</td>
					</tr>
				</c:forEach>
				
			</c:forEach>
		</tbody>
	</table>
</div>