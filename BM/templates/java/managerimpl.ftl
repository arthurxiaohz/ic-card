package ${service.packageName}.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import ${service.packageName}.model.${entity.entityName};
import <#if serviceTool.hasExtendEntity(entity)>${extendService.packageName}.service.impl.${extendEntity.entityName?cap_first}ManagerImpl<#else>org.hi.framework.service.impl.ManagerImpl</#if>;
import ${service.packageName}.service.${entity.entityName}Manager;

public class ${entity.entityName?cap_first}ManagerImpl extends <#if serviceTool.hasExtendEntity(entity)>${extendEntity.entityName?cap_first}</#if>ManagerImpl implements ${entity.entityName?cap_first}Manager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void save${entity.entityName?cap_first}(${entity.entityName?cap_first} ${entity.entityName?uncap_first}){
    	saveObject(${entity.entityName?uncap_first});
    
    }

    public void remove${entity.entityName?cap_first}ById(Integer id){
    	removeObjectById(id);
    	
    }

    public ${entity.entityName} get${entity.entityName?cap_first}ById(Integer id){
   		return (${entity.entityName}) getObjectById(id);
    }

    public List<${entity.entityName}> get${entity.entityName?cap_first}List(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurity${entity.entityName?cap_first}(${entity.entityName?cap_first} ${entity.entityName?uncap_first}){
    	saveObject(${entity.entityName?uncap_first});
    
    }

    public void removeSecurity${entity.entityName?cap_first}ById(Integer id){
    	removeObjectById(id);
    	
    }

    public ${entity.entityName} getSecurity${entity.entityName?cap_first}ById(Integer id){
   		return (${entity.entityName}) getObjectById(id);
    }

    public List<${entity.entityName}> getSecurity${entity.entityName?cap_first}List(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
