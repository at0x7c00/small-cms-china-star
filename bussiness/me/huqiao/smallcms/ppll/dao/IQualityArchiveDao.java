package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.QualityArchive;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 质量档案DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IQualityArchiveDao extends IBaseDao<QualityArchive> {
    /**
     * 质量档案查询记录数量
     * @param qualityArchive 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(QualityArchive qualityArchive);
	/**
	 * 质量档案历史记录数量
     * @param qualityArchive 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(QualityArchive qualityArchive,Page pageInfo);
    /**
     * 质量档案分页查询
     * @param qualityArchive 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<QualityArchive>  质量档案列表 
     */
    List<QualityArchive> findListPage(QualityArchive qualityArchive, Page pageInfo);
	/**
	 * 质量档案历史记录分页查询
     * @param qualityArchive 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<QualityArchive>>  质量档案历史列表
	 */
    List<HistoryRecord<QualityArchive>> findHistoryListPage(QualityArchive qualityArchive, Page pageInfo);
	/**
     * 质量档案版本号查询
     * @param version 版本号
	 * @return QualityArchive 质量档案历史记录
     */
	QualityArchive findByVersion(Integer version);
	/**
	 * 添加质量档案查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param qualityArchive 查询对象
	 */
	public void queryCause(Criteria criteria, QualityArchive qualityArchive);
	/**
	 * 质量档案关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<QualityArchive> 质量档案列表
	 */
	List<QualityArchive> findByKey(Page pageInfo,String queryKey);
	/**
	 * 质量档案关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个质量档案
     * @param  ids id数组
	 * @return List<QualityArchive>  质量档案列表
     */
	List<QualityArchive> findById(Integer[] ids);
}