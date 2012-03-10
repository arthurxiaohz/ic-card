package cn.net.iccard.tx.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import org.hi.framework.service.Manager;

public interface TblTxPayMentRequestManager extends Manager{
    
    public void saveTblTxPayMentRequest(TblTxPayMentRequest tblTxPayMentRequest);

    public void removeTblTxPayMentRequestById(Integer id);

    public TblTxPayMentRequest getTblTxPayMentRequestById(Integer id);

    public List<TblTxPayMentRequest> getTblTxPayMentRequestList(PageInfo pageInfo);
    
    public void saveSecurityTblTxPayMentRequest(TblTxPayMentRequest tblTxPayMentRequest);

    public void removeSecurityTblTxPayMentRequestById(Integer id);

    public TblTxPayMentRequest getSecurityTblTxPayMentRequestById(Integer id);

    public List<TblTxPayMentRequest> getSecurityTblTxPayMentRequestList(PageInfo pageInfo);    
}
