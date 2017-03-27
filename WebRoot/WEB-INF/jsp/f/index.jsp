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
	  					<div class="module-title-div-img c-orange">
	  					</div>
	  				</div>
	  			</div>
	  			
	  			<div class="honeycomb-row">
	  			
	  				<div class="honeycomb xinshijue">
	  					<div  class="big-title">
	  						<span>新视觉</span>
	  					</div>
	  					<div class="sub-title">
	  						<span >NEW PERSPECTIVE</span>
	  					</div>
	  				</div>
	  			
	  				<div class="honeycomb shenghuo">
	  					<div  class="big-title">
	  						<span>生活志</span>
	  					</div>
	  					<div class="sub-title">
	  						<span >LIFE STORY</span>
	  					</div>
	  				</div>
	  			
	  				<div class="honeycomb guangyin">
	  					<div  class="big-title">
	  						<span>匠人心</span>
	  					</div>
	  					<div class="sub-title">
	  						<span >CARPENTER'S HEART</span>
	  					</div>
	  				</div>
	  			</div>
	  			
	  			<div style="text-align:center;margin-top:20px;">
	  				<div class="more-circle gray"><a href="${basePath}f/column.do">更多</a></div>
	  			</div>
		  		
	  		</div>
	  		
  		</div>
  		
  		
  		<div class="container" style="background: #bbb7b6;">
	  		<div class="main-content">
	  			
	  			<div class="module-title" style="margin-top:20px;padding-top:50px;">
	  				<div class="module-title-div">
	  					<div class="module-title-div-img s-red">
	  					</div>
	  				</div>
	  			</div>
	  			
	  			<div class="style-warp" style="text-align:left;">
	  				<c:forEach items="${topStyles}" var="style">
		  				<div class="style-item">
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
		  					<span class="style-title">
		  					<n:shorthand length="15" content="${style.title}"></n:shorthand>
		  					</span>
		  					</a>
		  					<span class="style-sub-title"><n:shorthand length="15" content="${style.corporateName}"></n:shorthand></span>
		  				</div>
	  				</c:forEach>
	  				
	  			</div>
	  			
	  			<div style="text-align:center;margin-top:20px; padding-bottom:20px;">
	  				<div class="more-circle white"><a href="${basePath}f/style.do">更多</a></div>
	  			</div>
	  			
	  		</div>
	  	</div>
	  	
	  	<div class="container" style="margin:20px 0px 0px 0px;">
	  		<div class="main-content">
	  			
	  			<div class="module-title" style="margin-top:50px;">
	  				<div class="module-title-div">
	  					<div class="module-title-div-img i-orange">
	  					</div>
	  				</div>
	  			</div>
	  			
	  			
	  			<div style="text-align:left;margin-top:50px;margin-bottom:0px;">
	  			
	  				<div class="info-title-img">
	  					<c:choose>
	  					<c:when test="${not empty siteSetting.infoHeaderPic }">
	  						<img src="${basePath}filee/viewPic.do?manageKey=${siteSetting.infoHeaderPic.manageKey}" style="width:540px;height:447px;"/>
	  					</c:when>
	  					<c:otherwise>
		  					<img src="${basePath}resource/f/theme/default/css/img/info-demo.png" style="width:540px;height:447px;"/>
	  					</c:otherwise>
	  					</c:choose>
	  				</div>
	  				
	  				<div class="time-line">
	  					<div class="line"></div>
	  					
	  					
	  					<table class="time-set" style="float:right;" border="0">
	  						<c:forEach items="${topInfos}" var="info">
		  						<tr>
		  							<td>
		  								<div class="time-value">
			  								<span class="time-year"><fmt:formatDate value="${info.createTime}" pattern="yyyy"/></span>
			  								<span class="time-month">
			  								<fmt:formatDate value="${info.createTime}" pattern="MM/dd"/>
			  								</span>
			  							</div>
		  							</td>
		  							
		  							<td>
		  								<span class="time-circle"></span>
		  							</td>
		  							
		  							<td>
		  								<div class="time-content">
			  								<span class="time-title">
			  								<a href="${basePath}f/info-view.do?key=${info.manageKey}" target="_blank">
			  								<n:shorthand length="26" content="${info.title}"></n:shorthand>
			  								</a>
			  								</span>
			  								<span class="time-detail">
			  									<n:shorthand length="33" content="${info.abstractContent}"></n:shorthand>
			  								</span>
			  							</div>
		  							</td>
		  						</tr>
		  					</c:forEach>
	  					</table>
	  					
	  				</div>
	  				
	  			</div>
	  			
	  			
	  			<div style="text-align:center;margin-top:0px; padding-bottom:50px;position: relative;">
	  				<div class="more-circle orange" style=""><a href="${basePath}f/info.do">更多</a></div>
	  			</div>
	  			
	  		</div>
	  	</div>
	  	
	  	<%@include file="/WEB-INF/jsp/f/common/footer.jsp" %>
 		
  </body>
</html>
