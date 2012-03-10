package cn.net.iccard.bm.settleservice.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import org.hi.framework.service.Manager;

public interface TblStlSettleBatchManager extends Manager{
    
    public void saveTblStlSettleBatch(TblStlSettleBatch tblStlSettleBatch);

    public void removeTblStlSettleBatchById(Integer id);

    public TblStlSettleBatch getTblStlSettleBatchById(Integer id);

    public List<TblStlSettleBatch> getTblStlSettleBatchList(PageInfo pageInfo);
    
    public void saveSecurityTblStlSettleBatch(TblStlSettleBatch tblStlSettleBatch);

    public void removeSecurityTblStlSettleBatchById(Integer id);

    public TblStlSettleBatch getSecurityTblStlSettleBatchById(Integer id);

    public List<TblStlSettleBatch> getSecurityTblStlSettleBatchList(PageInfo pageInfo);    
}
