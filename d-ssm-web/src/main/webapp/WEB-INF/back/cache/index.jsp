<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>缓存列表</title>
		
		<script type="text/javascript" src="${ctx}/scripts/page.js"></script>
	</head>
	
	<body>
		
		<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">缓存管理</span>
				<span class="right add_t">
					<shiro:hasPermission name="cache:new">
						<a href="${ctx}/cache/new" title="添加">添加</a>
					</shiro:hasPermission>
				</span>
			</div>
			
			<div class="clear"></div>
			
			<div id="listDiv">
				<table id="dataTable" class="dataTable" style="width: 100%;">
					<tbody>
						<tr>
							<th>ID</th>
							<th>名称</th>
							<th>编码</th>
							<th>链接</th>
							<th>排序值</th>
							<th>是否显示</th>
							<th>最后更新人</th>
							<th>最后更新时间</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${resultList}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.name}</td>
								<td>${item.code}</td>
								<td>${item.link}</td>
								<td>${item.sequence}</td>
								<td>${item.display}</td>
								<td>${item.updateAid}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.updateTime}" /></td>
								<td>
									<shiro:hasPermission name="cache:show">
										<a href="${ctx}/cache/${item.id}" id="editLink-${item.name}">查看</a>
									</shiro:hasPermission>
									<shiro:hasPermission name="cache:edit">
										<a href="${ctx}/cache/${item.id}/edit" id="editLink-${item.name}">编辑</a>
									</shiro:hasPermission>
									<shiro:hasPermission name="cache:remove">
										<a href="${ctx}/cache/${item.id}" title="删除" onclick="return doDelete(this);">删除</a>
									</shiro:hasPermission>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>
		
	</body>
</html>