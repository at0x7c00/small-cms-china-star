package me.huqiao.smallcms.cms.service;
import java.util.List;

import me.huqiao.smallcms.cms.entity.FriendLink;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 友情链接Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IFriendLinkService extends IBaseService<FriendLink> {
    /**
     * 友情链接分页查询
     * @param friendLink 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<FriendLink> 友情链接分页信息对象
     */
    public Page<FriendLink> getListPage(FriendLink friendLink,Page pageInfo);
	/**
	  * 友情链接历史记录分页查���
	  * @param friendLink 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<FriendLink>> 友情链接历史分页信息对象
	  */
	public Page<HistoryRecord<FriendLink>> getHistoryListPage(FriendLink friendLink,Page pageInfo);
	/**
	 * 友情链接版本号查询
	 * @param version 查询版本号
	 * @return FriendLink 友情链接历史记录
	 */
	public FriendLink findByVersion(Integer version);
	/**
	 * 友情链接关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<FriendLink> 友情链接分页信息对象
	 * 
	 */
	Page<FriendLink> queryByKey(String queryKey, Page<FriendLink> pageInfo);
	/**
	 * 查找多个友情链接
	 * @param ids id数组
	 * @return List<FriendLink> 友情链接列表
	 * 
	 */
	List<FriendLink> queryById(Integer[] ids);
}