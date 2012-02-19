package org.hi.test.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.common.attachment.model.Attachment;
import org.hi.test.model.JobPosition;
import org.hi.test.model.Nation;
import org.hi.test.model.Experience;
import org.hi.test.model.Friends;
import org.hi.test.model.Staff;
import org.hi.base.organization.model.HiUser;

public abstract class StaffAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 员工编号
	 */	
 	protected  String useNum;

 	 /**
	 * 籍贯
	 */	
 	protected  String nativePlace;

 	 /**
	 * 学历
	 */	
 	protected  Integer degree;

 	 /**
	 * 专业
	 */	
 	protected  String specialty;

 	 /**
	 * 入场时间
	 */	
 	protected  Timestamp jobDate;

 	 /**
	 * 婚姻状态
	 */	
 	protected  Integer marry;

 	 /**
	 * 个人爱好
	 */	
 	protected  String interest;

 	 /**
	 * 工作岗位
	 */	
 	protected  JobPosition jobPosition;

 	 /**
	 * 附件
	 */	
 	protected  Attachment photo_attachment;

 	 /**
	 * 工作状态
	 */	
 	protected  Integer employedStatus;

 	 /**
	 * 民族
	 */	
 	protected  Nation nation;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

	private  List<Experience> experiences;
	private  List<Friends> friendss;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
    		if((id != null && this.id == null) || 
				this.id != null && (!this.id.equals(id) || id == null)){
        		this.setDirty(true);
        		this.oldValues.put("id", this.id);
        	}
        this.id = id;
    }
    
     public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
    		if((version != null && this.version == null) || 
				this.version != null && (!this.version.equals(version) || version == null)){
        		this.setDirty(true);
        		this.oldValues.put("version", this.version);
        	}
        this.version = version;
    }
    
    public String getUseNum() {
        return this.useNum;
    }
    
    public void setUseNum(String useNum) {
    		if((useNum != null && this.useNum == null) || 
				this.useNum != null && (!this.useNum.equals(useNum) || useNum == null)){
        		this.setDirty(true);
        		this.oldValues.put("useNum", this.useNum);
        	}
        this.useNum = useNum;
    }
    
    public String getNativePlace() {
        return this.nativePlace;
    }
    
    public void setNativePlace(String nativePlace) {
    		if((nativePlace != null && this.nativePlace == null) || 
				this.nativePlace != null && (!this.nativePlace.equals(nativePlace) || nativePlace == null)){
        		this.setDirty(true);
        		this.oldValues.put("nativePlace", this.nativePlace);
        	}
        this.nativePlace = nativePlace;
    }
    
    public Integer getDegree() {
        return this.degree;
    }
    
    public void setDegree(Integer degree) {
    		if((degree != null && this.degree == null) || 
				this.degree != null && (!this.degree.equals(degree) || degree == null)){
        		this.setDirty(true);
        		this.oldValues.put("degree", this.degree);
        	}
        this.degree = degree;
    }
    
    public String getSpecialty() {
        return this.specialty;
    }
    
    public void setSpecialty(String specialty) {
    		if((specialty != null && this.specialty == null) || 
				this.specialty != null && (!this.specialty.equals(specialty) || specialty == null)){
        		this.setDirty(true);
        		this.oldValues.put("specialty", this.specialty);
        	}
        this.specialty = specialty;
    }
    
    public Timestamp getJobDate() {
        return this.jobDate;
    }
    
    public void setJobDate(Timestamp jobDate) {
    		if((jobDate != null && this.jobDate == null) || 
				this.jobDate != null && (!this.jobDate.equals(jobDate) || jobDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("jobDate", this.jobDate);
        	}
        this.jobDate = jobDate;
    }
    
    public Integer getMarry() {
        return this.marry;
    }
    
    public void setMarry(Integer marry) {
    		if((marry != null && this.marry == null) || 
				this.marry != null && (!this.marry.equals(marry) || marry == null)){
        		this.setDirty(true);
        		this.oldValues.put("marry", this.marry);
        	}
        this.marry = marry;
    }
    
    public String getInterest() {
        return this.interest;
    }
    
    public void setInterest(String interest) {
    		if((interest != null && this.interest == null) || 
				this.interest != null && (!this.interest.equals(interest) || interest == null)){
        		this.setDirty(true);
        		this.oldValues.put("interest", this.interest);
        	}
        this.interest = interest;
    }
    
    public JobPosition getJobPosition() {
        return this.jobPosition;
    }
    
    public void setJobPosition(JobPosition jobPosition) {
    		if((jobPosition != null && this.jobPosition == null) || 
				this.jobPosition != null && (!this.jobPosition.equals(jobPosition) || jobPosition == null)){
        		this.setDirty(true);
        		this.oldValues.put("jobPosition", this.jobPosition);
        	}
        this.jobPosition = jobPosition;
    }
    
    public Attachment getPhoto_attachment() {
        return this.photo_attachment;
    }
    
    public void setPhoto_attachment(Attachment photo_attachment) {
    		if((photo_attachment != null && this.photo_attachment == null) || 
				this.photo_attachment != null && (!this.photo_attachment.equals(photo_attachment) || photo_attachment == null)){
        		this.setDirty(true);
        		this.oldValues.put("photo_attachment", this.photo_attachment);
        	}
        this.photo_attachment = photo_attachment;
    }
    
    public Integer getEmployedStatus() {
        return this.employedStatus;
    }
    
    public void setEmployedStatus(Integer employedStatus) {
    		if((employedStatus != null && this.employedStatus == null) || 
				this.employedStatus != null && (!this.employedStatus.equals(employedStatus) || employedStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("employedStatus", this.employedStatus);
        	}
        this.employedStatus = employedStatus;
    }
    
    public Nation getNation() {
        return this.nation;
    }
    
    public void setNation(Nation nation) {
    		if((nation != null && this.nation == null) || 
				this.nation != null && (!this.nation.equals(nation) || nation == null)){
        		this.setDirty(true);
        		this.oldValues.put("nation", this.nation);
        	}
        this.nation = nation;
    }
    
    public HiUser getCreator() {
        return this.creator;
    }
    
    public void setCreator(HiUser creator) {
    		if((creator != null && this.creator == null) || 
				this.creator != null && (!this.creator.equals(creator) || creator == null)){
        		this.setDirty(true);
        		this.oldValues.put("creator", this.creator);
        	}
        this.creator = creator;
    }
    

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Experience> getExperiences() {
        return this.experiences;
    }
    public void setFriendss(List<Friends> friendss) {
        this.friendss = friendss;
    }

    public List<Friends> getFriendss() {
        return this.friendss;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Staff) ) return false;
		 Staff castOther = ( Staff ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Staff".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("useNum", this.useNum)
		.append("nativePlace", this.nativePlace)
		.append("specialty", this.specialty)
		.append("interest", this.interest);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}