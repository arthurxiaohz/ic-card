package cn.net.iccard.bm.settleservice.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlSettleApply;
import org.hi.framework.service.Manager;

public interface TblStlSettleApplyManager extends Manager{
    
    public void saveTblStlSettleApply(TblStlSettleApply tblStlSettleApply);

    public void removeTblStlSettleApplyById(Integer id);

    public TblStlSettleApply getTblStlSettleApplyById(Integer id);

    public List<TblStlSettleApply> getTblStlSettleApplyList(PageInfo pageInfo);
    
    public void saveSecurityTblStlSettleApply(TblStlSettleApply tblStlSettleApply);

    public void removeSecurityTblStlSettleApplyById(Integer id);

    public TblStlSettleApply getSecurityTblStlSettleApplyById(Integer id);

    public List<TblStlSettleApply> getSecurityTblStlSettleApplyList(PageInfo pageInfo);    
}
