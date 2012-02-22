<#list service.entity as entity><#if entity.entityType != 2>
	/${entity.entityName?uncap_first}View.action=${entity.entityName?upper_case}_VIEW<#if serviceTool.getParentEntity(entity, allServices)?exists>,${serviceTool.getParentEntity(entity, allServices).entityName?upper_case}_VIEW</#if>
	/${entity.entityName?uncap_first}List.action=${entity.entityName?upper_case}_LIST
	/${entity.entityName?uncap_first}Save.action=${entity.entityName?upper_case}_SAVE<#if serviceTool.getParentEntity(entity, allServices)?exists>,${serviceTool.getParentEntity(entity, allServices).entityName?upper_case}_SAVE</#if>
	/${entity.entityName?uncap_first}Remove.action=${entity.entityName?upper_case}_DEL<#if serviceTool.getParentEntity(entity, allServices)?exists>,${serviceTool.getParentEntity(entity, allServices).entityName?upper_case}_DEL</#if>
	/${entity.entityName?uncap_first}Lookup.action=${entity.entityName?upper_case}_LOOKUP
</#if><#if entity_has_next && entity.entityType != 2>

</#if>
</#list>