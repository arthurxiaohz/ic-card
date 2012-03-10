package cn.net.iccard.member.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.member.model.TblMbInfo;
import org.hi.base.organization.model.HiUser;

public abstract class TblMbInfoAbstract extends HiUser implements Serializable{

 	 /**
	 * id
	 */	
 	protected  Integer id;

 	 /**
	 * 证件类型
	 */	
 	protected  String certificateTypeId;

 	 /**
	 * 卡号
	 */	
 	protected  String cardNo;

 	 /**
	 * 实名认证状态
	 */	
 	protected  String realNameStatus;

 	 /**
	 * 实名认证时间
	 */	
 	protected  String realNameTime;

 	 /**
	 * 注册时间
	 */	
 	protected  String registerTime;

 	 /**
	 * 注册方式
	 */	
 	protected  String registerWay;

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
    
    public String getCertificateTypeId() {
        return this.certificateTypeId;
    }
    
    public void setCertificateTypeId(String certificateTypeId) {
    		if((certificateTypeId != null && this.certificateTypeId == null) || 
				this.certificateTypeId != null && (!this.certificateTypeId.equals(certificateTypeId) || certificateTypeId == null)){
        		this.setDirty(true);
        		this.oldValues.put("certificateTypeId", this.certificateTypeId);
        	}
        this.certificateTypeId = certificateTypeId;
    }
    
    public String getCardNo() {
        return this.cardNo;
    }
    
    public void setCardNo(String cardNo) {
    		if((cardNo != null && this.cardNo == null) || 
				this.cardNo != null && (!this.cardNo.equals(cardNo) || cardNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("cardNo", this.cardNo);
        	}
        this.cardNo = cardNo;
    }
    
    public String getRealNameStatus() {
        return this.realNameStatus;
    }
    
    public void setRealNameStatus(String realNameStatus) {
    		if((realNameStatus != null && this.realNameStatus == null) || 
				this.realNameStatus != null && (!this.realNameStatus.equals(realNameStatus) || realNameStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("realNameStatus", this.realNameStatus);
        	}
        this.realNameStatus = realNameStatus;
    }
    
    public String getRealNameTime() {
        return this.realNameTime;
    }
    
    public void setRealNameTime(String realNameTime) {
    		if((realNameTime != null && this.realNameTime == null) || 
				this.realNameTime != null && (!this.realNameTime.equals(realNameTime) || realNameTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("realNameTime", this.realNameTime);
        	}
        this.realNameTime = realNameTime;
    }
    
    public String getRegisterTime() {
        return this.registerTime;
    }
    
    public void setRegisterTime(String registerTime) {
    		if((registerTime != null && this.registerTime == null) || 
				this.registerTime != null && (!this.registerTime.equals(registerTime) || registerTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("registerTime", this.registerTime);
        	}
        this.registerTime = registerTime;
    }
    
    public String getRegisterWay() {
        return this.registerWay;
    }
    
    public void setRegisterWay(String registerWay) {
    		if((registerWay != null && this.registerWay == null) || 
				this.registerWay != null && (!this.registerWay.equals(registerWay) || registerWay == null)){
        		this.setDirty(true);
        		this.oldValues.put("registerWay", this.registerWay);
        	}
        this.registerWay = registerWay;
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
		 if ( !(other instanceof TblMbInfo) ) return false;
		 TblMbInfo castOther = ( TblMbInfo ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.appendSuper(super.hashCode());
		hcb.append("TblMbInfo".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("certificateTypeId", this.certificateTypeId)
		.append("cardNo", this.cardNo)
		.append("realNameStatus", this.realNameStatus)
		.append("realNameTime", this.realNameTime)
		.append("registerTime", this.registerTime)
		.append("registerWay", this.registerWay)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}