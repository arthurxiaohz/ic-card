      <input type="hidden" name="pageInfo.sorterName" id="pageInfo.sorterName" value="<ws:property value="pageInfo.sorterName" default=""/>" />
      <input type="hidden" name="pageInfo.sorterDirection" id="pageInfo.sorterDirection" value="<ws:property value="pageInfo.sorterDirection" default="ASC"/>" />
      <!-- action -->						
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="120" class="SearchTableTop"><hi:text key="查询条件"/></td>
          <td >&nbsp;</td>
          <td width="64"><authz:authorize ifAnyGranted="${entity.entityName?upper_case}_SAVE"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建" parameterLanguageKeys="${entity.entityLabel}"/>" class="button1" onclick="${entity.entityName?uncap_first}_addNew('<hi:url>${entity.entityName?uncap_first}Edit.action?${entity.entityName?uncap_first}.id=-1</hi:url>')"/></ws:if><ws:else><input type="button" value="<hi:text key="重置"/>" class="button" onclick="lookup${entity.entityName?cap_first}('-1',<#list serviceTool.getDisplayFields(entity) as field>''<#if field_has_next>,</#if></#list>)"/></ws:else></authz:authorize></td>
          <td width="15">&nbsp;</td>
          <td width="64"><input type="button" value="<hi:text key="查询"/>" class="button1" onclick="javascript:formSearchSubmit()"/></td>
        </tr>
      </table>
