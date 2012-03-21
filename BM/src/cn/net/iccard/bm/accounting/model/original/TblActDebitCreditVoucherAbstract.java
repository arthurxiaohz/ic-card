package cn.net.iccard.bm.accounting.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.accounting.model.TblActDebitCreditVoucher;
import cn.net.iccard.bm.accounting.model.ActAccount;
import org.hi.base.organization.model.HiUser;

public abstract class TblActDebitCreditVoucherAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 凭证号
	 */	
 	protected  String voucherNo;

 	 /**
	 * 账户
	 */	
 	protected  ActAccount actAccount;

 	 /**
	 * 金额
	 */	
 	protected  Integer amount;

 	 /**
	 * 借贷方向
	 */	
 	protected  Integer debitOrCredit;

 	 /**
	 * 业务类型
	 */	
 	protected  Integer bizType;

 	 /**
	 * 业务流水
	 */	
 	protected  Integer bizLogId;

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
    
    public String getVoucherNo() {
        return this.voucherNo;
    }
    
    public void setVoucherNo(String voucherNo) {
    		if((voucherNo != null && this.voucherNo == null) || 
				this.voucherNo != null && (!this.voucherNo.equals(voucherNo) || voucherNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("voucherNo", this.voucherNo);
        	}
        this.voucherNo = voucherNo;
    }
    
    public ActAccount getActAccount() {
        return this.actAccount;
    }
    
    public void setActAccount(ActAccount actAccount) {
    		if((actAccount != null && this.actAccount == null) || 
				this.actAccount != null && (!this.actAccount.equals(actAccount) || actAccount == null)){
        		this.setDirty(true);
        		this.oldValues.put("actAccount", this.actAccount);
        	}
        this.actAccount = actAccount;
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
    
    public Integer getDebitOrCredit() {
        return this.debitOrCredit;
    }
    
    public void setDebitOrCredit(Integer debitOrCredit) {
    		if((debitOrCredit != null && this.debitOrCredit == null) || 
				this.debitOrCredit != null && (!this.debitOrCredit.equals(debitOrCredit) || debitOrCredit == null)){
        		this.setDirty(true);
        		this.oldValues.put("debitOrCredit", this.debitOrCredit);
        	}
        this.debitOrCredit = debitOrCredit;
    }
    
    public Integer getBizType() {
        return this.bizType;
    }
    
    public void setBizType(Integer bizType) {
    		if((bizType != null && this.bizType == null) || 
				this.bizType != null && (!this.bizType.equals(bizType) || bizType == null)){
        		this.setDirty(true);
        		this.oldValues.put("bizType", this.bizType);
        	}
        this.bizType = bizType;
    }
    
    public Integer getBizLogId() {
        return this.bizLogId;
    }
    
    public void setBizLogId(Integer bizLogId) {
    		if((bizLogId != null && this.bizLogId == null) || 
				this.bizLogId != null && (!this.bizLogId.equals(bizLogId) || bizLogId == null)){
        		this.setDirty(true);
        		this.oldValues.put("bizLogId", this.bizLogId);
        	}
        this.bizLogId = bizLogId;
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
		 if ( !(other instanceof TblActDebitCreditVoucher) ) return false;
		 TblActDebitCreditVoucher castOther = ( TblActDebitCreditVoucher ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblActDebitCreditVoucher".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("voucherNo", this.voucherNo)
		.append("amount", this.amount)
		.append("bizLogId", this.bizLogId)
		.append("remark", this.remark)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}