package cn.net.iccard.util;



import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

/**
 * ���й���������
 * */
public class BankComService {

	/**
     * ���ݴ����������Ϣ�б�,���
     * 
     * @param aFormName
     *            form����name����ֵ
     * @param aAction
     *            form����action����ֵ
     * @param aID
     *            form����id����ֵ
     * @param aNewForm
     *            �Ƿ�����ҳ�����ύ��(����ҳ��)
     * @param aParams
     *            form�����ύ��Ϣ��,properties��keyΪinput��name����ֵ,properties��valueΪinput��value����ֵ
     * @return ���ɵ�html��
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
     * ���ݴ����������Ϣ�б�,Ĭ�ϱ��ύaction����ֵ
     * 
     * @param aAction
     *            form����action����ֵ
     * @param aParams
     *            form�����ύ��Ϣ��,properties��keyΪinput��ǩ��name����ֵ,properties��valueΪinput��ǩ��value����ֵ
     * @return ���ɵ�html��
     */
    public StringBuffer buildForm(String aAction, Properties aParams) {
        return buildForm(null, aAction, "form1", false, aParams);
    }
    
    
    /**
	 * ����http form.
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
