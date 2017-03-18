<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<c:if test="${empty page.list }">
	暂无记录
</c:if>
<c:forEach items="${page.list}" var="chapter" varStatus="s">
	<li>
	<font class="title-prefix">■</font>
	<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
	<c:if test="${s.count%5==0}">
		<li class="devider"></li>
	</c:if>
</c:forEach>