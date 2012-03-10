package cn.net.iccard.bm.mcht.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.model.TblMchtFeeConfig;
import org.hi.base.organization.model.HiUser;

public abstract class TblMchtFeeConfigAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * tblMchtInfo
	 */	
 	protected  TblMchtInfo tblMchtInfo;

 	 /**
	 * 手续费类型
	 */	
 	protected  Integer mchtFeeType;

 	 /**
	 * 参数值
	 */	
 	protected  Double ruleValue;

 	 /**
	 * 单笔最低收费
	 */	
 	protected  Integer minVal = 0;

 	 /**
	 * 单笔最高收费
	 */	
 	protected  Integer maxVal = 0;

 	 /**
	 * 退款是否退还手续费
	 */	
 	protected  Integer isFeeReturn;

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
    
   public BaseObject getParentEntity(){
	   return this.tblMchtInfo;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.tblMchtInfo = (TblMchtInfo)parent;
   }
   
    public Integer getMchtFeeType() {
        return this.mchtFeeType;
    }
    
    public void setMchtFeeType(Integer mchtFeeType) {
    		if((mchtFeeType != null && this.mchtFeeType == null) || 
				this.mchtFeeType != null && (!this.mchtFeeType.equals(mchtFeeType) || mchtFeeType == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtFeeType", this.mchtFeeType);
        	}
        this.mchtFeeType = mchtFeeType;
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
    
    public Integer getMinVal() {
        return this.minVal;
    }
    
    public void setMinVal(Integer minVal) {
    		if((minVal != null && this.minVal == null) || 
				this.minVal != null && (!this.minVal.equals(minVal) || minVal == null)){
        		this.setDirty(true);
        		this.oldValues.put("minVal", this.minVal);
        	}
        this.minVal = minVal;
    }
    
    public Integer getMaxVal() {
        return this.maxVal;
    }
    
    public void setMaxVal(Integer maxVal) {
    		if((maxVal != null && this.maxVal == null) || 
				this.maxVal != null && (!this.maxVal.equals(maxVal) || maxVal == null)){
        		this.setDirty(true);
        		this.oldValues.put("maxVal", this.maxVal);
        	}
        this.maxVal = maxVal;
    }
    
    public Integer getIsFeeReturn() {
        return this.isFeeReturn;
    }
    
    public void setIsFeeReturn(Integer isFeeReturn) {
    		if((isFeeReturn != null && this.isFeeReturn == null) || 
				this.isFeeReturn != null && (!this.isFeeReturn.equals(isFeeReturn) || isFeeReturn == null)){
        		this.setDirty(true);
        		this.oldValues.put("isFeeReturn", this.isFeeReturn);
        	}
        this.isFeeReturn = isFeeReturn;
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
		 if ( !(other instanceof TblMchtFeeConfig) ) return false;
		 TblMchtFeeConfig castOther = ( TblMchtFeeConfig ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMchtFeeConfig".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("ruleValue", this.ruleValue)
		.append("minVal", this.minVal)
		.append("maxVal", this.maxVal);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}