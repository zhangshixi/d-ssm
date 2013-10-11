<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Admin show</title>
</head>

<body>

	<form id="editForm" name="editForm" method="post" action="${ctx}/admin/${target.id}">
		<input type="hidden" name="_method" value="PUT" />
		
		Login name: ${target.loginName}<br />
		Real name: ${target.realName}<br />
		Email: ${target.email}<br />
		Mobile: ${target.mobile}<br />
		Locked: ${target.locked}
	</form>

</body>
</html>