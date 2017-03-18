<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>${p.title}- ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
  	</head>
  
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/logo-and-menu.jsp" %> 
	  		
	  		<div class="main-content">
	  			<div class="module-group">
		  			<div class="module left lg" style="background: #fff;">
		  				<div class="module-title">
		  					<a name="content"></a>
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<div class="module-content" style="margin:10px 35px;">
		  					
		  					<div class="chapter-title">
			  					<h1>
			  					${p.title}
			  					</h1>
			  					<div class="chapter-info">
			  					来源：质量维护工程 &nbsp;&nbsp;&nbsp;&nbsp;发布时间：<fmt:formatDate value="${p.createTime}" pattern="yyyy/MM/dd HH:mm"/>
			  					</div>
		  					</div>
		  					
		  					<div class="chapter-content">
		  						<n:html value="${p.content}"/>
		  					</div>
		  					
		  					
		  					
		  				</div>
		  				
		  				
		  			</div>
		  			
		  			<div class="module right blue" style="background: #fff;">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhiliangredian-left.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhiliangredian.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${zhiliangredianList}" var="chapter">
		  						<%@include file="/WEB-INF/jsp/frontend/common/left-panel-list.jsp" %> 
		  					</c:forEach>
		  				</ul>
		  			</div>
		  			
		  			
		  			<div class="module right blue white" style="margin-top:25px;">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/rewen.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more top10" href="${basePath}frontend/hangyezixun.do"></a>
		  				</div>
		  				<ul class="module-content indexed">
		  					<c:forEach items="${top10ChapterList}" var="chapter" varStatus="s"> 
			  					<li>
			  					<span class="index">${s.count}</span><a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="20" content="${chapter.title}"></n:shorthand> </a>
			  					</li>
		  					</c:forEach>
		  				</ul>
		  			</div>
	  			</div>
		  		
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
  </body>
</html>
