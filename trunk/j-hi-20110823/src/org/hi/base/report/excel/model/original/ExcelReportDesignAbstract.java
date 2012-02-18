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
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.organization.model.HiUser;

public abstract class ExcelReportDesignAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 报表名称
	 */	
 	protected  String reportName;

 	 /**
	 * 报表编号
	 */	
 	protected  String reportNum;

 	 /**
	 * 模板文件
	 */	
 	protected  String template;

 	 /**
	 * 创建时间
	 */	
 	protected  Date createDate = new Date();

 	 /**
	 * 激活
	 * 
	 */	
 	protected  Integer enabled;

 	 /**
	 * Action类(全限定名)
	 */	
 	protected  String actionName;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

	private  List<ExcelSheet> excelSheets;

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
    
    public String getReportName() {
        return this.reportName;
    }
    
    public void setReportName(String reportName) {
    		if((reportName != null && this.reportName == null) || 
				this.reportName != null && (!this.reportName.equals(reportName) || reportName == null)){
        		this.setDirty(true);
        		this.oldValues.put("reportName", this.reportName);
        	}
        this.reportName = reportName;
    }
    
    public String getReportNum() {
        return this.reportNum;
    }
    
    public void setReportNum(String reportNum) {
    		if((reportNum != null && this.reportNum == null) || 
				this.reportNum != null && (!this.reportNum.equals(reportNum) || reportNum == null)){
        		this.setDirty(true);
        		this.oldValues.put("reportNum", this.reportNum);
        	}
        this.reportNum = reportNum;
    }
    
    public String getTemplate() {
        return this.template;
    }
    
    public void setTemplate(String template) {
    		if((template != null && this.template == null) || 
				this.template != null && (!this.template.equals(template) || template == null)){
        		this.setDirty(true);
        		this.oldValues.put("template", this.template);
        	}
        this.template = template;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
    		if((createDate != null && this.createDate == null) || 
				this.createDate != null && (!this.createDate.equals(createDate) || createDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("createDate", this.createDate);
        	}
        this.createDate = createDate;
    }
    
    public Integer getEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(Integer enabled) {
    		if((enabled != null && this.enabled == null) || 
				this.enabled != null && (!this.enabled.equals(enabled) || enabled == null)){
        		this.setDirty(true);
        		this.oldValues.put("enabled", this.enabled);
        	}
        this.enabled = enabled;
    }
    
    public String getActionName() {
        return this.actionName;
    }
    
    public void setActionName(String actionName) {
    		if((actionName != null && this.actionName == null) || 
				this.actionName != null && (!this.actionName.equals(actionName) || actionName == null)){
        		this.setDirty(true);
        		this.oldValues.put("actionName", this.actionName);
        	}
        this.actionName = actionName;
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
    
    public HiUser getCreator() {
        return this.creator;
    }
    
    public void setCreator(HiUser creator) {
    		if((creator != null && this.creator == null) || 
				this.creator != null && (!this.creator.equals(creator) || creator == null)){
        		this.setDirty(true);
        		this.oldValues.put("creator", this.creator);
        	}
        this.creator = creator;
    }
    

    public void setExcelSheets(List<ExcelSheet> excelSheets) {
        this.excelSheets = excelSheets;
    }

    public List<ExcelSheet> getExcelSheets() {
        return this.excelSheets;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExcelReportDesign) ) return false;
		 ExcelReportDesign castOther = ( ExcelReportDesign ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("ExcelReportDesign".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("reportName", this.reportName)
		.append("reportNum", this.reportNum)
		.append("template", this.template)
		.append("actionName", this.actionName)
		.append("description", this.description);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}