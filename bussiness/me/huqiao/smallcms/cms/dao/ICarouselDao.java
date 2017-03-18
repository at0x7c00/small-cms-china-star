package me.huqiao.smallcms.cms.dao;
import java.util.List;

import me.huqiao.smallcms.cms.entity.Carousel;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 轮播DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ICarouselDao extends IBaseDao<Carousel> {
    /**
     * 轮播查询记录数量
     * @param carousel 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Carousel carousel);
	/**
	 * 轮播历史记录数量
     * @param carousel 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Carousel carousel,Page pageInfo);
    /**
     * 轮播分页查询
     * @param carousel 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Carousel>  轮播列表 
     */
    List<Carousel> findListPage(Carousel carousel, Page pageInfo);
	/**
	 * 轮播历史记录分页查询
     * @param carousel 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Carousel>>  轮播历史列表
	 */
    List<HistoryRecord<Carousel>> findHistoryListPage(Carousel carousel, Page pageInfo);
	/**
     * 轮播版本号查询
     * @param version 版本号
	 * @return Carousel 轮播历史记录
     */
	Carousel findByVersion(Integer version);
	/**
	 * 添加轮播查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param carousel 查询对象
	 */
	public void queryCause(Criteria criteria, Carousel carousel);
	/**
	 * 轮播关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Carousel> 轮播列表
	 */
	List<Carousel> findByKey(Page pageInfo,String queryKey);
	/**
	 * 轮播关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个轮播
     * @param  ids id数组
	 * @return List<Carousel>  轮播列表
     */
	List<Carousel> findById(Integer[] ids);
}