<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<title>管理员登录</title>
    </head>
    <body>
        <form name="userAddForm" action="${WEBAPP_DOMAIN}/login" method="post">
    		name: <input type="text" name="name" />
    		<br />
    		密码：password: <input type="password" name="password" />
    		<br />
			<input type="submit" />
			<input type="reset" />
		</form>
    </body>
</html>