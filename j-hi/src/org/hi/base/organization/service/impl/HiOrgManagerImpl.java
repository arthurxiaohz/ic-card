package org.hi.base.organization.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.organization.model.HiOrg;
import org.hi.framework.security.context.SecurityOrgFilterEvent;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.organization.service.HiOrgManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class HiOrgManagerImpl extends ManagerImpl implements HiOrgManager, ApplicationEventPublisherAware{
	private ApplicationEventPublisher applicationEventPublisher;
	
	protected void postSaveObject(Object obj) {
		if(obj instanceof HiOrg  && ((HiOrg)obj).isDirty())
			publishEvent(obj);
		super.postSaveObject(obj);
	}
	
	protected void postRemoveObject(Object obj) {
		if(obj instanceof HiOrg)
			publishEvent(obj);
		super.postRemoveObject(obj);
	}
	
	protected void publishEvent(Object obj){
        if ( applicationEventPublisher != null ) {
        	SecurityOrgFilterEvent event = new SecurityOrgFilterEvent(obj);
            applicationEventPublisher.publishEvent( event );
        }
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
    protected void preSaveObject(Object obj) {
    	HiOrg org = (HiOrg)obj;
    	if(org.getCreator() == null)
    		org.setCreator(UserContextHelper.getUser());
        super.preSaveObject(obj);

    }
    
    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }
   
    public void saveHiOrg(HiOrg HiOrg){
    	saveObject(HiOrg);
    
    }

    public void removeHiOrgById(Integer id){
    	removeObjectById(id);
    	
    }

    public HiOrg getHiOrgById(Integer id){
   		return (HiOrg) getObjectById(id);
    }

    public List<HiOrg> getHiOrgList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityHiOrg(HiOrg hiOrg){
    	saveObject(hiOrg);
    }
    public void removeSecurityHiOrgById(Integer id){
    	removeObjectById(id);
    }
    public HiOrg getSecurityHiOrgById(Integer id){
    	return (HiOrg) getObjectById(id);
    }
    public List<HiOrg> getSecurityHiOrgList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
