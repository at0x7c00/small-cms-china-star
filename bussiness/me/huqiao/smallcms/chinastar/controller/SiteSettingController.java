package me.huqiao.smallcms.chinastar.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.chinastar.entity.SiteSetting;
import me.huqiao.smallcms.chinastar.service.ISiteSettingService;
import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.common.entity.propertyeditor.CommonFileEditor;
import me.huqiao.smallcms.common.service.ICommonFileService;
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
 * 网站设置控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("siteSetting")
public class SiteSettingController  extends BaseController {
   /**网站设置服务*/
    @Resource
    private ISiteSettingService siteSettingService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
	}
    //复杂关联关系的Service
@Resource private ICommonFileService commonFileService;
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return SiteSetting 网站设置对象
		  */
		@ModelAttribute(value="siteSetting")
		public SiteSetting initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		SiteSetting siteSetting = null;
		if (manageKey == null ||manageKey.equals("")) {
			siteSetting = new SiteSetting();
		} else {
			siteSetting =  siteSettingService.getEntityByProperty(SiteSetting.class,"manageKey", manageKey);
			if (siteSetting==null) {
				siteSetting=new SiteSetting();
			}
		}
		return siteSetting;
	}
    /**
     * 网站设置分页查询
     * @param request HttpServletRequest对象
     * @param siteSetting 网站设置查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,SiteSetting siteSetting,Page pageInfo) {
        Page<SiteSetting> siteSettingPage = siteSettingService.getListPage(siteSetting,pageInfo);
        request.setAttribute("pageBean", siteSettingPage);
		listFormParam(request,siteSetting,pageInfo);
    }
 	/**
     * 为网站设置分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param siteSetting 网站设置查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,SiteSetting siteSetting,Page pageInfo){
		//复杂关联关系数据准备
	}
    /**
     * 添加网站设置页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"siteSetting");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加网站设置
     * @param request HttpServletRequest对象
     * @param siteSetting 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("siteSetting") SiteSetting siteSetting,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
		siteSetting.setHeaderPic(parseFilee(request,"headerPicKeys",null));
		siteSetting.setInfoHeaderPic(parseFilee(request,"infoHeaderPicKeys",null));
	//保持一对多关联关系
	siteSetting.setManageKey(Md5Util.getManageKey());
    	siteSettingService.add(siteSetting);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改网站设置页面
     * @param siteSetting 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="siteSetting") SiteSetting siteSetting,HttpServletRequest request) {
	request.setAttribute("tempBean", siteSetting);
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"siteSetting");
    }
    /**
     *  修改网站设置 
     * @param siteSetting 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="siteSetting") SiteSetting siteSetting,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		String oldKey = null;
		if(siteSetting.getHeaderPic()!=null){
			oldKey = siteSetting.getHeaderPic().getManageKey();
		}
		siteSetting.setHeaderPic(parseFilee(request,"headerPicKeys",oldKey));
	
	
		String oldKey2 = null;
		if(siteSetting.getInfoHeaderPic()!=null){
			oldKey2 = siteSetting.getInfoHeaderPic().getManageKey();
		}
		siteSetting.setInfoHeaderPic(parseFilee(request,"infoHeaderPicKeys",oldKey2));
		//保持一对多关联关系
        siteSettingService.update(siteSetting);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看网站设置页面
     * @param siteSetting 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="siteSetting") SiteSetting siteSetting,HttpServletRequest request) {
	request.setAttribute("tempBean", siteSetting);
    	//复杂关联关系数据准备
        listFormParam(request,siteSetting,null);
    }
	/**
     * 删除单个网站设置对象
     * @param request HttpServletRequest对象
     * @param siteSetting 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute SiteSetting siteSetting) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	siteSettingService.delete(siteSetting);
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
    	SiteSetting siteSetting = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			siteSetting = siteSettingService.getEntityByProperty(SiteSetting.class,"manageKey",manageKey);
		markFileAsUnuse(siteSetting.getHeaderPic());
		markFileAsUnuse(siteSetting.getInfoHeaderPic());
    			siteSettingService.delete(siteSetting);
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
		List<SiteSetting> siteSettings = new ArrayList<SiteSetting>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				SiteSetting temp_siteSetting = siteSettingService.getEntityByProperty(SiteSetting.class, "manageKey", manageKey);
				if(temp_siteSetting!=null && !siteSettings.contains(temp_siteSetting)){
					siteSettings.add(temp_siteSetting);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("siteSettings",siteSettings);
		return "siteSetting/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param siteSetting 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,SiteSetting siteSetting,Page pageInfo){
		Page<HistoryRecord<SiteSetting>> siteSettingPage = siteSettingService.getHistoryListPage(siteSetting, pageInfo);
		request.setAttribute("pageBean", siteSettingPage);
		request.setAttribute("manageKey", siteSetting.getManageKey());
	    return "siteSetting/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		SiteSetting siteSetting = siteSettingService.findByVersion(version);
		SiteSetting preSiteSetting = (SiteSetting)siteSettingService.findByPreVersion(SiteSetting.class,siteSetting.getManageKey(),version);
		if(preSiteSetting!=null && preSiteSetting.getManageKey().equals(siteSetting.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preSiteSetting, siteSetting);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", siteSetting);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "siteSetting/detail";
	}*/
	/**
	 * 根据关键字获取网站设置select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<SiteSetting> 网站���置Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<SiteSetting> select2Query(String queryKey,Page<SiteSetting> pageInfo, HttpServletResponse response) {
		Page<SiteSetting> page = siteSettingService.queryByKey(queryKey, pageInfo);
		Select2<SiteSetting> select2 = new Select2<SiteSetting>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个网���设置
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<SiteSetting> 网站设置列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<SiteSetting> queryById(Integer[] ids,HttpServletResponse response) {
		List<SiteSetting> siteSettingList = siteSettingService.queryById(ids);
		return siteSettingList;
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
			@ModelAttribute(value="siteSetting") SiteSetting siteSetting,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",siteSetting);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "siteSetting/tab-add-form";
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
			@ModelAttribute(value="siteSetting") SiteSetting siteSetting,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",siteSetting);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "siteSetting/tab-detail-form";
	}
}