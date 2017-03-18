package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.Worker;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 工作人员DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IWorkerDao extends IBaseDao<Worker> {
    /**
     * 工作人员查询记录数量
     * @param worker 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Worker worker);
	/**
	 * 工作人员历史记录数量
     * @param worker 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Worker worker,Page pageInfo);
    /**
     * 工作人员分页查询
     * @param worker 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Worker>  工作人员列表 
     */
    List<Worker> findListPage(Worker worker, Page pageInfo);
	/**
	 * 工作人员历史记录分页查询
     * @param worker 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Worker>>  工作人员历史列表
	 */
    List<HistoryRecord<Worker>> findHistoryListPage(Worker worker, Page pageInfo);
	/**
     * 工作人员版本号查询
     * @param version 版本号
	 * @return Worker 工作人员历史记录
     */
	Worker findByVersion(Integer version);
	/**
	 * 添加工作人员查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param worker 查询对象
	 */
	public void queryCause(Criteria criteria, Worker worker);
	/**
	 * 工作人员关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Worker> 工作人员列表
	 */
	List<Worker> findByKey(Page pageInfo,String queryKey);
	/**
	 * 工作人员关��字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个工作人员
     * @param  ids id数组
	 * @return List<Worker>  工作人员列表
     */
	List<Worker> findById(Integer[] ids);
}