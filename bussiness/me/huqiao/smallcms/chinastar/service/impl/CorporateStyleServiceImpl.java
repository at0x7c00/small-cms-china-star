package me.huqiao.smallcms.chinastar.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.chinastar.dao.ICorporateStyleDao;
import me.huqiao.smallcms.chinastar.entity.CorporateStyle;
import me.huqiao.smallcms.chinastar.service.ICorporateStyleService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 企业风采Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class CorporateStyleServiceImpl extends BaseServiceImpl<CorporateStyle> implements ICorporateStyleService {
    /**企业风采DAO对象*/
    @Resource
    private ICorporateStyleDao corporateStyleDao;
    @Override
    public Page<CorporateStyle> getListPage(CorporateStyle corporateStyle,Page pageInfo) {
      	pageInfo.setTotalCount(corporateStyleDao.findListRowCount(corporateStyle).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(corporateStyleDao.findListPage(corporateStyle,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<CorporateStyle>> getHistoryListPage(CorporateStyle corporateStyle, Page pageInfo) {
		pageInfo.setTotalCount(corporateStyleDao.findHistoryListRowCount(corporateStyle,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(corporateStyleDao.findHistoryListPage(corporateStyle,pageInfo));
        return pageInfo;
	}
	@Override
	public CorporateStyle findByVersion(Integer version) {
		return corporateStyleDao.findByVersion(version);
	}
	@Override
	public Page<CorporateStyle> queryByKey(String queryKey, Page<CorporateStyle> pageInfo) {
		int countRecord = corporateStyleDao.findRowCount(queryKey).intValue();
		Page<CorporateStyle> page = new Page<CorporateStyle>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<CorporateStyle> corporateStyleList = corporateStyleDao.findByKey(pageInfo,queryKey);
		page.setList(corporateStyleList);
		return page;
	}
	@Override
	public List<CorporateStyle> queryById(Integer[] ids) {
		return corporateStyleDao.findById(ids);
	}
}