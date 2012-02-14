<#list service.entity as entity><#if entity.entityType != 2 && serviceTool.hasInEntity(entity.entityName, entitySet)><#if drop>
if exists (select * from sysobjects where id = object_id(N'${entity.tableName}') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table ${entity.tableName}
--</#if>
<#compress>
<#assign totalCount = 0>
<#assign count = 0>
<#assign hasPrimaryKey = false>
<#assign primaryKeyName =''>
<#list entity.field as property>
	<#if (property.fieldType == 6 || property.fieldType == 8) && property.lookupEntity.isLkForeignKey>
		<#assign totalCount = totalCount + 1>
	</#if>
	<#if property.fieldType != 6  && property.fieldType != 8 >
		<#assign totalCount = totalCount + 1>
	</#if>
	<#if !hasPrimaryKey && property.isPrimaryKey>
		<#assign hasPrimaryKey = true>
		<#assign primaryKeyName = property.fieldName>
	</#if>
</#list>
</#compress>
CREATE TABLE ${entity.tableName} (
<#list entity.field as field><#assign fieldType = field.fieldType><#if (fieldType == 6 || fieldType == 8)&& field.lookupEntity.isLkForeignKey><#assign count = count + 1>    ${field.fieldName} int <#if field.isFull>NOT</#if> NULL<#if count != totalCount || hasPrimaryKey>,${'\n'}</#if><#else><#if fieldType != 6 && fieldType != 8><#assign count = count + 1><#include "ddl-field.ftl"></#if></#if></#list>    <#if hasPrimaryKey>primary key (${primaryKeyName})</#if>);

--

</#if></#list>