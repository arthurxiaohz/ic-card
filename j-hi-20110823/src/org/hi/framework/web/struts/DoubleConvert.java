package org.hi.framework.web.struts;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * DoubleÀàÐÍ×ª»»Æ÷
 * @author kongfy
 *
 */
public class DoubleConvert extends StrutsTypeConverter {

	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(Double.class.equals(toClass)){
		    String doubleStr = values[0];
		    if ( doubleStr ==null || doubleStr.equals(""))
		    	return null;
		    Double doubleValue = Double.parseDouble(doubleStr);  
			return doubleValue;  
		}
		return 0;
	}

	public String convertToString(Map context, Object obj) {
		NumberFormat   formatter   =   new   DecimalFormat("0.0");
		String value = formatter.format(Double.valueOf(obj.toString()));
		return value;
	}

}
