package cn.net.iccard.bm.accounting.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.TblActTransferVoucher;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager;

public class TblActTransferVoucherManagerImpl extends ManagerImpl implements TblActTransferVoucherManager{
    
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
    
    public void saveTblActTransferVoucher(TblActTransferVoucher tblActTransferVoucher){
    	saveObject(tblActTransferVoucher);
    
    }

    public void removeTblActTransferVoucherById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblActTransferVoucher getTblActTransferVoucherById(Integer id){
   		return (TblActTransferVoucher) getObjectById(id);
    }

    public List<TblActTransferVoucher> getTblActTransferVoucherList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblActTransferVoucher(TblActTransferVoucher tblActTransferVoucher){
    	saveObject(tblActTransferVoucher);
    
    }

    public void removeSecurityTblActTransferVoucherById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblActTransferVoucher getSecurityTblActTransferVoucherById(Integer id){
   		return (TblActTransferVoucher) getObjectById(id);
    }

    public List<TblActTransferVoucher> getSecurityTblActTransferVoucherList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
