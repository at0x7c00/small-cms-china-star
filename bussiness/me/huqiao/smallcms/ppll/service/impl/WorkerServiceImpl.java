package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IWorkerDao;
import me.huqiao.smallcms.ppll.entity.Worker;
import me.huqiao.smallcms.ppll.service.IWorkerService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 工作人员Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class WorkerServiceImpl extends BaseServiceImpl<Worker> implements IWorkerService {
    /**工作人员DAO对象*/
    @Resource
    private IWorkerDao workerDao;
    @Override
    public Page<Worker> getListPage(Worker worker,Page pageInfo) {
      	pageInfo.setTotalCount(workerDao.findListRowCount(worker).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(workerDao.findListPage(worker,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Worker>> getHistoryListPage(Worker worker, Page pageInfo) {
		pageInfo.setTotalCount(workerDao.findHistoryListRowCount(worker,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(workerDao.findHistoryListPage(worker,pageInfo));
        return pageInfo;
	}
	@Override
	public Worker findByVersion(Integer version) {
		return workerDao.findByVersion(version);
	}
	@Override
	public Page<Worker> queryByKey(String queryKey, Page<Worker> pageInfo) {
		int countRecord = workerDao.findRowCount(queryKey).intValue();
		Page<Worker> page = new Page<Worker>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Worker> workerList = workerDao.findByKey(pageInfo,queryKey);
		page.setList(workerList);
		return page;
	}
	@Override
	public List<Worker> queryById(Integer[] ids) {
		return workerDao.findById(ids);
	}
}