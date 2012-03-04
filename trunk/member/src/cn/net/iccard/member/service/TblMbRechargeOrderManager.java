package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbRechargeOrder;
import org.hi.framework.service.Manager;

public interface TblMbRechargeOrderManager extends Manager{
    
    public void saveTblMbRechargeOrder(TblMbRechargeOrder tblMbRechargeOrder);

    public void removeTblMbRechargeOrderById(Integer id);

    public TblMbRechargeOrder getTblMbRechargeOrderById(Integer id);

    public List<TblMbRechargeOrder> getTblMbRechargeOrderList(PageInfo pageInfo);
    
    public void saveSecurityTblMbRechargeOrder(TblMbRechargeOrder tblMbRechargeOrder);

    public void removeSecurityTblMbRechargeOrderById(Integer id);

    public TblMbRechargeOrder getSecurityTblMbRechargeOrderById(Integer id);

    public List<TblMbRechargeOrder> getSecurityTblMbRechargeOrderList(PageInfo pageInfo);    
}
