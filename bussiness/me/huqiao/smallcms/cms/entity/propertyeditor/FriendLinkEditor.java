package me.huqiao.smallcms.cms.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.cms.entity.FriendLink;
import me.huqiao.smallcms.cms.service.IFriendLinkService;
/**
 * 友情链接编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class FriendLinkEditor extends PropertyEditorSupport{
    public IFriendLinkService friendLinkService;
    public FriendLinkEditor(IFriendLinkService friendLinkService){
        this.friendLinkService = friendLinkService;
    }
    public String getAsText(){
        FriendLink friendLink = (FriendLink)getValue();
        if(friendLink==null){
            return "";
        }
        return String.valueOf(friendLink.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        FriendLink friendLink = null;
friendLink = friendLinkService.getEntityByProperty(FriendLink.class,"manageKey",key);
if(friendLink==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            friendLink = friendLinkService.getById(FriendLink.class,integerId);
}
if(key!=null && !key.trim().equals("") && friendLink==null){
friendLink=new FriendLink();
}
        setValue(friendLink);
    }
}