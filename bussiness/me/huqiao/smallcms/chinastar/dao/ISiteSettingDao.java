package me.huqiao.smallcms.chinastar.dao;
import java.util.List;

import me.huqiao.smallcms.chinastar.entity.SiteSetting;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 网站设置DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ISiteSettingDao extends IBaseDao<SiteSetting> {
    /**
     * 网站设置查询记录数量
     * @param siteSetting 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(SiteSetting siteSetting);
	/**
	 * 网站设置历史记录数量
     * @param siteSetting 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(SiteSetting siteSetting,Page pageInfo);
    /**
     * 网站��置分页查询
     * @param siteSetting 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<SiteSetting>  网站设置列表 
     */
    List<SiteSetting> findListPage(SiteSetting siteSetting, Page pageInfo);
	/**
	 * 网站设置历史记录分页查询
     * @param siteSetting 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<SiteSetting>>  网站设置历史列表
	 */
    List<HistoryRecord<SiteSetting>> findHistoryListPage(SiteSetting siteSetting, Page pageInfo);
	/**
     * 网站设置版本号查询
     * @param version 版本号
	 * @return SiteSetting 网站设置历史记录
     */
	SiteSetting findByVersion(Integer version);
	/**
	 * 添加网站设置查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param siteSetting 查询对象
	 */
	public void queryCause(Criteria criteria, SiteSetting siteSetting);
	/**
	 * 网站设置关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<SiteSetting> 网站设置列表
	 */
	List<SiteSetting> findByKey(Page pageInfo,String queryKey);
	/**
	 * 网站设置关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个网站设置
     * @param  ids id数组
	 * @return List<SiteSetting>  网站设置列表
     */
	List<SiteSetting> findById(Integer[] ids);
}