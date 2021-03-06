<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
		      <a href="http://www.fclub.cn" target="_blank">&nbsp;</a>
		    </div>
		    
		    <div class="msgBoxDiv">
	    	</div>
		    
			<div class="top_right">
      			<dl class="nav">
        			<dd>
          				<a class="icon_reload" href="javascript:pageReload();"><span></span>刷新页面</a>
        			</dd>
        			<dd>
          				<a class="icon_edit" href="${ctx}/admin/<shiro:principal property="id" />/password" onclick="return toEditPassword(this);"><span></span>修改密码</a>
        			</dd>
        			<dd>
          				<a class="icon_getout" href="${ctx}/logout" target="_parent"><span></span>退出</a>
        			</dd>
        			<dd>
          				<a class="icon_help" href="${ctx}/help" target="mainFrame"><span></span>帮助手册</a>
        			</dd>
        			<dd>
          				<a class="icon_hezuo" href="/cooperation.htm" target="mainFrame"><span></span>合作须知</a>
        			</dd>
        			<dd>
          				<a class="icon_home" href="http://www.fclub.cn" target="_blank"><span></span>网站</a>
        			</dd>
      			</dl>
      			<div class="line"></div>
      			<div class="user">
	        		<div class="picBox">
		          		<div>
		            		<img src="${ctx}/images/top/pic.png" />
		          		</div>
	        		</div>
	        		<span><shiro:user><shiro:principal property="loginName" /></shiro:user></span>
      			</div>
    		</div>
		</div>
		
		<script type="text/javascript">
			function pageReload() {
			  window.top.frames['mainFrame'].document.location.reload();
			}
			
			function toEditPassword(target) {
                window.top.frames['mainFrame'].document.location.href = target.href;
                return false;
			}
		</script>
    </body>
</html>