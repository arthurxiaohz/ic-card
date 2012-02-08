package org.hi.base.report.excel.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.report.excel.action.ExcelReportDesignPageInfo;

public class ExcelSheetPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_sheetName;
 	protected  String  f_sheetName_op;
	protected  Double  f_sequence;
 	protected  String  f_sequence_op;
	protected  String  f_description;
 	protected  String  f_description_op;

 	protected  ExcelReportDesignPageInfo excelReportDesign;

    public Integer getF_id() {
        return this.f_id;
    }
    
    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }
    
    public String getF_id_op() {
        return this.f_id_op;
    }
    
    public void setF_id_op(String f_id_op) {
        this.f_id_op = f_id_op;
    }
   
    public String getF_sheetName() {
        return this.f_sheetName;
    }
    
    public void setF_sheetName(String f_sheetName) {
        this.f_sheetName = f_sheetName;
    }
    
    public String getF_sheetName_op() {
        return this.f_sheetName_op;
    }
    
    public void setF_sheetName_op(String f_sheetName_op) {
        this.f_sheetName_op = f_sheetName_op;
    }
   
    public Double getF_sequence() {
        return this.f_sequence;
    }
    
    public void setF_sequence(Double f_sequence) {
        this.f_sequence = f_sequence;
    }
    
    public String getF_sequence_op() {
        return this.f_sequence_op;
    }
    
    public void setF_sequence_op(String f_sequence_op) {
        this.f_sequence_op = f_sequence_op;
    }
   
    public String getF_description() {
        return this.f_description;
    }
    
    public void setF_description(String f_description) {
        this.f_description = f_description;
    }
    
    public String getF_description_op() {
        return this.f_description_op;
    }
    
    public void setF_description_op(String f_description_op) {
        this.f_description_op = f_description_op;
    }
   
	public ExcelReportDesignPageInfo getExcelReportDesign() {
		return excelReportDesign;
	}

	public void setExcelReportDesign(ExcelReportDesignPageInfo excelReportDesign) {
		this.excelReportDesign = excelReportDesign;
	}

}
