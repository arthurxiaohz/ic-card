<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">枚举值查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="枚举值名称" entity="EnumerationValue"/>：</dt><dd>${enumerationValue.valueName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="EnumerationValue"/>：</dt><dd>${enumerationValue.displayRef}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="EnumerationValue"/>：</dt><dd>${enumerationValue.description}</dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>