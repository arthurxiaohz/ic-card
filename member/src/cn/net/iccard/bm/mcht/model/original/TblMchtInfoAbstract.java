package cn.net.iccard.bm.mcht.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.mcht.model.TblMchtCertificate;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.model.TblMchtPaymentConfig;
import cn.net.iccard.bm.mcht.model.TblMchtFeeConfig;
import org.hi.base.organization.model.HiUser;

public abstract class TblMchtInfoAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 商户号
	 */	
 	protected  String mchtNo;

 	 /**
	 * 商户名称
	 */	
 	protected  String mchtName;

 	 /**
	 * 状态
	 */	
 	protected  Integer status;

 	 /**
	 * 商户类别
	 */	
 	protected  Integer mchtType;

 	 /**
	 * 座机
	 */	
 	protected  String landline;

 	 /**
	 * 移动电话
	 */	
 	protected  String mobile;

 	 /**
	 * 传真
	 */	
 	protected  String fax;

 	 /**
	 * 地址
	 */	
 	protected  String address;

 	 /**
	 * 手续费结算方式
	 */	
 	protected  Integer feeFlag;

 	 /**
	 * 支付自动确认期
	 */	
 	protected  Integer days;

 	 /**
	 * 银行账户账号
	 */	
 	protected  String bankAccountNo;

 	 /**
	 * 银行账户名称
	 */	
 	protected  String bankAccountName;

 	 /**
	 * 开户行行号
	 */	
 	protected  String bankNo;

 	 /**
	 * 开户行名称
	 */	
 	protected  String bankName;

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

	private  List<TblMchtFeeConfig> tblMchtFeeConfigs;
	private  List<TblMchtCertificate> tblMchtCertificates;
	private  List<TblMchtPaymentConfig> tblMchtPaymentConfigs;

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
    
    public String getMchtName() {
        return this.mchtName;
    }
    
    public void setMchtName(String mchtName) {
    		if((mchtName != null && this.mchtName == null) || 
				this.mchtName != null && (!this.mchtName.equals(mchtName) || mchtName == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtName", this.mchtName);
        	}
        this.mchtName = mchtName;
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
    
    public Integer getMchtType() {
        return this.mchtType;
    }
    
    public void setMchtType(Integer mchtType) {
    		if((mchtType != null && this.mchtType == null) || 
				this.mchtType != null && (!this.mchtType.equals(mchtType) || mchtType == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtType", this.mchtType);
        	}
        this.mchtType = mchtType;
    }
    
    public String getLandline() {
        return this.landline;
    }
    
    public void setLandline(String landline) {
    		if((landline != null && this.landline == null) || 
				this.landline != null && (!this.landline.equals(landline) || landline == null)){
        		this.setDirty(true);
        		this.oldValues.put("landline", this.landline);
        	}
        this.landline = landline;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
    		if((mobile != null && this.mobile == null) || 
				this.mobile != null && (!this.mobile.equals(mobile) || mobile == null)){
        		this.setDirty(true);
        		this.oldValues.put("mobile", this.mobile);
        	}
        this.mobile = mobile;
    }
    
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
    		if((fax != null && this.fax == null) || 
				this.fax != null && (!this.fax.equals(fax) || fax == null)){
        		this.setDirty(true);
        		this.oldValues.put("fax", this.fax);
        	}
        this.fax = fax;
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
    
    public Integer getFeeFlag() {
        return this.feeFlag;
    }
    
    public void setFeeFlag(Integer feeFlag) {
    		if((feeFlag != null && this.feeFlag == null) || 
				this.feeFlag != null && (!this.feeFlag.equals(feeFlag) || feeFlag == null)){
        		this.setDirty(true);
        		this.oldValues.put("feeFlag", this.feeFlag);
        	}
        this.feeFlag = feeFlag;
    }
    
    public Integer getDays() {
        return this.days;
    }
    
    public void setDays(Integer days) {
    		if((days != null && this.days == null) || 
				this.days != null && (!this.days.equals(days) || days == null)){
        		this.setDirty(true);
        		this.oldValues.put("days", this.days);
        	}
        this.days = days;
    }
    
    public String getBankAccountNo() {
        return this.bankAccountNo;
    }
    
    public void setBankAccountNo(String bankAccountNo) {
    		if((bankAccountNo != null && this.bankAccountNo == null) || 
				this.bankAccountNo != null && (!this.bankAccountNo.equals(bankAccountNo) || bankAccountNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("bankAccountNo", this.bankAccountNo);
        	}
        this.bankAccountNo = bankAccountNo;
    }
    
    public String getBankAccountName() {
        return this.bankAccountName;
    }
    
    public void setBankAccountName(String bankAccountName) {
    		if((bankAccountName != null && this.bankAccountName == null) || 
				this.bankAccountName != null && (!this.bankAccountName.equals(bankAccountName) || bankAccountName == null)){
        		this.setDirty(true);
        		this.oldValues.put("bankAccountName", this.bankAccountName);
        	}
        this.bankAccountName = bankAccountName;
    }
    
    public String getBankNo() {
        return this.bankNo;
    }
    
    public void setBankNo(String bankNo) {
    		if((bankNo != null && this.bankNo == null) || 
				this.bankNo != null && (!this.bankNo.equals(bankNo) || bankNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("bankNo", this.bankNo);
        	}
        this.bankNo = bankNo;
    }
    
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String bankName) {
    		if((bankName != null && this.bankName == null) || 
				this.bankName != null && (!this.bankName.equals(bankName) || bankName == null)){
        		this.setDirty(true);
        		this.oldValues.put("bankName", this.bankName);
        	}
        this.bankName = bankName;
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
    

    public void setTblMchtFeeConfigs(List<TblMchtFeeConfig> tblMchtFeeConfigs) {
        this.tblMchtFeeConfigs = tblMchtFeeConfigs;
    }

    public List<TblMchtFeeConfig> getTblMchtFeeConfigs() {
        return this.tblMchtFeeConfigs;
    }
    public void setTblMchtCertificates(List<TblMchtCertificate> tblMchtCertificates) {
        this.tblMchtCertificates = tblMchtCertificates;
    }

    public List<TblMchtCertificate> getTblMchtCertificates() {
        return this.tblMchtCertificates;
    }
    public void setTblMchtPaymentConfigs(List<TblMchtPaymentConfig> tblMchtPaymentConfigs) {
        this.tblMchtPaymentConfigs = tblMchtPaymentConfigs;
    }

    public List<TblMchtPaymentConfig> getTblMchtPaymentConfigs() {
        return this.tblMchtPaymentConfigs;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblMchtInfo) ) return false;
		 TblMchtInfo castOther = ( TblMchtInfo ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMchtInfo".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("mchtNo", this.mchtNo)
		.append("mchtName", this.mchtName)
		.append("landline", this.landline)
		.append("mobile", this.mobile)
		.append("fax", this.fax)
		.append("address", this.address)
		.append("days", this.days)
		.append("bankAccountNo", this.bankAccountNo)
		.append("bankAccountName", this.bankAccountName)
		.append("bankNo", this.bankNo)
		.append("bankName", this.bankName)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}