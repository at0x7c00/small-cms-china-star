package me.huqiao.smallcms.chinastar.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import me.huqiao.smallcms.chinastar.entity.SiteSetting;
import me.huqiao.smallcms.chinastar.service.ICorporateStyleService;
import me.huqiao.smallcms.chinastar.service.IInformationService;
import me.huqiao.smallcms.chinastar.service.ISiteSettingService;
import me.huqiao.smallcms.common.service.ICommonFolderService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/f")
public class FrontendController {
	
	@Resource
	private ICorporateStyleService corporateStyleService;
	
	@Resource
	private IInformationService infomationService;
	
	@Resource
	private ISiteSettingService siteSettingService;
	
	@Resource
	private ICommonFolderService fileService;

	@RequestMapping("index")
	public void index(HttpServletRequest request){
		request.setAttribute("siteSetting", siteSettingService.getSetting());
	}
	
	
	@RequestMapping("bannerCss")
	public ResponseEntity<String>  bannerCss(HttpServletRequest request){
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "text/css; charset=utf-8");
	    
	    StringBuffer content = new StringBuffer();
	    
	    
	    String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	    
		SiteSetting siteSetting = siteSettingService.getSetting();
		
		content.append(".big-banner{");
		if(siteSetting.getHeaderPic()!=null){
			if(siteSetting.getHeaderPic().isPicture()){
				content.append("	background:url("+basePath +"filee/vidwPic.do?manageKey="  + siteSetting.getHeaderPic().getManageKey() + ") no-repeat center;");
			}
		}else{
			content.append("	background:url("+basePath +"resource/f/theme/default/css/img/big-banner.png) no-repeat center;");
		}
		content.append("	width:100%;");
		content.append("	height:485px;");
		content.append("}");

		
	    
	    ResponseEntity<String> res =  new ResponseEntity<String>(content.toString(), responseHeaders, HttpStatus.OK);
	    
	    return res;
	}
	
}
