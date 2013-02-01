/*     */ package org.hi.metadata.hsc.context.environment;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"appName", "orgPackage", "templetDir", "srcOutput", "standardOutput"})
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
/*     */   public String getAppName()
/*     */   {
/*  72 */     return this.appName;
/*     */   }
/*     */ 
/*     */   public void setAppName(String value)
/*     */   {
/*  84 */     this.appName = value;
/*     */   }
/*     */ 
/*     */   public String getOrgPackage()
/*     */   {
/*  96 */     return this.orgPackage;
/*     */   }
/*     */ 
/*     */   public void setOrgPackage(String value)
/*     */   {
/* 108 */     this.orgPackage = value;
/*     */   }
/*     */ 
/*     */   public String getTempletDir()
/*     */   {
/* 120 */     return this.templetDir;
/*     */   }
/*     */ 
/*     */   public void setTempletDir(String value)
/*     */   {
/* 132 */     this.templetDir = value;
/*     */   }
/*     */ 
/*     */   public String getSrcOutput()
/*     */   {
/* 144 */     return this.srcOutput;
/*     */   }
/*     */ 
/*     */   public void setSrcOutput(String value)
/*     */   {
/* 156 */     this.srcOutput = value;
/*     */   }
/*     */ 
/*     */   public String getStandardOutput()
/*     */   {
/* 168 */     return this.standardOutput;
/*     */   }
/*     */ 
/*     */   public void setStandardOutput(String value)
/*     */   {
/* 180 */     this.standardOutput = value;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.metadata.hsc.context.environment.Generate
 * JD-Core Version:    0.6.0
 */