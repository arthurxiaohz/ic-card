<#if serviceTool.hasChild(entity)>

<#assign displayStep = 0>
var ${entity.entityName?uncap_first}_detail = {
<#list serviceTool.getChild(entity,allServices) as child><#assign displayCount = serviceTool.displayCount(child)>
"${child.entityName?uncap_first}":{
	"name":"${entity.entityName?uncap_first}.${child.entityName?uncap_first}s",
	"containerID":"${child.entityName?uncap_first}_Tbody",
	"sizeInput":"${child.entityName?uncap_first}_Length",	
	"POPmethod":"${child.entityName?uncap_first}_lookupPOP",
	"removeMethod":"${entity.entityName?uncap_first}_delDetail",
	"removeAction":"${child.entityName?uncap_first}Remove.action?${child.entityName?uncap_first}.id=",	
	"fields":[
<#list child.field as field>
<#if field.isListDisplay><#assign displayStep = displayStep + 1>
			  {"name":"<#if field.fieldType == 6 || field.fieldType == 8 >${serviceTool.getLookupFKFiled(child,field).fieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if>","type":"${serviceTool.getJSType(child, field)}","size":12}<#if displayStep != displayCount>,</#if>
</#if>
<#if displayStep == displayCount>
			 ]
	}<#if child_has_next>,</#if>
<#break>
</#if>
</#list>
<#assign displayStep = 0>	
</#list>
}
</#if>