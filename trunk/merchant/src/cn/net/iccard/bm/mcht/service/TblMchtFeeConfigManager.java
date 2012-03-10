package cn.net.iccard.bm.mcht.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtFeeConfig;
import org.hi.framework.service.Manager;

public interface TblMchtFeeConfigManager extends Manager{
    
    public void saveTblMchtFeeConfig(TblMchtFeeConfig tblMchtFeeConfig);

    public void removeTblMchtFeeConfigById(Integer id);

    public TblMchtFeeConfig getTblMchtFeeConfigById(Integer id);

    public List<TblMchtFeeConfig> getTblMchtFeeConfigList(PageInfo pageInfo);
    
    public void saveSecurityTblMchtFeeConfig(TblMchtFeeConfig tblMchtFeeConfig);

    public void removeSecurityTblMchtFeeConfigById(Integer id);

    public TblMchtFeeConfig getSecurityTblMchtFeeConfigById(Integer id);

    public List<TblMchtFeeConfig> getSecurityTblMchtFeeConfigList(PageInfo pageInfo);    
}
