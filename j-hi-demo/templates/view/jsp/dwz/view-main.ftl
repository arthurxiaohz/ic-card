				<#list serviceTool.getEditField(entity) as field>
		<dl<#if field.fieldType==9> class="nowrap"</#if>>
				  <#if field.fieldType == 7>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt><dd><hi:select emu="${field.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" isLabel="true"/></dd>
				  <#elseif field.fieldType == 4>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt><dd><fmt:formatDate value="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${field.fieldName?uncap_first}<#noparse>}</#noparse>" pattern="yyyy-MM-dd"/></dd>				  	 
				  <#elseif field.fieldType == 5>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt><dd><fmt:formatDate value="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${field.fieldName?uncap_first}<#noparse>}</#noparse>" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
				  <#elseif field.fieldType == 8>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt>
			<dd>
				<c:if test="<#noparse>${</#noparse>not empty ${entity.entityName?uncap_first}.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}<#noparse>}</#noparse>">
				<a href="<hi:url>attachmentView.action?attachment.id=<#noparse>${</#noparse>${entity.entityName?uncap_first}.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.id<#noparse>}</#noparse></hi:url>" target="_blank">
					<#noparse>${</#noparse>${entity.entityName?uncap_first}.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.fileNameImage<#noparse>}</#noparse>
				</a>
				</c:if>
			</dd>				  
				  <#elseif field.fieldType == 6>
				  <#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>
				  <#assign lkField = serviceTool.getField(allServices, field)>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt><dd><#if lkField.fieldType == 7><hi:select emu="${lkField.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}" isLabel="true"/><#else><#noparse>${</#noparse>${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse></#if></dd>
				  <#else>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt><dd><#noparse>${</#noparse>${entity.entityName?uncap_first}.${field.fieldName?uncap_first}<#noparse>}</#noparse></dd>
				</#if>
		</dl></#list>

		<div class="divider"></div>
