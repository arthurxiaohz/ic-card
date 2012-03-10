package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbPointExchangeRule;
import org.hi.framework.service.Manager;

public interface TblMbPointExchangeRuleManager extends Manager{
    
    public void saveTblMbPointExchangeRule(TblMbPointExchangeRule tblMbPointExchangeRule);

    public void removeTblMbPointExchangeRuleById(Integer id);

    public TblMbPointExchangeRule getTblMbPointExchangeRuleById(Integer id);

    public List<TblMbPointExchangeRule> getTblMbPointExchangeRuleList(PageInfo pageInfo);
    
    public void saveSecurityTblMbPointExchangeRule(TblMbPointExchangeRule tblMbPointExchangeRule);

    public void removeSecurityTblMbPointExchangeRuleById(Integer id);

    public TblMbPointExchangeRule getSecurityTblMbPointExchangeRuleById(Integer id);

    public List<TblMbPointExchangeRule> getSecurityTblMbPointExchangeRuleList(PageInfo pageInfo);    
}
