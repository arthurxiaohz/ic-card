<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="菜单项"/></h2>
<form action="menuSave.action?navTabId=menuList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="menu.menuType" value="${menu.menuType}"/>
<input type="hidden" name="menu.id" value="${menu.id}"/>
<input type="hidden" name="menu.version" value="${menu.version}"/>
<input type="hidden" name="menu.creator.id" value="${menu.creator.id}"/>

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="菜单名称" entity="Menu"/>：</dt><dd><input type="text" name="menu.menuName" class="textInput required" value="${menu.menuName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="Menu"/>：</dt><dd><input type="text" name="menu.displayRef" class="textInput required" value="${menu.displayRef}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="Menu"/>：</dt><dd><input type="text" name="menu.description" class="textInput required" value="${menu.description}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="父菜单项" entity="Menu"/>：</dt>
			<dd>
				<input type="hidden" name="menu.parentMenu.id" value="${menu.parentMenu.id}"/>
				<input type="text" class="textInput" name="menu.hi_parentMenu.menuName" value="${menu.parentMenu.menuName}"
									lookupGroup="menu" lookupName="parentMenu" suggestClass="org.hi.base.organization.model.Menu" searchFields="parentMenuName"/>
				<a class="btnLook" href="menuLookup.action?lookup=1" lookupGroup="menu" lookupName="parentMenu"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="序列" entity="Menu"/>：</dt><dd><input type="text" name="menu.sequence" class="textInput" value="${menu.sequence}" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
  
</div>
</form>