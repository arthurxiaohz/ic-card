package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbPointRule;
import org.hi.framework.service.Manager;

public interface TblMbPointRuleManager extends Manager{
    
    public void saveTblMbPointRule(TblMbPointRule tblMbPointRule);

    public void removeTblMbPointRuleById(Integer id);

    public TblMbPointRule getTblMbPointRuleById(Integer id);

    public List<TblMbPointRule> getTblMbPointRuleList(PageInfo pageInfo);
    
    public void saveSecurityTblMbPointRule(TblMbPointRule tblMbPointRule);

    public void removeSecurityTblMbPointRuleById(Integer id);

    public TblMbPointRule getSecurityTblMbPointRuleById(Integer id);

    public List<TblMbPointRule> getSecurityTblMbPointRuleList(PageInfo pageInfo);    
}
