package me.huqiao.smallcms.chinastar.service;
import java.util.List;

import me.huqiao.smallcms.chinastar.entity.Information;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 资讯Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IInformationService extends IBaseService<Information> {
    /**
     * 资讯分页查询
     * @param information 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Information> 资讯分页信息对象
     */
    public Page<Information> getListPage(Information information,Page pageInfo);
	/**
	  * 资讯历史记录分页查询
	  * @param information 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Information>> 资讯历史分页信息对象
	  */
	public Page<HistoryRecord<Information>> getHistoryListPage(Information information,Page pageInfo);
	/**
	 * 资讯版本号查询
	 * @param version 查询版本号
	 * @return Information 资讯历史记录
	 */
	public Information findByVersion(Integer version);
	/**
	 * 资讯关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Information> 资讯分页信息对象
	 * 
	 */
	Page<Information> queryByKey(String queryKey, Page<Information> pageInfo);
	/**
	 * 查找多个资讯
	 * @param ids id数组
	 * @return List<Information> 资讯列表
	 * 
	 */
	List<Information> queryById(Integer[] ids);
}