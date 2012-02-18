
package org.hi.base.menu.strutsmenu;


/**
 * @author ’≈Íª
 * Created on 2005-3-29
 */
import java.util.Locale;


import org.apache.struts.util.*;

//import javax.servlet.jsp.PageContext;
//import javax.servlet.jsp.JspException;

public class Resource {
//	private PageContext pageContext = null;
//	private String locale = null;
	
    public static String message(String bundle, Locale locale, String key){
    	MessageResourcesFactory factoryObject = MessageResourcesFactory.createFactory();
    	PropertyMessageResources msgResource = new PropertyMessageResources(factoryObject,bundle,false);
    	return msgResource.getMessage(locale,key);
    }

    /*
	public Resource(PageContext pageContext,String locale){
		this.pageContext = pageContext;
		this.locale = locale;
	}
	
	public String toString(String bundle,String key) throws JspException{
		return RequestUtils.message(pageContext,bundle,locale,key);
	}
*/	
	
	
	
	
}
