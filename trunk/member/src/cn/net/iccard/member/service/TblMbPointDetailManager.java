package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbPointDetail;
import org.hi.framework.service.Manager;

public interface TblMbPointDetailManager extends Manager{
    
    public void saveTblMbPointDetail(TblMbPointDetail tblMbPointDetail);

    public void removeTblMbPointDetailById(Integer id);

    public TblMbPointDetail getTblMbPointDetailById(Integer id);

    public List<TblMbPointDetail> getTblMbPointDetailList(PageInfo pageInfo);
    
    public void saveSecurityTblMbPointDetail(TblMbPointDetail tblMbPointDetail);

    public void removeSecurityTblMbPointDetailById(Integer id);

    public TblMbPointDetail getSecurityTblMbPointDetailById(Integer id);

    public List<TblMbPointDetail> getSecurityTblMbPointDetailList(PageInfo pageInfo);    
}
