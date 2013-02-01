/*    */ package org.hi.framework.spring;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.List;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.springframework.beans.factory.BeanDefinitionStoreException;
/*    */ import org.springframework.beans.factory.support.BeanDefinitionRegistry;
/*    */ import org.springframework.core.io.ByteArrayResource;
/*    */ import org.springframework.core.io.Resource;
/*    */ import org.springframework.core.io.support.EncodedResource;
/*    */ 
/*    */ public class XmlBeanDefinitionReader extends org.springframework.beans.factory.xml.XmlBeanDefinitionReader
/*    */ {
/*    */   public XmlBeanDefinitionReader(BeanDefinitionRegistry beanFactory)
/*    */   {
/* 19 */     super(beanFactory);
/*    */   }
/*    */   public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
/* 22 */     ByteArrayResource _resource = null;
/* 23 */     BufferedReader dis = null;
/*    */     try
/*    */     {
/* 26 */       dis = new BufferedReader(new InputStreamReader(resource.getInputStream()));
/* 27 */       StringBuffer sb = new StringBuffer();
/*    */       String line;
/* 29 */       while ((line = dis.readLine()) != null)
/*    */       {
/*    */         String line;
/* 30 */         if (!line.contains("${")) {
/* 31 */           sb.append(line).append("\n");
/*    */         }
/*    */         else
/*    */         {
/* 35 */           List dividList = StringUtils.dividToList(line, "${", "}");
/* 36 */           for (String divid : dividList)
/* 37 */             sb.append(HiConfigHolder.getProperty(divid) == null ? 
/* 38 */               divid : HiConfigHolder.getProperty(divid)); 
/*    */         }
/*    */       }
/* 40 */       _resource = new ByteArrayResource(sb.toString().getBytes("UTF-8"));
/*    */     }
/*    */     catch (IOException ex)
/*    */     {
/* 44 */       throw new BeanDefinitionStoreException(
/* 45 */         "IOException parsing XML document from " + resource, ex);
/*    */     }
/*    */     finally {
/* 48 */       if (dis != null) {
/*    */         try {
/* 50 */           dis.close();
/*    */         } catch (IOException e) {
/* 52 */           throw new BeanDefinitionStoreException(
/* 53 */             "IOException parsing XML document from " + resource, e);
/*    */         }
/*    */       }
/*    */     }
/* 57 */     return loadBeanDefinitions(new EncodedResource(_resource));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.spring.XmlBeanDefinitionReader
 * JD-Core Version:    0.6.0
 */