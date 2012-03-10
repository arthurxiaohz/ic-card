package cn.net.iccard.member.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import org.hi.base.organization.model.HiUser;
import cn.net.iccard.member.model.TblMbCouponRule;

public abstract class TblMbCouponRuleAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 会员
	 */	
 	protected  HiUser tblMbInfo;

 	 /**
	 * 商户
	 */	
 	protected  TblMchtInfo tblMchtInfo;

 	 /**
	 * 商户类别
	 */	
 	protected  Integer mchtType;

 	 /**
	 * 商品类别
	 */	
 	protected  Integer merchandiseCategory;

 	 /**
	 * 商品编号
	 */	
 	protected  String merchandiseNo;

 	 /**
	 * 优惠券类型
	 */	
 	protected  Integer couponType;

 	 /**
	 * 优惠券金额
	 */	
 	protected  Integer amount;

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
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();


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
    
    public TblMchtInfo getTblMchtInfo() {
        return this.tblMchtInfo;
    }
    
    public void setTblMchtInfo(TblMchtInfo tblMchtInfo) {
    		if((tblMchtInfo != null && this.tblMchtInfo == null) || 
				this.tblMchtInfo != null && (!this.tblMchtInfo.equals(tblMchtInfo) || tblMchtInfo == null)){
        		this.setDirty(true);
        		this.oldValues.put("tblMchtInfo", this.tblMchtInfo);
        	}
        this.tblMchtInfo = tblMchtInfo;
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
    
    public Integer getMerchandiseCategory() {
        return this.merchandiseCategory;
    }
    
    public void setMerchandiseCategory(Integer merchandiseCategory) {
    		if((merchandiseCategory != null && this.merchandiseCategory == null) || 
				this.merchandiseCategory != null && (!this.merchandiseCategory.equals(merchandiseCategory) || merchandiseCategory == null)){
        		this.setDirty(true);
        		this.oldValues.put("merchandiseCategory", this.merchandiseCategory);
        	}
        this.merchandiseCategory = merchandiseCategory;
    }
    
    public String getMerchandiseNo() {
        return this.merchandiseNo;
    }
    
    public void setMerchandiseNo(String merchandiseNo) {
    		if((merchandiseNo != null && this.merchandiseNo == null) || 
				this.merchandiseNo != null && (!this.merchandiseNo.equals(merchandiseNo) || merchandiseNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("merchandiseNo", this.merchandiseNo);
        	}
        this.merchandiseNo = merchandiseNo;
    }
    
    public Integer getCouponType() {
        return this.couponType;
    }
    
    public void setCouponType(Integer couponType) {
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
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblMbCouponRule) ) return false;
		 TblMbCouponRule castOther = ( TblMbCouponRule ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMbCouponRule".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("merchandiseNo", this.merchandiseNo)
		.append("amount", this.amount);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}