package me.huqiao.smallcms.cms.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 友情链接
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="cms_friend_link")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class FriendLink
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
/**站点名称*/
private String name;
/**站点地址*/
private String url;
/**排序*/
private Integer orderNum;
	/**排序开始，用于查询*/
private Integer orderNumStart;
	/**排序结束，用于查询*/
private Integer orderNumEnd;
/**站点Logo*/
private CommonFile picture;
	/**站点Logo模糊查询条件*/
private String pictureQuery;
/**状态*/
private UseStatus status;
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
 * @param name 要设置的站点名称
 */
public void setName(String name){
    this.name = name;
}
/**
 * @return String 站点名称 
 */
@Column(name="name",length=255,nullable=true)
public String getName(){
		return this.name;	
}
/**
 * @param url 要设置的站点地址
 */
public void setUrl(String url){
    this.url = url;
}
/**
 * @return String 站点地址 
 */
@Column(name="url",length=255,columnDefinition="text",nullable=true)
public String getUrl(){
		return this.url;	
}
/**
 * @param orderNum 要设置的排序
 */
public void setOrderNum(Integer orderNum){
    this.orderNum = orderNum;
}
/**
 * @return Integer 排序 
 */
@Column(name="order_num",nullable=true)
public Integer getOrderNum(){
		return this.orderNum;	
}
/**
  * @param orderNumStart 要设置的排序开始日期
  */
public void setOrderNumStart(Integer orderNumStart){
    this.orderNumStart = orderNumStart;
}
/**
  * @return Integer 排序开始日期
  */
@Transient
public Integer getOrderNumStart(){
    return this.orderNumStart;
}
/**
  * @param orderNumEnd 要设置的排序结束日期
  */
public void setOrderNumEnd(Integer orderNumEnd){
    this.orderNumEnd = orderNumEnd;
}
/**
  * @return Integer 排序结束日期
  */
@Transient
public Integer getOrderNumEnd(){
    return this.orderNumEnd;
}
/**
 * @param picture 要设置的站点Logo
 */
public void setPicture(CommonFile picture){
    this.picture = picture;
}
/**
 * @param pictureQuery 要设置的站点Logo模糊查询条件
 */
public void setPictureQuery(String pictureQuery){
    this.pictureQuery = pictureQuery;
}
/**
 * @return CommonFile 站点Logo 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="picutre_file_id",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getPicture(){
		return this.picture;	
}
/**
 * @return  String 站点Logo模糊查询条件
 */
@Transient
public String getPictureQuery(){
    return this.pictureQuery;
}
/**
 * @param status 要设置的状态
 */
public void setStatus(UseStatus status){
    this.status = status;
}
/**
 * @return UseStatus 状态 
 */
@Column(name="status",nullable=true,columnDefinition="enum('InUse','UnUse')")
@Enumerated(EnumType.STRING)
public UseStatus getStatus(){
		return this.status;	
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		FriendLink other = null;
		try{
			other = (FriendLink) obj;
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
		return "FriendLink [manageKey=" + manageKey + "]";
	}
	
	@Transient
	public String getPictureKey() {
		if(getPicture()!=null){
			return getPicture().getManageKey();
		}
		return null;
	}
}