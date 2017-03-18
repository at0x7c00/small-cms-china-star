package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.MemberOrganization;
import me.huqiao.smallcms.util.web.Page;
/**
 * 会员单位Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IMemberOrganizationService extends IBaseService<MemberOrganization> {
    /**
     * 会员单位分页查询
     * @param memberOrganization 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<MemberOrganization> 会员单位分页信息对象
     */
    public Page<MemberOrganization> getListPage(MemberOrganization memberOrganization,Page pageInfo);
	/**
	  * 会员单位历史记录分页查询
	  * @param memberOrganization 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<MemberOrganization>> 会员单位历史分页信息对象
	  */
	public Page<HistoryRecord<MemberOrganization>> getHistoryListPage(MemberOrganization memberOrganization,Page pageInfo);
	/**
	 * 会员单位版本号查询
	 * @param version 查询版本号
	 * @return MemberOrganization 会员单位历史记录
	 */
	public MemberOrganization findByVersion(Integer version);
	/**
	 * 会员单位关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<MemberOrganization> 会员单位分页信息对象
	 * 
	 */
	Page<MemberOrganization> queryByKey(String queryKey, Page<MemberOrganization> pageInfo);
	/**
	 * 查找多个会员单位
	 * @param ids id数组
	 * @return List<MemberOrganization> 会员单位列表
	 * 
	 */
	List<MemberOrganization> queryById(Integer[] ids);
}