package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IMemberOrganizationDao;
import me.huqiao.smallcms.ppll.entity.MemberOrganization;
import me.huqiao.smallcms.ppll.service.IMemberOrganizationService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 会员单位Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class MemberOrganizationServiceImpl extends BaseServiceImpl<MemberOrganization> implements IMemberOrganizationService {
    /**会员单位DAO对象*/
    @Resource
    private IMemberOrganizationDao memberOrganizationDao;
    @Override
    public Page<MemberOrganization> getListPage(MemberOrganization memberOrganization,Page pageInfo) {
      	pageInfo.setTotalCount(memberOrganizationDao.findListRowCount(memberOrganization).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(memberOrganizationDao.findListPage(memberOrganization,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<MemberOrganization>> getHistoryListPage(MemberOrganization memberOrganization, Page pageInfo) {
		pageInfo.setTotalCount(memberOrganizationDao.findHistoryListRowCount(memberOrganization,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(memberOrganizationDao.findHistoryListPage(memberOrganization,pageInfo));
        return pageInfo;
	}
	@Override
	public MemberOrganization findByVersion(Integer version) {
		return memberOrganizationDao.findByVersion(version);
	}
	@Override
	public Page<MemberOrganization> queryByKey(String queryKey, Page<MemberOrganization> pageInfo) {
		int countRecord = memberOrganizationDao.findRowCount(queryKey).intValue();
		Page<MemberOrganization> page = new Page<MemberOrganization>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<MemberOrganization> memberOrganizationList = memberOrganizationDao.findByKey(pageInfo,queryKey);
		page.setList(memberOrganizationList);
		return page;
	}
	@Override
	public List<MemberOrganization> queryById(Integer[] ids) {
		return memberOrganizationDao.findById(ids);
	}
}