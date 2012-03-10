package cn.net.iccard.bm.accounting.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.service.ActAccountManager;

public interface TblActAccountBalanceManager extends ActAccountManager{
    
    public void saveTblActAccountBalance(TblActAccountBalance tblActAccountBalance);

    public void removeTblActAccountBalanceById(Integer id);

    public TblActAccountBalance getTblActAccountBalanceById(Integer id);

    public List<TblActAccountBalance> getTblActAccountBalanceList(PageInfo pageInfo);
    
    public void saveSecurityTblActAccountBalance(TblActAccountBalance tblActAccountBalance);

    public void removeSecurityTblActAccountBalanceById(Integer id);

    public TblActAccountBalance getSecurityTblActAccountBalanceById(Integer id);

    public List<TblActAccountBalance> getSecurityTblActAccountBalanceList(PageInfo pageInfo);    
}
