package me.huqiao.smallcms.chinastar.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.chinastar.dao.ISiteSettingDao;
import me.huqiao.smallcms.chinastar.entity.SiteSetting;
import me.huqiao.smallcms.chinastar.service.ISiteSettingService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 网站设置Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class SiteSettingServiceImpl extends BaseServiceImpl<SiteSetting> implements ISiteSettingService {
    /**网站设置DAO对象*/
    @Resource
    private ISiteSettingDao siteSettingDao;
    @Override
    public Page<SiteSetting> getListPage(SiteSetting siteSetting,Page pageInfo) {
      	pageInfo.setTotalCount(siteSettingDao.findListRowCount(siteSetting).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(siteSettingDao.findListPage(siteSetting,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<SiteSetting>> getHistoryListPage(SiteSetting siteSetting, Page pageInfo) {
		pageInfo.setTotalCount(siteSettingDao.findHistoryListRowCount(siteSetting,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(siteSettingDao.findHistoryListPage(siteSetting,pageInfo));
        return pageInfo;
	}
	@Override
	public SiteSetting findByVersion(Integer version) {
		return siteSettingDao.findByVersion(version);
	}
	@Override
	public Page<SiteSetting> queryByKey(String queryKey, Page<SiteSetting> pageInfo) {
		int countRecord = siteSettingDao.findRowCount(queryKey).intValue();
		Page<SiteSetting> page = new Page<SiteSetting>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<SiteSetting> siteSettingList = siteSettingDao.findByKey(pageInfo,queryKey);
		page.setList(siteSettingList);
		return page;
	}
	@Override
	public List<SiteSetting> queryById(Integer[] ids) {
		return siteSettingDao.findById(ids);
	}
	
	public SiteSetting getSetting(){
		return getById(SiteSetting.class, 1);
	}
}