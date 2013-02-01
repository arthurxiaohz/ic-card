/*     */ package org.hi.metadata.hsc.context.environment;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"username", "password", "url", "driverClass"})
/*     */ @XmlRootElement(name="connection")
/*     */ public class Connection
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String username;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String password;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String url;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String driverClass;
/*     */ 
/*     */   public String getUsername()
/*     */   {
/*  68 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String value)
/*     */   {
/*  80 */     this.username = value;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/*  92 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String value)
/*     */   {
/* 104 */     this.password = value;
/*     */   }
/*     */ 
/*     */   public String getUrl()
/*     */   {
/* 116 */     return this.url;
/*     */   }
/*     */ 
/*     */   public void setUrl(String value)
/*     */   {
/* 128 */     this.url = value;
/*     */   }
/*     */ 
/*     */   public String getDriverClass()
/*     */   {
/* 140 */     return this.driverClass;
/*     */   }
/*     */ 
/*     */   public void setDriverClass(String value)
/*     */   {
/* 152 */     this.driverClass = value;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.environment.Connection
 * JD-Core Version:    0.6.0
 */