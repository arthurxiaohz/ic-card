package cn.net.iccard.member.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.member.model.TblMbPointDetail;
import org.hi.base.organization.model.HiUser;

public abstract class TblMbPointDetailAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 积分
	 */	
 	protected  Integer point;

 	 /**
	 * 积分交易类型
	 */	
 	protected  Integer pointTxType;

 	 /**
	 * 积分变动凭证
	 */	
 	protected  Integer voucherNo;

 	 /**
	 * 积分余额
	 */	
 	protected  Integer balance;

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
    
    public Integer getPoint() {
        return this.point;
    }
    
    public void setPoint(Integer point) {
    		if((point != null && this.point == null) || 
				this.point != null && (!this.point.equals(point) || point == null)){
        		this.setDirty(true);
        		this.oldValues.put("point", this.point);
        	}
        this.point = point;
    }
    
    public Integer getPointTxType() {
        return this.pointTxType;
    }
    
    public void setPointTxType(Integer pointTxType) {
    		if((pointTxType != null && this.pointTxType == null) || 
				this.pointTxType != null && (!this.pointTxType.equals(pointTxType) || pointTxType == null)){
        		this.setDirty(true);
        		this.oldValues.put("pointTxType", this.pointTxType);
        	}
        this.pointTxType = pointTxType;
    }
    
    public Integer getVoucherNo() {
        return this.voucherNo;
    }
    
    public void setVoucherNo(Integer voucherNo) {
    		if((voucherNo != null && this.voucherNo == null) || 
				this.voucherNo != null && (!this.voucherNo.equals(voucherNo) || voucherNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("voucherNo", this.voucherNo);
        	}
        this.voucherNo = voucherNo;
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
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblMbPointDetail) ) return false;
		 TblMbPointDetail castOther = ( TblMbPointDetail ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMbPointDetail".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("point", this.point)
		.append("voucherNo", this.voucherNo)
		.append("balance", this.balance);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}