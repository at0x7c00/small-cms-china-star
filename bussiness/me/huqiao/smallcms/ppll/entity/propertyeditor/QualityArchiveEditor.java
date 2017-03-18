package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.QualityArchive;
import me.huqiao.smallcms.ppll.service.IQualityArchiveService;
/**
 * 质量档案编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class QualityArchiveEditor extends PropertyEditorSupport{
    public IQualityArchiveService qualityArchiveService;
    public QualityArchiveEditor(IQualityArchiveService qualityArchiveService){
        this.qualityArchiveService = qualityArchiveService;
    }
    public String getAsText(){
        QualityArchive qualityArchive = (QualityArchive)getValue();
        if(qualityArchive==null){
            return "";
        }
        return String.valueOf(qualityArchive.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        QualityArchive qualityArchive = null;
qualityArchive = qualityArchiveService.getEntityByProperty(QualityArchive.class,"manageKey",key);
if(qualityArchive==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            qualityArchive = qualityArchiveService.getById(QualityArchive.class,integerId);
}
if(key!=null && !key.trim().equals("") && qualityArchive==null){
qualityArchive=new QualityArchive();
}
        setValue(qualityArchive);
    }
}