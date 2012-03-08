package cn.net.iccard.tx.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.tx.model.TblTxPayMentResponse;
import org.hi.base.organization.model.HiUser;

public abstract class TblTxPayMentResponseAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * ����id
	 */	
	protected  Integer id;

	/**
	 * �汾����version
	 */	
 	protected  Integer version;

 	 /**
	 * ���ؽӿڵİ汾��
	 */	
 	protected  String versionNo;

 	 /**
	 * ǩ������
	 */	
 	protected  String signMsg;

 	 /**
	 * ֧�����
	 */	
 	protected  Integer payResult;

 	 /**
	 * �̻���
	 */	
 	protected  String mchtNo;

 	 /**
	 * �̻�������
	 */	
 	protected  String merchantOrderNo;

 	 /**
	 * �̻��������
	 */	
 	protected  Integer orderAmount;

 	 /**
	 * ��������
	 */	
 	protected  String txTypeId;

 	 /**
	 * ��ϵͳ�еĶ���ʵ��֧�����
	 */	
 	protected  Integer payAmount;

 	 /**
	 * ֧�����ʱ��
	 */	
 	protected  String payDatetime;

 	 /**
	 * ��չ����1
	 */	
 	protected  String ext1;

 	 /**
	 * ��չ����2
	 */	
 	protected  Date ext2;

 	 /**
	 * �������
	 */	
 	protected  String errorCode;

 	 /**
	 * ��������
	 */	
 	protected  String context;

 	 /**
	 * �̻����ؽ��
	 */	
 	protected  String responseContent;

 	 /**
	 * ����ʱ��
	 */	
 	protected  Timestamp createdDatetime;

 	 /**
	 * ����޸�ʱ��
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * ����޸���
	 */	
 	protected  Integer lastUpdatedBy;

 	 /**
	 * ������
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

 	 /**
	 * ɾ����ʶ
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
    
    public Integer getPayResult() {
        return this.payResult;
    }
    
    public void setPayResult(Integer payResult) {
    		if((payResult != null && this.payResult == null) || 
				this.payResult != null && (!this.payResult.equals(payResult) || payResult == null)){
        		this.setDirty(true);
        		this.oldValues.put("payResult", this.payResult);
        	}
        this.payResult = payResult;
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
    
    public Integer getOrderAmount() {
        return this.orderAmount;
    }
    
    public void setOrderAmount(Integer orderAmount) {
    		if((orderAmount != null && this.orderAmount == null) || 
				this.orderAmount != null && (!this.orderAmount.equals(orderAmount) || orderAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("orderAmount", this.orderAmount);
        	}
        this.orderAmount = orderAmount;
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
    
    public Integer getPayAmount() {
        return this.payAmount;
    }
    
    public void setPayAmount(Integer payAmount) {
    		if((payAmount != null && this.payAmount == null) || 
				this.payAmount != null && (!this.payAmount.equals(payAmount) || payAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("payAmount", this.payAmount);
        	}
        this.payAmount = payAmount;
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
		 if ( !(other instanceof TblTxPayMentResponse) ) return false;
		 TblTxPayMentResponse castOther = ( TblTxPayMentResponse ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblTxPayMentResponse".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("versionNo", this.versionNo)
		.append("signMsg", this.signMsg)
		.append("mchtNo", this.mchtNo)
		.append("merchantOrderNo", this.merchantOrderNo)
		.append("orderAmount", this.orderAmount)
		.append("txTypeId", this.txTypeId)
		.append("payAmount", this.payAmount)
		.append("payDatetime", this.payDatetime)
		.append("ext1", this.ext1)
		.append("errorCode", this.errorCode)
		.append("context", this.context)
		.append("responseContent", this.responseContent)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}