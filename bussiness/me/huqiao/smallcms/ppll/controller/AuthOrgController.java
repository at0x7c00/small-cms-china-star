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
import me.huqiao.smallcms.ppll.entity.AuthOrg;
import me.huqiao.smallcms.ppll.service.IAuthOrgService;
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
 * 授权机构控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("authOrg")
public class AuthOrgController  extends BaseController {
   /**授权机构服务*/
    @Resource
    private IAuthOrgService authOrgService;
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
		  * @return AuthOrg 授权机构对象
		  */
		@ModelAttribute(value="authOrg")
		public AuthOrg initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		AuthOrg authOrg = null;
		if (manageKey == null ||manageKey.equals("")) {
			authOrg = new AuthOrg();
		} else {
			authOrg =  authOrgService.getEntityByProperty(AuthOrg.class,"manageKey", manageKey);
			if (authOrg==null) {
				authOrg=new AuthOrg();
			}
		}
		return authOrg;
	}
    /**
     * 授权机构分页查询
     * @param request HttpServletRequest对象
     * @param authOrg 授权机构查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,AuthOrg authOrg,Page pageInfo) {
        Page<AuthOrg> authOrgPage = authOrgService.getListPage(authOrg,pageInfo);
        request.setAttribute("pageBean", authOrgPage);
		listFormParam(request,authOrg,pageInfo);
    }
 	/**
     * 为授权机构分页查询表��准备数据
     * @param request HttpServletRequest对象
     * @param authOrg 授权机构查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,AuthOrg authOrg,Page pageInfo){
		//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加授权机构页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"authOrg");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加授权机构
     * @param request HttpServletRequest对象
     * @param authOrg 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("authOrg") AuthOrg authOrg,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	authOrg.setCertFile(parseFilee(request, "certFileKeys",null));
    	authOrg.setManageKey(Md5Util.getManageKey());
    	authOrgService.add(authOrg);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改授权机构页面
     * @param authOrg 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="authOrg") AuthOrg authOrg,HttpServletRequest request) {
	request.setAttribute("tempBean", authOrg);
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"authOrg");
    }
    /**
     *  修改授权机构 
     * @param authOrg 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="authOrg") AuthOrg authOrg,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
    	authOrg.setCertFile(parseFilee(request, "certFileKeys",authOrg.getCertFileKey()));
        authOrgService.update(authOrg);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看授权机构页面
     * @param authOrg 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="authOrg") AuthOrg authOrg,HttpServletRequest request) {
	request.setAttribute("tempBean", authOrg);
    	//复杂关联关系数据准备
        listFormParam(request,authOrg,null);
    }
	/**
     * 删除单个授权机构对象
     * @param request HttpServletRequest对象
     * @param authOrg 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute AuthOrg authOrg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	markFileAsUnuse(authOrg.getCertFile());
        	authOrgService.delete(authOrg);
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
    	AuthOrg authOrg = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			authOrg = authOrgService.getEntityByProperty(AuthOrg.class,"manageKey",manageKey);
    			markFileAsUnuse(authOrg.getCertFile());
    			authOrgService.delete(authOrg);
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
		List<AuthOrg> authOrgs = new ArrayList<AuthOrg>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				AuthOrg temp_authOrg = authOrgService.getEntityByProperty(AuthOrg.class, "manageKey", manageKey);
				if(temp_authOrg!=null && !authOrgs.contains(temp_authOrg)){
					authOrgs.add(temp_authOrg);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("authOrgs",authOrgs);
		return "authOrg/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param authOrg 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,AuthOrg authOrg,Page pageInfo){
		Page<HistoryRecord<AuthOrg>> authOrgPage = authOrgService.getHistoryListPage(authOrg, pageInfo);
		request.setAttribute("pageBean", authOrgPage);
		request.setAttribute("manageKey", authOrg.getManageKey());
	    return "authOrg/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		AuthOrg authOrg = authOrgService.findByVersion(version);
		AuthOrg preAuthOrg = (AuthOrg)authOrgService.findByPreVersion(AuthOrg.class,authOrg.getManageKey(),version);
		if(preAuthOrg!=null && preAuthOrg.getManageKey().equals(authOrg.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preAuthOrg, authOrg);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", authOrg);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "authOrg/detail";
	}*/
	/**
	 * 根据关键字获取授权机构select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<AuthOrg> 授权机构Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<AuthOrg> select2Query(String queryKey,Page<AuthOrg> pageInfo, HttpServletResponse response) {
		Page<AuthOrg> page = authOrgService.queryByKey(queryKey, pageInfo);
		Select2<AuthOrg> select2 = new Select2<AuthOrg>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个授权机构
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<AuthOrg> 授权机构列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<AuthOrg> queryById(Integer[] ids,HttpServletResponse response) {
		List<AuthOrg> authOrgList = authOrgService.queryById(ids);
		return authOrgList;
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
			@ModelAttribute(value="authOrg") AuthOrg authOrg,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",authOrg);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "authOrg/tab-add-form";
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
			@ModelAttribute(value="authOrg") AuthOrg authOrg,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",authOrg);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "authOrg/tab-detail-form";
	}
}