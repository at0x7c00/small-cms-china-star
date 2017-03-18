package me.huqiao.smallcms.ppll.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.common.entity.propertyeditor.CommonFileEditor;
import me.huqiao.smallcms.common.service.ICommonFileService;
import me.huqiao.smallcms.ppll.entity.QualityArchive;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.ppll.entity.propertyeditor.QualityArchiveCategoryEditor;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCategoryService;
import me.huqiao.smallcms.ppll.service.IQualityArchiveService;
import me.huqiao.smallcms.sys.entity.User;
import me.huqiao.smallcms.sys.entity.propertyeditor.UserEditor;
import me.huqiao.smallcms.sys.service.IUserService;
import me.huqiao.smallcms.util.Md5Util;
import me.huqiao.smallcms.util.web.JsonResult;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 质量档案控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("qualityArchive")
public class QualityArchiveController  extends BaseController {
   /**质量档案服务*/
    @Resource
    private IQualityArchiveService qualityArchiveService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
         binder.registerCustomEditor(User.class,new UserEditor(userService));
         binder.registerCustomEditor(QualityArchiveCategory.class,new QualityArchiveCategoryEditor(categoryService));
	}
    //复杂关联关系的Service
@Resource private ICommonFileService commonFileService;
@Resource private IUserService userService;
@Resource private IQualityArchiveCategoryService categoryService;
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return QualityArchive 质量档案对象
		  */
		@ModelAttribute(value="qualityArchive")
		public QualityArchive initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		QualityArchive qualityArchive = null;
		if (manageKey == null ||manageKey.equals("")) {
			qualityArchive = new QualityArchive();
		} else {
			qualityArchive =  qualityArchiveService.getEntityByProperty(QualityArchive.class,"manageKey", manageKey);
			if (qualityArchive==null) {
				qualityArchive=new QualityArchive();
			}
		}
		return qualityArchive;
	}
    /**
     * 质量档案分页查询
     * @param request HttpServletRequest对象
     * @param qualityArchive 质量档案查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,QualityArchive qualityArchive,Page pageInfo) {
        Page<QualityArchive> qualityArchivePage = qualityArchiveService.getListPage(qualityArchive,pageInfo);
        request.setAttribute("pageBean", qualityArchivePage);
		listFormParam(request,qualityArchive,pageInfo);
    }
 	/**
     * 为质量档案分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param qualityArchive 质量档案查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,QualityArchive qualityArchive,Page pageInfo){
		List<QualityArchiveCategory> categoryList = categoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", null);
    	request.setAttribute("categoryList",categoryList);
    	
		//复杂关联关系数据准备
		List<User> userList = userService.getByProperties(User.class,null,null,null,null);
		request.setAttribute("userList",userList);
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加质量档案页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
    	List<QualityArchiveCategory> categoryList = categoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", null);
    	request.setAttribute("categoryList",categoryList);
    	request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"qualityArchive");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加质量档案
     * @param request HttpServletRequest对象
     * @param qualityArchive 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("qualityArchive") QualityArchive qualityArchive,
	@RequestParam(value = "callBack",required = false)String callBack,
		@RequestParam(value="productDisplayKeys",required=false)String[] productDisplayKeys,
		@RequestParam(value="gloryDisplayKeys",required=false)String[] gloryDisplayKeys,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	
	    //保存多对多关联关系
		//设置产品展示
		HashSet<CommonFile> productDisplay = new HashSet<CommonFile>();
		if(productDisplayKeys!=null){
			for(String key : productDisplayKeys){
			if(key==null || key.trim().equals("")) continue;
				CommonFile file = commonFileService.getEntityByProperty(CommonFile.class, "manageKey", key);
				file.setInuse(UseStatus.InUse);
				commonFileService.update(file);
				productDisplay.add(file);
			}
		}
		qualityArchive.setCover(parseFilee(request, "coverKeys",null));
		qualityArchive.setCreateTime(new Date());
		qualityArchive.setUpdateTime(qualityArchive.getCreateTime());
		qualityArchive.setCreator(getCurrentUser());
		qualityArchive.setDetailCover(parseFilee(request, "videoOrPictureKeys",null));
		qualityArchive.setProductDisplay(productDisplay);
		//设置荣誉展示
		HashSet<CommonFile> gloryDisplay = new HashSet<CommonFile>();
		if(gloryDisplayKeys!=null){
			for(String key : gloryDisplayKeys){
			if(key==null || key.trim().equals("")) continue;
			CommonFile file = commonFileService.getEntityByProperty(CommonFile.class, "manageKey", key);
			file.setInuse(UseStatus.InUse);
			commonFileService.update(file);
			gloryDisplay.add(file);
			}
		}
		qualityArchive.setGloryDisplay(gloryDisplay);
		
		List<CommonFile> atts = commonFileService.findAttachementFromContent(qualityArchive.getContent());
        markFileAsInuse(atts);
        
		//保持一对多关联关系
		qualityArchive.setManageKey(Md5Util.getManageKey());
    	qualityArchiveService.add(qualityArchive);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改质量档案页面
     * @param qualityArchive 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="qualityArchive") QualityArchive qualityArchive,HttpServletRequest request) {
    	
    	List<QualityArchiveCategory> categoryList = categoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", null);
    	request.setAttribute("categoryList",categoryList);
    	
    	request.setAttribute("tempBean", qualityArchive);
    	//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"qualityArchive");
    }
    /**
     *  修改质量档案 
     * @param qualityArchive 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="qualityArchive") QualityArchive qualityArchive,
	@RequestParam(value="newContent")String newContent,
		@RequestParam(value="productDisplayKeys",required=false)String[] productDisplayKeys,
		@RequestParam(value="gloryDisplayKeys",required=false)String[] gloryDisplayKeys,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
		//设置产品展示
    	if(qualityArchive.getProductDisplay()!=null){
	    	for(CommonFile file : qualityArchive.getProductDisplay()){
				file.setInuse(UseStatus.UnUse);
				commonFileService.update(file);
			}
    	}
		HashSet<CommonFile> productDisplay = new HashSet<CommonFile>();
		if(productDisplayKeys!=null){
			for(String key : productDisplayKeys){
				if(key==null || key.trim().equals("")) continue;
				productDisplay.add(commonFileService.getEntityByProperty(CommonFile.class, "manageKey", key));
			}
		}
		qualityArchive.getProductDisplay().clear();
		qualityArchive.getProductDisplay().addAll(productDisplay);
		
		markFileAsInuse(qualityArchive.getProductDisplay());
		
		//设置荣誉展示
		if(qualityArchive.getGloryDisplay()!=null){
			for(CommonFile file : qualityArchive.getGloryDisplay()){
				file.setInuse(UseStatus.UnUse);
				commonFileService.update(file);
			}
		}
		HashSet<CommonFile> gloryDisplay = new HashSet<CommonFile>();
		if(gloryDisplayKeys!=null){
			for(String key : gloryDisplayKeys){
				if(key==null || key.trim().equals("")) continue;
				gloryDisplay.add(commonFileService.getEntityByProperty(CommonFile.class, "manageKey", key));
			}
		}
		qualityArchive.getGloryDisplay().clear();
		qualityArchive.getGloryDisplay().addAll(gloryDisplay);
		markFileAsInuse(qualityArchive.getProductDisplay());
		
		qualityArchive.setUpdateTime(new Date());
		qualityArchive.setDetailCover(parseFilee(request, "videoOrPictureKeys",qualityArchive.getDetailCoverKey()));
		
		qualityArchive.setCover(parseFilee(request, "coverKeys",qualityArchive.getCoverKey()));
		
		
		
		List<CommonFile> oldAtts = commonFileService.findAttachementFromContent(qualityArchive.getContent());
        List<CommonFile> newAtts = commonFileService.findAttachementFromContent(newContent);

        List<CommonFile> deleteAtts = commonFileService.findDeleteAtts(oldAtts,newAtts);
        for(CommonFile deleteAtt : deleteAtts){
        	deleteAtt.setInuse(UseStatus.UnUse);
        	commonFileService.update(deleteAtt);
        }
        markFileAsInuse(newAtts);
        qualityArchive.setContent(newContent);
    	
		//保持一对多关联关系
        qualityArchiveService.update(qualityArchive);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看质量档案页面
     * @param qualityArchive 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="qualityArchive") QualityArchive qualityArchive,HttpServletRequest request) {
	request.setAttribute("tempBean", qualityArchive);
    	//复杂关联关系数据准备
        listFormParam(request,qualityArchive,null);
    }
	/**
     * 删除单个质量档案对象
     * @param request HttpServletRequest对象
     * @param qualityArchive 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute QualityArchive qualityArchive) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	markFileAsUnuse(qualityArchive.getProductDisplay());
        	markFileAsUnuse(qualityArchive.getGloryDisplay());
        	markFileAsUnuse(qualityArchive.getCover());
        	markFileAsUnuse(qualityArchive.getDetailCover());
        	qualityArchiveService.delete(qualityArchive);
		} catch (RuntimeException re) {
			jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.inuse"));
			return jsonResult;
		}catch (Exception e) {
			jsonResult.setMessage(e.toString());
			return jsonResult;
		}
	//jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.success"));
        return jsonResult;
    }
    /**
     * 删除多个对象
     * @param manageKeys 唯一识别ID数组
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
	public JsonResult batchDelete(HttpServletRequest request,@RequestParam("manageKeys") String[] manageKeys) {
    	QualityArchive qualityArchive = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			qualityArchive = qualityArchiveService.getEntityByProperty(QualityArchive.class,"manageKey",manageKey);
            	markFileAsUnuse(qualityArchive.getProductDisplay());
            	markFileAsUnuse(qualityArchive.getGloryDisplay());
            	markFileAsUnuse(qualityArchive.getCover());
            	markFileAsUnuse(qualityArchive.getDetailCover());
    			qualityArchiveService.delete(qualityArchive);
			}catch (RuntimeException re) {
				jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.inuse"));
				return jsonResult;
			}catch (Exception e) {
				jsonResult.setMessage(e.toString());
				return jsonResult;
			}
    	}
		jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.success"));
    	return jsonResult;
    } 
	 /**
	  *选择对象返回html
      *@param request HttpServletRequest对象
	  *@param manageKeys manageKey 数组
	  *@return String 返回jsp页面路径
      */
	@RequestMapping(value = "/selectList",params = "htmlType")
	public String selectListWithHtml(HttpServletRequest request,
			@RequestParam(value = "manageKey",required = false)String[] manageKeys
			){
		List<QualityArchive> qualityArchives = new ArrayList<QualityArchive>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				QualityArchive temp_qualityArchive = qualityArchiveService.getEntityByProperty(QualityArchive.class, "manageKey", manageKey);
				if(temp_qualityArchive!=null && !qualityArchives.contains(temp_qualityArchive)){
					qualityArchives.add(temp_qualityArchive);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("qualityArchives",qualityArchives);
		return "qualityArchive/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param qualityArchive 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,QualityArchive qualityArchive,Page pageInfo){
		Page<HistoryRecord<QualityArchive>> qualityArchivePage = qualityArchiveService.getHistoryListPage(qualityArchive, pageInfo);
		request.setAttribute("pageBean", qualityArchivePage);
		request.setAttribute("manageKey", qualityArchive.getManageKey());
	    return "qualityArchive/history-list";
	} */
	/**
	 * 查看��史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		QualityArchive qualityArchive = qualityArchiveService.findByVersion(version);
		QualityArchive preQualityArchive = (QualityArchive)qualityArchiveService.findByPreVersion(QualityArchive.class,qualityArchive.getManageKey(),version);
		if(preQualityArchive!=null && preQualityArchive.getManageKey().equals(qualityArchive.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preQualityArchive, qualityArchive);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", qualityArchive);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "qualityArchive/detail";
	}*/
	/**
	 * 根据关键字获��质量档案select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<QualityArchive> 质量档案Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<QualityArchive> select2Query(String queryKey,Page<QualityArchive> pageInfo, HttpServletResponse response) {
		Page<QualityArchive> page = qualityArchiveService.queryByKey(queryKey, pageInfo);
		Select2<QualityArchive> select2 = new Select2<QualityArchive>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个质量档案
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<QualityArchive> 质量档案列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<QualityArchive> queryById(Integer[] ids,HttpServletResponse response) {
		List<QualityArchive> qualityArchiveList = qualityArchiveService.queryById(ids);
		return qualityArchiveList;
	}
	/**
	 * tab页添加表单
	 * @param trTarget tr的target值
	 * @param trIndex tr的序号
     * @param propName 表单元素name前缀
	 * @return String jsp路径
	 */
	@RequestMapping(value = "/tabAddForm")
public String tabAddForm(
			@ModelAttribute(value="qualityArchive") QualityArchive qualityArchive,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",qualityArchive);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "qualityArchive/tab-add-form";
	}
/**
	 * tab页查看详情页面
	 * @param trTarget tr的target值
	 * @param trIndex tr的序号
     * @param propName 表单元素name前缀
	 * @return String jsp路径
	 */
	@RequestMapping(value = "/tabDetailForm")
	public String tabDetailForm(
			@ModelAttribute(value="qualityArchive") QualityArchive qualityArchive,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",qualityArchive);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "qualityArchive/tab-detail-form";
	}
}