package cn.net.iccard.bm.mcht.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtPaymentConfig;
import org.hi.framework.service.Manager;

public interface TblMchtPaymentConfigManager extends Manager{
    
    public void saveTblMchtPaymentConfig(TblMchtPaymentConfig tblMchtPaymentConfig);

    public void removeTblMchtPaymentConfigById(Integer id);

    public TblMchtPaymentConfig getTblMchtPaymentConfigById(Integer id);

    public List<TblMchtPaymentConfig> getTblMchtPaymentConfigList(PageInfo pageInfo);
    
    public void saveSecurityTblMchtPaymentConfig(TblMchtPaymentConfig tblMchtPaymentConfig);

    public void removeSecurityTblMchtPaymentConfigById(Integer id);

    public TblMchtPaymentConfig getSecurityTblMchtPaymentConfigById(Integer id);

    public List<TblMchtPaymentConfig> getSecurityTblMchtPaymentConfigList(PageInfo pageInfo);    
}
