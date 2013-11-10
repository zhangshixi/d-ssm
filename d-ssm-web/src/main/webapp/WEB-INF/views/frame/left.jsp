<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
		<c:forEach items="${menuList}" var="item">
			<dl>
				<dt class="bold">
					<s class="icon_${item.code}"></s>${item.name}
				</dt>
				<c:forEach items="${item.childList}" var="childItem">
<%-- 					<shiro:hasPermission name="${childItem.code}:show"> --%>
						<dd style="display:none;">
							<a href="${ctx}${childItem.link}" target="mainFrame">${childItem.name}</a>
						</dd>
<%-- 					</shiro:hasPermission> --%>
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