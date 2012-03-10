package cn.net.iccard.bm.checkservice.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.checkservice.model.TblStlErrorDetail;
import org.hi.base.organization.model.HiUser;

public abstract class TblStlErrorDetailAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 平台交易流水号
	 */	
 	protected  String plTxTraceNo;

 	 /**
	 * 订单金额
	 */	
 	protected  Integer amount;

 	 /**
	 * 订单创建时间
	 */	
 	protected  Timestamp orderCreateDatetime;

 	 /**
	 * 机构订单号
	 */	
 	protected  String orgOrderId;

 	 /**
	 * 连接id
	 */	
 	protected  Integer connectionId;

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
	 * 差错类型
	 */	
 	protected  Integer discrepancyType;

 	 /**
	 * 描述
	 */	
 	protected  String description;

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
    
    public String getPlTxTraceNo() {
        return this.plTxTraceNo;
    }
    
    public void setPlTxTraceNo(String plTxTraceNo) {
    		if((plTxTraceNo != null && this.plTxTraceNo == null) || 
				this.plTxTraceNo != null && (!this.plTxTraceNo.equals(plTxTraceNo) || plTxTraceNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("plTxTraceNo", this.plTxTraceNo);
        	}
        this.plTxTraceNo = plTxTraceNo;
    }
    
    public Integer getAmount() {
        return this.amount;
    }
    
    public void setAmount(Integer amount) {
    		if((amount != null && this.amount == null) || 
				this.amount != null && (!this.amount.equals(amount) || amount == null)){
        		this.setDirty(true);
        		this.oldValues.put("amount", this.amount);
        	}
        this.amount = amount;
    }
    
    public Timestamp getOrderCreateDatetime() {
        return this.orderCreateDatetime;
    }
    
    public void setOrderCreateDatetime(Timestamp orderCreateDatetime) {
    		if((orderCreateDatetime != null && this.orderCreateDatetime == null) || 
				this.orderCreateDatetime != null && (!this.orderCreateDatetime.equals(orderCreateDatetime) || orderCreateDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("orderCreateDatetime", this.orderCreateDatetime);
        	}
        this.orderCreateDatetime = orderCreateDatetime;
    }
    
    public String getOrgOrderId() {
        return this.orgOrderId;
    }
    
    public void setOrgOrderId(String orgOrderId) {
    		if((orgOrderId != null && this.orgOrderId == null) || 
				this.orgOrderId != null && (!this.orgOrderId.equals(orgOrderId) || orgOrderId == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgOrderId", this.orgOrderId);
        	}
        this.orgOrderId = orgOrderId;
    }
    
    public Integer getConnectionId() {
        return this.connectionId;
    }
    
    public void setConnectionId(Integer connectionId) {
    		if((connectionId != null && this.connectionId == null) || 
				this.connectionId != null && (!this.connectionId.equals(connectionId) || connectionId == null)){
        		this.setDirty(true);
        		this.oldValues.put("connectionId", this.connectionId);
        	}
        this.connectionId = connectionId;
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
    
    public Integer getDiscrepancyType() {
        return this.discrepancyType;
    }
    
    public void setDiscrepancyType(Integer discrepancyType) {
    		if((discrepancyType != null && this.discrepancyType == null) || 
				this.discrepancyType != null && (!this.discrepancyType.equals(discrepancyType) || discrepancyType == null)){
        		this.setDirty(true);
        		this.oldValues.put("discrepancyType", this.discrepancyType);
        	}
        this.discrepancyType = discrepancyType;
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
		 if ( !(other instanceof TblStlErrorDetail) ) return false;
		 TblStlErrorDetail castOther = ( TblStlErrorDetail ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblStlErrorDetail".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("plTxTraceNo", this.plTxTraceNo)
		.append("amount", this.amount)
		.append("orgOrderId", this.orgOrderId)
		.append("connectionId", this.connectionId)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("description", this.description)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}