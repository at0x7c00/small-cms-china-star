package me.huqiao.smallcms.chinastar.dao;
import java.util.List;

import me.huqiao.smallcms.chinastar.entity.Information;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 资讯DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IInformationDao extends IBaseDao<Information> {
    /**
     * 资讯查询记录数量
     * @param information 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Information information);
	/**
	 * 资讯历史记录数量
     * @param information 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Information information,Page pageInfo);
    /**
     * 资讯分页查询
     * @param information 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Information>  资讯列表 
     */
    List<Information> findListPage(Information information, Page pageInfo);
	/**
	 * 资讯历史记录分页查询
     * @param information 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Information>>  资讯历史列表
	 */
    List<HistoryRecord<Information>> findHistoryListPage(Information information, Page pageInfo);
	/**
     * 资讯版本号查询
     * @param version 版本号
	 * @return Information 资讯历史记录
     */
	Information findByVersion(Integer version);
	/**
	 * 添加资讯查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param information 查询对象
	 */
	public void queryCause(Criteria criteria, Information information);
	/**
	 * 资讯关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Information> 资讯列表
	 */
	List<Information> findByKey(Page pageInfo,String queryKey);
	/**
	 * 资讯关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个资讯
     * @param  ids id数组
	 * @return List<Information>  资讯列表
     */
	List<Information> findById(Integer[] ids);
}