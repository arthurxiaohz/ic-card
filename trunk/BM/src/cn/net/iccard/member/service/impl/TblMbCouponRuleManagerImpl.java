package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbCouponRule;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbCouponRuleManager;

public class TblMbCouponRuleManagerImpl extends ManagerImpl implements TblMbCouponRuleManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveTblMbCouponRule(TblMbCouponRule tblMbCouponRule){
    	saveObject(tblMbCouponRule);
    
    }

    public void removeTblMbCouponRuleById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbCouponRule getTblMbCouponRuleById(Integer id){
   		return (TblMbCouponRule) getObjectById(id);
    }

    public List<TblMbCouponRule> getTblMbCouponRuleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbCouponRule(TblMbCouponRule tblMbCouponRule){
    	saveObject(tblMbCouponRule);
    
    }

    public void removeSecurityTblMbCouponRuleById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbCouponRule getSecurityTblMbCouponRuleById(Integer id){
   		return (TblMbCouponRule) getObjectById(id);
    }

    public List<TblMbCouponRule> getSecurityTblMbCouponRuleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
