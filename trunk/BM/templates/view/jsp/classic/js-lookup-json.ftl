<#if serviceTool.hasLookupEntity(entity)>
var ${entity.entityName?uncap_first}_lookup = {
<#list serviceTool.getLookupJsonCol(entity) as lkFieldGourp>
<#assign fields = "">
<#list lkFieldGourp as lkField>
	<#if lkField_index gt 0>
		<#assign fields = fields + lkField.lookupEntity.mainLkFieldName>
		<#if lkField_has_next><#assign fields = fields + ","></#if>
	</#if>
</#list>
<#list lkFieldGourp as lkField>
<#if lkField_index == 0>
<#assign lkEntity = serviceTool.getLookupEntity(lkField,allServices)>
"${lkField.fieldName?uncap_first}":{
<#if lkField.fieldType == 6>
		"url":"${lkField.lookupEntity.lkEntityName?uncap_first}Lookup.action?lookup=1",</#if><#if lkField.fieldType == 8>
		"url":"attachmentLookup.action?lookup=1&from=${lkField.lookupEntity.lkEntityName?uncap_first}&saveType=1",</#if>
		"domain":"${entity.entityName?uncap_first}",
		"lookupClassName":"${allServices["${lkField.lookupEntity.lkServiceName}"].packageName}.model.${lkField.lookupEntity.lkEntityName?cap_first}",
		"lookupSearchFields":"${fields}",
		"lookupSuggestFields":"${fields}",		
<#if serviceTool.getParentEntity(entity, allServices)?exists>
		"arrayName":"${serviceTool.getParentEntity(entity, allServices).entityName?uncap_first}.${entity.entityName?uncap_first}s",
</#if>
		"mapping":[{"b":"id", "t":"${lkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"},<#else>				   {"b":"${lkField.lookupEntity.mainLkFieldName}", "t":"${lkField.fieldName?uncap_first}"}<#if lkField_has_next>,</#if></#if>
<#if lkField_has_next == false>
				  ]
		}<#if lkFieldGourp_has_next>,</#if>
</#if>
</#list>
</#list>
}
</#if>