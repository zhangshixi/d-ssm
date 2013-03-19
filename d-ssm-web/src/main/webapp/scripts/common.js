/**
 * Test weather given value is empty or not.
 */
isEmpty = function(value) {
	return (typeof(value) === "undefined" || value === null || value.length === 0);
};

/**
 * Parse date string (eg: 2013-03-18) to date.
 */
parseToDate = function(date) {
	return new Date(date);
};

/**
 * Parse datetime string (eg: 2013-03-18 12:23:43) to date.
 */
parseToDatetime = function(datetime) {
	return new Date(Date.parse(datetime.replace(/-/g, '/')));
};

/**
 * Gets checked radio value by name.
 */
getCheckedRadioValue = function(radioName) {
	var radioAry = document.getElementsByName(radioName);
	for( var i = 0; i < radioAry.length; i++ ) {
		if (radioAry[i].checked) {
			return radioAry[i].value;
		}
	}
};

/**
 * Ajax delete operation.
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
};