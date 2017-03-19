package me.huqiao.smallcms.chinastar.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.chinastar.dao.ICorporateStyleDao;
import me.huqiao.smallcms.chinastar.entity.CorporateStyle;
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
 * 企业风采DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class CorporateStyleDaoImpl extends BaseDaoImpl<CorporateStyle> implements ICorporateStyleDao {
    @Override
    public Long findListRowCount(CorporateStyle corporateStyle) {
        Criteria criteria = getSession().createCriteria(CorporateStyle.class).setProjection(Projections.rowCount());
        queryCause(criteria,corporateStyle);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(CorporateStyle corporateStyle,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(CorporateStyle.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(corporateStyle.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<CorporateStyle> findListPage(CorporateStyle corporateStyle, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(CorporateStyle.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,corporateStyle);
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
	public List<HistoryRecord<CorporateStyle>> findHistoryListPage(CorporateStyle corporateStyle, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(CorporateStyle.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(corporateStyle.getManageKey()));
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
		List<HistoryRecord<CorporateStyle>> res = new ArrayList<HistoryRecord<CorporateStyle>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<CorporateStyle> record = new HistoryRecord<CorporateStyle>();
			record.setRecord((CorporateStyle)array[0]);
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
      * @param corporateStyle 查询对象
	  */
    public void queryCause(Criteria criteria,CorporateStyle corporateStyle){
       if(corporateStyle.getTitle()!=null
 && ! corporateStyle.getTitle().trim().equals("")){
		criteria.add(Restrictions.like("title",corporateStyle.getTitle(),MatchMode.ANYWHERE));
}
       if(corporateStyle.getCorporateName()!=null
 && ! corporateStyle.getCorporateName().trim().equals("")){
		criteria.add(Restrictions.like("corporateName",corporateStyle.getCorporateName(),MatchMode.ANYWHERE));
}
       if(corporateStyle.getContent()!=null
 && ! corporateStyle.getContent().trim().equals("")){
		criteria.add(Restrictions.like("content",corporateStyle.getContent(),MatchMode.ANYWHERE));
}
				if(corporateStyle.getVideo()!=null && corporateStyle.getVideo().getId() != null ){
					criteria.add(Restrictions.eq("video",corporateStyle.getVideo()));
				}
				if(corporateStyle.getCreator()!=null && corporateStyle.getCreator().getId() != null ){
					criteria.add(Restrictions.eq("creator",corporateStyle.getCreator()));
				}
if(corporateStyle.getCreateTimeStart()!=null){
criteria.add(Restrictions.ge("createTime",corporateStyle.getCreateTimeStart()));
}
if(corporateStyle.getCreateTimeEnd()!=null){
criteria.add(Restrictions.le("createTime",corporateStyle.getCreateTimeEnd()));
}
if(corporateStyle.getUpdateTimeStart()!=null){
criteria.add(Restrictions.ge("updateTime",corporateStyle.getUpdateTimeStart()));
}
if(corporateStyle.getUpdateTimeEnd()!=null){
criteria.add(Restrictions.le("updateTime",corporateStyle.getUpdateTimeEnd()));
}
       if(corporateStyle.getOrderNum()!=null
){
		criteria.add(Restrictions.eq("orderNum",corporateStyle.getOrderNum()));
}
       if(corporateStyle.getStatus()!=null
){
		criteria.add(Restrictions.eq("status",corporateStyle.getStatus()));
}
    }
	@Override
	public CorporateStyle findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(CorporateStyle.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (CorporateStyle)list.get(0);
		}
		return null;
	}
	@Override
	public List<CorporateStyle> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(CorporateStyle.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(CorporateStyle.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CorporateStyle> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(CorporateStyle.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}