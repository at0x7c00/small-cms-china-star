package me.huqiao.smallcms.cms.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.cms.entity.Carousel;
import me.huqiao.smallcms.cms.service.ICarouselService;
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
 * 轮播控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("carousel")
public class CarouselController  extends BaseController {
   /**轮播服务*/
    @Resource
    private ICarouselService carouselService;
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
		  * @return Carousel 轮播对象
		  */
		@ModelAttribute(value="carousel")
		public Carousel initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Carousel carousel = null;
		if (manageKey == null ||manageKey.equals("")) {
			carousel = new Carousel();
		} else {
			carousel =  carouselService.getEntityByProperty(Carousel.class,"manageKey", manageKey);
			if (carousel==null) {
				carousel=new Carousel();
			}
		}
		return carousel;
	}
    /**
     * 轮播分页查询
     * @param request HttpServletRequest对象
     * @param carousel 轮播查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Carousel carousel,Page pageInfo) {
        Page<Carousel> carouselPage = carouselService.getListPage(carousel,pageInfo);
        request.setAttribute("pageBean", carouselPage);
		listFormParam(request,carousel,pageInfo);
    }
 	/**
     * 为轮播分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param carousel 轮播查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Carousel carousel,Page pageInfo){
		//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加轮播页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"carousel");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加轮播
     * @param request HttpServletRequest对象
     * @param carousel 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("carousel") Carousel carousel,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	carousel.setPicture(parseFilee(request, "pictureKeys",null));
    	carousel.setManageKey(Md5Util.getManageKey());
    	carouselService.add(carousel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改轮播页面
     * @param carousel 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="carousel") Carousel carousel,HttpServletRequest request) {
	request.setAttribute("tempBean", carousel);
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	//clearTempDataList(request.getSession(),"carousel");
    }
    /**
     *  修改轮播 
     * @param carousel 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="carousel") Carousel carousel,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
    	carousel.setPicture(parseFilee(request, "pictureKeys",carousel.getPictureKey()));
        carouselService.update(carousel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看轮播页面
     * @param carousel 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="carousel") Carousel carousel,HttpServletRequest request) {
	request.setAttribute("tempBean", carousel);
    	//复杂关联关系数据准备
        listFormParam(request,carousel,null);
    }
	/**
     * 删除单个轮播对象
     * @param request HttpServletRequest对象
     * @param carousel 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Carousel carousel) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	markFileAsUnuse(carousel.getPicture());
        	carouselService.delete(carousel);
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
    	Carousel carousel = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			carousel = carouselService.getEntityByProperty(Carousel.class,"manageKey",manageKey);
    			markFileAsUnuse(carousel.getPicture());
    			carouselService.delete(carousel);
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
		List<Carousel> carousels = new ArrayList<Carousel>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Carousel temp_carousel = carouselService.getEntityByProperty(Carousel.class, "manageKey", manageKey);
				if(temp_carousel!=null && !carousels.contains(temp_carousel)){
					carousels.add(temp_carousel);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("carousels",carousels);
		return "carousel/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param carousel 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Carousel carousel,Page pageInfo){
		Page<HistoryRecord<Carousel>> carouselPage = carouselService.getHistoryListPage(carousel, pageInfo);
		request.setAttribute("pageBean", carouselPage);
		request.setAttribute("manageKey", carousel.getManageKey());
	    return "carousel/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Carousel carousel = carouselService.findByVersion(version);
		Carousel preCarousel = (Carousel)carouselService.findByPreVersion(Carousel.class,carousel.getManageKey(),version);
		if(preCarousel!=null && preCarousel.getManageKey().equals(carousel.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preCarousel, carousel);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", carousel);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "carousel/detail";
	}*/
	/**
	 * 根据关键字获取轮播select2对象
	 * @param queryKey ��询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Carousel> 轮播Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Carousel> select2Query(String queryKey,Page<Carousel> pageInfo, HttpServletResponse response) {
		Page<Carousel> page = carouselService.queryByKey(queryKey, pageInfo);
		Select2<Carousel> select2 = new Select2<Carousel>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个轮播
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Carousel> 轮播列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Carousel> queryById(Integer[] ids,HttpServletResponse response) {
		List<Carousel> carouselList = carouselService.queryById(ids);
		return carouselList;
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
			@ModelAttribute(value="carousel") Carousel carousel,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",carousel);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "carousel/tab-add-form";
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
			@ModelAttribute(value="carousel") Carousel carousel,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",carousel);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "carousel/tab-detail-form";
	}
}