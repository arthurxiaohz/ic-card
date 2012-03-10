package cn.net.iccard.bm.accounting.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.TblActDebitCreditVoucher;
import org.hi.framework.service.Manager;

public interface TblActDebitCreditVoucherManager extends Manager{
    
    public void saveTblActDebitCreditVoucher(TblActDebitCreditVoucher tblActDebitCreditVoucher);

    public void removeTblActDebitCreditVoucherById(Integer id);

    public TblActDebitCreditVoucher getTblActDebitCreditVoucherById(Integer id);

    public List<TblActDebitCreditVoucher> getTblActDebitCreditVoucherList(PageInfo pageInfo);
    
    public void saveSecurityTblActDebitCreditVoucher(TblActDebitCreditVoucher tblActDebitCreditVoucher);

    public void removeSecurityTblActDebitCreditVoucherById(Integer id);

    public TblActDebitCreditVoucher getSecurityTblActDebitCreditVoucherById(Integer id);

    public List<TblActDebitCreditVoucher> getSecurityTblActDebitCreditVoucherList(PageInfo pageInfo);    
}
