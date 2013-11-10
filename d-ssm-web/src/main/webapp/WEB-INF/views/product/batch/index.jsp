<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>batch List</title>
		
		<script type="text/javascript" src="${ctx}/scripts/page.js"></script>
	</head>
	
	<body>
		
		<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">权限色管理</span>
				<span class="right add_t">
					<shiro:hasPermission name="batch:new">
						<a href="${ctx}/batch/new" title="添加">添加</a>
					</shiro:hasPermission>
				</span>
			</div>
			
			<div class="clear"></div>
			
			<div id="searchPanel" class="search_row dark_blue">
			
				<form id="searchForm" name="searchForm" method="post" action="${ctx}/batch/list">
					<input type="hidden" name="pageIndex" value="1" />
					<input type="hidden" name="pageSize" value="20" />
					
					<div class="search_row_element">
		    			编码: <input type="text" class="enterQuery input black" name="code" />
		            </div>
					<div class="search_row_element">
		    			名称: <input type="text" class="enterQuery input black" name="name" />
		            </div>

					<input type="button" class="button" value="搜索" onclick="javascript:searchPage();" />
				</form>
			</div>
			
			<div class="clear"></div>
			
			<div id="contentPanel"></div>
		</div>
		
	</body>
</html>