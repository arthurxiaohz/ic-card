package cn.net.iccard.bm.checkservice.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlAdjustDetail;
import org.hi.framework.service.Manager;

public interface TblStlAdjustDetailManager extends Manager{
    
    public void saveTblStlAdjustDetail(TblStlAdjustDetail tblStlAdjustDetail);

    public void removeTblStlAdjustDetailById(Integer id);

    public TblStlAdjustDetail getTblStlAdjustDetailById(Integer id);

    public List<TblStlAdjustDetail> getTblStlAdjustDetailList(PageInfo pageInfo);
    
    public void saveSecurityTblStlAdjustDetail(TblStlAdjustDetail tblStlAdjustDetail);

    public void removeSecurityTblStlAdjustDetailById(Integer id);

    public TblStlAdjustDetail getSecurityTblStlAdjustDetailById(Integer id);

    public List<TblStlAdjustDetail> getSecurityTblStlAdjustDetailList(PageInfo pageInfo);    
}
