package cn.net.iccard.tx.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxSmsLog;
import org.hi.framework.service.Manager;

public interface TblTxSmsLogManager extends Manager{
    
    public void saveTblTxSmsLog(TblTxSmsLog tblTxSmsLog);

    public void removeTblTxSmsLogById(Integer id);

    public TblTxSmsLog getTblTxSmsLogById(Integer id);

    public List<TblTxSmsLog> getTblTxSmsLogList(PageInfo pageInfo);
    
    public void saveSecurityTblTxSmsLog(TblTxSmsLog tblTxSmsLog);

    public void removeSecurityTblTxSmsLogById(Integer id);

    public TblTxSmsLog getSecurityTblTxSmsLogById(Integer id);

    public List<TblTxSmsLog> getSecurityTblTxSmsLogList(PageInfo pageInfo);    
}
