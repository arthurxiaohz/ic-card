package cn.net.iccard.bm.mcht.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtCertificate;
import org.hi.framework.service.Manager;

public interface TblMchtCertificateManager extends Manager{
    
    public void saveTblMchtCertificate(TblMchtCertificate tblMchtCertificate);

    public void removeTblMchtCertificateById(Integer id);

    public TblMchtCertificate getTblMchtCertificateById(Integer id);

    public List<TblMchtCertificate> getTblMchtCertificateList(PageInfo pageInfo);
    
    public void saveSecurityTblMchtCertificate(TblMchtCertificate tblMchtCertificate);

    public void removeSecurityTblMchtCertificateById(Integer id);

    public TblMchtCertificate getSecurityTblMchtCertificateById(Integer id);

    public List<TblMchtCertificate> getSecurityTblMchtCertificateList(PageInfo pageInfo);    
}
