<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员信息"/></h2>
<form action="tblMbInfoSave.action?navTabId=tblMbInfoList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="证件类型" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.certificateTypeId" class="textInput" value="${tblMbInfo.certificateTypeId}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="卡号" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.cardNo" class="textInput required" value="${tblMbInfo.cardNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="实名认证状态" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.realNameStatus" class="textInput required" value="${tblMbInfo.realNameStatus}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="实名认证时间" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.realNameTime" class="textInput required" value="${tblMbInfo.realNameTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="注册时间" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.registerTime" class="textInput required" value="${tblMbInfo.registerTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="注册方式" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.registerWay" class="textInput required" value="${tblMbInfo.registerWay}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbInfo"/>：</dt>
			<dd>
				<input type="text" name="tblMbInfo.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbInfo.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbInfo"/>：</dt>
			<dd>
				<input type="text" name="tblMbInfo.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbInfo.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.userName" class="textInput required" value="${tblMbInfo.userName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="国家" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.country" class="textInput" value="${tblMbInfo.country}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="时区" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.timeZone" class="textInput" value="${tblMbInfo.timeZone}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号可用" entity="TblMbInfo"/>：</dt><dd><hi:select emu="yesNo" name="tblMbInfo.accountEnabled"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="加锁" entity="TblMbInfo"/>：</dt><dd><hi:select emu="yesNo" name="tblMbInfo.accountLocked"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="用效期至" entity="TblMbInfo"/>：</dt>
			<dd>
				<input type="text" name="tblMbInfo.expiredDate" class="textInput date" readonly="readonly"
					value="<fmt:formatDate value='${tblMbInfo.expiredDate}' pattern='yyyy-MM-dd'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="是否过期" entity="TblMbInfo"/>：</dt><dd><hi:select emu="yesNo" name="tblMbInfo.credentialsExpired"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.fullName" class="textInput required" value="${tblMbInfo.fullName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="TblMbInfo"/>：</dt>
			<dd>
				<input type="hidden" name="tblMbInfo.org.id" value="${tblMbInfo.org.id}"/>
				<input type="text" class="textInput" name="tblMbInfo.hi_org.orgName" value="${tblMbInfo.org.orgName}"
					autocomplete="off" lookupGroup="tblMbInfo" lookupName="org" suggestClass="org.hi.base.organization.model.HiOrg" searchFields="orgName"/>
				<a class="btnLook" href="<hi:url>hiOrgLookup.action?lookup=1</hi:url>" lookupGroup="tblMbInfo" lookupName="org"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="TblMbInfo"/>：</dt><dd><hi:select emu="gender" name="tblMbInfo.gender"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="地址" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.address" class="textInput" value="${tblMbInfo.address}" maxlength="200"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="电话" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.phone" class="textInput" value="${tblMbInfo.phone}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="手机" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.mobile" class="textInput" value="${tblMbInfo.mobile}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="邮编" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.zip" class="textInput" value="${tblMbInfo.zip}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="身份证" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.sSN" class="textInput" value="${tblMbInfo.sSN}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="E-Mail" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.mail" class="textInput" value="${tblMbInfo.mail}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="用户类型" entity="TblMbInfo"/>：</dt><dd><hi:select emu="userType" name="tblMbInfo.userMgrType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="提醒方式" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.notifyMode" class="textInput" value="${tblMbInfo.notifyMode}" maxlength="200"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.description" class="textInput" value="${tblMbInfo.description}" maxlength="500"/></dd>
		</dl>
				<input type="hidden" name="tblMbInfo.id" value="${tblMbInfo.id}"/>
				<input type="hidden" name="tblMbInfo.lastUpdatedBy.id" value="${tblMbInfo.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMbInfo.creator.id" value="${tblMbInfo.creator.id}"/>
				<input type="hidden" name="tblMbInfo.deleted" value="${tblMbInfo.deleted}"/>
				<input type="hidden" name="tblMbInfo.password" value="${tblMbInfo.password}"/>
				<input type="hidden" name="tblMbInfo.version" value="${tblMbInfo.version}"/>

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
