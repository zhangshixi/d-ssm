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
				<th>事务类型</th>
				<th>名称</th>
				<th>编码</th>
				<th>最后更新人</th>
				<th>最后更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${resultList}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.type ? "出库" : "入库"}</td>
					<td>${item.name}</td>
					<td>${item.code}</td>
					<td>${item.updateAdmin.loginName}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.updateTime}" /></td>
					<td>
						<shiro:hasPermission name="transtype:show">
							<a href="${ctx}/transtype/${item.id}" id="editLink-${item.name}">查看</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="transtype:edit">
							<a href="${ctx}/transtype/${item.id}/edit" id="editLink-${item.name}">编辑</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="transtype:remove">
							<a href="${ctx}/transtype/${item.id}" title="删除" onclick="return doDelete(this);">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/views/layout/page.jsp" />