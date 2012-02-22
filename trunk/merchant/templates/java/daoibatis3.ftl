package ${service.packageName}.dao.ibatis3;

<#if serviceTool.hasExtendEntity(entity)>import ${extendService.packageName}.dao.ibatis3.${extendEntity.entityName?cap_first}DAOIbatis3;<#else>import org.hi.framework.dao.ibatis3.BaseDAOIbatis;</#if>
import ${service.packageName}.dao.${entity.entityName?cap_first}DAO;
public class ${entity.entityName?cap_first}DAOIbatis3 extends <#if serviceTool.hasExtendEntity(entity)>${extendEntity.entityName?cap_first}DAOIbatis3<#else>BaseDAOIbatis</#if> implements ${entity.entityName?cap_first}DAO{

}
