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
 * 该类是一个将多个java对象封装成一个JSON字符串的工具类,每一个java对象都对象JSON字符串的一个属性,可以通过<code>addJSONObject()</code>方法向该类的实例中
 * 加入多个待换转为JSON的java对象
 * 例如：<p>
 * &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; HiUserManager bizMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;List&lt;HiUser&gt; users = bizMgr.getObjects();<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;JSONObject json = new JSONObject("id", new Integer(1));<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;json.addJSONObject("users", users, "id,fullName");<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;json.addJSONObject("zhUser", bizMgr.getObjectById(new Integer(1)), "id,userName,org.orgName,org.manager.fullName");<br>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;json.toString();
 * @author 张昊
 * @since 2011-4-10
 * @see org.hi.common.util.BeanUtil
 *
 */
public class JSONObject {
	private Map<String, JSONInfo> objects = new HashMap<String, JSONInfo>();
	
	/**
	 * JSONObject的构建器,通过给定JSON的属性名与待转换的java对象
	 * @param jsonPropertyName 给定JSON的属性名
	 * @param obj 待转换的java对象,这个java对象可以是基础类型比如日期、字符串，也可以是POJO对象，或者是Collection集合类对象
	 */
	public JSONObject(String jsonPropertyName, Object obj){
		if(jsonPropertyName != null && obj != null){
			objects.put(jsonPropertyName, new JSONInfo(obj, null));
		}
	}
	
	/**
	 * JSONObject的构建器,通过给定JSON的属性名与待转换的java对象
	 * @param jsonPropertyName 给定JSON的属性名
	 * @param obj 待转换的java对象,这个java对象可以是基础类型比如日期、字符串，也可以是POJO对象，或者是Collection集合类对象
	 * @param objectProperties 返回JSON字符串对应POJO的属性名列表,属性名与属性名之间用逗号分隔,如果该java对象的某个元素是集合也可以支持即集合属性名.集合元素对象属性名
	 * ,例如HiUser的POJO "id,org.orgName,org.id",注意：如果为空
	 * 则只转换一级属性,即它不会级联的返回属性的属性值
	 */
	public JSONObject(String jsonPropertyName, Object obj, String objectProperties){
		if(jsonPropertyName != null && obj != null)
			objects.put(jsonPropertyName, new JSONInfo(obj, objectProperties));
	}
	
	/**
	 * 添加一个待转换的java对象
	 * @param jsonPropertyName 给定JSON的属性名
	 * @param obj 待转换的java对象,这个java对象可以是基础类型比如日期、字符串，也可以是POJO对象，或者是Collection集合类对象
	 */
	public void addJSONObject(String jsonPropertyName, Object obj){
		addJSONObject(jsonPropertyName, obj, null);
	}
	
	/**
	 *添加一个待转换的java对象,使其作为JSON字符串的一部分
	 * @param jsonPropertyName 给定JSON的属性名
	 * @param obj 待转换的java对象,这个java对象可以是基础类型比如日期、字符串，也可以是POJO对象，或者是Collection集合类对象
	 * @param objectProperties 返回JSON字符串对应POJO的属性名列表,属性名与属性名之间用逗号分隔,如果该java对象的某个元素是集合也可以支持即集合属性名.集合元素对象属性名
	 * ,例如HiUser的POJO "id,org.orgName,org.id",注意：如果该参数为空
	 * 则只转换一级属性,即它不会级联的返回属性的属性值
	 */
	public void addJSONObject(String jsonPropertyName, Object obj, String objectProperties){
		if(jsonPropertyName != null && obj != null)
			objects.put(jsonPropertyName, new JSONInfo(obj, objectProperties));
	}
	
	/**
	 * 删除一个待转换的java对象
	 * @param jsonPropertyName 给定JSON的属性名
	 */
	public void removeJSONObject(String jsonPropertyName){
		objects.remove(jsonPropertyName);
	}
	
	/**
	 * 判断该属性的是否存在
	 * @param jsonPropertyName 给定JSON的属性名
	 * @return 如果存在则为真,否则为假
	 */
	public boolean isJSONObject(String jsonPropertyName){
		return objects.containsKey(jsonPropertyName);
	}
	
	/**
	 * 通过给定的属性名获得java对象
	 * @param jsonPropertyName 给定JSON的属性名
	 * @return 返回java对象
	 */
	public Object getJSONObject(String jsonPropertyName){
		if(objects.get(jsonPropertyName) == null)
			return null;
		return objects.get(jsonPropertyName).getObj();
	}
	
	/**
	 * 获得封装后的JSON对象
	 * @return 返回一个JSON对象的字符串
	 */
	public String getJSON(){
		return toString();
	}
	
	/**
	 * 获得封装后的JSON对象
	 * @return 返回一个JSON对象的字符串
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
