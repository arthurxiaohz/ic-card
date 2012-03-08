package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbCoupon;
import org.hi.framework.service.Manager;

public interface TblMbCouponManager extends Manager{
    
    public void saveTblMbCoupon(TblMbCoupon tblMbCoupon);

    public void removeTblMbCouponById(Integer id);

    public TblMbCoupon getTblMbCouponById(Integer id);

    public List<TblMbCoupon> getTblMbCouponList(PageInfo pageInfo);
    
    public void saveSecurityTblMbCoupon(TblMbCoupon tblMbCoupon);

    public void removeSecurityTblMbCouponById(Integer id);

    public TblMbCoupon getSecurityTblMbCouponById(Integer id);

    public List<TblMbCoupon> getSecurityTblMbCouponList(PageInfo pageInfo);    
}
