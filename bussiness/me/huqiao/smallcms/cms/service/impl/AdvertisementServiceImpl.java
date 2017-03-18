package me.huqiao.smallcms.cms.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.cms.dao.IAdvertisementDao;
import me.huqiao.smallcms.cms.entity.Advertisement;
import me.huqiao.smallcms.cms.service.IAdvertisementService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 广告Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class AdvertisementServiceImpl extends BaseServiceImpl<Advertisement> implements IAdvertisementService {
    /**广告DAO对象*/
    @Resource
    private IAdvertisementDao advertisementDao;
    @Override
    public Page<Advertisement> getListPage(Advertisement advertisement,Page pageInfo) {
      	pageInfo.setTotalCount(advertisementDao.findListRowCount(advertisement).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(advertisementDao.findListPage(advertisement,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Advertisement>> getHistoryListPage(Advertisement advertisement, Page pageInfo) {
		pageInfo.setTotalCount(advertisementDao.findHistoryListRowCount(advertisement,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(advertisementDao.findHistoryListPage(advertisement,pageInfo));
        return pageInfo;
	}
	@Override
	public Advertisement findByVersion(Integer version) {
		return advertisementDao.findByVersion(version);
	}
	@Override
	public Page<Advertisement> queryByKey(String queryKey, Page<Advertisement> pageInfo) {
		int countRecord = advertisementDao.findRowCount(queryKey).intValue();
		Page<Advertisement> page = new Page<Advertisement>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Advertisement> advertisementList = advertisementDao.findByKey(pageInfo,queryKey);
		page.setList(advertisementList);
		return page;
	}
	@Override
	public List<Advertisement> queryById(Integer[] ids) {
		return advertisementDao.findById(ids);
	}
}