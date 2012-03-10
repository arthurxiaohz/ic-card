package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbPointRule;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbPointRuleManager;

public class TblMbPointRuleManagerImpl extends ManagerImpl implements TblMbPointRuleManager{
    
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
    
    public void saveTblMbPointRule(TblMbPointRule tblMbPointRule){
    	saveObject(tblMbPointRule);
    
    }

    public void removeTblMbPointRuleById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbPointRule getTblMbPointRuleById(Integer id){
   		return (TblMbPointRule) getObjectById(id);
    }

    public List<TblMbPointRule> getTblMbPointRuleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbPointRule(TblMbPointRule tblMbPointRule){
    	saveObject(tblMbPointRule);
    
    }

    public void removeSecurityTblMbPointRuleById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbPointRule getSecurityTblMbPointRuleById(Integer id){
   		return (TblMbPointRule) getObjectById(id);
    }

    public List<TblMbPointRule> getSecurityTblMbPointRuleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
