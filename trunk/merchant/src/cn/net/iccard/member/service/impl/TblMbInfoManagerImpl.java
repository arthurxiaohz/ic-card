package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbInfo;
import org.hi.base.organization.service.impl.HiUserManagerImpl;
import cn.net.iccard.member.service.TblMbInfoManager;

public class TblMbInfoManagerImpl extends HiUserManagerImpl implements TblMbInfoManager{
    
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
    
    public void saveTblMbInfo(TblMbInfo tblMbInfo){
    	saveObject(tblMbInfo);
    
    }

    public void removeTblMbInfoById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbInfo getTblMbInfoById(Integer id){
   		return (TblMbInfo) getObjectById(id);
    }

    public List<TblMbInfo> getTblMbInfoList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbInfo(TblMbInfo tblMbInfo){
    	saveObject(tblMbInfo);
    
    }

    public void removeSecurityTblMbInfoById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbInfo getSecurityTblMbInfoById(Integer id){
   		return (TblMbInfo) getObjectById(id);
    }

    public List<TblMbInfo> getSecurityTblMbInfoList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
