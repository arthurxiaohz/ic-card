package cn.net.iccard.bm.mcht.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtUser;
import org.hi.base.organization.service.impl.HiUserManagerImpl;
import cn.net.iccard.bm.mcht.service.TblMchtUserManager;

public class TblMchtUserManagerImpl extends HiUserManagerImpl implements TblMchtUserManager{
    
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
    
    public void saveTblMchtUser(TblMchtUser tblMchtUser){
    	saveObject(tblMchtUser);
    
    }

    public void removeTblMchtUserById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtUser getTblMchtUserById(Integer id){
   		return (TblMchtUser) getObjectById(id);
    }

    public List<TblMchtUser> getTblMchtUserList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMchtUser(TblMchtUser tblMchtUser){
    	saveObject(tblMchtUser);
    
    }

    public void removeSecurityTblMchtUserById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtUser getSecurityTblMchtUserById(Integer id){
   		return (TblMchtUser) getObjectById(id);
    }

    public List<TblMchtUser> getSecurityTblMchtUserList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
