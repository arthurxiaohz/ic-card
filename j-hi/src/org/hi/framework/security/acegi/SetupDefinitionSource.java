package org.hi.framework.security.acegi;

import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.intercept.web.RegExpBasedFilterInvocationDefinitionMap;

public class SetupDefinitionSource extends
		RegExpBasedFilterInvocationDefinitionMap {

	public ConfigAttributeDefinition getAttributes(Object object)
			throws IllegalArgumentException {
		return null;
	}
}
