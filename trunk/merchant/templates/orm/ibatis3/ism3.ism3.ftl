<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN"  "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">
<mapper namespace="${entity.entityName?cap_first}"> 


	<resultMap id="${entity.entityName?cap_first}" type="${service.packageName}.model.${entity.entityName?cap_first}"<#if entity.extendEntity?? && entity.extendEntity.extendEntityName != ''> extends="${entity.extendEntity.extendEntityName}.${entity.extendEntity.extendEntityName}"</#if>>
	<#list  serviceTool.getSortField(entity) as property><#assign fieldType = property.fieldType><#if fieldType == 6 ||fieldType == 8 ><#if property.lookupEntity.isLkForeignKey><#include "ism3-lookupProperty.ftl"/></#if><#else><#include "ism3-property.ftl"/></#if></#list><#list entity.childEntity as child><#include "ism3-childProperty.ftl"/></#list>
	</resultMap>
    
    <select id="select_inner_${entity.entityName?cap_first}" resultMap="${entity.entityName?cap_first}" parameterType="int">  
       SELECT * FROM ${entity.tableName}  WHERE id = <#noparse>#{value}</#noparse>
    </select>
<#list entity.childEntity as child>

    <select id="select_inner_${child.childEntityName?cap_first}s" resultMap="${child.childEntityName?cap_first}.${child.childEntityName?cap_first}" parameterType="int">   
       SELECT * FROM ${serviceTool.getEntityByName(allServices,child.childEntityName).tableName} WHERE ${entity.entityName?uncap_first} = <#noparse>#{value}</#noparse>   
    </select>  
</#list>
  
	<select id="get${entity.entityName?cap_first}" resultMap="${entity.entityName?cap_first}">
		select * from ${entity.tableName} WHERE id = <#noparse>#{id}</#noparse>
	</select>
	<select id="list${entity.entityName?cap_first}" resultMap="${entity.entityName?cap_first}">#</select>
  
	<select id="count${entity.entityName?cap_first}" resultType="int">#</select> 
	
	<insert id="ins${entity.entityName?cap_first}" parameterType="java.util.HashMap">    
    	insert into ${entity.tableName} (id, <#if !entity.extendEntity?? || entity.extendEntity.extendEntityName == ''>version, </#if><#assign step = 0><#list entity.field as property><#assign fieldType = property.fieldType><#if (((fieldType == 6 || fieldType == 8) && property.lookupEntity.isLkForeignKey) || (fieldType != 6 && fieldType != 8)) && !property.isPrimaryKey><#assign step = step+1><#if  1 < step>, </#if>${property.fieldName}</#if></#list>) 
		values (<#noparse>#{id,jdbcType=NUMERIC}</#noparse><#if !entity.extendEntity?? || entity.extendEntity.extendEntityName == ''>, 1</#if><#list entity.field as property><#assign fieldType = property.fieldType><#if (((fieldType == 6 || fieldType == 8) && property.lookupEntity.isLkForeignKey) || (fieldType != 6 && fieldType != 8)) && !property.isPrimaryKey>, <#noparse>#{</#noparse>${property.fieldName},jdbcType=<#if fieldType == 1>LONGVARCHAR</#if><#if fieldType == 4>DATE,javaType=java.util.Date</#if><#if fieldType == 5>DATE,javaType=java.sql.Timestamp</#if><#if fieldType == 2 || fieldType == 3 || fieldType == 6 || fieldType == 7 || fieldType == 8>NUMERIC</#if><#if fieldType == 9>CLOB</#if>}</#if></#list>)
		<selectKey resultType="int"  keyProperty="id"/>   
	</insert>
	
	<update id="update${entity.entityName?cap_first}" parameterType="java.util.HashMap">
		update ${entity.tableName} set
<#if !(entity.extendEntity?? && entity.extendEntity.extendEntityName != '')>            version = <#noparse>#{version}</#noparse> +1,</#if>
<#assign i = 0><#list entity.field as property><#assign fieldType = property.fieldType><#if (((fieldType == 6 || fieldType == 8) && property.lookupEntity.isLkForeignKey) || (fieldType != 6 && fieldType != 8)) && !property.isPrimaryKey><#assign i = i+1>
			${property.fieldName} = <#noparse>#{</#noparse>${property.fieldName},jdbcType=<#if fieldType ==1>LONGVARCHAR</#if><#if fieldType == 4>DATE,javaType=java.util.Date</#if><#if fieldType == 5>DATE,javaType=java.sql.Timestamp</#if><#if fieldType == 2 || fieldType == 3 || fieldType == 6 || fieldType == 7 || fieldType == 8>NUMERIC</#if><#if fieldType == 9>CLOB</#if>}<#if i != step>,</#if>
</#if></#list>
    where    
      id = <#noparse>#{id}</#noparse>    
	</update>    
   
	<delete id="del${entity.entityName?cap_first}" parameterType="int">    
		delete from ${entity.tableName} where id = <#noparse>#{id}</#noparse>
	</delete>

</mapper>    
 