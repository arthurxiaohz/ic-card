package org.hi.base.organization.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiOrgPageInfo;

public class HiUserPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_userName;
 	protected  String  f_userName_op;
	protected  String  f_password;
 	protected  String  f_password_op;
	protected  Integer  f_country;
 	protected  String  f_country_op;
	protected  Integer  f_timeZone;
 	protected  String  f_timeZone_op;
	protected  Integer  f_accountEnabled;
 	protected  String  f_accountEnabled_op;
	protected  Integer  f_accountLocked;
 	protected  String  f_accountLocked_op;
	protected  Date  f_expiredDate;
 	protected  String  f_expiredDate_op;
	protected  Date  f_expiredDate01;
	protected  String  f_expiredDate01_op;
	protected  Integer  f_credentialsExpired;
 	protected  String  f_credentialsExpired_op;
	protected  String  f_fullName;
 	protected  String  f_fullName_op;
	protected  Integer  f_gender;
 	protected  String  f_gender_op;
	protected  String  f_address;
 	protected  String  f_address_op;
	protected  String  f_phone;
 	protected  String  f_phone_op;
	protected  String  f_mobile;
 	protected  String  f_mobile_op;
	protected  String  f_zip;
 	protected  String  f_zip_op;
	protected  String  f_sSN;
 	protected  String  f_sSN_op;
	protected  String  f_mail;
 	protected  String  f_mail_op;
	protected  Integer  f_userMgrType;
 	protected  String  f_userMgrType_op;
	protected  String  f_notifyMode;
 	protected  String  f_notifyMode_op;
	protected  String  f_description;
 	protected  String  f_description_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

 	protected  HiOrgPageInfo org;
 	protected  HiUserPageInfo creator;

    public Integer getF_id() {
        return this.f_id;
    }
    
    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }
    
    public String getF_id_op() {
        return this.f_id_op;
    }
    
    public void setF_id_op(String f_id_op) {
        this.f_id_op = f_id_op;
    }
   
    public String getF_userName() {
        return this.f_userName;
    }
    
    public void setF_userName(String f_userName) {
        this.f_userName = f_userName;
    }
    
    public String getF_userName_op() {
        return this.f_userName_op;
    }
    
    public void setF_userName_op(String f_userName_op) {
        this.f_userName_op = f_userName_op;
    }
   
    public String getF_password() {
        return this.f_password;
    }
    
    public void setF_password(String f_password) {
        this.f_password = f_password;
    }
    
    public String getF_password_op() {
        return this.f_password_op;
    }
    
    public void setF_password_op(String f_password_op) {
        this.f_password_op = f_password_op;
    }
   
    public Integer getF_country() {
        return this.f_country;
    }
    
    public void setF_country(Integer f_country) {
        this.f_country = f_country;
    }
    
    public String getF_country_op() {
        return this.f_country_op;
    }
    
    public void setF_country_op(String f_country_op) {
        this.f_country_op = f_country_op;
    }
   
    public Integer getF_timeZone() {
        return this.f_timeZone;
    }
    
    public void setF_timeZone(Integer f_timeZone) {
        this.f_timeZone = f_timeZone;
    }
    
    public String getF_timeZone_op() {
        return this.f_timeZone_op;
    }
    
    public void setF_timeZone_op(String f_timeZone_op) {
        this.f_timeZone_op = f_timeZone_op;
    }
   
    public Integer getF_accountEnabled() {
        return this.f_accountEnabled;
    }
    
    public void setF_accountEnabled(Integer f_accountEnabled) {
        this.f_accountEnabled = f_accountEnabled;
    }
    
    public String getF_accountEnabled_op() {
        return this.f_accountEnabled_op;
    }
    
    public void setF_accountEnabled_op(String f_accountEnabled_op) {
        this.f_accountEnabled_op = f_accountEnabled_op;
    }
   
    public Integer getF_accountLocked() {
        return this.f_accountLocked;
    }
    
    public void setF_accountLocked(Integer f_accountLocked) {
        this.f_accountLocked = f_accountLocked;
    }
    
    public String getF_accountLocked_op() {
        return this.f_accountLocked_op;
    }
    
    public void setF_accountLocked_op(String f_accountLocked_op) {
        this.f_accountLocked_op = f_accountLocked_op;
    }
   
    public Date getF_expiredDate() {
        return this.f_expiredDate;
    }
    
    public void setF_expiredDate(Date f_expiredDate) {
        this.f_expiredDate = f_expiredDate;
    }
    
    public String getF_expiredDate_op() {
        return this.f_expiredDate_op;
    }
    
    public void setF_expiredDate_op(String f_expiredDate_op) {
        this.f_expiredDate_op = f_expiredDate_op;
    }
    public Date getF_expiredDate01() {
        return this.f_expiredDate01;
    }
    
    public void setF_expiredDate01(Date f_expiredDate01) {
        this.f_expiredDate01 = f_expiredDate01;
    }
    
    public String getF_expiredDate01_op() {
        return this.f_expiredDate01_op;
    }
    
    public void setF_expiredDate01_op(String f_expiredDate01_op) {
        this.f_expiredDate01_op = f_expiredDate01_op;
    }
   
    public Integer getF_credentialsExpired() {
        return this.f_credentialsExpired;
    }
    
    public void setF_credentialsExpired(Integer f_credentialsExpired) {
        this.f_credentialsExpired = f_credentialsExpired;
    }
    
    public String getF_credentialsExpired_op() {
        return this.f_credentialsExpired_op;
    }
    
    public void setF_credentialsExpired_op(String f_credentialsExpired_op) {
        this.f_credentialsExpired_op = f_credentialsExpired_op;
    }
   
    public String getF_fullName() {
        return this.f_fullName;
    }
    
    public void setF_fullName(String f_fullName) {
        this.f_fullName = f_fullName;
    }
    
    public String getF_fullName_op() {
        return this.f_fullName_op;
    }
    
    public void setF_fullName_op(String f_fullName_op) {
        this.f_fullName_op = f_fullName_op;
    }
   
    public Integer getF_gender() {
        return this.f_gender;
    }
    
    public void setF_gender(Integer f_gender) {
        this.f_gender = f_gender;
    }
    
    public String getF_gender_op() {
        return this.f_gender_op;
    }
    
    public void setF_gender_op(String f_gender_op) {
        this.f_gender_op = f_gender_op;
    }
   
    public String getF_address() {
        return this.f_address;
    }
    
    public void setF_address(String f_address) {
        this.f_address = f_address;
    }
    
    public String getF_address_op() {
        return this.f_address_op;
    }
    
    public void setF_address_op(String f_address_op) {
        this.f_address_op = f_address_op;
    }
   
    public String getF_phone() {
        return this.f_phone;
    }
    
    public void setF_phone(String f_phone) {
        this.f_phone = f_phone;
    }
    
    public String getF_phone_op() {
        return this.f_phone_op;
    }
    
    public void setF_phone_op(String f_phone_op) {
        this.f_phone_op = f_phone_op;
    }
   
    public String getF_mobile() {
        return this.f_mobile;
    }
    
    public void setF_mobile(String f_mobile) {
        this.f_mobile = f_mobile;
    }
    
    public String getF_mobile_op() {
        return this.f_mobile_op;
    }
    
    public void setF_mobile_op(String f_mobile_op) {
        this.f_mobile_op = f_mobile_op;
    }
   
    public String getF_zip() {
        return this.f_zip;
    }
    
    public void setF_zip(String f_zip) {
        this.f_zip = f_zip;
    }
    
    public String getF_zip_op() {
        return this.f_zip_op;
    }
    
    public void setF_zip_op(String f_zip_op) {
        this.f_zip_op = f_zip_op;
    }
   
    public String getF_sSN() {
        return this.f_sSN;
    }
    
    public void setF_sSN(String f_sSN) {
        this.f_sSN = f_sSN;
    }
    
    public String getF_sSN_op() {
        return this.f_sSN_op;
    }
    
    public void setF_sSN_op(String f_sSN_op) {
        this.f_sSN_op = f_sSN_op;
    }
   
    public String getF_mail() {
        return this.f_mail;
    }
    
    public void setF_mail(String f_mail) {
        this.f_mail = f_mail;
    }
    
    public String getF_mail_op() {
        return this.f_mail_op;
    }
    
    public void setF_mail_op(String f_mail_op) {
        this.f_mail_op = f_mail_op;
    }
   
    public Integer getF_userMgrType() {
        return this.f_userMgrType;
    }
    
    public void setF_userMgrType(Integer f_userMgrType) {
        this.f_userMgrType = f_userMgrType;
    }
    
    public String getF_userMgrType_op() {
        return this.f_userMgrType_op;
    }
    
    public void setF_userMgrType_op(String f_userMgrType_op) {
        this.f_userMgrType_op = f_userMgrType_op;
    }
   
    public String getF_notifyMode() {
        return this.f_notifyMode;
    }
    
    public void setF_notifyMode(String f_notifyMode) {
        this.f_notifyMode = f_notifyMode;
    }
    
    public String getF_notifyMode_op() {
        return this.f_notifyMode_op;
    }
    
    public void setF_notifyMode_op(String f_notifyMode_op) {
        this.f_notifyMode_op = f_notifyMode_op;
    }
   
    public String getF_description() {
        return this.f_description;
    }
    
    public void setF_description(String f_description) {
        this.f_description = f_description;
    }
    
    public String getF_description_op() {
        return this.f_description_op;
    }
    
    public void setF_description_op(String f_description_op) {
        this.f_description_op = f_description_op;
    }
   
    public Integer getF_deleted() {
        return this.f_deleted;
    }
    
    public void setF_deleted(Integer f_deleted) {
        this.f_deleted = f_deleted;
    }
    
    public String getF_deleted_op() {
        return this.f_deleted_op;
    }
    
    public void setF_deleted_op(String f_deleted_op) {
        this.f_deleted_op = f_deleted_op;
    }
   
	public HiOrgPageInfo getOrg() {
		return org;
	}

	public void setOrg(HiOrgPageInfo org) {
		this.org = org;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
