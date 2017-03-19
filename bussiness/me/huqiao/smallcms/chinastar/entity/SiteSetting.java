package me.huqiao.smallcms.chinastar.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import me.huqiao.smallcms.common.entity.CommonFile;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 网站设置
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_site_setting")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class SiteSetting
{
/**唯一识别ID号 */
protected Integer id;
	/**@param id 要设置的唯一标示号*/
public void setId(Integer id){this.id=id;}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(columnDefinition="integer")
	/**@return Integer 唯一标示号*/
public Integer getId(){return this.id;}
/**网站头图*/
private CommonFile headerPic;
	/**网站头图模糊查询条件*/
private String headerPicQuery;
/**资讯栏目头图*/
private CommonFile infoHeaderPic;
	/**资讯栏目头图模糊查询条件*/
private String infoHeaderPicQuery;
	/**MD5管理ID*/
	protected String manageKey;
	/**@return String MD5管理ID */
	public String getManageKey() {
		return manageKey;
	}
	/**
	 * @param manageKey 要设置的MD5管理ID 
	 */
	public void setManageKey(String manageKey) {
		this.manageKey = manageKey;
	}
/**
 * @param headerPic 要设置的网站头图
 */
public void setHeaderPic(CommonFile headerPic){
    this.headerPic = headerPic;
}
/**
 * @param headerPicQuery 要设置的网站头图模糊查询条件
 */
public void setHeaderPicQuery(String headerPicQuery){
    this.headerPicQuery = headerPicQuery;
}
/**
 * @return CommonFile 网站头图 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="header_file_id",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getHeaderPic(){
		return this.headerPic;	
}
/**
 * @return  String 网站头图模糊查询条件
 */
@Transient
public String getHeaderPicQuery(){
    return this.headerPicQuery;
}
/**
 * @param infoHeaderPic 要设置的资讯栏目头图
 */
public void setInfoHeaderPic(CommonFile infoHeaderPic){
    this.infoHeaderPic = infoHeaderPic;
}
/**
 * @param infoHeaderPicQuery 要设置的资讯栏目头图模糊查询条件
 */
public void setInfoHeaderPicQuery(String infoHeaderPicQuery){
    this.infoHeaderPicQuery = infoHeaderPicQuery;
}
/**
 * @return CommonFile 资讯栏目头图 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="info_header_file_id",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getInfoHeaderPic(){
		return this.infoHeaderPic;	
}
/**
 * @return  String 资讯栏目头图模糊查询条件
 */
@Transient
public String getInfoHeaderPicQuery(){
    return this.infoHeaderPicQuery;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		SiteSetting other = null;
		try{
			other = (SiteSetting) obj;
		}catch(Exception e){
			return false;
		}
		if (manageKey == null) {
			if (other.getManageKey() != null)
				return false;
		} else if (!manageKey.equals(other.getManageKey()))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manageKey == null) ? 0 : manageKey.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "SiteSetting [manageKey=" + manageKey + "]";
	}
}