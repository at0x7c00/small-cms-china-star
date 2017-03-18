<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>会员风采 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
  	</head>
  
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/huiyuan.png">
		  					<a name="content"></a>
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<div class="module-content">
		  					<c:if test="${empty page.list }">
								暂无记录
							</c:if>
							<c:forEach items="${page.list}" var="chapter" varStatus="s">
								
								<div>
								
									<div class="img-div">
										<c:if test="${not empty chapter.cover}">
											<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}">
												<img alt="" src="${basePath}filee/viewPic.do?manageKey=${chapter.cover.manageKey}" style="width:240px;height:140px"/>
											</a>
										</c:if>
									</div>
									
									<div class="page-content">
										<h2>
										<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}">
											<n:shorthand length="30" content="${chapter.title}"></n:shorthand>
										</a>
										</h2>
										<div class="content-detail">
											<n:html value="${chapter.abstractContent}" length="110"></n:html>
										</div>
									</div>
								
									
								</div>
								
								<div class="huiyuan-devider"></div>
							</c:forEach>
		  				</div>
		  				
		  				 <jsp:include page="/WEB-INF/jsp/frontend/common/pageBar.jsp">
		  				 	<jsp:param value="${page}" name="page"/>
		  				 	<jsp:param value="frontend/huiyuanfengcai.do" name="url"/>
		  				 </jsp:include>
		  			</div>
		  			
	  			</div>
		  		
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
  </body>
</html>
