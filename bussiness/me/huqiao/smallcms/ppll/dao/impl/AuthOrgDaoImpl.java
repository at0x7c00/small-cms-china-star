package me.huqiao.smallcms.ppll.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.ppll.dao.IAuthOrgDao;
import me.huqiao.smallcms.ppll.entity.AuthOrg;
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
 * 授权机构DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class AuthOrgDaoImpl extends BaseDaoImpl<AuthOrg> implements IAuthOrgDao {
    @Override
    public Long findListRowCount(AuthOrg authOrg) {
        Criteria criteria = getSession().createCriteria(AuthOrg.class).setProjection(Projections.rowCount());
        queryCause(criteria,authOrg);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(AuthOrg authOrg,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(AuthOrg.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(authOrg.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<AuthOrg> findListPage(AuthOrg authOrg, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(AuthOrg.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,authOrg);
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
	public List<HistoryRecord<AuthOrg>> findHistoryListPage(AuthOrg authOrg, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(AuthOrg.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(authOrg.getManageKey()));
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
		List<HistoryRecord<AuthOrg>> res = new ArrayList<HistoryRecord<AuthOrg>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<AuthOrg> record = new HistoryRecord<AuthOrg>();
			record.setRecord((AuthOrg)array[0]);
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
      * @param authOrg 查询对象
	  */
    public void queryCause(Criteria criteria,AuthOrg authOrg){
       if(authOrg.getName()!=null
 && ! authOrg.getName().trim().equals("")){
		criteria.add(
				Restrictions.or(
				Restrictions.like("name",authOrg.getName(),MatchMode.ANYWHERE),
				Restrictions.like("tel",authOrg.getName(),MatchMode.ANYWHERE),
				Restrictions.like("address",authOrg.getName(),MatchMode.ANYWHERE)
				)
				);
}
       if(authOrg.getTel()!=null
 && ! authOrg.getTel().trim().equals("")){
		criteria.add(Restrictions.like("tel",authOrg.getTel(),MatchMode.ANYWHERE));
}
       if(authOrg.getAddress()!=null
 && ! authOrg.getAddress().trim().equals("")){
		criteria.add(Restrictions.like("address",authOrg.getAddress(),MatchMode.ANYWHERE));
}
if(authOrg.getCoroprateFromStart()!=null){
criteria.add(Restrictions.ge("coroprateFrom",authOrg.getCoroprateFromStart()));
}
if(authOrg.getCoroprateFromEnd()!=null){
criteria.add(Restrictions.le("coroprateFrom",authOrg.getCoroprateFromEnd()));
}
if(authOrg.getCoroprateToStart()!=null){
criteria.add(Restrictions.ge("coroprateTo",authOrg.getCoroprateToStart()));
}
if(authOrg.getCoroprateToEnd()!=null){
criteria.add(Restrictions.le("coroprateTo",authOrg.getCoroprateToEnd()));
}
				if(authOrg.getCertFile()!=null && authOrg.getCertFile().getId() != null ){
					criteria.add(Restrictions.eq("certFile",authOrg.getCertFile()));
				}
				
				if(authOrg.getStatus()!=null
						){
								criteria.add(Restrictions.eq("status",authOrg.getStatus()));
						}
    }
	@Override
	public AuthOrg findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(AuthOrg.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (AuthOrg)list.get(0);
		}
		return null;
	}
	@Override
	public List<AuthOrg> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(AuthOrg.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(AuthOrg.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AuthOrg> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(AuthOrg.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}