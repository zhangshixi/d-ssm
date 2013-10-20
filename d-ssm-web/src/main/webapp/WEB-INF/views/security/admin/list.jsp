<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="listDiv">
	<table id="dataTable" class="dataTable" style="width: 100%;">
		<tbody>
			<tr>
				<th>ID</th>
				<th>登录名</th>
				<th>真实姓名</th>
				<th>是否锁定</th>
				<th>手机</th>
				<th>电子邮件</th>
				<th>最后登录时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${resultList}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.loginName}</td>
					<td>${item.realName}</td>
					<td>${item.locked ? "是" : "否"}</td>
					<td>${item.mobile}</td>
					<td>${item.email}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.lastLoginTime}" /></td>
					<td>
						<shiro:hasPermission name="admin:show">
							<a href="${ctx}/admin/${item.id}" title="查看">查看</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="admin:edit">
							<a href="${ctx}/admin/${item.id}/edit" title="编辑">编辑</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="admin:remove">
							<a href="${ctx}/admin/${item.id}" title="删除" onclick="return doDelete(this);">删除</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="admin:authorize">
							<a href="${ctx}/admin/${item.id}/authorize" title="分配角色">分配角色</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/views/layout/page.jsp" />