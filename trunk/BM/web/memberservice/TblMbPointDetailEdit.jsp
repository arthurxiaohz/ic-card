<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员积分明细"/></h2>
<form action="tblMbPointDetailSave.action?navTabId=tblMbPointDetailList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="积分" entity="TblMbPointDetail"/>：</dt><dd><input type="text" name="tblMbPointDetail.point" class="textInput integer" value="${tblMbPointDetail.point}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="积分交易类型" entity="TblMbPointDetail"/>：</dt><dd><hi:select emu="pointTxType" name="tblMbPointDetail.pointTxType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="积分变动凭证" entity="TblMbPointDetail"/>：</dt><dd><input type="text" name="tblMbPointDetail.voucherNo" class="textInput integer" value="${tblMbPointDetail.voucherNo}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="积分余额" entity="TblMbPointDetail"/>：</dt><dd><input type="text" name="tblMbPointDetail.balance" class="textInput integer" value="${tblMbPointDetail.balance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbPointDetail"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointDetail.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointDetail.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbPointDetail"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointDetail.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointDetail.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="TblMbPointDetail"/>：</dt>
			<dd>
				<input type="hidden" name="tblMbPointDetail.tblMbInfo.id" value="${tblMbPointDetail.tblMbInfo.id}"/>
				<input type="text" class="textInput" name="tblMbPointDetail.hi_tblMbInfo.userName" value="${tblMbPointDetail.tblMbInfo.userName}"
					autocomplete="off" lookupGroup="tblMbPointDetail" lookupName="tblMbInfo" suggestClass="org.hi.base.organization.model.HiUser" searchFields="userName,fullName"/>
				<a class="btnLook" href="<hi:url>hiUserLookup.action?lookup=1</hi:url>" lookupGroup="tblMbPointDetail" lookupName="tblMbInfo"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbPointDetail"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblMbPointDetail.hi_tblMbInfo.fullName" value="${tblMbPointDetail.tblMbInfo.fullName}" readonly="readonly"/>
			</dd>
		</dl>
				<input type="hidden" name="tblMbPointDetail.id" value="${tblMbPointDetail.id}"/>
				<input type="hidden" name="tblMbPointDetail.lastUpdatedBy.id" value="${tblMbPointDetail.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMbPointDetail.creator.id" value="${tblMbPointDetail.creator.id}"/>
				<input type="hidden" name="tblMbPointDetail.version" value="${tblMbPointDetail.version}"/>

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
