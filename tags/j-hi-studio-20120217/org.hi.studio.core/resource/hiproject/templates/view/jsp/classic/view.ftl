<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<#include "/classic/view-head.ftl">
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面"  parameterLanguageKeys="${entity.entityLabel}"/></td>
    </tr>
    <tr>
      <td valign="top" class="ViewTableBackground">
		    
        <#include "/classic/view-main.ftl">
		<#include "/classic/view-detail.ftl">
		
		<script language="JavaScript">
          var detailNames = Array(<#list serviceTool.getChild(entity,allServices)  as childEntity>'<hi:text key="${childEntity.entityLabel}"/>'<#if childEntity_has_next>,</#if></#list>);
		  var detailTabButtons = Array(<#list serviceTool.getChild(entity,allServices)  as childEntity>'true'<#if childEntity_has_next>,</#if></#list>);
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><ws:if test="workflow==null"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"/>" class="Button2" onclick="javascript:window.location='${entity.entityName?uncap_first}List.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>