window.onload = function(){
	searchPage();
};

searchPage = function() {
	$("#searchForm").ajaxSubmit(function(result){
		$("#searchResult").html(result);
	});
};