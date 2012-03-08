package cn.net.iccard.bm.accounting.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.ActAccount;
import org.hi.framework.service.Manager;

public interface ActAccountManager extends Manager{
    
    public void saveActAccount(ActAccount actAccount);

    public void removeActAccountById(Integer id);

    public ActAccount getActAccountById(Integer id);

    public List<ActAccount> getActAccountList(PageInfo pageInfo);
    
    public void saveSecurityActAccount(ActAccount actAccount);

    public void removeSecurityActAccountById(Integer id);

    public ActAccount getSecurityActAccountById(Integer id);

    public List<ActAccount> getSecurityActAccountList(PageInfo pageInfo);    
}
