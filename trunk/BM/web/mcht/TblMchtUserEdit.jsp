<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商服操作员"/></h2>
<form action="tblMchtUserSave.action?navTabId=tblMchtUserList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="商户号" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.mchtNo" class="textInput" value="${tblMchtUser.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.userName" class="textInput required" value="${tblMchtUser.userName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="国家" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.country" class="textInput" value="${tblMchtUser.country}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="时区" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.timeZone" class="textInput" value="${tblMchtUser.timeZone}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号可用" entity="TblMchtUser"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtUser.accountEnabled"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="加锁" entity="TblMchtUser"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtUser.accountLocked"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="用效期至" entity="TblMchtUser"/>：</dt>
			<dd>
				<input type="text" name="tblMchtUser.expiredDate" class="textInput date" readonly="readonly"
					value="<fmt:formatDate value='${tblMchtUser.expiredDate}' pattern='yyyy-MM-dd'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="是否过期" entity="TblMchtUser"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtUser.credentialsExpired"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.fullName" class="textInput required" value="${tblMchtUser.fullName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="TblMchtUser"/>：</dt>
			<dd>
				<input type="hidden" name="tblMchtUser.org.id" value="${tblMchtUser.org.id}"/>
				<input type="text" class="textInput" name="tblMchtUser.hi_org.orgName" value="${tblMchtUser.org.orgName}"
					autocomplete="off" lookupGroup="tblMchtUser" lookupName="org" suggestClass="org.hi.base.organization.model.HiOrg" searchFields="orgName"/>
				<a class="btnLook" href="<hi:url>hiOrgLookup.action?lookup=1</hi:url>" lookupGroup="tblMchtUser" lookupName="org"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="TblMchtUser"/>：</dt><dd><hi:select emu="gender" name="tblMchtUser.gender"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.address" class="textInput" value="${tblMchtUser.address}" maxlength="200"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="电话" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.phone" class="textInput" value="${tblMchtUser.phone}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="手机" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.mobile" class="textInput" value="${tblMchtUser.mobile}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="邮编" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.zip" class="textInput" value="${tblMchtUser.zip}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="身份证" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.SSN" class="textInput" value="${tblMchtUser.SSN}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="E-Mail" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.mail" class="textInput" value="${tblMchtUser.mail}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="用户类型" entity="TblMchtUser"/>：</dt><dd><hi:select emu="userType" name="tblMchtUser.userMgrType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="提醒方式" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.notifyMode" class="textInput" value="${tblMchtUser.notifyMode}" maxlength="200"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblMchtUser"/>：</dt><dd><input type="text" name="tblMchtUser.description" class="textInput" value="${tblMchtUser.description}" maxlength="500"/></dd>
		</dl>
				<input type="hidden" name="tblMchtUser.id" value="${tblMchtUser.id}"/>
				<input type="hidden" name="tblMchtUser.creator.id" value="${tblMchtUser.creator.id}"/>
				<input type="hidden" name="tblMchtUser.deleted" value="${tblMchtUser.deleted}"/>
				<input type="hidden" name="tblMchtUser.password" value="${tblMchtUser.password}"/>
				<input type="hidden" name="tblMchtUser.version" value="${tblMchtUser.version}"/>

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
