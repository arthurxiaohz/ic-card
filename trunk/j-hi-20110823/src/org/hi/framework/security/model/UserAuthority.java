package org.hi.framework.security.model;

import org.hi.SpringContextHolder;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.security.model.original.UserAuthorityAbstract;
import org.hi.framework.security.service.AuthorityManager;


public class UserAuthority extends UserAuthorityAbstract{

    public Authority getAuthority() {
    	
    	if(!HiConfigHolder.getProperty("${hi.orm.type}").equals("SpringJDBC") || this.authority == null)
    		return this.authority;
    	
    	if(this.authority.getMenuLink() == null){
    		AuthorityManager authMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
    		this.authority = authMgr.getAuthorityById(this.authority.getId());
    	}
    	
    	if(this.authority.getMenuLink() != null && this.authority.getMenuLink().getMenu() == null){
    		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
    		this.authority.setMenuLink(menuLinkMgr.getMenuLinkById(this.authority.getMenuLink().getId()));
    	
    	}
    	
    	return this.authority;
    }
}