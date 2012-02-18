package org.hi.base.report.excel.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.report.excel.action.ExcelSheetPageInfo;

public class ExcelCellPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_cellColumn;
 	protected  String  f_cellColumn_op;
	protected  Integer  f_cellRow;
 	protected  String  f_cellRow_op;
	protected  String  f_variableName;
 	protected  String  f_variableName_op;
	protected  String  f_constant;
 	protected  String  f_constant_op;
	protected  Integer  f_isEnumeration;
 	protected  String  f_isEnumeration_op;
	protected  Integer  f_reportDataType;
 	protected  String  f_reportDataType_op;
	protected  Integer  f_stretchingType;
 	protected  String  f_stretchingType_op;
	protected  String  f_condition;
 	protected  String  f_condition_op;
	protected  String  f_description;
 	protected  String  f_description_op;

 	protected  ExcelSheetPageInfo excelSheet;

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
   
    public String getF_cellColumn() {
        return this.f_cellColumn;
    }
    
    public void setF_cellColumn(String f_cellColumn) {
        this.f_cellColumn = f_cellColumn;
    }
    
    public String getF_cellColumn_op() {
        return this.f_cellColumn_op;
    }
    
    public void setF_cellColumn_op(String f_cellColumn_op) {
        this.f_cellColumn_op = f_cellColumn_op;
    }
   
    public Integer getF_cellRow() {
        return this.f_cellRow;
    }
    
    public void setF_cellRow(Integer f_cellRow) {
        this.f_cellRow = f_cellRow;
    }
    
    public String getF_cellRow_op() {
        return this.f_cellRow_op;
    }
    
    public void setF_cellRow_op(String f_cellRow_op) {
        this.f_cellRow_op = f_cellRow_op;
    }
   
    public String getF_variableName() {
        return this.f_variableName;
    }
    
    public void setF_variableName(String f_variableName) {
        this.f_variableName = f_variableName;
    }
    
    public String getF_variableName_op() {
        return this.f_variableName_op;
    }
    
    public void setF_variableName_op(String f_variableName_op) {
        this.f_variableName_op = f_variableName_op;
    }
   
    public String getF_constant() {
        return this.f_constant;
    }
    
    public void setF_constant(String f_constant) {
        this.f_constant = f_constant;
    }
    
    public String getF_constant_op() {
        return this.f_constant_op;
    }
    
    public void setF_constant_op(String f_constant_op) {
        this.f_constant_op = f_constant_op;
    }
   
    public Integer getF_isEnumeration() {
        return this.f_isEnumeration;
    }
    
    public void setF_isEnumeration(Integer f_isEnumeration) {
        this.f_isEnumeration = f_isEnumeration;
    }
    
    public String getF_isEnumeration_op() {
        return this.f_isEnumeration_op;
    }
    
    public void setF_isEnumeration_op(String f_isEnumeration_op) {
        this.f_isEnumeration_op = f_isEnumeration_op;
    }
   
    public Integer getF_reportDataType() {
        return this.f_reportDataType;
    }
    
    public void setF_reportDataType(Integer f_reportDataType) {
        this.f_reportDataType = f_reportDataType;
    }
    
    public String getF_reportDataType_op() {
        return this.f_reportDataType_op;
    }
    
    public void setF_reportDataType_op(String f_reportDataType_op) {
        this.f_reportDataType_op = f_reportDataType_op;
    }
   
    public Integer getF_stretchingType() {
        return this.f_stretchingType;
    }
    
    public void setF_stretchingType(Integer f_stretchingType) {
        this.f_stretchingType = f_stretchingType;
    }
    
    public String getF_stretchingType_op() {
        return this.f_stretchingType_op;
    }
    
    public void setF_stretchingType_op(String f_stretchingType_op) {
        this.f_stretchingType_op = f_stretchingType_op;
    }
   
    public String getF_condition() {
        return this.f_condition;
    }
    
    public void setF_condition(String f_condition) {
        this.f_condition = f_condition;
    }
    
    public String getF_condition_op() {
        return this.f_condition_op;
    }
    
    public void setF_condition_op(String f_condition_op) {
        this.f_condition_op = f_condition_op;
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
   
	public ExcelSheetPageInfo getExcelSheet() {
		return excelSheet;
	}

	public void setExcelSheet(ExcelSheetPageInfo excelSheet) {
		this.excelSheet = excelSheet;
	}

}
