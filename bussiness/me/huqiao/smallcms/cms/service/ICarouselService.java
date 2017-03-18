package me.huqiao.smallcms.cms.service;
import java.util.List;

import me.huqiao.smallcms.cms.entity.Carousel;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 轮播Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ICarouselService extends IBaseService<Carousel> {
    /**
     * 轮播分页查询
     * @param carousel 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Carousel> 轮播分页信息对象
     */
    public Page<Carousel> getListPage(Carousel carousel,Page pageInfo);
	/**
	  * 轮播历史记录分页查询
	  * @param carousel 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Carousel>> 轮播历史分页信息对象
	  */
	public Page<HistoryRecord<Carousel>> getHistoryListPage(Carousel carousel,Page pageInfo);
	/**
	 * 轮播版本号查询
	 * @param version 查询版本号
	 * @return Carousel 轮播历史记录
	 */
	public Carousel findByVersion(Integer version);
	/**
	 * 轮播关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Carousel> 轮播分页信息对象
	 * 
	 */
	Page<Carousel> queryByKey(String queryKey, Page<Carousel> pageInfo);
	/**
	 * 查找多个轮播
	 * @param ids id数组
	 * @return List<Carousel> 轮播列表
	 * 
	 */
	List<Carousel> queryById(Integer[] ids);
}