package me.huqiao.smallcms.chinastar.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.chinastar.dao.IInformationDao;
import me.huqiao.smallcms.chinastar.entity.Information;
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
 * 资讯DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class InformationDaoImpl extends BaseDaoImpl<Information> implements IInformationDao {
    @Override
    public Long findListRowCount(Information information) {
        Criteria criteria = getSession().createCriteria(Information.class).setProjection(Projections.rowCount());
        queryCause(criteria,information);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Information information,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Information.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(information.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Information> findListPage(Information information, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Information.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,information);
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
	public List<HistoryRecord<Information>> findHistoryListPage(Information information, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Information.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(information.getManageKey()));
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
		List<HistoryRecord<Information>> res = new ArrayList<HistoryRecord<Information>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Information> record = new HistoryRecord<Information>();
			record.setRecord((Information)array[0]);
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
      * @param information 查询对象
	  */
    public void queryCause(Criteria criteria,Information information){
       if(information.getTitle()!=null
 && ! information.getTitle().trim().equals("")){
		criteria.add(Restrictions.like("title",information.getTitle(),MatchMode.ANYWHERE));
}
       if(information.getContent()!=null
 && ! information.getContent().trim().equals("")){
		criteria.add(Restrictions.like("content",information.getContent(),MatchMode.ANYWHERE));
}
if(information.getCreateTimeStart()!=null){
criteria.add(Restrictions.ge("createTime",information.getCreateTimeStart()));
}
if(information.getCreateTimeEnd()!=null){
criteria.add(Restrictions.le("createTime",information.getCreateTimeEnd()));
}
if(information.getUpdateTimeStart()!=null){
criteria.add(Restrictions.ge("updateTime",information.getUpdateTimeStart()));
}
if(information.getUpdateTimeEnd()!=null){
criteria.add(Restrictions.le("updateTime",information.getUpdateTimeEnd()));
}
				if(information.getCreator()!=null && information.getCreator().getId() != null ){
					criteria.add(Restrictions.eq("creator",information.getCreator()));
				}
				if(information.getCover()!=null && information.getCover().getId() != null ){
					criteria.add(Restrictions.eq("cover",information.getCover()));
				}
       if(information.getOrderNum()!=null
){
		criteria.add(Restrictions.eq("orderNum",information.getOrderNum()));
}
       if(information.getStatus()!=null
){
		criteria.add(Restrictions.eq("status",information.getStatus()));
}
    }
	@Override
	public Information findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Information.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Information)list.get(0);
		}
		return null;
	}
	@Override
	public List<Information> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Information.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Information.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Information> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Information.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}