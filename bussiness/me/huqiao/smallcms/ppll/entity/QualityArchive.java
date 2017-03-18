package me.huqiao.smallcms.ppll.entity;
import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.sys.entity.User;
import me.huqiao.smallcms.util.StringUtil;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 质量档案
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_quality_archive")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class QualityArchive
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
/**内容*/
private String content;
/**简介视频或图片*/
private CommonFile detailCover;
private CommonFile cover;
/**简介视频或图片模糊查询条件*/
private String detailCoverQuery;
/**产品展示*/
private Set<CommonFile> productDisplay;
/**创建人*/
private User creator;
	/**创建人模糊查询条件*/
private String creatorQuery;
/**荣誉展示*/
private Set<CommonFile> gloryDisplay;
/**创建时间*/
private Date createTime;
	/**创建时间开始，用于查询*/
private Date createTimeStart;
	/**创建时间结束，用于查询*/
private Date createTimeEnd;
/**排序*/
private Integer orderNum;
	/**排序开始，用于查询*/
private Integer orderNumStart;
	/**排序结束，用于查询*/
private Integer orderNumEnd;
/**阅读次数*/
private Date readCount;
	/**阅读次数开始，用于查询*/
private Date readCountStart;
	/**阅读次数结束，用于查询*/
private Date readCountEnd;
/**状态*/
private UseStatus status;

private Date updateTime;

private QualityArchiveCategory category;
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
 * @param detailCover 要设置的简介视频或图片
 */
public void setDetailCover(CommonFile detailCover){
    this.detailCover = detailCover;
}
/**
 * @param detailCoverQuery 要设置的简介视频或图片模糊查询条件
 */
public void setDetailCoverQuery(String detailCoverQuery){
    this.detailCoverQuery = detailCoverQuery;
}
/**
 * @return CommonFile 简介视频或图片 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="detail_cover",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getDetailCover(){
		return this.detailCover;	
}
/**
 * @return  String 简介视频或图片模糊查询条件
 */
@Transient
public String getDetailCoverQuery(){
    return this.detailCoverQuery;
}
/**
 * @param productDisplay 要设置的产品展示
 */
public void setProductDisplay(Set<CommonFile> productDisplay){
    this.productDisplay = productDisplay;
}
/**
 * @return Set<CommonFile> 产品展示 
 */
@ManyToMany(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class)
@JoinTable(name="quality_archive_product_display_filee",joinColumns={@JoinColumn(name="qualityarchive_id")},inverseJoinColumns={@JoinColumn(name="commonfile_id")})
@JsonIgnore
@OrderBy("id asc")
public Set<CommonFile> getProductDisplay(){
		return this.productDisplay;	
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
 * @param gloryDisplay 要设置的荣誉展示
 */
public void setGloryDisplay(Set<CommonFile> gloryDisplay){
    this.gloryDisplay = gloryDisplay;
}
/**
 * @return Set<CommonFile> 荣誉展示 
 */
@ManyToMany(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class)
@JoinTable(name="",joinColumns={@JoinColumn(name="qualityarchive_id")},inverseJoinColumns={@JoinColumn(name="commonfile_id")})
@JsonIgnore
@OrderBy("id asc")
public Set<CommonFile> getGloryDisplay(){
		return this.gloryDisplay;	
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
  * @param createTimeStart 要设置的创建时间开始日期
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
  * @param orderNumStart 要��置的排序开始日期
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
 * @param readCount 要设置的阅读次数
 */
public void setReadCount(Date readCount){
    this.readCount = readCount;
}
/**
 * @return Date 阅读次数 
 */
@Column(name="read_count",nullable=true)
public Date getReadCount(){
		return this.readCount;	
}
/**
  * @param readCountStart 要设置的阅读次数开始日期
  */
public void setReadCountStart(Date readCountStart){
    this.readCountStart = readCountStart;
}
/**
  * @return Date 阅读次数开始日期
  */
@Transient
public Date getReadCountStart(){
    return this.readCountStart;
}
/**
  * @param readCountEnd 要设置的阅读次数结束日期
  */
public void setReadCountEnd(Date readCountEnd){
    this.readCountEnd = readCountEnd;
}
/**
  * @return Date 阅读次数结束日期
  */
@Transient
public Date getReadCountEnd(){
    return this.readCountEnd;
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
		QualityArchive other = null;
		try{
			other = (QualityArchive) obj;
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
		return "QualityArchive [manageKey=" + manageKey + "]";
	}
	
	@ManyToOne(targetEntity=QualityArchiveCategory.class,fetch=FetchType.LAZY)
	@JoinColumn(name="category_id",nullable=true)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	public QualityArchiveCategory getCategory() {
		return category;
	}
	public void setCategory(QualityArchiveCategory category) {
		this.category = category;
	}
	@Column(name="update_time",nullable=true)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
	@JoinColumn(name="cover_id",nullable=true)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	public CommonFile getCover(){
			return this.cover;	
	}
	public void setCover(CommonFile cover) {
		this.cover = cover;
	}
	
	@Transient
	public String getAbstractContent(){
		return delHTMLTag(getContent());
	}
	
	public static String delHTMLTag(String htmlStr){ 
		if(StringUtil.isEmpty(htmlStr)){
			return htmlStr;
		}
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
    }
	
	@Transient
	public String getCoverKey() {
		if(getCover()!=null){
			return getCover().getManageKey();
		}
		return null;
	} 
	@Transient
	public String getDetailCoverKey() {
		if(getDetailCover()!=null){
			return getDetailCover().getManageKey();
		}
		return null;
	} 
}