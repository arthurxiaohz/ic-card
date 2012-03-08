package cn.net.iccard.member.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbPoint;
import org.hi.framework.service.Manager;

public interface TblMbPointManager extends Manager{
    
    public void saveTblMbPoint(TblMbPoint tblMbPoint);

    public void removeTblMbPointById(Integer id);

    public TblMbPoint getTblMbPointById(Integer id);

    public List<TblMbPoint> getTblMbPointList(PageInfo pageInfo);
    
    public void saveSecurityTblMbPoint(TblMbPoint tblMbPoint);

    public void removeSecurityTblMbPointById(Integer id);

    public TblMbPoint getSecurityTblMbPointById(Integer id);

    public List<TblMbPoint> getSecurityTblMbPointList(PageInfo pageInfo);    
}
