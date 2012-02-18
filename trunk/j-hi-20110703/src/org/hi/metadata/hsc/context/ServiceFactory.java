package org.hi.metadata.hsc.context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.common.util.JAXBUtil;
import org.hi.metadata.hsc.constant.EntityType;
import org.hi.metadata.hsc.context.environment.Environment;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.ObjectFactory;
import org.hi.metadata.hsc.context.service.Service;
import org.hi.metadata.hsc.util.ServiceFilenameFilter;

import bsh.This;


public class ServiceFactory extends ObjectFactory {
	public final static String SERVICE_CONFIG_FILES_DIR_NAME = "config";
	public final static String SERVICE_CONFIG_FILES_DIR = "generater/" + SERVICE_CONFIG_FILES_DIR_NAME;
	protected final static Log logger = LogFactory.getLog("org.hi.generator.context.ServiceFactory");
	/**
	 * ���������ļ��ļ����ĺ�׺
	 */
	public final static String SERVICE_CONFIG_FILE_SUFFIX = "hsc.xml";
	
	/**
	 * ����ָ�����ļ����ط��������ļ������ط�������<code>Serivce</code>��ʵ��
	 * @param pathFile ���������ļ�ȫ��������·����
	 * @return ���ط������ö���
	 * @throws FileNotFoundException ���û�з��ָ����ķ��������ļ�
	 * @throws JAXBException ����������������ļ�ʱ�д���
	 */
	public static Service loadService(String pathFile) throws FileNotFoundException, JAXBException{
		Object obj = JAXBUtil.loadObect(Service.class, pathFile);
		return (Service)obj;
	}
	
	public static Service loadService(InputStream fileInputStream) throws FileNotFoundException, JAXBException{
		Object obj = JAXBUtil.loadObect(Service.class, fileInputStream);
		return (Service)obj;
	} 
	
	/**
	 * ���ݻ������ö������ȫ���ķ������ã�����ϵͳ������ͻ�����
	 * @param environment �������ö���
	 * @return ����ȫ����������һ��<code>Map</code>,����keyΪ��������ƣ�valueΪ�������
	 * @throws JAXBException ����������������ļ�ʱ�д���
	 * @throws IOException 
	 */
	public static Map<String, Service> loadAllService(Environment environment) throws JAXBException, IOException{
		Map<String, Service> result = new HashMap<String, Service>();
		
		result.putAll(loadSystemServiceMap());
		result.putAll(loadCustomerServiceMap(environment));
		
		return result;
	}
	
	/**
	 * ���ݻ������ö������ȫ���ķ����ö��ʵ��������Ϣ������ϵͳ������ͻ�����
	 * @param environment �������ö���
	 * @return ����ȫ������������ö��ʵ������һ��<code>Map</code>,����keyΪʵ������ƣ�valueΪʵ�����
	 * @throws JAXBException ����������������ļ�ʱ�д���
	 * @throws IOException 
	 */
	public static Map<String, Entity> loadAllEnumeration(Environment environment) throws JAXBException, IOException{
		return loadAllEnumeration(loadAllService(environment));
	}
	/**
	 * ����ȫ������Map�������ȫ���ķ����ö��ʵ��������Ϣ������ϵͳ������ͻ�����
	 * @param allServices ȫ�������һ��<code>Map</code>,����keyΪ��������ƣ�valueΪ�������
	 * @return ����ȫ������������ö��ʵ������һ��<code>Map</code>,����keyΪʵ������ƣ�valueΪʵ�����
	 */	
	public static Map<String, Entity> loadAllEnumeration( Map<String, Service> allServices) {
		Map<String, Entity> result = new HashMap<String, Entity>();
		Set<String> allServiceKey = allServices.keySet();
		for (String key : allServiceKey) {
			Service service = allServices.get(key);
			
			if(service.getEntity() == null || service.getEntity().size() == 0)
				continue;
			
			for (Entity entity : service.getEntity()) {
				if(entity.getEntityType() == EntityType.ENTITY_TYPE_ENUMERATION)
					result.put(entity.getEntityName(), entity);
			}
		}
		return result;
	}

	/**
	 * ����ָ��ʵ���뻷�����ö��󷵻ص�ǰʵ�����ڵķ���
	 * @param entity ������ʵ��
	 * @param environment �������ö���
	 * @return ����ָ��ʵ�����ڷ���
	 * @throws JAXBException ����������������ļ�ʱ�д���
	 * @throws IOException 
	 */
	public static Service getService(Entity entity,Environment environment) throws JAXBException, IOException{
		return getService(entity,loadAllService(environment));
	}
	
	/**
	 * ����ָ��ʵ���뻷�����ö��󷵻ص�ǰʵ�����ڵķ���
	 * @param entity ������ʵ��
	 * @param allServices ȫ�������һ��<code>Map</code>,����keyΪ��������ƣ�valueΪ�������
	 * @return ����ָ��ʵ�����ڷ���
	 */
	public static Service getService(Entity entity,Map<String, Service> allServices){
		Set<String> allServiceKey = allServices.keySet();
		for (String key : allServiceKey) {
			Service service = allServices.get(key);
			
			if(service.getEntity() == null || service.getEntity().size() == 0)
				continue;
			
			for (Entity tagEntity : service.getEntity()) {
				if(tagEntity.getEntityName().equals(entity.getEntityName()))
					return service;
			}
		}
		return null;
	}
	/**
	 * ����ϵͳ��������
	 * <p>����ϵͳ���������ļ�������org.hi.generator.context����
	 * @return ����ȫ��ϵͳ��������һ��<code>List</code>�б�
	 * @throws JAXBException ����������������ļ�ʱ�д���
	 * @throws IOException 
	 */
	public static List<Service> loadSystemService() throws JAXBException, IOException{
		List<Service> result = new ArrayList<Service>();
//		URL url = ServiceFactory.class.getResource("");
		Service service;
//		if(url != null ){
//			File sysConfigDir = new File(url.getFile());
//			File[] files = sysConfigDir.listFiles(new ServiceFilenameFilter());
//			
//			if(files != null){
//				for (int i = 0; i < files.length; i++) {
//					service = loadService(files[i].toString());
//					result.add(service);
//				}
//			}
//			return result;
//		}
		InputStream servicesStream = ServiceFactory.class.getResourceAsStream("services.properties");
		if(servicesStream == null)
			return null;
		
		BufferedReader r = new BufferedReader(new InputStreamReader(servicesStream, "UTF-8"));
		String serviceFileName;
		while(( serviceFileName = r.readLine() ) != null) { 
			serviceFileName = serviceFileName.trim();
			InputStream serivceInputStream = ServiceFactory.class.getResourceAsStream(serviceFileName);
			service = loadService(serivceInputStream);
			result.add(service);
		}
			
		r.close();
		
		return result;
	}
	
	/**
	 * ����ϵͳ��������
	 * <p>����ϵͳ���������ļ�������org.hi.generator.context����
	 * @return ����ȫ��ϵͳ��������һ��<code>Map</code>,����keyΪ��������ƣ�valueΪ�������
	 * @throws JAXBException ����������������ļ�ʱ�д���
	 * @throws IOException 
	 */
	public static Map<String, Service> loadSystemServiceMap() throws JAXBException, IOException{
		Map<String, Service> result = new HashMap<String, Service>();
		
		List<Service> systemServices = loadSystemService();
		
		for (Iterator iter = systemServices.iterator(); iter.hasNext();) {
			Service service = (Service) iter.next();
			result.put(service.getServiceName(), service);
		}
		
		
		return result;
	}
	
	/**
	 * ���ؿͻ���������
	 * <p>ϵͳ����ݻ��������ļ��е���environmentԪ���µ�dir����,ȷ�����������ļ���Ŀ¼
	 * ϵͳ���Զ�����config�µ�����*.hsc.xml��׺���ļ���Ϊ���������ļ�
	 * @param environment �������ö���
	 * @return �������пͻ��������õ�һ��<code>List</code>�б�
	 * @throws FileNotFoundException ���û�з��ָ����ķ��������ļ�
	 * @throws JAXBException ����������������ļ�ʱ�д���
	 */
	public static List<Service> loadCustomerService(Environment environment) throws FileNotFoundException, JAXBException{
		List<Service> result = new ArrayList<Service>();
		String dirStr = environment.getDir();// + File.separator + ServiceFactory.SERVICE_CONFIG_FILES_DIR_NAME;
		File customerDir = new File(dirStr);
		
		if(!customerDir.exists()){
			URL metadataUrl =  ServiceFactory.class.getClassLoader().getResource("../metadata");
			try {
				customerDir  =  new File(metadataUrl.toURI());
			} catch (URISyntaxException e) {
			}
		}
		File[] customerFiles = customerDir.listFiles(new ServiceFilenameFilter());
		if(customerFiles != null){
			Service service;
			for (int i = 0; i < customerFiles.length; i++) {
				service = loadService(customerFiles[i].toString());
				result.add(service);
			}
		}
		return result;
	}

	/**
	 * ���ؿͻ���������
	 * <p>ϵͳ����ݻ��������ļ��е���environmentԪ���µ�dir����,ȷ�����������ļ���Ŀ¼
	 * ϵͳ���Զ�����config�µ�����*.hsc.xml��׺���ļ���Ϊ���������ļ�
	 * @param environment �������ö���
	 * @return �������пͻ��������õ�һ��<code>Map</code>,,����keyΪ��������ƣ�valueΪ�������
	 * @throws FileNotFoundException ���û�з��ָ����ķ��������ļ�
	 * @throws JAXBException ����������������ļ�ʱ�д���
	 */
	public static Map<String, Service> loadCustomerServiceMap(Environment environment) throws FileNotFoundException, JAXBException{
		Map<String, Service> result = new HashMap<String, Service>();
		
		List<Service> customerServices = loadCustomerService(environment);
		
		for (Iterator iter = customerServices.iterator(); iter.hasNext();) {
			Service service = (Service) iter.next();
			result.put(service.getServiceName(), service);
		}
		return result;
	}
	
	
	/**
	 * ��ָ���ķ������д�뵽ָ���ķ��������ļ���
	 * @param serviceFile Ҫд��ķ��������ļ�
	 * @param service ��д��ķ������
	 * @throws JAXBException  ����������������ļ�ʱ�д���
	 * @throws IOException 
	 */
	public static void writeServiceXML(String serviceFile, Service service) throws JAXBException, IOException{
		JAXBUtil.writeObject(Service.class, service, serviceFile);
	}
	
}
