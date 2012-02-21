package ${service.packageName}.dao;

<#if serviceTool.hasExtendEntity(entity)>import ${extendService.packageName}.dao.${extendEntity.entityName}DAO;<#else>import org.hi.framework.dao.DAO;</#if>

public interface ${entity.entityName?cap_first}DAO extends <#if serviceTool.hasExtendEntity(entity)>${extendEntity.entityName}</#if>DAO{

}
