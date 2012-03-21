package cn.net.iccard.bm.accounting.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import org.hi.base.organization.model.HiUser;

public abstract class TblActAccountBalanceAbstract extends ActAccount implements Serializable{

 	 /**
	 * id
	 */	
 	protected  Integer id;

 	 /**
	 * 可用余额
	 */	
 	protected  Integer availableBalance;

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
    
    public Integer getAvailableBalance() {
        return this.availableBalance;
    }
    
    public void setAvailableBalance(Integer availableBalance) {
    		if((availableBalance != null && this.availableBalance == null) || 
				this.availableBalance != null && (!this.availableBalance.equals(availableBalance) || availableBalance == null)){
        		this.setDirty(true);
        		this.oldValues.put("availableBalance", this.availableBalance);
        	}
        this.availableBalance = availableBalance;
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
		 if ( !(other instanceof TblActAccountBalance) ) return false;
		 TblActAccountBalance castOther = ( TblActAccountBalance ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.appendSuper(super.hashCode());
		hcb.append("TblActAccountBalance".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("availableBalance", this.availableBalance)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}