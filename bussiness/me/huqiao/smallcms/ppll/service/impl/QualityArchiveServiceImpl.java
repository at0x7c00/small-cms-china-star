package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IQualityArchiveDao;
import me.huqiao.smallcms.ppll.entity.QualityArchive;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.ppll.service.IQualityArchiveService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 质量档案Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class QualityArchiveServiceImpl extends BaseServiceImpl<QualityArchive> implements IQualityArchiveService {
    /**质量档案DAO对象*/
    @Resource
    private IQualityArchiveDao qualityArchiveDao;
    @Override
    public Page<QualityArchive> getListPage(QualityArchive qualityArchive,Page pageInfo) {
      	pageInfo.setTotalCount(qualityArchiveDao.findListRowCount(qualityArchive).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(qualityArchiveDao.findListPage(qualityArchive,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<QualityArchive>> getHistoryListPage(QualityArchive qualityArchive, Page pageInfo) {
		pageInfo.setTotalCount(qualityArchiveDao.findHistoryListRowCount(qualityArchive,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(qualityArchiveDao.findHistoryListPage(qualityArchive,pageInfo));
        return pageInfo;
	}
	@Override
	public QualityArchive findByVersion(Integer version) {
		return qualityArchiveDao.findByVersion(version);
	}
	@Override
	public Page<QualityArchive> queryByKey(String queryKey, Page<QualityArchive> pageInfo) {
		int countRecord = qualityArchiveDao.findRowCount(queryKey).intValue();
		Page<QualityArchive> page = new Page<QualityArchive>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<QualityArchive> qualityArchiveList = qualityArchiveDao.findByKey(pageInfo,queryKey);
		page.setList(qualityArchiveList);
		return page;
	}
	@Override
	public List<QualityArchive> queryById(Integer[] ids) {
		return qualityArchiveDao.findById(ids);
	}
	@Override
	public Page<QualityArchive> getAll(QualityArchiveCategory category,Page<QualityArchive> pageInfo) {
		QualityArchive qualityArchive = new QualityArchive();
		qualityArchive.setCategory(category);
		getListPage(qualityArchive, pageInfo);
		return null;
	}
}