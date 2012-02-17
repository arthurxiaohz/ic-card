/*     */ package org.hi.metadata.hsc.context.environment;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"database", "javaEnvironment", "generate"})
/*     */ @XmlRootElement(name="environment")
/*     */ public class Environment
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected Database database;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected JavaEnvironment javaEnvironment;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected Generate generate;
/*     */ 
/*     */   @XmlAttribute(required=true)
/*     */   protected String dir;
/*     */ 
/*     */   public Database getDatabase()
/*     */   {
/*  68 */     return this.database;
/*     */   }
/*     */ 
/*     */   public void setDatabase(Database value)
/*     */   {
/*  80 */     this.database = value;
/*     */   }
/*     */ 
/*     */   public JavaEnvironment getJavaEnvironment()
/*     */   {
/*  92 */     return this.javaEnvironment;
/*     */   }
/*     */ 
/*     */   public void setJavaEnvironment(JavaEnvironment value)
/*     */   {
/* 104 */     this.javaEnvironment = value;
/*     */   }
/*     */ 
/*     */   public Generate getGenerate()
/*     */   {
/* 116 */     return this.generate;
/*     */   }
/*     */ 
/*     */   public void setGenerate(Generate value)
/*     */   {
/* 128 */     this.generate = value;
/*     */   }
/*     */ 
/*     */   public String getDir()
/*     */   {
/* 140 */     return this.dir;
/*     */   }
/*     */ 
/*     */   public void setDir(String value)
/*     */   {
/* 152 */     this.dir = value;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.metadata.hsc.context.environment.Environment
 * JD-Core Version:    0.6.0
 */