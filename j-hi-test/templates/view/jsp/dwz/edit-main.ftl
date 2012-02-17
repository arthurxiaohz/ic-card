<#list serviceTool.getEditField(entity) as field>
		<dl<#if field.fieldType == 9>  class="nowrap"</#if>>
	<#if field.fieldType == 1 || field.fieldType = 2 || field.fieldType == 3>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt><dd><input type="text" name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" class="textInput<#if field.isFull> required</#if><#if serviceTool.getValidator(field)?exists > ${serviceTool.getValidator(field)}</#if>" value="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${field.fieldName?uncap_first}<#noparse>}</#noparse>"<#if field.fieldType = 1> maxlength="${field.length}"</#if><#if field.fieldType = 2> alt="<hi:text key="请输入整数"/>"</#if><#if field.fieldType = 3> alt="<hi:text key="请输浮点数"/>"</#if><#if field.isReadOnly> readonly="readonly" </#if>/></dd>
	<#elseif field.fieldType == 4 || field.fieldType == 5>				
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt>
			<dd>
				<input type="text" name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" class="textInput date<#if field.isFull> required</#if>" readonly="readonly"<#if field.fieldType == 5> pattern="yyyy-MM-dd HH:mm:ss"</#if>
					value="<fmt:formatDate value='<#noparse>${</#noparse>${entity.entityName?uncap_first}.${field.fieldName?uncap_first}<#noparse>}</#noparse>' pattern='yyyy-MM-dd<#if field.fieldType == 5> HH:mm:ss</#if>'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
	<#elseif field.fieldType == 6>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt>
			<dd>
		<#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>
		<#assign lkEntity = serviceTool.getLookupEntity(lkpkField, allServices)>
		<#assign lkField = serviceTool.getField(allServices, field)>
		<#if field.isMainLookup>
				<input type="hidden" name="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}" value="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}<#noparse>}</#noparse>"/>
		</#if>
				<input type="text" class="textInput<#if field.isFull> required</#if>" name="${entity.entityName?uncap_first}.hi_${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}" value="<#if lkField.fieldType == 7><hi:select emu="${lkField.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}" isLabel="true"/><#else><#noparse>${</#noparse>${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse></#if>"<#if !field.isMainLookup> readonly="readonly"/></#if>
		<#if field.isMainLookup>
		<#assign lkFields = serviceTool.getLookFields(lkpkField, entity)>
		<#assign fields = "">
		<#list lkFields as lkField>
			<#if lkField_index gt 0>
				<#assign fields = fields + lkField.lookupEntity.mainLkFieldName>
				<#if lkField_has_next><#assign fields = fields + ","></#if>
			</#if>
		</#list>	
					autocomplete="off" lookupGroup="${entity.entityName?uncap_first}" lookupName="${lkpkField.fieldName?uncap_first}" suggestClass="${allServices[lkpkField.lookupEntity.lkServiceName].packageName}.model.${lkEntity.entityName?cap_first}" searchFields="${fields}"/>
				<a class="btnLook" href="<hi:url>${lkEntity.entityName?uncap_first}Lookup.action?lookup=1</hi:url>" lookupGroup="${entity.entityName?uncap_first}" lookupName="${lkpkField.fieldName?uncap_first}"><hi:text key="查找带回"/></a>		
		</#if>
			</dd>
	<#elseif field.fieldType == 7>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt><dd><hi:select emu="${field.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}"/></dd>			
	<#elseif field.fieldType == 8>
		<#if field.isMainLookup>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt>
			<dd>
		<#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>
		<#assign lkEntity = serviceTool.getLookupEntity(lkpkField, allServices)>
				<input type="hidden" name="${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}" value="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}<#noparse>}</#noparse>"/>
				<input type="text" class="textInput<#if field.isFull> required</#if>" name="${entity.entityName?uncap_first}.hi_${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}" value="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse>" readonly="readonly"/>
				<a class="btnAttach" href="<hi:url>attachmentLookup.action?lookup=1&from=attachment&saveType=1</hi:url>" lookupGroup="${entity.entityName?uncap_first}" lookupName="${lkpkField.fieldName?uncap_first}" width="560" height="300" title="<hi:text key="附件"/>"><hi:text key="附件"/></a>
				<c:if test="<#noparse>${</#noparse>not empty ${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}<#noparse>}</#noparse>">
				<a class="btnView" href="attachmentView.action?attachment.id=<#noparse>${</#noparse>${entity.entityName?uncap_first}.${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}<#noparse>}</#noparse>" target="_blank">
					<hi:text key="查看"/>
				</a>
				</c:if>			
			</dd>
		</#if>			
	<#elseif field.fieldType == 9>
			<dt><hi:text key="${field.fieldLabel}" entity="${entity.entityName}"/>：</dt>
			<dd>
				<textarea class="editor" name="${entity.entityName?uncap_first}.${field.fieldName?uncap_first}" rows="8" cols="95"
					upLinkUrl="xhEditorUpload.action" upLinkExt="zip,rar,txt" 
					upImgUrl="xhEditorUpload.action" upImgExt="jpg,jpeg,gif,png" 
					upFlashUrl="xhEditorUpload.action" upFlashExt="swf"
					upMediaUrl="xhEditorUpload.action" upMediaExt:"avi" html5Upload="false">
				<#noparse>${</#noparse>${entity.entityName?uncap_first}.${field.fieldName?uncap_first}<#noparse>}</#noparse></textarea>
			</dd>
	</#if>			
		</dl>
</#list>		
				<#list  serviceTool.getHiddenField(entity) as hiddenField>
				<input type="hidden" name="${entity.entityName?uncap_first}.${hiddenField.fieldName?uncap_first}<#if hiddenField.fieldType == 6>.${hiddenField.lookupEntity.mainLkFieldName}</#if>" value="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${hiddenField.fieldName?uncap_first}<#if hiddenField.fieldType == 6>.${hiddenField.lookupEntity.mainLkFieldName}</#if><#noparse>}</#noparse>"/>
				</#list>
				<input type="hidden" name="${entity.entityName?uncap_first}.version" value="<#noparse>${</#noparse>${entity.entityName?uncap_first}.version<#noparse>}</#noparse>"/>

		<div class="divider"></div>
