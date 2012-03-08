<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="对账明细记录表"/></h2>
<form action="tblStlCheckDetailSave.action?navTabId=tblStlCheckDetailList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="对账批次号" entity="TblStlCheckDetail"/>：</dt><dd><input type="text" name="tblStlCheckDetail.checkBatchId" class="textInput required" value="${tblStlCheckDetail.checkBatchId}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="机构代码" entity="TblStlCheckDetail"/>：</dt><dd><input type="text" name="tblStlCheckDetail.orgId" class="textInput" value="${tblStlCheckDetail.orgId}" maxlength="11"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="机构类型" entity="TblStlCheckDetail"/>：</dt><dd><input type="text" name="tblStlCheckDetail.orgType" class="textInput" value="${tblStlCheckDetail.orgType}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="对账日期" entity="TblStlCheckDetail"/>：</dt><dd><input type="text" name="tblStlCheckDetail.checkDate" class="textInput" value="${tblStlCheckDetail.checkDate}" maxlength="8"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblStlCheckDetail"/>：</dt><dd><hi:select emu="detailStatus" name="tblStlCheckDetail.status"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlCheckDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlCheckDetail.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlCheckDetail.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlCheckDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlCheckDetail.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlCheckDetail.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlCheckDetail"/>：</dt><dd><input type="text" name="tblStlCheckDetail.lastUpdatedBy" class="textInput required integer" value="${tblStlCheckDetail.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="是否正在处理" entity="TblStlCheckDetail"/>：</dt><dd><hi:select emu="inProcess" name="tblStlCheckDetail.inProcess"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="交易机构流水号" entity="TblStlCheckDetail"/>：</dt><dd><input type="text" name="tblStlCheckDetail.txOrgOrderId" class="textInput" value="${tblStlCheckDetail.txOrgOrderId}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblStlCheckDetail"/>：</dt><dd><input type="text" name="tblStlCheckDetail.txAmount" class="textInput integer" value="${tblStlCheckDetail.txAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblStlCheckDetail.id" value="${tblStlCheckDetail.id}"/>
				<input type="hidden" name="tblStlCheckDetail.creator.id" value="${tblStlCheckDetail.creator.id}"/>
				<input type="hidden" name="tblStlCheckDetail.deleted" value="${tblStlCheckDetail.deleted}"/>
				<input type="hidden" name="tblStlCheckDetail.version" value="${tblStlCheckDetail.version}"/>

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
