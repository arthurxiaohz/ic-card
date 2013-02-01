/*    */ package org.hi.metadata.hsc.context.environment;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="", propOrder={"homePath", "libraryDir"})
/*    */ @XmlRootElement(name="javaEnvironment")
/*    */ public class JavaEnvironment
/*    */ {
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected String homePath;
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected String libraryDir;
/*    */ 
/*    */   public String getHomePath()
/*    */   {
/* 60 */     return this.homePath;
/*    */   }
/*    */ 
/*    */   public void setHomePath(String value)
/*    */   {
/* 72 */     this.homePath = value;
/*    */   }
/*    */ 
/*    */   public String getLibraryDir()
/*    */   {
/* 84 */     return this.libraryDir;
/*    */   }
/*    */ 
/*    */   public void setLibraryDir(String value)
/*    */   {
/* 96 */     this.libraryDir = value;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.environment.JavaEnvironment
 * JD-Core Version:    0.6.0
 */