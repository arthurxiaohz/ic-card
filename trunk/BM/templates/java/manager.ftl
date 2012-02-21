package ${service.packageName}.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import ${service.packageName}.model.${entity.entityName?cap_first};
<#if serviceTool.hasExtendEntity(entity)>import ${extendService.packageName}.service.${extendEntity.entityName?cap_first}Manager;<#else>import org.hi.framework.service.Manager;</#if>

public interface ${entity.entityName?cap_first}Manager extends <#if serviceTool.hasExtendEntity(entity)>${extendEntity.entityName?cap_first}</#if>Manager{
    
    public void save${entity.entityName?cap_first}(${entity.entityName?cap_first} ${entity.entityName?uncap_first});

    public void remove${entity.entityName?cap_first}ById(Integer id);

    public ${entity.entityName?cap_first} get${entity.entityName?cap_first}ById(Integer id);

    public List<${entity.entityName?cap_first}> get${entity.entityName?cap_first}List(PageInfo pageInfo);
    
    public void saveSecurity${entity.entityName?cap_first}(${entity.entityName?cap_first} ${entity.entityName?uncap_first});

    public void removeSecurity${entity.entityName?cap_first}ById(Integer id);

    public ${entity.entityName?cap_first} getSecurity${entity.entityName?cap_first}ById(Integer id);

    public List<${entity.entityName?cap_first}> getSecurity${entity.entityName?cap_first}List(PageInfo pageInfo);    
}
