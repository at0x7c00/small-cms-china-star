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
import me.huqiao.smallcms.ppll.entity.QualityArchiveCompany;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCompanyService;
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
 * 质量档案公司控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("qualityArchiveCompany")
public class QualityArchiveCompanyController  extends BaseController {
   /**质量档案公司服务*/
    @Resource
    private IQualityArchiveCompanyService qualityArchiveCompanyService;
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
		  * @return QualityArchiveCompany 质量档案公司对象
		  */
		@ModelAttribute(value="qualityArchiveCompany")
		public QualityArchiveCompany initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		QualityArchiveCompany qualityArchiveCompany = null;
		if (manageKey == null ||manageKey.equals("")) {
			qualityArchiveCompany = new QualityArchiveCompany();
		} else {
			qualityArchiveCompany =  qualityArchiveCompanyService.getEntityByProperty(QualityArchiveCompany.class,"manageKey", manageKey);
			if (qualityArchiveCompany==null) {
				qualityArchiveCompany=new QualityArchiveCompany();
			}
		}
		return qualityArchiveCompany;
	}
    /**
     * 质量档案公司分页查询
     * @param request HttpServletRequest对象
     * @param qualityArchiveCompany 质量档案公司查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,QualityArchiveCompany qualityArchiveCompany,Page pageInfo) {
        Page<QualityArchiveCompany> qualityArchiveCompanyPage = qualityArchiveCompanyService.getListPage(qualityArchiveCompany,pageInfo);
        request.setAttribute("pageBean", qualityArchiveCompanyPage);
		listFormParam(request,qualityArchiveCompany,pageInfo);
    }
 	/**
     * 为质量档案公司分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param qualityArchiveCompany 质量档案公司查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,QualityArchiveCompany qualityArchiveCompany,Page pageInfo){
		//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加质量档案公司页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"qualityArchiveCompany");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加质量档案公司
     * @param request HttpServletRequest对象
     * @param qualityArchiveCompany 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("qualityArchiveCompany") QualityArchiveCompany qualityArchiveCompany,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统��间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	qualityArchiveCompany.setManageKey(Md5Util.getManageKey());
    	qualityArchiveCompanyService.add(qualityArchiveCompany);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改质量档案公司页面
     * @param qualityArchiveCompany 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="qualityArchiveCompany") QualityArchiveCompany qualityArchiveCompany,HttpServletRequest request) {
	request.setAttribute("tempBean", qualityArchiveCompany);
    	//复杂关联关系���据准备
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	//clearTempDataList(request.getSession(),"qualityArchiveCompany");
    }
    /**
     *  修改质量档案公司 
     * @param qualityArchiveCompany 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="qualityArchiveCompany") QualityArchiveCompany qualityArchiveCompany,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        qualityArchiveCompanyService.update(qualityArchiveCompany);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看质量档案公司页面
     * @param qualityArchiveCompany 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="qualityArchiveCompany") QualityArchiveCompany qualityArchiveCompany,HttpServletRequest request) {
	request.setAttribute("tempBean", qualityArchiveCompany);
    	//复杂关联关系数据准备
        listFormParam(request,qualityArchiveCompany,null);
    }
	/**
     * 删除单个质量档案公司对象
     * @param request HttpServletRequest对象
     * @param qualityArchiveCompany 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute QualityArchiveCompany qualityArchiveCompany) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	qualityArchiveCompanyService.delete(qualityArchiveCompany);
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
    	QualityArchiveCompany qualityArchiveCompany = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			qualityArchiveCompany = qualityArchiveCompanyService.getEntityByProperty(QualityArchiveCompany.class,"manageKey",manageKey);
    			qualityArchiveCompanyService.delete(qualityArchiveCompany);
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
		List<QualityArchiveCompany> qualityArchiveCompanys = new ArrayList<QualityArchiveCompany>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				QualityArchiveCompany temp_qualityArchiveCompany = qualityArchiveCompanyService.getEntityByProperty(QualityArchiveCompany.class, "manageKey", manageKey);
				if(temp_qualityArchiveCompany!=null && !qualityArchiveCompanys.contains(temp_qualityArchiveCompany)){
					qualityArchiveCompanys.add(temp_qualityArchiveCompany);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("qualityArchiveCompanys",qualityArchiveCompanys);
		return "qualityArchiveCompany/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param qualityArchiveCompany 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,QualityArchiveCompany qualityArchiveCompany,Page pageInfo){
		Page<HistoryRecord<QualityArchiveCompany>> qualityArchiveCompanyPage = qualityArchiveCompanyService.getHistoryListPage(qualityArchiveCompany, pageInfo);
		request.setAttribute("pageBean", qualityArchiveCompanyPage);
		request.setAttribute("manageKey", qualityArchiveCompany.getManageKey());
	    return "qualityArchiveCompany/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		QualityArchiveCompany qualityArchiveCompany = qualityArchiveCompanyService.findByVersion(version);
		QualityArchiveCompany preQualityArchiveCompany = (QualityArchiveCompany)qualityArchiveCompanyService.findByPreVersion(QualityArchiveCompany.class,qualityArchiveCompany.getManageKey(),version);
		if(preQualityArchiveCompany!=null && preQualityArchiveCompany.getManageKey().equals(qualityArchiveCompany.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preQualityArchiveCompany, qualityArchiveCompany);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", qualityArchiveCompany);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "qualityArchiveCompany/detail";
	}*/
	/**
	 * 根据关键字获取质量档案公司select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<QualityArchiveCompany> 质量档案公司Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<QualityArchiveCompany> select2Query(String queryKey,Page<QualityArchiveCompany> pageInfo, HttpServletResponse response) {
		Page<QualityArchiveCompany> page = qualityArchiveCompanyService.queryByKey(queryKey, pageInfo);
		Select2<QualityArchiveCompany> select2 = new Select2<QualityArchiveCompany>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个质量档案公司
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<QualityArchiveCompany> 质量档案公司列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<QualityArchiveCompany> queryById(Integer[] ids,HttpServletResponse response) {
		List<QualityArchiveCompany> qualityArchiveCompanyList = qualityArchiveCompanyService.queryById(ids);
		return qualityArchiveCompanyList;
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
			@ModelAttribute(value="qualityArchiveCompany") QualityArchiveCompany qualityArchiveCompany,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",qualityArchiveCompany);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "qualityArchiveCompany/tab-add-form";
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
			@ModelAttribute(value="qualityArchiveCompany") QualityArchiveCompany qualityArchiveCompany,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",qualityArchiveCompany);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "qualityArchiveCompany/tab-detail-form";
	}
}