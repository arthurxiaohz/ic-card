package cn.net.iccard.bm.mcht.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtSettleCycleConfig;
import org.hi.framework.service.Manager;

public interface TblMchtSettleCycleConfigManager extends Manager{
    
    public void saveTblMchtSettleCycleConfig(TblMchtSettleCycleConfig tblMchtSettleCycleConfig);

    public void removeTblMchtSettleCycleConfigById(Integer id);

    public TblMchtSettleCycleConfig getTblMchtSettleCycleConfigById(Integer id);

    public List<TblMchtSettleCycleConfig> getTblMchtSettleCycleConfigList(PageInfo pageInfo);
    
    public void saveSecurityTblMchtSettleCycleConfig(TblMchtSettleCycleConfig tblMchtSettleCycleConfig);

    public void removeSecurityTblMchtSettleCycleConfigById(Integer id);

    public TblMchtSettleCycleConfig getSecurityTblMchtSettleCycleConfigById(Integer id);

    public List<TblMchtSettleCycleConfig> getSecurityTblMchtSettleCycleConfigList(PageInfo pageInfo);    
}
