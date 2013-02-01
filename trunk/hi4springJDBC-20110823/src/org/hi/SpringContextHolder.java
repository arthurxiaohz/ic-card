/*    */ package org.hi;
/*    */ 
/*    */ import javax.servlet.ServletContext;
/*    */ import org.springframework.beans.BeansException;
/*    */ import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
/*    */ import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ import org.springframework.context.ApplicationContextAware;
/*    */ import org.springframework.web.context.WebApplicationContext;
/*    */ 
/*    */ public class SpringContextHolder
/*    */   implements ApplicationContextAware, BeanFactoryPostProcessor
/*    */ {
/*    */   private static ApplicationContext applicationContext;
/*    */ 
/*    */   public static Object getBean(String name)
/*    */   {
/* 24 */     return applicationContext.getBean(name);
/*    */   }
/*    */ 
/*    */   public static Object getBean(Class clzz) {
/* 28 */     return getBean(clzz.getName());
/*    */   }
/*    */ 
/*    */   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
/*    */   {
/* 33 */     applicationContext = applicationContext;
/*    */   }
/*    */ 
/*    */   public static ApplicationContext getApplicationContext() {
/* 37 */     return applicationContext;
/*    */   }
/*    */   public static ServletContext getServletContext() {
/* 40 */     if ((applicationContext instanceof WebApplicationContext)) {
/* 41 */       return ((WebApplicationContext)applicationContext).getServletContext();
/*    */     }
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */   public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
/*    */     throws BeansException
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.SpringContextHolder
 * JD-Core Version:    0.6.0
 */