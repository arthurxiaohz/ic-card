package cn.net.iccard.member.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.member.model.TblMbTransactionRequest;
import org.hi.base.organization.model.HiUser;

public abstract class TblMbTransactionRequestAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 交易代码
	 */	
 	protected  String trancode;

 	 /**
	 * 商户号
	 */	
 	protected  String mchtNo;

 	 /**
	 * 交易金额
	 */	
 	protected  Integer amount;

 	 /**
	 * 交易时间
	 */	
 	protected  String trxTime;

 	 /**
	 * 交易状态
	 */	
 	protected  String txStatus;

 	 /**
	 * 附加信息
	 */	
 	protected  String msgext;

 	 /**
	 * 创建时间
	 */	
 	protected  Timestamp createdDatetime = new Timestamp(System.currentTimeMillis());

 	 /**
	 * 最后修改时间
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * 最后修改人
	 */	
 	protected  Integer lastUpdatedBy;

 	 /**
	 * 持卡人卡号
	 */	
 	protected  String pan;

 	 /**
	 * 持卡人个人信息
	 */	
 	protected  String chinfo;

 	 /**
	 * 平台流水号
	 */	
 	protected  String plTxTraceNo;

 	 /**
	 * 币种
	 */	
 	protected  String currencyType;

 	 /**
	 * 账户类型
	 */	
 	protected  String accountType;

 	 /**
	 * 账户号码
	 */	
 	protected  String accountNo;

 	 /**
	 * 交易完成时间
	 */	
 	protected  String plTxTime;

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
    
    public String getTrancode() {
        return this.trancode;
    }
    
    public void setTrancode(String trancode) {
    		if((trancode != null && this.trancode == null) || 
				this.trancode != null && (!this.trancode.equals(trancode) || trancode == null)){
        		this.setDirty(true);
        		this.oldValues.put("trancode", this.trancode);
        	}
        this.trancode = trancode;
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
    
    public String getTrxTime() {
        return this.trxTime;
    }
    
    public void setTrxTime(String trxTime) {
    		if((trxTime != null && this.trxTime == null) || 
				this.trxTime != null && (!this.trxTime.equals(trxTime) || trxTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("trxTime", this.trxTime);
        	}
        this.trxTime = trxTime;
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
    
    public String getPan() {
        return this.pan;
    }
    
    public void setPan(String pan) {
    		if((pan != null && this.pan == null) || 
				this.pan != null && (!this.pan.equals(pan) || pan == null)){
        		this.setDirty(true);
        		this.oldValues.put("pan", this.pan);
        	}
        this.pan = pan;
    }
    
    public String getChinfo() {
        return this.chinfo;
    }
    
    public void setChinfo(String chinfo) {
    		if((chinfo != null && this.chinfo == null) || 
				this.chinfo != null && (!this.chinfo.equals(chinfo) || chinfo == null)){
        		this.setDirty(true);
        		this.oldValues.put("chinfo", this.chinfo);
        	}
        this.chinfo = chinfo;
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
    
    public String getCurrencyType() {
        return this.currencyType;
    }
    
    public void setCurrencyType(String currencyType) {
    		if((currencyType != null && this.currencyType == null) || 
				this.currencyType != null && (!this.currencyType.equals(currencyType) || currencyType == null)){
        		this.setDirty(true);
        		this.oldValues.put("currencyType", this.currencyType);
        	}
        this.currencyType = currencyType;
    }
    
    public String getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(String accountType) {
    		if((accountType != null && this.accountType == null) || 
				this.accountType != null && (!this.accountType.equals(accountType) || accountType == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountType", this.accountType);
        	}
        this.accountType = accountType;
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
    
    public String getPlTxTime() {
        return this.plTxTime;
    }
    
    public void setPlTxTime(String plTxTime) {
    		if((plTxTime != null && this.plTxTime == null) || 
				this.plTxTime != null && (!this.plTxTime.equals(plTxTime) || plTxTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("plTxTime", this.plTxTime);
        	}
        this.plTxTime = plTxTime;
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
		 if ( !(other instanceof TblMbTransactionRequest) ) return false;
		 TblMbTransactionRequest castOther = ( TblMbTransactionRequest ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMbTransactionRequest".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("trancode", this.trancode)
		.append("mchtNo", this.mchtNo)
		.append("amount", this.amount)
		.append("trxTime", this.trxTime)
		.append("txStatus", this.txStatus)
		.append("msgext", this.msgext)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("pan", this.pan)
		.append("chinfo", this.chinfo)
		.append("plTxTraceNo", this.plTxTraceNo)
		.append("currencyType", this.currencyType)
		.append("accountType", this.accountType)
		.append("accountNo", this.accountNo)
		.append("plTxTime", this.plTxTime)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}