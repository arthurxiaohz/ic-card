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
import org.hi.base.menu.model.MenuLink;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.security.model.Authority;

public abstract class MenuLinkAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 菜单URL
	 */	
 	protected  String linkUrl;

 	 /**
	 * 显示信息
	 */	
 	protected  String displayRef;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 权限
	 */	
 	protected  Authority authority;

 	 /**
	 * 序列
	 */	
 	protected  Double sequence = new Double(9999);

 	 /**
	 * 菜单项
	 */	
 	protected  Menu menu;

 	 /**
	 * 菜单链接类型
	 */	
 	protected  Integer menuLinkType = new Integer(0);

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
    
    public String getLinkUrl() {
        return this.linkUrl;
    }
    
    public void setLinkUrl(String linkUrl) {
    		if((linkUrl != null && this.linkUrl == null) || 
				this.linkUrl != null && (!this.linkUrl.equals(linkUrl) || linkUrl == null)){
        		this.setDirty(true);
        		this.oldValues.put("linkUrl", this.linkUrl);
        	}
        this.linkUrl = linkUrl;
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
    
    public Authority getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(Authority authority) {
    		if((authority != null && this.authority == null) || 
				this.authority != null && (!this.authority.equals(authority) || authority == null)){
        		this.setDirty(true);
        		this.oldValues.put("authority", this.authority);
        	}
        this.authority = authority;
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
    
    public Menu getMenu() {
        return this.menu;
    }
    
    public void setMenu(Menu menu) {
    		if((menu != null && this.menu == null) || 
				this.menu != null && (!this.menu.equals(menu) || menu == null)){
        		this.setDirty(true);
        		this.oldValues.put("menu", this.menu);
        	}
        this.menu = menu;
    }
    
   public BaseObject getParentEntity(){
	   return this.menu;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.menu = (Menu)parent;
   }
   
    public Integer getMenuLinkType() {
        return this.menuLinkType;
    }
    
    public void setMenuLinkType(Integer menuLinkType) {
    		if((menuLinkType != null && this.menuLinkType == null) || 
				this.menuLinkType != null && (!this.menuLinkType.equals(menuLinkType) || menuLinkType == null)){
        		this.setDirty(true);
        		this.oldValues.put("menuLinkType", this.menuLinkType);
        	}
        this.menuLinkType = menuLinkType;
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
		 if ( !(other instanceof MenuLink) ) return false;
		 MenuLink castOther = ( MenuLink ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("MenuLink".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("linkUrl", this.linkUrl)
		.append("displayRef", this.displayRef)
		.append("description", this.description)
		.append("sequence", this.sequence)
		.append("menuLinkType", this.menuLinkType);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}