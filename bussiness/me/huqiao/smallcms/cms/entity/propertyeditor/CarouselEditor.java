package me.huqiao.smallcms.cms.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.cms.entity.Carousel;
import me.huqiao.smallcms.cms.service.ICarouselService;
/**
 * 轮播编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class CarouselEditor extends PropertyEditorSupport{
    public ICarouselService carouselService;
    public CarouselEditor(ICarouselService carouselService){
        this.carouselService = carouselService;
    }
    public String getAsText(){
        Carousel carousel = (Carousel)getValue();
        if(carousel==null){
            return "";
        }
        return String.valueOf(carousel.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Carousel carousel = null;
carousel = carouselService.getEntityByProperty(Carousel.class,"manageKey",key);
if(carousel==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            carousel = carouselService.getById(Carousel.class,integerId);
}
if(key!=null && !key.trim().equals("") && carousel==null){
carousel=new Carousel();
}
        setValue(carousel);
    }
}