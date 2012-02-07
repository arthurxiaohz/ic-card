              <ws:iterator value="${entity.entityName?uncap_first}s" status="${entity.entityName?uncap_first}">
			    <tr class="<ws:if test="#${entity.entityName?uncap_first}.odd==false">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getPKField(entity).fieldName?uncap_first}"/>" type="checkbox">
         		  </td>
				<#list serviceTool.getDisplayFields(entity) as field>
				  <td class="ListTableBodyData"> 
				<#if field.fieldType == 7>
				    <hi:select emu="${field.enumerationEntity?uncap_first}" name="${entity.entityName?uncap_first}s[<#noparse>$</#noparse>{${entity.entityName?uncap_first}.count-1 }].${field.fieldName?uncap_first}" isLabel="true"/>
				<#elseif field.fieldType == 4>
					<ws:date name="${field.fieldName?uncap_first}" format="yyyy-MM-dd"/>
				<#elseif field.fieldType == 5>
				    <ws:date name="${field.fieldName?uncap_first}" format="yyyy-MM-dd HH:mm:ss"/>
				<#elseif field.fieldType == 8>
				    <ws:if id="${entity.entityName?uncap_first}" test="${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}!=null ">
				   <a href="<hi:url>attachmentView.action?attachment.id=<ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.id"/></hi:url>" target="_blank">
				     &nbsp; <ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.fileNameImage" escape="false" />
				   </a>
				   </ws:if>			    
				<#elseif field.fieldType == 6>
				    <authz:authorize ifAnyGranted="${field.lookupEntity.lkEntityName?upper_case}_VIEW"><a href="<hi:url>${field.lookupEntity.lkEntityName?uncap_first}View.action?${field.lookupEntity.lkEntityName?uncap_first}.id=<ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.id"/>&workflow=-1</hi:url>" target="_blank"></authz:authorize>
					<ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}" /><authz:authorize ifAnyGranted="${field.lookupEntity.lkEntityName?upper_case}_VIEW"></a></authz:authorize>
				<#else>
				    <ws:property id="${entity.entityName?uncap_first}" value="${field.fieldName?uncap_first}" />
				</#if>
				    &nbsp;
				  </td>
				</#list>
				  <td class="ListTableBodyData">
				    <ws:if test="lookup==null">
				    <authz:authorize ifAnyGranted="${entity.entityName?upper_case}_DEL">
				      <a href="<hi:url>${entity.entityName?uncap_first}Remove.action?${entity.entityName?uncap_first}.${serviceTool.getPKField(entity).fieldName?uncap_first}=<ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getPKField(entity).fieldName?uncap_first}"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/del.gif" alt="<hi:text key="删除" parameterLanguageKeys="${entity.entityLabel}"/>" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="${entity.entityName?upper_case}_VIEW">				      
				      &nbsp;
				      <a href="<hi:url>${entity.entityName?uncap_first}View.action?${entity.entityName?uncap_first}.${serviceTool.getPKField(entity).fieldName?uncap_first}=<ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getPKField(entity).fieldName?uncap_first}"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/view.gif" alt="<hi:text key="查询" parameterLanguageKeys="${entity.entityLabel}"/>" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="${entity.entityName?upper_case}_SAVE">				    
				      &nbsp;
				      <a href="<hi:url>${entity.entityName?uncap_first}Edit.action?${entity.entityName?uncap_first}.${serviceTool.getPKField(entity).fieldName?uncap_first}=<ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getPKField(entity).fieldName?uncap_first}"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/modify.gif" alt="<hi:text key="编辑" parameterLanguageKeys="${entity.entityLabel}"/>" border="0"/></a>
				    </authz:authorize>				      
				    </ws:if>
				    <ws:else>
				      <span style="cursor: pointer" onclick="lookup${entity.entityName?cap_first}('<ws:property id="${entity.entityName?uncap_first}" value="${serviceTool.getPKField(entity).fieldName?uncap_first}"/>',<#list serviceTool.getDisplayFields(entity) as field>'<ws:property id="${entity.entityName?uncap_first}" value="<#if field.fieldType == 8 || field.fieldType == 6><#assign lkpkField = serviceTool.getLookupFKFiled(entity, field)>${lkpkField.fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if>"/>'<#if field_has_next>,</#if></#list>)"><img src="images/icon_Select.gif" border="0"></span>								
				    </ws:else>
				  </td>
			    </tr>
			  </ws:iterator>  		
																							