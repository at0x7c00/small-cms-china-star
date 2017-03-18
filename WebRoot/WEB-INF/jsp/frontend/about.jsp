<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>关于我们 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
		
		<link rel="stylesheet" href="${basePath}js/simple-modal/css/jquery.dialog.css" type="text/css" media="screen" title="no title" charset="utf-8">
		<script src="${basePath}js/simple-modal/js/jquery.dialog.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}js/plugin/jquery-validate/jquery.validate.min.js"></script>
		<style type="text/css">
		p{
			line-height: 1.6em;
		}
		
		.xtable td{
			vertical-align: top;
			padding-top:16px;
		}
		.xtable td p{
			margin-top:0px;
			padding-top:0px;
		}
		</style>
  	</head>
  
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group">
		  			<div class="module left lg" style="width:952px;">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/about.png">
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<div class="module-content">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/about-banner.png" >
		  					<p class="header">中国质量万里行促进会简介</p>
		  					
		  					<p>
		  					中国质量万里行促进会（英文简称CAQP）成立于1994年，前身是中国质量万里行组委会。
		  					<br/>是由政府部门、中央新闻机构、经济学家、名优企业及科技界等方面人士和单位自愿结成的全国性组织，具有独立法人资格，负责组织、指导、协调全国质量万里行工作，由国家质量监督检验检疫总局直接管理。
		  					<br/>国家质量监督检验检疫总局原副局长蒲长城为会长，人民日报社总编辑李宝善、全国政协经济委员会副主任委员、北京大学光华管理学院院长厉以宁、著名经济学家、国务院发展研究中心研究员吴敬琏、中国国际广播电台副台长王明华、新华社副总编辑夏林、中央电视台总编辑、副台长罗明、国家质量监督检验检疫总局总工程师刘兆彬等为副会长，高伯海同志担任秘书长。
		  					</p>
		  					
		  					<div class="devider"></div>
		  					
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/about-banner-2.png">
		  					<p class="header">质量维护工程</p>
		  					<p>
		  					质量维护工程是由中国质量万里行促进会发起，围绕“企业重视质量，人人关注质量”这一主题，借助中国最权威的质量监督平台，寻找一批优秀企业，立足于质量领域，及时、准确地向消费者提供满意放心的产品信息，同时进一步提高合格企业的知名度、信誉度，树立良好的企业形象，促进优秀企业的品牌化进程。
		  					</p>
		  					
		  					<div class="devider"></div>
		  					
		  					<p class="header" style="margin-bottom:0px;">活动宗旨</p>
		  					
		  					<div>
		  						<table border="0" class="xtable">
		  							<tr>
		  								<td >
		  								<div class="detail-item">
		  								搭建品牌平台
		  								</div>
		  								</td>
		  								<td>
		  								<p style="padding-top:3px;">依托中国质量万里行促进会搭建一个全国优质企业品牌形象展示平台，建立优质企业质量生态圈。  
		  								</p>
		  								</td>
		  							</tr>
		  							<tr>
		  								<td>
		  								<div class="detail-item">
		  								营造重视质量良好氛围
		  								</div> 
		  								</td>
		  								<td>
		  								<p style="padding-top:3px;">质量是企业生命之源，为提升企业质量意识，我们秉承以“质量赢市场，诚信铸品牌”的活动理念，推动企业发展，营造“企业重视质量、人人关注质量”的良好氛围。
		  								</p>
		  								</td>
		  							</tr>
		  							<tr>
		  								<td>
		  								<div class="detail-item">
		  								为优质企业证言
		  								</div>
		  								</td>
		  								<td>
		  								<p style="padding-top:3px;">
		  								好产品、好企业应该得到消费者认可，“质量维护工程”活动以发现好产品、好企业为己任，为优质企业证言；从而实现产品差异化，提升品牌公信力，帮助企业打造有竞争优势的品牌形象。
		  								</p>
		  								</td>
		  							</tr>
		  						</table>
		  					</div>
		  					
		  				</div>
		  				
		  			</div>
		  			
		  			<div class="module right blue" style="width:254px;">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/contact-us.png">
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				
		  				<div class="module-content">
		  					
		  					<div style="text-align:center;font-size:16px;">
		  					<p class="headerx" style="font-weight:bold;">联系我们：400-822-5757
		  					</p>
		  					</div>
		  					
		  					<div style="text-align:center;font-size:16px;padding:25px 0px">
		  					<a href="javascript:void(0);" id="chaxun">
		  						<img alt="" src="${basePath}resource/frontend/theme/default/css/img/chaxunzhongxin-btn.png">
		  					</a>
		  					</div>
		  					<div style="text-align:center;font-size:16px;padding:25px 0px">
		  					<a href="javascript:void(0);" id="ruhui">
		  						<img alt="" src="${basePath}resource/frontend/theme/default/css/img/ruhuishenqing-btn.png"/>
		  					</a>
		  					</div>
		  					
		  				</div>
		  				
		  			</div>
		  			
	  			</div>
	  			
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
 		
 		
 		
 		
 		<script type="text/javascript">
 		$(function(){
 			$("#ruhui").on("click",function(){
 				loadWaitDialog();
 				$.get(basePath + 'frontend/apply.do?notice=yes',function(d){
 					closeWaitDialog();
 					$('<div class="dialog-content" id="applyNotice" style="width:735px;height:505px;overflow:auto;"></div>').html(d).dialog({
 	 					title : "申请条件",
 	 					width:600,
 	 					height:400,
 	 					modal:true,
 	 					buttons: {
 	 						"同意":function(){
 	 							loadApplyUI();
 	 							return true;
 	 						},
 	 					},
 	 				});
 					
 					$("#verifyCodeImage").click(function(){
 						loadVerifyCode();
 					});
 					loadVerifyCode();
 					
 				});
 			});
 			
 			
 			
 			$("#chaxun").click(function(){
 				loadWaitDialog();
 				$.get(basePath + 'frontend/query.do',function(d){
 					closeWaitDialog();
 					var dialog = $('<div class="dialog-content" id="query" style="width:500px;height:300px;"></div>').html(d).dialog({
 	 					title : "查询中心",
 	 					width:600,
 	 					height:400,
 	 					modal:true,
 	 					buttons: {
 	 						/* "关闭" : function(){
 	 							$(".xdsoft_close").trigger("click");
 	 							return false;
 	 						} */
 	 					},
 	 				});
 					
 					$(".input-center").unbind("keydown").on("keydown",function(e){
 						if(e.keyCode==13){
	 						e.preventDefault();
	 						
	 						$(this).parent().parent().find(".query-btn").first().trigger("click");
	 						
	 						return false;
 						}
 					});
 					
 					$("#query").find(".query-btn").each(function(){
 						var _this = $(this);
 						_this.click(function(){
 							var input = _this.parents("td").first().find("input").first();
 							var key = input.val();
 							if(!key || key.trim()==""){
 								$("<div><strong>请输入要查询的关键字</strong></div>").dialog({
 									title:'提示',
									buttons: {
			 	 						"确定":function(){
			 	 							input.focus();
			 	 							input.val("");
			 	 							return true;
			 	 						}
									}
 								});
 								return;
 							}
 							var queryType = _this.data("query-type");
 							var title = '会员单位';
 							if(queryType=='qualityArchive'){
 								title = "质量档案";
 							}else if(queryType =='authOrg'){
 								title = "授权机构";
 							}else if(queryType =='worker'){
 								title = "工作人员";
 							}
 							$.post(basePath + "frontend/query.do",{key:key,queryType:queryType},function(res){
 								$('<div class="dialog-content" id="query" style="width:500px;height:300px;overflow:auto;">'  + res + '</div>').dialog({
 									title:title,
									buttons: {
			 	 					/* 	"关闭":function(){
			 	 							return true;
			 	 						} */
									}
 								});
 							});
 						});
 					});
 					
 					
 				});
 				
 			});
 			
 			
 		});
 		
 		function loadVerifyCode(){
	  		$("#verifyCodeImage").attr("src","${basePath}verifyimage.create?t="+new Date().getTime());
	  	}
 		
 		function loadWaitDialog(){
 			$("<div class='jquery-dialog-wait' id='wait-dialog'></div>").dialog({
 				modal:true,
 				closeBtn:false,
 				title:'加载中，请稍后'
 			});
 		}
 		function closeWaitDialog(){
 			window.setTimeout(function(){
	 			$("#wait-dialog").parents(".xdsoft_dialog_shadow_effect").first().find(".xdsoft_close").first().trigger("click");
 			},200);
 		}
 		
 		
 		function loadApplyUI(){
 			$.get(basePath + 'frontend/apply.do',function(d){
					closeWaitDialog();
					$('<div class="dialog-content" id="apply" style="width:735px;height:400px;"></div>').html(d).dialog({
	 					title : "申请信息",
	 					width:600,
	 					height:400,
	 					modal:true,
	 					buttons: {
	 						"提交":function(){
	 							if($("#apply-form").valid({errorPlacement:function(){}})){
	 								var data = $("#apply-form").serializeArray();
	 								$.post(basePath + "frontend/apply.do",data,function(res){
	 									if(res.statusCode!='200'){
	 										//alert(res.message);
	 										$("<div style='text-align:center;font-size:18px;'>" + res.message + "</div>").dialog({
	 											title:'提示',
	 											buttons: {
	 					 	 						"确定":function(){
	 					 	 							return true;
	 					 	 						}
	 											}
	 										});
	 									}else{
	 										$("<div style='text-align:center;font-size:18px;margin-top:10px;'>" + res.message + "</div>").dialog({
	 											title:'提示',
	 											buttons: {
	 					 	 						"确定":function(){
 	 					 	 						$("#apply").dialog("close");
 	 	 	 		 	 							$(".xdsoft_close").trigger("click");
	 					 	 							return true;
	 					 	 						}
	 											}
	 										});
	 									}
	 								});
	 							}
	 							return false;
	 						},
	 						/* "取消" : function(){
	 							$("#apply").dialog("close");
	 							$(".xdsoft_close").trigger("click");
	 							return false;
	 						} */
	 					},
	 				});
					
					for(var i = 0;i<cities.length;i++){
						$("#p").append($("<option value='"+ cities[i].name +"'>" + cities[i].name +  "</option>"));
					}
					$("#p").change(function(){
						var _p = $(this).val();
						$("#s").html("<option value=''>市辖区</option>");
						$("#c").html("<option value=''>城区</option>");
						for(var i = 0;i<cities.length;i++){
							if(cities[i].name == _p){
								for(var j  = 0;j<cities[i].city.length;j++){
									$("#s").append($("<option value='"+ cities[i].city[j].name +"'>" + cities[i].city[j].name +  "</option>"));
								}
								break;
							}
						}
					});
					
					$("#s").change(function(){
						var _s = $(this).val();
						$("#c").html("<option value=''>城区</option>");
						for(var i = 0;i<cities.length;i++){
							for(var j  = 0;j<cities[i].city.length;j++){
								if(cities[i].city[j].name == _s){
									for(var x  = 0;x<cities[i].city[j].area.length;x++){
										$("#c").append($("<option value='"+ cities[i].city[j].area[x] +"'>" + cities[i].city[j].area[x] +  "</option>"));
									}
									break;
								}
							}
						}
					});
					
					$("#c").change(function(){
						
						$("#address").val($("#p").val() + "," + $("#s").val() + "," + $("#c").val());
						
					});
					
					$("#verifyCodeImage").click(function(){
						loadVerifyCode();
					});
					loadVerifyCode();
					
				});
 		}
 		</script>
 		<script type="text/javascript" src="${basePath}js/city.js"></script>
  </body>
</html>
