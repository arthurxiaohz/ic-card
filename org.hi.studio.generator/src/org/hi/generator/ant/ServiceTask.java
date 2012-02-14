/*     */ package org.hi.generator.ant;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import org.apache.tools.ant.BuildException;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.metadata.hsc.context.ServiceFactory;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ 
/*     */ public class ServiceTask extends HiTask
/*     */ {
/*  27 */   private List services = new ArrayList();
/*     */   private String entities;
/*  31 */   private List<String> hscFileList = new ArrayList();
/*     */ 
/*     */   public ServiceTask(HiGeneraterToolTask parent)
/*     */   {
/*  22 */     super(parent);
/*     */   }
/*     */ 
/*     */   public List<String> getHscFileList()
/*     */   {
/*  66 */     return this.hscFileList;
/*     */   }
/*     */ 
/*     */   public void setHscFileList(List<String> hscFileList) {
/*  70 */     this.hscFileList = hscFileList;
/*     */   }
/*     */ 
/*     */   public List getServices()
/*     */   {
/*  78 */     if (this.services.size() == 0)
/*     */     {
/*  81 */       for (Iterator it = this.hscFileList.iterator(); it.hasNext(); ) {
/*  82 */         String filePath = (String)it.next();
/*     */         try {
/*  84 */           Service service = ServiceFactory.loadService(filePath);
/*  85 */           this.services.add(service);
/*     */         }
/*     */         catch (FileNotFoundException e) {
/*  88 */           throw new BuildException(filePath + "Not Found ", e);
/*     */         } catch (JAXBException e) {
/*  90 */           throw new BuildException("Problem while loading and parse " + filePath, e);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  96 */     return this.services;
/*     */   }
/*     */ 
/*     */   public List<String> getEntityNames()
/*     */   {
/* 103 */     if ((this.entities == null) || (this.entities.trim().equals(""))) {
/* 104 */       return null;
/*     */     }
/* 106 */     return StringUtils.strToArrayList(this.entities);
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 111 */     return "service";
/*     */   }
/*     */ 
/*     */   public String getEntities()
/*     */   {
/* 116 */     return this.entities;
/*     */   }
/*     */ 
/*     */   public void setEntities(String entities) {
/* 120 */     this.entities = entities;
/*     */   }
/*     */ 
/*     */   public Integer getSort()
/*     */   {
/* 125 */     return new Integer(0);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.ServiceTask
 * JD-Core Version:    0.6.0
 */