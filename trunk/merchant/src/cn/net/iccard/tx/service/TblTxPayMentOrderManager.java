package cn.net.iccard.tx.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import org.hi.framework.service.Manager;

public interface TblTxPayMentOrderManager extends Manager{
    
    public void saveTblTxPayMentOrder(TblTxPayMentOrder tblTxPayMentOrder);

    public void removeTblTxPayMentOrderById(Integer id);

    public TblTxPayMentOrder getTblTxPayMentOrderById(Integer id);

    public List<TblTxPayMentOrder> getTblTxPayMentOrderList(PageInfo pageInfo);
    
    public void saveSecurityTblTxPayMentOrder(TblTxPayMentOrder tblTxPayMentOrder);

    public void removeSecurityTblTxPayMentOrderById(Integer id);

    public TblTxPayMentOrder getSecurityTblTxPayMentOrderById(Integer id);

    public List<TblTxPayMentOrder> getSecurityTblTxPayMentOrderList(PageInfo pageInfo);    
}
