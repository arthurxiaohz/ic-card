package org.hi.base.report.excel.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.base.report.excel.model.ExcelReportDesign;

public abstract class ExcelSheetAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 报表
	 */	
 	protected  ExcelReportDesign excelReportDesign;

 	 /**
	 * 工作表名称
	 */	
 	protected  String sheetName;

 	 /**
	 * 序列
	 */	
 	protected  Double sequence = new Double(9999);

 	 /**
	 * 描述
	 */	
 	protected  String description;

	private  List<ExcelCell> excelCells;

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
    
    public ExcelReportDesign getExcelReportDesign() {
        return this.excelReportDesign;
    }
    
    public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
    		if((excelReportDesign != null && this.excelReportDesign == null) || 
				this.excelReportDesign != null && (!this.excelReportDesign.equals(excelReportDesign) || excelReportDesign == null)){
        		this.setDirty(true);
        		this.oldValues.put("excelReportDesign", this.excelReportDesign);
        	}
        this.excelReportDesign = excelReportDesign;
    }
    
   public BaseObject getParentEntity(){
	   return this.excelReportDesign;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.excelReportDesign = (ExcelReportDesign)parent;
   }
   
    public String getSheetName() {
        return this.sheetName;
    }
    
    public void setSheetName(String sheetName) {
    		if((sheetName != null && this.sheetName == null) || 
				this.sheetName != null && (!this.sheetName.equals(sheetName) || sheetName == null)){
        		this.setDirty(true);
        		this.oldValues.put("sheetName", this.sheetName);
        	}
        this.sheetName = sheetName;
    }
    
    public Double getSequence() {
        return this.sequence;
    }
    
    public void setSequence(Double sequence) {
    		if((sequence != null && this.sequence == null) || 
				this.sequence != null && (!this.sequence.equals(sequence) || sequence == null)){
        		this.setDirty(true);
        		this.oldValues.put("sequence", this.sequence);
        	}
        this.sequence = sequence;
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
    

    public void setExcelCells(List<ExcelCell> excelCells) {
        this.excelCells = excelCells;
    }

    public List<ExcelCell> getExcelCells() {
        return this.excelCells;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExcelSheet) ) return false;
		 ExcelSheet castOther = ( ExcelSheet ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("ExcelSheet".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("sheetName", this.sheetName)
		.append("sequence", this.sequence)
		.append("description", this.description);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}