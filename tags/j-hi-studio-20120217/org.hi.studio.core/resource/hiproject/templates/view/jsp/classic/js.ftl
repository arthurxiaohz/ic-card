
<#include "/classic/js-lookup-json.ftl">
<#include "/classic/js-detail-json.ftl">

var ${entity.entityName?uncap_first}_detailObject ; 
var ${entity.entityName?uncap_first}_lookupObject ;
var ${entity.entityName?uncap_first}_detailCounts = new Array();

function ${entity.entityName?uncap_first}_parse(){
	${entity.entityName?uncap_first}_lookupObject = new framework_lookup(${entity.entityName?uncap_first}_lookup);
<#if serviceTool.hasChild(entity)>	
	${entity.entityName?uncap_first}_detailObject = new framework_detail(${entity.entityName?uncap_first}_detail);
</#if>
<#list serviceTool.getChild(entity,allServices) as child>
	${entity.entityName?uncap_first}_detailCounts.push({"name":"${child.entityName?uncap_first}","size":CUBBYUtil.getValue(eval("${entity.entityName?uncap_first}_detail.${child.entityName?uncap_first}.sizeInput"))});
</#list>
	${entity.entityName?uncap_first}_initDetailTabs();
}
<#include "/classic/js-lookup.ftl">
<#include "/classic/js-detail.ftl">
<#include "/classic/js-tab.ftl">

Event.observe(window,"load",${entity.entityName?uncap_first}_parse);