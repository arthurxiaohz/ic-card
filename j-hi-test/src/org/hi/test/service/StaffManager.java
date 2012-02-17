package org.hi.test.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.Staff;
import org.hi.framework.service.Manager;

public interface StaffManager extends Manager{
    
    public void saveStaff(Staff staff);

    public void removeStaffById(Integer id);

    public Staff getStaffById(Integer id);

    public List<Staff> getStaffList(PageInfo pageInfo);
    
    public void saveSecurityStaff(Staff staff);

    public void removeSecurityStaffById(Integer id);

    public Staff getSecurityStaffById(Integer id);

    public List<Staff> getSecurityStaffList(PageInfo pageInfo);    
}
