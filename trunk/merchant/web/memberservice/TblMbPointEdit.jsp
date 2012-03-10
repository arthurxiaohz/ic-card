<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员积分"/></h2>
<form action="tblMbPointSave.action?navTabId=tblMbPointList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="帐号" entity="TblMbPoint"/>：</dt>
			<dd>
				<input type="hidden" name="tblMbPoint.tblMbInfo.id" value="${tblMbPoint.tblMbInfo.id}"/>
				<input type="text" class="textInput" name="tblMbPoint.hi_tblMbInfo.userName" value="${tblMbPoint.tblMbInfo.userName}"
					autocomplete="off" lookupGroup="tblMbPoint" lookupName="tblMbInfo" suggestClass="org.hi.base.organization.model.HiUser" searchFields="userName,fullName"/>
				<a class="btnLook" href="<hi:url>hiUserLookup.action?lookup=1</hi:url>" lookupGroup="tblMbPoint" lookupName="tblMbInfo"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbPoint"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblMbPoint.hi_tblMbInfo.fullName" value="${tblMbPoint.tblMbInfo.fullName}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="积分余额" entity="TblMbPoint"/>：</dt><dd><input type="text" name="tblMbPoint.balance" class="textInput integer" value="${tblMbPoint.balance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbPoint"/>：</dt>
			<dd>
				<input type="text" name="tblMbPoint.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPoint.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbPoint"/>：</dt>
			<dd>
				<input type="text" name="tblMbPoint.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPoint.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMbPoint.id" value="${tblMbPoint.id}"/>
				<input type="hidden" name="tblMbPoint.lastUpdatedBy.id" value="${tblMbPoint.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMbPoint.creator.id" value="${tblMbPoint.creator.id}"/>
				<input type="hidden" name="tblMbPoint.version" value="${tblMbPoint.version}"/>

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
