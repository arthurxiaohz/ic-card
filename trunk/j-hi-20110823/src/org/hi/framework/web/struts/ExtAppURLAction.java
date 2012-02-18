package org.hi.framework.web.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;

public class ExtAppURLAction extends BaseAction{
	private String extUrl;
	
	public String execute() throws Exception{
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		List<MenuLink> MenuLinks = menuLinkMgr.getObjects();
		for (MenuLink menuLink : MenuLinks) {
			if(menuLink.getLinkUrl().contains(extUrl)){
				String linkUrl =  menuLink.getLinkUrl();
				extUrl = linkUrl.substring(linkUrl.indexOf("extUrl=")+ 7);
				break;
			}
				
		}
		
		return "extapp";
	}
	
	public String getExtUrl() {
		return extUrl;
	}

	public void setExtUrl(String extUrl) {
		this.extUrl = extUrl;
	}
	
	
	
}
