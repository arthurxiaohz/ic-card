package cn.net.iccard.tx.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.tx.model.TblTxSmsLog;
import org.hi.base.organization.model.HiUser;

public abstract class TblTxSmsLogAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * ����id
	 */	
	protected  Integer id;

	/**
	 * �汾����version
	 */	
 	protected  Integer version;

 	 /**
	 * ���ͷ���ʶ
	 */	
 	protected  String senderId;

 	 /**
	 * ���ͷ���ˮ��
	 */	
 	protected  String seqNo;

 	 /**
	 * �ֻ�����
	 */	
 	protected  String phoneNum;

 	 /**
	 * ��������
	 */	
 	protected  String phoneMessage;

 	 /**
	 * ����״̬
	 */	
 	protected  String status;

 	 /**
	 * ����ʱ��
	 */	
 	protected  Timestamp createdDatetime = new Timestamp(System.currentTimeMillis());

 	 /**
	 * ����޸�ʱ��
	 */	
 	protected  Timestamp lastUpdatedDdatetime;

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
    
    public String getSenderId() {
        return this.senderId;
    }
    
    public void setSenderId(String senderId) {
    		if((senderId != null && this.senderId == null) || 
				this.senderId != null && (!this.senderId.equals(senderId) || senderId == null)){
        		this.setDirty(true);
        		this.oldValues.put("senderId", this.senderId);
        	}
        this.senderId = senderId;
    }
    
    public String getSeqNo() {
        return this.seqNo;
    }
    
    public void setSeqNo(String seqNo) {
    		if((seqNo != null && this.seqNo == null) || 
				this.seqNo != null && (!this.seqNo.equals(seqNo) || seqNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("seqNo", this.seqNo);
        	}
        this.seqNo = seqNo;
    }
    
    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    public void setPhoneNum(String phoneNum) {
    		if((phoneNum != null && this.phoneNum == null) || 
				this.phoneNum != null && (!this.phoneNum.equals(phoneNum) || phoneNum == null)){
        		this.setDirty(true);
        		this.oldValues.put("phoneNum", this.phoneNum);
        	}
        this.phoneNum = phoneNum;
    }
    
    public String getPhoneMessage() {
        return this.phoneMessage;
    }
    
    public void setPhoneMessage(String phoneMessage) {
    		if((phoneMessage != null && this.phoneMessage == null) || 
				this.phoneMessage != null && (!this.phoneMessage.equals(phoneMessage) || phoneMessage == null)){
        		this.setDirty(true);
        		this.oldValues.put("phoneMessage", this.phoneMessage);
        	}
        this.phoneMessage = phoneMessage;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
    		if((status != null && this.status == null) || 
				this.status != null && (!this.status.equals(status) || status == null)){
        		this.setDirty(true);
        		this.oldValues.put("status", this.status);
        	}
        this.status = status;
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
    
    public Timestamp getLastUpdatedDdatetime() {
        return this.lastUpdatedDdatetime;
    }
    
    public void setLastUpdatedDdatetime(Timestamp lastUpdatedDdatetime) {
    		if((lastUpdatedDdatetime != null && this.lastUpdatedDdatetime == null) || 
				this.lastUpdatedDdatetime != null && (!this.lastUpdatedDdatetime.equals(lastUpdatedDdatetime) || lastUpdatedDdatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastUpdatedDdatetime", this.lastUpdatedDdatetime);
        	}
        this.lastUpdatedDdatetime = lastUpdatedDdatetime;
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
		 if ( !(other instanceof TblTxSmsLog) ) return false;
		 TblTxSmsLog castOther = ( TblTxSmsLog ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblTxSmsLog".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("senderId", this.senderId)
		.append("seqNo", this.seqNo)
		.append("phoneNum", this.phoneNum)
		.append("phoneMessage", this.phoneMessage)
		.append("status", this.status)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}