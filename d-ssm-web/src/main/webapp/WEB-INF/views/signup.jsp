<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<title>Signup</title>
    </head>
	
    <body>
        <form name="userAddForm" action="${WEBAPP_DOMAIN}/signup" method="post">
    		name: <input type="text" name="name" />
    		<br>
    		password: <input type="password" name="password" />
    		<br>
    		email: <input type="email" name="email" />
			<input type="submit" />
			<input type="reset" />
		</form>
    </body>
</html>