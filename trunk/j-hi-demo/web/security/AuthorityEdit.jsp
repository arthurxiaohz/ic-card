<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="权限"/>
</h2>
<form action="authoritySave.action?navTabId=authorityList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="权限名称" entity="Authority" />:</dt><dd>
			<input type="text" class="textInput required" id="authority.authorityName" name="authority.authorityName" value="<ws:property value="authority.authorityName"/>">
					 
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="Authority" />:</dt><dd>
			<input type="text" class="textInput" id="authority.displayRef" name="authority.displayRef" value="<ws:property value="authority.displayRef"/>">
				 	  
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="属性资源" entity="Authority" />:</dt><dd>
			<input type="text" class="textInput" id="authority.propertedResource" name="authority.propertedResource" value="<ws:property value="authority.propertedResource"/>">
				 	  
			</dd>			
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="Authority" />:</dt>
			<dd>
				<input type="text" class="textInput" id="authority.description" name="authority.description" value="<ws:property value="authority.description"/>">
				   </dd>
		</dl>
		<dl>
			<dt><hi:text key="菜单链接" entity="Authority" />:</dt><dd>
				<input type="hidden" name="authority.menuLink.id" value="${authority.menuLink.id}"/>
				<input type="text" class="textInput required" name="authority.hi_menuLink.description" value="${authority.menuLink.description}"
									lookupGroup="authority" lookupName="menuLink" suggestClass="org.hi.base.menu.model.MenuLink" searchFields="description"/>
				<a class="btnLook" href="menuLinkLookup.action?lookup=1" lookupGroup="authority" lookupName="menuLink"><hi:text key="查找带回"/></a>		
		
					 
			</dd>
		</dl>
			<input type="hidden" id="authority.id" name="authority.id" value="<ws:property value="authority.id"/>">
				<input type="hidden" id="authority.creator.id" name="authority.creator.id" value="<ws:property value="authority.creator.id"/>">
				<input type="hidden" id="authority.authorityType" name="authority.authorityType" value="<ws:property value="authority.authorityType"/>">
				<div class="divider"></div>
			</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
  
</div>
</form>
