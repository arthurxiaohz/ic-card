package ${service.packageName}.action;

import java.sql.Timestamp;
import java.util.Date;

<#if serviceTool.hasExtendEntity(entity)>
import ${allServices["${entity.extendEntity.extendServiceName}"].packageName}.action.${entity.extendEntity.extendEntityName}PageInfo;
<#else>
import org.hi.framework.web.PageInfoView;
</#if>
<#list serviceTool.getLookupField(entity) as lkField>
<#if lkField.lookupEntity.lkEntityName != entity.entityName>
import ${allServices["${lkField.lookupEntity.lkServiceName}"].packageName}.action.${lkField.lookupEntity.lkEntityName}PageInfo;
</#if>
</#list>

public class ${entity.entityName?cap_first}PageInfo extends <#if serviceTool.hasExtendEntity(entity)>${entity.extendEntity.extendEntityName}PageInfo<#else>PageInfoView</#if>{

<#list entity.field as field><#assign fieldType = field.fieldType><#if fieldType != 6 && fieldType != 8><#include "action/pageinfo-field.ftl"></#if>
</#list>
<#list entity.field as lkField><#if (lkField.fieldType == 6 || lkField.fieldType == 8) && lkField.lookupEntity.isLkForeignKey>
<#include "action/pageinfo-field_lk.ftl">
</#if>
</#list>

<#list entity.field as field><#assign fieldType = field.fieldType><#if fieldType != 6 && fieldType != 8><#include "action/pageinfo-method.ftl"></#if>
</#list>
<#list entity.field as lkField><#if (lkField.fieldType == 6 || lkField.fieldType == 8) && lkField.lookupEntity.isLkForeignKey>
<#include "action/pageinfo-method_lk.ftl">
</#if>
</#list>


}
