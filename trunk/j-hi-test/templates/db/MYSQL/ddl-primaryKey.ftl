    ${field.fieldName} int <#if entity.entityType != 3>auto_increment </#if>NOT NULL <#if count != totalCount>,</#if><#if entity.entityType != 3>
    version int NOT NULL ,</#if>
