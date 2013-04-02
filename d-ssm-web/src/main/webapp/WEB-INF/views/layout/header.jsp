<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="header" class="row">
	
	<div>header</div>
	
	<div class="pull-right">
		<shiro:guest><a href="${ctx}/login">个人中心</a></shiro:guest>
		<shiro:user>欢迎您，<shiro:principal property="name" /> <a href="${ctx}/logout">退出</a></shiro:user>
	</div>
	
</div>