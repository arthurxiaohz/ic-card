		<#if serviceTool.hasChild(entity)>
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td>
			  <div id="${entity.entityName?uncap_first}_detailTabsDIV">
			  <#list serviceTool.getChild(entity,allServices)  as childEntity>
			  <#assign lookupFieldName = "">
			    <div id="tabViewmain1_${childEntity_index}" class="dhtmlgoodies_aTab">
			  	  <input type="hidden" name="${childEntity.entityName?uncap_first}_Length" id="${childEntity.entityName?uncap_first}_Length" value='<ws:property value="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s.size" default="0"/>' />
				  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="DetailTable">
				    <tr>
				    &nbsp;
					</tr>
					<thead>
				    <tr> <!-- detail header -->
				    <#list serviceTool.getDisplayFields(childEntity) as childField>
				      <td class="DetailTableLable"><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></td>
				    </#list>
				    </tr>        <!-- detail header end -->
				    </thead>
				    <tbody id="${childEntity.entityName?uncap_first}_Tbody" > 
				    <ws:iterator value="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s" id="${childEntity.entityName?uncap_first}" status="${childEntity.entityName?uncap_first}Index">
				    <tr> <!-- detail body -->								
				    <#list serviceTool.getDisplayFields(childEntity) as childField>
				      <td class="DetailTableData">&nbsp;<#if childField_index == 0>
					    <input type="hidden"
									id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${serviceTool.getPKField(childEntity).fieldName?uncap_first}"
									name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${serviceTool.getPKField(childEntity).fieldName?uncap_first}"
									value="<ws:property id="${childEntity.entityName?uncap_first}" value="${serviceTool.getPKField(childEntity).fieldName?uncap_first}"/>"/></#if>
						<#if childField.fieldType == 4>
						<ws:date  name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[#${childEntity.entityName?uncap_first}Index.index].${childField.fieldName?uncap_first}" format="yyyy-MM-dd"/>
						<#elseif childField.fieldType == 5>
						<ws:date  name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[#${childEntity.entityName?uncap_first}Index.index].${childField.fieldName?uncap_first}" format="yyyy-MM-dd HH:mm:ss"/>
				        <#elseif childField.fieldType == 7>
					    <hi:select emu="${childField.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}" isLabel="true" />
				        <#else>
				        <#if (childField.fieldType == 6 || childField.fieldType == 8) && childField.isMainLookup>
				        <#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>
				        <#assign lkEntity = serviceTool.getLookupEntity(lkpkField, allServices)>
					    <input type="hidden"
							        id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"
							        name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"
							        value="<ws:property id="${childEntity.entityName?uncap_first}" value="${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"/>"/>
				        </#if><#if  childField.fieldType == 8>
				      		  <a href="<hi:url>attachmentView.action?attachment.id=<ws:property id="${childEntity.entityName?uncap_first}" value="${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"/></hi:url>" target="blank"  >
				      	</#if>
						            <ws:property id="${childEntity.entityName?uncap_first}" value="<#if childField.fieldType == 6 || childField.fieldType == 8><#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>${lkpkField.fieldName?uncap_first}.<#if childField.fieldType == 6>${childField.lookupEntity.mainLkFieldName?uncap_first}</#if><#if childField.fieldType == 8>fileNameImage</#if><#else>${childField.fieldName?uncap_first}</#if>" escape="false"/>
					    <#if  childField.fieldType == 8>		</a></#if>
					    </#if>
				      </td>
				    </#list>
				    </tr>   <!-- detail body end -->
				    </ws:iterator>
				    </tbody>
				  </table>
			    </div>
			  </#list>
			  </div>
		    </td>
		  </tr>
		</table>
		</#if>
