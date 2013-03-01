<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="header" class="row">
	
	<div><h1>MJEE-SSM-WEB HEADER</small></h1></div>
	
	<div class="pull-right">
		<shiro:guest><a href="${ctx}/login">ç»å½</a></shiro:guest>
		<shiro:user>ä½ å¥½, <shiro:principal property="name"/> <a href="${ctx}/logout">éåºç»å½</a></shiro:user>
	</div>
	
</div>