package cn.net.iccard.tx.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxPayMentResponse;
import org.hi.framework.service.Manager;

public interface TblTxPayMentResponseManager extends Manager{
    
    public void saveTblTxPayMentResponse(TblTxPayMentResponse tblTxPayMentResponse);

    public void removeTblTxPayMentResponseById(Integer id);

    public TblTxPayMentResponse getTblTxPayMentResponseById(Integer id);

    public List<TblTxPayMentResponse> getTblTxPayMentResponseList(PageInfo pageInfo);
    
    public void saveSecurityTblTxPayMentResponse(TblTxPayMentResponse tblTxPayMentResponse);

    public void removeSecurityTblTxPayMentResponseById(Integer id);

    public TblTxPayMentResponse getSecurityTblTxPayMentResponseById(Integer id);

    public List<TblTxPayMentResponse> getSecurityTblTxPayMentResponseList(PageInfo pageInfo);    
}
