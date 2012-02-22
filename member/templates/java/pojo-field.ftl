 	<#if field.isPrimaryKey && entity.entityType != 3>
 	/**
	 * 主键${field.fieldName}
	 */	
	protected  ${serviceTool.getFieldType(field)} ${field.fieldName};${'\n'}<#if  entity.entityType != 4>
	/**
	 * 版本控制version
	 */	
 	protected  Integer version;${'\n'}</#if>
 	<#else>
 /**
	 * ${field.fieldLabel}
	 */	
 	protected  ${serviceTool.getFieldType(field)} ${field.fieldName}<#if field.defaultValue?exists &&  field.defaultValue?trim != ""> = ${field.defaultValue}</#if>;${'\n'}
 	</#if>
 	