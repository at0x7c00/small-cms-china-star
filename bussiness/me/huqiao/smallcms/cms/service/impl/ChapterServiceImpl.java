package me.huqiao.smallcms.cms.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.cms.dao.IChapterDao;
import me.huqiao.smallcms.cms.entity.Chapter;
import me.huqiao.smallcms.cms.entity.WebPage;
import me.huqiao.smallcms.cms.service.IChapterService;
import me.huqiao.smallcms.cms.service.IWebPageService;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 文章Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class ChapterServiceImpl extends BaseServiceImpl<Chapter> implements IChapterService {
	
	@Resource
	private IWebPageService pageService;
	
    /**文章DAO对象*/
    @Resource
    private IChapterDao chapterDao;
    @Override
    public Page<Chapter> getListPage(Chapter chapter,Page pageInfo) {
      	pageInfo.setTotalCount(chapterDao.findListRowCount(chapter).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(chapterDao.findListPage(chapter,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Chapter>> getHistoryListPage(Chapter chapter, Page pageInfo) {
		pageInfo.setTotalCount(chapterDao.findHistoryListRowCount(chapter,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(chapterDao.findHistoryListPage(chapter,pageInfo));
        return pageInfo;
	}
	@Override
	public Chapter findByVersion(Integer version) {
		return chapterDao.findByVersion(version);
	}
	@Override
	public Page<Chapter> queryByKey(String queryKey, Page<Chapter> pageInfo) {
		int countRecord = chapterDao.findRowCount(queryKey).intValue();
		Page<Chapter> page = new Page<Chapter>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Chapter> chapterList = chapterDao.findByKey(pageInfo,queryKey);
		page.setList(chapterList);
		return page;
	}
	@Override
	public List<Chapter> queryById(Integer[] ids) {
		return chapterDao.findById(ids);
	}
	
	public List<Chapter> getTop(Integer top,Integer type){
		WebPage p = pageService.getById(WebPage.class, type);
		return getByProperties(Chapter.class, new String[]{"status","page"}, new Object[]{UseStatus.InUse,p}, "orderNum asc,updateTime desc", top);
	}
	
	public Page<Chapter> getAll(Integer type,Page<Chapter> pageInfo){
		WebPage p = pageService.getById(WebPage.class, type);
		Chapter chapter = new Chapter();
		chapter.setPage(p);
		chapter.setStatus(UseStatus.InUse);
		pageInfo.setOrderField("updateTime");
		pageInfo.setOrderDirection("desc");
		return getListPage(chapter, pageInfo);
	}
	
	public List<Chapter> getTop10OfAll(){
		return getByProperties(Chapter.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "readCount desc,updateTime desc", 10);
	}
	
}