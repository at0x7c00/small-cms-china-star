package me.huqiao.smallcms.cms.service;
import java.util.List;

import me.huqiao.smallcms.cms.entity.WebPage;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 栏目Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IWebPageService extends IBaseService<WebPage> {
    /**
     * 栏目分页查询
     * @param webPage 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<WebPage> 栏目分页信息对象
     */
    public Page<WebPage> getListPage(WebPage webPage,Page pageInfo);
	/**
	  * 栏目历史记录分页查询
	  * @param webPage 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<WebPage>> 栏目历史分页信息对象
	  */
	public Page<HistoryRecord<WebPage>> getHistoryListPage(WebPage webPage,Page pageInfo);
	/**
	 * 栏目版本号查询
	 * @param version 查询版本号
	 * @return WebPage 栏目历史记录
	 */
	public WebPage findByVersion(Integer version);
	/**
	 * 栏目关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<WebPage> 栏目分页信息对象
	 * 
	 */
	Page<WebPage> queryByKey(String queryKey, Page<WebPage> pageInfo);
	/**
	 * 查找多个栏目
	 * @param ids id数组
	 * @return List<WebPage> 栏目列表
	 * 
	 */
	List<WebPage> queryById(Integer[] ids);
}