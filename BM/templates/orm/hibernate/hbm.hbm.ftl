<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
    <<#if entity.entityType == 3>joined-subclass<#else>class</#if> name="${service.packageName?lower_case}.model.${entity.entityName?cap_first}" table="${entity.tableName}" <#if serviceTool.hasExtendEntity(entity)>extends="${extendService.packageName}.model.${extendEntity.entityName?cap_first}"</#if>>
        <#list entity.field as property><#assign fieldType = property.fieldType><#if fieldType == 6 || fieldType == 8><#if property.lookupEntity.isLkForeignKey><#include "hbm-lookupProperty.ftl"/></#if><#else><#include "hbm-property.ftl"/></#if></#list>
<#list entity.childEntity as child><#include "hbm-manyProperty.ftl"></#list>
    
    </<#if entity.entityType == 3>joined-subclass<#else>class</#if>>
</hibernate-mapping>