package cn.net.iccard.bm.checkservice.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlOrganization;
import org.hi.framework.service.Manager;

public interface TblStlOrganizationManager extends Manager{
    
    public void saveTblStlOrganization(TblStlOrganization tblStlOrganization);

    public void removeTblStlOrganizationById(Integer id);

    public TblStlOrganization getTblStlOrganizationById(Integer id);

    public List<TblStlOrganization> getTblStlOrganizationList(PageInfo pageInfo);
    
    public void saveSecurityTblStlOrganization(TblStlOrganization tblStlOrganization);

    public void removeSecurityTblStlOrganizationById(Integer id);

    public TblStlOrganization getSecurityTblStlOrganizationById(Integer id);

    public List<TblStlOrganization> getSecurityTblStlOrganizationList(PageInfo pageInfo);    
}
