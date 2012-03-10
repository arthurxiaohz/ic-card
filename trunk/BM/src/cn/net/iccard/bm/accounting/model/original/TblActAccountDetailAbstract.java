package cn.net.iccard.bm.accounting.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.organization.model.HiUser;
import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.model.TblActAccountDetail;

public abstract class TblActAccountDetailAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 账户
	 */	
 	protected  ActAccount actAccount;

 	 /**
	 * 凭证类型
	 */	
 	protected  Integer voucherType;

 	 /**
	 * 凭证号
	 */	
 	protected  String voucherNo;

 	 /**
	 * 金额
	 */	
 	protected  Integer amount;

 	 /**
	 * 借贷方向
	 */	
 	protected  Integer debitOrCredit;

 	 /**
	 * 余额
	 */	
 	protected  Integer balance;

 	 /**
	 * 备注
	 */	
 	protected  String remark;

 	 /**
	 * 截止日期
	 */	
 	protected  String expiredDate;

 	 /**
	 * 结算状态
	 */	
 	protected  Integer settleStatus;

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
    
    public Integer getVoucherType() {
        return this.voucherType;
    }
    
    public void setVoucherType(Integer voucherType) {
    		if((voucherType != null && this.voucherType == null) || 
				this.voucherType != null && (!this.voucherType.equals(voucherType) || voucherType == null)){
        		this.setDirty(true);
        		this.oldValues.put("voucherType", this.voucherType);
        	}
        this.voucherType = voucherType;
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
    
    public Integer getBalance() {
        return this.balance;
    }
    
    public void setBalance(Integer balance) {
    		if((balance != null && this.balance == null) || 
				this.balance != null && (!this.balance.equals(balance) || balance == null)){
        		this.setDirty(true);
        		this.oldValues.put("balance", this.balance);
        	}
        this.balance = balance;
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
    
    public String getExpiredDate() {
        return this.expiredDate;
    }
    
    public void setExpiredDate(String expiredDate) {
    		if((expiredDate != null && this.expiredDate == null) || 
				this.expiredDate != null && (!this.expiredDate.equals(expiredDate) || expiredDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("expiredDate", this.expiredDate);
        	}
        this.expiredDate = expiredDate;
    }
    
    public Integer getSettleStatus() {
        return this.settleStatus;
    }
    
    public void setSettleStatus(Integer settleStatus) {
    		if((settleStatus != null && this.settleStatus == null) || 
				this.settleStatus != null && (!this.settleStatus.equals(settleStatus) || settleStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleStatus", this.settleStatus);
        	}
        this.settleStatus = settleStatus;
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
		 if ( !(other instanceof TblActAccountDetail) ) return false;
		 TblActAccountDetail castOther = ( TblActAccountDetail ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblActAccountDetail".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("voucherNo", this.voucherNo)
		.append("amount", this.amount)
		.append("balance", this.balance)
		.append("remark", this.remark)
		.append("expiredDate", this.expiredDate)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}