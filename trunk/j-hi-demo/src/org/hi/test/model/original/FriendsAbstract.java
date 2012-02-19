package org.hi.test.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.test.model.Friends;
import org.hi.test.model.Staff;
import org.hi.base.organization.model.HiUser;

public abstract class FriendsAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 姓名
	 */	
 	protected  String name;

 	 /**
	 * 年龄
	 */	
 	protected  Integer age;

 	 /**
	 * staff
	 */	
 	protected  Staff staff;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

 	 /**
	 * 删除标识
	 */	
 	protected  Integer deleted = 0;


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
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
    		if((name != null && this.name == null) || 
				this.name != null && (!this.name.equals(name) || name == null)){
        		this.setDirty(true);
        		this.oldValues.put("name", this.name);
        	}
        this.name = name;
    }
    
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
    		if((age != null && this.age == null) || 
				this.age != null && (!this.age.equals(age) || age == null)){
        		this.setDirty(true);
        		this.oldValues.put("age", this.age);
        	}
        this.age = age;
    }
    
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
    		if((staff != null && this.staff == null) || 
				this.staff != null && (!this.staff.equals(staff) || staff == null)){
        		this.setDirty(true);
        		this.oldValues.put("staff", this.staff);
        	}
        this.staff = staff;
    }
    
   public BaseObject getParentEntity(){
	   return this.staff;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.staff = (Staff)parent;
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
    
    public Integer getDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(Integer deleted) {
    		if((deleted != null && this.deleted == null) || 
				this.deleted != null && (!this.deleted.equals(deleted) || deleted == null)){
        		this.setDirty(true);
        		this.oldValues.put("deleted", this.deleted);
        	}
        this.deleted = deleted;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Friends) ) return false;
		 Friends castOther = ( Friends ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Friends".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("name", this.name)
		.append("age", this.age)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}