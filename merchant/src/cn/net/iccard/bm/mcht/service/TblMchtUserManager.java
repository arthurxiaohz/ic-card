package cn.net.iccard.bm.mcht.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtUser;
import org.hi.base.organization.service.HiUserManager;

public interface TblMchtUserManager extends HiUserManager{
    
    public void saveTblMchtUser(TblMchtUser tblMchtUser);

    public void removeTblMchtUserById(Integer id);

    public TblMchtUser getTblMchtUserById(Integer id);

    public List<TblMchtUser> getTblMchtUserList(PageInfo pageInfo);
    
    public void saveSecurityTblMchtUser(TblMchtUser tblMchtUser);

    public void removeSecurityTblMchtUserById(Integer id);

    public TblMchtUser getSecurityTblMchtUserById(Integer id);

    public List<TblMchtUser> getSecurityTblMchtUserList(PageInfo pageInfo);    
}
