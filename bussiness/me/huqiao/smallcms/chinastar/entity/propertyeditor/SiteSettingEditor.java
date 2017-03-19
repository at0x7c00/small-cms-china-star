package me.huqiao.smallcms.chinastar.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.chinastar.entity.SiteSetting;
import me.huqiao.smallcms.chinastar.service.ISiteSettingService;
/**
 * 网站设置编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class SiteSettingEditor extends PropertyEditorSupport{
    public ISiteSettingService siteSettingService;
    public SiteSettingEditor(ISiteSettingService siteSettingService){
        this.siteSettingService = siteSettingService;
    }
    public String getAsText(){
        SiteSetting siteSetting = (SiteSetting)getValue();
        if(siteSetting==null){
            return "";
        }
        return String.valueOf(siteSetting.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        SiteSetting siteSetting = null;
siteSetting = siteSettingService.getEntityByProperty(SiteSetting.class,"manageKey",key);
if(siteSetting==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            siteSetting = siteSettingService.getById(SiteSetting.class,integerId);
}
if(key!=null && !key.trim().equals("") && siteSetting==null){
siteSetting=new SiteSetting();
}
        setValue(siteSetting);
    }
}