package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.QualityArchiveCompany;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCompanyService;
/**
 * 质量档案公司编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class QualityArchiveCompanyEditor extends PropertyEditorSupport{
    public IQualityArchiveCompanyService qualityArchiveCompanyService;
    public QualityArchiveCompanyEditor(IQualityArchiveCompanyService qualityArchiveCompanyService){
        this.qualityArchiveCompanyService = qualityArchiveCompanyService;
    }
    public String getAsText(){
        QualityArchiveCompany qualityArchiveCompany = (QualityArchiveCompany)getValue();
        if(qualityArchiveCompany==null){
            return "";
        }
        return String.valueOf(qualityArchiveCompany.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        QualityArchiveCompany qualityArchiveCompany = null;
qualityArchiveCompany = qualityArchiveCompanyService.getEntityByProperty(QualityArchiveCompany.class,"manageKey",key);
if(qualityArchiveCompany==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            qualityArchiveCompany = qualityArchiveCompanyService.getById(QualityArchiveCompany.class,integerId);
}
if(key!=null && !key.trim().equals("") && qualityArchiveCompany==null){
qualityArchiveCompany=new QualityArchiveCompany();
}
        setValue(qualityArchiveCompany);
    }
}