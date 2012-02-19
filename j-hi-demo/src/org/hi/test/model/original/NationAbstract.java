package org.hi.test.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.test.model.Nation;
import org.hi.base.organization.model.HiUser;

public abstract class NationAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 中文名字
	 */	
 	protected  String chineseName;

 	 /**
	 * 英文名字
	 */	
 	protected  String englishName;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();


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
    
    public String getChineseName() {
        return this.chineseName;
    }
    
    public void setChineseName(String chineseName) {
    		if((chineseName != null && this.chineseName == null) || 
				this.chineseName != null && (!this.chineseName.equals(chineseName) || chineseName == null)){
        		this.setDirty(true);
        		this.oldValues.put("chineseName", this.chineseName);
        	}
        this.chineseName = chineseName;
    }
    
    public String getEnglishName() {
        return this.englishName;
    }
    
    public void setEnglishName(String englishName) {
    		if((englishName != null && this.englishName == null) || 
				this.englishName != null && (!this.englishName.equals(englishName) || englishName == null)){
        		this.setDirty(true);
        		this.oldValues.put("englishName", this.englishName);
        	}
        this.englishName = englishName;
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
		 if ( !(other instanceof Nation) ) return false;
		 Nation castOther = ( Nation ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Nation".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("chineseName", this.chineseName)
		.append("englishName", this.englishName);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}