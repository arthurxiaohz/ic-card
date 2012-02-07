		<tbody>
			<c:forEach var="item" items="<#noparse>${</#noparse>${entity.entityName?uncap_first}s<#noparse>}</#noparse>" varStatus="s">
			<tr>
				<c:if test="<#noparse>${</#noparse>empty lookup<#noparse>}</#noparse>">
				<td><input name="orderIndexs" value="<#noparse>${</#noparse>item.id<#noparse>}</#noparse>" type="checkbox"></td>
				</c:if>			
				<#list serviceTool.getDisplayFields(entity) as field>
				<#if field.fieldType == 7>
				    <td><hi:select emu="${field.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${field.fieldName?uncap_first}" isLabel="true"/></td>
				<#elseif field.fieldType == 4>
					<td><fmt:formatDate value="<#noparse>${item.</#noparse>${field.fieldName?uncap_first}<#noparse>}</#noparse>" pattern="yyyy-MM-dd"/></td>
				<#elseif field.fieldType == 5>
				    <td><fmt:formatDate value="<#noparse>${item.</#noparse>${field.fieldName?uncap_first}<#noparse>}</#noparse>" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<#elseif field.fieldType == 8>
				    <td>
						<c:if test="<#noparse>${not empty </#noparse>item.${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}<#noparse>}</#noparse>">
				   		<a href="<hi:url>attachmentView.action?attachment.id=<#noparse>${item.</#noparse>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.id<#noparse>}</#noparse></hi:url>" target="_blank"><#noparse>${item.</#noparse>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.fileNameImage<#noparse>}</#noparse></a>
				     	</c:if>
				   </td>		    
				<#elseif field.fieldType == 6><#assign lkField = serviceTool.getField(allServices, field)><#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>
				    <#if lkField.fieldType == 6><#assign lkEntity = serviceTool.getEntityByName(allServices,lkpkField.lookupEntity.lkEntityName)><#assign lklkpkField = serviceTool.getLookupFKFiled(lkEntity, lkField)>
				    <td><authz:authorize ifAnyGranted="${lkField.lookupEntity.lkEntityName?upper_case}_VIEW"><a href="<hi:url>${lkField.lookupEntity.lkEntityName?uncap_first}View.action?${lkField.lookupEntity.lkEntityName?uncap_first}.id=<#noparse>${item.</#noparse>${serviceTool.getLookupFKFiled(entity,lkField).fieldName?uncap_first}.${lklkpkField.fieldName}.id<#noparse>}</#noparse>&workflow=-1</hi:url>" target="dialog"></authz:authorize>
				    <#noparse>${item.</#noparse>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.${lklkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse>
				    <authz:authorize ifAnyGranted="${lkField.lookupEntity.lkEntityName?upper_case}_VIEW"></a></authz:authorize>
				    <#else>
				    <td><authz:authorize ifAnyGranted="${field.lookupEntity.lkEntityName?upper_case}_VIEW"><a href="<hi:url>${field.lookupEntity.lkEntityName?uncap_first}View.action?${field.lookupEntity.lkEntityName?uncap_first}.id=<#noparse>${item.</#noparse>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.id<#noparse>}</#noparse>&workflow=-1</hi:url>" target="dialog"></authz:authorize>
				    	<#if lkField.fieldType == 7>
				    <hi:select emu="${lkField.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}" isLabel="true"/>
				    	<#else>
					<#noparse>${item.</#noparse>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse>
						</#if>
					<authz:authorize ifAnyGranted="${field.lookupEntity.lkEntityName?upper_case}_VIEW"></a></authz:authorize>
					</#if>
					</td>
				<#else>
				    <td><#noparse>${item.</#noparse>${field.fieldName?uncap_first}<#noparse>}</#noparse></td>
				</#if>
</#list>				
				<td>
				<c:choose>
					<c:when test="<#noparse>${</#noparse>empty lookup<#noparse>}</#noparse>">
				    <authz:authorize ifAnyGranted="${entity.entityName?upper_case}_DEL">
				      <a class="btnDel" href="<hi:url>${entity.entityName?uncap_first}Remove.action?ajax=1&${entity.entityName?uncap_first}.${serviceTool.getPKField(entity).fieldName?uncap_first}=<#noparse>${</#noparse>item.id<#noparse>}</#noparse></hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="${entity.entityLabel}"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="${entity.entityName?upper_case}_VIEW">
				      <a class="btnView" href="<hi:url>${entity.entityName?uncap_first}View.action?${entity.entityName?uncap_first}.${serviceTool.getPKField(entity).fieldName?uncap_first}=<#noparse>${</#noparse>item.id<#noparse>}</#noparse></hi:url>" target="navTab" rel="${entity.entityName?uncap_first}" title="<hi:text key="查看" parameterLanguageKeys="${entity.entityLabel}"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="${entity.entityName?upper_case}_SAVE">
				      <a class="btnEdit" href="<hi:url>${entity.entityName?uncap_first}Edit.action?${entity.entityName?uncap_first}.${serviceTool.getPKField(entity).fieldName?uncap_first}=<#noparse>${</#noparse>item.id<#noparse>}</#noparse></hi:url>" target="navTab" rel="${entity.entityName?uncap_first}" title="<hi:text key="编辑" parameterLanguageKeys="${entity.entityLabel}"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:<#noparse>$</#noparse>.bringBack({id:'<#noparse>${</#noparse>item.${serviceTool.getPKField(entity).fieldName?uncap_first}<#noparse>}</#noparse>', <#list serviceTool.getDisplayFields(entity) as field>${field.fieldName?uncap_first}:'<#if field.fieldType == 8 || field.fieldType == 6><#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)><#assign lkField = serviceTool.getField(allServices, field)><#if lkField.fieldType == 7><hi:select emu="${lkField.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}" isLabel="true"/><#else><#noparse>${</#noparse>item.${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#noparse>}</#noparse></#if><#else><#if field.fieldType == 7><hi:select emu="${field.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}s[<#noparse>${</#noparse>s.index<#noparse>}</#noparse>].${field.fieldName?uncap_first}" isLabel="true"/><#else><#noparse>${</#noparse>item.${field.fieldName?uncap_first}<#noparse>}</#noparse></#if></#if>'<#if field_has_next>,</#if></#list>})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
