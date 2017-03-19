package me.huqiao.smallcms.chinastar.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.chinastar.dao.IInformationDao;
import me.huqiao.smallcms.chinastar.entity.Information;
import me.huqiao.smallcms.chinastar.service.IInformationService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 资讯Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class InformationServiceImpl extends BaseServiceImpl<Information> implements IInformationService {
    /**资讯DAO对象*/
    @Resource
    private IInformationDao informationDao;
    @Override
    public Page<Information> getListPage(Information information,Page pageInfo) {
      	pageInfo.setTotalCount(informationDao.findListRowCount(information).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(informationDao.findListPage(information,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Information>> getHistoryListPage(Information information, Page pageInfo) {
		pageInfo.setTotalCount(informationDao.findHistoryListRowCount(information,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(informationDao.findHistoryListPage(information,pageInfo));
        return pageInfo;
	}
	@Override
	public Information findByVersion(Integer version) {
		return informationDao.findByVersion(version);
	}
	@Override
	public Page<Information> queryByKey(String queryKey, Page<Information> pageInfo) {
		int countRecord = informationDao.findRowCount(queryKey).intValue();
		Page<Information> page = new Page<Information>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Information> informationList = informationDao.findByKey(pageInfo,queryKey);
		page.setList(informationList);
		return page;
	}
	@Override
	public List<Information> queryById(Integer[] ids) {
		return informationDao.findById(ids);
	}
}