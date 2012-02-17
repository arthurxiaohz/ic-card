<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<%@page import="org.hi.framework.security.context.UserContextHelper"%>
<%@page import="org.hi.base.organization.model.UserType"%><html>
 
<%
	String filterUserType = "";
	if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MANAGER){
		filterUserType = "1401,1402";
	}
	
%>
<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="人员"/></h2>

<form action="securityUserSave.action?navTabId=securityUserList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="hiUser.id" value="${hiUser.id}"/>
<input type="hidden" name="hiUser.version" value="${hiUser.version}"/>
<input type="hidden" name="hiUser.deleted" value="${hiUser.deleted}"/>
<input type="hidden" name="hiUser.creator.id" value="${hiUser.creator.id}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="姓名" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.fullName" class="textInput" value="${hiUser.fullName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="HiUser"/>：</dt>
			<dd>
				<input type="hidden" name="hiUser.org.id" value="${hiUser.org.id}"/>
				<input type="text" class="textInput" name="hiUser.hi_org.orgName" value="${hiUser.org.orgName}"
									lookupGroup="hiUser" lookupName="org" suggestClass="org.hi.base.organization.model.HiOrg" searchFields="orgName"/>
				<a class="btnLook" href="hiOrgLookup.action?lookup=1" lookupGroup="hiUser" lookupName="org"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="HiUser"/>：</dt><dd><input type="text" name="hiUser.userName" class="textInput" value="${hiUser.userName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="密码" entity="HiUser"/>：</dt><dd><input type="password" name="hiUser.newPassword" class="textInput" value="${hiUser.password}" /></dd>
		</dl>
		
		<dl>
			<dt><hi:text key="帐号可用" entity="HiUser"/>：</dt><dd> <hi:select type="radio"  emu="yesNo" name="hiUser.accountEnabled" defaultValue="3200" /></dd>			
		</dl>
		
		<dl>
			<dt><hi:text key="加锁" entity="HiUser"/>：</dt><dd>  <hi:select type="radio" emu="yesNo" name="hiUser.accountLocked" defaultValue="3201" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期至" entity="HiUser"/>：</dt>
			<dd>
				<input type="text" name="hiUser.expiredDate" class="textInput date" readonly="readonly"
					value="<fmt:formatDate value='${hiUser.expiredDate}' pattern='yyyy-MM-dd'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="用户类型" entity="HiUser"/>：</dt><dd> <hi:select emu="userType" name="hiUser.userMgrType" defaultValue="1402" filterPattern="<%=filterUserType%>"/></dd>
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