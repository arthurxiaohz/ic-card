    ${field.fieldName} int <#if entity.entityType != 3>IDENTITY (1, 1) </#if>NOT NULL <#if count != totalCount>,</#if><#if entity.entityType != 3>
    version int NOT NULL ,</#if>
