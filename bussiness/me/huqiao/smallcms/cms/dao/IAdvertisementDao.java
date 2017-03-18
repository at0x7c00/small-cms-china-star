package me.huqiao.smallcms.cms.dao;
import java.util.List;

import me.huqiao.smallcms.cms.entity.Advertisement;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 广告DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IAdvertisementDao extends IBaseDao<Advertisement> {
    /**
     * 广告查询记录数量
     * @param advertisement 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Advertisement advertisement);
	/**
	 * 广告历史记录数量
     * @param advertisement 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Advertisement advertisement,Page pageInfo);
    /**
     * 广告分页查询
     * @param advertisement 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Advertisement>  广告列表 
     */
    List<Advertisement> findListPage(Advertisement advertisement, Page pageInfo);
	/**
	 * 广告历史记录分页查询
     * @param advertisement 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Advertisement>>  广告历史列表
	 */
    List<HistoryRecord<Advertisement>> findHistoryListPage(Advertisement advertisement, Page pageInfo);
	/**
     * 广告版本号查询
     * @param version 版本号
	 * @return Advertisement 广告历史记录
     */
	Advertisement findByVersion(Integer version);
	/**
	 * 添加广告查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param advertisement 查询对象
	 */
	public void queryCause(Criteria criteria, Advertisement advertisement);
	/**
	 * 广告关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Advertisement> 广��列表
	 */
	List<Advertisement> findByKey(Page pageInfo,String queryKey);
	/**
	 * 广告关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个广告
     * @param  ids id数组
	 * @return List<Advertisement>  广告列表
     */
	List<Advertisement> findById(Integer[] ids);
}