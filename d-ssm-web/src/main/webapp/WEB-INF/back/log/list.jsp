<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="listDiv">
	<table id="dataTable" class="dataTable" style="width: 100%;">
		<tbody>
			<tr>
				<th>编号</th>
				<th>文件名</th>
				<th>文件大小</th>
				<th>最后修改时间</th>
				<th>绝对路径</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${resultList}" var="item" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${item.name}</td>
					<td>${item.size}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.lastModifiedTime}" /></td>
					<td>${item.absolutePath}</td>
					<td>
						<shiro:hasRole name="log:manager">
							<a href="${ctx}/log/${item.name}" title="监控">监控</a>
							<a href="${ctx}/log/${item.name}/download" title="下载">下载</a>
							<a href="${ctx}/log/${item.name}/clear" title="清空">清空</a>
							<a href="${ctx}/log/${item.name}/remove" title="删除">删除</a>
						</shiro:hasRole>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>

<jsp:include page="../layout/page.jsp" />