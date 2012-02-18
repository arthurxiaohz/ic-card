package org.hi.framework.web.taglib.component.builder;

import java.util.Iterator;
import java.util.Map;

public class BuilderTools {
	public static String getParameters(Map parameters){
		if(parameters == null)
			return "";
		
		StringBuffer result =new StringBuffer("");
		Iterator it = parameters.keySet().iterator();
		while (it.hasNext()) {
			Object key =  it.next();
			String value = (String) parameters.get(key);
			result.append(" "+ key +"=\"" + value + "\" ");
		}
		
		return result.toString();
	}
}
