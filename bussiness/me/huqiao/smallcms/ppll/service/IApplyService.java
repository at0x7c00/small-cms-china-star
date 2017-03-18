package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.Apply;
import me.huqiao.smallcms.util.web.Page;
/**
 * 会员入会申请Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IApplyService extends IBaseService<Apply> {
    /**
     * 会员入会申请分页查询
     * @param apply 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Apply> 会员入会申请分页信息对象
     */
    public Page<Apply> getListPage(Apply apply,Page pageInfo);
	/**
	  * 会员入会申请历史记录分页查询
	  * @param apply 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Apply>> 会员入会申请历史分页信息对象
	  */
	public Page<HistoryRecord<Apply>> getHistoryListPage(Apply apply,Page pageInfo);
	/**
	 * 会员入会申请版本号查询
	 * @param version 查询版本号
	 * @return Apply 会员入会申请历史记录
	 */
	public Apply findByVersion(Integer version);
	/**
	 * 会员入会申请关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Apply> 会员入会申请分页信息对象
	 * 
	 */
	Page<Apply> queryByKey(String queryKey, Page<Apply> pageInfo);
	/**
	 * 查找多个会员入会申请
	 * @param ids id数组
	 * @return List<Apply> 会员入会申请列表
	 * 
	 */
	List<Apply> queryById(Integer[] ids);
}