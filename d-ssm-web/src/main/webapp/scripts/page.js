window.onload = function(){
	searchPage();
};

searchPage = function() {
	$("#searchForm").ajaxSubmit(function(result){
		$("#contentPanel").html(result);
	});
};

function jumpToPage(index) {
	var pageIndex = index;
	if (isEmpty(pageIndex)) {
		pageIndex = $("#jumpToPage").val();
	}
	
	pageIndex = parseInt(pageIndex);
	if (pageIndex > 0) {
		$("input[name=pageIndex]").val(pageIndex);
		$("input[name=pageSize]").val($("#changePageSize").val());
		
		searchPage();
	}
}

function changePageSize() {
	// change to first page
	$("input[name=pageIndex]").val(1);
	$("input[name=pageSize]").val($("#changePageSize").val());
	
	searchPage();
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