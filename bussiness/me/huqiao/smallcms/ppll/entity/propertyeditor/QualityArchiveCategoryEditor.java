package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCategoryService;
/**
 * 质量档案类别编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class QualityArchiveCategoryEditor extends PropertyEditorSupport{
    public IQualityArchiveCategoryService qualityArchiveCategoryService;
    public QualityArchiveCategoryEditor(IQualityArchiveCategoryService qualityArchiveCategoryService){
        this.qualityArchiveCategoryService = qualityArchiveCategoryService;
    }
    public String getAsText(){
        QualityArchiveCategory qualityArchiveCategory = (QualityArchiveCategory)getValue();
        if(qualityArchiveCategory==null){
            return "";
        }
        return String.valueOf(qualityArchiveCategory.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        QualityArchiveCategory qualityArchiveCategory = null;
qualityArchiveCategory = qualityArchiveCategoryService.getEntityByProperty(QualityArchiveCategory.class,"manageKey",key);
if(qualityArchiveCategory==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            qualityArchiveCategory = qualityArchiveCategoryService.getById(QualityArchiveCategory.class,integerId);
}
if(key!=null && !key.trim().equals("") && qualityArchiveCategory==null){
qualityArchiveCategory=new QualityArchiveCategory();
}
        setValue(qualityArchiveCategory);
    }
}