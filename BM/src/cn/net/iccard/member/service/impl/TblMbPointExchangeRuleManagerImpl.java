package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbPointExchangeRule;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbPointExchangeRuleManager;

public class TblMbPointExchangeRuleManagerImpl extends ManagerImpl implements TblMbPointExchangeRuleManager{
    
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
    
    public void saveTblMbPointExchangeRule(TblMbPointExchangeRule tblMbPointExchangeRule){
    	saveObject(tblMbPointExchangeRule);
    
    }

    public void removeTblMbPointExchangeRuleById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbPointExchangeRule getTblMbPointExchangeRuleById(Integer id){
   		return (TblMbPointExchangeRule) getObjectById(id);
    }

    public List<TblMbPointExchangeRule> getTblMbPointExchangeRuleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbPointExchangeRule(TblMbPointExchangeRule tblMbPointExchangeRule){
    	saveObject(tblMbPointExchangeRule);
    
    }

    public void removeSecurityTblMbPointExchangeRuleById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbPointExchangeRule getSecurityTblMbPointExchangeRuleById(Integer id){
   		return (TblMbPointExchangeRule) getObjectById(id);
    }

    public List<TblMbPointExchangeRule> getSecurityTblMbPointExchangeRuleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
