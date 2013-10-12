<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Admin List</title>
		<link type="text/css" rel="stylesheet" href="${ctx}/styles/common.css" />
		<link type="text/css" rel="stylesheet" href="${ctx}/styles/core.css" />
		<link type="text/css" rel="stylesheet" href="${ctx}/styles/main.css" />
		<link type="text/css" rel="stylesheet" href="${ctx}/styles/plugin/thickbox.css" />
		
		<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/jquery/jquery.form.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/jquery/jquery.validate.js"></script>
		
		<script type="text/javascript" src="${ctx}/scripts/page.js"></script>
		
		<script type="text/javascript" src="${ctx}/scripts/main.js"></script>
		<script type="text/javascript" src="${ctx}/scripts/util.js"></script>
	</head>
	
	<body>
		
		<div class="main">
			<div class="main_title">
				<span class="left bold main_title_top dark_blue">管理员管理</span>
				<span class="right add_t"><a href="${ctx}/admin/new" title="添加">添加</a></span>
			</div>
			
			<div class="clear"></div>
			
			<div id="searchPanel" class="search_row dark_blue">
			
				<form id="searchForm" name="searchForm" method="POST" action="${ctx}/admin/list">
					<input type="hidden" name="pageIndex" value="1" />
					<input type="hidden" name="pageSize" value="5" />
					
					<div class="search_row_element">
		    			Name: <input type="text" class="enterQuery input black" name="realName" />
		            </div>
					<div class="search_row_element">
		    			Email: <input type="text" class="enterQuery input black" name="email" />
		            </div>
					<div class="search_row_element">
		    			Mobile: <input type="text" class="enterQuery input black" name="mobile" />
		            </div>

					<input type="button" value="Submit" onclick="javascript:searchPage();" />
				</form>
			</div>
			
			<div class="clear"></div>
			
			<div id="searchResult"></div>
		</div>
		
	</body>
</html>