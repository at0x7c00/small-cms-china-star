package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.Apply;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 会员入会申请DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IApplyDao extends IBaseDao<Apply> {
    /**
     * 会员入会申请查询记录数量
     * @param apply 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Apply apply);
	/**
	 * 会员入会申请历史记录数量
     * @param apply 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Apply apply,Page pageInfo);
    /**
     * 会员入会申请分页查询
     * @param apply ��询对象
     * @param pageInfo 分页查询对象
     * @return  List<Apply>  会员入会申请列表 
     */
    List<Apply> findListPage(Apply apply, Page pageInfo);
	/**
	 * 会员入会申请历史记录分页查询
     * @param apply 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Apply>>  会员入会申请历史列表
	 */
    List<HistoryRecord<Apply>> findHistoryListPage(Apply apply, Page pageInfo);
	/**
     * 会员入会申请版本号查询
     * @param version 版本号
	 * @return Apply 会员入会申请历史记录
     */
	Apply findByVersion(Integer version);
	/**
	 * 添加会员入会申请查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param apply 查询对象
	 */
	public void queryCause(Criteria criteria, Apply apply);
	/**
	 * 会员入会申请关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Apply> 会员入会申请列表
	 */
	List<Apply> findByKey(Page pageInfo,String queryKey);
	/**
	 * 会员入会申请关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个会员入会申请
     * @param  ids id数组
	 * @return List<Apply>  会员入会申请列表
     */
	List<Apply> findById(Integer[] ids);
}