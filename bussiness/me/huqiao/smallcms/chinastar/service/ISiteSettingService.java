package me.huqiao.smallcms.chinastar.service;
import java.util.List;

import me.huqiao.smallcms.chinastar.entity.SiteSetting;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 网站设置Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ISiteSettingService extends IBaseService<SiteSetting> {
    /**
     * 网站设置分页查询
     * @param siteSetting 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<SiteSetting> 网站设置分页信息对象
     */
    public Page<SiteSetting> getListPage(SiteSetting siteSetting,Page pageInfo);
	/**
	  * 网站设置��史记录分页查询
	  * @param siteSetting 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<SiteSetting>> 网站设置历史分页信息对象
	  */
	public Page<HistoryRecord<SiteSetting>> getHistoryListPage(SiteSetting siteSetting,Page pageInfo);
	/**
	 * 网站设置版本号查询
	 * @param version 查询版本号
	 * @return SiteSetting 网站设置历史记录
	 */
	public SiteSetting findByVersion(Integer version);
	/**
	 * 网站设置关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<SiteSetting> 网站设置分页信息对象
	 * 
	 */
	Page<SiteSetting> queryByKey(String queryKey, Page<SiteSetting> pageInfo);
	/**
	 * 查找多个网站设置
	 * @param ids id数组
	 * @return List<SiteSetting> 网站设置列表
	 * 
	 */
	List<SiteSetting> queryById(Integer[] ids);
	
	public SiteSetting getSetting();
}