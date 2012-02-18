package org.hi.framework.security.acegi;

import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.intercept.web.FilterInvocation;
import org.acegisecurity.intercept.web.RegExpBasedFilterInvocationDefinitionMap;

public class HiRegExpBasedFilterInvocationDefinitionMap extends
		RegExpBasedFilterInvocationDefinitionMap {
	public ConfigAttributeDefinition getAttributes(Object object)
    throws IllegalArgumentException {
    if ((object == null) || !this.supports(object.getClass())) {
        throw new IllegalArgumentException("Object must be a FilterInvocation");
    }

    String url = ((FilterInvocation) object).getRequestUrl();
    if(url.indexOf("?")!=-1)
    	url=url.substring(0,url.indexOf("?"));
    return this.lookupAttributes(url);
}


}
