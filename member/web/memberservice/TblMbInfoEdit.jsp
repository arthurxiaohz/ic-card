<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员信息"/></h2>
<form action="tblMbInfoSave.action?navTabId=tblMbInfoList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="账号" entity="TblMbInfo"/>：</dt><dd><input type="text" name="tblMbInfo.userName" class="textInput required" value="${tblMbInfo.userName}" maxlength="30"/></dd>
		</dl>
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
				<input type="hidden" name="tblMbInfo.id" value="${tblMbInfo.id}"/>
				<input type="hidden" name="tblMbInfo.lastUpdatedBy.id" value="${tblMbInfo.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMbInfo.creator.id" value="${tblMbInfo.creator.id}"/>
				<input type="hidden" name="tblMbInfo.deleted" value="${tblMbInfo.deleted}"/>
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
