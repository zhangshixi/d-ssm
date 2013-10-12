<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title>version</title>
		
		<link href="${ctx}/styles/common.css" rel="stylesheet" type="text/css"/>
		<link href="${ctx}/styles/core.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
    </head>
    
    <body>
    	<div id="header" >
		    <div class="top_left">
		      <a href="http://www.fclub.cn" target="_blank" hidefocus="true">&nbsp;</a>
		    </div>
			<div class="top_right">
      			<dl class="nav">
        			<dd>
          				<a class="icon_edit" href="javascript:toUpdatePassword();"><span></span>修改密码</a>
        			</dd>
        			<dd>
          				<a class="icon_reload" href="javascript:pageReload();"><span></span>刷新</a>
        			</dd>
        			<dd>
          				<a class="icon_getout" href="/logout.htm" target="_parent"><span></span>退出</a>
        			</dd>
        			<dd>
          				<a class="icon_hezuo" href="/cooperation.htm" target="mainFrame"><span></span>合作须知</a>
        			</dd>
        			<dd>
          				<a class="icon_help" href="/help.htm" target="mainFrame"><span></span>操作手册</a>
        			</dd>
        			<dd>
          				<a class="icon_home" href="http://www.fclub.cn" target="_blank"><span></span>网店</a>
        			</dd>
      			</dl>
      			<div class="line"></div>
      			<div class="user">
	        		<div class="picBox">
		          		<div>
		            		<img src="${ctx}/images/top/pic.png" />
		          		</div>
	        		</div>
	        		<span>Michael</span>
      			</div>
    		</div>
		</div>
		
		<script type="text/javascript">
		//按钮淡入淡出效果
		/*$('.topButton').hover(function () {
		  $(this).prev('.topButtonHover').fadeIn(0);
		  $(this).css('color','#003048');
		},function () {
		  $(this).prev('.topButtonHover').fadeOut(100);
		  $(this).removeAttr('style');
		});*/
		
		// 刷新页面
		function pageReload() {
		  window.top.frames['mainFrame'].document.location.reload();
		}
		// 头部信息显示
		var h=20,time=3000,speed=500;
		function showMsg() {
		  $('.msgBox ul').height(h);
		  setTimeout(function(){msgNum()},0);
		  var t=setInterval(function(){msgNum();gundong();},time);
		  $('.msgBox li').hover(
		    function () {clearInterval(t)},
		    function () {t=setInterval(function(){msgNum();gundong();},time)}
		  );
		}
		// 判断信息数量
		function msgNum() {
		  if ($('.msgBox li').length>0){$('.msgBox').show();}else {$('.msgBox').hide();}
		}
		// 轮播滚动函数
		function gundong(){
		  if ($('.msgBox li').length>1){
		    $('.msgBox li:eq(0)').animate({marginTop:-h},speed,function () {
		      $(this).removeAttr('style');
		      $('.msgBox ul').append($(this));
		    });
		  }
		}
		showMsg();
		
		function toUpdatePassword() {
			window.top.frames['mainFrame'].document.location.href = "/passwordTo.htm";
		}
		</script>
    </body>
</html>