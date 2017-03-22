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
	  		<div class="main-content" style="text-align: center;">
	  		
	  			
	  			<div style="margin:80px auto 0px auto;min-height:500px;width:1035px;padding-bottom:30px;border-bottom:1px solid #ddd;">
	  		
	  				<div style="width:335px;min-height:485px;margin-top:45px;float:right;text-align:right;">
			  		<div style="border:1px solid #ddd;min-height:485px;text-align:center;">
			  		
			  			<div class="module-title" style="width:115px;height:123px;margin-top:-40px;margin-left:120px;background: #fff;">
			  				<div class="module-title-div">
			  					<div class="module-title-div-img new">
			  					</div>
			  				</div>
			  			</div>
			  			
			  			
			  			<ul class="more-list">
			  				<c:forEach items="${hotInfos}" var="info">
			  				<li>
			  					<a href="${basePath}f/info-view.do?key=${info.manageKey}"><n:shorthand length="30" content="${info.title}"></n:shorthand></a>
			  				</li>
			  				</c:forEach>
			  				
			  			</ul>
			  		
			  		</div>
			  		<div class="more-btn">
			  		<a href="${basePath}f/info.do#content">
			  		阅读更多
			  		</a>
			  		</div>
			  		</div>
			  		
			  		
			  		<div class="article-div">
			  		
			  			<h1 class="article-title">
							${info.title }		  			
			  			</h1>
			  			
			  			<span class="article-info">中国星品牌 &nbsp;&nbsp;<fmt:formatDate value="${info.createTime}" pattern="yyyy/MM/dd hh:mm"/></span>
			  			
			  			
			  			<div class="article-content">
			  				
			  				<n:html value="${info.content}"></n:html>
			  				
			  			</div>
			  		
			  		</div>
	  			
	  			</div>
	  			
	  			
	  			
	  		</div>
	  		
  		</div>
	  	
	  	<%@include file="/WEB-INF/jsp/f/common/footer.jsp" %>
 		
  </body>
</html>
