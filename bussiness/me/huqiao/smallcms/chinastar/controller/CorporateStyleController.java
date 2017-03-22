package me.huqiao.smallcms.chinastar.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.chinastar.entity.CorporateStyle;
import me.huqiao.smallcms.chinastar.service.ICorporateStyleService;
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
 * 企业风采控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("corporateStyle")
public class CorporateStyleController  extends BaseController {
   /**企业风采服务*/
    @Resource
    private ICorporateStyleService corporateStyleService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
         binder.registerCustomEditor(User.class,new UserEditor(userService));
	}
    //复杂关联关系的Service
@Resource private ICommonFileService commonFileService;
@Resource private IUserService userService;
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return CorporateStyle 企业风采对象
		  */
		@ModelAttribute(value="corporateStyle")
		public CorporateStyle initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		CorporateStyle corporateStyle = null;
		if (manageKey == null ||manageKey.equals("")) {
			corporateStyle = new CorporateStyle();
		} else {
			corporateStyle =  corporateStyleService.getEntityByProperty(CorporateStyle.class,"manageKey", manageKey);
			if (corporateStyle==null) {
				corporateStyle=new CorporateStyle();
			}
		}
		return corporateStyle;
	}
    /**
     * 企业风采分页查询
     * @param request HttpServletRequest对象
     * @param corporateStyle 企业风采查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,CorporateStyle corporateStyle,Page pageInfo) {
        Page<CorporateStyle> corporateStylePage = corporateStyleService.getListPage(corporateStyle,pageInfo);
        request.setAttribute("pageBean", corporateStylePage);
		listFormParam(request,corporateStyle,pageInfo);
    }
 	/**
     * 为企业风采分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param corporateStyle 企业风采查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,CorporateStyle corporateStyle,Page pageInfo){
		//复杂关联关系数据准备
					List<User> userList = userService.getByProperties(User.class,null,null,null,null);
	request.setAttribute("userList",userList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加企业风采页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
					List<User> userList = userService.getByProperties(User.class,null,null,null,null);
	request.setAttribute("userList",userList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"corporateStyle");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加企业风采
     * @param request HttpServletRequest对象
     * @param corporateStyle 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("corporateStyle") CorporateStyle corporateStyle,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	corporateStyle.setCreator(getCurrentUser());
    	corporateStyle.setCreateTime(new Date());
    	corporateStyle.setUpdateTime(corporateStyle.getCreateTime());
		corporateStyle.setVideo(parseFilee(request,"videoKeys",null));
		corporateStyle.setCover(parseFilee(request,"coverKeys",null));
		corporateStyle.setManageKey(Md5Util.getManageKey());
    	corporateStyleService.add(corporateStyle);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改企业风采页面
     * @param corporateStyle 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="corporateStyle") CorporateStyle corporateStyle,HttpServletRequest request) {
	request.setAttribute("tempBean", corporateStyle);
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
					List<User> userList = userService.getByProperties(User.class,null,null,null,null);
	request.setAttribute("userList",userList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	//clearTempDataList(request.getSession(),"corporateStyle");
    }
    /**
     *  修改企业风采 
     * @param corporateStyle 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="corporateStyle") CorporateStyle corporateStyle,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
    	corporateStyle.setUpdateTime(new Date());
    	
    	String oldKey = null;
		if(corporateStyle.getVideo()!=null){
			oldKey = corporateStyle.getVideo().getManageKey();
		}
		corporateStyle.setVideo(parseFilee(request,"videoKeys",oldKey));
		
		String oldKey2 = null; 
		if(corporateStyle.getCover()!=null){
			oldKey2 = corporateStyle.getCover().getManageKey();
		}
		corporateStyle.setCover(parseFilee(request,"coverKeys",oldKey2));
		
		
        corporateStyleService.update(corporateStyle);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看企业风采页面
     * @param corporateStyle 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="corporateStyle") CorporateStyle corporateStyle,HttpServletRequest request) {
	request.setAttribute("tempBean", corporateStyle);
    	//复杂关联关系数据准备
        listFormParam(request,corporateStyle,null);
    }
	/**
     * 删除单个企业风采对象
     * @param request HttpServletRequest对象
     * @param corporateStyle 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute CorporateStyle corporateStyle) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	corporateStyleService.delete(corporateStyle);
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
    	CorporateStyle corporateStyle = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			corporateStyle = corporateStyleService.getEntityByProperty(CorporateStyle.class,"manageKey",manageKey);
    			markFileAsUnuse(corporateStyle.getVideo());
    			markFileAsUnuse(corporateStyle.getCover());
    			corporateStyleService.delete(corporateStyle);
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
		List<CorporateStyle> corporateStyles = new ArrayList<CorporateStyle>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				CorporateStyle temp_corporateStyle = corporateStyleService.getEntityByProperty(CorporateStyle.class, "manageKey", manageKey);
				if(temp_corporateStyle!=null && !corporateStyles.contains(temp_corporateStyle)){
					corporateStyles.add(temp_corporateStyle);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("corporateStyles",corporateStyles);
		return "corporateStyle/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param corporateStyle 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,CorporateStyle corporateStyle,Page pageInfo){
		Page<HistoryRecord<CorporateStyle>> corporateStylePage = corporateStyleService.getHistoryListPage(corporateStyle, pageInfo);
		request.setAttribute("pageBean", corporateStylePage);
		request.setAttribute("manageKey", corporateStyle.getManageKey());
	    return "corporateStyle/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		CorporateStyle corporateStyle = corporateStyleService.findByVersion(version);
		CorporateStyle preCorporateStyle = (CorporateStyle)corporateStyleService.findByPreVersion(CorporateStyle.class,corporateStyle.getManageKey(),version);
		if(preCorporateStyle!=null && preCorporateStyle.getManageKey().equals(corporateStyle.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preCorporateStyle, corporateStyle);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", corporateStyle);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "corporateStyle/detail";
	}*/
	/**
	 * 根据关键字获取企业风采select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<CorporateStyle> 企业风采Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<CorporateStyle> select2Query(String queryKey,Page<CorporateStyle> pageInfo, HttpServletResponse response) {
		Page<CorporateStyle> page = corporateStyleService.queryByKey(queryKey, pageInfo);
		Select2<CorporateStyle> select2 = new Select2<CorporateStyle>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个企业风采
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<CorporateStyle> 企业风采列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<CorporateStyle> queryById(Integer[] ids,HttpServletResponse response) {
		List<CorporateStyle> corporateStyleList = corporateStyleService.queryById(ids);
		return corporateStyleList;
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
			@ModelAttribute(value="corporateStyle") CorporateStyle corporateStyle,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",corporateStyle);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "corporateStyle/tab-add-form";
	}
/**
	 * tab页查看详��页面
	 * @param trTarget tr的target值
	 * @param trIndex tr的序号
     * @param propName 表单元素name前缀
	 * @return String jsp路径
	 */
	@RequestMapping(value = "/tabDetailForm")
	public String tabDetailForm(
			@ModelAttribute(value="corporateStyle") CorporateStyle corporateStyle,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",corporateStyle);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "corporateStyle/tab-detail-form";
	}
}