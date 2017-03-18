package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.MemberOrganization;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 会员单位DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IMemberOrganizationDao extends IBaseDao<MemberOrganization> {
    /**
     * 会员单位查询记录数量
     * @param memberOrganization 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(MemberOrganization memberOrganization);
	/**
	 * 会员单位历史记录数量
     * @param memberOrganization 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(MemberOrganization memberOrganization,Page pageInfo);
    /**
     * 会员单位分页查询
     * @param memberOrganization 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<MemberOrganization>  会员单位列表 
     */
    List<MemberOrganization> findListPage(MemberOrganization memberOrganization, Page pageInfo);
	/**
	 * 会员单位历史记录分页查询
     * @param memberOrganization 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<MemberOrganization>>  会员单位历史列表
	 */
    List<HistoryRecord<MemberOrganization>> findHistoryListPage(MemberOrganization memberOrganization, Page pageInfo);
	/**
     * 会员单位版本号查询
     * @param version 版本号
	 * @return MemberOrganization 会员单位历史记录
     */
	MemberOrganization findByVersion(Integer version);
	/**
	 * 添加会员单位查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param memberOrganization 查询对象
	 */
	public void queryCause(Criteria criteria, MemberOrganization memberOrganization);
	/**
	 * 会员单位关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<MemberOrganization> 会员单位列表
	 */
	List<MemberOrganization> findByKey(Page pageInfo,String queryKey);
	/**
	 * 会员单位关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个会员单位
     * @param  ids id数组
	 * @return List<MemberOrganization>  会员单位列表
     */
	List<MemberOrganization> findById(Integer[] ids);
}