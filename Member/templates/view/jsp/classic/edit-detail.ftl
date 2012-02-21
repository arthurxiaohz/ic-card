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
					  <input type="button" onclick="${entity.entityName?uncap_first}_addDetail('${childEntity.entityName?uncap_first}')" value="新建"></input>
					</tr>
					<thead>
				    <tr> <!-- detail header -->
				    <#list serviceTool.getDisplayFields(childEntity) as childField>
				      <td class="DetailTableLable"><hi:text key="${childField.fieldLabel}" entity="${childEntity.entityName}"/></td>
				    </#list>
				      <td class="DetailTableLable"><hi:text key="操作"/></td>
				    </tr>        <!-- detail header end -->
				    </thead>
				    <tbody id="${childEntity.entityName?uncap_first}_Tbody" > 
				    <ws:iterator value="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s" id="${childEntity.entityName?uncap_first}" status="${childEntity.entityName?uncap_first}Index">
				    <tr> <!-- detail body -->								
				    <#list serviceTool.getDisplayFields(childEntity) as childField><#if childField_index == 0>
					    <input type="hidden"
									id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${serviceTool.getPKField(childEntity).fieldName?uncap_first}"
									name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${serviceTool.getPKField(childEntity).fieldName?uncap_first}"
									value="<ws:property id="${childEntity.entityName?uncap_first}" value="${serviceTool.getPKField(childEntity).fieldName?uncap_first}"/>"/>
					    <input type="hidden"
									id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].version"
									name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].version"
									value="<ws:property id="${childEntity.entityName?uncap_first}" value="version"/>"/>
</#if>
				      <td class="DetailTableData">
				        <#if childField.fieldType == 7>
					    <hi:select emu="${childField.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}" />
				        <#elseif childField.fieldType == 4>
				  		  <input name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}"
				  		   id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}"
				  		   type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
				  		   value="<ws:date  name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[#${childEntity.entityName?uncap_first}Index.index].${childField.fieldName?uncap_first}" format="yyyy-MM-dd"/>" />
				  		 <#elseif childField.fieldType == 5>
				  		  <input name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}"
				  		   id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}"
				  		   type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
				  		   value="<ws:date  name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[#${childEntity.entityName?uncap_first}Index.index].${childField.fieldName?uncap_first}" format="yyyy-MM-dd HH:mm:ss"/>" />
				        <#else>
				        <#if (childField.fieldType == 6 || childField.fieldType == 8) && childField.isMainLookup>
				        <#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>
				        <#assign lkEntity = serviceTool.getLookupEntity(lkpkField, allServices)>
					    <input type="hidden"
							        id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"
							        name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"
							        value="<ws:property id="${childEntity.entityName?uncap_first}" value="${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"/>"/>
				        </#if>												
					    <input type="text"
						            id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}"<#if serviceTool.getValidator(childField)?exists > validator="${serviceTool.getValidator(childField)}" </#if>
						            name="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}"
						            value="<ws:property id="${childEntity.entityName?uncap_first}" value="<#if childField.fieldType == 6 || childField.fieldType == 8><#assign lkpkField = serviceTool.getLookupFKFiled(childEntity, childField)>${lkpkField.fieldName?uncap_first}.${childField.lookupEntity.mainLkFieldName?uncap_first}<#else>${childField.fieldName?uncap_first}</#if>"/>"
						            size="12"<#if childField.fieldType == 6 && childField.isMainLookup>  onkeyUp="${childEntity.entityName?uncap_first}_lookupSuggest(event, '${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}','${serviceTool.getLookupFKFiled(childEntity,childField).fieldName?uncap_first}','${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}.suggest',<ws:property value="#${childEntity.entityName?uncap_first}Index.count-1"/>)" onclick="${childEntity.entityName?uncap_first}_lookupSuggest(event, '${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}','${serviceTool.getLookupFKFiled(childEntity,childField).fieldName?uncap_first}','${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}.suggest',<ws:property value="#${childEntity.entityName?uncap_first}Index.count-1"/>)"    onblur="showAndHide('${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}.suggest','hide');"<#else></#if> /><#if (childField.fieldType == 6 || childField.fieldType == 8 )&& childField.isMainLookup>
					    <span onclick="${childEntity.entityName?uncap_first}_lookupPOP('${serviceTool.getLookupFKFiled(childEntity,childField).fieldName?uncap_first}',<ws:property value="#${childEntity.entityName?uncap_first}Index.count-1"/>)" style="cursor:hand"><img src="images/lookup.gif" width="18" height="17" border="0" /></span></#if>
					    </#if>
					    <#if  childField.fieldType == 8 && childField.isMainLookup>
					     <ws:if id="breedFile" test="${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}>0">
						            <a href="<hi:url>attachmentView.action?attachment.id=<ws:property id="${childEntity.entityName?uncap_first}" value="${lkpkField.fieldName?uncap_first}.${serviceTool.getPKField(lkEntity).fieldName?uncap_first}"/></hi:url>" target="blank"><hi:text key="查看"/></a>
						 </ws:if>					    
					    </#if><#if childField.fieldType == 6 && childField.isMainLookup>
						<br/>
						<div class="SuggestList" id="${entity.entityName?uncap_first}.${childEntity.entityName?uncap_first}s[<#noparse>$</#noparse>{${childEntity.entityName?uncap_first}Index.count-1}].${childField.fieldName?uncap_first}.suggest">
							<div class="SuggestMain">
								<ul>
								</ul>
						    </div>
						</div></#if>					    
				      </td>
				    </#list>
				      <td class="DetailTableData">
				        <image src="images/delete.gif" onclick="${entity.entityName?uncap_first}_delDetail('<ws:property id="${childEntity.entityName?uncap_first}" value="${serviceTool.getPKField(childEntity).fieldName?uncap_first}"/>','${childEntity.entityName?uncap_first}')" style="cursor:hand">
				      </td>
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
