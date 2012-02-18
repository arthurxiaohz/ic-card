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
	 * 服务配置文件文件名的后缀
	 */
	public final static String SERVICE_CONFIG_FILE_SUFFIX = "hsc.xml";
	
	/**
	 * 根据指定的文件加载服务配置文件并返回服务配置<code>Serivce</code>的实例
	 * @param pathFile 服务配置文件全名，包括路径名
	 * @return 返回服务配置对象
	 * @throws FileNotFoundException 如果没有发现给定的服务配置文件
	 * @throws JAXBException 如果解析环境服务文件时有错误
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
	 * 根据环境配置对象加载全部的服务配置，包括系统服务与客户服务
	 * @param environment 环境配置对象
	 * @return 返回全部服务对象的一个<code>Map</code>,其中key为服务的名称，value为服务对象
	 * @throws JAXBException 如果解析环境服务文件时有错误
	 * @throws IOException 
	 */
	public static Map<String, Service> loadAllService(Environment environment) throws JAXBException, IOException{
		Map<String, Service> result = new HashMap<String, Service>();
		
		result.putAll(loadSystemServiceMap());
		result.putAll(loadCustomerServiceMap(environment));
		
		return result;
	}
	
	/**
	 * 根据环境配置对象加载全部的服务的枚举实体配置信息，包括系统服务与客户服务
	 * @param environment 环境配置对象
	 * @return 返回全部服务下所有枚举实体对象的一个<code>Map</code>,其中key为实体的名称，value为实体对象
	 * @throws JAXBException 如果解析环境服务文件时有错误
	 * @throws IOException 
	 */
	public static Map<String, Entity> loadAllEnumeration(Environment environment) throws JAXBException, IOException{
		return loadAllEnumeration(loadAllService(environment));
	}
	/**
	 * 根据全部服务Map对象加载全部的服务的枚举实体配置信息，包括系统服务与客户服务
	 * @param allServices 全部服务的一个<code>Map</code>,其中key为服务的名称，value为服务对象
	 * @return 返回全部服务下所有枚举实体对象的一个<code>Map</code>,其中key为实体的名称，value为实体对象
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
	 * 根据指定实体与环境配置对象返回当前实体所在的服务
	 * @param entity 给定的实体
	 * @param environment 环境配置对象
	 * @return 返回指定实体所在服务
	 * @throws JAXBException 如果解析环境服务文件时有错误
	 * @throws IOException 
	 */
	public static Service getService(Entity entity,Environment environment) throws JAXBException, IOException{
		return getService(entity,loadAllService(environment));
	}
	
	/**
	 * 根据指定实体与环境配置对象返回当前实体所在的服务
	 * @param entity 给定的实体
	 * @param allServices 全部服务的一个<code>Map</code>,其中key为服务的名称，value为服务对象
	 * @return 返回指定实体所在服务
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
	 * 加载系统服务配置
	 * <p>所有系统服务配置文件均放在org.hi.generator.context包下
	 * @return 返回全部系统服务对象的一个<code>List</code>列表
	 * @throws JAXBException 如果解析环境服务文件时有错误
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
	 * 加载系统服务配置
	 * <p>所有系统服务配置文件均放在org.hi.generator.context包下
	 * @return 返回全部系统服务对象的一个<code>Map</code>,其中key为服务的名称，value为服务对象
	 * @throws JAXBException 如果解析环境服务文件时有错误
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
	 * 加载客户服务配置
	 * <p>系统会根据环境配置文件中的在environment元素下的dir属性,确定服务配置文件的目录
	 * 系统会自动加载config下的所有*.hsc.xml后缀的文件作为服务配置文件
	 * @param environment 环境配置对象
	 * @return 返回所有客户服务配置的一个<code>List</code>列表
	 * @throws FileNotFoundException 如果没有发现给定的服务配置文件
	 * @throws JAXBException 如果解析环境服务文件时有错误
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
	 * 加载客户服务配置
	 * <p>系统会根据环境配置文件中的在environment元素下的dir属性,确定服务配置文件的目录
	 * 系统会自动加载config下的所有*.hsc.xml后缀的文件作为服务配置文件
	 * @param environment 环境配置对象
	 * @return 返回所有客户服务配置的一个<code>Map</code>,,其中key为服务的名称，value为服务对象
	 * @throws FileNotFoundException 如果没有发现给定的服务配置文件
	 * @throws JAXBException 如果解析环境服务文件时有错误
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
	 * 将指定的服务对象写入到指定的服务配置文件中
	 * @param serviceFile 要写入的服务配置文件
	 * @param service 等写入的服务对象
	 * @throws JAXBException  如果解析环境服务文件时有错误
	 * @throws IOException 
	 */
	public static void writeServiceXML(String serviceFile, Service service) throws JAXBException, IOException{
		JAXBUtil.writeObject(Service.class, service, serviceFile);
	}
	
}
