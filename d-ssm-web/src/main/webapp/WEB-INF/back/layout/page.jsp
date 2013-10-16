<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="pageDiv" class="list_b">
	<div class="left">
		第<span class="bold red">${page.pageIndex}</span>页，
		共<span class="bold red" id="totalPages">${page.totalPage}</span>页，
		<span class="bold red">${page.totalData}</span>条，
		每页显示
		<select id="changePageSize" onchange="changePageSize();">
			<option value="2" <c:if test="${page.pageSize == 2}">selected="selected"</c:if>>2</option>
			<option value="10" <c:if test="${page.pageSize == 10}">selected="selected"</c:if>>10</option>
			<option value="20" <c:if test="${page.pageSize == 20}">selected="selected"</c:if>>20</option>
			<option value="50" <c:if test="${page.pageSize == 50}">selected="selected"</c:if>>50</option>
		</select>
	</div>
	<div class="right list_bottom list_b">
    	<a <c:if test="${page.firstPage}">class="gray"</c:if>
    	   <c:if test="${!page.firstPage}">href="javascript:jumpToPage(1);"</c:if>
    	>首页</a>
		<a <c:if test="${page.firstPage}">class="gray"</c:if>
		   <c:if test="${!page.firstPage}">href="javascript:jumpToPage(${page.pageIndex - 1});"</c:if>
		>上一页</a>
        <a <c:if test="${page.lastPage}">class="gray"</c:if>
    	   <c:if test="${!page.lastPage}">href="javascript:jumpToPage(${page.pageIndex + 1});"</c:if>
		>下一页</a>
		<a <c:if test="${page.lastPage}">class="gray"</c:if>
    	   <c:if test="${!page.lastPage}">href="javascript:jumpToPage(${page.totalPage});"</c:if>
		>尾页</a>
        <input type="text" class="input" id="jumpToPage" style="width:30px;">
    	<a class="button" href="javascript:jumpToPage();">GO</a>
	</div>
</div>