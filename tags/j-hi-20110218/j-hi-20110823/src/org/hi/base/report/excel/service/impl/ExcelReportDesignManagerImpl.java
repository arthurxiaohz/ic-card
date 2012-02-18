package org.hi.base.report.excel.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.report.excel.service.ExcelReportDesignManager;
import org.hi.common.util.BizNumberUtil;

public class ExcelReportDesignManagerImpl extends ManagerImpl implements ExcelReportDesignManager{
    
    protected void preSaveObject(Object obj) {
    	ExcelReportDesign erd = (ExcelReportDesign)obj;
		if(erd.getId() == null  && (erd.getReportNum() == null || erd.getReportNum().trim().equals(""))){
			erd.setReportNum(BizNumberUtil.genNumber(4, "reportNum", ExcelReportDesign.class));
		}
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
    
    public void saveExcelReportDesign(ExcelReportDesign excelReportDesign){
    	saveObject(excelReportDesign);
    
    }

    public void removeExcelReportDesignById(Integer id){
    	removeObjectById(id);
    	
    }

    public ExcelReportDesign getExcelReportDesignById(Integer id){
   		return (ExcelReportDesign) getObjectById(id);
    }

    public List<ExcelReportDesign> getExcelReportDesignList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityExcelReportDesign(ExcelReportDesign excelReportDesign){
    	saveObject(excelReportDesign);
    }
    public void removeSecurityExcelReportDesignById(Integer id){
    	removeObjectById(id);
    }
    public ExcelReportDesign getSecurityExcelReportDesignById(Integer id){
    	return (ExcelReportDesign) getObjectById(id);
    }
    public List<ExcelReportDesign> getSecurityExcelReportDesignList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
