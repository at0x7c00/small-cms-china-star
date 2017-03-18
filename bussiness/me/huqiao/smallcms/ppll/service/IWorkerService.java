package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.Worker;
import me.huqiao.smallcms.util.web.Page;
/**
 * 工作人员Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IWorkerService extends IBaseService<Worker> {
    /**
     * 工作人员分页查询
     * @param worker 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Worker> 工作人员分页信息对象
     */
    public Page<Worker> getListPage(Worker worker,Page pageInfo);
	/**
	  * 工作人员历史记录分页查询
	  * @param worker 查询���象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Worker>> 工作人员历史分页信息对象
	  */
	public Page<HistoryRecord<Worker>> getHistoryListPage(Worker worker,Page pageInfo);
	/**
	 * 工作人员版本号查询
	 * @param version 查询版本号
	 * @return Worker 工作人员历史记录
	 */
	public Worker findByVersion(Integer version);
	/**
	 * 工作人员关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Worker> 工作人员分页信息对象
	 * 
	 */
	Page<Worker> queryByKey(String queryKey, Page<Worker> pageInfo);
	/**
	 * 查找多个工作人员
	 * @param ids id数组
	 * @return List<Worker> 工作人员列表
	 * 
	 */
	List<Worker> queryById(Integer[] ids);
}