<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title>电子商务平台统一分销系统</title>
		
		<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
		<script type="text/javascript">
			if (top.location != self.location) {
			    top.location = self.location; 
			}
		</script>
    </head>
    
<!-- <body> -->
   	<frameset rows="60,*" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src="${ctx}/frame/top" id="topFrame" name="topFrame" scrolling="no" noresize="noresize" />
		<frameset cols="210,15,*" frameborder="no" border="0" framespacing="0" id="myFrame" name="myFrame">
			<frame src="${ctx}/frame/left" id="leftFrame" name="leftFrame" scrolling="auto" noresize="noresize" />
			<frame src="${ctx}/frame/middle" id="midFrame" name="midFrame" scrolling="no" noresize="noresize" />
			<frame src="${ctx}/admin" id="mainFrame" name="mainFrame" scrolling="auto" noresize="noresize" />
		</frameset>
	</frameset>
<!-- </body> -->

</html>