<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<title>log</title>
    	
		<style type="text/css">
			.loading{width:16px; height:16px; display:block; overflow:hidden; background:url(http://img.tfclub.cn/images/index/preload.gif); position:relative; margin-left:0px; z-index: 99999;}
		</style>
		
    	<script type="text/javascript" src="${ctx}/scripts/jquery/jquery.js"></script>
    	<script type="text/javascript" src="${ctx}/scripts/util.js"></script>
    	<script type="text/javascript">
	        jQuery().ready(function() {
	        	
// 	        	var pos = "${pos}";
        		var id = window.setInterval(function() {
	        		jQuery.ajax({
	        			type: "POST",
	        			url: "${ctx}/log/${name}/0",
	        			success: function(result) {
// 	        				if (!isEmpty(result)) {
// 		        				pos = parseInt(pos) + result.length;
// 	        				}
	            			jQuery("#log").append(result + "<br/>");
	    					window.scrollTo(0, document.body.clientHeight);
	        			}
	        		});
        		}, 2000);
	        	
	        	jQuery(document).keydown(function(event) {
	        		if (event.ctrlKey && event.which === 67) {
	        			window.clearInterval(id);
	        			$(".loading").hide();
	        		}
	        	});
	        });
	    </script>
    </head>

    <body>
    	
        <div id="log"></div>
        <div class="loading"></div>
    
    </body>
</html>