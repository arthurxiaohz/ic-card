package org.hi.base.sysapp.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.enumeration.model.YesNo;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.model.Helper;

public abstract class HelperAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 辅助编码
	 */	
 	protected  String helperCode;

 	 /**
	 * 标题
	 */	
 	protected  String title;

 	 /**
	 * URL
	 */	
 	protected  String urlAction;

 	 /**
	 * 帮助正文
	 */	
 	protected  String helpContent;

 	 /**
	 * 是否带参数
	 */	
 	protected  Integer isWithPara = 3201;

 	 /**
	 * 激活帮助
	 */	
 	protected  Integer activeHelp = 3200;

 	 /**
	 * 激活编码
	 */	
 	protected  Integer activeCode = 3200;

	private  List<HelperRef> helperRefs;

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
    
    public String getHelperCode() {
        return this.helperCode;
    }
    
    public void setHelperCode(String helperCode) {
    		if((helperCode != null && this.helperCode == null) || 
				this.helperCode != null && (!this.helperCode.equals(helperCode) || helperCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("helperCode", this.helperCode);
        	}
        this.helperCode = helperCode;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
    		if((title != null && this.title == null) || 
				this.title != null && (!this.title.equals(title) || title == null)){
        		this.setDirty(true);
        		this.oldValues.put("title", this.title);
        	}
        this.title = title;
    }
    
    public String getUrlAction() {
        return this.urlAction;
    }
    
    public void setUrlAction(String urlAction) {
    		if((urlAction != null && this.urlAction == null) || 
				this.urlAction != null && (!this.urlAction.equals(urlAction) || urlAction == null)){
        		this.setDirty(true);
        		this.oldValues.put("urlAction", this.urlAction);
        	}
        this.urlAction = urlAction;
    }
    
    public String getHelpContent() {
        return this.helpContent;
    }
    
    public void setHelpContent(String helpContent) {
    		if((helpContent != null && this.helpContent == null) || 
				this.helpContent != null && (!this.helpContent.equals(helpContent) || helpContent == null)){
        		this.setDirty(true);
        		this.oldValues.put("helpContent", this.helpContent);
        	}
        this.helpContent = helpContent;
    }
    
    public Integer getIsWithPara() {
        return this.isWithPara;
    }
    
    public void setIsWithPara(Integer isWithPara) {
    		if((isWithPara != null && this.isWithPara == null) || 
				this.isWithPara != null && (!this.isWithPara.equals(isWithPara) || isWithPara == null)){
        		this.setDirty(true);
        		this.oldValues.put("isWithPara", this.isWithPara);
        	}
        this.isWithPara = isWithPara;
    }
    
    public Integer getActiveHelp() {
        return this.activeHelp;
    }
    
    public void setActiveHelp(Integer activeHelp) {
    		if((activeHelp != null && this.activeHelp == null) || 
				this.activeHelp != null && (!this.activeHelp.equals(activeHelp) || activeHelp == null)){
        		this.setDirty(true);
        		this.oldValues.put("activeHelp", this.activeHelp);
        	}
        this.activeHelp = activeHelp;
    }
    
    public Integer getActiveCode() {
        return this.activeCode;
    }
    
    public void setActiveCode(Integer activeCode) {
    		if((activeCode != null && this.activeCode == null) || 
				this.activeCode != null && (!this.activeCode.equals(activeCode) || activeCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("activeCode", this.activeCode);
        	}
        this.activeCode = activeCode;
    }
    

    public void setHelperRefs(List<HelperRef> helperRefs) {
        this.helperRefs = helperRefs;
    }

    public List<HelperRef> getHelperRefs() {
        return this.helperRefs;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Helper) ) return false;
		 Helper castOther = ( Helper ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Helper".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("helperCode", this.helperCode)
		.append("title", this.title)
		.append("urlAction", this.urlAction);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}