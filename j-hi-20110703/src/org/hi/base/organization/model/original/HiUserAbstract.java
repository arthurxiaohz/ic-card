package org.hi.base.organization.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.organization.model.UserType;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;

public abstract class HiUserAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 帐号
	 */	
 	protected  String userName;

 	 /**
	 * 密码
	 */	
 	protected  String password;

 	 /**
	 * 国家
	 */	
 	protected  Integer country;

 	 /**
	 * 时区
	 */	
 	protected  Integer timeZone;

 	 /**
	 * 帐号可用
	 * 
	 */	
 	protected  Integer accountEnabled;

 	 /**
	 * 加锁
	 * 
	 */	
 	protected  Integer accountLocked;

 	 /**
	 * 用效期至
	 */	
 	protected  Date expiredDate;

 	 /**
	 * 是否过期
	 * 
	 */	
 	protected  Integer credentialsExpired;

 	 /**
	 * 姓名
	 */	
 	protected  String fullName;

 	 /**
	 * 部门
	 */	
 	protected  HiOrg org;

 	 /**
	 * 性别
	 * 
	 */	
 	protected  Integer gender;

 	 /**
	 * 地址
	 */	
 	protected  String address;

 	 /**
	 * 电话
	 */	
 	protected  String phone;

 	 /**
	 * 手机
	 */	
 	protected  String mobile;

 	 /**
	 * 邮编
	 */	
 	protected  String zip;

 	 /**
	 * 身份证
	 */	
 	protected  String SSN;

 	 /**
	 * E-Mail
	 */	
 	protected  String mail;

 	 /**
	 * 用户类型
	 * 
	 */	
 	protected  Integer userMgrType;

 	 /**
	 * 提醒方式
	 */	
 	protected  String notifyMode;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator;

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
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
    		if((userName != null && this.userName == null) || 
				this.userName != null && (!this.userName.equals(userName) || userName == null)){
        		this.setDirty(true);
        		this.oldValues.put("userName", this.userName);
        	}
        this.userName = userName;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
    		if((password != null && this.password == null) || 
				this.password != null && (!this.password.equals(password) || password == null)){
        		this.setDirty(true);
        		this.oldValues.put("password", this.password);
        	}
        this.password = password;
    }
    
    public Integer getCountry() {
        return this.country;
    }
    
    public void setCountry(Integer country) {
    		if((country != null && this.country == null) || 
				this.country != null && (!this.country.equals(country) || country == null)){
        		this.setDirty(true);
        		this.oldValues.put("country", this.country);
        	}
        this.country = country;
    }
    
    public Integer getTimeZone() {
        return this.timeZone;
    }
    
    public void setTimeZone(Integer timeZone) {
    		if((timeZone != null && this.timeZone == null) || 
				this.timeZone != null && (!this.timeZone.equals(timeZone) || timeZone == null)){
        		this.setDirty(true);
        		this.oldValues.put("timeZone", this.timeZone);
        	}
        this.timeZone = timeZone;
    }
    
    public Integer getAccountEnabled() {
        return this.accountEnabled;
    }
    
    public void setAccountEnabled(Integer accountEnabled) {
    		if((accountEnabled != null && this.accountEnabled == null) || 
				this.accountEnabled != null && (!this.accountEnabled.equals(accountEnabled) || accountEnabled == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountEnabled", this.accountEnabled);
        	}
        this.accountEnabled = accountEnabled;
    }
    
    public Integer getAccountLocked() {
        return this.accountLocked;
    }
    
    public void setAccountLocked(Integer accountLocked) {
    		if((accountLocked != null && this.accountLocked == null) || 
				this.accountLocked != null && (!this.accountLocked.equals(accountLocked) || accountLocked == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountLocked", this.accountLocked);
        	}
        this.accountLocked = accountLocked;
    }
    
    public Date getExpiredDate() {
        return this.expiredDate;
    }
    
    public void setExpiredDate(Date expiredDate) {
    		if((expiredDate != null && this.expiredDate == null) || 
				this.expiredDate != null && (!this.expiredDate.equals(expiredDate) || expiredDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("expiredDate", this.expiredDate);
        	}
        this.expiredDate = expiredDate;
    }
    
    public Integer getCredentialsExpired() {
        return this.credentialsExpired;
    }
    
    public void setCredentialsExpired(Integer credentialsExpired) {
    		if((credentialsExpired != null && this.credentialsExpired == null) || 
				this.credentialsExpired != null && (!this.credentialsExpired.equals(credentialsExpired) || credentialsExpired == null)){
        		this.setDirty(true);
        		this.oldValues.put("credentialsExpired", this.credentialsExpired);
        	}
        this.credentialsExpired = credentialsExpired;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
    		if((fullName != null && this.fullName == null) || 
				this.fullName != null && (!this.fullName.equals(fullName) || fullName == null)){
        		this.setDirty(true);
        		this.oldValues.put("fullName", this.fullName);
        	}
        this.fullName = fullName;
    }
    
    public HiOrg getOrg() {
        return this.org;
    }
    
    public void setOrg(HiOrg org) {
    		if((org != null && this.org == null) || 
				this.org != null && (!this.org.equals(org) || org == null)){
        		this.setDirty(true);
        		this.oldValues.put("org", this.org);
        	}
        this.org = org;
    }
    
    public Integer getGender() {
        return this.gender;
    }
    
    public void setGender(Integer gender) {
    		if((gender != null && this.gender == null) || 
				this.gender != null && (!this.gender.equals(gender) || gender == null)){
        		this.setDirty(true);
        		this.oldValues.put("gender", this.gender);
        	}
        this.gender = gender;
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
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
    		if((phone != null && this.phone == null) || 
				this.phone != null && (!this.phone.equals(phone) || phone == null)){
        		this.setDirty(true);
        		this.oldValues.put("phone", this.phone);
        	}
        this.phone = phone;
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
    
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
    		if((zip != null && this.zip == null) || 
				this.zip != null && (!this.zip.equals(zip) || zip == null)){
        		this.setDirty(true);
        		this.oldValues.put("zip", this.zip);
        	}
        this.zip = zip;
    }
    
    public String getSSN() {
        return this.SSN;
    }
    
    public void setSSN(String SSN) {
    		if((SSN != null && this.SSN == null) || 
				this.SSN != null && (!this.SSN.equals(SSN) || SSN == null)){
        		this.setDirty(true);
        		this.oldValues.put("SSN", this.SSN);
        	}
        this.SSN = SSN;
    }
    
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
    		if((mail != null && this.mail == null) || 
				this.mail != null && (!this.mail.equals(mail) || mail == null)){
        		this.setDirty(true);
        		this.oldValues.put("mail", this.mail);
        	}
        this.mail = mail;
    }
    
    public Integer getUserMgrType() {
        return this.userMgrType;
    }
    
    public void setUserMgrType(Integer userMgrType) {
    		if((userMgrType != null && this.userMgrType == null) || 
				this.userMgrType != null && (!this.userMgrType.equals(userMgrType) || userMgrType == null)){
        		this.setDirty(true);
        		this.oldValues.put("userMgrType", this.userMgrType);
        	}
        this.userMgrType = userMgrType;
    }
    
    public String getNotifyMode() {
        return this.notifyMode;
    }
    
    public void setNotifyMode(String notifyMode) {
    		if((notifyMode != null && this.notifyMode == null) || 
				this.notifyMode != null && (!this.notifyMode.equals(notifyMode) || notifyMode == null)){
        		this.setDirty(true);
        		this.oldValues.put("notifyMode", this.notifyMode);
        	}
        this.notifyMode = notifyMode;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
    		if((description != null && this.description == null) || 
				this.description != null && (!this.description.equals(description) || description == null)){
        		this.setDirty(true);
        		this.oldValues.put("description", this.description);
        	}
        this.description = description;
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
		 if ( !(other instanceof HiUser) ) return false;
		 HiUser castOther = ( HiUser ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("HiUser".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("userName", this.userName)
		.append("password", this.password)
		.append("country", this.country)
		.append("timeZone", this.timeZone)
		.append("fullName", this.fullName)
		.append("address", this.address)
		.append("phone", this.phone)
		.append("mobile", this.mobile)
		.append("zip", this.zip)
		.append("SSN", this.SSN)
		.append("mail", this.mail)
		.append("notifyMode", this.notifyMode)
		.append("description", this.description)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}