package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.AuthOrg;
import me.huqiao.smallcms.ppll.service.IAuthOrgService;
/**
 * 授权机构编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class AuthOrgEditor extends PropertyEditorSupport{
    public IAuthOrgService authOrgService;
    public AuthOrgEditor(IAuthOrgService authOrgService){
        this.authOrgService = authOrgService;
    }
    public String getAsText(){
        AuthOrg authOrg = (AuthOrg)getValue();
        if(authOrg==null){
            return "";
        }
        return String.valueOf(authOrg.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        AuthOrg authOrg = null;
authOrg = authOrgService.getEntityByProperty(AuthOrg.class,"manageKey",key);
if(authOrg==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            authOrg = authOrgService.getById(AuthOrg.class,integerId);
}
if(key!=null && !key.trim().equals("") && authOrg==null){
authOrg=new AuthOrg();
}
        setValue(authOrg);
    }
}