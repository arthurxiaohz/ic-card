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
			<div class="tabsContent" style="height:120px;">
			  <#list serviceTool.getChild(entity,allServices)  as childEntity>
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
				    <#list serviceTool.getDisplayFields(childEntity) as childField>
								<th><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></th>
				    </#list>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="<#noparse>${</#noparse>${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s<#noparse>}</#noparse>">
							<tr>						
				    <#list serviceTool.getDisplayFields(childEntity) as childField>
						<#if childField.fieldType == 4>
								<td><fmt:formatDate value="<#noparse>${</#noparse>item.${childField.fieldName?uncap_first}<#noparse>}</#noparse>" pattern="yyyy-MM-dd"/></td>
						<#elseif childField.fieldType == 5>
								<td><fmt:formatDate value="<#noparse>${</#noparse>item.${childField.fieldName?uncap_first}<#noparse>}</#noparse>" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				        <#elseif childField.fieldType == 7>
				        		<td><hi:select emu="${childField.enumerationEntity?uncap_first}" name="item.${childField.fieldName?uncap_first}" isLabel="true"/></td>
				        <#else>
						<#if  childField.fieldType == 8><#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>
								<td>
									<a href="<hi:url>attachmentView.action?attachment.id=<#noparse>${</#noparse>item.${lkpkField.fieldName?uncap_first}.id<#noparse>}</#noparse></hi:url>" target="blank"  >
										<#noparse>${</#noparse>item.${lkpkField.fieldName?uncap_first}.fileNameImage<#noparse>}</#noparse>
									</a>
								</td>
						<#else>
								<td><#noparse>${</#noparse>item.<#if childField.fieldType == 6><#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>${lkpkField.fieldName?uncap_first}.<#if childField.fieldType == 6>${childField.lookupEntity.mainLkFieldName?uncap_first}</#if><#else>${childField.fieldName?uncap_first}</#if><#noparse>}</#noparse></td>
						</#if>
				      </#if>
				      </#list>
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
