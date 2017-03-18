package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.MemberOrganization;
import me.huqiao.smallcms.ppll.service.IMemberOrganizationService;
/**
 * 会员单位编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class MemberOrganizationEditor extends PropertyEditorSupport{
    public IMemberOrganizationService memberOrganizationService;
    public MemberOrganizationEditor(IMemberOrganizationService memberOrganizationService){
        this.memberOrganizationService = memberOrganizationService;
    }
    public String getAsText(){
        MemberOrganization memberOrganization = (MemberOrganization)getValue();
        if(memberOrganization==null){
            return "";
        }
        return String.valueOf(memberOrganization.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        MemberOrganization memberOrganization = null;
memberOrganization = memberOrganizationService.getEntityByProperty(MemberOrganization.class,"manageKey",key);
if(memberOrganization==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            memberOrganization = memberOrganizationService.getById(MemberOrganization.class,integerId);
}
if(key!=null && !key.trim().equals("") && memberOrganization==null){
memberOrganization=new MemberOrganization();
}
        setValue(memberOrganization);
    }
}