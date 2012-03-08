package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbCouponDetail;
import org.hi.framework.service.Manager;

public interface TblMbCouponDetailManager extends Manager{
    
    public void saveTblMbCouponDetail(TblMbCouponDetail tblMbCouponDetail);

    public void removeTblMbCouponDetailById(Integer id);

    public TblMbCouponDetail getTblMbCouponDetailById(Integer id);

    public List<TblMbCouponDetail> getTblMbCouponDetailList(PageInfo pageInfo);
    
    public void saveSecurityTblMbCouponDetail(TblMbCouponDetail tblMbCouponDetail);

    public void removeSecurityTblMbCouponDetailById(Integer id);

    public TblMbCouponDetail getSecurityTblMbCouponDetailById(Integer id);

    public List<TblMbCouponDetail> getSecurityTblMbCouponDetailList(PageInfo pageInfo);    
}
