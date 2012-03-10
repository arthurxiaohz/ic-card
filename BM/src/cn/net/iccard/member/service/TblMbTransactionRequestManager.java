package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbTransactionRequest;
import org.hi.framework.service.Manager;

public interface TblMbTransactionRequestManager extends Manager{
    
    public void saveTblMbTransactionRequest(TblMbTransactionRequest tblMbTransactionRequest);

    public void removeTblMbTransactionRequestById(Integer id);

    public TblMbTransactionRequest getTblMbTransactionRequestById(Integer id);

    public List<TblMbTransactionRequest> getTblMbTransactionRequestList(PageInfo pageInfo);
    
    public void saveSecurityTblMbTransactionRequest(TblMbTransactionRequest tblMbTransactionRequest);

    public void removeSecurityTblMbTransactionRequestById(Integer id);

    public TblMbTransactionRequest getSecurityTblMbTransactionRequestById(Integer id);

    public List<TblMbTransactionRequest> getSecurityTblMbTransactionRequestList(PageInfo pageInfo);    
}
