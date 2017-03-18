package me.huqiao.smallcms.ppll.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.ppll.dao.IApplyDao;
import me.huqiao.smallcms.ppll.entity.Apply;
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
 * 会员入会申请DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class ApplyDaoImpl extends BaseDaoImpl<Apply> implements IApplyDao {
    @Override
    public Long findListRowCount(Apply apply) {
        Criteria criteria = getSession().createCriteria(Apply.class).setProjection(Projections.rowCount());
        queryCause(criteria,apply);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Apply apply,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Apply.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(apply.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Apply> findListPage(Apply apply, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Apply.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,apply);
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
	public List<HistoryRecord<Apply>> findHistoryListPage(Apply apply, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Apply.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(apply.getManageKey()));
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
		List<HistoryRecord<Apply>> res = new ArrayList<HistoryRecord<Apply>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Apply> record = new HistoryRecord<Apply>();
			record.setRecord((Apply)array[0]);
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
      * @param apply 查询对象
	  */
    public void queryCause(Criteria criteria,Apply apply){
       if(apply.getName()!=null
 && ! apply.getName().trim().equals("")){
		criteria.add(Restrictions.like("name",apply.getName(),MatchMode.ANYWHERE));
}
       if(apply.getAddress()!=null
 && ! apply.getAddress().trim().equals("")){
		criteria.add(Restrictions.like("address",apply.getAddress(),MatchMode.ANYWHERE));
}
       if(apply.getContact()!=null
 && ! apply.getContact().trim().equals("")){
		criteria.add(Restrictions.like("contact",apply.getContact(),MatchMode.ANYWHERE));
}
       if(apply.getTel()!=null
 && ! apply.getTel().trim().equals("")){
		criteria.add(Restrictions.like("tel",apply.getTel(),MatchMode.ANYWHERE));
}
       if(apply.getRegistMoney()!=null
){
		criteria.add(Restrictions.eq("registMoney",apply.getRegistMoney()));
}
       if(apply.getIndustry()!=null
 && ! apply.getIndustry().trim().equals("")){
		criteria.add(Restrictions.like("industry",apply.getIndustry(),MatchMode.ANYWHERE));
}
       if(apply.getBandNum()!=null
 && ! apply.getBandNum().trim().equals("")){
		criteria.add(Restrictions.like("bandNum",apply.getBandNum(),MatchMode.ANYWHERE));
}
       if(apply.getRemark()!=null
 && ! apply.getRemark().trim().equals("")){
		criteria.add(Restrictions.like("remark",apply.getRemark(),MatchMode.ANYWHERE));
}
       if(apply.getStatus()!=null
    		   ){
    		   		criteria.add(Restrictions.eq("status",apply.getStatus()));
    		   }
    }
	@Override
	public Apply findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Apply.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Apply)list.get(0);
		}
		return null;
	}
	@Override
	public List<Apply> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Apply.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Apply.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Apply> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Apply.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}