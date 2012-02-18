package org.hi.base.menu.filter;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.hi.base.menu.model.Menu;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.strutsmenu.MenuCollectionProcessor;
import org.hi.framework.HiConfigHolder;

public class HiMenuMenuLinkCollectionProcessor implements
		MenuCollectionProcessor {

	public Collection getCollection(Collection coll, Map<String, String> parameters) {

		//		如果不配置多语言则，不显示多语言菜单
		if(HiConfigHolder.getI18NLanguage() == null){
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				Object obj = (Object) iterator.next();
				
				if(obj instanceof Menu){
					Menu menu = (Menu)obj;
					if(menu.getMenuName().equals("i18n")) {
						iterator.remove();
						coll.remove(obj);
					}
				}
				if(obj instanceof MenuLink){
					MenuLink menuLink = (MenuLink)obj;
					if(menuLink.getMenu().getMenuName().equals("i18n")){
						iterator.remove();
						coll.remove(obj);
					}
				}
			}
		}
		
//		如果不配置在线帮助，则不显示帮助菜单
		if(HiConfigHolder.getHelper().equals("false")){
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				Object obj = (Object) iterator.next();
				
				if(obj instanceof MenuLink){
					MenuLink menuLink = (MenuLink)obj;
					if(menuLink.getId() == 5500){
						iterator.remove();
						coll.remove(obj);
					}
				}
			}
		}
		
		return coll;
	}

}
