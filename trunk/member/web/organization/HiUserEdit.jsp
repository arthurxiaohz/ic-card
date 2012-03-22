<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="人员"/></h2>
<form action="hiUserSave.action?navTabId=hiUserList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="hiUser.id" value="${hiUser.id}"/>
<input type="hidden" name="hiUser.version" value="${hiUser.version}"/>
<input type="hidden" name="hiUser.deleted" value="${hiUser.deleted}"/>
<input type="hidden" name="hiUser.creator.id" value="${hiUser.creator.id}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="帐号" entity="HiUser"/>：</dt><dd><input <c:if test="${tblMchtInfo.id!=null}">readonly="readonly"</c:if> type="text" name="hiUser.userName" class="textInput required" value="${hiUser.userName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.fullName" class="textInput required" value="${hiUser.fullName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="HiUser"/>：</dt>
			<dd>
				<input type="hidden" name="hiUser.org.id" value="${hiUser.org.id}"/>
				<input type="text" class="textInput required" name="hiUser.hi_org.orgName" value="${hiUser.org.orgName}"
									lookupGroup="hiUser" lookupName="org" suggestClass="org.hi.base.organization.model.HiOrg" searchFields="orgName"/>
				<a class="btnLook" href="tree.action?menuName=userOrgEditByOrg" lookupGroup="hiUser" lookupName="org"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="HiUser"/>：</dt><dd><hi:select emu="gender" name="hiUser.gender"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.address" class="textInput" value="${hiUser.address}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="电话" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.phone" class="textInput" value="${hiUser.phone}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="手机" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.mobile" class="textInput" value="${hiUser.mobile}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="邮编" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.zip" class="textInput" value="${hiUser.zip}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="身份证" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.SSN" class="textInput" value="${hiUser.SSN}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="E-Mail" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.mail" class="textInput" value="${hiUser.mail}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="时区" entity="HiUser"/>：</dt><dd><hi:entitySelect entityName="org.hi.i18n.model.Timezone" key="timezone" title="description" name="hiUser.timeZone" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="语言" entity="HiUser"/>：</dt><dd><hi:entitySelect entityName="org.hi.i18n.model.LanguageCode" key="id" title="description" name="hiUser.country" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="提醒方式" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.notifyMode" class="textInput" value="${hiUser.notifyMode}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.description" class="textInput" value="${hiUser.description}" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
  <input type="hidden" name="hiUser.userMgrType" value="${hiUser.userMgrType}"/>
  
</div>
</form>