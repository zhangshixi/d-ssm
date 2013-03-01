<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title>ç¼è¾ç¨æ·</title>
    </head>
    <body>
		<form name="userEditForm" action="${WEBAPP_DOMAIN}/user/$!{user.id}" method="post">
			<input type="hidden" name="_method" value="put" />
			
    		name: <input type="text" name="name" value="$!{user.name}" />
    		<br>
    		password: <input type="input" name="password" value="$!{user.password}" />
    		<br>
    		email: <input type="email" name="email" value="$!{user.email}" />
			<br />
			<input type="submit" />
		</form>
    </body>
</html>