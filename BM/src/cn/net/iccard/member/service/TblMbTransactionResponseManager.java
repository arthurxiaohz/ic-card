package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbTransactionResponse;
import org.hi.framework.service.Manager;

public interface TblMbTransactionResponseManager extends Manager{
    
    public void saveTblMbTransactionResponse(TblMbTransactionResponse tblMbTransactionResponse);

    public void removeTblMbTransactionResponseById(Integer id);

    public TblMbTransactionResponse getTblMbTransactionResponseById(Integer id);

    public List<TblMbTransactionResponse> getTblMbTransactionResponseList(PageInfo pageInfo);
    
    public void saveSecurityTblMbTransactionResponse(TblMbTransactionResponse tblMbTransactionResponse);

    public void removeSecurityTblMbTransactionResponseById(Integer id);

    public TblMbTransactionResponse getSecurityTblMbTransactionResponseById(Integer id);

    public List<TblMbTransactionResponse> getSecurityTblMbTransactionResponseList(PageInfo pageInfo);    
}
