package org.hi.test.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.Staff;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.test.service.StaffManager;

public class StaffManagerImpl extends ManagerImpl implements StaffManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveStaff(Staff staff){
    	saveObject(staff);
    
    }

    public void removeStaffById(Integer id){
    	removeObjectById(id);
    	
    }

    public Staff getStaffById(Integer id){
   		return (Staff) getObjectById(id);
    }

    public List<Staff> getStaffList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityStaff(Staff staff){
    	saveObject(staff);
    
    }

    public void removeSecurityStaffById(Integer id){
    	removeObjectById(id);
    	
    }

    public Staff getSecurityStaffById(Integer id){
   		return (Staff) getObjectById(id);
    }

    public List<Staff> getSecurityStaffList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
