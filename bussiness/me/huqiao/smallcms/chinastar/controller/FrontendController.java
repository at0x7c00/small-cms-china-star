package me.huqiao.smallcms.chinastar.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import me.huqiao.smallcms.chinastar.entity.CorporateStyle;
import me.huqiao.smallcms.chinastar.entity.Information;
import me.huqiao.smallcms.chinastar.entity.SiteSetting;
import me.huqiao.smallcms.chinastar.service.ICorporateStyleService;
import me.huqiao.smallcms.chinastar.service.IInformationService;
import me.huqiao.smallcms.chinastar.service.ISiteSettingService;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.common.service.ICommonFolderService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		request.setAttribute("topInfos", topInfo(5));
		request.setAttribute("topStyles", topStyle(8));
	}
	
	
	@RequestMapping("column")
	public void column(HttpServletRequest request){
		request.setAttribute("siteSetting", siteSettingService.getSetting());
	}
	
	
	@RequestMapping("style")
	public void style(HttpServletRequest request,Page<CorporateStyle> pageInfo){
		request.setAttribute("siteSetting", siteSettingService.getSetting());
		
		
		CorporateStyle corporateStyle = new CorporateStyle();
		corporateStyle.setStatus(UseStatus.InUse);
		
		pageInfo.setOrderField("orderNum");
		pageInfo.setOrderDirection("asc");
		
		pageInfo.setNumPerPage(9);
		
		Page<CorporateStyle> page = corporateStyleService.getListPage(corporateStyle, pageInfo);
		request.setAttribute("page", page);
		
	}
	
	@RequestMapping("info")
	public void info(HttpServletRequest request,Page<Information> pageInfo){
		request.setAttribute("siteSetting", siteSettingService.getSetting());
		
		Information information = new Information();
		information.setStatus(UseStatus.InUse);
		
		pageInfo.setOrderField("orderNum");
		pageInfo.setOrderDirection("asc");
		
		pageInfo.setNumPerPage(9);
		
		Page<Information> page = infomationService.getListPage(information, pageInfo);
		request.setAttribute("page", page);
		
		request.setAttribute("hotInfos", newInfo(6));
	}
	
	@RequestMapping("info-view")
	public void infoView(HttpServletRequest request,@RequestParam(value = "key",required = false)String key){
		request.setAttribute("siteSetting", siteSettingService.getSetting());
		if(key!=null){
			Information info = infomationService.getEntityByProperty(Information.class, "manageKey", key);
			if(info!=null && info.getStatus()==UseStatus.InUse){
				request.setAttribute("info", info);
			}
		}
		request.setAttribute("hotInfos", newInfo(6));
	}
	
	
	@RequestMapping("style-view")
	public void styleView(HttpServletRequest request,@RequestParam(value = "key",required = false)String key){
		if(key!=null){
			CorporateStyle style = corporateStyleService.getEntityByProperty(CorporateStyle.class, "manageKey", key);
			if(style!=null && style.getStatus()==UseStatus.InUse){
				request.setAttribute("style", style);
			}
		}
		request.setAttribute("random", Math.random());
	}
	
	
	private List<CorporateStyle> topStyle(int top){
		return corporateStyleService.getByProperties(CorporateStyle.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum asc", top);
	}
	
	private List<Information> topInfo(int top){
		return infomationService.getByProperties(Information.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum asc", top);
	}
	
	private List<Information> newInfo(int top){
		return infomationService.getByProperties(Information.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "updateTime desc", top);
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
				content.append("	background:url("+basePath +"filee/viewPic.do?manageKey="  + siteSetting.getHeaderPic().getManageKey() + ") no-repeat center;");
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
