package org.hi.base.organization.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;

public abstract class HiOrgAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 部门名称
	 */	
 	protected  String orgName;

 	 /**
	 * 部门编号
	 */	
 	protected  String orgNum;

 	 /**
	 * 部门经理
	 */	
 	protected  HiUser manager;

 	 /**
	 * 父部门
	 */	
 	protected  HiOrg parentOrg;

 	 /**
	 * 地址
	 */	
 	protected  String address;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator;

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
    
    public String getOrgNum() {
        return this.orgNum;
    }
    
    public void setOrgNum(String orgNum) {
    		if((orgNum != null && this.orgNum == null) || 
				this.orgNum != null && (!this.orgNum.equals(orgNum) || orgNum == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgNum", this.orgNum);
        	}
        this.orgNum = orgNum;
    }
    
    public HiUser getManager() {
        return this.manager;
    }
    
    public void setManager(HiUser manager) {
    		if((manager != null && this.manager == null) || 
				this.manager != null && (!this.manager.equals(manager) || manager == null)){
        		this.setDirty(true);
        		this.oldValues.put("manager", this.manager);
        	}
        this.manager = manager;
    }
    
    public HiOrg getParentOrg() {
        return this.parentOrg;
    }
    
    public void setParentOrg(HiOrg parentOrg) {
    		if((parentOrg != null && this.parentOrg == null) || 
				this.parentOrg != null && (!this.parentOrg.equals(parentOrg) || parentOrg == null)){
        		this.setDirty(true);
        		this.oldValues.put("parentOrg", this.parentOrg);
        	}
        this.parentOrg = parentOrg;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
    		if((address != null && this.address == null) || 
				this.address != null && (!this.address.equals(address) || address == null)){
        		this.setDirty(true);
        		this.oldValues.put("address", this.address);
        	}
        this.address = address;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
    		if((description != null && this.description == null) || 
				this.description != null && (!this.description.equals(description) || description == null)){
        		this.setDirty(true);
        		this.oldValues.put("description", this.description);
        	}
        this.description = description;
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
		 if ( !(other instanceof HiOrg) ) return false;
		 HiOrg castOther = ( HiOrg ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("HiOrg".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("orgName", this.orgName)
		.append("orgNum", this.orgNum)
		.append("address", this.address)
		.append("description", this.description)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}