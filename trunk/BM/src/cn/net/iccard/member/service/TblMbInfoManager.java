package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbInfo;
import org.hi.base.organization.service.HiUserManager;

public interface TblMbInfoManager extends HiUserManager{
    
    public void saveTblMbInfo(TblMbInfo tblMbInfo);

    public void removeTblMbInfoById(Integer id);

    public TblMbInfo getTblMbInfoById(Integer id);

    public List<TblMbInfo> getTblMbInfoList(PageInfo pageInfo);
    
    public void saveSecurityTblMbInfo(TblMbInfo tblMbInfo);

    public void removeSecurityTblMbInfoById(Integer id);

    public TblMbInfo getSecurityTblMbInfoById(Integer id);

    public List<TblMbInfo> getSecurityTblMbInfoList(PageInfo pageInfo);    
}
