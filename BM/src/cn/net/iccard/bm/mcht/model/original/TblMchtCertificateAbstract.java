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
import cn.net.iccard.bm.mcht.model.TblMchtCertificate;
import org.hi.base.organization.model.HiUser;

public abstract class TblMchtCertificateAbstract extends BaseObject implements Serializable{

 	
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
	 * 证书序列号
	 */	
 	protected  String certSn;

 	 /**
	 * 颁发者DN
	 */	
 	protected  String issuerCertDn;

 	 /**
	 * 证书DN
	 */	
 	protected  String certDn;

 	 /**
	 * 证书有效期开始时间
	 */	
 	protected  String startTime;

 	 /**
	 * 证书有效期结束时间
	 */	
 	protected  String endTime;

 	 /**
	 * 证书内容
	 */	
 	protected  String certContent;

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
   
    public String getCertSn() {
        return this.certSn;
    }
    
    public void setCertSn(String certSn) {
    		if((certSn != null && this.certSn == null) || 
				this.certSn != null && (!this.certSn.equals(certSn) || certSn == null)){
        		this.setDirty(true);
        		this.oldValues.put("certSn", this.certSn);
        	}
        this.certSn = certSn;
    }
    
    public String getIssuerCertDn() {
        return this.issuerCertDn;
    }
    
    public void setIssuerCertDn(String issuerCertDn) {
    		if((issuerCertDn != null && this.issuerCertDn == null) || 
				this.issuerCertDn != null && (!this.issuerCertDn.equals(issuerCertDn) || issuerCertDn == null)){
        		this.setDirty(true);
        		this.oldValues.put("issuerCertDn", this.issuerCertDn);
        	}
        this.issuerCertDn = issuerCertDn;
    }
    
    public String getCertDn() {
        return this.certDn;
    }
    
    public void setCertDn(String certDn) {
    		if((certDn != null && this.certDn == null) || 
				this.certDn != null && (!this.certDn.equals(certDn) || certDn == null)){
        		this.setDirty(true);
        		this.oldValues.put("certDn", this.certDn);
        	}
        this.certDn = certDn;
    }
    
    public String getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(String startTime) {
    		if((startTime != null && this.startTime == null) || 
				this.startTime != null && (!this.startTime.equals(startTime) || startTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("startTime", this.startTime);
        	}
        this.startTime = startTime;
    }
    
    public String getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(String endTime) {
    		if((endTime != null && this.endTime == null) || 
				this.endTime != null && (!this.endTime.equals(endTime) || endTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("endTime", this.endTime);
        	}
        this.endTime = endTime;
    }
    
    public String getCertContent() {
        return this.certContent;
    }
    
    public void setCertContent(String certContent) {
    		if((certContent != null && this.certContent == null) || 
				this.certContent != null && (!this.certContent.equals(certContent) || certContent == null)){
        		this.setDirty(true);
        		this.oldValues.put("certContent", this.certContent);
        	}
        this.certContent = certContent;
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
		 if ( !(other instanceof TblMchtCertificate) ) return false;
		 TblMchtCertificate castOther = ( TblMchtCertificate ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMchtCertificate".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("certSn", this.certSn)
		.append("issuerCertDn", this.issuerCertDn)
		.append("certDn", this.certDn)
		.append("startTime", this.startTime)
		.append("endTime", this.endTime);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}