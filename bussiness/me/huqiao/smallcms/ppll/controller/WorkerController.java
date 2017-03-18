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
import me.huqiao.smallcms.ppll.entity.Worker;
import me.huqiao.smallcms.ppll.service.IWorkerService;
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
 * 工作人员控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("worker")
public class WorkerController  extends BaseController {
   /**工作人员服务*/
    @Resource
    private IWorkerService workerService;
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
		  * @return Worker 工作人员对象
		  */
		@ModelAttribute(value="worker")
		public Worker initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Worker worker = null;
		if (manageKey == null ||manageKey.equals("")) {
			worker = new Worker();
		} else {
			worker =  workerService.getEntityByProperty(Worker.class,"manageKey", manageKey);
			if (worker==null) {
				worker=new Worker();
			}
		}
		return worker;
	}
    /**
     * 工作人员分页查询
     * @param request HttpServletRequest对象
     * @param worker 工作人员查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Worker worker,Page pageInfo) {
        Page<Worker> workerPage = workerService.getListPage(worker,pageInfo);
        request.setAttribute("pageBean", workerPage);
		listFormParam(request,worker,pageInfo);
    }
 	/**
     * 为工作人员分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param worker 工作人员查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Worker worker,Page pageInfo){
		//复杂关联关系数据准备
		request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加工作人员页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
		//clearTempDataList(request.getSession(),"worker");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加工作人员
     * @param request HttpServletRequest对象
     * @param worker 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("worker") Worker worker,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
    	worker.setPhotoFile(parseFilee(request, "photoFileKeys",null));
	worker.setManageKey(Md5Util.getManageKey());
    	workerService.add(worker);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改工作人员页面
     * @param worker 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="worker") Worker worker,HttpServletRequest request) {
	request.setAttribute("tempBean", worker);
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
	//clearTempDataList(request.getSession(),"worker");
    }
    /**
     *  修改工作人员 
     * @param worker 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="worker") Worker worker,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
    	worker.setPhotoFile(parseFilee(request, "photoFileKeys",worker.getPotoFileKey()));
        workerService.update(worker);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看工作人员页面
     * @param worker 需���查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="worker") Worker worker,HttpServletRequest request) {
	request.setAttribute("tempBean", worker);
    	//复杂关联关系数据准备
        listFormParam(request,worker,null);
    }
	/**
     * 删除单个工作人员对象
     * @param request HttpServletRequest对象
     * @param worker 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Worker worker) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	markFileAsUnuse(worker.getPhotoFile());
        	workerService.delete(worker);
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
    	Worker worker = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			worker = workerService.getEntityByProperty(Worker.class,"manageKey",manageKey);
    			markFileAsUnuse(worker.getPhotoFile());
    			workerService.delete(worker);
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
		List<Worker> workers = new ArrayList<Worker>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Worker temp_worker = workerService.getEntityByProperty(Worker.class, "manageKey", manageKey);
				if(temp_worker!=null && !workers.contains(temp_worker)){
					workers.add(temp_worker);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("workers",workers);
		return "worker/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param worker 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Worker worker,Page pageInfo){
		Page<HistoryRecord<Worker>> workerPage = workerService.getHistoryListPage(worker, pageInfo);
		request.setAttribute("pageBean", workerPage);
		request.setAttribute("manageKey", worker.getManageKey());
	    return "worker/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Worker worker = workerService.findByVersion(version);
		Worker preWorker = (Worker)workerService.findByPreVersion(Worker.class,worker.getManageKey(),version);
		if(preWorker!=null && preWorker.getManageKey().equals(worker.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preWorker, worker);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", worker);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "worker/detail";
	}*/
	/**
	 * 根据关键字获取工作人员select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Worker> 工作人员Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Worker> select2Query(String queryKey,Page<Worker> pageInfo, HttpServletResponse response) {
		Page<Worker> page = workerService.queryByKey(queryKey, pageInfo);
		Select2<Worker> select2 = new Select2<Worker>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个工作人员
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Worker> 工作人员列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Worker> queryById(Integer[] ids,HttpServletResponse response) {
		List<Worker> workerList = workerService.queryById(ids);
		return workerList;
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
			@ModelAttribute(value="worker") Worker worker,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",worker);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "worker/tab-add-form";
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
			@ModelAttribute(value="worker") Worker worker,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",worker);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "worker/tab-detail-form";
	}
}