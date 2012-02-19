package ${service.packageName}.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

<#list importClass as className>
import ${className};
</#list>

public abstract class ${entity.entityName?cap_first}Abstract extends <#if serviceTool.hasExtendEntity(entity)>${entity.extendEntity.extendEntityName}<#else>BaseObject</#if> implements Serializable{

<#list entity.field as field><#assign fieldType = field.fieldType><#if (fieldType == 6 || fieldType == 8) && !field.lookupEntity.isLkForeignKey><#else><#include "pojo-field.ftl"></#if>
</#list>
<#if serviceTool.hasChild(entity)><#include "pojo-childentity-field.ftl"/></#if>

<#list entity.field as field><#assign fieldType = field.fieldType><#if (fieldType == 6 || fieldType == 8) && !field.lookupEntity.isLkForeignKey><#else><#include "pojo-method.ftl"></#if>
</#list>

<#if serviceTool.hasChild(entity)><#include "pojo-childentity-method.ftl"/></#if>

<#include "pojo-equalshashcode.ftl"/>


<#include "pojo-tostring.ftl"/>


}