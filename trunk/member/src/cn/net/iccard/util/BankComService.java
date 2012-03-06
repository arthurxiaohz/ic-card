package cn.net.iccard.util;



import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

/**
 * 银行公共服务类
 * */
public class BankComService {

	/**
     * 根据传入的请求信息列表,组成
     * 
     * @param aFormName
     *            form表单的name属性值
     * @param aAction
     *            form表单的action属性值
     * @param aID
     *            form表单的id属性值
     * @param aNewForm
     *            是否在新页面中提交表单(弹新页面)
     * @param aParams
     *            form表单的提交信息表,properties的key为input的name属性值,properties的value为input的value属性值
     * @return 生成的html表单
     */
    public StringBuffer buildForm(String aFormName, String aAction, String aID, boolean aNewForm, Properties aParams) {
        StringBuffer tForm = new StringBuffer("<form  method='post' action='").append(aAction).append("' ");
        if (aFormName != null && !aFormName.equals(""))
            tForm.append(" name='").append(aFormName).append("' ");
        if (aID != null && !aID.equals(""))
            tForm.append(" id='").append(aID).append("' ");
        if (aNewForm)
            tForm.append(" TARGET='_blank' ");
        tForm.append(">");
        if (aParams != null) {
            Enumeration tParams = aParams.propertyNames();
            String tParamName = null;
            while (tParams.hasMoreElements()) {
                tParamName = (String) tParams.nextElement();
                tForm.append("<input type='hidden' name='").append(tParamName).append("' value='").append(
                        aParams.getProperty(tParamName, "")).append("'/>");
            }
        }
        tForm.append("</form>");
        return tForm;
    }

    /**
     * 根据传入的请求信息列表,默认表单提交action属性值
     * 
     * @param aAction
     *            form表单的action属性值
     * @param aParams
     *            form表单的提交信息表,properties的key为input标签的name属性值,properties的value为input标签的value属性值
     * @return 生成的html表单
     */
    public StringBuffer buildForm(String aAction, Properties aParams) {
        return buildForm(null, aAction, "form1", false, aParams);
    }
    
    
    /**
	 * 创建http form.
	 * 
	 * @param properties
	 * @return
	 */
    public String generateForm(Map properties) {
		String tPostUrl = (String)properties.get("Post_URL");
		properties.remove("Post_URL");
		StringBuffer buf = new StringBuffer();
		//buf.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		//buf.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		buf.append("<form name='form1' action=").append(tPostUrl).append(" method=\"post\">");
		
		Iterator it = properties.entrySet().iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			if (null == value || "".equals(value))  {

				buf.append("<input type='hidden' name='").append(key)
				   .append("' id='").append(key)
				   .append("' value=''/>");
			} else {
				buf.append("<input type='hidden' name='").append(key)
				   .append("' id='").append(key)
				   .append("' value='").append(value).append("'/>");
			}
		}
		buf.append("</form>");
		//System.out.print("Form=["+buf.toString()+"]");
		return buf.toString();
	}
    
}
