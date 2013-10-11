<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Admin List</title>
		<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/jquery/jquery.form.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/jquery/jquery.validate.js"></script>
		
		<script type="text/javascript" src="${ctx}/scripts/page.js"></script>
		
		<script type="text/javascript" src="${ctx}/scripts/main.js"></script>
		<script type="text/javascript" src="${ctx}/scripts/util.js"></script>
	</head>
	
	<body>
		
		<a href="${ctx}/admin/new" title="添加">添加</a> <br />
		
		<form id="searchForm" name="searchForm" method="POST" action="${ctx}/admin/list">
			<input type="hidden" name="pageIndex" value="1" />
			<input type="hidden" name="pageSize" value="5" />
			
			Name: <input type="text" name="realName" />
			Email: <input type="text" name="email" />
			Phone: <input type="text" name="mobile" />
			<input type="button" value="Submit" onclick="javascript:searchPage();" />
		</form>
	
		<div id="searchResult"></div>
		
	</body>
</html>