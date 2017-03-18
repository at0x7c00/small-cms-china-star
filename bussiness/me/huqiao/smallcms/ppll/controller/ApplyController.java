package me.huqiao.smallcms.ppll.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.ppll.entity.Apply;
import me.huqiao.smallcms.ppll.service.IApplyService;
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
 * 会员入会申请控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("apply")
public class ApplyController  extends BaseController {
   /**会员入会申请服务*/
    @Resource
    private IApplyService applyService;
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
		  * @return Apply 会员入会申请对象
		  */
		@ModelAttribute(value="apply")
		public Apply initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Apply apply = null;
		if (manageKey == null ||manageKey.equals("")) {
			apply = new Apply();
		} else {
			apply =  applyService.getEntityByProperty(Apply.class,"manageKey", manageKey);
			if (apply==null) {
				apply=new Apply();
			}
		}
		return apply;
	}
    /**
     * 会员入会申请分页查询
     * @param request HttpServletRequest对象
     * @param apply 会员入会申请查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Apply apply,Page pageInfo) {
        Page<Apply> applyPage = applyService.getListPage(apply,pageInfo);
        request.setAttribute("pageBean", applyPage);
		listFormParam(request,apply,pageInfo);
    }
 	/**
     * 为会员入会申请分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param apply 会员入会申请查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Apply apply,Page pageInfo){
		//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加会员入会申请页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"apply");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加会员入会申请
     * @param request HttpServletRequest对象
     * @param apply 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("apply") Apply apply,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	apply.setCreateTime(new Date());
    	apply.setManageKey(Md5Util.getManageKey());
    	applyService.add(apply);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改会员入会申请页面
     * @param apply 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="apply") Apply apply,HttpServletRequest request) {
	request.setAttribute("tempBean", apply);
    	//复杂关联关系数据准备
	//clearTempDataList(request.getSession(),"apply");
    }
    /**
     *  修改会员入会申请 
     * @param apply 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="apply") Apply apply,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        applyService.update(apply);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看会员入会申请页面
     * @param apply 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="apply") Apply apply,HttpServletRequest request) {
	request.setAttribute("tempBean", apply);
    	//复杂关联关系数据准备
        listFormParam(request,apply,null);
    }
	/**
     * 删除单个会员入会申请对象
     * @param request HttpServletRequest对象
     * @param apply 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Apply apply) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	applyService.delete(apply);
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
    	Apply apply = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			apply = applyService.getEntityByProperty(Apply.class,"manageKey",manageKey);
    			applyService.delete(apply);
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
		List<Apply> applys = new ArrayList<Apply>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Apply temp_apply = applyService.getEntityByProperty(Apply.class, "manageKey", manageKey);
				if(temp_apply!=null && !applys.contains(temp_apply)){
					applys.add(temp_apply);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("applys",applys);
		return "apply/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param apply 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Apply apply,Page pageInfo){
		Page<HistoryRecord<Apply>> applyPage = applyService.getHistoryListPage(apply, pageInfo);
		request.setAttribute("pageBean", applyPage);
		request.setAttribute("manageKey", apply.getManageKey());
	    return "apply/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Apply apply = applyService.findByVersion(version);
		Apply preApply = (Apply)applyService.findByPreVersion(Apply.class,apply.getManageKey(),version);
		if(preApply!=null && preApply.getManageKey().equals(apply.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preApply, apply);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", apply);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "apply/detail";
	}*/
	/**
	 * 根据关键字获取会员入会申请select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Apply> 会员入会申请Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Apply> select2Query(String queryKey,Page<Apply> pageInfo, HttpServletResponse response) {
		Page<Apply> page = applyService.queryByKey(queryKey, pageInfo);
		Select2<Apply> select2 = new Select2<Apply>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个会员入会申请
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Apply> 会员入会申请列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Apply> queryById(Integer[] ids,HttpServletResponse response) {
		List<Apply> applyList = applyService.queryById(ids);
		return applyList;
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
			@ModelAttribute(value="apply") Apply apply,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",apply);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "apply/tab-add-form";
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
			@ModelAttribute(value="apply") Apply apply,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",apply);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "apply/tab-detail-form";
	}
}