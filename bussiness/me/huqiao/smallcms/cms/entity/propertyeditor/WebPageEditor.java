package me.huqiao.smallcms.cms.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.cms.entity.WebPage;
import me.huqiao.smallcms.cms.service.IWebPageService;
/**
 * 栏目编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class WebPageEditor extends PropertyEditorSupport{
    public IWebPageService webPageService;
    public WebPageEditor(IWebPageService webPageService){
        this.webPageService = webPageService;
    }
    public String getAsText(){
        WebPage webPage = (WebPage)getValue();
        if(webPage==null){
            return "";
        }
        return String.valueOf(webPage.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        WebPage webPage = null;
webPage = webPageService.getEntityByProperty(WebPage.class,"manageKey",key);
if(webPage==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            webPage = webPageService.getById(WebPage.class,integerId);
}
if(key!=null && !key.trim().equals("") && webPage==null){
webPage=new WebPage();
}
        setValue(webPage);
    }
}