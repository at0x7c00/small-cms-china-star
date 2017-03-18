package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 质量档案类别DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IQualityArchiveCategoryDao extends IBaseDao<QualityArchiveCategory> {
    /**
     * 质量档案类别查询记录数量
     * @param qualityArchiveCategory 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(QualityArchiveCategory qualityArchiveCategory);
	/**
	 * 质量档案类别历史记录数量
     * @param qualityArchiveCategory 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(QualityArchiveCategory qualityArchiveCategory,Page pageInfo);
    /**
     * 质量档案类别分页查询
     * @param qualityArchiveCategory 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<QualityArchiveCategory>  质量档案类别列表 
     */
    List<QualityArchiveCategory> findListPage(QualityArchiveCategory qualityArchiveCategory, Page pageInfo);
	/**
	 * 质量档案类别历史记录分页查询
     * @param qualityArchiveCategory 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<QualityArchiveCategory>>  质量档案类别历史列表
	 */
    List<HistoryRecord<QualityArchiveCategory>> findHistoryListPage(QualityArchiveCategory qualityArchiveCategory, Page pageInfo);
	/**
     * 质量档案类别版本号查询
     * @param version 版本号
	 * @return QualityArchiveCategory 质量档案类别历史记录
     */
	QualityArchiveCategory findByVersion(Integer version);
	/**
	 * 添加质量档案类别查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param qualityArchiveCategory 查询对象
	 */
	public void queryCause(Criteria criteria, QualityArchiveCategory qualityArchiveCategory);
	/**
	 * 质量档案类别关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<QualityArchiveCategory> 质量档案类别列表
	 */
	List<QualityArchiveCategory> findByKey(Page pageInfo,String queryKey);
	/**
	 * 质量档案类别关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个质量档案类别
     * @param  ids id数组
	 * @return List<QualityArchiveCategory>  质量档案类别列表
     */
	List<QualityArchiveCategory> findById(Integer[] ids);
}