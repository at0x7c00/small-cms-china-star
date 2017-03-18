package me.huqiao.smallcms.cms.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.cms.entity.Advertisement;
import me.huqiao.smallcms.cms.service.IAdvertisementService;
/**
 * 广告编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class AdvertisementEditor extends PropertyEditorSupport{
    public IAdvertisementService advertisementService;
    public AdvertisementEditor(IAdvertisementService advertisementService){
        this.advertisementService = advertisementService;
    }
    public String getAsText(){
        Advertisement advertisement = (Advertisement)getValue();
        if(advertisement==null){
            return "";
        }
        return String.valueOf(advertisement.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Advertisement advertisement = null;
advertisement = advertisementService.getEntityByProperty(Advertisement.class,"manageKey",key);
if(advertisement==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            advertisement = advertisementService.getById(Advertisement.class,integerId);
}
if(key!=null && !key.trim().equals("") && advertisement==null){
advertisement=new Advertisement();
}
        setValue(advertisement);
    }
}