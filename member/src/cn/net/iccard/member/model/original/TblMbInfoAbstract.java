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

public abstract class TblMbInfoAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 平台交易流水号
	 */	
 	protected  String plNo;

 	 /**
	 * 平台会员号
	 */	
 	protected  String userName;

 	 /**
	 * 交易类型
	 */	
 	protected  String certificateTypeId;

 	 /**
	 * 证件号码
	 */	
 	protected  String certificateNo;

 	 /**
	 * 真实姓名
	 */	
 	protected  String realName;

 	 /**
	 * 性别
	 */	
 	protected  String sex;

 	 /**
	 * 住址
	 */	
 	protected  String address;

 	 /**
	 * 邮政编码
	 */	
 	protected  String zipCode;

 	 /**
	 * 手机
	 */	
 	protected  String mobile;

 	 /**
	 * 固定电话
	 */	
 	protected  String phone;

 	 /**
	 * Email地址
	 */	
 	protected  String email;

 	 /**
	 * 登录密码
	 */	
 	protected  String password;

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
 	protected  Timestamp createdDatetime;

 	 /**
	 * 最后修改时间
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * 最后修改人
	 */	
 	protected  String lastUpdatedBy;

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
    
    public String getPlNo() {
        return this.plNo;
    }
    
    public void setPlNo(String plNo) {
    		if((plNo != null && this.plNo == null) || 
				this.plNo != null && (!this.plNo.equals(plNo) || plNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("plNo", this.plNo);
        	}
        this.plNo = plNo;
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
    
    public String getCertificateNo() {
        return this.certificateNo;
    }
    
    public void setCertificateNo(String certificateNo) {
    		if((certificateNo != null && this.certificateNo == null) || 
				this.certificateNo != null && (!this.certificateNo.equals(certificateNo) || certificateNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("certificateNo", this.certificateNo);
        	}
        this.certificateNo = certificateNo;
    }
    
    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String realName) {
    		if((realName != null && this.realName == null) || 
				this.realName != null && (!this.realName.equals(realName) || realName == null)){
        		this.setDirty(true);
        		this.oldValues.put("realName", this.realName);
        	}
        this.realName = realName;
    }
    
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
    		if((sex != null && this.sex == null) || 
				this.sex != null && (!this.sex.equals(sex) || sex == null)){
        		this.setDirty(true);
        		this.oldValues.put("sex", this.sex);
        	}
        this.sex = sex;
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
    
    public String getZipCode() {
        return this.zipCode;
    }
    
    public void setZipCode(String zipCode) {
    		if((zipCode != null && this.zipCode == null) || 
				this.zipCode != null && (!this.zipCode.equals(zipCode) || zipCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("zipCode", this.zipCode);
        	}
        this.zipCode = zipCode;
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
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
    		if((email != null && this.email == null) || 
				this.email != null && (!this.email.equals(email) || email == null)){
        		this.setDirty(true);
        		this.oldValues.put("email", this.email);
        	}
        this.email = email;
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
    
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(String lastUpdatedBy) {
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
        hcb.append(getId());
		hcb.append("TblMbInfo".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("plNo", this.plNo)
		.append("userName", this.userName)
		.append("certificateTypeId", this.certificateTypeId)
		.append("certificateNo", this.certificateNo)
		.append("realName", this.realName)
		.append("sex", this.sex)
		.append("address", this.address)
		.append("zipCode", this.zipCode)
		.append("mobile", this.mobile)
		.append("phone", this.phone)
		.append("email", this.email)
		.append("password", this.password)
		.append("cardNo", this.cardNo)
		.append("realNameStatus", this.realNameStatus)
		.append("realNameTime", this.realNameTime)
		.append("registerTime", this.registerTime)
		.append("registerWay", this.registerWay)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}