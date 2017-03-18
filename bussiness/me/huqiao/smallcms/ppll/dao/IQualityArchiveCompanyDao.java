package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCompany;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 质量档案公司DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IQualityArchiveCompanyDao extends IBaseDao<QualityArchiveCompany> {
    /**
     * 质量档案公司查询记录数量
     * @param qualityArchiveCompany 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(QualityArchiveCompany qualityArchiveCompany);
	/**
	 * 质量档案公司历史记录数量
     * @param qualityArchiveCompany 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(QualityArchiveCompany qualityArchiveCompany,Page pageInfo);
    /**
     * 质量档案公司分页查询
     * @param qualityArchiveCompany 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<QualityArchiveCompany>  质量档案公司列表 
     */
    List<QualityArchiveCompany> findListPage(QualityArchiveCompany qualityArchiveCompany, Page pageInfo);
	/**
	 * 质量档案公司历史记录分页查询
     * @param qualityArchiveCompany 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<QualityArchiveCompany>>  质量档案公司历史列表
	 */
    List<HistoryRecord<QualityArchiveCompany>> findHistoryListPage(QualityArchiveCompany qualityArchiveCompany, Page pageInfo);
	/**
     * 质量档案公司版本号查询
     * @param version 版本号
	 * @return QualityArchiveCompany 质量档案公司历史记录
     */
	QualityArchiveCompany findByVersion(Integer version);
	/**
	 * 添加质量档案公司查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param qualityArchiveCompany 查询对象
	 */
	public void queryCause(Criteria criteria, QualityArchiveCompany qualityArchiveCompany);
	/**
	 * 质量档案公司关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<QualityArchiveCompany> 质量档案公司列表
	 */
	List<QualityArchiveCompany> findByKey(Page pageInfo,String queryKey);
	/**
	 * 质量档案公司关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个质量档案公司
     * @param  ids id数组
	 * @return List<QualityArchiveCompany>  质量档案公司列表
     */
	List<QualityArchiveCompany> findById(Integer[] ids);
}