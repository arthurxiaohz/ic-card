package cn.net.iccard.bm.checkservice.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlCheckOrganizationControl;
import org.hi.framework.service.Manager;

public interface TblStlCheckOrganizationControlManager extends Manager{
    
    public void saveTblStlCheckOrganizationControl(TblStlCheckOrganizationControl tblStlCheckOrganizationControl);

    public void removeTblStlCheckOrganizationControlById(Integer id);

    public TblStlCheckOrganizationControl getTblStlCheckOrganizationControlById(Integer id);

    public List<TblStlCheckOrganizationControl> getTblStlCheckOrganizationControlList(PageInfo pageInfo);
    
    public void saveSecurityTblStlCheckOrganizationControl(TblStlCheckOrganizationControl tblStlCheckOrganizationControl);

    public void removeSecurityTblStlCheckOrganizationControlById(Integer id);

    public TblStlCheckOrganizationControl getSecurityTblStlCheckOrganizationControlById(Integer id);

    public List<TblStlCheckOrganizationControl> getSecurityTblStlCheckOrganizationControlList(PageInfo pageInfo);    
}
