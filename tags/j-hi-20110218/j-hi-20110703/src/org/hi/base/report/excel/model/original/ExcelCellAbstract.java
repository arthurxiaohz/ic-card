package org.hi.base.report.excel.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.enumeration.model.YesNo;
import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.base.report.excel.model.ExcelCell;

public abstract class ExcelCellAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 工作表
	 */	
 	protected  ExcelSheet excelSheet;

 	 /**
	 * 列
	 */	
 	protected  String cellColumn;

 	 /**
	 * 行
	 */	
 	protected  Integer cellRow;

 	 /**
	 * 变量名
	 */	
 	protected  String variableName;

 	 /**
	 * 常量
	 */	
 	protected  String constant;

 	 /**
	 * 枚举类型
	 * 
	 */	
 	protected  Integer isEnumeration;

 	 /**
	 * 数据类型
	 * 
	 */	
 	protected  Integer reportDataType;

 	 /**
	 * 伸展方式
	 * 
	 */	
 	protected  Integer stretchingType;

 	 /**
	 * 条件
	 */	
 	protected  String conditionCell;

 	 /**
	 * 描述
	 */	
 	protected  String description;


    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
    		if((id != null && this.id == null) || 
				this.id != null && (!this.id.equals(id) || id == null)){
        		this.setDirty(true);
        		this.oldValues.put("id", this.id);
        	}
        this.id = id;
    }
    
     public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
    		if((version != null && this.version == null) || 
				this.version != null && (!this.version.equals(version) || version == null)){
        		this.setDirty(true);
        		this.oldValues.put("version", this.version);
        	}
        this.version = version;
    }
    
    public ExcelSheet getExcelSheet() {
        return this.excelSheet;
    }
    
    public void setExcelSheet(ExcelSheet excelSheet) {
    		if((excelSheet != null && this.excelSheet == null) || 
				this.excelSheet != null && (!this.excelSheet.equals(excelSheet) || excelSheet == null)){
        		this.setDirty(true);
        		this.oldValues.put("excelSheet", this.excelSheet);
        	}
        this.excelSheet = excelSheet;
    }
    
   public BaseObject getParentEntity(){
	   return this.excelSheet;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.excelSheet = (ExcelSheet)parent;
   }
   
    public String getCellColumn() {
        return this.cellColumn;
    }
    
    public void setCellColumn(String cellColumn) {
    		if((cellColumn != null && this.cellColumn == null) || 
				this.cellColumn != null && (!this.cellColumn.equals(cellColumn) || cellColumn == null)){
        		this.setDirty(true);
        		this.oldValues.put("cellColumn", this.cellColumn);
        	}
        this.cellColumn = cellColumn;
    }
    
    public Integer getCellRow() {
        return this.cellRow;
    }
    
    public void setCellRow(Integer cellRow) {
    		if((cellRow != null && this.cellRow == null) || 
				this.cellRow != null && (!this.cellRow.equals(cellRow) || cellRow == null)){
        		this.setDirty(true);
        		this.oldValues.put("cellRow", this.cellRow);
        	}
        this.cellRow = cellRow;
    }
    
    public String getVariableName() {
        return this.variableName;
    }
    
    public void setVariableName(String variableName) {
    		if((variableName != null && this.variableName == null) || 
				this.variableName != null && (!this.variableName.equals(variableName) || variableName == null)){
        		this.setDirty(true);
        		this.oldValues.put("variableName", this.variableName);
        	}
        this.variableName = variableName;
    }
    
    public String getConstant() {
        return this.constant;
    }
    
    public void setConstant(String constant) {
    		if((constant != null && this.constant == null) || 
				this.constant != null && (!this.constant.equals(constant) || constant == null)){
        		this.setDirty(true);
        		this.oldValues.put("constant", this.constant);
        	}
        this.constant = constant;
    }
    
    public Integer getIsEnumeration() {
        return this.isEnumeration;
    }
    
    public void setIsEnumeration(Integer isEnumeration) {
    		if((isEnumeration != null && this.isEnumeration == null) || 
				this.isEnumeration != null && (!this.isEnumeration.equals(isEnumeration) || isEnumeration == null)){
        		this.setDirty(true);
        		this.oldValues.put("isEnumeration", this.isEnumeration);
        	}
        this.isEnumeration = isEnumeration;
    }
    
    public Integer getReportDataType() {
        return this.reportDataType;
    }
    
    public void setReportDataType(Integer reportDataType) {
    		if((reportDataType != null && this.reportDataType == null) || 
				this.reportDataType != null && (!this.reportDataType.equals(reportDataType) || reportDataType == null)){
        		this.setDirty(true);
        		this.oldValues.put("reportDataType", this.reportDataType);
        	}
        this.reportDataType = reportDataType;
    }
    
    public Integer getStretchingType() {
        return this.stretchingType;
    }
    
    public void setStretchingType(Integer stretchingType) {
    		if((stretchingType != null && this.stretchingType == null) || 
				this.stretchingType != null && (!this.stretchingType.equals(stretchingType) || stretchingType == null)){
        		this.setDirty(true);
        		this.oldValues.put("stretchingType", this.stretchingType);
        	}
        this.stretchingType = stretchingType;
    }
    
    public String getConditionCell() {
        return this.conditionCell;
    }
    
    public void setConditionCell(String conditionCell) {
    		if((conditionCell != null && this.conditionCell == null) || 
				this.conditionCell != null && (!this.conditionCell.equals(conditionCell) || conditionCell == null)){
        		this.setDirty(true);
        		this.oldValues.put("conditionCell", this.conditionCell);
        	}
        this.conditionCell = conditionCell;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
    		if((description != null && this.description == null) || 
				this.description != null && (!this.description.equals(description) || description == null)){
        		this.setDirty(true);
        		this.oldValues.put("description", this.description);
        	}
        this.description = description;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExcelCell) ) return false;
		 ExcelCell castOther = ( ExcelCell ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("ExcelCell".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("cellColumn", this.cellColumn)
		.append("cellRow", this.cellRow)
		.append("variableName", this.variableName)
		.append("constant", this.constant)
		.append("conditionCell", this.conditionCell)
		.append("description", this.description);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}