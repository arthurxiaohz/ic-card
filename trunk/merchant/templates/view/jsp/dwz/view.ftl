<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="${entity.entityLabel}"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        <#include "/dwz/view-main.ftl">
		<#include "/dwz/view-detail.ftl">
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
