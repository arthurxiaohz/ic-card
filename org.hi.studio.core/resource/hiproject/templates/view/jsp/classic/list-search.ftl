	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="SearchTable">
<#assign pkLookupMap = serviceTool.getLookupSearchMap(entity)>
<#assign pageInfoFieldName = "">
<#assign lookupFieldName = "">
<#list serviceTool.getSearchFields(entity) as field2>
        <tr>
	  <#list field2 as field>
	  <#assign label = field.fieldLabel>
<#if field.fieldType == 6><#assign lookupField = pkLookupMap["${field.fieldName}"]></#if>
<#if field.fieldType != 6><#assign pageInfoFieldName = 'f_'+field.fieldName?uncap_first><#else><#assign pageInfoFieldName = lookupField.fieldName?uncap_first+'.f_'+field.lookupEntity.mainLkFieldName?uncap_first></#if>
	  	  <td width="15%" class="SearchTableLabel"><#if label!=''><hi:text key="${label}" entity="${entity.entityName}"/>:</#if>&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  <#if field.fieldName != "">
	  	    <hi:search name="pageInfo.${pageInfoFieldName}" <#if field.fieldType == 7>emu="${field.enumerationEntity?uncap_first}"</#if> <#if field.fieldType == 4 ||  field.fieldType == 5>cssClass="SearchTableData_Date" isDate="true" br="false" needSelect="false"<#else>  cssClass="SearchTableDataText" needSelect="<#if field.fieldType != 2 && field.fieldType != 3>false<#else>true</#if>"</#if>/>
	  </#if>
	  <#if field.fieldType == 4 ||  field.fieldType == 5>
	  		<input type="hidden" name="pageInfo.${pageInfoFieldName}_op" value="&gt;=">
	  		&nbsp;-&nbsp;
	  		<hi:search name="pageInfo.${pageInfoFieldName}01" cssClass="SearchTableData_Date" needSelect="false" br="false" isDate="true" />
	  		<input type="hidden" name="pageInfo.${pageInfoFieldName}01_op" value="&lt;=">
	  </#if>
	  	  </td>
	  </#list>
	  	</tr>
	  </#list>
	  </table>
