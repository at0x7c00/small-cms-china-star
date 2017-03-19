package me.huqiao.smallcms.chinastar.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.chinastar.entity.CorporateStyle;
import me.huqiao.smallcms.chinastar.service.ICorporateStyleService;
/**
 * 企业风采编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class CorporateStyleEditor extends PropertyEditorSupport{
    public ICorporateStyleService corporateStyleService;
    public CorporateStyleEditor(ICorporateStyleService corporateStyleService){
        this.corporateStyleService = corporateStyleService;
    }
    public String getAsText(){
        CorporateStyle corporateStyle = (CorporateStyle)getValue();
        if(corporateStyle==null){
            return "";
        }
        return String.valueOf(corporateStyle.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        CorporateStyle corporateStyle = null;
corporateStyle = corporateStyleService.getEntityByProperty(CorporateStyle.class,"manageKey",key);
if(corporateStyle==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            corporateStyle = corporateStyleService.getById(CorporateStyle.class,integerId);
}
if(key!=null && !key.trim().equals("") && corporateStyle==null){
corporateStyle=new CorporateStyle();
}
        setValue(corporateStyle);
    }
}