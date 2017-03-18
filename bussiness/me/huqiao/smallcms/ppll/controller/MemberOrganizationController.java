package me.huqiao.smallcms.ppll.controller;
import java.util.ArrayList;
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
import me.huqiao.smallcms.ppll.entity.MemberOrganization;
import me.huqiao.smallcms.ppll.service.IMemberOrganizationService;
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
 * 会员单位控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("memberOrganization")
public class MemberOrganizationController  extends BaseController {
   /**会员单位服务*/
    @Resource
    private IMemberOrganizationService memberOrganizationService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
	}
    //复杂关联关系的Service
@Resource private ICommonFileService commonFileService;
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return MemberOrganization 会员单位对���
		  */
		@ModelAttribute(value="memberOrganization")
		public MemberOrganization initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		MemberOrganization memberOrganization = null;
		if (manageKey == null ||manageKey.equals("")) {
			memberOrganization = new MemberOrganization();
		} else {
			memberOrganization =  memberOrganizationService.getEntityByProperty(MemberOrganization.class,"manageKey", manageKey);
			if (memberOrganization==null) {
				memberOrganization=new MemberOrganization();
			}
		}
		return memberOrganization;
	}
    /**
     * 会员单位分页查询
     * @param request HttpServletRequest对象
     * @param memberOrganization 会员单位查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,MemberOrganization memberOrganization,Page pageInfo) {
        Page<MemberOrganization> memberOrganizationPage = memberOrganizationService.getListPage(memberOrganization,pageInfo);
        request.setAttribute("pageBean", memberOrganizationPage);
		listFormParam(request,memberOrganization,pageInfo);
    }
 	/**
     * 为会员单位分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param memberOrganization 会员单位查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,MemberOrganization memberOrganization,Page pageInfo){
		//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加会员单位页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"memberOrganization");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加会员单位
     * @param request HttpServletRequest对象
     * @param memberOrganization 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("memberOrganization") MemberOrganization memberOrganization,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
    	memberOrganization.setCertFile(parseFilee(request, "certFileKeys",null));
	memberOrganization.setManageKey(Md5Util.getManageKey());
    	memberOrganizationService.add(memberOrganization);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改会员单位页面
     * @param memberOrganization 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="memberOrganization") MemberOrganization memberOrganization,HttpServletRequest request) {
	request.setAttribute("tempBean", memberOrganization);
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"memberOrganization");
    }
    /**
     *  修改��员单位 
     * @param memberOrganization 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="memberOrganization") MemberOrganization memberOrganization,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
    	memberOrganization.setCertFile(parseFilee(request, "certFileKeys",memberOrganization.getCertFileKey()));
        memberOrganizationService.update(memberOrganization);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看会员单位页面
     * @param memberOrganization ���要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="memberOrganization") MemberOrganization memberOrganization,HttpServletRequest request) {
	request.setAttribute("tempBean", memberOrganization);
    	//复杂关联关系数据准备
        listFormParam(request,memberOrganization,null);
    }
	/**
     * 删除单个会员单位对象
     * @param request HttpServletRequest对象
     * @param memberOrganization 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute MemberOrganization memberOrganization) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	markFileAsUnuse(memberOrganization.getCertFile());
        	memberOrganizationService.delete(memberOrganization);
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
    	MemberOrganization memberOrganization = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			memberOrganization = memberOrganizationService.getEntityByProperty(MemberOrganization.class,"manageKey",manageKey);
    			markFileAsUnuse(memberOrganization.getCertFile());
    			memberOrganizationService.delete(memberOrganization);
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
		List<MemberOrganization> memberOrganizations = new ArrayList<MemberOrganization>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				MemberOrganization temp_memberOrganization = memberOrganizationService.getEntityByProperty(MemberOrganization.class, "manageKey", manageKey);
				if(temp_memberOrganization!=null && !memberOrganizations.contains(temp_memberOrganization)){
					memberOrganizations.add(temp_memberOrganization);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("memberOrganizations",memberOrganizations);
		return "memberOrganization/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param memberOrganization 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,MemberOrganization memberOrganization,Page pageInfo){
		Page<HistoryRecord<MemberOrganization>> memberOrganizationPage = memberOrganizationService.getHistoryListPage(memberOrganization, pageInfo);
		request.setAttribute("pageBean", memberOrganizationPage);
		request.setAttribute("manageKey", memberOrganization.getManageKey());
	    return "memberOrganization/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		MemberOrganization memberOrganization = memberOrganizationService.findByVersion(version);
		MemberOrganization preMemberOrganization = (MemberOrganization)memberOrganizationService.findByPreVersion(MemberOrganization.class,memberOrganization.getManageKey(),version);
		if(preMemberOrganization!=null && preMemberOrganization.getManageKey().equals(memberOrganization.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preMemberOrganization, memberOrganization);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", memberOrganization);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "memberOrganization/detail";
	}*/
	/**
	 * 根据关键字获取会员单位select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<MemberOrganization> 会员单位Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<MemberOrganization> select2Query(String queryKey,Page<MemberOrganization> pageInfo, HttpServletResponse response) {
		Page<MemberOrganization> page = memberOrganizationService.queryByKey(queryKey, pageInfo);
		Select2<MemberOrganization> select2 = new Select2<MemberOrganization>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个会员单位
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<MemberOrganization> 会员单位列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<MemberOrganization> queryById(Integer[] ids,HttpServletResponse response) {
		List<MemberOrganization> memberOrganizationList = memberOrganizationService.queryById(ids);
		return memberOrganizationList;
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
			@ModelAttribute(value="memberOrganization") MemberOrganization memberOrganization,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",memberOrganization);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "memberOrganization/tab-add-form";
	}
/**
	 * tab页查看详情页面
	 * @param trTarget tr的target值
	 * @param trIndex tr的序号
     * @param propName 表单元素name前缀
	 * @return String jsp��径
	 */
	@RequestMapping(value = "/tabDetailForm")
	public String tabDetailForm(
			@ModelAttribute(value="memberOrganization") MemberOrganization memberOrganization,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",memberOrganization);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "memberOrganization/tab-detail-form";
	}
}