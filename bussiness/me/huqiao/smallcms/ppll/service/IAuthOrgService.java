package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.AuthOrg;
import me.huqiao.smallcms.util.web.Page;
/**
 * 授权机构Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IAuthOrgService extends IBaseService<AuthOrg> {
    /**
     * 授权机构分页查询
     * @param authOrg 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<AuthOrg> 授权机构分页信息对象
     */
    public Page<AuthOrg> getListPage(AuthOrg authOrg,Page pageInfo);
	/**
	  * 授权机构历史记录分页查询
	  * @param authOrg 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<AuthOrg>> 授权机构历史分页信息对象
	  */
	public Page<HistoryRecord<AuthOrg>> getHistoryListPage(AuthOrg authOrg,Page pageInfo);
	/**
	 * 授权机构版本号查询
	 * @param version 查询版本号
	 * @return AuthOrg 授权机构历史记录
	 */
	public AuthOrg findByVersion(Integer version);
	/**
	 * 授权机构关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<AuthOrg> 授权机构分页信息对象
	 * 
	 */
	Page<AuthOrg> queryByKey(String queryKey, Page<AuthOrg> pageInfo);
	/**
	 * 查找多个授权机构
	 * @param ids id数组
	 * @return List<AuthOrg> 授权机构列表
	 * 
	 */
	List<AuthOrg> queryById(Integer[] ids);
}