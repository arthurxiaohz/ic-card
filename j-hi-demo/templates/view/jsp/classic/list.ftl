<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<#include "/classic/list-head.ftl">
<body>
<form name="formSearch" method="post" action="${entity.entityName?uncap_first}List.action">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <#include "/classic/list-search-action.ftl">	
    </td>
  </tr>
  <tr>
    <td valign="top" class="SearchForm">
	  <#include "/classic/list-search.ftl">
    </td>
  </tr>
  <tr>
    <td height="5" ></td>
  </tr>
  <tr>
    <td valign="top">
	  <#include "/classic/list-list.ftl">
    </td>
  </tr>
</table>
</form>
</body>
</html>	