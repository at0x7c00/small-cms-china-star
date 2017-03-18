package me.huqiao.smallcms.cms.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.cms.dao.IChapterDao;
import me.huqiao.smallcms.cms.entity.Chapter;
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
 * 文章DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class ChapterDaoImpl extends BaseDaoImpl<Chapter> implements IChapterDao {
    @Override
    public Long findListRowCount(Chapter chapter) {
        Criteria criteria = getSession().createCriteria(Chapter.class).setProjection(Projections.rowCount());
        queryCause(criteria,chapter);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Chapter chapter,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Chapter.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(chapter.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Chapter> findListPage(Chapter chapter, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Chapter.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,chapter);
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
	public List<HistoryRecord<Chapter>> findHistoryListPage(Chapter chapter, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Chapter.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(chapter.getManageKey()));
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
		List<HistoryRecord<Chapter>> res = new ArrayList<HistoryRecord<Chapter>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Chapter> record = new HistoryRecord<Chapter>();
			record.setRecord((Chapter)array[0]);
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
	  * 根据查询对象往criteria对象��加查询条件
      * @param criteria Hibernate criteria对象
      * @param chapter 查询对象
	  */
    public void queryCause(Criteria criteria,Chapter chapter){
				if(chapter.getCreator()!=null && chapter.getCreator().getId() != null ){
					criteria.add(Restrictions.eq("creator",chapter.getCreator()));
				}
       if(chapter.getReadCount()!=null
){
		criteria.add(Restrictions.eq("readCount",chapter.getReadCount()));
}
if(chapter.getCreateTimeStart()!=null){
criteria.add(Restrictions.ge("createTime",chapter.getCreateTimeStart()));
}
if(chapter.getCreateTimeEnd()!=null){
criteria.add(Restrictions.le("createTime",chapter.getCreateTimeEnd()));
}
       if(chapter.getTitle()!=null
 && ! chapter.getTitle().trim().equals("")){
		criteria.add(Restrictions.like("title",chapter.getTitle(),MatchMode.ANYWHERE));
}
       if(chapter.getContent()!=null
 && ! chapter.getContent().trim().equals("")){
		criteria.add(Restrictions.like("content",chapter.getContent(),MatchMode.ANYWHERE));
}
				if(chapter.getPage()!=null && chapter.getPage().getId() != null ){
					criteria.add(Restrictions.eq("page",chapter.getPage()));
				}
				if(chapter.getCover()!=null && chapter.getCover().getId() != null ){
					criteria.add(Restrictions.eq("cover",chapter.getCover()));
				}
       if(chapter.getOrderNum()!=null
){
		criteria.add(Restrictions.eq("orderNum",chapter.getOrderNum()));
}
       if(chapter.getStatus()!=null
){
		criteria.add(Restrictions.eq("status",chapter.getStatus()));
}
    }
	@Override
	public Chapter findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Chapter.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Chapter)list.get(0);
		}
		return null;
	}
	@Override
	public List<Chapter> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Chapter.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Chapter.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Chapter> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Chapter.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}