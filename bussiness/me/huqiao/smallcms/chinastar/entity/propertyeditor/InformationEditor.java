package me.huqiao.smallcms.chinastar.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.chinastar.entity.Information;
import me.huqiao.smallcms.chinastar.service.IInformationService;
/**
 * 资讯编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class InformationEditor extends PropertyEditorSupport{
    public IInformationService informationService;
    public InformationEditor(IInformationService informationService){
        this.informationService = informationService;
    }
    public String getAsText(){
        Information information = (Information)getValue();
        if(information==null){
            return "";
        }
        return String.valueOf(information.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Information information = null;
information = informationService.getEntityByProperty(Information.class,"manageKey",key);
if(information==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            information = informationService.getById(Information.class,integerId);
}
if(key!=null && !key.trim().equals("") && information==null){
information=new Information();
}
        setValue(information);
    }
}