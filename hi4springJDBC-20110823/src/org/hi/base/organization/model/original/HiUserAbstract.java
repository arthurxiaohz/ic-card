/*     */ package org.hi.base.organization.model.original;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public abstract class HiUserAbstract extends BaseObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Integer id;
/*     */   protected Integer version;
/*     */   protected String userName;
/*     */   protected String password;
/*     */   protected Integer country;
/*     */   protected Integer timeZone;
/*     */   protected Integer accountEnabled;
/*     */   protected Integer accountLocked;
/*     */   protected Date expiredDate;
/*     */   protected Integer credentialsExpired;
/*     */   protected String fullName;
/*     */   private HiOrg org;
/*     */   protected Integer gender;
/*     */   protected String address;
/*     */   protected String phone;
/*     */   protected String mobile;
/*     */   protected String zip;
/*     */   protected String SSN;
/*     */   protected String mail;
/*     */   protected Integer userMgrType;
/*     */   protected String notifyMode;
/*     */   protected String description;
/*     */   protected HiUser creator;
/* 143 */   protected Integer deleted = Integer.valueOf(0);
/*     */ 
/*     */   public Integer getId()
/*     */   {
/* 147 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/* 151 */     if (((id != null) && (this.id == null)) || (
/* 152 */       (this.id != null) && ((!this.id.equals(id)) || (id == null)))) {
/* 153 */       setDirty(true);
/* 154 */       this.oldValues.put("id", this.id);
/*     */     }
/* 156 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getVersion() {
/* 160 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version) {
/* 164 */     if (((version != null) && (this.version == null)) || (
/* 165 */       (this.version != null) && ((!this.version.equals(version)) || (version == null)))) {
/* 166 */       setDirty(true);
/* 167 */       this.oldValues.put("version", this.version);
/*     */     }
/* 169 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getUserName() {
/* 173 */     return this.userName;
/*     */   }
/*     */ 
/*     */   public void setUserName(String userName) {
/* 177 */     if (((userName != null) && (this.userName == null)) || (
/* 178 */       (this.userName != null) && ((!this.userName.equals(userName)) || (userName == null)))) {
/* 179 */       setDirty(true);
/* 180 */       this.oldValues.put("userName", this.userName);
/*     */     }
/* 182 */     this.userName = userName;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/* 186 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/* 190 */     if (((password != null) && (this.password == null)) || (
/* 191 */       (this.password != null) && ((!this.password.equals(password)) || (password == null)))) {
/* 192 */       setDirty(true);
/* 193 */       this.oldValues.put("password", this.password);
/*     */     }
/* 195 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public Integer getCountry() {
/* 199 */     return this.country;
/*     */   }
/*     */ 
/*     */   public void setCountry(Integer country) {
/* 203 */     if (((country != null) && (this.country == null)) || (
/* 204 */       (this.country != null) && ((!this.country.equals(country)) || (country == null)))) {
/* 205 */       setDirty(true);
/* 206 */       this.oldValues.put("country", this.country);
/*     */     }
/* 208 */     this.country = country;
/*     */   }
/*     */ 
/*     */   public Integer getTimeZone() {
/* 212 */     return this.timeZone;
/*     */   }
/*     */ 
/*     */   public void setTimeZone(Integer timeZone) {
/* 216 */     if (((timeZone != null) && (this.timeZone == null)) || (
/* 217 */       (this.timeZone != null) && ((!this.timeZone.equals(timeZone)) || (timeZone == null)))) {
/* 218 */       setDirty(true);
/* 219 */       this.oldValues.put("timeZone", this.timeZone);
/*     */     }
/* 221 */     this.timeZone = timeZone;
/*     */   }
/*     */ 
/*     */   public Integer getAccountEnabled() {
/* 225 */     return this.accountEnabled;
/*     */   }
/*     */ 
/*     */   public void setAccountEnabled(Integer accountEnabled) {
/* 229 */     if (((accountEnabled != null) && (this.accountEnabled == null)) || (
/* 230 */       (this.accountEnabled != null) && ((!this.accountEnabled.equals(accountEnabled)) || (accountEnabled == null)))) {
/* 231 */       setDirty(true);
/* 232 */       this.oldValues.put("accountEnabled", this.accountEnabled);
/*     */     }
/* 234 */     this.accountEnabled = accountEnabled;
/*     */   }
/*     */ 
/*     */   public Integer getAccountLocked() {
/* 238 */     return this.accountLocked;
/*     */   }
/*     */ 
/*     */   public void setAccountLocked(Integer accountLocked) {
/* 242 */     if (((accountLocked != null) && (this.accountLocked == null)) || (
/* 243 */       (this.accountLocked != null) && ((!this.accountLocked.equals(accountLocked)) || (accountLocked == null)))) {
/* 244 */       setDirty(true);
/* 245 */       this.oldValues.put("accountLocked", this.accountLocked);
/*     */     }
/* 247 */     this.accountLocked = accountLocked;
/*     */   }
/*     */ 
/*     */   public Date getExpiredDate() {
/* 251 */     return this.expiredDate;
/*     */   }
/*     */ 
/*     */   public void setExpiredDate(Date expiredDate) {
/* 255 */     if (((expiredDate != null) && (this.expiredDate == null)) || (
/* 256 */       (this.expiredDate != null) && ((!this.expiredDate.equals(expiredDate)) || (expiredDate == null)))) {
/* 257 */       setDirty(true);
/* 258 */       this.oldValues.put("expiredDate", this.expiredDate);
/*     */     }
/* 260 */     this.expiredDate = expiredDate;
/*     */   }
/*     */ 
/*     */   public Integer getCredentialsExpired() {
/* 264 */     return this.credentialsExpired;
/*     */   }
/*     */ 
/*     */   public void setCredentialsExpired(Integer credentialsExpired) {
/* 268 */     if (((credentialsExpired != null) && (this.credentialsExpired == null)) || (
/* 269 */       (this.credentialsExpired != null) && ((!this.credentialsExpired.equals(credentialsExpired)) || (credentialsExpired == null)))) {
/* 270 */       setDirty(true);
/* 271 */       this.oldValues.put("credentialsExpired", this.credentialsExpired);
/*     */     }
/* 273 */     this.credentialsExpired = credentialsExpired;
/*     */   }
/*     */ 
/*     */   public String getFullName() {
/* 277 */     return this.fullName;
/*     */   }
/*     */ 
/*     */   public void setFullName(String fullName) {
/* 281 */     if (((fullName != null) && (this.fullName == null)) || (
/* 282 */       (this.fullName != null) && ((!this.fullName.equals(fullName)) || (fullName == null)))) {
/* 283 */       setDirty(true);
/* 284 */       this.oldValues.put("fullName", this.fullName);
/*     */     }
/* 286 */     this.fullName = fullName;
/*     */   }
/*     */ 
/*     */   public HiOrg getOrg() {
/* 290 */     return this.org;
/*     */   }
/*     */ 
/*     */   public void setOrg(HiOrg org) {
/* 294 */     if (((org != null) && (this.org == null)) || (
/* 295 */       (this.org != null) && ((!this.org.equals(org)) || (org == null)))) {
/* 296 */       setDirty(true);
/* 297 */       this.oldValues.put("org", this.org);
/*     */     }
/* 299 */     this.org = org;
/*     */   }
/*     */ 
/*     */   public Integer getGender() {
/* 303 */     return this.gender;
/*     */   }
/*     */ 
/*     */   public void setGender(Integer gender) {
/* 307 */     if (((gender != null) && (this.gender == null)) || (
/* 308 */       (this.gender != null) && ((!this.gender.equals(gender)) || (gender == null)))) {
/* 309 */       setDirty(true);
/* 310 */       this.oldValues.put("gender", this.gender);
/*     */     }
/* 312 */     this.gender = gender;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 316 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 320 */     if (((address != null) && (this.address == null)) || (
/* 321 */       (this.address != null) && ((!this.address.equals(address)) || (address == null)))) {
/* 322 */       setDirty(true);
/* 323 */       this.oldValues.put("address", this.address);
/*     */     }
/* 325 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getPhone() {
/* 329 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone) {
/* 333 */     if (((phone != null) && (this.phone == null)) || (
/* 334 */       (this.phone != null) && ((!this.phone.equals(phone)) || (phone == null)))) {
/* 335 */       setDirty(true);
/* 336 */       this.oldValues.put("phone", this.phone);
/*     */     }
/* 338 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getMobile() {
/* 342 */     return this.mobile;
/*     */   }
/*     */ 
/*     */   public void setMobile(String mobile) {
/* 346 */     if (((mobile != null) && (this.mobile == null)) || (
/* 347 */       (this.mobile != null) && ((!this.mobile.equals(mobile)) || (mobile == null)))) {
/* 348 */       setDirty(true);
/* 349 */       this.oldValues.put("mobile", this.mobile);
/*     */     }
/* 351 */     this.mobile = mobile;
/*     */   }
/*     */ 
/*     */   public String getZip() {
/* 355 */     return this.zip;
/*     */   }
/*     */ 
/*     */   public void setZip(String zip) {
/* 359 */     if (((zip != null) && (this.zip == null)) || (
/* 360 */       (this.zip != null) && ((!this.zip.equals(zip)) || (zip == null)))) {
/* 361 */       setDirty(true);
/* 362 */       this.oldValues.put("zip", this.zip);
/*     */     }
/* 364 */     this.zip = zip;
/*     */   }
/*     */ 
/*     */   public String getSSN() {
/* 368 */     return this.SSN;
/*     */   }
/*     */ 
/*     */   public void setSSN(String SSN) {
/* 372 */     if (((SSN != null) && (this.SSN == null)) || (
/* 373 */       (this.SSN != null) && ((!this.SSN.equals(SSN)) || (SSN == null)))) {
/* 374 */       setDirty(true);
/* 375 */       this.oldValues.put("SSN", this.SSN);
/*     */     }
/* 377 */     this.SSN = SSN;
/*     */   }
/*     */ 
/*     */   public String getMail() {
/* 381 */     return this.mail;
/*     */   }
/*     */ 
/*     */   public void setMail(String mail) {
/* 385 */     if (((mail != null) && (this.mail == null)) || (
/* 386 */       (this.mail != null) && ((!this.mail.equals(mail)) || (mail == null)))) {
/* 387 */       setDirty(true);
/* 388 */       this.oldValues.put("mail", this.mail);
/*     */     }
/* 390 */     this.mail = mail;
/*     */   }
/*     */ 
/*     */   public Integer getUserMgrType() {
/* 394 */     return this.userMgrType;
/*     */   }
/*     */ 
/*     */   public void setUserMgrType(Integer userMgrType) {
/* 398 */     if (((userMgrType != null) && (this.userMgrType == null)) || (
/* 399 */       (this.userMgrType != null) && ((!this.userMgrType.equals(userMgrType)) || (userMgrType == null)))) {
/* 400 */       setDirty(true);
/* 401 */       this.oldValues.put("userMgrType", this.userMgrType);
/*     */     }
/* 403 */     this.userMgrType = userMgrType;
/*     */   }
/*     */ 
/*     */   public String getNotifyMode() {
/* 407 */     return this.notifyMode;
/*     */   }
/*     */ 
/*     */   public void setNotifyMode(String notifyMode) {
/* 411 */     if (((notifyMode != null) && (this.notifyMode == null)) || (
/* 412 */       (this.notifyMode != null) && ((!this.notifyMode.equals(notifyMode)) || (notifyMode == null)))) {
/* 413 */       setDirty(true);
/* 414 */       this.oldValues.put("notifyMode", this.notifyMode);
/*     */     }
/* 416 */     this.notifyMode = notifyMode;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 420 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 424 */     if (((description != null) && (this.description == null)) || (
/* 425 */       (this.description != null) && ((!this.description.equals(description)) || (description == null)))) {
/* 426 */       setDirty(true);
/* 427 */       this.oldValues.put("description", this.description);
/*     */     }
/* 429 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public HiUser getCreator() {
/* 433 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(HiUser creator) {
/* 437 */     if (((creator != null) && (this.creator == null)) || (
/* 438 */       (this.creator != null) && ((!this.creator.equals(creator)) || (creator == null)))) {
/* 439 */       setDirty(true);
/* 440 */       this.oldValues.put("creator", this.creator);
/*     */     }
/* 442 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public Integer getDeleted() {
/* 446 */     return this.deleted;
/*     */   }
/*     */ 
/*     */   public void setDeleted(Integer deleted) {
/* 450 */     if (((deleted != null) && (this.deleted == null)) || (
/* 451 */       (this.deleted != null) && ((!this.deleted.equals(deleted)) || (deleted == null)))) {
/* 452 */       setDirty(true);
/* 453 */       this.oldValues.put("deleted", this.deleted);
/*     */     }
/* 455 */     this.deleted = deleted;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 461 */     if (this == other) return true;
/* 462 */     if (other == null) return false;
/* 463 */     if (!(other instanceof HiUser)) return false;
/* 464 */     HiUser castOther = (HiUser)other;
/*     */ 
/* 466 */     return (getId() == castOther.getId()) || ((getId() != null) && (castOther.getId() != null) && (getId().equals(castOther.getId())));
/*     */   }
/*     */ 
/*     */   public int hashCode() {
/* 470 */     HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
/* 471 */     hcb.append(getId());
/* 472 */     hcb.append("HiUser".hashCode());
/* 473 */     return hcb.toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 477 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
/* 478 */     sb.append("id", this.id)
/* 479 */       .append("userName", this.userName)
/* 480 */       .append("password", this.password)
/* 481 */       .append("country", this.country)
/* 482 */       .append("timeZone", this.timeZone)
/* 483 */       .append("fullName", this.fullName)
/* 484 */       .append("address", this.address)
/* 485 */       .append("phone", this.phone)
/* 486 */       .append("mobile", this.mobile)
/* 487 */       .append("zip", this.zip)
/* 488 */       .append("SSN", this.SSN)
/* 489 */       .append("mail", this.mail)
/* 490 */       .append("notifyMode", this.notifyMode)
/* 491 */       .append("description", this.description)
/* 492 */       .append("deleted", this.deleted);
/*     */ 
/* 494 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Serializable getPrimarykey() {
/* 498 */     return this.id;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.model.original.HiUserAbstract
 * JD-Core Version:    0.6.0
 */