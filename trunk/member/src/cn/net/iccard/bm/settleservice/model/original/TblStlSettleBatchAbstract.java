package cn.net.iccard.bm.settleservice.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import org.hi.base.organization.model.HiUser;

public abstract class TblStlSettleBatchAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * ����id
	 */	
	protected  Integer id;

	/**
	 * �汾����version
	 */	
 	protected  Integer version;

 	 /**
	 * �������κ�
	 */	
 	protected  String settleBatchNo;

 	 /**
	 * ������
	 */	
 	protected  Date settleDate;

 	 /**
	 * ������
	 */	
 	protected  Integer totalCount;

 	 /**
	 * �ܽ��
	 */	
 	protected  Integer totalAmount;

 	 /**
	 * ״̬
	 */	
 	protected  Integer settleBatchStatus;

 	 /**
	 * ��ע
	 */	
 	protected  String remark;

 	 /**
	 * ����ʱ��
	 */	
 	protected  Timestamp createdDateTime;

 	 /**
	 * ����޸�ʱ��
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * ����޸���
	 */	
 	protected  HiUser lastUpdatedBy;

 	 /**
	 * ������
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
    
    public String getSettleBatchNo() {
        return this.settleBatchNo;
    }
    
    public void setSettleBatchNo(String settleBatchNo) {
    		if((settleBatchNo != null && this.settleBatchNo == null) || 
				this.settleBatchNo != null && (!this.settleBatchNo.equals(settleBatchNo) || settleBatchNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleBatchNo", this.settleBatchNo);
        	}
        this.settleBatchNo = settleBatchNo;
    }
    
    public Date getSettleDate() {
        return this.settleDate;
    }
    
    public void setSettleDate(Date settleDate) {
    		if((settleDate != null && this.settleDate == null) || 
				this.settleDate != null && (!this.settleDate.equals(settleDate) || settleDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleDate", this.settleDate);
        	}
        this.settleDate = settleDate;
    }
    
    public Integer getTotalCount() {
        return this.totalCount;
    }
    
    public void setTotalCount(Integer totalCount) {
    		if((totalCount != null && this.totalCount == null) || 
				this.totalCount != null && (!this.totalCount.equals(totalCount) || totalCount == null)){
        		this.setDirty(true);
        		this.oldValues.put("totalCount", this.totalCount);
        	}
        this.totalCount = totalCount;
    }
    
    public Integer getTotalAmount() {
        return this.totalAmount;
    }
    
    public void setTotalAmount(Integer totalAmount) {
    		if((totalAmount != null && this.totalAmount == null) || 
				this.totalAmount != null && (!this.totalAmount.equals(totalAmount) || totalAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("totalAmount", this.totalAmount);
        	}
        this.totalAmount = totalAmount;
    }
    
    public Integer getSettleBatchStatus() {
        return this.settleBatchStatus;
    }
    
    public void setSettleBatchStatus(Integer settleBatchStatus) {
    		if((settleBatchStatus != null && this.settleBatchStatus == null) || 
				this.settleBatchStatus != null && (!this.settleBatchStatus.equals(settleBatchStatus) || settleBatchStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleBatchStatus", this.settleBatchStatus);
        	}
        this.settleBatchStatus = settleBatchStatus;
    }
    
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
    		if((remark != null && this.remark == null) || 
				this.remark != null && (!this.remark.equals(remark) || remark == null)){
        		this.setDirty(true);
        		this.oldValues.put("remark", this.remark);
        	}
        this.remark = remark;
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
		 if ( !(other instanceof TblStlSettleBatch) ) return false;
		 TblStlSettleBatch castOther = ( TblStlSettleBatch ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblStlSettleBatch".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("settleBatchNo", this.settleBatchNo)
		.append("totalCount", this.totalCount)
		.append("totalAmount", this.totalAmount);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}