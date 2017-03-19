package me.huqiao.smallcms.chinastar.service;
import java.util.List;

import me.huqiao.smallcms.chinastar.entity.CorporateStyle;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 企业风采Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ICorporateStyleService extends IBaseService<CorporateStyle> {
    /**
     * 企业风采分页查询
     * @param corporateStyle 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<CorporateStyle> 企业风采分页信息对象
     */
    public Page<CorporateStyle> getListPage(CorporateStyle corporateStyle,Page pageInfo);
	/**
	  * 企业风采历史记录分页查询
	  * @param corporateStyle 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<CorporateStyle>> 企业风采历史分页信息对象
	  */
	public Page<HistoryRecord<CorporateStyle>> getHistoryListPage(CorporateStyle corporateStyle,Page pageInfo);
	/**
	 * 企业风采版本号查询
	 * @param version 查询版本号
	 * @return CorporateStyle 企业风采历史记录
	 */
	public CorporateStyle findByVersion(Integer version);
	/**
	 * 企业风采关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<CorporateStyle> 企业风采分页信息对象
	 * 
	 */
	Page<CorporateStyle> queryByKey(String queryKey, Page<CorporateStyle> pageInfo);
	/**
	 * 查找多个企业风采
	 * @param ids id数组
	 * @return List<CorporateStyle> 企业风采列表
	 * 
	 */
	List<CorporateStyle> queryById(Integer[] ids);
}