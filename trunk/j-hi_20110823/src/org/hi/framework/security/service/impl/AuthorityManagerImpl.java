package org.hi.framework.security.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hi.common.util.BeanUtil;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.service.impl.ManagerImpl;
import org.springframework.beans.factory.InitializingBean;

public class AuthorityManagerImpl extends ManagerImpl implements AuthorityManager, InitializingBean{
    private List<Authority> authorites = new ArrayList<Authority>();
	
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveAuthority(Authority Authority){
    	saveObject(Authority);
    
    }

    public void removeAuthorityById(Integer id){
    	removeObjectById(id);
    	
    }

    public Authority getAuthorityById(Integer id){
   		return (Authority) getObjectById(id);
    }

    public List<Authority> getAuthorityList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    
    public void saveSecurityAuthority(Authority authority){
    	saveObject(authority);
    }
    public void removeSecurityAuthorityById(Integer id){
    	removeObjectById(id);
    }
    public Authority getSecurityAuthorityById(Integer id){
    	return (Authority) getObjectById(id);
    }
    public List<Authority> getSecurityAuthorityList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public Object getObjectById(Serializable id){
    	if(authorites.size() == 0)
    		return (Authority)super.getObjectById(id);
    	
    	for (Authority authority : authorites) {
			if(authority.getId().equals(id) )
				return authority;
		}
    	return null;
    }
    
    public List<Authority> getObjects(){
    	if(authorites.size() == 0)
    		return super.getObjects();
    	
    	return authorites;
    }
	public void afterPropertiesSet() throws Exception {
//		如果不是发布模式则不加载缓存
		if(!HiConfigHolder.getPublished())
			return;
		
		List<Authority> _authorites = this.getObjects();
		for (Authority _authority : _authorites) {
			Authority authority = new Authority();
			BeanUtil.setBean2Bean(_authority, authority);
			authorites.add(authority);
		}
	} 
}
