/*    */ package org.hi.base.schedule.context;
/*    */ 
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.SchedulerFactory;
/*    */ import org.springframework.beans.factory.FactoryBean;
/*    */ import org.springframework.context.ApplicationEvent;
/*    */ import org.springframework.context.ApplicationListener;
/*    */ 
/*    */ public class ScheduleDefChangeListerner
/*    */   implements ApplicationListener
/*    */ {
/* 14 */   protected final Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   public void onApplicationEvent(ApplicationEvent event) {
/* 17 */     if ((event instanceof ScheduleDefChangeEvent))
/*    */       try {
/* 19 */         Object service = SpringContextHolder.getBean(SchedulerFactory.class.getName());
/* 20 */         SchedulerFactory schedulerFactory = null;
/* 21 */         if (!(service instanceof FactoryBean))
/* 22 */           schedulerFactory = (SchedulerFactory)SpringContextHolder.getBean("&" + SchedulerFactory.class.getName());
/*    */         else {
/* 24 */           schedulerFactory = (SchedulerFactory)service;
/*    */         }
/* 26 */         long startTime = System.currentTimeMillis();
/* 27 */         schedulerFactory.restart();
/* 28 */         long endTime = System.currentTimeMillis();
/* 29 */         if (this.log.isTraceEnabled())
/* 30 */           this.log.trace("restart scheduler: \n\t use:" + (
/* 31 */             endTime - startTime) + "ms");
/*    */       }
/*    */       catch (Exception e) {
/* 34 */         this.log.error("when restart scheduler problem:");
/* 35 */         e.printStackTrace();
/*    */       }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.context.ScheduleDefChangeListerner
 * JD-Core Version:    0.6.0
 */