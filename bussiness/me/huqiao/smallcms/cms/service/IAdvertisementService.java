package me.huqiao.smallcms.cms.service;
import java.util.List;

import me.huqiao.smallcms.cms.entity.Advertisement;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 广告Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IAdvertisementService extends IBaseService<Advertisement> {
    /**
     * 广告分页查询
     * @param advertisement 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Advertisement> 广告分页信息对象
     */
    public Page<Advertisement> getListPage(Advertisement advertisement,Page pageInfo);
	/**
	  * 广告历史记录分页查���
	  * @param advertisement 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Advertisement>> 广告历史分页信息对象
	  */
	public Page<HistoryRecord<Advertisement>> getHistoryListPage(Advertisement advertisement,Page pageInfo);
	/**
	 * 广告版本号查询
	 * @param version 查询版本号
	 * @return Advertisement 广告历史记录
	 */
	public Advertisement findByVersion(Integer version);
	/**
	 * 广告关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Advertisement> 广告分页信息对象
	 * 
	 */
	Page<Advertisement> queryByKey(String queryKey, Page<Advertisement> pageInfo);
	/**
	 * 查找多个广告
	 * @param ids id数组
	 * @return List<Advertisement> 广告列表
	 * 
	 */
	List<Advertisement> queryById(Integer[] ids);
}