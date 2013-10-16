<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>menu List</title>
	</head>
	
	<body>
		
		<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">日志管理</span>
			</div>
			
			<div class="clear"></div>
			
			<div id="listDiv">
				
				<table id="dataTable" class="dataTable" style="width: 100%;">
					<tbody>
						<tr>
							<th>编号</th>
							<th>日志文件</th>
							<th>文件大小</th>
							<th>最后修改时间</th>
							<th>操作</th>
						</tr>
						
						<c:forEach items="${logFiles}" var="item" varStatus="count">
							<tr>
								<td>${count.count}</td>
								<td>${item.absolutePath}</td>
								<td>1.2M</td>
								<td>2013-10-16 15:23:43</td>
								<td>
									<shiro:hasRole name="log">
										<a href="${ctx}/log/${item.name}" title="监控">监控</a>
										<a href="${ctx}/log/${item.name}" title="清空">清空</a>
										<a href="${ctx}/log/${item.name}" title="下载">下载</a>
										<a href="${ctx}/log/${item.name}" title="清空">删除</a>
									</shiro:hasRole>
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>

		</div>
		
	</body>
</html>