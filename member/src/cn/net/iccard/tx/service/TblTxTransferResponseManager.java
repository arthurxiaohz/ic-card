package cn.net.iccard.tx.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxTransferResponse;
import org.hi.framework.service.Manager;

public interface TblTxTransferResponseManager extends Manager{
    
    public void saveTblTxTransferResponse(TblTxTransferResponse tblTxTransferResponse);

    public void removeTblTxTransferResponseById(Integer id);

    public TblTxTransferResponse getTblTxTransferResponseById(Integer id);

    public List<TblTxTransferResponse> getTblTxTransferResponseList(PageInfo pageInfo);
    
    public void saveSecurityTblTxTransferResponse(TblTxTransferResponse tblTxTransferResponse);

    public void removeSecurityTblTxTransferResponseById(Integer id);

    public TblTxTransferResponse getSecurityTblTxTransferResponseById(Integer id);

    public List<TblTxTransferResponse> getSecurityTblTxTransferResponseList(PageInfo pageInfo);    
}
