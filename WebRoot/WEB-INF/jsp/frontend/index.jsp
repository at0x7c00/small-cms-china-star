<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title> ${systemTitle}-首页 </title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
		
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}js/image-flow/style.css">
		<script src="${basePath}js/image-flow/image-flow.js"></script>
  	</head>
   
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group"  style="min-height:370px;">
		  			<div class="module left">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhengce.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhengcedongtai.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${zhengcedongtaiList}" var="chapter">
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
		  					</c:forEach>
		  				</ul>
		  			</div>
		  			
		  			<div class="module right">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhiliangredian.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhiliangredian.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${zhiliangredianList}" var="chapter">
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
		  					</c:forEach>
		  				</ul>
		  			</div>
	  			</div>
	  			
	  			<div class="ad-group">
	  				<div class="ad left">
	  					<a href="${ adList[0].url}" target="_blank" title="${adList[0].title }">
		  					<img src="${basePath}filee/viewPic.do?manageKey=${adList[0].picture.manageKey}" />
	  					</a>
	  				</div>
	  				<div class="ad right">
	  					<a href="${ adList[1].url}" target="_blank" title="${adList[1].title }">
	  						<img src="${basePath}filee/viewPic.do?manageKey=${adList[1].picture.manageKey}" />
	  					</a>
	  				</div>
	  			</div>
	  			
	  			<div class="module-group">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/huiyuan.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/huiyuanfengcai.do"></a>
		  				</div>
		  				<div>	
		  					<table width="100%" border="0">
		  						<tr>
		  							<td width="590px" style="text-align:center;">
		  								<a href="${basePath}frontend/chapterDetail.do?k=${huiyuanfengcaiList[0].manageKey}" target="_blank">
				  								<img alt="" style="width:550px;height:270px;" src="${basePath}filee/viewPic.do?manageKey=${huiyuanfengcaiList[0].cover.manageKey}">
		  								</a>
		  							</td>
		  							<td>
		  								<ul class="module-content" style="padding-left:5px;">
						  					<c:forEach items="${huiyuanfengcaiList}" var="chapter">
							  					<li>
							  					<font class="title-prefix">■</font>
							  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
						  					</c:forEach>
						  				</ul>
		  							</td>
		  						</tr>
		  					</table>
		  				</div>
		  			</div>
		  		</div>
		  		
		  		<div class="module-group" style="min-height:243px;">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhiliangdangan.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhiliangdangan.do"></a>
		  				</div>
		  				
		  				<div class="module-content" style="padding-bottom:10px;position:relative;" >
		  				
		  				
		  				<span id="btn-left" class="btn btn-left"></span>
		  				<span id="btn-right" class="btn btn-right"></span>
					  <div id="image-flow">
					    <ul id="image-flow-ul">
					      <c:forEach items="${qualityArchiveList }" var="qa">
					      	<li>
					      	<a href="${basePath}frontend/danganDetail.do?manageKey=${qa.manageKey}" target="_blank" title="${qa.title}">
					      	<img src="${basePath}filee/viewPic.do?manageKey=${qa.cover.manageKey}">
					      	</a>
					      	<a href="${basePath}frontend/danganDetail.do?manageKey=${qa.manageKey}" target="_blank" title="${qa.title}">
							<span>
							<n:shorthand length="14" content="${qa.title}"></n:shorthand>
							</span>					
							</a>
					      	</li>
					      </c:forEach>
					    </ul>
					  </div>
		  				
		  				
		  				</div>
		  				
		  			</div>
		  		</div>
		  		
		  		<div class="module-group">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/hangye.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/hangyezixun.do"></a>
		  				</div>
		  				<ul class="module-content bordered">
		  					<c:forEach items="${hangyezixunList}" var="chapter"> 
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="50" content="${chapter.title}"></n:shorthand> </a>
			  					<span class="publish-date"><fmt:formatDate value="${chapter.createTime}" pattern="yyyy/MM/dd"/></span>
			  					</li>
		  					</c:forEach>
		  				</ul>
		  			</div>
		  		</div>
		  		
		  		<div class="module-group"  style="min-height:73px;">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/youqing.png">
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<div class="module-content">
		  					<c:forEach items="${flinkList}" var="flink">
			  					<a href="${flink.url}" target="_blank">${flink.name}</a>
		  					</c:forEach>
		  				</div>
		  			</div>
		  		</div>
		  		
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
 		
  </body>
</html>
