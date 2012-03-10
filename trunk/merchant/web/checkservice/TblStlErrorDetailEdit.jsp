<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="差错明细表"/></h2>
<form action="tblStlErrorDetailSave.action?navTabId=tblStlErrorDetailList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblStlErrorDetail"/>：</dt><dd><input type="text" name="tblStlErrorDetail.plTxTraceNo" class="textInput required" value="${tblStlErrorDetail.plTxTraceNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="订单金额" entity="TblStlErrorDetail"/>：</dt><dd><input type="text" name="tblStlErrorDetail.amount" class="textInput integer" value="${tblStlErrorDetail.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="订单创建时间" entity="TblStlErrorDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlErrorDetail.orderCreateDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlErrorDetail.orderCreateDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="机构订单号" entity="TblStlErrorDetail"/>：</dt><dd><input type="text" name="tblStlErrorDetail.orgOrderId" class="textInput" value="${tblStlErrorDetail.orgOrderId}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="连接id" entity="TblStlErrorDetail"/>：</dt><dd><input type="text" name="tblStlErrorDetail.connectionId" class="textInput integer" value="${tblStlErrorDetail.connectionId}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlErrorDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlErrorDetail.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlErrorDetail.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlErrorDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlErrorDetail.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlErrorDetail.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlErrorDetail"/>：</dt><dd><input type="text" name="tblStlErrorDetail.lastUpdatedBy" class="textInput required integer" value="${tblStlErrorDetail.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="差错类型" entity="TblStlErrorDetail"/>：</dt><dd><hi:select emu="discrepancyType" name="tblStlErrorDetail.discrepancyType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblStlErrorDetail"/>：</dt><dd><input type="text" name="tblStlErrorDetail.description" class="textInput" value="${tblStlErrorDetail.description}" maxlength="100"/></dd>
		</dl>
				<input type="hidden" name="tblStlErrorDetail.id" value="${tblStlErrorDetail.id}"/>
				<input type="hidden" name="tblStlErrorDetail.creator.id" value="${tblStlErrorDetail.creator.id}"/>
				<input type="hidden" name="tblStlErrorDetail.deleted" value="${tblStlErrorDetail.deleted}"/>
				<input type="hidden" name="tblStlErrorDetail.version" value="${tblStlErrorDetail.version}"/>

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
