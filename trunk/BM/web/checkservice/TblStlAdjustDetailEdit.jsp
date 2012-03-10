<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="调账申请表"/></h2>
<form action="tblStlAdjustDetailSave.action?navTabId=tblStlAdjustDetailList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblStlAdjustDetail"/>：</dt><dd><input type="text" name="tblStlAdjustDetail.plTxTraceNo" class="textInput required" value="${tblStlAdjustDetail.plTxTraceNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="网关订单号" entity="TblStlAdjustDetail"/>：</dt><dd><input type="text" name="tblStlAdjustDetail.orderId" class="textInput integer" value="${tblStlAdjustDetail.orderId}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblStlAdjustDetail"/>：</dt><dd><hi:select emu="adjustStatus" name="tblStlAdjustDetail.status"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlAdjustDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlAdjustDetail.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlAdjustDetail.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlAdjustDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlAdjustDetail.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlAdjustDetail.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlAdjustDetail"/>：</dt><dd><input type="text" name="tblStlAdjustDetail.lastUpdatedBy" class="textInput required integer" value="${tblStlAdjustDetail.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblStlAdjustDetail"/>：</dt><dd><input type="text" name="tblStlAdjustDetail.description" class="textInput" value="${tblStlAdjustDetail.description}" maxlength="100"/></dd>
		</dl>
				<input type="hidden" name="tblStlAdjustDetail.id" value="${tblStlAdjustDetail.id}"/>
				<input type="hidden" name="tblStlAdjustDetail.creator.id" value="${tblStlAdjustDetail.creator.id}"/>
				<input type="hidden" name="tblStlAdjustDetail.deleted" value="${tblStlAdjustDetail.deleted}"/>
				<input type="hidden" name="tblStlAdjustDetail.version" value="${tblStlAdjustDetail.version}"/>

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
