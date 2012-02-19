		<#if serviceTool.hasChild(entity)>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
					<#list serviceTool.getChild(entity,allServices)  as childEntity>
						<li><a href="javascript:void(0)"><span><hi:text key="${childEntity.entityLabel}"/></span></a></li>
					</#list>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:150px;">
			  <#list serviceTool.getChild(entity,allServices)  as childEntity>
				<div>
					<table class="list nowrap" width="100%" itemDetail="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s">
						<thead>
							<tr>
				    <#list serviceTool.getDisplayFields(childEntity) as childField>
				    		<#if childField.fieldType == 1 || childField.fieldType == 2 || childField.fieldType == 3 || childField.fieldType == 4 || childField.fieldType == 5 >
								<th type="${serviceTool.getJSType(childEntity, childField)}" class="<#if childField.isFull> required</#if><#if childField.fieldType == 4 || childField.fieldType == 5> date</#if><#if serviceTool.getValidator(childField)?exists > ${serviceTool.getValidator(childField)}</#if>" name="${childField.fieldName?uncap_first}" size="12"<#if childField.fieldType = 1> maxlength="${childField.length}"</#if>><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></th>
							<#elseif childField.fieldType == 6>
							<#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>
								<#if childField.isMainLookup>
							<#assign lkEntity = serviceTool.getLookupEntity(lkpkField, allServices)>								
							<#assign lkFields = serviceTool.getLookFields(lkpkField, childEntity)>
							<#assign fields = "">
							<#list lkFields as lkField>
								<#if lkField_index gt 0>
									<#assign fields = fields + lkField.lookupEntity.mainLkFieldName>
									<#if lkField_has_next><#assign fields = fields + ","></#if>
								</#if>
							</#list>								
								<th type="lookup" class="<#if childField.isFull>required</#if>" name="${childField.lookupEntity.mainLkFieldName}" lookupName="${lkpkField.fieldName?uncap_first}" lookupUrl="<hi:url>${childField.lookupEntity.lkEntityName?uncap_first}Lookup.action?lookup=1</hi:url>" suggestClass="${allServices[lkpkField.lookupEntity.lkServiceName].packageName}.model.${lkEntity.entityName?cap_first}" searchFields="${fields}" size="12"><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></th>
								<#else>
								<th type="lookup" class="<#if childField.isFull>required</#if>" name="${childField.lookupEntity.mainLkFieldName}" lookupName="${lkpkField.fieldName?uncap_first}" size="12"><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></th>
								</#if>
							<#elseif childField.fieldType == 7>
								<th type="enum" name="${childField.fieldName?uncap_first}" enumName="${childField.enumerationEntity?uncap_first}" size="12"><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></th>
							<#elseif childField.fieldType == 8>
								<th type="attach" class="<#if childField.isFull>required</#if>" name="${childField.lookupEntity.mainLkFieldName?uncap_first}" lookupName="${serviceTool.getLookupFKFiled(childEntity, childField).fieldName?uncap_first}" lookupUrl="<hi:url>attachmentLookup.action?lookup=1&from=attachment&saveType=1</hi:url>" size="12"><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></th>
							<#elseif childField.fieldType == 9>
								<th type="text" name="${childField.fieldName?uncap_first}" size="12"><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></th>
							</#if>
				    </#list>
								<th type="del" width="60"><hi:text key="操作"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s<#noparse>}</#noparse>"  varStatus="s">
							<tr>
							<input type="hidden" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${serviceTool.getPKField(childEntity).fieldName?uncap_first}" value="<#noparse>${item</#noparse>.${serviceTool.getPKField(childEntity).fieldName?uncap_first}<#noparse>}</#noparse>"/>
							<input type="hidden" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].version" value="<#noparse>${item</#noparse>.version<#noparse>}</#noparse>"/>
				    <#list serviceTool.getDisplayFields(childEntity) as childField>							
								<td>
						<#if childField.fieldType == 1 || childField.fieldType == 2 || childField.fieldType == 3>
									<input type="text" class="<#if childField.isFull> required</#if><#if serviceTool.getValidator(childField)?exists > ${serviceTool.getValidator(childField)}</#if>" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${childField.fieldName?uncap_first}" value="<#noparse>${</#noparse>item.${childField.fieldName?uncap_first}<#noparse>}</#noparse>" size="12"<#if childField.fieldType = 1> maxlength="${childField.length}"</#if><#if childField.fieldType = 2> alt="<hi:text key="请输入整数"/>"</#if><#if childField.fieldType = 3> alt="<hi:text key="请输浮点数"/>"</#if><#if childField.isReadOnly> childField="readonly" </#if>/>
						<#elseif childField.fieldType == 4 || childField.fieldType == 5>
									<input type="text" class="date<#if childField.isFull> required</#if>" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${childField.fieldName?uncap_first}" class="date"<#if childField.fieldType == 5> pattern='yyyy-MM-dd HH:mm:ss'</#if>
										value="<fmt:formatDate value='<#noparse>${item.</#noparse>${childField.fieldName?uncap_first}<#noparse>}</#noparse>'<#if childField.fieldType == 5> pattern='yyyy-MM-dd HH:mm:ss'</#if>/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
						<#elseif childField.fieldType == 6>
								<#if childField.isMainLookup>
							<#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>
							<#assign lkEntity = serviceTool.getLookupEntity(lkpkField, allServices)>								
							<#assign lkFields = serviceTool.getLookFields(lkpkField, childEntity)>
							<#assign fields = "">
							<#list lkFields as lkField>
								<#if lkField_index gt 0>
									<#assign fields = fields + lkField.lookupEntity.mainLkFieldName>
									<#if lkField_has_next><#assign fields = fields + ","></#if>
								</#if>
							</#list>
									<input type="hidden" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(childEntity).fieldName?uncap_first}" value="<#noparse>${item.</#noparse>${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(childEntity).fieldName?uncap_first}<#noparse>}</#noparse>"/>
									<input type="text" class="<#if childField.isFull>required</#if>" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].hi_${lkpkField.fieldName?uncap_first}.${childField.lookupEntity.mainLkFieldName?uncap_first}" value="<#noparse>${item.</#noparse>${lkpkField.fieldName?uncap_first}.${childField.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse>" size="12" 
										autocomplete="off" lookupGroup="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s" lookupName="${lkpkField.fieldName?uncap_first}" index="<#noparse>${s.index}</#noparse>" suggestClass="${allServices[lkpkField.lookupEntity.lkServiceName].packageName}.model.${lkEntity.entityName?cap_first}" searchFields="${fields}"/>
									<a class="btnLook" href="<hi:url>${lkEntity.entityName?uncap_first}Lookup.action?lookup=1</hi:url>" lookupGroup="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s" lookupName="${lkpkField.fieldName?uncap_first}" index="<#noparse>${s.index}</#noparse>" title="<hi:text key="查找带回"/>"><hi:text key="查找带回"/></a>
								<#else>
									<input type="text" class="<#if childField.isFull>required</#if>" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].hi_${lkpkField.fieldName?uncap_first}.${childField.lookupEntity.mainLkFieldName?uncap_first}" value="<#noparse>${item.</#noparse>${lkpkField.fieldName?uncap_first}.${childField.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse>" lookupGroup="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s" lookupName="${lkpkField.fieldName?uncap_first}" size="12" readonly="readonly"/>
								</#if>						
						<#elseif childField.fieldType == 7>
									<hi:select emu="${childField.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${childField.fieldName?uncap_first}" />
						<#elseif childField.fieldType == 8>
							<#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>						
									<input type="hidden" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(childEntity).fieldName?uncap_first}" value="<#noparse>${item.</#noparse>${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(childEntity).fieldName?uncap_first}<#noparse>}</#noparse>"/>
									<input type="text" class="<#if childField.isFull>required</#if>" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].hi_${lkpkField.fieldName?uncap_first}.${childField.lookupEntity.mainLkFieldName?uncap_first}" value="<#noparse>${item.</#noparse>${lkpkField.fieldName?uncap_first}.${childField.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse>" size="12" readonly="readonly"/>
									<a class="btnAttach" href="<hi:url>attachmentLookup.action?lookup=1&from=attachment&saveType=1</hi:url>" lookupGroup="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s" lookupName="${serviceTool.getLookupFKFiled(childEntity, childField).fieldName?uncap_first}" index="<#noparse>${s.index}</#noparse>" width="560" height="300" title="<hi:text key="附件"/>"><hi:text key="附件"/></a>
									<c:if test="<#noparse>${</#noparse>not empty item.${lkpkField.fieldName?uncap_first}<#noparse>}</#noparse>">
									<a class="btnView" href="attachmentView.action?attachment.id=<#noparse>${item.</#noparse>${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(childEntity).fieldName?uncap_first}<#noparse>}</#noparse>" target="_blank">
										<hi:text key="查看"/>
									</a>
									</c:if>	
						<#elseif childField.fieldType == 9>
									<input type="text" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${childField.fieldName?uncap_first}" value="<#noparse>${</#noparse>item.${childField.fieldName?uncap_first}<#noparse>}</#noparse>" size="20"/>						
						</#if>
								</td>
					</#list>
								<td><a href="<hi:url>${childEntity.entityName?uncap_first}Remove.action?ajax=1&${childEntity.entityName?uncap_first}.${serviceTool.getPKField(childEntity).fieldName?uncap_first}=<#noparse>${item.</#noparse>${serviceTool.getPKField(childEntity).fieldName?uncap_first}<#noparse>}</#noparse></hi:url>" class="btnDel" title="<hi:text key="确定要删除吗?"/>">删除</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>								
			</#list>
				
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>				
		</#if>