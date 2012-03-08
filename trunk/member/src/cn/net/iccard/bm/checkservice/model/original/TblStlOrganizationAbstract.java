package cn.net.iccard.bm.checkservice.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.checkservice.model.TblStlOrganization;
import org.hi.base.organization.model.HiUser;

public abstract class TblStlOrganizationAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 机构代码
	 */	
 	protected  String orgId;

 	 /**
	 * 机构类型
	 */	
 	protected  String orgType;

 	 /**
	 * 机构名称
	 */	
 	protected  String orgName;

 	 /**
	 * 可用状态
	 */	
 	protected  Integer status;

 	 /**
	 * 场次数
	 */	
 	protected  Integer fieldTimes;

 	 /**
	 * 描述
	 */	
 	protected  String extDesc;

 	 /**
	 * 创建时间
	 */	
 	protected  Timestamp createdDatetime;

 	 /**
	 * 最后修改时间
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * 最后修改人
	 */	
 	protected  Integer lastUpdatedBy;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

 	 /**
	 * 删除标识
	 */	
 	protected  Integer deleted = 0;


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
    
    public String getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(String orgId) {
    		if((orgId != null && this.orgId == null) || 
				this.orgId != null && (!this.orgId.equals(orgId) || orgId == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgId", this.orgId);
        	}
        this.orgId = orgId;
    }
    
    public String getOrgType() {
        return this.orgType;
    }
    
    public void setOrgType(String orgType) {
    		if((orgType != null && this.orgType == null) || 
				this.orgType != null && (!this.orgType.equals(orgType) || orgType == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgType", this.orgType);
        	}
        this.orgType = orgType;
    }
    
    public String getOrgName() {
        return this.orgName;
    }
    
    public void setOrgName(String orgName) {
    		if((orgName != null && this.orgName == null) || 
				this.orgName != null && (!this.orgName.equals(orgName) || orgName == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgName", this.orgName);
        	}
        this.orgName = orgName;
    }
    
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
    		if((status != null && this.status == null) || 
				this.status != null && (!this.status.equals(status) || status == null)){
        		this.setDirty(true);
        		this.oldValues.put("status", this.status);
        	}
        this.status = status;
    }
    
    public Integer getFieldTimes() {
        return this.fieldTimes;
    }
    
    public void setFieldTimes(Integer fieldTimes) {
    		if((fieldTimes != null && this.fieldTimes == null) || 
				this.fieldTimes != null && (!this.fieldTimes.equals(fieldTimes) || fieldTimes == null)){
        		this.setDirty(true);
        		this.oldValues.put("fieldTimes", this.fieldTimes);
        	}
        this.fieldTimes = fieldTimes;
    }
    
    public String getExtDesc() {
        return this.extDesc;
    }
    
    public void setExtDesc(String extDesc) {
    		if((extDesc != null && this.extDesc == null) || 
				this.extDesc != null && (!this.extDesc.equals(extDesc) || extDesc == null)){
        		this.setDirty(true);
        		this.oldValues.put("extDesc", this.extDesc);
        	}
        this.extDesc = extDesc;
    }
    
    public Timestamp getCreatedDatetime() {
        return this.createdDatetime;
    }
    
    public void setCreatedDatetime(Timestamp createdDatetime) {
    		if((createdDatetime != null && this.createdDatetime == null) || 
				this.createdDatetime != null && (!this.createdDatetime.equals(createdDatetime) || createdDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("createdDatetime", this.createdDatetime);
        	}
        this.createdDatetime = createdDatetime;
    }
    
    public Timestamp getLastUpdatedDatetime() {
        return this.lastUpdatedDatetime;
    }
    
    public void setLastUpdatedDatetime(Timestamp lastUpdatedDatetime) {
    		if((lastUpdatedDatetime != null && this.lastUpdatedDatetime == null) || 
				this.lastUpdatedDatetime != null && (!this.lastUpdatedDatetime.equals(lastUpdatedDatetime) || lastUpdatedDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastUpdatedDatetime", this.lastUpdatedDatetime);
        	}
        this.lastUpdatedDatetime = lastUpdatedDatetime;
    }
    
    public Integer getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(Integer lastUpdatedBy) {
    		if((lastUpdatedBy != null && this.lastUpdatedBy == null) || 
				this.lastUpdatedBy != null && (!this.lastUpdatedBy.equals(lastUpdatedBy) || lastUpdatedBy == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastUpdatedBy", this.lastUpdatedBy);
        	}
        this.lastUpdatedBy = lastUpdatedBy;
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
    
    public Integer getDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(Integer deleted) {
    		if((deleted != null && this.deleted == null) || 
				this.deleted != null && (!this.deleted.equals(deleted) || deleted == null)){
        		this.setDirty(true);
        		this.oldValues.put("deleted", this.deleted);
        	}
        this.deleted = deleted;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblStlOrganization) ) return false;
		 TblStlOrganization castOther = ( TblStlOrganization ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblStlOrganization".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("orgId", this.orgId)
		.append("orgType", this.orgType)
		.append("orgName", this.orgName)
		.append("fieldTimes", this.fieldTimes)
		.append("extDesc", this.extDesc)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}