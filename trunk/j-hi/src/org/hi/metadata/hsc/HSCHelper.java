package org.hi.metadata.hsc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.metadata.hsc.context.EnvironmentFactory;
import org.hi.metadata.hsc.context.ServiceFactory;
import org.hi.metadata.hsc.context.environment.Environment;
import org.hi.metadata.hsc.context.service.ChildEntity;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.ExtendEntity;
import org.hi.metadata.hsc.context.service.Field;
import org.hi.metadata.hsc.context.service.Service;


/**
 * @author 张昊
 * @since 2010-01-20
 * @deprecated
 *
 */
public class HSCHelper {
	private static Environment environment;
	private static Map<String, Service> allService;
	protected final static Log logger = LogFactory.getLog("org.hi.metadata.hsc.HSCHelper");
	public static Map<String, Service> getAllService(String servletRootDir) throws JAXBException, IOException{
		getEnvironment(servletRootDir);
		if(allService == null)
			allService = ServiceFactory.loadAllService(environment);
		return allService;
	}
	
	/**
	 * @param servletRootDir
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Map<String, Entity> getAllEnumeration(String servletRootDir) throws JAXBException, IOException{
		if(allService == null)
			getAllService(servletRootDir);
		return ServiceFactory.loadAllEnumeration(allService);
	}
	
	/**
	 * @param servletRootDir
	 * @return
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 * @deprecated
	 */
	public static Map<String, Service> getServices(String servletRootDir) throws FileNotFoundException, JAXBException{
		getEnvironment(servletRootDir);
		return ServiceFactory.loadCustomerServiceMap(environment);
	}
	
	/**
	 * @param servletRootDir
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static List<Entity> getAllEntity(String servletRootDir) throws JAXBException, IOException{
		List<Entity> entitis = new ArrayList<Entity>();
		getAllService(servletRootDir);
		for (Entry<String, Service> entry : allService.entrySet()) {
			entitis.addAll(entry.getValue().getEntity());
		}
		return entitis;
	}
	
	/**
	 * @param servletRootDir
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static List<Entity> getEntities(String servletRootDir) throws JAXBException, IOException{
		List<Entity> entitis = new ArrayList<Entity>();
		Map<String, Service> services = getServices(servletRootDir);
		for (Entry<String, Service> entry : services.entrySet()) {
			entitis.addAll(entry.getValue().getEntity());
		}
		return entitis;
	}
	
	
	/**
	 * @param servletRootDir
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Entity getEntity(String servletRootDir, Class clazz) throws JAXBException, IOException{
		Map<String, Service> services = getAllService(servletRootDir);
		for (Entry<String, Service> entry : services.entrySet()) {
			Service service = entry.getValue();
			List<Entity> entits = service.getEntity();
			for (Entity entity : entits) {
				if(entity.getEntityName().equals(clazz.getSimpleName())
						&&	clazz.getName().contains(service.getPackageName()))
					return entity;
			}
		}
		return null;
	}
	
	/**
	 * @param servletRootDir
	 * @param clazz
	 * @param propertyName
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Field getField(String servletRootDir, Class clazz, String propertyName) throws JAXBException, IOException{
		Entity entity = getEntity(servletRootDir, clazz);
		return getField(servletRootDir, entity, propertyName);
	}
	
	/**
	 * @param servletRootDir
	 * @param entity
	 * @param propertyName
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Field getField(String servletRootDir, Entity entity, String propertyName) throws JAXBException, IOException{
		String[] propertis = propertyName.split("[.]");

			Field currentField = null;
			
			for (Field field : entity.getField()) {
				if(field.getFieldName().equals(propertis[0]))
					currentField = field;
			}
			
			if(propertis.length == 1)
				return currentField;
		
			String entityName = currentField.getLookupEntity().getLkEntityName();
			String serviceName = currentField.getLookupEntity().getLkServiceName();
			Entity domainEntity = getEntity(servletRootDir, entityName, serviceName);
			String domainPropertyName = "";
			for (int i = 1; i <= propertis.length - 1; i++) {
				domainPropertyName += propertis[i];
			}
			
			return getField(servletRootDir, domainEntity, domainPropertyName);
	}
	
	/**
	 * @param servletRootDir
	 * @param entityName
	 * @param serviceName
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Entity getEntity(String servletRootDir, String entityName, String serviceName) throws JAXBException, IOException{
		Map<String, Service> services = getAllService(servletRootDir);
		for (Entry<String, Service> entry : services.entrySet()) {
			Service service = entry.getValue();
			List<Entity> entits = service.getEntity();
			for (Entity entity : entits) {
				if(entity.getEntityName().equals(entityName)
						&&	service.getServiceName().equals(serviceName))
					return entity;
			}
		}
		return null;
	}
	
	/**
	 * @param servletRootDir
	 * @param entityName
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Entity getEntity(String servletRootDir, String entityName) throws JAXBException, IOException{
		Map<String, Service> services = getAllService(servletRootDir);
		for (Entry<String, Service> entry : services.entrySet()) {
			Service service = entry.getValue();
			List<Entity> entits = service.getEntity();
			for (Entity entity : entits) {
				if(entity.getEntityName().equals(entityName))
					return entity;
			}
		}
		return null;
	}
	
	/**
	 * 获取从实例列表
	 * @param servletRootDir
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static List<Entity> getItemEntities(String servletRootDir, Class clazz) throws JAXBException, IOException{
		List<Entity> result = new ArrayList<Entity>();
		Entity masterEntity = getEntity(servletRootDir, clazz);
		List<ChildEntity> childs = masterEntity.getChildEntity();
		for (ChildEntity childEntity : childs) {
			result.add(getEntity(servletRootDir, childEntity.getChildEntityName(), childEntity.getChildServiceName()));
		}
		return result;
	}
	
	/**
	 * 获取当前实体的继承的父实体
	 * @param servletRootDir
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Entity getParentEntity(String servletRootDir, Class clazz) throws JAXBException, IOException{
		Entity entity = getEntity(servletRootDir, clazz);
		ExtendEntity exEntity = entity.getExtendEntity();
		if(exEntity == null || exEntity.getExtendEntityName() == null || exEntity.getExtendEntityName().trim().equals("")
				|| exEntity.getExtendServiceName() == null || exEntity.getExtendServiceName().trim().equals(""))
			return null;
		
		return getEntity(servletRootDir, exEntity.getExtendEntityName(), exEntity.getExtendServiceName());
	}
	
	/**
	 * 获取主实体
	 * @param servletRootDir
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Entity getMasterEntity(String servletRootDir, Class clazz)throws JAXBException, IOException{
		Entity entity = getEntity(servletRootDir, clazz);
		List<Field> fields = entity.getField();
		for (Field field : fields) {
			if(!field.isIsParent()) continue;
			String masterEntityName = field.getLookupEntity().getLkEntityName();
			String masterServiceName = field.getLookupEntity().getLkServiceName();
			return getEntity(servletRootDir, masterEntityName, masterServiceName);
		}
		return null;
	}
	
	/**
	 * @param servletRootDir
	 * @param entity
	 * @return
	 * @throws ClassNotFoundException
	 * @throws JAXBException
	 * @throws IOException
	 * @deprecated
	 */
	public static Class getEntityClass(String servletRootDir, Entity entity) throws ClassNotFoundException, JAXBException, IOException{
		getAllService(servletRootDir);
		String packageName = null;
		for(Map.Entry<String, Service> entry : allService.entrySet()){
			Service service = entry.getValue();
			
			for (Entity _entity : service.getEntity()) {
				if(_entity.getEntityName().equals(entity.getEntityName()) && _entity.getTableName().equals(entity.getTableName())){
					packageName = service.getPackageName();
						break;		//跳出内循环
				}
			}
			
			if(packageName != null)  //跳出外循环
				break;
				
		}
		if(packageName == null)
			return null;
		
		String className = packageName + ".model." + entity.getEntityName();
		return Class.forName(className.trim());
	}
	
	/**
	 * @param servletRootDir
	 * @return
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 * @deprecated
	 */
	private static Environment getEnvironment(String  servletRootDir) throws FileNotFoundException, JAXBException{
		if(environment == null)
			environment = EnvironmentFactory.loadServletEnvironment(servletRootDir);
		return environment;
	}
	
	
	
}
