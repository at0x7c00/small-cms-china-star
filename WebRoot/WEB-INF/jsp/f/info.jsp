<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title> ${systemTitle}-首页 </title>
		<%@include file="/WEB-INF/jsp/f/common/resource.jsp" %>
  	</head>
   
  <body>
  		
		<%@include file="/WEB-INF/jsp/f/common/header.jsp" %>
  		
  		<div class="container">
	  		<div class="main-content">
	  		
	  			<div class="module-title" style="margin-top:70px;">
	  				<div class="module-title-div">
	  					<div class="module-title-div-img release-orange">
	  					</div>
	  				</div>
	  			</div>
	  			
	  			
	  			<div class="" style="margin-bottom:50px;">
	  			    <a name="content"></a>
	  				<c:forEach items="${page.list}" var="info">
	  					<div class="info">
	  						<div class="info-img">
	  							<c:choose>
	  								<c:when test="${empty info.cover }">
	  									<img src="${basePath}resource/f/theme/default/css/img/285x160.png" width="285px" height="160px"/>
	  								</c:when>
	  								<c:otherwise>
	  									<img src="${basePath}filee/viewPic.do?manageKey=${info.cover.manageKey}" width="285px" height="160px"/>
	  								</c:otherwise>
	  							</c:choose>
	  						</div>
	  						<div class="info-div">
	  							<div class="info-circle"></div>
	  							<h1 class="info-title">
	  							<a href="${basePath}f/info-view.do?key=${info.manageKey}" target="_blank">
	  							<n:shorthand length="30" content="${info.title}"></n:shorthand>
	  							</a>
	  							</h1>
	  							<p class="info-content">
	  							<n:shorthand length="55" content="${info.abstractContent}"></n:shorthand>
	  							</p>
	  							<div style="margin-top:10px;">
	  							<span class="date"><fmt:formatDate value="${ info.createTime }" pattern="yyyy/MM/dd"/></span>
	  							</div>
	  						</div>
		  				</div>
	  				</c:forEach>
	  			</div>
	  			
	  			<div>
					<jsp:include page="/WEB-INF/jsp/f/common/pageBar.jsp">
						<jsp:param value="f/info.do" name="url"/>
					</jsp:include>		
	  			</div>
	  		</div>
	  		
  		</div>
	  	
	  	<%@include file="/WEB-INF/jsp/f/common/footer.jsp" %>
 		
  </body>
</html>
