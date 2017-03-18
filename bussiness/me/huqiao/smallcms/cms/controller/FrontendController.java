package me.huqiao.smallcms.cms.controller;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import me.huqiao.smallcms.cms.entity.Advertisement;
import me.huqiao.smallcms.cms.entity.Carousel;
import me.huqiao.smallcms.cms.entity.Chapter;
import me.huqiao.smallcms.cms.entity.FriendLink;
import me.huqiao.smallcms.cms.service.IAdvertisementService;
import me.huqiao.smallcms.cms.service.ICarouselService;
import me.huqiao.smallcms.cms.service.IChapterService;
import me.huqiao.smallcms.cms.service.IFriendLinkService;
import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.ppll.entity.Apply;
import me.huqiao.smallcms.ppll.entity.AuthOrg;
import me.huqiao.smallcms.ppll.entity.MemberOrganization;
import me.huqiao.smallcms.ppll.entity.QualityArchive;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCompany;
import me.huqiao.smallcms.ppll.entity.Worker;
import me.huqiao.smallcms.ppll.service.IApplyService;
import me.huqiao.smallcms.ppll.service.IAuthOrgService;
import me.huqiao.smallcms.ppll.service.IMemberOrganizationService;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCategoryService;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCompanyService;
import me.huqiao.smallcms.ppll.service.IQualityArchiveService;
import me.huqiao.smallcms.ppll.service.IWorkerService;
import me.huqiao.smallcms.servlet.VerifyImageServlet;
import me.huqiao.smallcms.util.Md5Util;
import me.huqiao.smallcms.util.StringUtil;
import me.huqiao.smallcms.util.web.JsonResult;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 轮播控制器
 * @author NOVOTS
 * @version Version 1.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value = "frontend")
public class FrontendController  extends BaseController {
	
	private Integer PAGE_ID_ZHENGCE = 1;
	private Integer PAGE_ID_ZHILIANGREDIAN = 2;
	private Integer PAGE_ID_HUIYUANFENGCAI = 3;
	private Integer PAGE_ID_HANGYEZIXUN = 4;
	
	@Resource
	private IChapterService chapterService;
	@Resource
	private ICarouselService carouselService;
	@Resource
	private IAdvertisementService adService;
	@Resource
	private IFriendLinkService flinkService;
	@Resource
	private IQualityArchiveService qualityArchiveService;
	@Resource
	private IQualityArchiveCategoryService qualityArchiveCategoryService;
	@Resource
	private IApplyService applyService;
	@Resource
	private IMemberOrganizationService memberOrgService;
	@Resource
	private IQualityArchiveCompanyService qaCompanyService;
	@Resource
	private IAuthOrgService authOrgService;
	@Resource
	private IWorkerService workerService;
	
	
	
	
	@RequestMapping("index")
	public void index(HttpServletRequest request){
		
		prepareCarousel(request);
		
		zhengceTop(request);
		zhiliangTop(request);
		
		
		huiyuanTop(request);
		hangyeTop(request);
		
		//ad
		adTop(request);
		
		//friend link 
		friendLinkTop(request);
		
		qaTop(request);
		
	}

	private void qaTop(HttpServletRequest request) {
		List<QualityArchive> qualityArchiveList = qualityArchiveService.getByProperties(QualityArchive.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 10);
		request.setAttribute("qualityArchiveList", qualityArchiveList);
	}

	private void friendLinkTop(HttpServletRequest request) {
		List<FriendLink> flinkList = flinkService.getByProperties(FriendLink.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", null);
		request.setAttribute("flinkList", flinkList);
	}

	private void adTop(HttpServletRequest request) {
		List<Advertisement> adList = adService.getByProperties(Advertisement.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 10);
		request.setAttribute("adList", adList);
	}

	private void hangyeTop(HttpServletRequest request) {
		List<Chapter> hangyezixunList = chapterService.getTop(8, PAGE_ID_HANGYEZIXUN);
		request.setAttribute("hangyezixunList", hangyezixunList);
	}

	private void huiyuanTop(HttpServletRequest request) {
		List<Chapter> huiyuanfengcaiList = chapterService.getTop(8, PAGE_ID_HUIYUANFENGCAI);
		request.setAttribute("huiyuanfengcaiList", huiyuanfengcaiList);
	}

	private void zhiliangTop(HttpServletRequest request) {
		List<Chapter> zhiliangredianList = chapterService.getTop(8, PAGE_ID_ZHILIANGREDIAN);
		request.setAttribute("zhiliangredianList", zhiliangredianList);
	}

	private void zhengceTop(HttpServletRequest request) {
		List<Chapter> zhengcedongtaiList = chapterService.getTop(8, PAGE_ID_ZHENGCE);
		request.setAttribute("zhengcedongtaiList", zhengcedongtaiList);
	}
	
	private void zhengcePage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_ZHENGCE,pageInfo);
		request.setAttribute("page", page);
	}
	private void zhiliangPage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_ZHILIANGREDIAN,pageInfo);
		request.setAttribute("page", page);
	}
	private void hangyePage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_HANGYEZIXUN,pageInfo);
		request.setAttribute("page", page);
	}
	private void huiyuanPage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_HUIYUANFENGCAI,pageInfo);
		request.setAttribute("page", page);
	}
	private void zhiliangdanganPage(HttpServletRequest request,Page<QualityArchive> pageInfo) {
		String categoryKey = request.getParameter("categoryKey");
		QualityArchiveCategory category = null;
		if(StringUtil.isNotEmpty(categoryKey)){
			category =  qualityArchiveCategoryService.getEntityByProperty(QualityArchiveCategory.class, "manageKey",categoryKey);
		}
		if(category==null || category.getStatus()==UseStatus.UnUse){
			List<QualityArchiveCategory> list = qualityArchiveCategoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 1);
			if(list.size()>0){
				category = list.get(0);
			}
		}
		request.setAttribute("category", category);
		Page<QualityArchive> page = qualityArchiveService.getAll(category,pageInfo);
		request.setAttribute("page", page);
	}

	private void prepareCarousel(HttpServletRequest request) {
		List<Carousel> carouselList = carouselService.getByProperties(Carousel.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 10);
		request.setAttribute("carouselList", carouselList);
	}
	
	@RequestMapping("zhengcedongtai")
	public void zhengcedongtai(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		zhiliangTop(request);
		hangyeTop(request);
		pageInfo.setNumPerPage(15);
		zhengcePage(request, pageInfo);
	}
	
	@RequestMapping("zhiliangredian")
	public void zhiliangredian(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		zhengceTop(request);
		hangyeTop(request);
		pageInfo.setNumPerPage(15);
		zhiliangPage(request, pageInfo);
	}
	
	@RequestMapping("huiyuanfengcai")
	public void huiyuanfengcai(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		pageInfo.setNumPerPage(4);
		huiyuanPage(request, pageInfo);
	}
	
	@RequestMapping("zhiliangdangan")
	public void zhiliangdangan(HttpServletRequest request,Page<QualityArchive> pageInfo){
		prepareCarousel(request);
		zhiliangdanganPage(request,pageInfo);
		List<QualityArchiveCategory> categoryList = qualityArchiveCategoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", null);
		request.setAttribute("categoryList",categoryList);
	}

	@RequestMapping("hangyezixun")
	public void hangyezixun(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		pageInfo.setNumPerPage(15);
		hangyePage(request, pageInfo);
	}
	@RequestMapping("danganDetail")
	public void danganDetail(HttpServletRequest request,@RequestParam("manageKey")String qaKey){
		QualityArchive qa = qualityArchiveService.getEntityByProperty(QualityArchive.class, "manageKey", qaKey);
		if(qa!=null && qa.getStatus()==UseStatus.InUse){
			request.setAttribute("qa", qa);
		}
	}
	
	@RequestMapping("about")
	public void about(HttpServletRequest request){
		prepareCarousel(request);
	}
	
	@RequestMapping("chapterDetail")
	public void chapterDetail(HttpServletRequest request,@RequestParam(value = "manageKey",required = false)String key){
		if(StringUtil.isEmpty(key)){
			key = request.getParameter("k");
		}
		prepareCarousel(request);
		
		Chapter chapter = chapterService.getEntityByProperty(Chapter.class, "manageKey", key);
		if(chapter!=null){
			chapter.setReadCount(chapter.getReadCount()==null ? 1 : (chapter.getReadCount()+1));
			chapterService.update(chapter); 
		}
		request.setAttribute("p", chapter);
		
		zhiliangTop(request);
		
		request.setAttribute("top10ChapterList",chapterService.getTop10OfAll());
	}
	
	
	@RequestMapping(value = "apply",method = RequestMethod.GET,params = "notice")
	public String applyNotice(){
		return "frontend/applyNotice";
	}
	
	@RequestMapping(value = "apply",method = RequestMethod.GET)
	public void applyUI(){
		
	}
	
	@RequestMapping(value = "apply",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult apply(HttpServletRequest request,@ModelAttribute("apply") Apply apply,
			@RequestParam(value = "verifyCode")String checkcode){
		String checkCodeInSession = (String)request.getSession().getAttribute(VerifyImageServlet.SIMPLE_CAPCHA_SESSION_KEY);
		checkCodeInSession = checkCodeInSession==null ? null : checkCodeInSession.toLowerCase();
		if(!(checkcode!=null && checkcode.toLowerCase().equals(checkCodeInSession))){
			return JsonResult.error("验证码错误!");
		}
		request.getSession().removeAttribute(VerifyImageServlet.SIMPLE_CAPCHA_SESSION_KEY);
		apply.setManageKey(Md5Util.getManageKey());
		apply.setCreateTime(new Date());
		applyService.add(apply);
		return JsonResult.success("申请成功!");
	}
	
	@RequestMapping(value = "query",method = RequestMethod.GET)
	public void queryUI(){
	}
	
	@RequestMapping(value = "query",method = RequestMethod.POST,params = "queryType=memberOrg")
	public String queryMemberOrg(HttpServletRequest request, @RequestParam("key")String key){
		MemberOrganization memberOrganization = new MemberOrganization();
		Page<MemberOrganization> pageInfo = new Page<MemberOrganization>();
		memberOrganization.setName(key);
		pageInfo = memberOrgService.getListPage(memberOrganization, pageInfo);
		if(pageInfo.getList().size()>0){
			request.setAttribute("tempBean", pageInfo.getList().get(0));
		}
		return "frontend/queryMemberOrg";
	}
	
	@RequestMapping(value = "query",method = RequestMethod.POST,params = "queryType=qualityArchive")
	public String queryQualityArchive(HttpServletRequest request,@RequestParam("key")String key){
		QualityArchiveCompany qaCompany = new QualityArchiveCompany();
		Page<QualityArchiveCompany> pageInfo = new Page<QualityArchiveCompany>();
		qaCompany.setName(key);
		pageInfo = qaCompanyService.getListPage(qaCompany, pageInfo);
		if(pageInfo.getList().size()>0){
			request.setAttribute("tempBean", pageInfo.getList().get(0));
		}
		return "frontend/queryQualityArchiveCompany";
	}
	
	@RequestMapping(value = "query",method = RequestMethod.POST,params = "queryType=authOrg")
	public String queryAuthOrg(HttpServletRequest request,@RequestParam("key")String key){
		AuthOrg authOrg = new AuthOrg();
		Page<AuthOrg> pageInfo = new Page<AuthOrg>();
		authOrg.setName(key);
		pageInfo = authOrgService.getListPage(authOrg, pageInfo);
		if(pageInfo.getList().size()>0){
			request.setAttribute("tempBean", pageInfo.getList().get(0));
		}
		return "frontend/queryAuthOrg";
	}
	
	@RequestMapping(value = "query",method = RequestMethod.POST,params = "queryType=worker")
	public String queryWorker(HttpServletRequest request,@RequestParam("key")String key){
		Worker worker = new Worker();
		Page<Worker> pageInfo = new Page<Worker>();
		worker.setName(key);
		pageInfo = workerService.getListPage(worker, pageInfo);
		if(pageInfo.getList().size()>0){
			request.setAttribute("tempBean", pageInfo.getList().get(0));
		}
		
		return "frontend/queryWorker";
	}
	
	@RequestMapping(value = "pictureXML/{key}",produces = "application/xml")
	public ResponseEntity<String> pictureXML(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "key")String key){
		
		QualityArchive qa = qualityArchiveService.getEntityByProperty(QualityArchive.class, "manageKey", key);
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "application/xml; charset=utf-8");
	    
	    StringBuffer content = new StringBuffer();
	    
	    content.append("<?xml version='1.0' encoding='utf-8'?>");
	    content.append("<contentsRotator>");
	    
	    String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	    
		if(qa.getProductDisplay()!=null){
		    int i = 0;
		    for(CommonFile file : qa.getProductDisplay()){
		    	int index = (++i);
		    	String c = "";
		    	if(index<=5){
		    		c = "E";
		    	}else if(index<=8){
		    		c = "S";
		    	}else{
		    		c = "B";
		    	}
		    	content.append(" <item order='"+index+"' category='"+ c +"' type='image' title='请勿用于商业用途' image='"+ basePath +"filee/viewPic.do?manageKey="+file.getManageKey()+"' source='http://www.baidu.com' target='_self' />");
		    }
		}
	    
		int total = qa.getProductDisplay()==null ? 0 : qa.getProductDisplay().size();
	    
		for(;total<7;total++){
	    	content.append("<item order='"+  (total + 1) + "' category='S' type='video' title='666666666' image='http://localhost:1987/cms/js/flash-3d-gallery/zsimg/01.gif' source='http://www.baidu.com' />");
		}
	    
	    content.append("</contentsRotator>");
	    
	    
	    ResponseEntity<String> res =  new ResponseEntity<String>(content.toString(), responseHeaders, HttpStatus.OK);
	    
	    return res;
	}
	
}