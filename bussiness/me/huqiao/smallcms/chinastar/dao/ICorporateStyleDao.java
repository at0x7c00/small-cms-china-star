package me.huqiao.smallcms.chinastar.dao;
import java.util.List;

import me.huqiao.smallcms.chinastar.entity.CorporateStyle;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 企业风采DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ICorporateStyleDao extends IBaseDao<CorporateStyle> {
    /**
     * 企业风采查询记录数量
     * @param corporateStyle 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(CorporateStyle corporateStyle);
	/**
	 * 企业风采历史记录数量
     * @param corporateStyle 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(CorporateStyle corporateStyle,Page pageInfo);
    /**
     * 企业风采分页查询
     * @param corporateStyle 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<CorporateStyle>  企业风采列表 
     */
    List<CorporateStyle> findListPage(CorporateStyle corporateStyle, Page pageInfo);
	/**
	 * 企业风采历史记录分页查询
     * @param corporateStyle 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<CorporateStyle>>  企业风采历史列表
	 */
    List<HistoryRecord<CorporateStyle>> findHistoryListPage(CorporateStyle corporateStyle, Page pageInfo);
	/**
     * 企业风采版本号查询
     * @param version 版本号
	 * @return CorporateStyle 企业风采历史记录
     */
	CorporateStyle findByVersion(Integer version);
	/**
	 * 添加企业风采查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param corporateStyle 查询对象
	 */
	public void queryCause(Criteria criteria, CorporateStyle corporateStyle);
	/**
	 * ��业风采关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<CorporateStyle> 企业风采列表
	 */
	List<CorporateStyle> findByKey(Page pageInfo,String queryKey);
	/**
	 * 企业风采关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个企业风采
     * @param  ids id数组
	 * @return List<CorporateStyle>  企业风采列表
     */
	List<CorporateStyle> findById(Integer[] ids);
}