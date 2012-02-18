package org.hi.base.schedule.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.SpringContextHolder;
import org.hi.base.schedule.SchedulerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ScheduleDefChangeListerner implements ApplicationListener {
	
	protected final Log log = LogFactory.getLog(getClass());
	  
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof ScheduleDefChangeEvent){
			try {
				Object service = SpringContextHolder.getBean(SchedulerFactory.class.getName());
				SchedulerFactory schedulerFactory = null;
				if(!(service instanceof FactoryBean))
					schedulerFactory = (SchedulerFactory)SpringContextHolder.getBean(BeanFactory.FACTORY_BEAN_PREFIX + SchedulerFactory.class.getName());
				else
					schedulerFactory = (SchedulerFactory)service;
				
				long startTime = System.currentTimeMillis();
				schedulerFactory.restart();
				long endTime = System.currentTimeMillis();
				if(log.isTraceEnabled()){
					log.trace("restart scheduler: \n\t use:" 
						+ (endTime - startTime) + "ms");
				}
			} catch (Exception e) {
				log.error("when restart scheduler problem:");
				e.printStackTrace();
			}
		}
	}


}
