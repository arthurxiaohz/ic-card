package ${service.packageName}.dao.ibatis;

<#if serviceTool.hasExtendEntity(entity)>import ${extendService.packageName}.dao.ibatis.${extendEntity.entityName?cap_first}DAOIbatis;<#else>import org.hi.framework.dao.ibatis.BaseDAOIbatis;</#if>
import ${service.packageName}.dao.${entity.entityName?cap_first}DAO;
public class ${entity.entityName?cap_first}DAOIbatis extends <#if serviceTool.hasExtendEntity(entity)>${extendEntity.entityName?cap_first}DAOIbatis<#else>BaseDAOIbatis</#if> implements ${entity.entityName?cap_first}DAO{

}
