        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTable"> <!-- fields to edit  -->
          <tr>
            <td height="5" >  </td>      
       	  </tr>
		  <tr>
		    <td >
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
<#assign trFlag = 0 >
<#assign tdNum = 2 >
			    <tr>
				<#list serviceTool.getEditField(entity) as field>
				<#assign trFlag = trFlag + 1>
				  <td width="15%" class="ViewTableLabel"  id="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}Label"><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				  <#if field.fieldType == 7>
				    <hi:select cssClass="ViewTableDataText" emu="${field.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" isLabel="true"/>
				  <#elseif field.fieldType == 4>
					  <ws:date name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" format="yyyy-MM-dd"/>
				  <#elseif field.fieldType == 5>
				      <ws:date name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" format="yyyy-MM-dd HH:mm:ss"/>
				  <#elseif field.fieldType == 8>
				   <ws:if test="${entity.entityName?uncap_first}.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}!= null ">
				     <a href="<hi:url>attachmentView.action?attachment.id=<ws:property id="${entity.entityName?uncap_first}" value="${entity.entityName?uncap_first}.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.id"/></hi:url>" target="_blank">
				     <ws:property id="${entity.entityName?uncap_first}" value="${entity.entityName?uncap_first}.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.fileNameImage" escape="false" />
				     </a>
				     </ws:if>
				  <#else>
				  <#if field.fieldType == 6 && field.isMainLookup>
				  <#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>
				  <#assign lkEntity = serviceTool.getLookupEntity(lkpkField, allServices)>
					<input type="hidden" id="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}" name="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}" value="<ws:property value="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"/>">
				  </#if>
					<ws:property value="${entity.entityName?uncap_first}.<#if field.fieldType == 6><#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if>"/>
				  </#if>
				  </td>
				<#if trFlag % tdNum =0>
			    </tr>
				<tr>
				</#if>
				</#list>
				</tr>
				<#list  serviceTool.getHiddenField(entity) as hiddenField>
				<input type="hidden" id="${entity.entityName?uncap_first}.${hiddenField.fieldName?uncap_first}" name="${entity.entityName?uncap_first}.${hiddenField.fieldName?uncap_first}" value="<ws:property value="${entity.entityName?uncap_first}.${hiddenField.fieldName?uncap_first}"/>">
				</#list>
			  </table>
			</td>
		  </tr>
		  <tfoot>
			<tr>
			  <td colspan="${tdNum * 2}">
			    &nbsp;
			  </td>
			</tr>
		  </tfoot>
		</table>  <!-- fields to edit end -->
