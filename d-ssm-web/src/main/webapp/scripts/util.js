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






function jumpPage(pageNo) {
	$("#pageNo").val(pageNo);
	$("#pageSize").val($("#selePageSize").val());
	TB_showMaskLayer("正在查询...");
	$("#searchForm").ajaxSubmit(function(result) {
		$("#contentPanel").html(result);
		TB_removeMaskLayer();
	});
}
function jumpPageTo() {
	var index = $("#pageTo").val();
	index = parseInt(index);
	if (index > 0) {
		jumpPage(index);
	}
}
function changePageSize() {
	$("#pageSize").val($("#selePageSize").val());
	TB_showMaskLayer("正在查询...");
	$("#searchForm").ajaxSubmit(function(result) {
		$("#contentPanel").html(result);
		TB_removeMaskLayer();
	});
}
function sortBy(column) {
	if ($("#order") == null || $("#orderBy") == null) {
		return;
	}
	var orderClass;
	var order = $("#order").val();
	if (order == 'asc') {
		$("#order").val('desc');
		orderClass = "sequenceDown";
	} else {
		$("#order").val('asc');
		orderClass = "sequenceUp";
	}
	$("#orderBy").val(column);
	TB_showMaskLayer("正在查询...");
	$("#searchForm").ajaxSubmit(function(result) {
		$("#contentPanel").html(result);
		column = column.substring(column.lastIndexOf(".") + 1);
		$("#dataTable th a[class^='sequence']").not("#"+column).removeClass().addClass("sequenceDef");
		$("#"+column).removeClass().addClass(orderClass);
		TB_removeMaskLayer();
	});
}