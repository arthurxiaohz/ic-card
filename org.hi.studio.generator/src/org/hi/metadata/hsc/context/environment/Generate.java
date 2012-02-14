/*     */ package org.hi.metadata.hsc.context.environment;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"appName", "orgPackage", "templetDir", "srcOutput", "standardOutput", "ormType", "viewType", "pageFrameType"})
/*     */ @XmlRootElement(name="generate")
/*     */ public class Generate
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String appName;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String orgPackage;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String templetDir;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String srcOutput;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String standardOutput;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String ormType;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String viewType;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String pageFrameType;
/*     */ 
/*     */   public String getViewType()
/*     */   {
/*  73 */     return this.viewType;
/*     */   }
/*     */ 
/*     */   public void setViewType(String viewType) {
/*  77 */     this.viewType = viewType;
/*     */   }
/*     */ 
/*     */   public String getOrmType() {
/*  81 */     return this.ormType;
/*     */   }
/*     */ 
/*     */   public void setOrmType(String ormType) {
/*  85 */     this.ormType = ormType;
/*     */   }
/*     */ 
/*     */   public String getAppName()
/*     */   {
/*  97 */     return this.appName;
/*     */   }
/*     */ 
/*     */   public void setAppName(String value)
/*     */   {
/* 109 */     this.appName = value;
/*     */   }
/*     */ 
/*     */   public String getOrgPackage()
/*     */   {
/* 121 */     return this.orgPackage;
/*     */   }
/*     */ 
/*     */   public void setOrgPackage(String value)
/*     */   {
/* 133 */     this.orgPackage = value;
/*     */   }
/*     */ 
/*     */   public String getTempletDir()
/*     */   {
/* 145 */     return this.templetDir;
/*     */   }
/*     */ 
/*     */   public void setTempletDir(String value)
/*     */   {
/* 157 */     this.templetDir = value;
/*     */   }
/*     */ 
/*     */   public String getSrcOutput()
/*     */   {
/* 169 */     return this.srcOutput;
/*     */   }
/*     */ 
/*     */   public void setSrcOutput(String value)
/*     */   {
/* 181 */     this.srcOutput = value;
/*     */   }
/*     */ 
/*     */   public String getStandardOutput()
/*     */   {
/* 193 */     return this.standardOutput;
/*     */   }
/*     */ 
/*     */   public void setStandardOutput(String value)
/*     */   {
/* 205 */     this.standardOutput = value;
/*     */   }
/*     */ 
/*     */   public String getPageFrameType() {
/* 209 */     return this.pageFrameType;
/*     */   }
/*     */ 
/*     */   public void setPageFrameType(String pageFrameType) {
/* 213 */     this.pageFrameType = pageFrameType;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.metadata.hsc.context.environment.Generate
 * JD-Core Version:    0.6.0
 */