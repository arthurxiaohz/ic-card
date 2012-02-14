<#if serviceTool.hasLookupEntity(entity)>

function ${entity.entityName?uncap_first}_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = ${entity.entityName?uncap_first}_lookupObject;
	${entity.entityName?uncap_first}_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function ${entity.entityName?uncap_first}_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = ${entity.entityName?uncap_first}_lookupObject;
	${entity.entityName?uncap_first}_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookup${entity.entityName?cap_first}(id,<#list serviceTool.getDisplayFields(entity) as field>${field.fieldName?uncap_first}<#if field_has_next>,</#if></#list>){
	var ${entity.entityName?uncap_first} = {"id":id,<#list serviceTool.getDisplayFields(entity) as field>"${field.fieldName?uncap_first}":${field.fieldName?uncap_first}<#if field_has_next>,</#if></#list>};
	window.opener.bringBack(${entity.entityName?uncap_first});
	window.close();
}
</#if>