package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.AuthOrg;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 授权机构DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IAuthOrgDao extends IBaseDao<AuthOrg> {
    /**
     * 授权机构查询记录数量
     * @param authOrg 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(AuthOrg authOrg);
	/**
	 * 授权机构历史记录数量
     * @param authOrg 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(AuthOrg authOrg,Page pageInfo);
    /**
     * 授权机构分页查询
     * @param authOrg 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<AuthOrg>  授权机构列表 
     */
    List<AuthOrg> findListPage(AuthOrg authOrg, Page pageInfo);
	/**
	 * 授权机构历史记录分页查询
     * @param authOrg 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<AuthOrg>>  授权机构历史列表
	 */
    List<HistoryRecord<AuthOrg>> findHistoryListPage(AuthOrg authOrg, Page pageInfo);
	/**
     * 授权机构版本号查询
     * @param version 版本号
	 * @return AuthOrg 授权机构历史记录
     */
	AuthOrg findByVersion(Integer version);
	/**
	 * 添加授权机构查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param authOrg 查询对象
	 */
	public void queryCause(Criteria criteria, AuthOrg authOrg);
	/**
	 * 授权机构关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<AuthOrg> 授权机构列表
	 */
	List<AuthOrg> findByKey(Page pageInfo,String queryKey);
	/**
	 * 授权机构关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个授权机构
     * @param  ids id数组
	 * @return List<AuthOrg>  授权机构列表
     */
	List<AuthOrg> findById(Integer[] ids);
}