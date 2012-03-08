package cn.net.iccard.bm.settleservice.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlCleaningDetail;
import org.hi.framework.service.Manager;

public interface TblStlCleaningDetailManager extends Manager{
    
    public void saveTblStlCleaningDetail(TblStlCleaningDetail tblStlCleaningDetail);

    public void removeTblStlCleaningDetailById(Integer id);

    public TblStlCleaningDetail getTblStlCleaningDetailById(Integer id);

    public List<TblStlCleaningDetail> getTblStlCleaningDetailList(PageInfo pageInfo);
    
    public void saveSecurityTblStlCleaningDetail(TblStlCleaningDetail tblStlCleaningDetail);

    public void removeSecurityTblStlCleaningDetailById(Integer id);

    public TblStlCleaningDetail getSecurityTblStlCleaningDetailById(Integer id);

    public List<TblStlCleaningDetail> getSecurityTblStlCleaningDetailList(PageInfo pageInfo);    
}
