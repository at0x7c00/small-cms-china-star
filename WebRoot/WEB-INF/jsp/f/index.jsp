<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title> ${systemTitle}-首页 </title>
		<%@include file="/WEB-INF/jsp/f/common/resource.jsp" %>
  	</head>
   
  <body>
  		<div class="big-banner">
  			<c:if test="${(not empty siteSetting.headerPic) and siteSetting.headerPic.video}">
	  			<div class="video-div">
	  				<video autoplay="autoplay" loop="loop">
	  					<source src="${basePath}resource/video/home-video-bg.mp4" type="video/mp4" >
	  				</video>
	  			</div>
	  			<div class="video-div-mask"></div>
  			</c:if>
  		</div>
  		
  		<div class="menu-bar" data-request="${_request_url}">
  			<ul>
  				<li>
  					<div class="logo"></div>
  				</li>
  				<li>
  					<a href="${basePath}f/index.do">首&nbsp;&nbsp;页</a>
  				</li>
  				<li>
  					<a href="#">栏目介绍</a>
  				</li>
  				<li>
  					<a href="#">企业风采</a>
  				</li>
  				<li>
  					<a href="#">资&nbsp;&nbsp;讯</a>
  				</li>
  			</ul>
  		</div>
  		
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
	  				<div class="more-circle gray">更多</div>
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
	  			
	  			<div class="style-warp">
	  				<div class="style-item">
	  					<div class="play-btn"></div>
	  					<a href="">
	  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
	  					</a>
	  					<a href="#">
	  					<span class="style-title">激发智慧无限潜能</span>
	  					</a>
	  					<span class="style-sub-title">无锡云尚优课教育咨询有限公司</span>
	  				</div>
	  				
	  				<div class="style-item">
	  					<div class="play-btn"></div>
	  					<a href="">
	  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
	  					</a>
	  					<a href="#">
	  					<span class="style-title">激发智慧无限潜能</span>
	  					</a>
	  					<span class="style-sub-title">无锡云尚优课教育咨询有限公司</span>
	  				</div>
	  				
	  				<div class="style-item">
	  					<div class="play-btn"></div>
	  					<a href="">
	  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
	  					</a>
	  					<a href="#">
	  					<span class="style-title">激发智慧无限潜能</span>
	  					</a>
	  					<span class="style-sub-title">无锡云尚优课教育咨询有限公司</span>
	  				</div>
	  				
	  				<div class="style-item">
	  					<div class="play-btn"></div>
	  					<a href="">
	  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
	  					</a>
	  					<a href="#">
	  					<span class="style-title">激发智慧无限潜能</span>
	  					</a>
	  					<span class="style-sub-title">无锡云尚优课教育咨询有限公司</span>
	  				</div>
	  				
	  				
	  				<div class="style-item">
	  					<div class="play-btn"></div>
	  					<a href="">
	  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
	  					</a>
	  					<a href="#">
	  					<span class="style-title">激发智慧无限潜能</span>
	  					</a>
	  					<span class="style-sub-title">无锡云尚优课教育咨询有限公司</span>
	  				</div>
	  				
	  				<div class="style-item">
	  					<div class="play-btn"></div>
	  					<a href="">
	  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
	  					</a>
	  					<a href="#">
	  					<span class="style-title">激发智慧无限潜能</span>
	  					</a>
	  					<span class="style-sub-title">无锡云尚优课教育咨询有限公司</span>
	  				</div>
	  				
	  				<div class="style-item">
	  					<div class="play-btn"></div>
	  					<a href="">
	  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
	  					</a>
	  					<a href="#">
	  					<span class="style-title">激发智慧无限潜能</span>
	  					</a>
	  					<span class="style-sub-title">无锡云尚优课教育咨询有限公司</span>
	  				</div>
	  				
	  				<div class="style-item">
	  					<div class="play-btn"></div>
	  					<a href="">
	  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
	  					</a>
	  					<a href="#">
	  					<span class="style-title">激发智慧无限潜能</span>
	  					</a>
	  					<span class="style-sub-title">无锡云尚优课教育咨询有限公司</span>
	  				</div>
	  			</div>
	  			
	  			<div style="text-align:center;margin-top:20px; padding-bottom:20px;">
	  				<div class="more-circle white">更多</div>
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
	  					<img src="${basePath}resource/f/theme/default/css/img/info-demo.png"/>
	  				</div>
	  				
	  				<div class="time-line">
	  					<div class="line"></div>
	  					
	  					
	  					<table class="time-set" style="float:right;" border="0">
	  						<tr>
	  							<td>
	  								<div class="time-value">
		  								<span class="time-year">2017</span>
		  								<span class="time-month">01/20</span>
		  							</div>
	  							</td>
	  							
	  							<td>
	  								<span class="time-circle"></span>
	  							</td>
	  							
	  							<td>
	  								<div class="time-content">
		  								<span class="time-title">需求沟通</span>
		  								<span class="time-detail">
		  									倾听客户需求，了解用户使用环境和操作流程。倾听客户需求，了解用户使用环境和…
		  								</span>
		  							</div>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td>
	  								<div class="time-value">
		  								<span class="time-year">2017</span>
		  								<span class="time-month">01/20</span>
		  							</div>
	  							</td>
	  							
	  							<td>
	  								<span class="time-circle"></span>
	  							</td>
	  							
	  							<td>
	  								<div class="time-content">
		  								<span class="time-title">需求沟通</span>
		  								<span class="time-detail">
		  									倾听客户需求，了解用户使用环境和操作流程。倾听客户需求，了解用户使用环境和…
		  								</span>
		  							</div>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td>
	  								<div class="time-value">
		  								<span class="time-year">2017</span>
		  								<span class="time-month">01/20</span>
		  							</div>
	  							</td>
	  							
	  							<td>
	  								<span class="time-circle"></span>
	  							</td>
	  							
	  							<td>
	  								<div class="time-content">
		  								<span class="time-title">需求沟通</span>
		  								<span class="time-detail">
		  									倾听客户需求，了解用户使用环境和操作流程。倾听客户需求，了解用户使用环境和…
		  								</span>
		  							</div>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td>
	  								<div class="time-value">
		  								<span class="time-year">2017</span>
		  								<span class="time-month">01/20</span>
		  							</div>
	  							</td>
	  							
	  							<td>
	  								<span class="time-circle"></span>
	  							</td>
	  							
	  							<td>
	  								<div class="time-content">
		  								<span class="time-title">需求沟通</span>
		  								<span class="time-detail">
		  									倾听客户需求，了解用户使用环境和操作流程。倾听客户需求，了解用户使用环境和…
		  								</span>
		  							</div>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td>
	  								<div class="time-value">
		  								<span class="time-year">2017</span>
		  								<span class="time-month">01/20</span>
		  							</div>
	  							</td>
	  							
	  							<td>
	  								<span class="time-circle"></span>
	  							</td>
	  							
	  							<td>
	  								<div class="time-content">
		  								<span class="time-title">需求沟通</span>
		  								<span class="time-detail">
		  									倾听客户需求，了解用户使用环境和操作流程。倾听客户需求，了解用户使用环境和…
		  								</span>
		  							</div>
	  							</td>
	  						</tr>
	  					</table>
	  					
	  				</div>
	  				
	  			</div>
	  			
	  			
	  			<div style="text-align:center;margin-top:0px; padding-bottom:50px;position: relative;">
	  				<div class="more-circle orange" style="">更多</div>
	  			</div>
	  			
	  		</div>
	  	</div>
	  	
	  	
	  	
	  	<div class="container" style="background:#000;margin:20px 0px 0px 0px;">
	  		<div class="main-content">
	  			<div class="module-title" style="padding-top:50px;">
	  				<div class="module-title-div">
	  					<div class="module-title-div-img co-red">
	  					</div>
	  				</div>
	  			</div>
	  			
	  			<div style="text-align:center;color:#969495;font-size:12px;letter-spacing:2px;line-height:1.7em;">
	  				邮箱/Mail<br/>
	  				yingxiaoguanli@cctv-ppll.com
	  			</div>
	  			
	  			<div style="text-align:center;margin-top:40px;padding-bottom:40px;">
	  				<div style="width:270px;display:inline-block;margin:0px auto;">
		  				<span class="contact-phone"></span><span class="contact-tel">400-827-1616</span>
		  			</div> 
	  			</div>
	  		</div>
	  	</div>
 		
  </body>
</html>
