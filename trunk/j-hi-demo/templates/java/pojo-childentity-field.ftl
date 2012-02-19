<#list entity.childEntity as child>
	private  List<${child.childEntityName?cap_first}> ${child.childEntityName?uncap_first}s;
</#list>
    