package org.hi.base.menu.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.menu.model.Menu;
import org.hi.base.organization.model.HiUser;

public abstract class MenuAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 菜单名称
	 */	
 	protected  String menuName;

 	 /**
	 * 显示信息
	 */	
 	protected  String displayRef;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 父菜单项
	 */	
 	protected  Menu parentMenu;

 	 /**
	 * 序列
	 */	
 	protected  Double sequence = new Double(9999);

 	 /**
	 * 菜单项类型
	 */	
 	protected  Integer menuType = new Integer(0);

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator;


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
    
    public String getMenuName() {
        return this.menuName;
    }
    
    public void setMenuName(String menuName) {
    		if((menuName != null && this.menuName == null) || 
				this.menuName != null && (!this.menuName.equals(menuName) || menuName == null)){
        		this.setDirty(true);
        		this.oldValues.put("menuName", this.menuName);
        	}
        this.menuName = menuName;
    }
    
    public String getDisplayRef() {
        return this.displayRef;
    }
    
    public void setDisplayRef(String displayRef) {
    		if((displayRef != null && this.displayRef == null) || 
				this.displayRef != null && (!this.displayRef.equals(displayRef) || displayRef == null)){
        		this.setDirty(true);
        		this.oldValues.put("displayRef", this.displayRef);
        	}
        this.displayRef = displayRef;
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
    
    public Menu getParentMenu() {
        return this.parentMenu;
    }
    
    public void setParentMenu(Menu parentMenu) {
    		if((parentMenu != null && this.parentMenu == null) || 
				this.parentMenu != null && (!this.parentMenu.equals(parentMenu) || parentMenu == null)){
        		this.setDirty(true);
        		this.oldValues.put("parentMenu", this.parentMenu);
        	}
        this.parentMenu = parentMenu;
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
    
    public Integer getMenuType() {
        return this.menuType;
    }
    
    public void setMenuType(Integer menuType) {
    		if((menuType != null && this.menuType == null) || 
				this.menuType != null && (!this.menuType.equals(menuType) || menuType == null)){
        		this.setDirty(true);
        		this.oldValues.put("menuType", this.menuType);
        	}
        this.menuType = menuType;
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
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Menu) ) return false;
		 Menu castOther = ( Menu ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Menu".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("menuName", this.menuName)
		.append("displayRef", this.displayRef)
		.append("description", this.description)
		.append("sequence", this.sequence)
		.append("menuType", this.menuType);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}