              <tr>
          	    <td width="15" class="ListTableBodyLabel">
				  <input name="chkall" value="checkbox" onclick="javascript:selectAll()" type="checkbox">            
				</td>
<#list serviceTool.getDisplayFields(entity) as field><#assign label = field.fieldLabel>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('<#if field.fieldType == 6 || field.fieldType == 8>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if>')" id="title_<#if field.fieldType == 6 || field.fieldType == 8>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if>"><hi:text key="${label}" entity="${entity.entityName}"/>
				  <ws:if test="pageInfo.sorterName.equals('<#if field.fieldType == 6 || field.fieldType == 8>${serviceTool.getLookupFKFiled(entity,field).fieldName?uncap_first}.${field.lookupEntity.mainLkFieldName?uncap_first}<#else>${field.fieldName?uncap_first}</#if>')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
				</#list>
				<td class="ListTableBodyLabel">
				  <ws:if test="lookup==null">
				    <hi:text key="操作"/> 
				  </ws:if>
				  <ws:else>
				   <hi:text key="查找带回"/> 
				  </ws:else>
				</td>
              </tr>
																			