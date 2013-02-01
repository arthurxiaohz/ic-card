/*    */ package org.hi.framework.spring;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.springframework.beans.factory.support.DefaultListableBeanFactory;
/*    */ import org.springframework.beans.factory.xml.ResourceEntityResolver;
/*    */ 
/*    */ public class XmlWebApplicationContext extends org.springframework.web.context.support.XmlWebApplicationContext
/*    */ {
/*    */   protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
/*    */     throws IOException
/*    */   {
/* 12 */     XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
/*    */ 
/* 16 */     beanDefinitionReader.setResourceLoader(this);
/* 17 */     beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));
/*    */ 
/* 21 */     initBeanDefinitionReader(beanDefinitionReader);
/* 22 */     loadBeanDefinitions(beanDefinitionReader);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.spring.XmlWebApplicationContext
 * JD-Core Version:    0.6.0
 */