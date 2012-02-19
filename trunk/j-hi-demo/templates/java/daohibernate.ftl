package ${service.packageName}.dao.hibernate;

<#if serviceTool.hasExtendEntity(entity)>import ${extendService.packageName}.dao.hibernate.${extendEntity.entityName?cap_first}DAOHibernate;<#else>import org.hi.framework.dao.hibernate.BaseDAOHibernate;</#if>
import ${service.packageName}.dao.${entity.entityName?cap_first}DAO;
public class ${entity.entityName?cap_first}DAOHibernate extends <#if serviceTool.hasExtendEntity(entity)>${extendEntity.entityName?cap_first}DAOHibernate<#else>BaseDAOHibernate</#if> implements ${entity.entityName?cap_first}DAO{

}
