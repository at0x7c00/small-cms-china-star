package me.huqiao.smallcms.ppll.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.ppll.dao.IMemberOrganizationDao;
import me.huqiao.smallcms.ppll.entity.MemberOrganization;
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
 * 会员单位DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class MemberOrganizationDaoImpl extends BaseDaoImpl<MemberOrganization> implements IMemberOrganizationDao {
    @Override
    public Long findListRowCount(MemberOrganization memberOrganization) {
        Criteria criteria = getSession().createCriteria(MemberOrganization.class).setProjection(Projections.rowCount());
        queryCause(criteria,memberOrganization);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(MemberOrganization memberOrganization,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(MemberOrganization.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(memberOrganization.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<MemberOrganization> findListPage(MemberOrganization memberOrganization, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(MemberOrganization.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,memberOrganization);
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
	public List<HistoryRecord<MemberOrganization>> findHistoryListPage(MemberOrganization memberOrganization, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(MemberOrganization.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(memberOrganization.getManageKey()));
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
		List<HistoryRecord<MemberOrganization>> res = new ArrayList<HistoryRecord<MemberOrganization>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<MemberOrganization> record = new HistoryRecord<MemberOrganization>();
			record.setRecord((MemberOrganization)array[0]);
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
      * @param memberOrganization 查询对象
	  */
    public void queryCause(Criteria criteria,MemberOrganization memberOrganization){
       if(memberOrganization.getName()!=null
 && ! memberOrganization.getName().trim().equals("")){
		criteria.add(Restrictions.like("name",memberOrganization.getName(),MatchMode.ANYWHERE));
}
if(memberOrganization.getCorporateFromStart()!=null){
criteria.add(Restrictions.ge("corporateFrom",memberOrganization.getCorporateFromStart()));
}
if(memberOrganization.getCorporateFromEnd()!=null){
criteria.add(Restrictions.le("corporateFrom",memberOrganization.getCorporateFromEnd()));
}
if(memberOrganization.getCorporateToStart()!=null){
criteria.add(Restrictions.ge("corporateTo",memberOrganization.getCorporateToStart()));
}
if(memberOrganization.getCorporateToEnd()!=null){
criteria.add(Restrictions.le("corporateTo",memberOrganization.getCorporateToEnd()));
}
				if(memberOrganization.getCertFile()!=null && memberOrganization.getCertFile().getId() != null ){
					criteria.add(Restrictions.eq("certFile",memberOrganization.getCertFile()));
				}
				
				if(memberOrganization.getStatus()!=null
						){
								criteria.add(Restrictions.eq("status",memberOrganization.getStatus()));
						}
    }
	@Override
	public MemberOrganization findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(MemberOrganization.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (MemberOrganization)list.get(0);
		}
		return null;
	}
	@Override
	public List<MemberOrganization> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(MemberOrganization.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(MemberOrganization.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberOrganization> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(MemberOrganization.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}