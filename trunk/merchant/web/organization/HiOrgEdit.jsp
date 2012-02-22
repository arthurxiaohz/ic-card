<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="部门"/></h2>
<form action="hiOrgSave.action?navTabId=hiOrgList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="hiOrg.id" value="${hiOrg.id}"/>
<input type="hidden" name="hiOrg.version" value="${hiOrg.version}"/>
<input type="hidden" name="hiOrg.deleted" value="${hiOrg.deleted}"/>
<input type="hidden" name="hiOrg.creator.id" value="${hiOrg.creator.id}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="部门名称" entity="HiOrg"/>：</dt><dd><input type="text" name="hiOrg.orgName" class="textInput required" value="${hiOrg.orgName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="部门编号" entity="HiOrg"/>：</dt><dd><input type="text" name="hiOrg.orgNum" class="textInput" value="${hiOrg.orgNum}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="部门经理" entity="HiOrg"/>：</dt>
			<dd>
				<input type="hidden" name="hiOrg.manager.id" value="${hiOrg.manager.id}" />
				
				<input type="text" class="textInput" name="hiOrg.hi_manager.fullName" value="${hiOrg.manager.fullName}"
					lookupGroup="hiOrg" lookupName="manager" suggestClass="org.hi.base.organization.model.HiUser" searchFields="fullName"/>
				<a class="btnLook" href="tree.action?menuName=orgEditByUser" lookupGroup="hiOrg" lookupName="manager"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="上级部门" entity="HiOrg"/>：</dt>
			<dd>
				<input type="hidden" name="hiOrg.parentOrg.id" value="${hiOrg.parentOrg.id}" />
				<input type="text" class="textInput" name="hiOrg.hi_parentOrg.orgName" value="${hiOrg.parentOrg.orgName}"
									lookupGroup="hiOrg" lookupName="parentOrg" suggestClass="org.hi.base.organization.model.HiOrg" searchFields="orgName,orgNum"/>
				<a class="btnLook" href="tree.action?menuName=userOrgEditByOrg" lookupGroup="hiOrg" lookupName="parentOrg"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		
		<dl>
			<dt><hi:text key="地址" entity="HiOrg"/>：</dt><dd><input type="text" name="hiOrg.address" class="textInput" value="${hiOrg.address}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="HiOrg"/>：</dt><dd><input type="text" name="hiOrg.description" class="textInput" value="${hiOrg.description}" /></dd>
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

