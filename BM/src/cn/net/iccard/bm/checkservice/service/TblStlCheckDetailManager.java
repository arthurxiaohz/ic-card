package cn.net.iccard.bm.checkservice.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlCheckDetail;
import org.hi.framework.service.Manager;

public interface TblStlCheckDetailManager extends Manager{
    
    public void saveTblStlCheckDetail(TblStlCheckDetail tblStlCheckDetail);

    public void removeTblStlCheckDetailById(Integer id);

    public TblStlCheckDetail getTblStlCheckDetailById(Integer id);

    public List<TblStlCheckDetail> getTblStlCheckDetailList(PageInfo pageInfo);
    
    public void saveSecurityTblStlCheckDetail(TblStlCheckDetail tblStlCheckDetail);

    public void removeSecurityTblStlCheckDetailById(Integer id);

    public TblStlCheckDetail getSecurityTblStlCheckDetailById(Integer id);

    public List<TblStlCheckDetail> getSecurityTblStlCheckDetailList(PageInfo pageInfo);    
}
