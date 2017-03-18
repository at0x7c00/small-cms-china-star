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
 * 会员单位
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_member_organization")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class MemberOrganization
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
/**合作期限*/
private Date corporateFrom;
	/**合作期限开始，用于查询*/
private Date corporateFromStart;
	/**合作期限结束，用于查询*/
private Date corporateFromEnd;
/**合作期限*/
private Date corporateTo;
	/**合作期限开始，用于查询*/
private Date corporateToStart;
	/**合作期限结束，用于查询*/
private Date corporateToEnd;
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
 * @param corporateFrom 要设置的合作期限
 */
public void setCorporateFrom(Date corporateFrom){
    this.corporateFrom = corporateFrom;
}
/**
 * @return Date 合作期限 
 */
@Column(name="corporate_from",nullable=true)
public Date getCorporateFrom(){
		return this.corporateFrom;	
}
/**
  * @param corporateFromStart 要设置的合作期限开始日期
  */
public void setCorporateFromStart(Date corporateFromStart){
    this.corporateFromStart = corporateFromStart;
}
/**
  * @return Date 合作期限开始日期
  */
@Transient
public Date getCorporateFromStart(){
    return this.corporateFromStart;
}
/**
  * @param corporateFromEnd 要设置的合作期限结束日期
  */
public void setCorporateFromEnd(Date corporateFromEnd){
    this.corporateFromEnd = corporateFromEnd;
}
/**
  * @return Date 合作期限结束日期
  */
@Transient
public Date getCorporateFromEnd(){
    return this.corporateFromEnd;
}
/**
 * @param corporateTo 要设置的合作期限
 */
public void setCorporateTo(Date corporateTo){
    this.corporateTo = corporateTo;
}
/**
 * @return Date 合作期限 
 */
@Column(name="corporate_to",nullable=true)
public Date getCorporateTo(){
		return this.corporateTo;	
}
/**
  * @param corporateToStart 要设置的合作期限开始日期
  */
public void setCorporateToStart(Date corporateToStart){
    this.corporateToStart = corporateToStart;
}
/**
  * @return Date 合作期限开始日期
  */
@Transient
public Date getCorporateToStart(){
    return this.corporateToStart;
}
/**
  * @param corporateToEnd 要设置的合作期限结束日期
  */
public void setCorporateToEnd(Date corporateToEnd){
    this.corporateToEnd = corporateToEnd;
}
/**
  * @return Date 合作期限结束日期
  */
@Transient
public Date getCorporateToEnd(){
    return this.corporateToEnd;
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
		MemberOrganization other = null;
		try{
			other = (MemberOrganization) obj;
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
		return "MemberOrganization [manageKey=" + manageKey + "]";
	}
	
	@Transient
	public String getCertFileKey() {
		if(getCertFile()!=null){
			return getCertFile().getManageKey();
		}
		return null;
	}
}