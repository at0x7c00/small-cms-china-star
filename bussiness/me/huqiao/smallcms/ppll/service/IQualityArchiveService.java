package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.QualityArchive;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.util.web.Page;
/**
 * 质量档案Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IQualityArchiveService extends IBaseService<QualityArchive> {
    /**
     * 质量档案分页查询
     * @param qualityArchive 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<QualityArchive> 质量档案分页信息对象
     */
    public Page<QualityArchive> getListPage(QualityArchive qualityArchive,Page pageInfo);
	/**
	  * 质量档案历史记录分页查询
	  * @param qualityArchive 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<QualityArchive>> 质量档案历史分页信息对象
	  */
	public Page<HistoryRecord<QualityArchive>> getHistoryListPage(QualityArchive qualityArchive,Page pageInfo);
	/**
	 * 质量档案版本号查询
	 * @param version 查询版本号
	 * @return QualityArchive 质量档案历史记录
	 */
	public QualityArchive findByVersion(Integer version);
	/**
	 * 质量档案关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<QualityArchive> 质量档案分页信息对象
	 * 
	 */
	Page<QualityArchive> queryByKey(String queryKey, Page<QualityArchive> pageInfo);
	/**
	 * 查找多个质量档案
	 * @param ids id数组
	 * @return List<QualityArchive> 质量档案列表
	 * 
	 */
	List<QualityArchive> queryById(Integer[] ids);
	public Page<QualityArchive> getAll(QualityArchiveCategory category,
			Page<QualityArchive> pageInfo);
}