        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTable"> <!-- fields to edit  -->
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
				  <td width="15%" class="EditTable<#if field.isFull><#if field.fieldType == 6 && field.lookupEntity.isLkForeignKey><#else>Key</#if></#if>Label"  id="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}Label"><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>:</td>
				  <td width="35%" class="EditTableData">
				  <#if field.fieldType == 7>
				    <hi:select cssClass="EditTableDataEnum" emu="${field.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" id="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}"/>
				  <#elseif field.fieldType == 4>
				     <input name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}"
				  		   id="${entity.entityName?uncap_first}_${field.fieldName?uncap_first}" class="EditTableDataText" 
				  		   type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
				  		   value="<ws:date  name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" format="yyyy-MM-dd"/>" />
				   <#elseif field.fieldType == 5>
				    <table border="0" cellpadding="0" cellspacing="0">
				     <input name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}"
				  		   id="${entity.entityName?uncap_first}_${field.fieldName?uncap_first}" class="EditTableDataText"
				  		   type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
				  		   value="<ws:date  name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" format="yyyy-MM-dd HH:mm:ss"/>" />
					</table>
				  <#else>
				  <#if (field.fieldType == 6 || field.fieldType == 8 )&& field.isMainLookup>
				  <#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>
				  <#assign lkEntity = serviceTool.getLookupEntity(lkpkField, allServices)>
					<input type="hidden" id="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}" name="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}" value="<ws:property value="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"/>">
				  </#if>							
					<input type="text" class="EditTableDataText" id="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" <#if field.isReadOnly>readonly="true" </#if><#if serviceTool.getValidator(field)?exists >validator="${serviceTool.getValidator(field)}" </#if>name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" value="<ws:property value="${entity.entityName?uncap_first}.<#if (field.fieldType == 6 || field.fieldType == 8)><#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if>"/>"<#if field.fieldType == 6 && field.isMainLookup> onkeyUp="${entity.entityName?uncap_first}_lookupSuggest(event, '${entity.entityName?uncap_first}.${field.fieldName?uncap_first}','${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}','${entity.entityName?uncap_first}.${field.fieldName?uncap_first}.suggest')" onclick="${entity.entityName?uncap_first}_lookupSuggest(event, '${entity.entityName?uncap_first}.${field.fieldName?uncap_first}','${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}','${entity.entityName?uncap_first}.${field.fieldName?uncap_first}.suggest')"    onblur="showAndHide('${entity.entityName?uncap_first}.${field.fieldName?uncap_first}.suggest','hide');"</#if>></#if>
				  <#if ( field.fieldType == 6 ||  field.fieldType == 8 )&& field.getLookupEntity().getLkEntityName() != "" && field.isMainLookup>
					<span onclick="${entity.entityName?uncap_first}_lookupPOP('${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
<#if field.fieldType == 8 && field.getLookupEntity().getLkEntityName() != "" && field.isMainLookup>
<ws:if test="${entity.entityName?uncap_first}.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}!= null">
				          <a href="<hi:url>attachmentView.action?attachment.id=<ws:property id="${entity.entityName?uncap_first}" value="${entity.entityName?uncap_first}.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.id"/></hi:url>" target="_blank"><hi:text key="查看"/></a>
</ws:if>
</#if><#if field.fieldType == 6 && field.isMainLookup>
					<br/>
					<div class="SuggestList" id="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
</#if>					
				  </#if>
				  </td>
				<#if trFlag % tdNum =0>
			    </tr>
				<tr>
				</#if>
				</#list>
				</tr>
				<#list  serviceTool.getHiddenField(entity) as hiddenField>
				<input type="hidden" id="${entity.entityName?uncap_first}.${hiddenField.fieldName?uncap_first}<#if hiddenField.fieldType == 6>.${hiddenField.lookupEntity.mainLkFieldName}</#if>" name="${entity.entityName?uncap_first}.${hiddenField.fieldName?uncap_first}<#if hiddenField.fieldType == 6>.${hiddenField.lookupEntity.mainLkFieldName}</#if>" value="<ws:property value="${entity.entityName?uncap_first}.${hiddenField.fieldName?uncap_first}<#if hiddenField.fieldType == 6>.${hiddenField.lookupEntity.mainLkFieldName}</#if>"/>">
				</#list>
				<input type="hidden" id="${entity.entityName?uncap_first}.version" name="${entity.entityName?uncap_first}.version" value="<ws:property value="${entity.entityName?uncap_first}.version"/>">
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
