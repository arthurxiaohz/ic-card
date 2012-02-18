package org.hi.base.report.excel.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.report.excel.service.ExcelSheetManager;

public class ExcelSheetManagerImpl extends ManagerImpl implements ExcelSheetManager{
    
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
    
    public void saveExcelSheet(ExcelSheet excelSheet){
    	saveObject(excelSheet);
    
    }

    public void removeExcelSheetById(Integer id){
    	removeObjectById(id);
    	
    }

    public ExcelSheet getExcelSheetById(Integer id){
   		return (ExcelSheet) getObjectById(id);
    }

    public List<ExcelSheet> getExcelSheetList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityExcelSheet(ExcelSheet excelSheet){
    	saveObject(excelSheet);
    }
    public void removeSecurityExcelSheetById(Integer id){
    	removeObjectById(id);
    }
    public ExcelSheet getSecurityExcelSheetById(Integer id){
    	return (ExcelSheet) getObjectById(id);
    }
    public List<ExcelSheet> getSecurityExcelSheetList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
}
