/*    */ package org.hi.framework.context;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.core.io.Resource;
/*    */ 
/*    */ public class HiFrameworkConfig
/*    */ {
/* 18 */   protected final Log logger = LogFactory.getLog(HiFrameworkConfig.class);
/*    */   private Resource location;
/*    */ 
/*    */   public Properties getConfig()
/*    */   {
/* 26 */     Properties props = null;
/*    */     try
/*    */     {
/* 29 */       props = new Properties();
/* 30 */       this.logger.info("loading properties file :" + this.location.getFilename());
/* 31 */       InputStream is = this.location.getInputStream();
/* 32 */       props.load(is);
/* 33 */       is.close();
/*    */     } catch (IOException e) {
/* 35 */       this.logger.error("Unable to load " + this.location.getFilename(), e);
/* 36 */       return null;
/*    */     }
/*    */ 
/* 39 */     return props;
/*    */   }
/*    */ 
/*    */   public Resource getLocation()
/*    */   {
/* 44 */     return this.location;
/*    */   }
/*    */ 
/*    */   public void setLocation(Resource location) {
/* 48 */     this.location = location;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.context.HiFrameworkConfig
 * JD-Core Version:    0.6.0
 */