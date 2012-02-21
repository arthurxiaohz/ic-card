<#assign pageInfoFieldName = field.fieldName?uncap_first>
	protected  ${serviceTool.getFieldType(field)}  f_${pageInfoFieldName};
 	protected  String  f_${pageInfoFieldName}_op;
<#if fieldType == 4 || fieldType == 5>
	protected  ${serviceTool.getFieldType(field)}  f_${pageInfoFieldName}01;
	protected  String  f_${pageInfoFieldName}01_op;
</#if>