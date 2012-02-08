package org.hi.base.report.excel.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.organization.model.HiUser;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.report.excel.service.ExcelCellManager;

public class ExcelCellManagerImpl extends ManagerImpl implements ExcelCellManager{
    
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
    
    public void saveExcelCell(ExcelCell excelCell){
    	saveObject(excelCell);
    
    }

    public void removeExcelCellById(Integer id){
    	removeObjectById(id);
    	
    }

    public ExcelCell getExcelCellById(Integer id){
   		return (ExcelCell) getObjectById(id);
    }

    public List<ExcelCell> getExcelCellList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityExcelCell(ExcelCell excelCell){
    	saveObject(excelCell);
    }
    public void removeSecurityExcelCellById(Integer id){
    	removeObjectById(id);
    }
    public ExcelCell getSecurityExcelCellById(Integer id){
    	return (ExcelCell) getObjectById(id);
    }
    public List<ExcelCell> getSecurityExcelCellList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
    
    
}
