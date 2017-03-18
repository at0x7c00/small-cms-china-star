package me.huqiao.smallcms.cms.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.cms.entity.Advertisement;
import me.huqiao.smallcms.cms.service.IAdvertisementService;
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
 * 广告控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("advertisement")
public class AdvertisementController  extends BaseController {
   /**广告服务*/
    @Resource
    private IAdvertisementService advertisementService;
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
		  * @return Advertisement 广告对象
		  */
		@ModelAttribute(value="advertisement")
		public Advertisement initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Advertisement advertisement = null;
		if (manageKey == null ||manageKey.equals("")) {
			advertisement = new Advertisement();
		} else {
			advertisement =  advertisementService.getEntityByProperty(Advertisement.class,"manageKey", manageKey);
			if (advertisement==null) {
				advertisement=new Advertisement();
			}
		}
		return advertisement;
	}
    /**
     * 广告分页查询
     * @param request HttpServletRequest对象
     * @param advertisement 广告查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Advertisement advertisement,Page pageInfo) {
        Page<Advertisement> advertisementPage = advertisementService.getListPage(advertisement,pageInfo);
        request.setAttribute("pageBean", advertisementPage);
		listFormParam(request,advertisement,pageInfo);
    }
 	/**
     * 为广告分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param advertisement 广告查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Advertisement advertisement,Page pageInfo){
		//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加广告页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
    	request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"advertisement");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加广告
     * @param request HttpServletRequest对象
     * @param advertisement 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("advertisement") Advertisement advertisement,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
    	advertisement.setPicture(parseFilee(request, "pictureKeys",null));
    	advertisement.setManageKey(Md5Util.getManageKey());
    	advertisementService.add(advertisement);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改广告页面
     * @param advertisement 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="advertisement") Advertisement advertisement,HttpServletRequest request) {
	request.setAttribute("tempBean", advertisement);
    	//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"advertisement");
    }
    /**
     *  修改广告 
     * @param advertisement 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="advertisement") Advertisement advertisement,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
    	advertisement.setPicture(parseFilee(request, "pictureKeys",advertisement.getPictureKey()));
        advertisementService.update(advertisement);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看广告页面
     * @param advertisement 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="advertisement") Advertisement advertisement,HttpServletRequest request) {
	request.setAttribute("tempBean", advertisement);
    	//复杂关联关系数据准备
        listFormParam(request,advertisement,null);
    }
	/**
     * 删除单个广告对象
     * @param request HttpServletRequest对象
     * @param advertisement 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Advertisement advertisement) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	markFileAsUnuse(advertisement.getPicture());
        	advertisementService.delete(advertisement);
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
    	Advertisement advertisement = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			advertisement = advertisementService.getEntityByProperty(Advertisement.class,"manageKey",manageKey);
    			markFileAsUnuse(advertisement.getPicture());
    			advertisementService.delete(advertisement);
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
		List<Advertisement> advertisements = new ArrayList<Advertisement>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Advertisement temp_advertisement = advertisementService.getEntityByProperty(Advertisement.class, "manageKey", manageKey);
				if(temp_advertisement!=null && !advertisements.contains(temp_advertisement)){
					advertisements.add(temp_advertisement);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("advertisements",advertisements);
		return "advertisement/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param advertisement 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Advertisement advertisement,Page pageInfo){
		Page<HistoryRecord<Advertisement>> advertisementPage = advertisementService.getHistoryListPage(advertisement, pageInfo);
		request.setAttribute("pageBean", advertisementPage);
		request.setAttribute("manageKey", advertisement.getManageKey());
	    return "advertisement/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Advertisement advertisement = advertisementService.findByVersion(version);
		Advertisement preAdvertisement = (Advertisement)advertisementService.findByPreVersion(Advertisement.class,advertisement.getManageKey(),version);
		if(preAdvertisement!=null && preAdvertisement.getManageKey().equals(advertisement.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preAdvertisement, advertisement);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", advertisement);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "advertisement/detail";
	}*/
	/**
	 * 根据关键字获取广告select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Advertisement> 广告Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Advertisement> select2Query(String queryKey,Page<Advertisement> pageInfo, HttpServletResponse response) {
		Page<Advertisement> page = advertisementService.queryByKey(queryKey, pageInfo);
		Select2<Advertisement> select2 = new Select2<Advertisement>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个广告
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Advertisement> 广告列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Advertisement> queryById(Integer[] ids,HttpServletResponse response) {
		List<Advertisement> advertisementList = advertisementService.queryById(ids);
		return advertisementList;
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
			@ModelAttribute(value="advertisement") Advertisement advertisement,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",advertisement);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "advertisement/tab-add-form";
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
			@ModelAttribute(value="advertisement") Advertisement advertisement,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",advertisement);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "advertisement/tab-detail-form";
	}
}