package cn.net.iccard.tx.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxTransferRequest;
import org.hi.framework.service.Manager;

public interface TblTxTransferRequestManager extends Manager{
    
    public void saveTblTxTransferRequest(TblTxTransferRequest tblTxTransferRequest);

    public void removeTblTxTransferRequestById(Integer id);

    public TblTxTransferRequest getTblTxTransferRequestById(Integer id);

    public List<TblTxTransferRequest> getTblTxTransferRequestList(PageInfo pageInfo);
    
    public void saveSecurityTblTxTransferRequest(TblTxTransferRequest tblTxTransferRequest);

    public void removeSecurityTblTxTransferRequestById(Integer id);

    public TblTxTransferRequest getSecurityTblTxTransferRequestById(Integer id);

    public List<TblTxTransferRequest> getSecurityTblTxTransferRequestList(PageInfo pageInfo);    
}
