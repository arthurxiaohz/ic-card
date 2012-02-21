<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
    "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
    "http://struts.apache.org/dtds/struts-2.0.dtd">
<struts>
	<package name="${service.serviceName}" extends="${appName}" >
<#list service.entity as entity><#if entity.entityType != 2>
		<!-- ============= ${entity.entityLabel}对应的${entity.entityName?cap_first}Action============ --> 
		<action name="${entity.entityName?uncap_first}" class="${service.packageName}.action.struts.${entity.entityName?cap_first}Action">
			<interceptor-ref name="modelParamsStack" />
		</action> 

<#include "struts/jsp/config-action.ftl">
</#if>
</#list>

</package>
</struts>