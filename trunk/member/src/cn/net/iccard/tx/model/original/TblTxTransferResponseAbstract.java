package cn.net.iccard.tx.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.tx.model.TblTxTransferResponse;
import org.hi.base.organization.model.HiUser;

public abstract class TblTxTransferResponseAbstract extends BaseObject implements Serializable{

 	
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
	 * 返回接口的版本号
	 */	
 	protected  String versionNo;

 	 /**
	 * 签名内容
	 */	
 	protected  String signMsg;

 	 /**
	 * 转账结果
	 */	
 	protected  String transferResult;

 	 /**
	 * 平台交易流水号
	 */	
 	protected  String plTxTraceNo;

 	 /**
	 * 商户订单号
	 */	
 	protected  String merchantOrderNo;

 	 /**
	 * 商户转账金额
	 */	
 	protected  Integer transferAmount;

 	 /**
	 * 交易类型
	 */	
 	protected  String txTypeId;

 	 /**
	 * 支付完成时间
	 */	
 	protected  String payDatetime;

 	 /**
	 * 扩展参数1
	 */	
 	protected  String ext1;

 	 /**
	 * 扩展参数2
	 */	
 	protected  Date ext2;

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
	 * 错误代码
	 */	
 	protected  String errorCode;

 	 /**
	 * 报文内容
	 */	
 	protected  String context;

 	 /**
	 * 商户返回结果
	 */	
 	protected  String responseContent;

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
    
    public String getVersionNo() {
        return this.versionNo;
    }
    
    public void setVersionNo(String versionNo) {
    		if((versionNo != null && this.versionNo == null) || 
				this.versionNo != null && (!this.versionNo.equals(versionNo) || versionNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("versionNo", this.versionNo);
        	}
        this.versionNo = versionNo;
    }
    
    public String getSignMsg() {
        return this.signMsg;
    }
    
    public void setSignMsg(String signMsg) {
    		if((signMsg != null && this.signMsg == null) || 
				this.signMsg != null && (!this.signMsg.equals(signMsg) || signMsg == null)){
        		this.setDirty(true);
        		this.oldValues.put("signMsg", this.signMsg);
        	}
        this.signMsg = signMsg;
    }
    
    public String getTransferResult() {
        return this.transferResult;
    }
    
    public void setTransferResult(String transferResult) {
    		if((transferResult != null && this.transferResult == null) || 
				this.transferResult != null && (!this.transferResult.equals(transferResult) || transferResult == null)){
        		this.setDirty(true);
        		this.oldValues.put("transferResult", this.transferResult);
        	}
        this.transferResult = transferResult;
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
    
    public String getMerchantOrderNo() {
        return this.merchantOrderNo;
    }
    
    public void setMerchantOrderNo(String merchantOrderNo) {
    		if((merchantOrderNo != null && this.merchantOrderNo == null) || 
				this.merchantOrderNo != null && (!this.merchantOrderNo.equals(merchantOrderNo) || merchantOrderNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("merchantOrderNo", this.merchantOrderNo);
        	}
        this.merchantOrderNo = merchantOrderNo;
    }
    
    public Integer getTransferAmount() {
        return this.transferAmount;
    }
    
    public void setTransferAmount(Integer transferAmount) {
    		if((transferAmount != null && this.transferAmount == null) || 
				this.transferAmount != null && (!this.transferAmount.equals(transferAmount) || transferAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("transferAmount", this.transferAmount);
        	}
        this.transferAmount = transferAmount;
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
    
    public String getPayDatetime() {
        return this.payDatetime;
    }
    
    public void setPayDatetime(String payDatetime) {
    		if((payDatetime != null && this.payDatetime == null) || 
				this.payDatetime != null && (!this.payDatetime.equals(payDatetime) || payDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("payDatetime", this.payDatetime);
        	}
        this.payDatetime = payDatetime;
    }
    
    public String getExt1() {
        return this.ext1;
    }
    
    public void setExt1(String ext1) {
    		if((ext1 != null && this.ext1 == null) || 
				this.ext1 != null && (!this.ext1.equals(ext1) || ext1 == null)){
        		this.setDirty(true);
        		this.oldValues.put("ext1", this.ext1);
        	}
        this.ext1 = ext1;
    }
    
    public Date getExt2() {
        return this.ext2;
    }
    
    public void setExt2(Date ext2) {
    		if((ext2 != null && this.ext2 == null) || 
				this.ext2 != null && (!this.ext2.equals(ext2) || ext2 == null)){
        		this.setDirty(true);
        		this.oldValues.put("ext2", this.ext2);
        	}
        this.ext2 = ext2;
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
    
    public String getErrorCode() {
        return this.errorCode;
    }
    
    public void setErrorCode(String errorCode) {
    		if((errorCode != null && this.errorCode == null) || 
				this.errorCode != null && (!this.errorCode.equals(errorCode) || errorCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("errorCode", this.errorCode);
        	}
        this.errorCode = errorCode;
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
    
    public String getResponseContent() {
        return this.responseContent;
    }
    
    public void setResponseContent(String responseContent) {
    		if((responseContent != null && this.responseContent == null) || 
				this.responseContent != null && (!this.responseContent.equals(responseContent) || responseContent == null)){
        		this.setDirty(true);
        		this.oldValues.put("responseContent", this.responseContent);
        	}
        this.responseContent = responseContent;
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
		 if ( !(other instanceof TblTxTransferResponse) ) return false;
		 TblTxTransferResponse castOther = ( TblTxTransferResponse ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblTxTransferResponse".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("responseId", this.responseId)
		.append("versionNo", this.versionNo)
		.append("signMsg", this.signMsg)
		.append("transferResult", this.transferResult)
		.append("plTxTraceNo", this.plTxTraceNo)
		.append("merchantOrderNo", this.merchantOrderNo)
		.append("transferAmount", this.transferAmount)
		.append("txTypeId", this.txTypeId)
		.append("payDatetime", this.payDatetime)
		.append("ext1", this.ext1)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("errorCode", this.errorCode)
		.append("context", this.context)
		.append("responseContent", this.responseContent)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}