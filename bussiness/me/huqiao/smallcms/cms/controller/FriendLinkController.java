package me.huqiao.smallcms.cms.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.cms.entity.FriendLink;
import me.huqiao.smallcms.cms.service.IFriendLinkService;
import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
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
 * 友情链接控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("friendLink")
public class FriendLinkController  extends BaseController {
   /**友情链接服务*/
    @Resource
    private IFriendLinkService friendLinkService;
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
		  * @return FriendLink 友情链接对象
		  */
		@ModelAttribute(value="friendLink")
		public FriendLink initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		FriendLink friendLink = null;
		if (manageKey == null ||manageKey.equals("")) {
			friendLink = new FriendLink();
		} else {
			friendLink =  friendLinkService.getEntityByProperty(FriendLink.class,"manageKey", manageKey);
			if (friendLink==null) {
				friendLink=new FriendLink();
			}
		}
		return friendLink;
	}
    /**
     * 友情链接分页查询
     * @param request HttpServletRequest对象
     * @param friendLink 友情链接查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,FriendLink friendLink,Page pageInfo) {
        Page<FriendLink> friendLinkPage = friendLinkService.getListPage(friendLink,pageInfo);
        request.setAttribute("pageBean", friendLinkPage);
		listFormParam(request,friendLink,pageInfo);
    }
 	/**
     * 为友情链接分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param friendLink 友情链接查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,FriendLink friendLink,Page pageInfo){
		//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加友情链接页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
    	request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"friendLink");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加友情链接
     * @param request HttpServletRequest对象
     * @param friendLink 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("friendLink") FriendLink friendLink,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	friendLink.setPicture(parseFilee(request, "pictureKeys",null));
    	friendLink.setManageKey(Md5Util.getManageKey());
    	friendLinkService.add(friendLink);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改友情链接页面
     * @param friendLink 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="friendLink") FriendLink friendLink,HttpServletRequest request) {
	request.setAttribute("tempBean", friendLink);
    	//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//	clearTempDataList(request.getSession(),"friendLink");
    }
    /**
     *  修改友情链接 
     * @param friendLink 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="friendLink") FriendLink friendLink,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
    	friendLink.setPicture(parseFilee(request, "pictureKeys",friendLink.getPictureKey()));
        friendLinkService.update(friendLink);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看友情链接页面
     * @param friendLink 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="friendLink") FriendLink friendLink,HttpServletRequest request) {
	request.setAttribute("tempBean", friendLink);
    	//复杂关联关系数据准备
        listFormParam(request,friendLink,null);
    }
	/**
     * 删除单个友情链接对象
     * @param request HttpServletRequest对象
     * @param friendLink 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute FriendLink friendLink) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	markFileAsUnuse(friendLink.getPicture());
        	friendLinkService.delete(friendLink);
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
    	FriendLink friendLink = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			friendLink = friendLinkService.getEntityByProperty(FriendLink.class,"manageKey",manageKey);
    			markFileAsUnuse(friendLink.getPicture());
    			friendLinkService.delete(friendLink);
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
		List<FriendLink> friendLinks = new ArrayList<FriendLink>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				FriendLink temp_friendLink = friendLinkService.getEntityByProperty(FriendLink.class, "manageKey", manageKey);
				if(temp_friendLink!=null && !friendLinks.contains(temp_friendLink)){
					friendLinks.add(temp_friendLink);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("friendLinks",friendLinks);
		return "friendLink/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param friendLink 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,FriendLink friendLink,Page pageInfo){
		Page<HistoryRecord<FriendLink>> friendLinkPage = friendLinkService.getHistoryListPage(friendLink, pageInfo);
		request.setAttribute("pageBean", friendLinkPage);
		request.setAttribute("manageKey", friendLink.getManageKey());
	    return "friendLink/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		FriendLink friendLink = friendLinkService.findByVersion(version);
		FriendLink preFriendLink = (FriendLink)friendLinkService.findByPreVersion(FriendLink.class,friendLink.getManageKey(),version);
		if(preFriendLink!=null && preFriendLink.getManageKey().equals(friendLink.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preFriendLink, friendLink);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", friendLink);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "friendLink/detail";
	}*/
	/**
	 * 根据关键字获取友情链接select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<FriendLink> 友情链接Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<FriendLink> select2Query(String queryKey,Page<FriendLink> pageInfo, HttpServletResponse response) {
		Page<FriendLink> page = friendLinkService.queryByKey(queryKey, pageInfo);
		Select2<FriendLink> select2 = new Select2<FriendLink>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个友情链接
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<FriendLink> 友情链接列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<FriendLink> queryById(Integer[] ids,HttpServletResponse response) {
		List<FriendLink> friendLinkList = friendLinkService.queryById(ids);
		return friendLinkList;
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
			@ModelAttribute(value="friendLink") FriendLink friendLink,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",friendLink);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "friendLink/tab-add-form";
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
			@ModelAttribute(value="friendLink") FriendLink friendLink,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",friendLink);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "friendLink/tab-detail-form";
	}
}