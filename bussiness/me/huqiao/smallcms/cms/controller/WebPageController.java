package me.huqiao.smallcms.cms.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.cms.entity.WebPage;
import me.huqiao.smallcms.cms.service.IWebPageService;
import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
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
 * 栏目控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("webPage")
public class WebPageController  extends BaseController {
   /**栏目服务*/
    @Resource
    private IWebPageService webPageService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
	}
    //复杂关联关系的Service
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return WebPage 栏目对象
		  */
		@ModelAttribute(value="webPage")
		public WebPage initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		WebPage webPage = null;
		if (manageKey == null ||manageKey.equals("")) {
			webPage = new WebPage();
		} else {
			webPage =  webPageService.getEntityByProperty(WebPage.class,"manageKey", manageKey);
			if (webPage==null) {
				webPage=new WebPage();
			}
		}
		return webPage;
	}
    /**
     * 栏目分页查询
     * @param request HttpServletRequest对象
     * @param webPage 栏目查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,WebPage webPage,Page pageInfo) {
        Page<WebPage> webPagePage = webPageService.getListPage(webPage,pageInfo);
        request.setAttribute("pageBean", webPagePage);
		listFormParam(request,webPage,pageInfo);
    }
 	/**
     * 为栏目分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param webPage 栏目查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,WebPage webPage,Page pageInfo){
		//复杂关联关系数���准备
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加栏目页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"webPage");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加栏目
     * @param request HttpServletRequest对象
     * @param webPage 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("webPage") WebPage webPage,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	webPage.setManageKey(Md5Util.getManageKey());
    	webPageService.add(webPage);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改栏目页面
     * @param webPage 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="webPage") WebPage webPage,HttpServletRequest request) {
	request.setAttribute("tempBean", webPage);
    	//复杂关联关系数据准备
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	//clearTempDataList(request.getSession(),"webPage");
    }
    /**
     *  修改栏目 
     * @param webPage 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="webPage") WebPage webPage,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        webPageService.update(webPage);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看栏目页面
     * @param webPage 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="webPage") WebPage webPage,HttpServletRequest request) {
	request.setAttribute("tempBean", webPage);
    	//复杂关联关系数据准备
        listFormParam(request,webPage,null);
    }
	/**
     * 删除单个栏目对象
     * @param request HttpServletRequest对象
     * @param webPage 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute WebPage webPage) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	webPageService.delete(webPage);
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
    	WebPage webPage = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			webPage = webPageService.getEntityByProperty(WebPage.class,"manageKey",manageKey);
    			webPageService.delete(webPage);
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
		List<WebPage> webPages = new ArrayList<WebPage>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				WebPage temp_webPage = webPageService.getEntityByProperty(WebPage.class, "manageKey", manageKey);
				if(temp_webPage!=null && !webPages.contains(temp_webPage)){
					webPages.add(temp_webPage);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("webPages",webPages);
		return "webPage/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param webPage 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,WebPage webPage,Page pageInfo){
		Page<HistoryRecord<WebPage>> webPagePage = webPageService.getHistoryListPage(webPage, pageInfo);
		request.setAttribute("pageBean", webPagePage);
		request.setAttribute("manageKey", webPage.getManageKey());
	    return "webPage/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		WebPage webPage = webPageService.findByVersion(version);
		WebPage preWebPage = (WebPage)webPageService.findByPreVersion(WebPage.class,webPage.getManageKey(),version);
		if(preWebPage!=null && preWebPage.getManageKey().equals(webPage.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preWebPage, webPage);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", webPage);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "webPage/detail";
	}*/
	/**
	 * 根据关键字获取栏目select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<WebPage> 栏目Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<WebPage> select2Query(String queryKey,Page<WebPage> pageInfo, HttpServletResponse response) {
		Page<WebPage> page = webPageService.queryByKey(queryKey, pageInfo);
		Select2<WebPage> select2 = new Select2<WebPage>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个栏目
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<WebPage> 栏目列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<WebPage> queryById(Integer[] ids,HttpServletResponse response) {
		List<WebPage> webPageList = webPageService.queryById(ids);
		return webPageList;
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
			@ModelAttribute(value="webPage") WebPage webPage,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",webPage);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "webPage/tab-add-form";
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
			@ModelAttribute(value="webPage") WebPage webPage,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",webPage);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "webPage/tab-detail-form";
	}
}