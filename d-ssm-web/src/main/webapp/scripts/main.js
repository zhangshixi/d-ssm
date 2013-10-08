function doDeleteUser(userId) {
	ajaxDelete("/user/" + userId, "/user");
}