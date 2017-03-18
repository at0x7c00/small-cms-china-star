<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>质量档案 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
  	</head>
  
  <body>
  		<div class="container">
  			
  			<%@include file="/WEB-INF/jsp/frontend/common/logo-and-menu.jsp" %>
	  		
	  		<div style="margin:15px 0px;">
 				<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhiliang-banner.png">
 			</div>
	  		
	  		<div class="main-content">
	  		
	  			<div class="module-group blue">
	  			
	  				
	  				<div class="module-category">
	  					<div class="category-title">
	  						<a name="content"></a>
	  					</div>
	  					<div class="category-content">
	  						<c:forEach items="${categoryList }" var="c">
		  						<a href="${basePath}frontend/zhiliangdangan.do?categoryKey=${c.manageKey}#content" class="${category.manageKey eq c.manageKey ? 'active':'' }">${c.name}</a>
	  						</c:forEach>
	  					</div>
	  				</div>
	  			
		  			
		  			<div class="dangan-content">
		  			<c:if test="${empty page.list}">
		  			暂无记录.
		  			</c:if>
		  			<c:forEach items="${page.list}" var="qa">
			  			<div class="dangan-detail">
			  				<div class="dangan-item">
			  					<div class="dangan-pic">
			  						<c:if test="${not empty qa.cover }">
				  						<a href="${basePath}frontend/danganDetail.do?manageKey=${qa.manageKey}" target="_blank">
					  						<img alt="" src="${basePath}filee/viewPic.do?manageKey=${qa.cover.manageKey}"/>
				  						</a>
			  						</c:if>
			  					</div>
			  					<div class="dangan-abstract" length="37">
			  						<a href="${basePath}frontend/danganDetail.do?manageKey=${qa.manageKey}" target="_blank">
			  						<n:shorthand length="37" content="${qa.abstractContent}"></n:shorthand>&nbsp;
			  						</a>
			  					</div>
			  				</div>
			  			</div>
			  			
		  			</c:forEach>
			  			<jsp:include page="/WEB-INF/jsp/frontend/common/pageBar.jsp">
		  				 	<jsp:param value="${page}" name="page"/>
		  				 	<jsp:param value="frontend/zhiliangdangan.do" name="url"/>
		  				 	<jsp:param value="categoryKey=${category.manageKey}" name="params"/>
		  				 </jsp:include>
		  			</div>
		  			
	  			</div>
	  			
		  		
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
  </body>
</html>
