package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbCouponRule;
import org.hi.framework.service.Manager;

public interface TblMbCouponRuleManager extends Manager{
    
    public void saveTblMbCouponRule(TblMbCouponRule tblMbCouponRule);

    public void removeTblMbCouponRuleById(Integer id);

    public TblMbCouponRule getTblMbCouponRuleById(Integer id);

    public List<TblMbCouponRule> getTblMbCouponRuleList(PageInfo pageInfo);
    
    public void saveSecurityTblMbCouponRule(TblMbCouponRule tblMbCouponRule);

    public void removeSecurityTblMbCouponRuleById(Integer id);

    public TblMbCouponRule getSecurityTblMbCouponRuleById(Integer id);

    public List<TblMbCouponRule> getSecurityTblMbCouponRuleList(PageInfo pageInfo);    
}
