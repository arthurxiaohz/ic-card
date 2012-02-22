<!DOCTYPE xwork PUBLIC "-//OpenSymphony Group//XWork 1.1.1//EN" "http://www.opensymphony.com/xwork/xwork-1.1.1.dtd">

<xwork>
	<package name="${service.serviceName}" extends="${appName}" >
<#list service.entity as entity><#if entity.entityType != 2>
<#include "webwork/jsp/config-action.ftl">
</#if>
</#list>

</package>
</xwork>