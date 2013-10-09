window.onload = function(){
	searchPage();
};

searchPage = function() {
	$("#searchForm").ajaxSubmit(function(result){
		$("#searchResult").html(result);
	});
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