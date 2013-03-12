/**
 * 
 */
ajaxDelete = function(deleteUrl, succeedUrl) {
	if (confirm("确定删除？")) {
		$.ajax({
			type: "DELETE",
			url: "${WEBAPP_DOMAIN}" + deleteUrl,
			success: function(result) {
				window.location.replace("${WEBAPP_DOMAIN}" + succeedUrl);
			}
		});
	}
}