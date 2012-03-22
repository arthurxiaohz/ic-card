package cn.net.iccard.bm.accounting.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.accounting.model.ActAccount;
import org.hi.base.organization.model.HiUser;

public abstract class ActAccountAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 账号
	 */	
 	protected  String accountNo;

 	 /**
	 * 账户分类
	 */	
 	protected  Integer accountCatalog;

 	 /**
	 * 开户方类型
	 */	
 	protected  Integer accountPartyType;

 	 /**
	 * 开户方
	 */	
 	protected  String accountParty;

 	 /**
	 * 开户名称
	 */	
 	protected  String accountName;

 	 /**
	 * 状态
	 */	
 	protected  Integer status;

 	 /**
	 * 备注
	 */	
 	protected  String remark;

 	 /**
	 * 创建时间
	 */	
 	protected  Timestamp createdDateTime = new Timestamp(System.currentTimeMillis());

 	 /**
	 * 最后修改时间
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * 最后修改人
	 */	
 	protected  HiUser lastUpdatedBy;

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
    
    public String getAccountNo() {
        return this.accountNo;
    }
    
    public void setAccountNo(String accountNo) {
    		if((accountNo != null && this.accountNo == null) || 
				this.accountNo != null && (!this.accountNo.equals(accountNo) || accountNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountNo", this.accountNo);
        	}
        this.accountNo = accountNo;
    }
    
    public Integer getAccountCatalog() {
        return this.accountCatalog;
    }
    
    public void setAccountCatalog(Integer accountCatalog) {
    		if((accountCatalog != null && this.accountCatalog == null) || 
				this.accountCatalog != null && (!this.accountCatalog.equals(accountCatalog) || accountCatalog == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountCatalog", this.accountCatalog);
        	}
        this.accountCatalog = accountCatalog;
    }
    
    public Integer getAccountPartyType() {
        return this.accountPartyType;
    }
    
    public void setAccountPartyType(Integer accountPartyType) {
    		if((accountPartyType != null && this.accountPartyType == null) || 
				this.accountPartyType != null && (!this.accountPartyType.equals(accountPartyType) || accountPartyType == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountPartyType", this.accountPartyType);
        	}
        this.accountPartyType = accountPartyType;
    }
    
    public String getAccountParty() {
        return this.accountParty;
    }
    
    public void setAccountParty(String accountParty) {
    		if((accountParty != null && this.accountParty == null) || 
				this.accountParty != null && (!this.accountParty.equals(accountParty) || accountParty == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountParty", this.accountParty);
        	}
        this.accountParty = accountParty;
    }
    
    public String getAccountName() {
        return this.accountName;
    }
    
    public void setAccountName(String accountName) {
    		if((accountName != null && this.accountName == null) || 
				this.accountName != null && (!this.accountName.equals(accountName) || accountName == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountName", this.accountName);
        	}
        this.accountName = accountName;
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
    
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
    		if((remark != null && this.remark == null) || 
				this.remark != null && (!this.remark.equals(remark) || remark == null)){
        		this.setDirty(true);
        		this.oldValues.put("remark", this.remark);
        	}
        this.remark = remark;
    }
    
    public Timestamp getCreatedDateTime() {
        return this.createdDateTime;
    }
    
    public void setCreatedDateTime(Timestamp createdDateTime) {
    		if((createdDateTime != null && this.createdDateTime == null) || 
				this.createdDateTime != null && (!this.createdDateTime.equals(createdDateTime) || createdDateTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("createdDateTime", this.createdDateTime);
        	}
        this.createdDateTime = createdDateTime;
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
    
    public HiUser getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(HiUser lastUpdatedBy) {
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
		 if ( !(other instanceof ActAccount) ) return false;
		 ActAccount castOther = ( ActAccount ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("ActAccount".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("accountNo", this.accountNo)
		.append("accountParty", this.accountParty)
		.append("accountName", this.accountName)
		.append("remark", this.remark)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}