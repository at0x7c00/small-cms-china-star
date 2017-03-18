package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.Apply;
import me.huqiao.smallcms.ppll.service.IApplyService;
/**
 * 会员入会申请编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class ApplyEditor extends PropertyEditorSupport{
    public IApplyService applyService;
    public ApplyEditor(IApplyService applyService){
        this.applyService = applyService;
    }
    public String getAsText(){
        Apply apply = (Apply)getValue();
        if(apply==null){
            return "";
        }
        return String.valueOf(apply.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Apply apply = null;
apply = applyService.getEntityByProperty(Apply.class,"manageKey",key);
if(apply==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            apply = applyService.getById(Apply.class,integerId);
}
if(key!=null && !key.trim().equals("") && apply==null){
apply=new Apply();
}
        setValue(apply);
    }
}