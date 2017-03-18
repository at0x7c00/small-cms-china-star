<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>行业资讯 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
  	</head>
  
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/hangye.png">
		  					<a name="content"></a>
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<ul class="module-content">
		  					<c:if test="${empty page.list }">
								暂无记录
							</c:if>
							<c:forEach items="${page.list}" var="chapter" varStatus="s">
								<li>
								<font class="title-prefix blue">◆</font>
								<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a>
								<span class="publish-date" style="float:right;"><fmt:formatDate value="${chapter.createTime}" pattern="yyyy/MM/dd"/></span>
								</li>
								<li class="devider dashed"></li>
							</c:forEach>
		  				</ul>
		  				
		  				 <jsp:include page="/WEB-INF/jsp/frontend/common/pageBar.jsp">
		  				 	<jsp:param value="${page}" name="page"/>
		  				 	<jsp:param value="frontend/hangyezixun.do" name="url"/>
		  				 </jsp:include>
		  				 
		  				 
		  			</div>
		  			
	  			</div>
		  		
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
  </body>
</html>
