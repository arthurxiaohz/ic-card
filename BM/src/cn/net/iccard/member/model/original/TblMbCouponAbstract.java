package cn.net.iccard.member.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.member.model.TblMbCouponDetail;
import cn.net.iccard.member.model.TblMbCoupon;
import org.hi.base.organization.model.HiUser;

public abstract class TblMbCouponAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 优惠券类型
	 */	
 	protected  String couponType;

 	 /**
	 * 优惠券金额
	 */	
 	protected  Integer amount;

 	 /**
	 * 优惠券可用余额
	 */	
 	protected  Integer balance;

 	 /**
	 * 优惠券状态
	 */	
 	protected  Integer couponStatus;

 	 /**
	 * 有效期开始时间
	 */	
 	protected  Timestamp startDatetime;

 	 /**
	 * 有效期结束时间
	 */	
 	protected  Timestamp endDatetime;

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
	 * 会员
	 */	
 	protected  HiUser tblMbInfo;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

	private  List<TblMbCouponDetail> tblMbCouponDetails;

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
    
    public String getCouponType() {
        return this.couponType;
    }
    
    public void setCouponType(String couponType) {
    		if((couponType != null && this.couponType == null) || 
				this.couponType != null && (!this.couponType.equals(couponType) || couponType == null)){
        		this.setDirty(true);
        		this.oldValues.put("couponType", this.couponType);
        	}
        this.couponType = couponType;
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
    
    public Integer getCouponStatus() {
        return this.couponStatus;
    }
    
    public void setCouponStatus(Integer couponStatus) {
    		if((couponStatus != null && this.couponStatus == null) || 
				this.couponStatus != null && (!this.couponStatus.equals(couponStatus) || couponStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("couponStatus", this.couponStatus);
        	}
        this.couponStatus = couponStatus;
    }
    
    public Timestamp getStartDatetime() {
        return this.startDatetime;
    }
    
    public void setStartDatetime(Timestamp startDatetime) {
    		if((startDatetime != null && this.startDatetime == null) || 
				this.startDatetime != null && (!this.startDatetime.equals(startDatetime) || startDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("startDatetime", this.startDatetime);
        	}
        this.startDatetime = startDatetime;
    }
    
    public Timestamp getEndDatetime() {
        return this.endDatetime;
    }
    
    public void setEndDatetime(Timestamp endDatetime) {
    		if((endDatetime != null && this.endDatetime == null) || 
				this.endDatetime != null && (!this.endDatetime.equals(endDatetime) || endDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("endDatetime", this.endDatetime);
        	}
        this.endDatetime = endDatetime;
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
    
    public HiUser getTblMbInfo() {
        return this.tblMbInfo;
    }
    
    public void setTblMbInfo(HiUser tblMbInfo) {
    		if((tblMbInfo != null && this.tblMbInfo == null) || 
				this.tblMbInfo != null && (!this.tblMbInfo.equals(tblMbInfo) || tblMbInfo == null)){
        		this.setDirty(true);
        		this.oldValues.put("tblMbInfo", this.tblMbInfo);
        	}
        this.tblMbInfo = tblMbInfo;
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
    

    public void setTblMbCouponDetails(List<TblMbCouponDetail> tblMbCouponDetails) {
        this.tblMbCouponDetails = tblMbCouponDetails;
    }

    public List<TblMbCouponDetail> getTblMbCouponDetails() {
        return this.tblMbCouponDetails;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblMbCoupon) ) return false;
		 TblMbCoupon castOther = ( TblMbCoupon ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMbCoupon".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("couponType", this.couponType)
		.append("amount", this.amount)
		.append("balance", this.balance);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}