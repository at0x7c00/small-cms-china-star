package me.huqiao.smallcms.ppll.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.ppll.dao.IQualityArchiveCompanyDao;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCompany;
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
 * 质量档案公司DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class QualityArchiveCompanyDaoImpl extends BaseDaoImpl<QualityArchiveCompany> implements IQualityArchiveCompanyDao {
    @Override
    public Long findListRowCount(QualityArchiveCompany qualityArchiveCompany) {
        Criteria criteria = getSession().createCriteria(QualityArchiveCompany.class).setProjection(Projections.rowCount());
        queryCause(criteria,qualityArchiveCompany);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(QualityArchiveCompany qualityArchiveCompany,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(QualityArchiveCompany.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(qualityArchiveCompany.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<QualityArchiveCompany> findListPage(QualityArchiveCompany qualityArchiveCompany, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(QualityArchiveCompany.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,qualityArchiveCompany);
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
	public List<HistoryRecord<QualityArchiveCompany>> findHistoryListPage(QualityArchiveCompany qualityArchiveCompany, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(QualityArchiveCompany.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(qualityArchiveCompany.getManageKey()));
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
		List<HistoryRecord<QualityArchiveCompany>> res = new ArrayList<HistoryRecord<QualityArchiveCompany>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<QualityArchiveCompany> record = new HistoryRecord<QualityArchiveCompany>();
			record.setRecord((QualityArchiveCompany)array[0]);
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
      * @param qualityArchiveCompany 查询对象
	  */
    public void queryCause(Criteria criteria,QualityArchiveCompany qualityArchiveCompany){
       if(qualityArchiveCompany.getName()!=null && ! qualityArchiveCompany.getName().trim().equals("")){
    	   criteria.add(
    			   Restrictions.or(
    			   Restrictions.like("name",qualityArchiveCompany.getName(),MatchMode.ANYWHERE),
    			   Restrictions.like("lawPerson",qualityArchiveCompany.getName(),MatchMode.ANYWHERE),
    			   Restrictions.like("address",qualityArchiveCompany.getName(),MatchMode.ANYWHERE),
    			   Restrictions.like("tradeScope",qualityArchiveCompany.getName(),MatchMode.ANYWHERE),
    			   Restrictions.like("serviceCenter",qualityArchiveCompany.getName(),MatchMode.ANYWHERE)
    			   )
    			   );
       }
       if(qualityArchiveCompany.getLawPerson()!=null
 && ! qualityArchiveCompany.getLawPerson().trim().equals("")){
		criteria.add(Restrictions.like("lawPerson",qualityArchiveCompany.getLawPerson(),MatchMode.ANYWHERE));
}
       if(qualityArchiveCompany.getRegisterMoney()!=null
){
		criteria.add(Restrictions.eq("registerMoney",qualityArchiveCompany.getRegisterMoney()));
}
       if(qualityArchiveCompany.getAddress()!=null
 && ! qualityArchiveCompany.getAddress().trim().equals("")){
		criteria.add(Restrictions.like("address",qualityArchiveCompany.getAddress(),MatchMode.ANYWHERE));
}
       if(qualityArchiveCompany.getTradeScope()!=null
 && ! qualityArchiveCompany.getTradeScope().trim().equals("")){
		criteria.add(Restrictions.like("tradeScope",qualityArchiveCompany.getTradeScope(),MatchMode.ANYWHERE));
}
       if(qualityArchiveCompany.getServiceCenter()!=null
 && ! qualityArchiveCompany.getServiceCenter().trim().equals("")){
		criteria.add(Restrictions.like("serviceCenter",qualityArchiveCompany.getServiceCenter(),MatchMode.ANYWHERE));
}
       if(qualityArchiveCompany.getAuditStatus()!=null
 && ! qualityArchiveCompany.getAuditStatus().trim().equals("")){
		criteria.add(Restrictions.like("auditStatus",qualityArchiveCompany.getAuditStatus(),MatchMode.ANYWHERE));
}
       if(qualityArchiveCompany.getStatus()!=null
){
		criteria.add(Restrictions.eq("status",qualityArchiveCompany.getStatus()));
}
    }
	@Override
	public QualityArchiveCompany findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(QualityArchiveCompany.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (QualityArchiveCompany)list.get(0);
		}
		return null;
	}
	@Override
	public List<QualityArchiveCompany> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(QualityArchiveCompany.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(QualityArchiveCompany.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QualityArchiveCompany> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(QualityArchiveCompany.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}