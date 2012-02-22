<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="个人设置"/></h2>
<form action="personalSettingSave.action?navTabId=personalSettingList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="hiUser.id" value="${hiUser.id}"/>
<input type="hidden" name="hiUser.userMgrType" value="${hiUser.userMgrType}"/>
<input type="hidden" name="hiUser.version"  value="${hiUser.version}"/>
<input type="hidden" name="hiUser.fullName"  value="${hiUser.fullName}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="帐号" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.userName" class="textInput" value="${hiUser.userName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="密码" entity="HiUser"/>：</dt><dd><input type="password" name="hiUser.newPassword" class="textInput" value="${hiUser.password}" /></dd>
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
			<dt><hi:text key="邮箱地址" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.mail" class="textInput" value="${hiUser.mail}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="时区" entity="HiUser"/>：</dt><dd><hi:entitySelect entityName="org.hi.i18n.model.Timezone" key="timezone" title="description" name="hiUser.timeZone" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="语言" entity="HiUser"/>：</dt><dd><hi:entitySelect entityName="org.hi.i18n.model.LanguageCode" key="id" title="description" name="hiUser.country" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.address" class="textInput" value="${hiUser.address}" /></dd>
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