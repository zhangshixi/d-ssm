/* ---- Common utilities ---- */
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


/* ---- Restful delete method ---- */
/**
 * Delete operation.
 */
doDelete = function(target, message) {
	if (isEmpty(message)) {
		message = "确定删除？";
	}
	
	if (confirm(message)) {
		var form = document.createElement('form');
		form.style.display = 'none';
		form.setAttribute('method','POST');
		form.setAttribute('action', target.href);
		target.parentNode.appendChild(form);
		
		var input = document.createElement('input');
		input.setAttribute('type', 'hidden');
		input.setAttribute('name', '_method');
		input.setAttribute('value', 'DELETE');
		form.appendChild(input);
		
		form.submit();
	}
	
	return false;
};

/**
 * Ajax delete operation.
 */
doAjaxDelete = function(deleteUrl, succeedUrl) {
	if (confirm("确定删除？")) {
		$.ajax({
			type: "DELETE",
			url: deleteUrl,
			success: function(result) {
				window.location.replace(succeedUrl);
			}
		});
	}
};

/* ---- jquery.validate.js extends ---- */

