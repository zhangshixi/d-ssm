<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow-x:hidden;overflow-y:auto;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>聚尚网-供应商平台管理系统</title>
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
				<s class="icon_gysxx"></s>
				供应商信息
			</dt>
			<dd style="display:none;">
				<a href="${ctx}/admin" target="mainFrame" title="" hidefocus="true"><s></s>基本信息</a>
			</dd>
		</dl>
		
		<dl>
			<dt class="bold">
				<s class="icon_yygl"></s>
				运营管理
			</dt>
			<dd style="display:none;">
				<a href="/rush/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>专场管理</a>
			</dd>
			<dd style="display:none;">
				<a href="/workorder/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>工单处理</a>
			</dd>
			<dd style="display:none;">
				<a href="/selfreturn/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>自助退货</a>
			</dd>
			<dd style="display:none;">
				<a href="/notice/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>系统公告</a>
			</dd>
		</dl>
		<dl>
			<dt class="bold">
				<s class="icon_spgl"></s>
				商品管理
			</dt>
			<dd style="display:none;">
				<a href="/goods/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>商品列表</a>
			</dd>
			<dd style="display:none;">
				<a href="/batchImport/init.htm" target="mainFrame" title="" hidefocus="true"><s></s>批量导入</a>
			</dd>
			<dd style="display:none;">
				<a href="/bcsimp/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>尺寸图导入</a>
			</dd>
			<dd style="display:none;">
				<a href="/goods/category/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>商品分类</a>
			</dd>
			<dd style="display:none;">
				<a href="/goods/type/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>前台三级分类</a>
			</dd>
		</dl>
		<dl>
			<dt class="bold">
				<s class="icon_fhgl"></s>
				发货管理
			</dt>
			<dd style="display:none;">
				<a href="/shippingwave/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>波次列表</a>
			</dd>
			<dd style="display:none;">
				<a href="/shippingwave/shipping/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>批量发货</a>
			</dd>
			<dd style="display:none;">
				<a href="/shipping/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>物流公司</a>
			</dd>
			<dd style="display:none;">
				<a href="/shippingpacket/list/main.htm" target="mainFrame" title="" hidefocus="true"><s></s>订单查询</a>
			</dd>
		</dl>
    </div>
    <div class="shadow"></div>
</div>
</body>
<script type="text/javascript">
if (!('v'=='\v')) {
	$(window).scroll(function () {
		if ($('body').scrollTop()>0) {
			$('.shadow').height($('body').height());
		} else {$('.shadow').removeAttr('style')}
	});
}
</script>
</html>