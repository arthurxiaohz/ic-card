<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="权限资源"/>
</h2>
<form action="privilegeResourceSave.action?navTabId=privilegeResourceList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="权限名称" entity="PrivilegeResource" />:</dt><dd>
			<input type="text" class="textInput required" id="privilegeResource.authorityName" name="privilegeResource.authorityName" value="<ws:property value="privilegeResource.authorityName"/>">
				 
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="表现层" entity="PrivilegeResource" />:</dt><dd>
			<input type="text" class="textInput" id="privilegeResource.viewLayer" name="privilegeResource.viewLayer" value="<ws:property value="privilegeResource.viewLayer"/>">
				  
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="表现层权限扩展" entity="PrivilegeResource" />:</dt>
			<dd>
			<input type="text" class="textInput" id="privilegeResource.veiwExtAuthNames" name="privilegeResource.veiwExtAuthNames" value="<ws:property value="privilegeResource.veiwExtAuthNames"/>">
				  
			</dd>			
		</dl>
		<dl>
			<dt><hi:text key="业务层" entity="PrivilegeResource" />:</dt>
			<dd>
				<input type="text" class="textInput" id="privilegeResource.businessLayer" name="privilegeResource.businessLayer" value="<ws:property value="privilegeResource.businessLayer"/>">
				  </dd>
		</dl>
		<dl>
			<dt><hi:text key="业务层权限扩展" entity="PrivilegeResource" />:</dt><dd>
				<input type="text" class="textInput" id="privilegeResource.bizExtAuthNames" name="privilegeResource.bizExtAuthNames" value="<ws:property value="privilegeResource.bizExtAuthNames"/>">
				 
			</dd>
		</dl>
			<input type="hidden" id="privilegeResource.id" name="privilegeResource.id" value="<ws:property value="privilegeResource.id"/>">
				<input type="hidden" id="privilegeResource.version" name="privilegeResource.version" value="<ws:property value="privilegeResource.version"/>">
			
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
