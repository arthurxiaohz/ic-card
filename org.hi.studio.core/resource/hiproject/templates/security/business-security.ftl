<#list service.entity as entity><#if entity.entityType != 2>
	${service.packageName}.service.${entity.entityName?cap_first}Manager.getSecurity${entity.entityName?cap_first}List=${entity.entityName?upper_case}_LIST,${entity.entityName?upper_case}_LOOKUP
	${service.packageName}.service.${entity.entityName?cap_first}Manager.getSecurity${entity.entityName?cap_first}ById=${entity.entityName?upper_case}_VIEW<#if serviceTool.getParentEntity(entity, allServices)?exists>,${serviceTool.getParentEntity(entity, allServices).entityName?upper_case}_VIEW</#if>
	${service.packageName}.service.${entity.entityName?cap_first}Manager.saveSecurity${entity.entityName?cap_first}=${entity.entityName?upper_case}_SAVE<#if serviceTool.getParentEntity(entity, allServices)?exists>,${serviceTool.getParentEntity(entity, allServices).entityName?upper_case}_SAVE</#if>
	${service.packageName}.service.${entity.entityName?cap_first}Manager.removeSecurity${entity.entityName?cap_first}ById=${entity.entityName?upper_case}_DEL<#if serviceTool.getParentEntity(entity, allServices)?exists>,${serviceTool.getParentEntity(entity, allServices).entityName?upper_case}_DEL</#if>
</#if><#if entity_has_next && entity.entityType != 2>

</#if>
</#list>