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
import cn.net.iccard.member.model.TblMbPointRule;
import org.hi.base.organization.model.HiUser;

public abstract class TblMbPointRuleAbstract extends BaseObject implements Serializable{

 	
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
	 * 有效期开始时间
	 */	
 	protected  Timestamp startDatetime;

 	 /**
	 * 有效期结束时间
	 */	
 	protected  Timestamp endDatetime;

 	 /**
	 * 起始金额
	 */	
 	protected  String minAmount;

 	 /**
	 * 截止金额
	 */	
 	protected  String maxAmount;

 	 /**
	 * 积分规则类型
	 */	
 	protected  Integer pointRuleType;

 	 /**
	 * 参数值
	 */	
 	protected  Double ruleValue;

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
 	protected  Integer lastUpdatedBy;

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
    
    public String getMinAmount() {
        return this.minAmount;
    }
    
    public void setMinAmount(String minAmount) {
    		if((minAmount != null && this.minAmount == null) || 
				this.minAmount != null && (!this.minAmount.equals(minAmount) || minAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("minAmount", this.minAmount);
        	}
        this.minAmount = minAmount;
    }
    
    public String getMaxAmount() {
        return this.maxAmount;
    }
    
    public void setMaxAmount(String maxAmount) {
    		if((maxAmount != null && this.maxAmount == null) || 
				this.maxAmount != null && (!this.maxAmount.equals(maxAmount) || maxAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("maxAmount", this.maxAmount);
        	}
        this.maxAmount = maxAmount;
    }
    
    public Integer getPointRuleType() {
        return this.pointRuleType;
    }
    
    public void setPointRuleType(Integer pointRuleType) {
    		if((pointRuleType != null && this.pointRuleType == null) || 
				this.pointRuleType != null && (!this.pointRuleType.equals(pointRuleType) || pointRuleType == null)){
        		this.setDirty(true);
        		this.oldValues.put("pointRuleType", this.pointRuleType);
        	}
        this.pointRuleType = pointRuleType;
    }
    
    public Double getRuleValue() {
        return this.ruleValue;
    }
    
    public void setRuleValue(Double ruleValue) {
    		if((ruleValue != null && this.ruleValue == null) || 
				this.ruleValue != null && (!this.ruleValue.equals(ruleValue) || ruleValue == null)){
        		this.setDirty(true);
        		this.oldValues.put("ruleValue", this.ruleValue);
        	}
        this.ruleValue = ruleValue;
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
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblMbPointRule) ) return false;
		 TblMbPointRule castOther = ( TblMbPointRule ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMbPointRule".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("minAmount", this.minAmount)
		.append("maxAmount", this.maxAmount)
		.append("ruleValue", this.ruleValue)
		.append("lastUpdatedBy", this.lastUpdatedBy);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}