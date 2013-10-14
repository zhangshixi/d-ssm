<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<link href="${ctx}/styles/common.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/styles/core.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
<script type="text/javascript" src="${ctx}/scripts/left.js"></script>
</head>

<body style="background:#333;">
<div id="left_list">
    <div class="left_title">
      	<span class="left_title_top">菜单</span>
      	<div class="left_button1" id="left_list_button"></div>
    </div>
    <div class="left_list_Center">
		<dl>
			<dt class="bold">
				<s class="icon_gysxx"></s>权限管理
			</dt>
			<dd style="display:none;">
				<a href="${ctx}/admin" target="mainFrame">管理员管理</a>
			</dd>
			<dd style="display:none;">
				<a href="${ctx}/role" target="mainFrame">角色管理</a>
			</dd>
			<dd style="display:none;">
				<a href="${ctx}/permission" target="mainFrame">权限管理</a>
			</dd>
			<dd style="display:none;">
				<a href="${ctx}/menu" target="mainFrame">菜单设置</a>
			</dd>
		</dl>
		
		<dl>
			<dt class="bold">
				<s class="icon_yygl"></s>系统管理
			</dt>
			<dd style="display:none;">
				<a href="${ctx}/log" target="mainFrame">系统日志</a>
			</dd>
		</dl>
		
		
		<c:forEach items="${enumList}" var="item">
			<dl>
			<dt class="bold">
				<s class="icon_yygl"></s>${item.name}
			</dt>
			<c:forEach items="${enum.childList}" var="childItem">	
				<dd style="display:none;">
					<a href="${ctx}${childItem.link}" target="mainFrame">${childItem.name}</a>
				</dd>
			</c:forEach>
		</dl>
		</c:forEach>
    </div>
    <div class="shadow"></div>
</div>
	<script type="text/javascript">
		if (!('v'=='\v')) {
			$(window).scroll(function () {
				if ($('body').scrollTop()>0) {
					$('.shadow').height($('body').height());
				} else {
					$('.shadow').removeAttr('style');
				}
			});
		}
	</script>
</body>
</html>