package cn.net.iccard.bm.accounting.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.TblActAccountDetail;
import org.hi.framework.service.Manager;

public interface TblActAccountDetailManager extends Manager{
    
    public void saveTblActAccountDetail(TblActAccountDetail tblActAccountDetail);

    public void removeTblActAccountDetailById(Integer id);

    public TblActAccountDetail getTblActAccountDetailById(Integer id);

    public List<TblActAccountDetail> getTblActAccountDetailList(PageInfo pageInfo);
    
    public void saveSecurityTblActAccountDetail(TblActAccountDetail tblActAccountDetail);

    public void removeSecurityTblActAccountDetailById(Integer id);

    public TblActAccountDetail getSecurityTblActAccountDetailById(Integer id);

    public List<TblActAccountDetail> getSecurityTblActAccountDetailList(PageInfo pageInfo);    
}
