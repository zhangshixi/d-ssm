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

<div id="pageDiv" class="list_b">
	<div class="left">
		第<span class="bold red">${page.pageIndex}</span>页，
		共<span class="bold red" id="totalPages">${page.totalPage}</span>页，
		<span class="bold red">${page.totalData}</span>条，
		每页显示
		<select id="changePageSize" onchange="changePageSize();">
			<option value="2" <c:if test="${page.pageSize == 2}">selected="selected"</c:if>>2</option>
			<option value="10" <c:if test="${page.pageSize == 10}">selected="selected"</c:if>>10</option>
			<option value="20" <c:if test="${page.pageSize == 20}">selected="selected"</c:if>>20</option>
			<option value="50" <c:if test="${page.pageSize == 50}">selected="selected"</c:if>>50</option>
		</select>
	</div>
	<div class="right list_bottom list_b">
    	<a <c:if test="${page.firstPage}">class="gray"</c:if>
    	   <c:if test="${!page.firstPage}">href="javascript:jumpToPage(1);"</c:if>
    	>首页</a>
		<a <c:if test="${page.firstPage}">class="gray"</c:if>
		   <c:if test="${!page.firstPage}">href="javascript:jumpToPage(${page.pageIndex - 1});"</c:if>
		>上一页</a>
        <a <c:if test="${page.lastPage}">class="gray"</c:if>
    	   <c:if test="${!page.lastPage}">href="javascript:jumpToPage(${page.pageIndex + 1});"</c:if>
		>下一页</a>
		<a <c:if test="${page.lastPage}">class="gray"</c:if>
    	   <c:if test="${!page.lastPage}">href="javascript:jumpToPage(${page.totalPage});"</c:if>
		>尾页</a>
        <input type="text" class="input" id="jumpToPage" style="width:30px;">
    	<a class="button" href="javascript:jumpToPage();">GO</a>
	</div>
</div>