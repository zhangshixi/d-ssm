<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<title>log</title>
    	<script type="text/javascript">
            jQuery().ready(function() {
    			
    			function getLog() {
    				jQuery.ajax({
        				type: "POST",
                        url: "$ctx/log",
                        data: {name:$name, pos:0},
                    	success: function(result)
        					jQuery("#log").append(new Date().toString());
            			}
    				});
    			};
    			
    			function run() {
        			setInterval(getLog(), 5);
    			};
    			
    			run();
            });
        </script>
    </head>

    <body>
    	
        <div id="log"></div>
    
    </body>
</html>