package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbPoint;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbPointManager;

public class TblMbPointManagerImpl extends ManagerImpl implements TblMbPointManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveTblMbPoint(TblMbPoint tblMbPoint){
    	saveObject(tblMbPoint);
    
    }

    public void removeTblMbPointById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbPoint getTblMbPointById(Integer id){
   		return (TblMbPoint) getObjectById(id);
    }

    public List<TblMbPoint> getTblMbPointList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbPoint(TblMbPoint tblMbPoint){
    	saveObject(tblMbPoint);
    
    }

    public void removeSecurityTblMbPointById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbPoint getSecurityTblMbPointById(Integer id){
   		return (TblMbPoint) getObjectById(id);
    }

    public List<TblMbPoint> getSecurityTblMbPointList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
