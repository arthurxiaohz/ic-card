<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<#include "/classic/edit-head.ftl">
</head>
<body>
  <form name="saveForm" action="${entity.entityName?uncap_first}Save.action" method="post" onsubmit="return checkValue('<#list serviceTool.getFullField(entity) as fullField><#if fullField.isMainLookup || fullField.fieldType != 6>${entity.entityName?uncap_first}.${fullField.fieldName?uncap_first}<#if fullField_has_next>,</#if></#if></#list>')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面"  parameterLanguageKeys="${entity.entityLabel}"/></td>
    </tr>
    <tr>
      <td valign="top" class="EditTableBackground">
		    
        <#include "/classic/edit-main.ftl">
		<!-- orderDetail edit -->
		<#include "/classic/edit-detail.ftl">
		
		<script language="JavaScript">
          var detailNames = Array(<#list serviceTool.getChild(entity,allServices)  as childEntity>'<hi:text key="${childEntity.entityLabel}" />'<#if childEntity_has_next>,</#if></#list>);
		  var detailTabButtons = Array(<#list serviceTool.getChild(entity,allServices)  as childEntity>'true'<#if childEntity_has_next>,</#if></#list>);
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="button" onclick="if(saveForm.onsubmit()) saveForm.submit();" id="save" value="<hi:text key="保存"/>" class="Button2"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"/>" class="Button2" onclick="javascript:window.location='${entity.entityName?uncap_first}List.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>