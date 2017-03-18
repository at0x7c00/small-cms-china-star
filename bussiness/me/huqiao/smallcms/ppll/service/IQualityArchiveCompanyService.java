package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCompany;
import me.huqiao.smallcms.util.web.Page;
/**
 * 质量档案公司Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IQualityArchiveCompanyService extends IBaseService<QualityArchiveCompany> {
    /**
     * 质量档案公司分页查询
     * @param qualityArchiveCompany 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<QualityArchiveCompany> 质量档案公司分页信息对象
     */
    public Page<QualityArchiveCompany> getListPage(QualityArchiveCompany qualityArchiveCompany,Page pageInfo);
	/**
	  * 质量档案公司历史记录分页查询
	  * @param qualityArchiveCompany 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<QualityArchiveCompany>> 质量档案公司历史分页信息对象
	  */
	public Page<HistoryRecord<QualityArchiveCompany>> getHistoryListPage(QualityArchiveCompany qualityArchiveCompany,Page pageInfo);
	/**
	 * 质量档案公司版本号查询
	 * @param version 查询版本号
	 * @return QualityArchiveCompany 质量档案公司历史记录
	 */
	public QualityArchiveCompany findByVersion(Integer version);
	/**
	 * 质量档案公司关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<QualityArchiveCompany> 质量档案公司分页信息对象
	 * 
	 */
	Page<QualityArchiveCompany> queryByKey(String queryKey, Page<QualityArchiveCompany> pageInfo);
	/**
	 * 查找多个质量档案公司
	 * @param ids id数组
	 * @return List<QualityArchiveCompany> 质量档案公司列表
	 * 
	 */
	List<QualityArchiveCompany> queryById(Integer[] ids);
}