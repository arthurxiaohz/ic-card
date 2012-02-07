<#list entity.childEntity as child>
Element_${child.childEntityName?uncap_first}s=${service.packageName}.model.${child.childEntityName?cap_first}
</#list>