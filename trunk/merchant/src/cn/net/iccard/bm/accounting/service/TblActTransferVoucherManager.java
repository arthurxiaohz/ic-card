package cn.net.iccard.bm.accounting.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.TblActTransferVoucher;
import org.hi.framework.service.Manager;

public interface TblActTransferVoucherManager extends Manager{
    
    public void saveTblActTransferVoucher(TblActTransferVoucher tblActTransferVoucher);

    public void removeTblActTransferVoucherById(Integer id);

    public TblActTransferVoucher getTblActTransferVoucherById(Integer id);

    public List<TblActTransferVoucher> getTblActTransferVoucherList(PageInfo pageInfo);
    
    public void saveSecurityTblActTransferVoucher(TblActTransferVoucher tblActTransferVoucher);

    public void removeSecurityTblActTransferVoucherById(Integer id);

    public TblActTransferVoucher getSecurityTblActTransferVoucherById(Integer id);

    public List<TblActTransferVoucher> getSecurityTblActTransferVoucherList(PageInfo pageInfo);    
}
