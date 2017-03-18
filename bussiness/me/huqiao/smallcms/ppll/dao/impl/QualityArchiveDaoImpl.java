package me.huqiao.smallcms.ppll.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.ppll.dao.IQualityArchiveDao;
import me.huqiao.smallcms.ppll.entity.QualityArchive;
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
 * 质量档案DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class QualityArchiveDaoImpl extends BaseDaoImpl<QualityArchive> implements IQualityArchiveDao {
    @Override
    public Long findListRowCount(QualityArchive qualityArchive) {
        Criteria criteria = getSession().createCriteria(QualityArchive.class).setProjection(Projections.rowCount());
        queryCause(criteria,qualityArchive);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(QualityArchive qualityArchive,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(QualityArchive.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(qualityArchive.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<QualityArchive> findListPage(QualityArchive qualityArchive, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(QualityArchive.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,qualityArchive);
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
	public List<HistoryRecord<QualityArchive>> findHistoryListPage(QualityArchive qualityArchive, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(QualityArchive.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(qualityArchive.getManageKey()));
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
		List<HistoryRecord<QualityArchive>> res = new ArrayList<HistoryRecord<QualityArchive>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<QualityArchive> record = new HistoryRecord<QualityArchive>();
			record.setRecord((QualityArchive)array[0]);
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
      * @param qualityArchive 查询对象
	  */
    public void queryCause(Criteria criteria,QualityArchive qualityArchive){
       if(qualityArchive.getTitle()!=null
 && ! qualityArchive.getTitle().trim().equals("")){
		criteria.add(Restrictions.like("title",qualityArchive.getTitle(),MatchMode.ANYWHERE));
}
       if(qualityArchive.getContent()!=null
 && ! qualityArchive.getContent().trim().equals("")){
		criteria.add(Restrictions.like("content",qualityArchive.getContent(),MatchMode.ANYWHERE));
}
				if(qualityArchive.getDetailCover()!=null && qualityArchive.getDetailCover().getId() != null ){
					criteria.add(Restrictions.eq("detailCover",qualityArchive.getDetailCover()));
				}
				if(qualityArchive.getCreator()!=null && qualityArchive.getCreator().getId() != null ){
					criteria.add(Restrictions.eq("creator",qualityArchive.getCreator()));
				}
if(qualityArchive.getCreateTimeStart()!=null){
criteria.add(Restrictions.ge("createTime",qualityArchive.getCreateTimeStart()));
}
if(qualityArchive.getCreateTimeEnd()!=null){
criteria.add(Restrictions.le("createTime",qualityArchive.getCreateTimeEnd()));
}
       if(qualityArchive.getOrderNum()!=null
){
		criteria.add(Restrictions.eq("orderNum",qualityArchive.getOrderNum()));
}
if(qualityArchive.getReadCountStart()!=null){
criteria.add(Restrictions.ge("readCount",qualityArchive.getReadCountStart()));
}
if(qualityArchive.getReadCountEnd()!=null){
criteria.add(Restrictions.le("readCount",qualityArchive.getReadCountEnd()));
}
       if(qualityArchive.getStatus()!=null
){
		criteria.add(Restrictions.eq("status",qualityArchive.getStatus()));
}
       
       if(qualityArchive.getCategory()!=null ){
    		   		criteria.add(Restrictions.eq("category",qualityArchive.getCategory()));
       }
    }
	@Override
	public QualityArchive findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(QualityArchive.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (QualityArchive)list.get(0);
		}
		return null;
	}
	@Override
	public List<QualityArchive> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(QualityArchive.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(QualityArchive.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QualityArchive> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(QualityArchive.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}