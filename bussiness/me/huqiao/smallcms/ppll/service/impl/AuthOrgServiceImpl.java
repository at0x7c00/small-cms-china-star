package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IAuthOrgDao;
import me.huqiao.smallcms.ppll.entity.AuthOrg;
import me.huqiao.smallcms.ppll.service.IAuthOrgService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 授权机构Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class AuthOrgServiceImpl extends BaseServiceImpl<AuthOrg> implements IAuthOrgService {
    /**授权机构DAO对象*/
    @Resource
    private IAuthOrgDao authOrgDao;
    @Override
    public Page<AuthOrg> getListPage(AuthOrg authOrg,Page pageInfo) {
      	pageInfo.setTotalCount(authOrgDao.findListRowCount(authOrg).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(authOrgDao.findListPage(authOrg,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<AuthOrg>> getHistoryListPage(AuthOrg authOrg, Page pageInfo) {
		pageInfo.setTotalCount(authOrgDao.findHistoryListRowCount(authOrg,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(authOrgDao.findHistoryListPage(authOrg,pageInfo));
        return pageInfo;
	}
	@Override
	public AuthOrg findByVersion(Integer version) {
		return authOrgDao.findByVersion(version);
	}
	@Override
	public Page<AuthOrg> queryByKey(String queryKey, Page<AuthOrg> pageInfo) {
		int countRecord = authOrgDao.findRowCount(queryKey).intValue();
		Page<AuthOrg> page = new Page<AuthOrg>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<AuthOrg> authOrgList = authOrgDao.findByKey(pageInfo,queryKey);
		page.setList(authOrgList);
		return page;
	}
	@Override
	public List<AuthOrg> queryById(Integer[] ids) {
		return authOrgDao.findById(ids);
	}
}