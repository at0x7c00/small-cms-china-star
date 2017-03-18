<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>${qa.title} - 质量档案 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
		<%--
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}js/3d-gallery/css/style.css">
		 --%>
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}resource/frontend/theme/default/css/detail.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}js/zoom-pic/css/style.css">
		
		<link href="http://vjs.zencdn.net/5.8.8/video-js.css" rel="stylesheet">

		 <!-- If you'd like to support IE8 -->
		 <script src="http://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script>
		 
		 <script src="${basePath}js/zoom-pic/js/ZoomPic.js" type="text/javascript"></script>
		 
		 <style type="text/css">
		 .video-js .vjs-big-play-button {
		    font-size: 3em;
		    line-height: 1.5em;
		    height: 1.5em;
		    width: 3em;
		    display: block;
		    position: absolute;
		    top:80%;
		    bottom: 10px;
		    left: 10px;
		    padding: 0;
		    cursor: pointer;
		    opacity: 1;
		    border: 0.06666em solid #fff;
		    background-color: #2B333F;
		    background-color: rgba(43, 51, 63, 0.7);
		    -webkit-border-radius: 0.3em;
		    -moz-border-radius: 0.3em;
		    border-radius: 0.3em;
		    -webkit-transition: all 0.4s;
		    -moz-transition: all 0.4s;
		    -o-transition: all 0.4s;
		    transition: all 0.4s;
		}
		p{
		font-size:14px;
		text-align:left;
		line-height:20px;
		text-indent: 2em;
		}
		.subfeature{
			width:205px;
			height:275px;
		}
		.stepcarousel{
			height:290px;
		}
		.scrollbut{
			display: none;
		}
		.stepcarousel .panel{
			margin:20px;
			width:205px;
		}
		 </style>
  	</head>
  
  <body>
  		<%--
  		<div class="dangan-detail-line"></div>
  		 --%>
  		<div class="dangan-detail-banner">
  		</div>
  		<div class="container">
	  
  			<div class="qute">
  				<div style="text-align:center;" class="image-devider">
		  			<img alt="" src="${basePath}resource/frontend/theme/default/css/img/qiyejianjie.png" class="img-full-page">
  				</div>
	  			<div class="dangan-detail-content">
	  				<table width="100%" border="0" style="margin-top:20px;">
	  					<tr>
	  						<td width="45%" style="text-align:right;padding-right:20px;">
	  						<c:if test="${not empty qa.detailCover }">
		  						<c:choose>
		  							<c:when test="${qa.detailCover.video }">
				  							<div style="width:434px;height:330px;float:right;">
						  						<video id="my-video" class="video-js" controls preload="auto" width="430" height="330"
											  poster="${basePath}filee/viewPic.do?manageKey=${qa.detailCover.manageKey}" data-setup="{}">
											    <source src="${basePath}filee/downloadFile.do?key=${qa.detailCover.manageKey}" type='video/mp4'>
											    <p class="vjs-no-js">
											      To view this video please enable JavaScript, and consider upgrading to a web browser that
											      <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
											    </p>
											  </video>
				  							</div>
		  							</c:when>
		  							<c:otherwise>
				  						<img alt="" src="${basePath}filee/viewPic.do?manageKey=${qa.detailCover.manageKey}" width="300" height="225">
		  							</c:otherwise>
		  						</c:choose>
	  						</c:if>
	  						</td>
	  						<td style="vertical-align: top;padding-top:20px;">
	  							<h1 style="font-size:24px;font-weight:bold;color:black;text-align: center;margin:0px 0px 20px 0px;">
	  							<n:shorthand length="30" content="${qa.title}"></n:shorthand> 
	  							</h1>
	  							<div style="padding-left:20px;">
	  							<p style="font-size:14px;text-indent: 2em;line-height:1.5em;">
	  							<n:html value="${qa.content}"/> 
	  							</p>
	  							</div>
	  						</td>
	  					</tr>
	  				</table>
	  			</div>
  			</div>
  			<div class="qute">
  				<div class="image-devider">
	  			<img alt="" src="${basePath}resource/frontend/theme/default/css/img/product.png" class="img-full-page">
  				</div>
  				
  				 <div class="gallery-box">
  				<%--
  				 <div class="gallery">
  					<div class="g-container">
  						<c:forEach items="${qa.productDisplay}" var="p">
							 <div class="img-holder">
							    <img src="${basePath}filee/viewPic.do?manageKey=${p.manageKey}">
							  	<div class="title">${p.fileNameOnly}</div>
							    <div class="img-ref">
							       <img src="${basePath}filee/viewPic.do?manageKey=${p.manageKey}">
							    </div>
							  </div>
  						</c:forEach>
					</div>
					
					<div class="scrolller-container">
					    <div class="scroller"></div>
					  </div>
					  
					  <div class="arrow left">
					  	<i class="fa fa-chevron-left"></i>
					  </div>
					  
					  <div class="arrow right">
					  	<i class="fa fa-chevron-right"></i>
					  </div>
					
				</div> 
  				--%>
				<%--
				<div class="main_flash">
				<script type="text/javascript" language="javascript">printFlash('${basePath}js/flash-3d-gallery/mainVisual.swf','1110','480','mainVisual','xml=${basePath}frontend/pictureXML/${qa.manageKey}.do&currItem=1&charset=utf-8');</script>
				</div>
				 --%>
				 <%--
				 <div id="LoopDiv">
					<input id="S_Num" type="hidden" value="8" />
					<div id="starsIF" class="imageflow"> 
						<c:forEach items="${qa.productDisplay}" var="file" varStatus="s">
						<img src="${basePath}filee/viewPic.do?manageKey=${file.manageKey }" longdesc="#" width="280" height="300" alt="Picture" /> 
						</c:forEach>
					</div>
				</div>
				<div class="clear"></div>
				  --%>
				 
						<div id="Index_Box">
						  <pre class="prev">&nbsp;</pre>
						  <pre class="next">&nbsp;</pre>
						  <ul>
							<c:forEach items="${qa.productDisplay}" var="file" varStatus="s">
						    <li><a href="javascript:void(0);"><img src="${basePath}filee/viewPic.do?manageKey=${file.manageKey }"></a>
						    <p>
						    	<span>${file.fileNameOnly }</span>
						    </p>
						    </li>
						    </c:forEach>
						  </ul>
						</div>
				  </div>
				 
  			</div>
  			<div class="qute" style="">
  					<div class="image-devider">
	  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/rongyu.png" style=""/>
  					</div>
  					
  					
  					<div style="margin-top:20px;text-aling:center;padding-left:15px;">
  					
  					
  					<div id="colee_left" style="width:1085px;overflow:hidden;">
		<table>
                    <tbody><tr>
                        <td id="colee_left1">
                            <table cellpadding="5px;">
                                <tbody><tr>
                                   <c:forEach items="${qa.gloryDisplay}" var="p">
                                    <td>
                                    <img src="${basePath}filee/viewPic.do?manageKey=${p.manageKey}" 
								alt="butterflies-are-gross" class="post-image" width="205" height="275" />
                                    </td>
                                    </c:forEach>
                                </tr>
                            </tbody></table>
                        </td>
                        <td id="colee_left2">
                            <table cellpadding="5px;">
                                <tbody><tr>
                                <c:forEach items="${qa.gloryDisplay}" var="p">
                                    <td>
                                    <img src="${basePath}filee/viewPic.do?manageKey=${p.manageKey}" 
								alt="butterflies-are-gross" class="post-image" width="205" height="275" />
                                    </td>
                                    </c:forEach>
                                </tr>
                            </tbody></table>
                        </td>
                    </tr>
                </tbody></table>
               </div>
  					
  					<%-- <div id="mygallery" class="stepcarousel">
					<div class="belt" id="displaycssbelt">
						<c:forEach items="${qa.gloryDisplay}" var="p">
							<div class="panel">
								<div class="subfeature"><a href="javascript:void(0);">
								<img src="${basePath}filee/viewPic.do?manageKey=${p.manageKey}" 
								alt="butterflies-are-gross" class="post-image" width="205" height="275" />
								</a>
								
									<div class="subfeature-txt"><h2><a href="javascript:void(0);">Butterflies are Gross</a></h2></div>
								
								</div>
							</div>	
						</c:forEach>
					</div>
					</div> --%>
  					
  					
  					</div>
  					
  					
  			</div>
  		</div>
  		
  		<div class="detail-footer">
  			<div class="line"></div>
  			<div style="text-align:center;color:#663333;font-weight:bold;font-size:20px;padding:20px 0px 30px 0px;">
  				<span>品质·信誉·未来</span>
  			</div>
  		</div>
  </body>
  <%--
	  <script src='${basePath}js/3d-gallery/js/TweenMax.min.js'></script>
	  <script src='${basePath}js/3d-gallery/js/Draggable.min.js'></script>
  	  <script src="${basePath}js/3d-gallery/js/index.js"></script>
   --%>
  	  
  	  <script src="http://vjs.zencdn.net/5.8.8/video.js"></script>
  	  <%--
  	  <script type="text/javascript">
		stepcarousel.setup({
			galleryid: 'mygallery', //id of carousel DIV
			beltclass: 'belt', //class of inner "belt" DIV containing all the panel DIVs
			panelclass: 'panel', //class of panel DIVs each holding content
			panelbehavior: {speed:500, wraparound:false, persist:true},
			autostep: {enable:true, moveby:4, pause:10000},
			defaultbuttons: {enable: true, moveby: 4, leftnav: ['${basePath}js/step-gallery/images/butt-left.gif', 0, 64], rightnav: ['${basePath}js/step-gallery/images/butt-right.gif', -11, 64]},
			statusvars: ['statusA', 'statusB', 'statusC'], //register 3 variables that contain current panel (start), current panel (last), and total panels
			contenttype: ['inline'], //content setting ['inline'] or ['external', 'path_to_external_file']
			oninit:function(){
				isloaded=true
				document.getElementById('displaycssbelt').style.visibility="visible";
				//document.getElementById('stocklevels').style.visibility="visible";
			}
		});
		</script>
  	   --%>
  	   <script>
		    var speed = 30//速度数值越大速度越慢
		    var colee_left2 = document.getElementById("colee_left2");
		    var colee_left1 = document.getElementById("colee_left1");
		    var colee_left = document.getElementById("colee_left");
		    colee_left2.innerHTML = colee_left1.innerHTML;
		    function Marquee3() {
		        if (colee_left2.offsetWidth - colee_left.scrollLeft <= 0)//offsetWidth 是对象的可见宽度
		            colee_left.scrollLeft -= colee_left1.offsetWidth//scrollWidth 是对象的实际内容的宽，不包边线宽度
		        else {
		            colee_left.scrollLeft++
		        }
		    }
		    var MyMar3 = setInterval(Marquee3, speed)
		    colee_left.onmouseover = function () {
		        clearInterval(MyMar3)
		    }
		    colee_left.onmouseout = function () {
		        MyMar3 = setInterval(Marquee3, speed)
		    }
		</script>
</html>