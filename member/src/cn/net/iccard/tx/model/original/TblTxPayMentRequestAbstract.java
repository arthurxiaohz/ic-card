package cn.net.iccard.tx.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.tx.model.TblTxPayMentRequest;
import org.hi.base.organization.model.HiUser;

public abstract class TblTxPayMentRequestAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 商户交易流水号
	 */	
 	protected  String mchtTxTraceNo;

 	 /**
	 * 原始商户交易流水号
	 */	
 	protected  String lastMchtTxTraceNo;

 	 /**
	 * 商户号
	 */	
 	protected  String mchtNo;

 	 /**
	 * 交易金额
	 */	
 	protected  String amount;

 	 /**
	 * 原始交易发生时间
	 */	
 	protected  String lastMchtTxTime;

 	 /**
	 * 交易时间
	 */	
 	protected  String mchtTxTime;

 	 /**
	 * 交易状态
	 */	
 	protected  String txStatus;

 	 /**
	 * 交易类型
	 */	
 	protected  String txTypeId;

 	 /**
	 * 附加信息
	 */	
 	protected  String msgext;

 	 /**
	 * 原始报文
	 */	
 	protected  String mchtRawMessage;

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
    
    public String getMchtTxTraceNo() {
        return this.mchtTxTraceNo;
    }
    
    public void setMchtTxTraceNo(String mchtTxTraceNo) {
    		if((mchtTxTraceNo != null && this.mchtTxTraceNo == null) || 
				this.mchtTxTraceNo != null && (!this.mchtTxTraceNo.equals(mchtTxTraceNo) || mchtTxTraceNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtTxTraceNo", this.mchtTxTraceNo);
        	}
        this.mchtTxTraceNo = mchtTxTraceNo;
    }
    
    public String getLastMchtTxTraceNo() {
        return this.lastMchtTxTraceNo;
    }
    
    public void setLastMchtTxTraceNo(String lastMchtTxTraceNo) {
    		if((lastMchtTxTraceNo != null && this.lastMchtTxTraceNo == null) || 
				this.lastMchtTxTraceNo != null && (!this.lastMchtTxTraceNo.equals(lastMchtTxTraceNo) || lastMchtTxTraceNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastMchtTxTraceNo", this.lastMchtTxTraceNo);
        	}
        this.lastMchtTxTraceNo = lastMchtTxTraceNo;
    }
    
    public String getMchtNo() {
        return this.mchtNo;
    }
    
    public void setMchtNo(String mchtNo) {
    		if((mchtNo != null && this.mchtNo == null) || 
				this.mchtNo != null && (!this.mchtNo.equals(mchtNo) || mchtNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtNo", this.mchtNo);
        	}
        this.mchtNo = mchtNo;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(String amount) {
    		if((amount != null && this.amount == null) || 
				this.amount != null && (!this.amount.equals(amount) || amount == null)){
        		this.setDirty(true);
        		this.oldValues.put("amount", this.amount);
        	}
        this.amount = amount;
    }
    
    public String getLastMchtTxTime() {
        return this.lastMchtTxTime;
    }
    
    public void setLastMchtTxTime(String lastMchtTxTime) {
    		if((lastMchtTxTime != null && this.lastMchtTxTime == null) || 
				this.lastMchtTxTime != null && (!this.lastMchtTxTime.equals(lastMchtTxTime) || lastMchtTxTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastMchtTxTime", this.lastMchtTxTime);
        	}
        this.lastMchtTxTime = lastMchtTxTime;
    }
    
    public String getMchtTxTime() {
        return this.mchtTxTime;
    }
    
    public void setMchtTxTime(String mchtTxTime) {
    		if((mchtTxTime != null && this.mchtTxTime == null) || 
				this.mchtTxTime != null && (!this.mchtTxTime.equals(mchtTxTime) || mchtTxTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtTxTime", this.mchtTxTime);
        	}
        this.mchtTxTime = mchtTxTime;
    }
    
    public String getTxStatus() {
        return this.txStatus;
    }
    
    public void setTxStatus(String txStatus) {
    		if((txStatus != null && this.txStatus == null) || 
				this.txStatus != null && (!this.txStatus.equals(txStatus) || txStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("txStatus", this.txStatus);
        	}
        this.txStatus = txStatus;
    }
    
    public String getTxTypeId() {
        return this.txTypeId;
    }
    
    public void setTxTypeId(String txTypeId) {
    		if((txTypeId != null && this.txTypeId == null) || 
				this.txTypeId != null && (!this.txTypeId.equals(txTypeId) || txTypeId == null)){
        		this.setDirty(true);
        		this.oldValues.put("txTypeId", this.txTypeId);
        	}
        this.txTypeId = txTypeId;
    }
    
    public String getMsgext() {
        return this.msgext;
    }
    
    public void setMsgext(String msgext) {
    		if((msgext != null && this.msgext == null) || 
				this.msgext != null && (!this.msgext.equals(msgext) || msgext == null)){
        		this.setDirty(true);
        		this.oldValues.put("msgext", this.msgext);
        	}
        this.msgext = msgext;
    }
    
    public String getMchtRawMessage() {
        return this.mchtRawMessage;
    }
    
    public void setMchtRawMessage(String mchtRawMessage) {
    		if((mchtRawMessage != null && this.mchtRawMessage == null) || 
				this.mchtRawMessage != null && (!this.mchtRawMessage.equals(mchtRawMessage) || mchtRawMessage == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtRawMessage", this.mchtRawMessage);
        	}
        this.mchtRawMessage = mchtRawMessage;
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
		 if ( !(other instanceof TblTxPayMentRequest) ) return false;
		 TblTxPayMentRequest castOther = ( TblTxPayMentRequest ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblTxPayMentRequest".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("mchtTxTraceNo", this.mchtTxTraceNo)
		.append("lastMchtTxTraceNo", this.lastMchtTxTraceNo)
		.append("mchtNo", this.mchtNo)
		.append("amount", this.amount)
		.append("lastMchtTxTime", this.lastMchtTxTime)
		.append("mchtTxTime", this.mchtTxTime)
		.append("txStatus", this.txStatus)
		.append("txTypeId", this.txTypeId)
		.append("msgext", this.msgext)
		.append("mchtRawMessage", this.mchtRawMessage)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}