package cn.net.iccard.bm.mcht.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import org.hi.framework.service.Manager;

public interface TblMchtInfoManager extends Manager{
    
    public void saveTblMchtInfo(TblMchtInfo tblMchtInfo);

    public void removeTblMchtInfoById(Integer id);

    public TblMchtInfo getTblMchtInfoById(Integer id);

    public List<TblMchtInfo> getTblMchtInfoList(PageInfo pageInfo);
    
    public void saveSecurityTblMchtInfo(TblMchtInfo tblMchtInfo);

    public void removeSecurityTblMchtInfoById(Integer id);

    public TblMchtInfo getSecurityTblMchtInfoById(Integer id);

    public List<TblMchtInfo> getSecurityTblMchtInfoList(PageInfo pageInfo);    
}
