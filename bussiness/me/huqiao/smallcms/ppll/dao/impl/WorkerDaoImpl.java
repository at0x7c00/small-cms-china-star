package me.huqiao.smallcms.ppll.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.ppll.dao.IWorkerDao;
import me.huqiao.smallcms.ppll.entity.Worker;
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
 * 工作人员DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class WorkerDaoImpl extends BaseDaoImpl<Worker> implements IWorkerDao {
    @Override
    public Long findListRowCount(Worker worker) {
        Criteria criteria = getSession().createCriteria(Worker.class).setProjection(Projections.rowCount());
        queryCause(criteria,worker);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Worker worker,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Worker.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(worker.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Worker> findListPage(Worker worker, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Worker.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,worker);
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
	public List<HistoryRecord<Worker>> findHistoryListPage(Worker worker, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Worker.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(worker.getManageKey()));
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
		List<HistoryRecord<Worker>> res = new ArrayList<HistoryRecord<Worker>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Worker> record = new HistoryRecord<Worker>();
			record.setRecord((Worker)array[0]);
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
	  * 根据查询对象往criteria���象增加查询条件
      * @param criteria Hibernate criteria对象
      * @param worker 查询对象
	  */
    public void queryCause(Criteria criteria,Worker worker){
       if(worker.getWorkNum()!=null
 && ! worker.getWorkNum().trim().equals("")){
		criteria.add(Restrictions.like("workNum",worker.getWorkNum(),MatchMode.ANYWHERE));
}
				if(worker.getPhotoFile()!=null && worker.getPhotoFile().getId() != null ){
					criteria.add(Restrictions.eq("photoFile",worker.getPhotoFile()));
				}
       if(worker.getName()!=null
 && ! worker.getName().trim().equals("")){
		criteria.add(
				Restrictions.or(
				Restrictions.like("name",worker.getName(),MatchMode.ANYWHERE),
				Restrictions.like("workNum",worker.getName(),MatchMode.ANYWHERE),
				Restrictions.like("area",worker.getName(),MatchMode.ANYWHERE),
				Restrictions.like("job",worker.getName(),MatchMode.ANYWHERE)
				)
				);
}
       if(worker.getArea()!=null
 && ! worker.getArea().trim().equals("")){
		criteria.add(Restrictions.like("area",worker.getArea(),MatchMode.ANYWHERE));
}
       if(worker.getJob()!=null
 && ! worker.getJob().trim().equals("")){
		criteria.add(Restrictions.like("job",worker.getJob(),MatchMode.ANYWHERE));
}
       if(worker.getStatus()!=null
    		   ){
    		   		criteria.add(Restrictions.eq("status",worker.getStatus()));
    		   }
    }
    
	@Override
	public Worker findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Worker.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Worker)list.get(0);
		}
		return null;
	}
	@Override
	public List<Worker> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Worker.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Worker.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Worker> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Worker.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}