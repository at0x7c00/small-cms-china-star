package me.huqiao.smallcms.cms.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.cms.dao.IFriendLinkDao;
import me.huqiao.smallcms.cms.entity.FriendLink;
import me.huqiao.smallcms.cms.service.IFriendLinkService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 友情链接Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class FriendLinkServiceImpl extends BaseServiceImpl<FriendLink> implements IFriendLinkService {
    /**友情链接DAO对象*/
    @Resource
    private IFriendLinkDao friendLinkDao;
    @Override
    public Page<FriendLink> getListPage(FriendLink friendLink,Page pageInfo) {
      	pageInfo.setTotalCount(friendLinkDao.findListRowCount(friendLink).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(friendLinkDao.findListPage(friendLink,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<FriendLink>> getHistoryListPage(FriendLink friendLink, Page pageInfo) {
		pageInfo.setTotalCount(friendLinkDao.findHistoryListRowCount(friendLink,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(friendLinkDao.findHistoryListPage(friendLink,pageInfo));
        return pageInfo;
	}
	@Override
	public FriendLink findByVersion(Integer version) {
		return friendLinkDao.findByVersion(version);
	}
	@Override
	public Page<FriendLink> queryByKey(String queryKey, Page<FriendLink> pageInfo) {
		int countRecord = friendLinkDao.findRowCount(queryKey).intValue();
		Page<FriendLink> page = new Page<FriendLink>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<FriendLink> friendLinkList = friendLinkDao.findByKey(pageInfo,queryKey);
		page.setList(friendLinkList);
		return page;
	}
	@Override
	public List<FriendLink> queryById(Integer[] ids) {
		return friendLinkDao.findById(ids);
	}
}