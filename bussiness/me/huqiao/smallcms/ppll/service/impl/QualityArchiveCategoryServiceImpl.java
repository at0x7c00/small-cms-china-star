package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IQualityArchiveCategoryDao;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCategoryService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 质量档案类别Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class QualityArchiveCategoryServiceImpl extends BaseServiceImpl<QualityArchiveCategory> implements IQualityArchiveCategoryService {
    /**质量档案类别DAO对象*/
    @Resource
    private IQualityArchiveCategoryDao qualityArchiveCategoryDao;
    @Override
    public Page<QualityArchiveCategory> getListPage(QualityArchiveCategory qualityArchiveCategory,Page pageInfo) {
      	pageInfo.setTotalCount(qualityArchiveCategoryDao.findListRowCount(qualityArchiveCategory).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(qualityArchiveCategoryDao.findListPage(qualityArchiveCategory,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<QualityArchiveCategory>> getHistoryListPage(QualityArchiveCategory qualityArchiveCategory, Page pageInfo) {
		pageInfo.setTotalCount(qualityArchiveCategoryDao.findHistoryListRowCount(qualityArchiveCategory,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(qualityArchiveCategoryDao.findHistoryListPage(qualityArchiveCategory,pageInfo));
        return pageInfo;
	}
	@Override
	public QualityArchiveCategory findByVersion(Integer version) {
		return qualityArchiveCategoryDao.findByVersion(version);
	}
	@Override
	public Page<QualityArchiveCategory> queryByKey(String queryKey, Page<QualityArchiveCategory> pageInfo) {
		int countRecord = qualityArchiveCategoryDao.findRowCount(queryKey).intValue();
		Page<QualityArchiveCategory> page = new Page<QualityArchiveCategory>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<QualityArchiveCategory> qualityArchiveCategoryList = qualityArchiveCategoryDao.findByKey(pageInfo,queryKey);
		page.setList(qualityArchiveCategoryList);
		return page;
	}
	@Override
	public List<QualityArchiveCategory> queryById(Integer[] ids) {
		return qualityArchiveCategoryDao.findById(ids);
	}
}