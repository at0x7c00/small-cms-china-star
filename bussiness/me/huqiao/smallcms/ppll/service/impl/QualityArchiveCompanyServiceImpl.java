package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IQualityArchiveCompanyDao;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCompany;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCompanyService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 质量档案公司Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class QualityArchiveCompanyServiceImpl extends BaseServiceImpl<QualityArchiveCompany> implements IQualityArchiveCompanyService {
    /**质量档案公司DAO对象*/
    @Resource
    private IQualityArchiveCompanyDao qualityArchiveCompanyDao;
    @Override
    public Page<QualityArchiveCompany> getListPage(QualityArchiveCompany qualityArchiveCompany,Page pageInfo) {
      	pageInfo.setTotalCount(qualityArchiveCompanyDao.findListRowCount(qualityArchiveCompany).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(qualityArchiveCompanyDao.findListPage(qualityArchiveCompany,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<QualityArchiveCompany>> getHistoryListPage(QualityArchiveCompany qualityArchiveCompany, Page pageInfo) {
		pageInfo.setTotalCount(qualityArchiveCompanyDao.findHistoryListRowCount(qualityArchiveCompany,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(qualityArchiveCompanyDao.findHistoryListPage(qualityArchiveCompany,pageInfo));
        return pageInfo;
	}
	@Override
	public QualityArchiveCompany findByVersion(Integer version) {
		return qualityArchiveCompanyDao.findByVersion(version);
	}
	@Override
	public Page<QualityArchiveCompany> queryByKey(String queryKey, Page<QualityArchiveCompany> pageInfo) {
		int countRecord = qualityArchiveCompanyDao.findRowCount(queryKey).intValue();
		Page<QualityArchiveCompany> page = new Page<QualityArchiveCompany>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<QualityArchiveCompany> qualityArchiveCompanyList = qualityArchiveCompanyDao.findByKey(pageInfo,queryKey);
		page.setList(qualityArchiveCompanyList);
		return page;
	}
	@Override
	public List<QualityArchiveCompany> queryById(Integer[] ids) {
		return qualityArchiveCompanyDao.findById(ids);
	}
}