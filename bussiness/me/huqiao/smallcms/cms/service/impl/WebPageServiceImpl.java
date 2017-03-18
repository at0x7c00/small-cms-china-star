package me.huqiao.smallcms.cms.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.cms.dao.IWebPageDao;
import me.huqiao.smallcms.cms.entity.WebPage;
import me.huqiao.smallcms.cms.service.IWebPageService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 栏目Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class WebPageServiceImpl extends BaseServiceImpl<WebPage> implements IWebPageService {
    /**栏目DAO对象*/
    @Resource
    private IWebPageDao webPageDao;
    @Override
    public Page<WebPage> getListPage(WebPage webPage,Page pageInfo) {
      	pageInfo.setTotalCount(webPageDao.findListRowCount(webPage).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(webPageDao.findListPage(webPage,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<WebPage>> getHistoryListPage(WebPage webPage, Page pageInfo) {
		pageInfo.setTotalCount(webPageDao.findHistoryListRowCount(webPage,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(webPageDao.findHistoryListPage(webPage,pageInfo));
        return pageInfo;
	}
	@Override
	public WebPage findByVersion(Integer version) {
		return webPageDao.findByVersion(version);
	}
	@Override
	public Page<WebPage> queryByKey(String queryKey, Page<WebPage> pageInfo) {
		int countRecord = webPageDao.findRowCount(queryKey).intValue();
		Page<WebPage> page = new Page<WebPage>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<WebPage> webPageList = webPageDao.findByKey(pageInfo,queryKey);
		page.setList(webPageList);
		return page;
	}
	@Override
	public List<WebPage> queryById(Integer[] ids) {
		return webPageDao.findById(ids);
	}
}