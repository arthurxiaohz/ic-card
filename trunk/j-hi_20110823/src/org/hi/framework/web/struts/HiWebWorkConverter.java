package org.hi.framework.web.struts;

import java.util.Map;

import org.hi.framework.model.BaseObject;

import ognl.DefaultTypeConverter;

public class HiWebWorkConverter extends DefaultTypeConverter {

    public Object convertValue(Map context, Object o, Class toClass) {
    	if(BaseObject.class.isAssignableFrom(toClass))
    		return converToBaseObject(context, (BaseObject)o, toClass);
    	else if (toClass.equals(String.class)) {
            return convertToString(context, o);
        } else if (o instanceof String[]) {
            return convertFromString(context, (String[]) o, toClass);
        } else if (o instanceof String) {
            return convertFromString(context, new String[]{(String) o}, toClass);
        } else {
        	return performFallbackConversion(context, o, toClass);
        }
    }
    
    protected Object performFallbackConversion(Map context, Object o, Class toClass) {
    	return super.convertValue(context, o, toClass);
    }
    
    public Object converToBaseObject(Map context,BaseObject o, Class toClass){
    	return null;
    }
    
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return null;
	}

	public String convertToString(Map context, Object o) {
		return null;
	}

}
