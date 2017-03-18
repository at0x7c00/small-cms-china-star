<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>政策动态 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
  	</head>
  
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group">
		  			<div class="module left lg">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhengce.png">
		  					<a name="content"></a>
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<ul class="module-content">
		  					<%@include file="/WEB-INF/jsp/frontend/common/pageContent.jsp" %>
		  				</ul>
		  				
		  				 <jsp:include page="/WEB-INF/jsp/frontend/common/pageBar.jsp">
		  				 	<jsp:param value="${page}" name="page"/>
		  				 	<jsp:param value="frontend/zhengcedongtai.do" name="url"/>
		  				 </jsp:include>
		  				
		  			</div>
		  			
		  			<div class="module right blue">
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
		  			
		  			
		  			<div class="module right blue" style="margin-top:25px;">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/hangye-left.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/hangyezixun.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${hangyezixunList}" var="chapter"> 
		  						<%@include file="/WEB-INF/jsp/frontend/common/left-panel-list.jsp" %>
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
