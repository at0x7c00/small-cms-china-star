package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IApplyDao;
import me.huqiao.smallcms.ppll.entity.Apply;
import me.huqiao.smallcms.ppll.service.IApplyService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 会员入会申请Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class ApplyServiceImpl extends BaseServiceImpl<Apply> implements IApplyService {
    /**会员入会申请DAO对象*/
    @Resource
    private IApplyDao applyDao;
    @Override
    public Page<Apply> getListPage(Apply apply,Page pageInfo) {
      	pageInfo.setTotalCount(applyDao.findListRowCount(apply).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(applyDao.findListPage(apply,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Apply>> getHistoryListPage(Apply apply, Page pageInfo) {
		pageInfo.setTotalCount(applyDao.findHistoryListRowCount(apply,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(applyDao.findHistoryListPage(apply,pageInfo));
        return pageInfo;
	}
	@Override
	public Apply findByVersion(Integer version) {
		return applyDao.findByVersion(version);
	}
	@Override
	public Page<Apply> queryByKey(String queryKey, Page<Apply> pageInfo) {
		int countRecord = applyDao.findRowCount(queryKey).intValue();
		Page<Apply> page = new Page<Apply>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Apply> applyList = applyDao.findByKey(pageInfo,queryKey);
		page.setList(applyList);
		return page;
	}
	@Override
	public List<Apply> queryById(Integer[] ids) {
		return applyDao.findById(ids);
	}
}