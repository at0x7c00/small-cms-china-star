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
	  					<div class="module-title-div-img style-orange">
	  					</div>
	  				</div>
	  			</div>
	  			
	  			
	  			<div class="a-style-warp" style="margin-top:30px;">
	  			<a name="content"></a>
	  				<div>
	  				<c:forEach items="${page.list}" var="style" varStatus="x">
	  					<div class="a-style-item index-${x.count%3}">
		  					<div class="play-btn" data-styleid="${style.manageKey}"></div>
		  					<a href="javascript:void(0);" data-styleid="${style.manageKey}">
		  					<c:choose>
		  						<c:when test="${empty style.cover }">
				  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
		  						</c:when>
		  						<c:otherwise>
				  					<img alt="" src="${basePath}filee/viewPic.do?manageKey=${style.cover.manageKey}"/>
		  						</c:otherwise>
		  					</c:choose>
		  					</a>
		  					<a href="javascript:void(0);" data-styleid="${style.manageKey}">
		  					<span class="a-style-title">
		  					<n:shorthand length="15" content="${style.title}"></n:shorthand>
		  					</span>
		  					</a>
		  					<span class="a-style-sub-title"><n:shorthand length="15" content="${style.corporateName}"></n:shorthand></span>
		  				</div>
	  				</c:forEach>
	  				</div>
	  			</div>
	  			
	  			<div>
					<jsp:include page="/WEB-INF/jsp/f/common/pageBar.jsp">
						<jsp:param value="f/style.do" name="url"/>
					</jsp:include>	
	  			</div>
	  		</div>
	  		
  		</div>
	  	
	  	<%@include file="/WEB-INF/jsp/f/common/footer.jsp" %>
 		
  </body>
</html>
