package cn.net.iccard.tx.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxTransfer;
import org.hi.framework.service.Manager;

public interface TblTxTransferManager extends Manager{
    
    public void saveTblTxTransfer(TblTxTransfer tblTxTransfer);

    public void removeTblTxTransferById(Integer id);

    public TblTxTransfer getTblTxTransferById(Integer id);

    public List<TblTxTransfer> getTblTxTransferList(PageInfo pageInfo);
    
    public void saveSecurityTblTxTransfer(TblTxTransfer tblTxTransfer);

    public void removeSecurityTblTxTransferById(Integer id);

    public TblTxTransfer getSecurityTblTxTransferById(Integer id);

    public List<TblTxTransfer> getSecurityTblTxTransferList(PageInfo pageInfo);    
}
