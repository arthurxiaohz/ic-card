package ${service.packageName}.dao.springjdbc;

<#if serviceTool.hasExtendEntity(entity)>import ${extendService.packageName}.dao.springjdbc.${extendEntity.entityName?cap_first}DAOSpringJDBC;<#else>import org.hi.framework.dao.springjdbc.BaseDAOSpringJDBC;</#if>
import ${service.packageName}.dao.${entity.entityName?cap_first}DAO;
public class ${entity.entityName?cap_first}DAOSpringJDBC extends <#if serviceTool.hasExtendEntity(entity)>${extendEntity.entityName?cap_first}DAOSpringJDBC<#else>BaseDAOSpringJDBC</#if> implements ${entity.entityName?cap_first}DAO{

}
