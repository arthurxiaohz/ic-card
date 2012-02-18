package org.hi.i18n.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.i18n.model.LanguageStr;
import org.hi.i18n.model.Language;
import org.hi.base.organization.model.HiUser;

public abstract class LanguageStrAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * ����id
	 */	
	protected  Integer id;

	/**
	 * �汾����version
	 */	
 	protected  Integer version;

 	 /**
	 * language
	 */	
 	protected  Language language;

 	 /**
	 * ���Դ���
	 */	
 	protected  String languageCode;

 	 /**
	 * ֵ
	 */	
 	protected  String value;

 	 /**
	 * ������
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
    
    public Language getLanguage() {
        return this.language;
    }
    
    public void setLanguage(Language language) {
    		if((language != null && this.language == null) || 
				this.language != null && (!this.language.equals(language) || language == null)){
        		this.setDirty(true);
        		this.oldValues.put("language", this.language);
        	}
        this.language = language;
    }
    
   public BaseObject getParentEntity(){
	   return this.language;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.language = (Language)parent;
   }
   
    public String getLanguageCode() {
        return this.languageCode;
    }
    
    public void setLanguageCode(String languageCode) {
    		if((languageCode != null && this.languageCode == null) || 
				this.languageCode != null && (!this.languageCode.equals(languageCode) || languageCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("languageCode", this.languageCode);
        	}
        this.languageCode = languageCode;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
    		if((value != null && this.value == null) || 
				this.value != null && (!this.value.equals(value) || value == null)){
        		this.setDirty(true);
        		this.oldValues.put("value", this.value);
        	}
        this.value = value;
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
		 if ( !(other instanceof LanguageStr) ) return false;
		 LanguageStr castOther = ( LanguageStr ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("LanguageStr".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("languageCode", this.languageCode)
		.append("value", this.value);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}