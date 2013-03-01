<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		<title>User List</title>
    </head>
    <body>
		pageIndex: $!{pageResult.pageIndex}
		<br>
		pageSize: $!{pageResult.pageSize}
		<br>
		totalData: $!{pageResult.totalData}
		<br>
		totalPage: $!{pageResult.totalPage}
		<br>
		remainPage: $!{pageResult.remainPage}
		<br>
		toIndex: $!{pageResult.toIndex}
		<br>
		orderBy: $!{pageResult.orderBy}
		<br>
		orderType: $!{pageResult.orderType}
		<br>
		#foreach(${user} in ${pageResult.resultList})
			=========================================
    		<br>
			name: $!{user.name}
    		<br>
    		password: $!{user.password}
    		<br>
    		email: $!{user.email}
			<br>
            <a href="${WEBAPP_DOMAIN}/user/$!{user.id}/edit">ç¼è¾</a>
            <a href="#" onclick="javascript:doDeleteUser($!{user.id});">å é¤</a>
			<br>
		#end
    </body>
</html>