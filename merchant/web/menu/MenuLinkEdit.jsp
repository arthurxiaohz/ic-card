<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="菜单链接"/></h2>
<form action="menuLinkSave.action?navTabId=menuLinkList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="menuLink.id" value="${menuLink.id}"/>
<input type="hidden" name="menuLink.menuLinkType" value="${menuLink.menuLinkType}"/>
<input type="hidden" name="menuLink.userName" value="${menuLink.creator.userName}"/>
<input type="hidden" name="menuLink.version" value="${menuLink.version}"/>
<input type="hidden" name="menuLink.creator.id" value="${menuLink.creator.id}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="菜单URL" entity="MenuLink"/>：</dt><dd><input type="text" name="menuLink.linkUrl" class="textInput required" value="${menuLink.linkUrl}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="MenuLink"/>：</dt><dd><input type="text" name="menuLink.displayRef" class="textInput required" value="${menuLink.displayRef}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="MenuLink"/>：</dt><dd><input type="text" name="menuLink.description" class="textInput required" value="${menuLink.description}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="权限" entity="MenuLink"/>：</dt><dd><input type="text" name="menuLink.hi_authority.description" readonly="readonly" class="textInput" value="${menuLink.authority.description}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="权限名称" entity="MenuLink"/>：</dt>
			<dd>
				<input type="hidden" name="menuLink.authority.id" value="${menuLink.authority.id}"/>
				<input type="text" class="textInput required" name="menuLink.hi_authority.authorityName" value="${menuLink.authority.authorityName}"
									lookupGroup="menuLink" lookupName="authority" suggestClass="org.hi.framework.security.model.Authority" searchFields="authorityName,id"/>
				<a class="btnLook" href="authorityLookup.action?lookup=1" lookupGroup="menuLink" lookupName="authority"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="序列" entity="MenuLink"/>：</dt><dd><input type="text" name="menuLink.sequence" class="textInput" value="${menuLink.sequence}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="菜单项名称" entity="MenuLink"/>：</dt>
			<dd>
				<input type="hidden" name="menuLink.menu.id" value="${menuLink.menu.id}"/>
				<input type="text" class="textInput required" name="menuLink.hi_menu.menuName" value="${menuLink.menu.menuName}"
									lookupGroup="menuLink" lookupName="menu" suggestClass="org.hi.base.organization.model.MenuLink" searchFields="menuName,description"/>
				<a class="btnLook" href="menuLookup.action?lookup=1" lookupGroup="menuLink" lookupName="menu"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="菜单项描述" entity="MenuLink"/>：</dt><dd><input type="text" name="menuLink.hi_menu.description" readonly="readonly" class="textInput" value="${menuLink.menu.description}"/></dd>
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