package org.hi.common.util;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hi.base.organization.model.HiUser;
import org.hi.framework.model.BaseObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * ������һ�������java�����װ��һ��JSON�ַ����Ĺ�����,ÿһ��java���󶼶���JSON�ַ�����һ������,����ͨ��<code>addJSONObject()</code>����������ʵ����
 * ����������תΪJSON��java����
 * ���磺<p>
 * &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; HiUserManager bizMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;List&lt;HiUser&gt; users = bizMgr.getObjects();<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;JSONObject json = new JSONObject("id", new Integer(1));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;json.addJSONObject("users", users, "id,fullName");<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;json.addJSONObject("zhUser", bizMgr.getObjectById(new Integer(1)), "id,userName,org.orgName,org.manager.fullName");<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;json.toString();
 * @author ���
 * @since 2011-4-10
 * @see org.hi.common.util.BeanUtil
 *
 */
public class JSONObject {
	private Map<String, JSONInfo> objects = new HashMap<String, JSONInfo>();
	
	/**
	 * JSONObject�Ĺ�����,ͨ������JSON�����������ת����java����
	 * @param jsonPropertyName ����JSON��������
	 * @param obj ��ת����java����,���java��������ǻ������ͱ������ڡ��ַ�����Ҳ������POJO���󣬻�����Collection���������
	 */
	public JSONObject(String jsonPropertyName, Object obj){
		if(jsonPropertyName != null && obj != null){
			objects.put(jsonPropertyName, new JSONInfo(obj, null));
		}
	}
	
	/**
	 * JSONObject�Ĺ�����,ͨ������JSON�����������ת����java����
	 * @param jsonPropertyName ����JSON��������
	 * @param obj ��ת����java����,���java��������ǻ������ͱ������ڡ��ַ�����Ҳ������POJO���󣬻�����Collection���������
	 * @param objectProperties ����JSON�ַ�����ӦPOJO���������б�,��������������֮���ö��ŷָ�,�����java�����ĳ��Ԫ���Ǽ���Ҳ����֧�ּ�����������.����Ԫ�ض���������
	 * ,����HiUser��POJO "id,org.orgName,org.id",ע�⣺���Ϊ��
	 * ��ֻת��һ������,�������ἶ���ķ������Ե�����ֵ
	 */
	public JSONObject(String jsonPropertyName, Object obj, String objectProperties){
		if(jsonPropertyName != null && obj != null)
			objects.put(jsonPropertyName, new JSONInfo(obj, objectProperties));
	}
	
	/**
	 * ���һ����ת����java����
	 * @param jsonPropertyName ����JSON��������
	 * @param obj ��ת����java����,���java��������ǻ������ͱ������ڡ��ַ�����Ҳ������POJO���󣬻�����Collection���������
	 */
	public void addJSONObject(String jsonPropertyName, Object obj){
		addJSONObject(jsonPropertyName, obj, null);
	}
	
	/**
	 *���һ����ת����java����,ʹ����ΪJSON�ַ�����һ����
	 * @param jsonPropertyName ����JSON��������
	 * @param obj ��ת����java����,���java��������ǻ������ͱ������ڡ��ַ�����Ҳ������POJO���󣬻�����Collection���������
	 * @param objectProperties ����JSON�ַ�����ӦPOJO���������б�,��������������֮���ö��ŷָ�,�����java�����ĳ��Ԫ���Ǽ���Ҳ����֧�ּ�����������.����Ԫ�ض���������
	 * ,����HiUser��POJO "id,org.orgName,org.id",ע�⣺����ò���Ϊ��
	 * ��ֻת��һ������,�������ἶ���ķ������Ե�����ֵ
	 */
	public void addJSONObject(String jsonPropertyName, Object obj, String objectProperties){
		if(jsonPropertyName != null && obj != null)
			objects.put(jsonPropertyName, new JSONInfo(obj, objectProperties));
	}
	
	/**
	 * ɾ��һ����ת����java����
	 * @param jsonPropertyName ����JSON��������
	 */
	public void removeJSONObject(String jsonPropertyName){
		objects.remove(jsonPropertyName);
	}
	
	/**
	 * �жϸ����Ե��Ƿ����
	 * @param jsonPropertyName ����JSON��������
	 * @return ���������Ϊ��,����Ϊ��
	 */
	public boolean isJSONObject(String jsonPropertyName){
		return objects.containsKey(jsonPropertyName);
	}
	
	/**
	 * ͨ�����������������java����
	 * @param jsonPropertyName ����JSON��������
	 * @return ����java����
	 */
	public Object getJSONObject(String jsonPropertyName){
		if(objects.get(jsonPropertyName) == null)
			return null;
		return objects.get(jsonPropertyName).getObj();
	}
	
	/**
	 * ��÷�װ���JSON����
	 * @return ����һ��JSON������ַ���
	 */
	public String getJSON(){
		return toString();
	}
	
	/**
	 * ��÷�װ���JSON����
	 * @return ����һ��JSON������ַ���
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer("{");
		int i = 0;
		for(Map.Entry<String, JSONInfo> entry: objects.entrySet()){
			JSONInfo info = entry.getValue();
			String jsonPropertyName = entry.getKey();
			if( info == null)
				continue;
			
			if(i > 0)
				sb.append(",");
			i++;
			
			sb.append("\"").append(jsonPropertyName).append("\"");
			sb.append(":");
			
			Object obj = info.getObj();
			
			if(obj instanceof String || obj instanceof Date || obj instanceof Timestamp)
				sb.append("\"");

			if(obj instanceof Collection)
				sb.append(BeanUtil.getCollection2JSON((Collection)obj, null, info.getProperties(), false));
			else if(obj instanceof BaseObject)
				sb.append(BeanUtil.getBean2JSON(obj, info.getProperties()));
			else if(obj instanceof Date)
				sb.append(StringUtils.DateToStr((Date)obj, "yyyy-MM-dd"));
			else if(obj instanceof Timestamp)
				sb.append(StringUtils.DateToStr(new Date(((Timestamp)obj).getTime()), "yyyy-MM-dd hh:mm:ss"));
			else
				sb.append(obj.toString());
				
			if(obj instanceof String || obj instanceof Date || obj instanceof Timestamp)
				sb.append("\"");
		}
		
		sb.append("}");
		return sb.toString();
	}
	
	public static Object json2Bean(String json, Class clazz){
		 GsonBuilder builder = new GsonBuilder(); 
			Gson gson = builder.create();
			return gson.fromJson(json, clazz);
	}
	
}

class JSONInfo{
	private Object obj;
	private String properties;
	
	JSONInfo(Object obj, String properties){
		this.obj = obj;
		this.properties = properties;
	}
	public Object getObj() {
		return obj;
	}
	public String getProperties() {
		return properties;
	}
	
}
