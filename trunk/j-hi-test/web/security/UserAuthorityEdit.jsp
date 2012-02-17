<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="用户权限"/></h2>

<form name="saveForm" action="userAuthoritySave.action?navTabId=userAuthorityList&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="userAuthority.id" value="${userAuthority.id}">
<input type="hidden" name="userAuthority.version" value="${userAuthority.version}">

<div class="pageContent">
 
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="用户" entity="UserAuthority" />：</dt>
			<dd>
				<input type="hidden" name="userAuthority.securityUser.id" value="${userAuthority.securityUser.id}"/>
				<input type="text" class="textInput required" name="userAuthority.hi_securityUser.userName" value="${userAuthority.securityUser.userName}"
					autocomplete="off" lookupGroup="userAuthority" lookupName="securityUser" suggestClass="org.hi.base.organization.model.HiUser" searchFields="userName,fullName"/>
				<a class="btnLook" href="hiUserLookup.action?lookup=1" lookupGroup="userAuthority" lookupName="securityUser"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="权限" entity="UserAuthority" />：</dt>
			<dd>
				<input type="hidden" name="userAuthority.authority.id" value="${userAuthority.authority.id}"/>
				<input type="text" class="textInput required" name="userAuthority.hi_authority.description" value="${userAuthority.authority.description}"
					autocomplete="off" lookupGroup="userAuthority" lookupName="authority" suggestClass="org.hi.framework.security.model.Authority" searchFields="authorityName,description"/>
				<a class="btnLook" href="authorityLookup.action?lookup=1" lookupGroup="userAuthority" lookupName="authority"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="UserAuthority" />：</dt>
			<dd>
				<input type="hidden" name="userAuthority.org.id" value="${userAuthority.org.id}"/>
				<input type="text" class="textInput required" name="userAuthority.hi_org.orgName" value="${userAuthority.securityUser.orgName}"
					autocomplete="off" lookupGroup="userAuthority" lookupName="org" suggestClass="org.hi.base.organization.model.HiOrg" searchFields="orgName,orgNum"/>
				<a class="btnLook" href="hiOrgLookup.action?lookup=1" lookupGroup="userAuthority" lookupName="org"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="范围" entity="UserAuthority" />：</dt>
			<dd>
				<hi:select emu="securityScope" name="userAuthority.scope"/>
			</dd>
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
