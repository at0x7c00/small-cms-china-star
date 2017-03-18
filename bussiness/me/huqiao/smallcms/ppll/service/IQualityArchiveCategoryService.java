package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.util.web.Page;
/**
 * 质量档案类别Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IQualityArchiveCategoryService extends IBaseService<QualityArchiveCategory> {
    /**
     * 质量档案类别分页查询
     * @param qualityArchiveCategory 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<QualityArchiveCategory> 质量档案类别分页信息对象
     */
    public Page<QualityArchiveCategory> getListPage(QualityArchiveCategory qualityArchiveCategory,Page pageInfo);
	/**
	  * 质量档案类别历史记录分页查询
	  * @param qualityArchiveCategory 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<QualityArchiveCategory>> 质量档案类别历史分页信息对象
	  */
	public Page<HistoryRecord<QualityArchiveCategory>> getHistoryListPage(QualityArchiveCategory qualityArchiveCategory,Page pageInfo);
	/**
	 * 质量档案类别版本号查询
	 * @param version 查询版本号
	 * @return QualityArchiveCategory 质量档案类别历史记录
	 */
	public QualityArchiveCategory findByVersion(Integer version);
	/**
	 * 质量档案类别关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<QualityArchiveCategory> 质量档案类别分页信息对象
	 * 
	 */
	Page<QualityArchiveCategory> queryByKey(String queryKey, Page<QualityArchiveCategory> pageInfo);
	/**
	 * 查找多个质量��案类别
	 * @param ids id数组
	 * @return List<QualityArchiveCategory> 质量档案类别列表
	 * 
	 */
	List<QualityArchiveCategory> queryById(Integer[] ids);
}