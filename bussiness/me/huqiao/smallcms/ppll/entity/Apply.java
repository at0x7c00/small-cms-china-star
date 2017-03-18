package me.huqiao.smallcms.ppll.entity;
import java.util.Date;

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
 * 会员入会申请
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_apply")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Apply
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
/**公司地址*/
private String address;
/**联系人*/
private String contact;
/**联系方式*/
private String tel;
/**注册资金*/
private Integer registMoney;
	/**注册资金开始，用于查询*/
private Integer registMoneyStart;
	/**注册资金结束，用于查询*/
private Integer registMoneyEnd;
/**所属行业*/
private String industry;
/**品牌字号*/
private String bandNum;
/**备注*/
private String remark;

/**状态*/
private UseStatus status;

private Date createTime;


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
 * @param address 要设置的公司地址
 */
public void setAddress(String address){
    this.address = address;
}
/**
 * @return String 公司地址 
 */
@Column(name="address",length=255,nullable=true)
public String getAddress(){
		return this.address;	
}
/**
 * @param contact 要设置的联系人
 */
public void setContact(String contact){
    this.contact = contact;
}
/**
 * @return String 联系人 
 */
@Column(name="contact",length=255,nullable=true)
public String getContact(){
		return this.contact;	
}
/**
 * @param tel 要设置的联系方式
 */
public void setTel(String tel){
    this.tel = tel;
}
/**
 * @return String 联系方式 
 */
@Column(name="tel",length=255,nullable=true)
public String getTel(){
		return this.tel;	
}
/**
 * @param registMoney 要设置的注册资金
 */
public void setRegistMoney(Integer registMoney){
    this.registMoney = registMoney;
}
/**
 * @return Integer 注册资金 
 */
@Column(name="regist_money",nullable=true)
public Integer getRegistMoney(){
		return this.registMoney;	
}
/**
  * @param registMoneyStart 要设置的注册资金开始日期
  */
public void setRegistMoneyStart(Integer registMoneyStart){
    this.registMoneyStart = registMoneyStart;
}
/**
  * @return Integer 注册资金开始日期
  */
@Transient
public Integer getRegistMoneyStart(){
    return this.registMoneyStart;
}
/**
  * @param registMoneyEnd 要设置的注册资金结束日期
  */
public void setRegistMoneyEnd(Integer registMoneyEnd){
    this.registMoneyEnd = registMoneyEnd;
}
/**
  * @return Integer 注册资金结束日期
  */
@Transient
public Integer getRegistMoneyEnd(){
    return this.registMoneyEnd;
}
/**
 * @param industry 要设置的所属行业
 */
public void setIndustry(String industry){
    this.industry = industry;
}
/**
 * @return String 所属行业 
 */
@Column(name="industry",length=255,nullable=true)
public String getIndustry(){
		return this.industry;	
}
/**
 * @param bandNum 要设置的品牌字号
 */
public void setBandNum(String bandNum){
    this.bandNum = bandNum;
}
/**
 * @return String 品牌字号 
 */
@Column(name="band_num",length=255,nullable=true)
public String getBandNum(){
		return this.bandNum;	
}
/**
 * @param remark 要设置的备注
 */
public void setRemark(String remark){
    this.remark = remark;
}
/**
 * @return String 备注 
 */
@Column(name="remark",length=255,nullable=true)
public String getRemark(){
		return this.remark;	
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Apply other = null;
		try{
			other = (Apply) obj;
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
		return "Apply [manageKey=" + manageKey + "]";
	}
	
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}