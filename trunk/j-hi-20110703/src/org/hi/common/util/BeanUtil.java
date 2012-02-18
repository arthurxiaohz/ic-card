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
 * ������POJO�������õĹ����࣬��ҪĿ���ǶԸ���������������ȡ�����øö������Ե�ֵ
 * @author ���
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
	 * ��ø�������������������Ӧ��ֵ
	 * @param bean ��������
	 * @param propertyName ������
	 * @return ���ظ����Զ�Ӧ��ֵ
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
	 * �жϸ�����bean���Ƿ����������������,���������Բ��������.
	 * �������Bean�и���������,��Ϊorg,org.manager.id�����������
	 * @param bean ��������
	 * @param propertyName ������
	 * @return ������ڸ������������򷵻�true,���򷵻�false
	 */
	public static boolean hasPropertyName(Object bean, String propertyName){
		String[] propertyNames = StringUtils.strToStrArray(propertyName, ".");
		Class clzz =  bean.getClass();
		Field field = null;
		
		for(int i = 0; i < propertyNames.length; i++){
			
			//�������Ƿ��и������Ƶ�����
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
	 * �ݹ�(ֱ�����õ�Object)�ж�clazz���Ƿ��и�������(fieldName)����,������򷵻ضԸ����Ӧ��<code>Field</code>,���򷵻ؿ�
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
			return hasClassField(clazz.getSuperclass(), fieldName); //�ݹ鴦��,ȥ�����������
		}
	}
	/**
	 * ��ø�������������������Ӧ��ֵ
	 * @param bean ��������
	 * @param propertyName ������
	 * @return ���ظ����Զ�Ӧ��ֵ,������ֵ����ΪString����
	 */
	public static String getPropertyValueToStr(Object bean, String propertyName){
		Object val = getPropertyValue(bean, propertyName);
		
		if(val == null)
			return null;
		
		return val.toString();
	}
	
	/**
	 * Ϊ����������������ֵ
	 * @param bean ��������
	 * @param propertyName ������
	 * @param value ֵ
	 */
	public static void setPropertyValue(Object bean, String propertyName, Object value){
		try {
			PropertyUtils.setProperty(bean, propertyName, value);
		} catch (Exception e) {
			log.trace("org.hi.common.util.BeanUtil.setPropertyValue propertyName:"+propertyName+" value:"+value, e);
		} 
	}
	
	
	/**
	 * ͨ��OGNL��ֵ��������ֵӳ�䵽��������,����֧�ּ�����ĸ�ֵ
	 * @param bean ��������
	 * @param propertyName ������
	 * @param value ֵ
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
	 * ͨ��OGNL��ֵ��������ֵӳ�䵽��������,����֧�ּ�����ĸ�ֵ
	 * @param bean ��������
	 * @param propertyName ������
	 * @param value ֵ
	 */
	private static void ognlPropertyValue(Object bean, String propertyName){
		
	}
	
	/**
	 * ͨ���������ȫ�޶�������һ������Ķ���ʵ�����ö�����ͨ���޲εĹ��������������ģ�
	 * @param className ���ȫ�޶���
	 * @return ���ظ������һ������
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
	 * ͨ��������clazz����Beanʵ��,ͨ��propertyNames������,ͨ��set������ֵ,��������һ��POJO����ļ���
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
				ognlPropertyValue(bean, propertyNamesArray[i], valueArray[i]);		//ͨ��OGNL�����Ͷ�����㸳ֵ
			}
			result.add(bean);
		}
	    return result;
	}
	
	
	/**
	 * ��ԴPOJO���������ֵ���Ƶ�Ŀ������������,�÷���֧�ּ��ϼ����������.
	 * <p>ע��:�ڶ�Ŀ�����ֵʱ,����Դ������������Ŀ�������������������ȫ��ͬʱ�Żḳֵ,����ϵͳ����ֵ
	 * @param resouce Դ����
	 * @param targer Ŀ�����
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
	 * �������Ĳ���collectionת��Ϊһ��xml��ʽ���ַ���
	 * @param collection ��ת��Ϊxml�ļ��϶���
	 * @param collName xml��Ԫ�ص�Ԫ����
	 * @param elementName xml�ж���Ԫ�ص�Ԫ����,Ҳ����xml����Ӧ�ļ���Ԫ�ص�Ԫ������
	 * @return ����xml��ʽ���ַ���
	 * <p>����:
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
	 * ��������POJO(bean)����ת��Ϊһ��xml��ʽ���ַ���,���������������xml�ĵ���Ԫ����
	 * @param bean ��ת��Ϊxml��POJO����
	 * @param elementName ���ص�xml�ĵ��ĸ�Ԫ�ص�Ԫ����
	 * @return ���������bean���Ӧ��xml��ʽ���ַ���
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
	 * ͨ������������Ϊһ��xml��ʽ��������(is)��������ת��Ϊָ����(clazz)��һ������
	 * @param is xml��ʽ���ַ���
	 * @param clazz ��ת����POJO�������
	 * @return ����һ��POJO����
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
	 * ��xml�ַ����ĵ�ת��Ϊһ��POJO����
	 * @param xml ��ת����XML�ĵ���ʽ���ַ���
	 * @param clazz ��ת����POJO�������
	 * @return ����һ��POJO����
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
					ParameterizedType type = (ParameterizedType)field.getGenericType(); //�ҵ���������Ӧ������  
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
						!propertyClass.equals(Date.class) && !propertyClass.equals(Timestamp.class)){	//�������ԭʼ����
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
	 * �������clazz��ԭʼ����,�򷵻����ԭʼ��������Ӧ�İ�װ�������,���򷵻ظ����ͱ���
	 * @param clazz ��������������
	 * @return �����ԭʼ�����򷵻������Ӧ�İ�װ�������,���򷵻ض������ͱ���
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
	 * ͨ��������POJO���Ϸ��ظ�POJOȫ������һ��JSON�ַ���
	 * @param col ���϶���
	 * @param collName ������JSON�е�������
	 * @return ����һ��JSON�ַ���
	 */
	public static String getCollection2JSON(Collection col, String collName){
		return getCollection2JSON(col, collName, null, false);
	}
	/**
	 * ͨ��������POJO���Ϸ���һ��JSON�ַ���
	 * @param col ���϶���
	 * @param collName ������JSON�е�������
	 * @param properies ����JSON�ַ�����ӦPOJO��������,����HiUser��POJO "id,org.orgName,org.id"
	 * @return ����һ��JSON�ַ���
	 */
	public static String getCollection2JSON(Collection col, String collName , String properies, boolean isObject){
		if(col == null)
			return "";
		StringBuffer sb = new StringBuffer("");
		if(isObject)
			sb.append("{");
		if(collName != null){
			sb.append("\"").append(collName).append("\""); //������JSON�еı�����
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
		sb.append("[");								//�Ӽ�����JSON�е������ʶ��
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
	 * ͨ��������POJO���ظ�POJOȫ������һ��JSON�ַ���
	 * @param bean POJO����
	 * @return ����һ��JSON�ַ���
	 */		
	public static String getBean2JSON(Object bean){
		return getBean2JSON(bean, null);
	}
	
	
	/**
	 * ͨ��������POJO����һ��JSON�ַ���
	 * @param bean POJO����
	 * @param properies ����JSON�ַ�����ӦPOJO��������,����HiUser��POJO "id,org.orgName,org.id"
	 * @return ����һ��JSON�ַ���
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
			sb.append("\"").append(propertyName).append("\""); 	//��JSON��������
			sb.append(":");										//��JSON����������ֵ�ķָ���:
			
			if(Collection.class.isAssignableFrom(propertyClazz)){
				String collProperties = null;
				if(entry.getValue() != null)
					collProperties = StringUtils.CollectionToStr(entry.getValue());
				
				sb.append(getCollection2JSONValue((Collection)val, propertyName, collProperties));
			}
			else if(BaseObject.class.isAssignableFrom(propertyClazz)){	//˵����domainObject
				if((entry.getValue() != null) || level < 1){
					if(val == null){
						Class properyClass = getProperyClass(bean, propertyName);
						val = BeanUtil.CreateObject(properyClass.getName());
					}
						sb.append(getBean2JSON(val, entry.getValue() == null ? null : StringUtils.CollectionToStr(entry.getValue()), ++level)); //��һ����level��1
						level--; //��Ϊ��һ����ƽ���ٽ�level��1
				}
				if(entry.getValue() == null  && level >= 1) //�������2����domainObject�͸�json����ֵ
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
					sb.append(getPropertyValueToStr(bean, propertyName));	//��JSON��ֵ
				
				
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
            
            Object param = clazz.newInstance();		//�½�ʵ��
            Ognl.setValue(propName, context, target, param);	//�ݹ����?
            return param;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}