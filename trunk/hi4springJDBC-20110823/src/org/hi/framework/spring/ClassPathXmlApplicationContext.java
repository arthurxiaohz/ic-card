/*    */ package org.hi.framework.spring;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.springframework.beans.BeansException;
/*    */ import org.springframework.beans.factory.support.DefaultListableBeanFactory;
/*    */ import org.springframework.beans.factory.xml.ResourceEntityResolver;
/*    */ 
/*    */ public class ClassPathXmlApplicationContext extends org.springframework.context.support.ClassPathXmlApplicationContext
/*    */ {
/*    */   public ClassPathXmlApplicationContext(String configLocation)
/*    */     throws BeansException
/*    */   {
/* 15 */     super(configLocation);
/*    */   }
/*    */   public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
/* 18 */     super(configLocations, null);
/*    */   }
/*    */ 
/*    */   protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws IOException
/*    */   {
/* 23 */     XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
/*    */ 
/* 27 */     beanDefinitionReader.setResourceLoader(this);
/* 28 */     beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));
/*    */ 
/* 32 */     initBeanDefinitionReader(beanDefinitionReader);
/* 33 */     loadBeanDefinitions(beanDefinitionReader);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.spring.ClassPathXmlApplicationContext
 * JD-Core Version:    0.6.0
 */