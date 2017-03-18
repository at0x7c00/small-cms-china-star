package me.huqiao.smallcms.cms.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.cms.dao.ICarouselDao;
import me.huqiao.smallcms.cms.entity.Carousel;
import me.huqiao.smallcms.cms.service.ICarouselService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 轮播Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class CarouselServiceImpl extends BaseServiceImpl<Carousel> implements ICarouselService {
    /**轮播DAO对象*/
    @Resource
    private ICarouselDao carouselDao;
    @Override
    public Page<Carousel> getListPage(Carousel carousel,Page pageInfo) {
      	pageInfo.setTotalCount(carouselDao.findListRowCount(carousel).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(carouselDao.findListPage(carousel,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Carousel>> getHistoryListPage(Carousel carousel, Page pageInfo) {
		pageInfo.setTotalCount(carouselDao.findHistoryListRowCount(carousel,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(carouselDao.findHistoryListPage(carousel,pageInfo));
        return pageInfo;
	}
	@Override
	public Carousel findByVersion(Integer version) {
		return carouselDao.findByVersion(version);
	}
	@Override
	public Page<Carousel> queryByKey(String queryKey, Page<Carousel> pageInfo) {
		int countRecord = carouselDao.findRowCount(queryKey).intValue();
		Page<Carousel> page = new Page<Carousel>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Carousel> carouselList = carouselDao.findByKey(pageInfo,queryKey);
		page.setList(carouselList);
		return page;
	}
	@Override
	public List<Carousel> queryById(Integer[] ids) {
		return carouselDao.findById(ids);
	}
}