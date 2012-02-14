<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE sqlMap PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN" "com/ibatis/sqlmap/engine/builder/xml/sql-map-2.dtd">
<sqlMap>

	<typeAlias alias="${entity.entityName?cap_first}" type="${service.packageName?lower_case}.model.${entity.entityName?cap_first}"/>

	<resultMap id="${entity.entityName?cap_first}" class="${entity.entityName?cap_first}"<#if entity.extendEntity?? && entity.extendEntity.extendEntityName != ''> extends="${entity.extendEntity.extendEntityName}"</#if>>
	<#list entity.field as property><#assign fieldType = property.fieldType><#if fieldType == 6 || fieldType == 8><#if property.lookupEntity.isLkForeignKey><#include "ism-lookupProperty.ftl"/></#if><#else><#include "ism-property.ftl"/></#if></#list><#list entity.childEntity as child><#include "ism-childProperty.ftl"/></#list>
	</resultMap>
    
    <select id="select_inner_${entity.entityName?cap_first}" resultMap="${entity.entityName?cap_first}" parameterClass="int">  
       SELECT * FROM ${entity.tableName}  WHERE id =#value#
    </select>
<#list entity.childEntity as child>

    <select id="select_inner_${child.childEntityName?cap_first}s" resultMap="${child.childEntityName?cap_first}" parameterClass="int">   
       SELECT * FROM ${serviceTool.getEntityByName(allServices,child.childEntityName).tableName} WHERE ${entity.entityName?uncap_first} =#value#    
    </select>  
</#list>
  
	<select id="get${entity.entityName?cap_first}" resultMap="${entity.entityName?cap_first}">
		select * from ${entity.tableName} WHERE id = #id# 
	</select>
	
	<insert id="ins${entity.entityName?cap_first}" parameterClass="java.util.HashMap">    
    	insert into ${entity.tableName} (id, <#if !entity.extendEntity?? || entity.extendEntity.extendEntityName == ''>version, </#if><#assign step = 0><#list entity.field as property><#assign fieldType = property.fieldType><#if (((fieldType == 6 || fieldType == 8) && property.lookupEntity.isLkForeignKey) || (fieldType != 6 && fieldType != 8)) && !property.isPrimaryKey><#assign step = step+1><#if  1 < step>, </#if>${property.fieldName}</#if></#list>) 
		values (#id#<#if !entity.extendEntity?? || entity.extendEntity.extendEntityName == ''>, 1</#if><#list entity.field as property><#assign fieldType = property.fieldType><#if (((fieldType == 6 || fieldType == 8) && property.lookupEntity.isLkForeignKey) || (fieldType != 6 && fieldType != 8)) && !property.isPrimaryKey>, #${property.fieldName}#</#if></#list>)
		<selectKey resultClass="int"  keyProperty="id" />   
	</insert>    
   
 
	<update id="update${entity.entityName?cap_first}" parameterClass="java.util.HashMap">    
		update ${entity.tableName} set
<#if !(entity.extendEntity?? && entity.extendEntity.extendEntityName != '')>            version = #version# +1,</#if>
<#assign i = 0><#list entity.field as property><#assign fieldType = property.fieldType><#if (((fieldType == 6 || fieldType == 8) && property.lookupEntity.isLkForeignKey) || (fieldType != 6 && fieldType != 8)) && !property.isPrimaryKey><#assign i = i+1>
			${property.fieldName} = #${property.fieldName}#<#if i != step>,</#if>
</#if></#list>
    where    
      id = #id#    
	</update>    
   
	<delete id="del${entity.entityName?cap_first}" parameterClass="int">    
		delete from ${entity.tableName} where id = #id#   
	</delete>
    
	<selectExt id="list${entity.entityName?cap_first}" resultMap="${entity.entityName?cap_first}"/> 
  
	<selectExt id="count${entity.entityName?cap_first}" resultClass="int"/> 

</sqlMap>    