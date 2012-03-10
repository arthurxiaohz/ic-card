package cn.net.iccard.bm.checkservice.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlErrorDetail;
import org.hi.framework.service.Manager;

public interface TblStlErrorDetailManager extends Manager{
    
    public void saveTblStlErrorDetail(TblStlErrorDetail tblStlErrorDetail);

    public void removeTblStlErrorDetailById(Integer id);

    public TblStlErrorDetail getTblStlErrorDetailById(Integer id);

    public List<TblStlErrorDetail> getTblStlErrorDetailList(PageInfo pageInfo);
    
    public void saveSecurityTblStlErrorDetail(TblStlErrorDetail tblStlErrorDetail);

    public void removeSecurityTblStlErrorDetailById(Integer id);

    public TblStlErrorDetail getSecurityTblStlErrorDetailById(Integer id);

    public List<TblStlErrorDetail> getSecurityTblStlErrorDetailList(PageInfo pageInfo);    
}
