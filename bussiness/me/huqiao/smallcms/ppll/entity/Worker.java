package me.huqiao.smallcms.ppll.entity;
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
 * 工作人员
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_worker")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Worker
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
/**工号*/
private String workNum;
/**照片*/
private CommonFile photoFile;
	/**照片模糊查询条件*/
private String photoFileQuery;
/**员工姓名*/
private String name;
/**所属区域*/
private String area;
/**职务*/
private String job;
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
 * @param workNum 要设置的工号
 */
public void setWorkNum(String workNum){
    this.workNum = workNum;
}
/**
 * @return String 工号 
 */
@Column(name="work_num",length=255,nullable=true)
public String getWorkNum(){
		return this.workNum;	
}
/**
 * @param photoFile 要设置的照片
 */
public void setPhotoFile(CommonFile photoFile){
    this.photoFile = photoFile;
}
/**
 * @param photoFileQuery 要设置的照片模糊查询条件
 */
public void setPhotoFileQuery(String photoFileQuery){
    this.photoFileQuery = photoFileQuery;
}
/**
 * @return CommonFile 照片 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="photo_file_id",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getPhotoFile(){
		return this.photoFile;	
}
/**
 * @return  String 照片模糊查询条件
 */
@Transient
public String getPhotoFileQuery(){
    return this.photoFileQuery;
}
/**
 * @param name 要设置的员工姓名
 */
public void setName(String name){
    this.name = name;
}
/**
 * @return String 员工姓名 
 */
@Column(name="name",length=255,nullable=true)
public String getName(){
		return this.name;	
}
/**
 * @param area 要设置的所属区域
 */
public void setArea(String area){
    this.area = area;
}
/**
 * @return String 所属区域 
 */
@Column(name="area",length=255,nullable=true)
public String getArea(){
		return this.area;	
}
/**
 * @param job 要设置的职务
 */
public void setJob(String job){
    this.job = job;
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
 * @return String 职务 
 */
@Column(name="job",length=255,nullable=true)
public String getJob(){
		return this.job;	
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Worker other = null;
		try{
			other = (Worker) obj;
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
		return "Worker [manageKey=" + manageKey + "]";
	}
	
	@Transient
	public String getPotoFileKey() {
		if(getPhotoFile()!=null){
			return getPhotoFile().getManageKey();
		}
		return null;
	}
}