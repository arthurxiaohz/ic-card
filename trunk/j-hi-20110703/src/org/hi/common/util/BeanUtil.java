package org.hi.common.util;


import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import ognl.NullHandler;
import ognl.Ognl;
import ognl.OgnlException;
import ognl.OgnlRuntime;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.framework.model.BaseObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 该类是POJO属性设置的工具类，主要目的是对给定对象及属性名获取与设置该对象属性的值
 * @author 张昊
 * @since 2007-07-26
 */
public class BeanUtil {
	
	protected final static Log log = LogFactory.getLog("org.hi.common.util.BeanUtil");
	
	private final static Set<String> unIncludes = new HashSet<String>();
	static{
		unIncludes.add("class");
		unIncludes.add("parentEntity");
		unIncludes.add("oldValue");
		unIncludes.add("dirty");
		unIncludes.add("dataSymbol");
		unIncludes.add("cascadeDirty");
		unIncludes.add("target");
		unIncludes.add("targetParent");
		unIncludes.add("primarykey");
	}
	
	/**
	 * 获得给定对象与属性名所对应的值
	 * @param bean 给定对象
	 * @param propertyName 属性名
	 * @return 返回该属性对应的值
	 */
	public static Object getPropertyValue(Object bean, String propertyName){
		try {
			return PropertyUtils.getProperty(bean, propertyName);
			
		} catch (Exception e) {
			if(!hasPropertyName(bean, propertyName))
				log.trace("org.hi.common.util.BeanUtil.getPropertyValue propertyName:"+propertyName, e);
			return null;
		}
	}
	
	/**
	 * 判断给定的bean下是否包括给定的属性名,属性名可以不限制深度.
	 * 例如给定Bean有个部门属性,名为org,org.manager.id是深度属性名
	 * @param bean 给定对象
	 * @param propertyName 属性名
	 * @return 如果存在给定的属性名则返回true,否则返回false
	 */
	public static boolean hasPropertyName(Object bean, String propertyName){
		String[] propertyNames = StringUtils.strToStrArray(propertyName, ".");
		Class clzz =  bean.getClass();
		Field field = null;
		
		for(int i = 0; i < propertyNames.length; i++){
			
			//类型中是否有给定名称的属性
			field = hasClassField(clzz, propertyNames[i]);
			if(field == null)
				return false;
			
			clzz = field.getType();
		}

		return true;
	}
	
	public static Class getProperyClass(Object bean, String propertyName){
		try {
			return PropertyUtils.getPropertyType(bean, propertyName);
			
		} catch (Exception e) {
			log.trace("org.hi.common.util.BeanUtil.getProperyClass propertyName:" + propertyName, e);
		} 
		return null;
	}
	
	
	/**
	 * 递归(直至调用的Object)判断clazz中是否有给定域名(fieldName)的域,如果有则返回对该域对应的<code>Field</code>,否则返回空
	 * @param clzz
	 * @param fieldName
	 * @return
	 */
	private static Field hasClassField(Class clazz, String fieldName){
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (Exception e) {
			if(clazz.equals(Object.class))
				return null;
			return hasClassField(clazz.getSuperclass(), fieldName); //递归处理,去父类的属性名
		}
	}
	/**
	 * 获得给定对象与属性名所对应的值
	 * @param bean 给定对象
	 * @param propertyName 属性名
	 * @return 返回该属性对应的值,并将该值造型为String类型
	 */
	public static String getPropertyValueToStr(Object bean, String propertyName){
		Object val = getPropertyValue(bean, propertyName);
		
		if(val == null)
			return null;
		
		return val.toString();
	}
	
	/**
	 * 为给定对象属性设置值
	 * @param bean 给定对象
	 * @param propertyName 属性名
	 * @param value 值
	 */
	public static void setPropertyValue(Object bean, String propertyName, Object value){
		try {
			PropertyUtils.setProperty(bean, propertyName, value);
		} catch (Exception e) {
			log.trace("org.hi.common.util.BeanUtil.setPropertyValue propertyName:"+propertyName+" value:"+value, e);
		} 
	}
	
	
	/**
	 * 通过OGNL赋值，将属性值映射到对象树中,但不支持集合类的赋值
	 * @param bean 给定对象
	 * @param propertyName 属性名
	 * @param value 值
	 */
	public static void ognlPropertyValue(Object bean, String propertyName, Object value){
		try {
			NullHandler oldNullHandler = OgnlRuntime.getNullHandler(Object.class);
			OgnlRuntime.setNullHandler(Object.class, new StanderNullHandler());
			Ognl.setValue(propertyName, bean, value);
			OgnlRuntime.setNullHandler(Object.class, oldNullHandler);
		} catch (OgnlException e) {
			log.trace("OgnlException", e);
		}
	}

	/**
	 * 通过OGNL赋值，将属性值映射到对象树中,但不支持集合类的赋值
	 * @param bean 给定对象
	 * @param propertyName 属性名
	 * @param value 值
	 */
	private static void ognlPropertyValue(Object bean, String propertyName){
		
	}
	
	/**
	 * 通过给定类的全限定名返回一个该类的对象实例（该对象是通过无参的构建器创建出来的）
	 * @param className 类的全限定名
	 * @return 返回给定类的一个对象
	 */
	public static Object CreateObject(String className){
		Object obj=null;
		try {
			obj= Class.forName(className,true,Thread.currentThread().getContextClassLoader()).newInstance();
		} catch (Exception e) {
			log.trace("org.hi.common.util.BeanUtil.CreateObject className:"+className, e);
		}
		return obj;
	}
	
	/**
	 * 通过给定的clazz创建Bean实例,通过propertyNames赋属性,通过set赋属性值,并将返回一个POJO对象的集合
	 * @deprecated
	 * @param set
	 * @param propertyNames
	 * @param clazz
	 * @return
	 */
	protected static List encapsulationBeans(List set, String propertyNames, Class clazz){
		List result = new ArrayList();
	    String[] propertyNamesArray = StringUtils.strToStrArray(propertyNames);
        for (Iterator iter = set.iterator(); iter.hasNext();) {
        	Object bean = CreateObject(clazz.getName());
			
			Object obj = iter.next();
			Object[] valueArray = null;
			if(obj.getClass().isArray()){
				valueArray = (Object[])obj;
			}
			else{
				valueArray = new Object[1];
				valueArray[0] = obj;
			}
			
			for (int i = 0; i < valueArray.length; i++) {
				ognlPropertyValue(bean, propertyNamesArray[i], valueArray[i]);		//通过OGNL对树型对象深层赋值
			}
			result.add(bean);
		}
	    return result;
	}
	
	
	/**
	 * 将源POJO对象的属性值复制到目标对象的属性中,该方法支持集合及域对象属性.
	 * <p>注意:在对目标对象赋值时,仅对源对象中属性与目标对象属性名及类型完全相同时才会赋值,否则系统不赋值
	 * @param resouce 源对象
	 * @param targer 目标对象
	 */
	public static void setBean2Bean(Object resouce, Object targer){
		PropertyDescriptor[] targerProperties = PropertyUtils.getPropertyDescriptors(targer);
		PropertyDescriptor[] resouceProperties = PropertyUtils.getPropertyDescriptors(resouce);
		for (PropertyDescriptor resouceDescriptor : resouceProperties) {
			String resourceName =  resouceDescriptor.getName();
			Class resourceClass = resouceDescriptor.getPropertyType();
			for (PropertyDescriptor targerDescriptor : targerProperties) {
				String targerName =  targerDescriptor.getName();
				Class targerClass = targerDescriptor.getPropertyType();
				if(resourceName.equals(targerName) && resourceClass.equals(targerClass)){
					try{
						Object val = getPropertyValue(resouce,resourceName);
						if(val == null) break;
						
						if(val instanceof Collection){
							Collection resourceCol = (Collection)val;
							if(resourceCol.size() < 1) break;
							Collection targerCol  = null;
							if(val instanceof List)
								targerCol =  new ArrayList();
							else if(val instanceof Set)
								targerCol = new LinkedHashSet();
							else
								targerCol =  (Collection)CreateObject(val.getClass().getName());;
							Field field = null;
							try{
								field = targer.getClass().getDeclaredField(targerName);
							}catch(NoSuchFieldException e){
								field = targer.getClass().getSuperclass().getDeclaredField(targerName);
							}
							field.setAccessible(true);
							field.set(targer, targerCol);
							targerDescriptor.setValue(targerName, targerCol);
							for (Object resourceObj : resourceCol) {
								Object targerObj = CreateObject(resourceObj.getClass().getName());
								setBean2Bean(resourceObj, targerObj);
								targerCol.add(targerObj);
							}
						}
						else
							setPropertyValue(targer, targerName, getPropertyValue(resouce,resourceName));
					}
					catch (Throwable e) {}
					break;
				}
			}
		}
	}
	
	/**
	 * 将给定的参数collection转换为一个xml格式的字符串
	 * @param collection 待转换为xml的集合对象
	 * @param collName xml根元素的元素名
	 * @param elementName xml中二级元素的元素名,也就是xml所对应的集合元素的元素名称
	 * @return 返回xml格式的字符串
	 * <p>例如:
	 * <P>&lt;collName&gt;</P>
	 * <P align=left>&nbsp; &lt;elementName&gt;</P>
	 * <P align=left>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ...</P>
	 * <P align=left>&nbsp; &lt;/elementName&gt;</P>
	 * <P align=left>&nbsp;&nbsp;&nbsp;&nbsp; ...</P>
	 * <P align=left>&nbsp; &lt;elementName&gt;</P>
	 * <P align=left>&nbsp; &lt;/elementName&gt;</P>
	 * <P>&lt;/collName&gt;</P>&nbsp;
	 */
	public static String getCollection2XML(Collection<Object> collection, String collName, String elementName ){
		if(collection == null || collection.size() == 0) return ""; 
		StringBuffer sb = new StringBuffer("<"+collName+">").append("\n");
		for (Object object : collection) 
			sb.append(getBean2XML(object, elementName, 1, new StringBuffer(),  new HashSet<String>()));
		sb.append("</" + collName +">");
		
		return sb.toString();
	}
	
	/**
	 * 将给定的POJO(bean)对象转换为一个xml格式的字符串,对象的属性名就是xml文档的元素名
	 * @param bean 待转换为xml的POJO对象
	 * @param elementName 返回的xml文档的根元素的元素名
	 * @return 返回与参数bean相对应的xml格式的字符串
	 */
	public static String getBean2XML(Object bean, String elementName){
		String xml = getBean2XML(bean, elementName, 0, new StringBuffer(), new HashSet<String>());
		return xml;
	}
	
	private static String getBean2XML(Object bean, String elementName, int deep, StringBuffer sb, Set<String> classes){
		if(bean == null)
			return null;
		try{bean.hashCode();}
		catch (Exception e) {return null;}
		String beanHash = String.valueOf(bean.hashCode());
		if(classes.contains(beanHash) && !originalType(bean))
			return null;
		else
			classes.add(beanHash);
		
		if(bean instanceof Collection){
			for (Object obj : (Collection)bean) {
				getBean2XML(obj,elementName, deep, sb, classes);
			}
		}
		
		else{
			for (int i = 0; i < deep; i++) 
				sb.append("\t");
			
			if(elementName == null)
				elementName = StringUtils.lowerFrist(bean.getClass().getSimpleName());
			
				sb.append("<").append(elementName).append(">");
			if(!originalType(bean))
				sb.append("\n");
		}
		
		if (originalType(bean)){
			if(bean instanceof Date)
				sb.append(StringUtils.DateToStr((Date)bean, "yyyy-MM-dd HH:mm:ss"));
			else if(bean instanceof String){
				bean = StringUtils.replace((String)bean, "<", "&lt;");
				bean = StringUtils.replace((String)bean, ">", "&gt;");
				bean = StringUtils.replace((String)bean, "&", "&amp;");
				sb.append(bean);
			}
			else
				sb.append(bean.toString());
		}
		
		else{

			PropertyDescriptor[] beanProperties = PropertyUtils.getPropertyDescriptors(bean);
			for (PropertyDescriptor propertyDescriptor : beanProperties) {
				if(propertyDescriptor.getReadMethod() == null || propertyDescriptor.getWriteMethod() == null)
					continue;
				String propertyName = propertyDescriptor.getName();
				Object propertyValue = getPropertyValue(bean, propertyName);
				
				getBean2XML(propertyValue, propertyName, deep+1, sb, classes);
			}
		}
		
		if(!(bean instanceof Collection)){
			if(!originalType(bean))
				for (int i = 0; i < deep; i++) 
					sb.append("\t");
			
			sb.append("</").append(elementName).append(">").append("\n");
		}
		return sb.toString();	
	}
	
	protected static boolean originalType(Object bean){
		return bean instanceof Boolean || bean instanceof Character
			|| bean instanceof Double || bean instanceof Float
			|| bean instanceof Integer || bean instanceof Long
			|| bean instanceof Short || bean instanceof String
			|| bean instanceof Date || bean instanceof Locale
			|| bean instanceof Timestamp;
		
	}
	
	/**
	 * 通过给定的内容为一个xml格式的输入流(is)将该内容转换为指定的(clazz)的一个对象
	 * @param is xml格式的字符流
	 * @param clazz 待转换成POJO对象的类
	 * @return 返回一个POJO对象
	 */
	public static Object getXML2BeanByInputStream(InputStream is, Class clazz){
		if(is == null)
			return null;
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
		try{
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			return getXML2Bean(doc.getDocumentElement(), clazz);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	
	/**
	 * 将xml字符串文档转换为一个POJO对象
	 * @param xml 待转换的XML文档格式的字符串
	 * @param clazz 待转换成POJO对象的类
	 * @return 返回一个POJO对象
	 */
	public static Object getXML2Bean(String xml, Class clazz){
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(xml.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return getXML2BeanByInputStream(is, clazz);
	}
	
	private static Object getXML2Bean(Node node, Class clazz) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ParseException, NoSuchFieldException {
		Object bean = CreateObject(clazz.getName());
		PropertyDescriptor[] beanProperties = PropertyUtils.getPropertyDescriptors(bean);
		NodeList nodeList = node.getChildNodes();
		
		for (PropertyDescriptor propertyDescriptor : beanProperties) {
			if(propertyDescriptor.getReadMethod() == null || propertyDescriptor.getWriteMethod() == null)
				continue;
			String propertyName = propertyDescriptor.getName();
			Class propertyClass = originalWrapper(propertyDescriptor.getPropertyType());
			Object value = null;
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node propertyNode = nodeList.item(i);
				if(propertyNode.getNodeType() != Node.ELEMENT_NODE)
					continue;
				Element element = (Element)propertyNode;
				if(!element.getTagName().equals(propertyName))
					continue;
				
				
				if (Collection.class.isAssignableFrom(propertyClass)){
					if(getPropertyValue(bean, propertyName) != null)
						continue;
					
					Field field = hasClassField(clazz, propertyName);
					ParameterizedType type = (ParameterizedType)field.getGenericType(); //找到泛型所对应的类型  
					Type[] types = type.getActualTypeArguments();
					Class elementClass = (Class)types[0];
					
					
					Collection deails = null;
					if(List.class.isAssignableFrom(propertyClass))
						deails = new ArrayList();
					if(Set.class.isAssignableFrom(propertyClass))
						deails = new HashSet();
					
					for (int j = 0; j < nodeList.getLength(); j++) {
						Node elementNode = nodeList.item(j);
						if(elementNode.getNodeType() != Node.ELEMENT_NODE)
							continue;
						Element nodeElement = (Element)elementNode;
						if(!nodeElement.getTagName().equals(propertyName))
							continue;
						
						deails.add(getXML2Bean(nodeElement, elementClass));
					}
					
					
					setPropertyValue(bean, propertyName, deails);
					continue;
				}

				
				if(!propertyClass.equals(Boolean.class) && !propertyClass.equals(Character.class) &&
						!propertyClass.equals(Double.class) && !propertyClass.equals(Float.class) && 
						!propertyClass.equals(Integer.class) && !propertyClass.equals(Long.class) && 
						!propertyClass.equals(Short.class) && !propertyClass.equals(String.class) && 
						!propertyClass.equals(Date.class) && !propertyClass.equals(Timestamp.class)){	//如果不是原始类型
					value = getXML2Bean(element, propertyClass);
					setPropertyValue(bean, propertyName, value);
					continue;
				}
				
				
				String textContent = element.getTextContent();
				if(propertyClass.equals(Date.class) || propertyClass.equals(Timestamp.class)){
					SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
					value = formatter.parse(textContent);
					if(propertyClass.equals(Timestamp.class)){
						value = new Timestamp(((Date)value).getTime());
					}
				}
				else{
					Constructor constructor = propertyClass.getConstructor(String.class);
					value = constructor.newInstance(textContent);
				}
				setPropertyValue(bean, propertyName, value);
			}
			
		}
		
		return bean;
	}
	
	/**
	 * 如果参数clazz是原始类型,则返回与该原始类型所对应的包装类的类型,否则返回该类型本身
	 * @param clazz 该验测的数据类型
	 * @return 如果是原始类型则返回与其对应的包装类的类型,否则返回对与类型本身
	 */
	public static Class originalWrapper(Class clazz){
		if(clazz.equals(boolean.class))return Boolean.class;
		if(clazz.equals(int.class))return Integer.class;
		if(clazz.equals(double.class))return Double.class;
		if(clazz.equals(float.class))return Float.class;
		if(clazz.equals(char.class))return Character.class;
		if(clazz.equals(long.class))return Long.class;
		if(clazz.equals(short.class))return Short.class;
		return clazz;
	}
	
	/**
	 * 通过给定的POJO集合返回该POJO全部属性一个JSON字符串
	 * @param col 集合对象
	 * @param collName 集合在JSON中的属性名
	 * @return 返回一个JSON字符串
	 */
	public static String getCollection2JSON(Collection col, String collName){
		return getCollection2JSON(col, collName, null, false);
	}
	/**
	 * 通过给定的POJO集合返回一个JSON字符串
	 * @param col 集合对象
	 * @param collName 集合在JSON中的属性名
	 * @param properies 返回JSON字符串对应POJO的属性名,例如HiUser的POJO "id,org.orgName,org.id"
	 * @return 返回一个JSON字符串
	 */
	public static String getCollection2JSON(Collection col, String collName , String properies, boolean isObject){
		if(col == null)
			return "";
		StringBuffer sb = new StringBuffer("");
		if(isObject)
			sb.append("{");
		if(collName != null){
			sb.append("\"").append(collName).append("\""); //集合在JSON中的变量名
			sb.append(":");	
		}
		sb.append(getCollection2JSONValue(col, collName, properies));
		
		if(isObject)
			sb.append("}");
		return sb.toString();
	}
	
	protected static String getCollection2JSONValue(Collection col, String collName , String properies){
		if(col == null)
			return "[]";
		
		StringBuffer sb = new StringBuffer("");
		sb.append("[");								//加集合在JSON中的数组标识符
		int i = 0;
		for (Object object : col) {
			if(i >0)
				sb.append(",");
			i++;
			sb.append(getBean2JSON(object, properies));
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	/**
	 * 通过给定的POJO返回该POJO全部属性一个JSON字符串
	 * @param bean POJO对象
	 * @return 返回一个JSON字符串
	 */		
	public static String getBean2JSON(Object bean){
		return getBean2JSON(bean, null);
	}
	
	
	/**
	 * 通过给定的POJO返回一个JSON字符串
	 * @param bean POJO对象
	 * @param properies 返回JSON字符串对应POJO的属性名,例如HiUser的POJO "id,org.orgName,org.id"
	 * @return 返回一个JSON字符串
	 */	
	
	public static String getBean2JSON(Object bean, String properies){
		return getBean2JSON(bean, properies, 0);
	}
	
	private static String getBean2JSON(Object bean, String properies, int level){
		if(bean == null)
			return "";
		StringBuffer sb = new StringBuffer("{");
		List<String> propertisList = new ArrayList<String>();
		if(properies ==null){
			PropertyDescriptor[] beanProperties = PropertyUtils.getPropertyDescriptors(bean);
			String propertyName;
			for (PropertyDescriptor propertyDescriptor : beanProperties) {
				propertyName = propertyDescriptor.getName();
				if(unIncludes.contains(propertyName))
					continue;
				propertisList.add(propertyName);
			}
		}
		else{
			propertisList = StringUtils.strToArrayList(properies);
		}
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String propertyName : propertisList) {
			if(propertyName.indexOf(".") > 0){
				int index= propertyName.indexOf(".");
				String domainName = propertyName.substring(0, index);
				String endName = propertyName.substring(index+1);
				if(map.get(domainName) == null){
					List<String> doaminProperties = new ArrayList<String>();
					doaminProperties.add(endName);
					map.put(domainName, doaminProperties);
				}
				else{
					map.get(domainName).add(endName);
				}
			}
			else
				map.put(propertyName, null);
		}
		
		int i = 0;
		for(Map.Entry<String, List<String>> entry: map.entrySet()) {
			
			if(i > 0)
				sb.append(",");
			i++;
			String propertyName = entry.getKey();
			
			Object val = getPropertyValue(bean, propertyName);
			Class propertyClazz = getProperyClass(bean, propertyName);
			sb.append("\"").append(propertyName).append("\""); 	//加JSON的属性名
			sb.append(":");										//加JSON的属性名与值的分隔符:
			
			if(Collection.class.isAssignableFrom(propertyClazz)){
				String collProperties = null;
				if(entry.getValue() != null)
					collProperties = StringUtils.CollectionToStr(entry.getValue());
				
				sb.append(getCollection2JSONValue((Collection)val, propertyName, collProperties));
			}
			else if(BaseObject.class.isAssignableFrom(propertyClazz)){	//说明是domainObject
				if((entry.getValue() != null) || level < 1){
					if(val == null){
						Class properyClass = getProperyClass(bean, propertyName);
						val = BeanUtil.CreateObject(properyClass.getName());
					}
						sb.append(getBean2JSON(val, entry.getValue() == null ? null : StringUtils.CollectionToStr(entry.getValue()), ++level)); //下一级将level加1
						level--; //因为下一个是平级再将level减1
				}
				if(entry.getValue() == null  && level >= 1) //如果到第2级的domainObject就给json赋空值
					sb.append("\"\"");
				
			}
			else{
					sb.append("\"");
				if(val == null)
					sb.append("");
				else if(val instanceof Date)
					sb.append(StringUtils.DateToStr((Date)val, "yyyy-MM-dd"));
				else if(val instanceof Timestamp){
					sb.append(StringUtils.DateToStr(new Date(((Timestamp)val).getTime()), "yyyy-MM-dd hh:mm:ss"));
				}
				else
					sb.append(getPropertyValueToStr(bean, propertyName));	//加JSON的值
				
				
					sb.append("\"");
			}
		}
		
		sb.append("}");
		return sb.toString();
	}
}


class StanderNullHandler implements NullHandler {
	
    public StanderNullHandler() {
        super();
    }
    
    public Object nullMethodResult(Map context, Object target, String methodName, Object[] args) {
        return null;
    }
    
    public Object nullPropertyValue(Map context, Object target, Object property) {
        try {
            String propName = property.toString();
            Class clazz = OgnlRuntime.getPropertyDescriptor(target.getClass(), propName).getPropertyType();
            
            if (Collection.class.isAssignableFrom(clazz)) {
                return new ArrayList();
            } else if (clazz == Map.class) {
                return new HashMap();
            }
            
            Object param = clazz.newInstance();		//新建实例
            Ognl.setValue(propName, context, target, param);	//递归调用?
            return param;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}