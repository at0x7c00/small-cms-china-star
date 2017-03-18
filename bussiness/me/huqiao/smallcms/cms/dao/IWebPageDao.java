package me.huqiao.smallcms.cms.dao;
import java.util.List;

import me.huqiao.smallcms.cms.entity.WebPage;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 栏目DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IWebPageDao extends IBaseDao<WebPage> {
    /**
     * 栏目查询记录数量
     * @param webPage 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(WebPage webPage);
	/**
	 * 栏目历史记录数量
     * @param webPage 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(WebPage webPage,Page pageInfo);
    /**
     * 栏目分页查询
     * @param webPage 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<WebPage>  栏目列表 
     */
    List<WebPage> findListPage(WebPage webPage, Page pageInfo);
	/**
	 * 栏目历史记录分页查询
     * @param webPage 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<WebPage>>  栏目历史列表
	 */
    List<HistoryRecord<WebPage>> findHistoryListPage(WebPage webPage, Page pageInfo);
	/**
     * 栏目版本号查询
     * @param version 版本号
	 * @return WebPage 栏目历史记录
     */
	WebPage findByVersion(Integer version);
	/**
	 * 添加栏目查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param webPage 查询对象
	 */
	public void queryCause(Criteria criteria, WebPage webPage);
	/**
	 * 栏目关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<WebPage> 栏目列表
	 */
	List<WebPage> findByKey(Page pageInfo,String queryKey);
	/**
	 * 栏目关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个栏目
     * @param  ids id数组
	 * @return List<WebPage>  栏目列表
     */
	List<WebPage> findById(Integer[] ids);
}