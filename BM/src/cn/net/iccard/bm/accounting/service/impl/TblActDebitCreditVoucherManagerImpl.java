package cn.net.iccard.bm.accounting.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.TblActDebitCreditVoucher;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.accounting.service.TblActDebitCreditVoucherManager;

public class TblActDebitCreditVoucherManagerImpl extends ManagerImpl implements TblActDebitCreditVoucherManager{
    
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
    
    public void saveTblActDebitCreditVoucher(TblActDebitCreditVoucher tblActDebitCreditVoucher){
    	saveObject(tblActDebitCreditVoucher);
    
    }

    public void removeTblActDebitCreditVoucherById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblActDebitCreditVoucher getTblActDebitCreditVoucherById(Integer id){
   		return (TblActDebitCreditVoucher) getObjectById(id);
    }

    public List<TblActDebitCreditVoucher> getTblActDebitCreditVoucherList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblActDebitCreditVoucher(TblActDebitCreditVoucher tblActDebitCreditVoucher){
    	saveObject(tblActDebitCreditVoucher);
    
    }

    public void removeSecurityTblActDebitCreditVoucherById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblActDebitCreditVoucher getSecurityTblActDebitCreditVoucherById(Integer id){
   		return (TblActDebitCreditVoucher) getObjectById(id);
    }

    public List<TblActDebitCreditVoucher> getSecurityTblActDebitCreditVoucherList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
