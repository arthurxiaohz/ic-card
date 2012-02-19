<#assign pkLookupMap = serviceTool.getLookupSearchMap(entity)>
<#assign pageInfoFieldName = "">
<#assign lookupFieldName = "">
<#list serviceTool.getSearchFields(entity) as field2>
	  <#list field2 as field>
	  <#assign label = field.fieldLabel>
<#if field.fieldType == 6><#assign lookupField = pkLookupMap["${field.fieldName}"]></#if>
<#if field.fieldType != 6><#assign pageInfoFieldName = 'f_'+field.fieldName?uncap_first><#else><#assign pageInfoFieldName = lookupField.fieldName?uncap_first+'.f_'+field.lookupEntity.mainLkFieldName?uncap_first></#if>
			<li<#if field.fieldType == 4 ||  field.fieldType == 5> class="dateRange"</#if>>
<#if label!=''>				<label><hi:text key="${label}" entity="${entity.entityName}"/>:</label></#if>
<#if field.fieldName != "">
			<#if field.fieldType == 7>
				<hi:search name="pageInfo.${pageInfoFieldName}" emu="${field.enumerationEntity?uncap_first}"/>
			<#elseif field.fieldType == 8>
				<input type="text" name="pageInfo.${field.fieldName}_attachment.f_fileName" value="<#noparse>${</#noparse>pageInfo.${field.fieldName}_attachment.f_fileName<#noparse>}</#noparse>"/>
			<#elseif field.fieldType == 4 ||  field.fieldType == 5>
				<input type="text" name="pageInfo.${pageInfoFieldName}" class="date" readonly="readonly" value="<fmt:formatDate value='<#noparse>${</#noparse>pageInfo.${pageInfoFieldName}<#noparse>}</#noparse>' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.${pageInfoFieldName}_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.${pageInfoFieldName}01" class="date" readonly="readonly" value="<fmt:formatDate value='<#noparse>${</#noparse>pageInfo.${pageInfoFieldName}01<#noparse>}</#noparse>' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.${pageInfoFieldName}01_op" value="&lt;=">
			<#else>
				<input type="text" name="pageInfo.${pageInfoFieldName}" value="<#noparse>${</#noparse>pageInfo.${pageInfoFieldName}<#noparse>}</#noparse>"/>
			</#if>
</#if>
			</li>	  
	  </#list>
	  </#list>