package me.huqiao.smallcms.ppll.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import me.huqiao.smallcms.common.entity.enumtype.UseStatus;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * 质量档案公司
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_quality_archive_company")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class QualityArchiveCompany
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
/**法人代表*/
private String lawPerson;
/**注册资金*/
private Integer registerMoney;
	/**注册资金开始，用于查询*/
private Integer registerMoneyStart;
	/**注册资金结束，用于查询*/
private Integer registerMoneyEnd;
/**企业所在地*/
private String address;
/**经营范围*/
private String tradeScope;
/**所属服务中心*/
private String serviceCenter;
/**企业资质初步审核状态*/
private String auditStatus;
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
 * @param lawPerson 要设置的法人代表
 */
public void setLawPerson(String lawPerson){
    this.lawPerson = lawPerson;
}
/**
 * @return String 法人代表 
 */
@Column(name="law_person",length=255,nullable=true)
public String getLawPerson(){
		return this.lawPerson;	
}
/**
 * @param registerMoney 要设置的注册资金
 */
public void setRegisterMoney(Integer registerMoney){
    this.registerMoney = registerMoney;
}
/**
 * @return Integer 注册资金 
 */
@Column(name="register_money",nullable=true)
public Integer getRegisterMoney(){
		return this.registerMoney;	
}
/**
  * @param registerMoneyStart 要设置的注册资金开始日期
  */
public void setRegisterMoneyStart(Integer registerMoneyStart){
    this.registerMoneyStart = registerMoneyStart;
}
/**
  * @return Integer 注册资金开始日期
  */
@Transient
public Integer getRegisterMoneyStart(){
    return this.registerMoneyStart;
}
/**
  * @param registerMoneyEnd 要设置的注册资金结束日期
  */
public void setRegisterMoneyEnd(Integer registerMoneyEnd){
    this.registerMoneyEnd = registerMoneyEnd;
}
/**
  * @return Integer 注册资金结束日期
  */
@Transient
public Integer getRegisterMoneyEnd(){
    return this.registerMoneyEnd;
}
/**
 * @param address 要设置的企业所在地
 */
public void setAddress(String address){
    this.address = address;
}
/**
 * @return String 企业所在地 
 */
@Column(name="address",length=255,nullable=true)
public String getAddress(){
		return this.address;	
}
/**
 * @param tradeScope 要设置的经营范围
 */
public void setTradeScope(String tradeScope){
    this.tradeScope = tradeScope;
}
/**
 * @return String 经营范围 
 */
@Column(name="trade_scope",length=255,columnDefinition="text",nullable=true)
public String getTradeScope(){
		return this.tradeScope;	
}
/**
 * @param serviceCenter 要设置的所属服务中心
 */
public void setServiceCenter(String serviceCenter){
    this.serviceCenter = serviceCenter;
}
/**
 * @return String 所属服务中心 
 */
@Column(name="service_center",length=255,nullable=true)
public String getServiceCenter(){
		return this.serviceCenter;	
}
/**
 * @param auditStatus 要设置的企业资质初步审核状态
 */
public void setAuditStatus(String auditStatus){
    this.auditStatus = auditStatus;
}
/**
 * @return String 企业资质初步审核状态 
 */
@Column(name="audit_status",length=255,nullable=true)
public String getAuditStatus(){
		return this.auditStatus;	
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
		QualityArchiveCompany other = null;
		try{
			other = (QualityArchiveCompany) obj;
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
		return "QualityArchiveCompany [manageKey=" + manageKey + "]";
	}
}