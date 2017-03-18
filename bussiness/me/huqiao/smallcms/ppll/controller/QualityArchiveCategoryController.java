package me.huqiao.smallcms.ppll.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCategoryService;
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
 * 质量档案类别控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("qualityArchiveCategory")
public class QualityArchiveCategoryController  extends BaseController {
   /**质量档案类别服务*/
    @Resource
    private IQualityArchiveCategoryService qualityArchiveCategoryService;
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
		  * @return QualityArchiveCategory 质量档案类别对象
		  */
		@ModelAttribute(value="qualityArchiveCategory")
		public QualityArchiveCategory initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		QualityArchiveCategory qualityArchiveCategory = null;
		if (manageKey == null ||manageKey.equals("")) {
			qualityArchiveCategory = new QualityArchiveCategory();
		} else {
			qualityArchiveCategory =  qualityArchiveCategoryService.getEntityByProperty(QualityArchiveCategory.class,"manageKey", manageKey);
			if (qualityArchiveCategory==null) {
				qualityArchiveCategory=new QualityArchiveCategory();
			}
		}
		return qualityArchiveCategory;
	}
    /**
     * 质量档案类别分页查询
     * @param request HttpServletRequest对象
     * @param qualityArchiveCategory 质量档案类别查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,QualityArchiveCategory qualityArchiveCategory,Page pageInfo) {
        Page<QualityArchiveCategory> qualityArchiveCategoryPage = qualityArchiveCategoryService.getListPage(qualityArchiveCategory,pageInfo);
        request.setAttribute("pageBean", qualityArchiveCategoryPage);
		listFormParam(request,qualityArchiveCategory,pageInfo);
    }
 	/**
     * 为质量档案类别分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param qualityArchiveCategory 质量档案类别查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,QualityArchiveCategory qualityArchiveCategory,Page pageInfo){
		//复杂关联关系数据准备
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加质量档案类别页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"qualityArchiveCategory");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加质量档案类别
     * @param request HttpServletRequest对象
     * @param qualityArchiveCategory 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("qualityArchiveCategory") QualityArchiveCategory qualityArchiveCategory,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
	    //保存多对多关联关系
    	//保持一对多关联关系
    	qualityArchiveCategory.setManageKey(Md5Util.getManageKey());
    	qualityArchiveCategoryService.add(qualityArchiveCategory);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改质量档案类别页面
     * @param qualityArchiveCategory 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="qualityArchiveCategory") QualityArchiveCategory qualityArchiveCategory,HttpServletRequest request) {
	request.setAttribute("tempBean", qualityArchiveCategory);
    	//复杂关联关系数据准备
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	//clearTempDataList(request.getSession(),"qualityArchiveCategory");
    }
    /**
     *  修改质量档案类别 
     * @param qualityArchiveCategory 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="qualityArchiveCategory") QualityArchiveCategory qualityArchiveCategory,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        qualityArchiveCategoryService.update(qualityArchiveCategory);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看质量档案类别页面
     * @param qualityArchiveCategory 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="qualityArchiveCategory") QualityArchiveCategory qualityArchiveCategory,HttpServletRequest request) {
	request.setAttribute("tempBean", qualityArchiveCategory);
    	//复杂关联关系数据准备
        listFormParam(request,qualityArchiveCategory,null);
    }
	/**
     * 删除单���质量档案类别对象
     * @param request HttpServletRequest对象
     * @param qualityArchiveCategory 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute QualityArchiveCategory qualityArchiveCategory) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	qualityArchiveCategoryService.delete(qualityArchiveCategory);
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
    	QualityArchiveCategory qualityArchiveCategory = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			qualityArchiveCategory = qualityArchiveCategoryService.getEntityByProperty(QualityArchiveCategory.class,"manageKey",manageKey);
    			qualityArchiveCategoryService.delete(qualityArchiveCategory);
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
		List<QualityArchiveCategory> qualityArchiveCategorys = new ArrayList<QualityArchiveCategory>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				QualityArchiveCategory temp_qualityArchiveCategory = qualityArchiveCategoryService.getEntityByProperty(QualityArchiveCategory.class, "manageKey", manageKey);
				if(temp_qualityArchiveCategory!=null && !qualityArchiveCategorys.contains(temp_qualityArchiveCategory)){
					qualityArchiveCategorys.add(temp_qualityArchiveCategory);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("qualityArchiveCategorys",qualityArchiveCategorys);
		return "qualityArchiveCategory/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param qualityArchiveCategory 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,QualityArchiveCategory qualityArchiveCategory,Page pageInfo){
		Page<HistoryRecord<QualityArchiveCategory>> qualityArchiveCategoryPage = qualityArchiveCategoryService.getHistoryListPage(qualityArchiveCategory, pageInfo);
		request.setAttribute("pageBean", qualityArchiveCategoryPage);
		request.setAttribute("manageKey", qualityArchiveCategory.getManageKey());
	    return "qualityArchiveCategory/history-list";
	} */
	/**
	 * 查���历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		QualityArchiveCategory qualityArchiveCategory = qualityArchiveCategoryService.findByVersion(version);
		QualityArchiveCategory preQualityArchiveCategory = (QualityArchiveCategory)qualityArchiveCategoryService.findByPreVersion(QualityArchiveCategory.class,qualityArchiveCategory.getManageKey(),version);
		if(preQualityArchiveCategory!=null && preQualityArchiveCategory.getManageKey().equals(qualityArchiveCategory.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preQualityArchiveCategory, qualityArchiveCategory);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", qualityArchiveCategory);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "qualityArchiveCategory/detail";
	}*/
	/**
	 * 根据关键字获取质量档案类别select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<QualityArchiveCategory> 质量档案类别Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<QualityArchiveCategory> select2Query(String queryKey,Page<QualityArchiveCategory> pageInfo, HttpServletResponse response) {
		Page<QualityArchiveCategory> page = qualityArchiveCategoryService.queryByKey(queryKey, pageInfo);
		Select2<QualityArchiveCategory> select2 = new Select2<QualityArchiveCategory>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个质量档案类别
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<QualityArchiveCategory> 质量档案类别列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<QualityArchiveCategory> queryById(Integer[] ids,HttpServletResponse response) {
		List<QualityArchiveCategory> qualityArchiveCategoryList = qualityArchiveCategoryService.queryById(ids);
		return qualityArchiveCategoryList;
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
			@ModelAttribute(value="qualityArchiveCategory") QualityArchiveCategory qualityArchiveCategory,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",qualityArchiveCategory);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "qualityArchiveCategory/tab-add-form";
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
			@ModelAttribute(value="qualityArchiveCategory") QualityArchiveCategory qualityArchiveCategory,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",qualityArchiveCategory);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "qualityArchiveCategory/tab-detail-form";
	}
}