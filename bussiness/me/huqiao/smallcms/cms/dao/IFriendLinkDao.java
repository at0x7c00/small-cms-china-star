package me.huqiao.smallcms.cms.dao;
import java.util.List;

import me.huqiao.smallcms.cms.entity.FriendLink;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 友情链接DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IFriendLinkDao extends IBaseDao<FriendLink> {
    /**
     * 友情链接查询记录数量
     * @param friendLink 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(FriendLink friendLink);
	/**
	 * 友情链接历史记录数量
     * @param friendLink 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(FriendLink friendLink,Page pageInfo);
    /**
     * 友情链接分页查询
     * @param friendLink 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<FriendLink>  友情链接列表 
     */
    List<FriendLink> findListPage(FriendLink friendLink, Page pageInfo);
	/**
	 * 友情链接历史记录分页查询
     * @param friendLink 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<FriendLink>>  友情链接历史列表
	 */
    List<HistoryRecord<FriendLink>> findHistoryListPage(FriendLink friendLink, Page pageInfo);
	/**
     * 友情链接版本号查询
     * @param version 版本号
	 * @return FriendLink 友情链接历史记录
     */
	FriendLink findByVersion(Integer version);
	/**
	 * 添加友情链接查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param friendLink 查询对象
	 */
	public void queryCause(Criteria criteria, FriendLink friendLink);
	/**
	 * 友情链接关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<FriendLink> 友情链接��表
	 */
	List<FriendLink> findByKey(Page pageInfo,String queryKey);
	/**
	 * 友情链接关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个友情链接
     * @param  ids id数组
	 * @return List<FriendLink>  友情链接列表
     */
	List<FriendLink> findById(Integer[] ids);
}