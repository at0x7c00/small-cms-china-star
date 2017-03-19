package me.huqiao.smallcms.chinastar.entity;
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
import me.huqiao.smallcms.sys.entity.User;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 企业风采
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_corporate_style")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class CorporateStyle
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
/**标题*/
private String title;
/**企业名称*/
private String corporateName;
/**内容*/
private String content;
/**视频文件*/
private CommonFile video;
	/**视频文件模糊查询条件*/
private String videoQuery;
/**创建人*/
private User creator;
	/**创建人模糊查询条件*/
private String creatorQuery;
/**创建时间*/
private Date createTime;
	/**创建时间开始，用于查询*/
private Date createTimeStart;
	/**创建时间结束，用于查询*/
private Date createTimeEnd;
/**更新时间*/
private Date updateTime;
	/**更新时间开始，用于查询*/
private Date updateTimeStart;
	/**更新时间结束，用于查询*/
private Date updateTimeEnd;
/**排序*/
private Integer orderNum;
	/**排序开始，用于查询*/
private Integer orderNumStart;
	/**排序结束，用于查询*/
private Integer orderNumEnd;
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
 * @param title 要设置的标题
 */
public void setTitle(String title){
    this.title = title;
}
/**
 * @return String 标题 
 */
@Column(name="title",length=255,nullable=true)
public String getTitle(){
		return this.title;	
}
/**
 * @param corporateName 要设置的企业名称
 */
public void setCorporateName(String corporateName){
    this.corporateName = corporateName;
}
/**
 * @return String 企业名称 
 */
@Column(name="corporate_name",length=255,nullable=true)
public String getCorporateName(){
		return this.corporateName;	
}
/**
 * @param content 要设置的内容
 */
public void setContent(String content){
    this.content = content;
}
/**
 * @return String 内容 
 */
@Column(name="content",length=255,columnDefinition="text",nullable=true)
public String getContent(){
		return this.content;	
}
/**
 * @param video 要设置的视频文件
 */
public void setVideo(CommonFile video){
    this.video = video;
}
/**
 * @param videoQuery 要设置的视频文件模糊查询条件
 */
public void setVideoQuery(String videoQuery){
    this.videoQuery = videoQuery;
}
/**
 * @return CommonFile 视频文件 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="video_id",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getVideo(){
		return this.video;	
}
/**
 * @return  String 视频文件模糊查询条件
 */
@Transient
public String getVideoQuery(){
    return this.videoQuery;
}
/**
 * @param creator 要设置的创建人
 */
public void setCreator(User creator){
    this.creator = creator;
}
/**
 * @param creatorQuery 要设置的创建人模糊查询条件
 */
public void setCreatorQuery(String creatorQuery){
    this.creatorQuery = creatorQuery;
}
/**
 * @return User 创建人 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.sys.entity.User.class,fetch=FetchType.LAZY)
@JoinColumn(name="creator_id",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public User getCreator(){
		return this.creator;	
}
/**
 * @return  String 创建人模糊查询条件
 */
@Transient
public String getCreatorQuery(){
    return this.creatorQuery;
}
/**
 * @param createTime 要设置的创建时间
 */
public void setCreateTime(Date createTime){
    this.createTime = createTime;
}
/**
 * @return Date 创建时间 
 */
@Column(name="create_time",nullable=true)
public Date getCreateTime(){
		return this.createTime;	
}
/**
  * @param createTimeStart 要设���的创建时间开始日期
  */
public void setCreateTimeStart(Date createTimeStart){
    this.createTimeStart = createTimeStart;
}
/**
  * @return Date 创建时间开始日期
  */
@Transient
public Date getCreateTimeStart(){
    return this.createTimeStart;
}
/**
  * @param createTimeEnd 要设置的创建时间结束日期
  */
public void setCreateTimeEnd(Date createTimeEnd){
    this.createTimeEnd = createTimeEnd;
}
/**
  * @return Date 创建时间结束日期
  */
@Transient
public Date getCreateTimeEnd(){
    return this.createTimeEnd;
}
/**
 * @param updateTime 要设置的更新时间
 */
public void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
}
/**
 * @return Date 更新时间 
 */
@Column(name="updateTime",nullable=true)
public Date getUpdateTime(){
		return this.updateTime;	
}
/**
  * @param updateTimeStart 要设置的更新时间开始日期
  */
public void setUpdateTimeStart(Date updateTimeStart){
    this.updateTimeStart = updateTimeStart;
}
/**
  * @return Date 更新时间开始日期
  */
@Transient
public Date getUpdateTimeStart(){
    return this.updateTimeStart;
}
/**
  * @param updateTimeEnd 要设置的更新时间结束日期
  */
public void setUpdateTimeEnd(Date updateTimeEnd){
    this.updateTimeEnd = updateTimeEnd;
}
/**
  * @return Date 更新时间结束日期
  */
@Transient
public Date getUpdateTimeEnd(){
    return this.updateTimeEnd;
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
		CorporateStyle other = null;
		try{
			other = (CorporateStyle) obj;
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
		return "CorporateStyle [manageKey=" + manageKey + "]";
	}
}