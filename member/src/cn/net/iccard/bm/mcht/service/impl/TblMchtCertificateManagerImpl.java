package cn.net.iccard.bm.mcht.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtCertificate;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.mcht.service.TblMchtCertificateManager;

public class TblMchtCertificateManagerImpl extends ManagerImpl implements TblMchtCertificateManager{
    
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
    
    public void saveTblMchtCertificate(TblMchtCertificate tblMchtCertificate){
    	saveObject(tblMchtCertificate);
    
    }

    public void removeTblMchtCertificateById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtCertificate getTblMchtCertificateById(Integer id){
   		return (TblMchtCertificate) getObjectById(id);
    }

    public List<TblMchtCertificate> getTblMchtCertificateList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMchtCertificate(TblMchtCertificate tblMchtCertificate){
    	saveObject(tblMchtCertificate);
    
    }

    public void removeSecurityTblMchtCertificateById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtCertificate getSecurityTblMchtCertificateById(Integer id){
   		return (TblMchtCertificate) getObjectById(id);
    }

    public List<TblMchtCertificate> getSecurityTblMchtCertificateList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
