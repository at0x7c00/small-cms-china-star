package me.huqiao.smallcms.ppll.entity;
import java.util.Date;

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
 * 授权机构
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_auth_org")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class AuthOrg
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
/**公司名称*/
private String name;
/**联系电话*/
private String tel;
/**公司地址*/
private String address;
/**合作开始时间*/
private Date coroprateFrom;
	/**合作开始时间开始，用于查询*/
private Date coroprateFromStart;
	/**合作开始时间结束，用于查询*/
private Date coroprateFromEnd;
/**合作结束时间*/
private Date coroprateTo;
	/**合作结束时间开始，用于查询*/
private Date coroprateToStart;
	/**合作结束时间结束，用于查询*/
private Date coroprateToEnd;
/**证书*/
private CommonFile certFile;
	/**证书模糊查询条件*/
private String certFileQuery;
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
 * @param name 要设置的公司名称
 */
public void setName(String name){
    this.name = name;
}
/**
 * @return String 公司名称 
 */
@Column(name="name",length=255,nullable=true)
public String getName(){
		return this.name;	
}
/**
 * @param tel 要设置的联系电话
 */
public void setTel(String tel){
    this.tel = tel;
}
/**
 * @return String 联系电话 
 */
@Column(name="tel",length=255,nullable=true)
public String getTel(){
		return this.tel;	
}
/**
 * @param address 要设置的公司地址
 */
public void setAddress(String address){
    this.address = address;
}
/**
 * @return String 公司地址 
 */
@Column(name="address",length=255,columnDefinition="text",nullable=true)
public String getAddress(){
		return this.address;	
}
/**
 * @param coroprateFrom 要设置的合作开始时间
 */
public void setCoroprateFrom(Date coroprateFrom){
    this.coroprateFrom = coroprateFrom;
}
/**
 * @return Date 合作开始时间 
 */
@Column(name="coroprate_from",nullable=true)
public Date getCoroprateFrom(){
		return this.coroprateFrom;	
}
/**
  * @param coroprateFromStart 要设置的合作开始时间开始日期
  */
public void setCoroprateFromStart(Date coroprateFromStart){
    this.coroprateFromStart = coroprateFromStart;
}
/**
  * @return Date 合作开始时间开始日期
  */
@Transient
public Date getCoroprateFromStart(){
    return this.coroprateFromStart;
}
/**
  * @param coroprateFromEnd 要设置的合作开始时间结束日期
  */
public void setCoroprateFromEnd(Date coroprateFromEnd){
    this.coroprateFromEnd = coroprateFromEnd;
}
/**
  * @return Date 合作开始时间结束日期
  */
@Transient
public Date getCoroprateFromEnd(){
    return this.coroprateFromEnd;
}
/**
 * @param coroprateTo 要设置的合作结束时间
 */
public void setCoroprateTo(Date coroprateTo){
    this.coroprateTo = coroprateTo;
}
/**
 * @return Date 合作结束时间 
 */
@Column(name="coroprate_to",nullable=true)
public Date getCoroprateTo(){
		return this.coroprateTo;	
}
/**
  * @param coroprateToStart 要设置的合作结束时间开始日期
  */
public void setCoroprateToStart(Date coroprateToStart){
    this.coroprateToStart = coroprateToStart;
}
/**
  * @return Date 合作结束时间开始日期
  */
@Transient
public Date getCoroprateToStart(){
    return this.coroprateToStart;
}
/**
  * @param coroprateToEnd 要设置的合作结束时间结束日期
  */
public void setCoroprateToEnd(Date coroprateToEnd){
    this.coroprateToEnd = coroprateToEnd;
}
/**
  * @return Date 合作结束时间结束日期
  */
@Transient
public Date getCoroprateToEnd(){
    return this.coroprateToEnd;
}
/**
 * @param certFile 要设置的证书
 */
public void setCertFile(CommonFile certFile){
    this.certFile = certFile;
}
/**
 * @param certFileQuery 要设置的证书模糊查询条件
 */
public void setCertFileQuery(String certFileQuery){
    this.certFileQuery = certFileQuery;
}
/**
 * @return CommonFile 证书 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="cert_file_id",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getCertFile(){
		return this.certFile;	
}

/**状态*/
private UseStatus status;


/**
 * @return UseStatus 状态 
 */
@Column(name="status",nullable=true,columnDefinition="enum('InUse','UnUse')")
@Enumerated(EnumType.STRING)
public UseStatus getStatus(){
		return this.status;	
}

/**
 * @param status 要设置的状态
 */
public void setStatus(UseStatus status){
    this.status = status;
}

/**
 * @return  String 证书模糊查询条件
 */
@Transient
public String getCertFileQuery(){
    return this.certFileQuery;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		AuthOrg other = null;
		try{
			other = (AuthOrg) obj;
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
		return "AuthOrg [manageKey=" + manageKey + "]";
	}
	
	@Transient
	public String getCertFileKey(){
		if(getCertFile()!=null){
			return getCertFile().getManageKey();
		}
		return null;
	}
}