package me.huqiao.smallcms.chinastar.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.chinastar.dao.ISiteSettingDao;
import me.huqiao.smallcms.chinastar.entity.SiteSetting;
import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.envers.query.AuditQueryCreator;
import org.springframework.stereotype.Repository;
/**
 * 网站设置DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class SiteSettingDaoImpl extends BaseDaoImpl<SiteSetting> implements ISiteSettingDao {
    @Override
    public Long findListRowCount(SiteSetting siteSetting) {
        Criteria criteria = getSession().createCriteria(SiteSetting.class).setProjection(Projections.rowCount());
        queryCause(criteria,siteSetting);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(SiteSetting siteSetting,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(SiteSetting.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(siteSetting.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<SiteSetting> findListPage(SiteSetting siteSetting, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(SiteSetting.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,siteSetting);
        if(pageInfo.getOrderField()!=null && !pageInfo.getOrderField().trim().equals("")){
         	if(pageInfo.getOrderDirection()==null || pageInfo.getOrderDirection().trim().equals("asc")){
         		criteria.addOrder(Order.asc(pageInfo.getOrderField()));
         	}else{
         		criteria.addOrder(Order.desc(pageInfo.getOrderField()));
         	}
         }else{
         	criteria.addOrder(Order.asc("id")); 
         }
        return criteria.list();
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoryRecord<SiteSetting>> findHistoryListPage(SiteSetting siteSetting, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(SiteSetting.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(siteSetting.getManageKey()));
		queryCause(query,pageInfo);
		if (pageInfo.getOrderField() != null && !pageInfo.getOrderField().trim().equals("")) {
			if (pageInfo.getOrderDirection() == null || pageInfo.getOrderDirection().trim().equals("asc")) {
				query.addOrder(AuditEntity.property(pageInfo.getOrderField()).asc());
			} else {
				query.addOrder(AuditEntity.property(pageInfo.getOrderField()).desc());
			}
		} else {
			query.addOrder(AuditEntity.property("id").desc());
		}
		List list = query.getResultList();
		List<HistoryRecord<SiteSetting>> res = new ArrayList<HistoryRecord<SiteSetting>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<SiteSetting> record = new HistoryRecord<SiteSetting>();
			record.setRecord((SiteSetting)array[0]);
			record.setRevisionEntity((TestRevisionEntity)array[1]);
			record.setType((RevisionType)array[2]);
			res.add(record);
		}
		return res;
	}
	/**
	  * 添加历史记录查询条件
      * @param query 历史查询对象
      * @param pageInfo 历史记录分页查询对象
	  */
	public void queryCause(AuditQuery query,Page pageInfo) {
		if(pageInfo.getOperateDateStart()!=null){
			query.add(AuditEntity.revisionProperty("timestamp").ge(pageInfo.getOperateDateStart()));
		}
		if(pageInfo.getOperateDateEnd()!=null){
			query.add(AuditEntity.revisionProperty("timestamp").le(pageInfo.getOperateDateEnd()));
		}
		if(pageInfo.getOperator()!=null && !pageInfo.getOperator().trim().equals("")){
			query.add(AuditEntity.revisionProperty("username").like(pageInfo.getOperator(),MatchMode.ANYWHERE));
		}
		if(pageInfo.getOperateType()!=null && !pageInfo.getOperateType().trim().equals("")){
			query.add(AuditEntity.revisionType().eq(RevisionType.valueOf(pageInfo.getOperateType())));
		}
	}
	/**
	  * 根据查询对象往criteria对象增加查询条件
      * @param criteria Hibernate criteria对象
      * @param siteSetting 查询对象
	  */
    public void queryCause(Criteria criteria,SiteSetting siteSetting){
				if(siteSetting.getHeaderPic()!=null && siteSetting.getHeaderPic().getId() != null ){
					criteria.add(Restrictions.eq("headerPic",siteSetting.getHeaderPic()));
				}
				if(siteSetting.getInfoHeaderPic()!=null && siteSetting.getInfoHeaderPic().getId() != null ){
					criteria.add(Restrictions.eq("infoHeaderPic",siteSetting.getInfoHeaderPic()));
				}
    }
	@Override
	public SiteSetting findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(SiteSetting.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (SiteSetting)list.get(0);
		}
		return null;
	}
	@Override
	public List<SiteSetting> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(SiteSetting.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(SiteSetting.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SiteSetting> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(SiteSetting.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}