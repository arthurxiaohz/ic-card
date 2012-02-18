package org.hi.metadata.hsc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.hi.SpringContextHolder;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.Field;
import org.hi.metadata.hsc.context.service.Service;

public class HSC {
	
	public static Map<String, Service> getAllService() throws JAXBException, IOException{
		return HSCHelper.getAllService(SpringContextHolder.getServletContext().getRealPath(""));
	}
	
	public static Map<String, Entity> getAllEnumeration() throws JAXBException, IOException{
		return HSCHelper.getAllEnumeration(SpringContextHolder.getServletContext().getRealPath(""));
	}
	
	public static Map<String, Service> getServices() throws FileNotFoundException, JAXBException{
		return HSCHelper.getServices(SpringContextHolder.getServletContext().getRealPath(""));
	}
	
	public static List<Entity> getAllEntity() throws JAXBException, IOException{
		return HSCHelper.getAllEntity(SpringContextHolder.getServletContext().getRealPath(""));
	}
	
	public static List<Entity> getEntities() throws JAXBException, IOException{
		return HSCHelper.getEntities(SpringContextHolder.getServletContext().getRealPath(""));
	}
	
	public static Entity getEntity(Class clazz) throws JAXBException, IOException{
		return HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), clazz);
	}
	
	public static Field getField( Class clazz, String propertyName) throws JAXBException, IOException{
		return HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), clazz, propertyName);
	}
	
	public static Field getField(Entity entity, String propertyName) throws JAXBException, IOException{
		return HSCHelper.getField(SpringContextHolder.getServletContext().getRealPath(""), entity, propertyName);
	}
	
	public static Entity getEntity(String entityName, String serviceName) throws JAXBException, IOException{
		return HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), entityName, serviceName);
	}
	
	public static Entity getEntity(String entityName) throws JAXBException, IOException{
		return HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), entityName);
	}
	
	public static List<Entity> getItemEntities(Class clazz) throws JAXBException, IOException{
		return HSCHelper.getItemEntities(SpringContextHolder.getServletContext().getRealPath(""), clazz);
	}
	
	public static Entity getParentEntity(Class clazz) throws JAXBException, IOException{
		return HSCHelper.getParentEntity(SpringContextHolder.getServletContext().getRealPath(""), clazz);
	}
	
	public static Entity getMasterEntity(Class clazz)throws JAXBException, IOException{
		return HSCHelper.getMasterEntity(SpringContextHolder.getServletContext().getRealPath(""), clazz);
	}
	
	public static Class getEntityClass(Entity entity) throws ClassNotFoundException, JAXBException, IOException{
		return HSCHelper.getEntityClass(SpringContextHolder.getServletContext().getRealPath(""), entity);
	}
	
	
}
