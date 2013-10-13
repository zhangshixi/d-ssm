<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${ctx}/styles/core.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
<script type="text/javascript">
//点击展开关闭左侧菜单
$(function(){
	$('#mid').toggle(function close(){
		if (!isIE6()&&!isIE7()) {
			var cols = window.top.document.getElementById("myFrame").cols;
			var width = cols.split(',')[0];
			if (parseInt(width)<=0) {
				$('#mid div').removeClass('nosel').addClass('sel');
				jQuery(window.parent.parent.frames["leftFrame"].document).find("#left_list").removeClass('right');
				window.top.document.getElementById('myFrame').cols='0,15,*';
				return false;
			};
			window.top.document.getElementById('myFrame').cols=String(window.top.document.getElementById("myFrame").cols.split(',')[0]-30)+",15,*";
			jQuery(window.parent.parent.frames["leftFrame"].document).find("#left_list").addClass('right');
			setTimeout(close,16);
		} else {
			window.top.document.getElementById('myFrame').cols='0,15,*';
			$('#mid div').removeClass('nosel').addClass('sel');
		};
	},
	function open(){
		if (!isIE6()&&!isIE7()) {
			var cols = window.top.document.getElementById("myFrame").cols;
			var width = cols.split(',')[0];
			if (parseInt(width)>=210) {
				$('#mid div').addClass("nosel").removeClass("sel");
				jQuery(window.parent.parent.frames["leftFrame"].document).find("#left_list").removeClass('right');
				window.top.document.getElementById('myFrame').cols='210,15,*';
				return false;
			}
			window.top.document.getElementById('myFrame').cols=String(parseInt(window.top.document.getElementById("myFrame").cols.split(',')[0])+30)+",15,*";
			jQuery(window.parent.parent.frames["leftFrame"].document).find("#left_list").addClass('right');
			setTimeout(open,16);
		} else {
			window.top.document.getElementById('myFrame').cols='210,15,*';
			$('#mid div').addClass("nosel").removeClass("sel");
		}
	});
});
//判断浏览器是非为IE7
function isIE7() {
	var version = navigator.userAgent.indexOf('MSIE 7.0')>-1;
	return version;
}
//判断浏览器是非为IE6
function isIE6() {
	var version = navigator.userAgent.indexOf('MSIE 6.0')>-1;
	return version;
}
</script>
</head>
<body style="height:100%;">
	<div id="midBody">
		<div id="mid">
			<div class="nosel"></div>
		</div>
	</div>

</body>
</html>