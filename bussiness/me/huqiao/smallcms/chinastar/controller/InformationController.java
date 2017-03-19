package me.huqiao.smallcms.chinastar.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.chinastar.entity.Information;
import me.huqiao.smallcms.chinastar.service.IInformationService;
import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.common.entity.propertyeditor.CommonFileEditor;
import me.huqiao.smallcms.common.service.ICommonFileService;
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
 * 资讯控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("information")
public class InformationController  extends BaseController {
   /**资讯服务*/
    @Resource
    private IInformationService informationService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(User.class,new UserEditor(userService));
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
	}
    //复杂关联关系的Service
@Resource private IUserService userService;
@Resource private ICommonFileService commonFileService;
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return Information 资讯对象
		  */
		@ModelAttribute(value="information")
		public Information initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Information information = null;
		if (manageKey == null ||manageKey.equals("")) {
			information = new Information();
		} else {
			information =  informationService.getEntityByProperty(Information.class,"manageKey", manageKey);
			if (information==null) {
				information=new Information();
			}
		}
		return information;
	}
    /**
     * 资讯分页查询
     * @param request HttpServletRequest对象
     * @param information 资讯查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Information information,Page pageInfo) {
        Page<Information> informationPage = informationService.getListPage(information,pageInfo);
        request.setAttribute("pageBean", informationPage);
		listFormParam(request,information,pageInfo);
    }
 	/**
     * 为资讯分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param information 资讯查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Information information,Page pageInfo){
		//复杂关联关系数据准备
					List<User> userList = userService.getByProperties(User.class,null,null,null,null);
	request.setAttribute("userList",userList);
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加资讯页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<User> userList = userService.getByProperties(User.class,null,null,null,null);
	request.setAttribute("userList",userList);
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"information");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加资讯
     * @param request HttpServletRequest对象
     * @param information 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("information") Information information,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	markFileAsInuse(commonFileService.findAttachementFromContent(information.getContent()));
		information.setCover(parseFilee(request,"coverKeys",null));
		information.setCreateTime(new Date());
		information.setUpdateTime(information.getCreateTime());
		information.setCreator(getCurrentUser());
		information.setManageKey(Md5Util.getManageKey());
    	informationService.add(information);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改资讯页面
     * @param information 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="information") Information information,HttpServletRequest request) {
	request.setAttribute("tempBean", information);
    	//复杂关联关系数据准备
					List<User> userList = userService.getByProperties(User.class,null,null,null,null);
	request.setAttribute("userList",userList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	//clearTempDataList(request.getSession(),"information");
    }
    /**
     *  修改资讯 
     * @param information 待修改的实体对象
     * @param request HttpServletRequest��象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="information") Information information,
	@RequestParam(value = "newContent")String newContent,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
    	markFileAsUnuse(commonFileService.findAttachementFromContent(information.getContent()));
    	markFileAsInuse(commonFileService.findAttachementFromContent(newContent));
    	information.setContent(newContent);
    	information.setUpdateTime(new Date());

    	String oldKey = null; 
		if(information.getCover()!=null){
			oldKey = information.getCover().getManageKey();
		}
		information.setCover(parseFilee(request,"coverKeys",oldKey));
		
        informationService.update(information);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看资讯页面
     * @param information 需要查看���实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="information") Information information,HttpServletRequest request) {
	request.setAttribute("tempBean", information);
    	//复杂关联关系数据准备
        listFormParam(request,information,null);
    }
	/**
     * 删除单个资讯对象
     * @param request HttpServletRequest对象
     * @param information 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Information information) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	informationService.delete(information);
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
    	Information information = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			information = informationService.getEntityByProperty(Information.class,"manageKey",manageKey);
    			markFileAsUnuse(commonFileService.findAttachementFromContent(information.getContent()));
    			markFileAsUnuse(information.getCover());
    			informationService.delete(information);
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
		List<Information> informations = new ArrayList<Information>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Information temp_information = informationService.getEntityByProperty(Information.class, "manageKey", manageKey);
				if(temp_information!=null && !informations.contains(temp_information)){
					informations.add(temp_information);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("informations",informations);
		return "information/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param information 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Information information,Page pageInfo){
		Page<HistoryRecord<Information>> informationPage = informationService.getHistoryListPage(information, pageInfo);
		request.setAttribute("pageBean", informationPage);
		request.setAttribute("manageKey", information.getManageKey());
	    return "information/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Information information = informationService.findByVersion(version);
		Information preInformation = (Information)informationService.findByPreVersion(Information.class,information.getManageKey(),version);
		if(preInformation!=null && preInformation.getManageKey().equals(information.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preInformation, information);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", information);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "information/detail";
	}*/
	/**
	 * 根据关键字获取资讯select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Information> 资讯Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Information> select2Query(String queryKey,Page<Information> pageInfo, HttpServletResponse response) {
		Page<Information> page = informationService.queryByKey(queryKey, pageInfo);
		Select2<Information> select2 = new Select2<Information>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个资讯
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Information> 资讯列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Information> queryById(Integer[] ids,HttpServletResponse response) {
		List<Information> informationList = informationService.queryById(ids);
		return informationList;
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
			@ModelAttribute(value="information") Information information,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",information);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "information/tab-add-form";
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
			@ModelAttribute(value="information") Information information,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",information);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "information/tab-detail-form";
	}
}