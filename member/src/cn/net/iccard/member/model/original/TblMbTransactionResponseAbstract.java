package cn.net.iccard.member.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.member.model.TblMbTransactionResponse;
import org.hi.base.organization.model.HiUser;

public abstract class TblMbTransactionResponseAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 通知记录id标识
	 */	
 	protected  String responseId;

 	 /**
	 * 对应的系统订单号
	 */	
 	protected  String ordedId;

 	 /**
	 * 交易系统的机构号
	 */	
 	protected  Integer orgId;

 	 /**
	 * 交易系统的交易流水号
	 */	
 	protected  String orgOrdedId;

 	 /**
	 * 交易金额
	 */	
 	protected  Integer amount;

 	 /**
	 * 报文的原始报文
	 */	
 	protected  String context;

 	 /**
	 * 返回报文标识订单的成功状态
	 */	
 	protected  Integer state;

 	 /**
	 * 发送报文的IP地址
	 */	
 	protected  String sourceIp;

 	 /**
	 * 最后修改时间
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * 最后修改人
	 */	
 	protected  String lastUpdatedBy;

 	 /**
	 * 创建时间
	 */	
 	protected  Timestamp createdDatetime;

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
    
    public String getResponseId() {
        return this.responseId;
    }
    
    public void setResponseId(String responseId) {
    		if((responseId != null && this.responseId == null) || 
				this.responseId != null && (!this.responseId.equals(responseId) || responseId == null)){
        		this.setDirty(true);
        		this.oldValues.put("responseId", this.responseId);
        	}
        this.responseId = responseId;
    }
    
    public String getOrdedId() {
        return this.ordedId;
    }
    
    public void setOrdedId(String ordedId) {
    		if((ordedId != null && this.ordedId == null) || 
				this.ordedId != null && (!this.ordedId.equals(ordedId) || ordedId == null)){
        		this.setDirty(true);
        		this.oldValues.put("ordedId", this.ordedId);
        	}
        this.ordedId = ordedId;
    }
    
    public Integer getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(Integer orgId) {
    		if((orgId != null && this.orgId == null) || 
				this.orgId != null && (!this.orgId.equals(orgId) || orgId == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgId", this.orgId);
        	}
        this.orgId = orgId;
    }
    
    public String getOrgOrdedId() {
        return this.orgOrdedId;
    }
    
    public void setOrgOrdedId(String orgOrdedId) {
    		if((orgOrdedId != null && this.orgOrdedId == null) || 
				this.orgOrdedId != null && (!this.orgOrdedId.equals(orgOrdedId) || orgOrdedId == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgOrdedId", this.orgOrdedId);
        	}
        this.orgOrdedId = orgOrdedId;
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
    
    public String getContext() {
        return this.context;
    }
    
    public void setContext(String context) {
    		if((context != null && this.context == null) || 
				this.context != null && (!this.context.equals(context) || context == null)){
        		this.setDirty(true);
        		this.oldValues.put("context", this.context);
        	}
        this.context = context;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
    		if((state != null && this.state == null) || 
				this.state != null && (!this.state.equals(state) || state == null)){
        		this.setDirty(true);
        		this.oldValues.put("state", this.state);
        	}
        this.state = state;
    }
    
    public String getSourceIp() {
        return this.sourceIp;
    }
    
    public void setSourceIp(String sourceIp) {
    		if((sourceIp != null && this.sourceIp == null) || 
				this.sourceIp != null && (!this.sourceIp.equals(sourceIp) || sourceIp == null)){
        		this.setDirty(true);
        		this.oldValues.put("sourceIp", this.sourceIp);
        	}
        this.sourceIp = sourceIp;
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
    
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(String lastUpdatedBy) {
    		if((lastUpdatedBy != null && this.lastUpdatedBy == null) || 
				this.lastUpdatedBy != null && (!this.lastUpdatedBy.equals(lastUpdatedBy) || lastUpdatedBy == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastUpdatedBy", this.lastUpdatedBy);
        	}
        this.lastUpdatedBy = lastUpdatedBy;
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
		 if ( !(other instanceof TblMbTransactionResponse) ) return false;
		 TblMbTransactionResponse castOther = ( TblMbTransactionResponse ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMbTransactionResponse".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("responseId", this.responseId)
		.append("ordedId", this.ordedId)
		.append("orgId", this.orgId)
		.append("orgOrdedId", this.orgOrdedId)
		.append("amount", this.amount)
		.append("context", this.context)
		.append("state", this.state)
		.append("sourceIp", this.sourceIp)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}