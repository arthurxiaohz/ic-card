		<thead>
			<tr>
				<c:if test="<#noparse>${empty lookup}</#noparse>">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
<#list serviceTool.getDisplayFields(entity) as field><#assign label = field.fieldLabel>				
				<th orderField="<#if field.fieldType == 6 || field.fieldType == 8>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if>" <#noparse>class="${pageInfo.sorterName eq '</#noparse><#if field.fieldType == 6 || field.fieldType == 8>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if><#noparse>' ? pageInfo.sorterDirection : ''}"</#noparse>><hi:text key="${label}" entity="${entity.entityName}"/></th>
</#list>				
				<th width="90">
					<c:choose>
						<c:when test="<#noparse>${empty lookup}</#noparse>"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				