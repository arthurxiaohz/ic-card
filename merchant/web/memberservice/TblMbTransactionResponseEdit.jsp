<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="网关交易结果"/></h2>
<form action="tblMbTransactionResponseSave.action?navTabId=tblMbTransactionResponseList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="对应的系统订单号" entity="TblMbTransactionResponse"/>：</dt><dd><input type="text" name="tblMbTransactionResponse.ordedId" class="textInput" value="${tblMbTransactionResponse.ordedId}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易系统的机构号" entity="TblMbTransactionResponse"/>：</dt><dd><input type="text" name="tblMbTransactionResponse.orgId" class="textInput integer" value="${tblMbTransactionResponse.orgId}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易系统的交易流水号" entity="TblMbTransactionResponse"/>：</dt><dd><input type="text" name="tblMbTransactionResponse.orgOrdedId" class="textInput" value="${tblMbTransactionResponse.orgOrdedId}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblMbTransactionResponse"/>：</dt><dd><input type="text" name="tblMbTransactionResponse.amount" class="textInput integer" value="${tblMbTransactionResponse.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="报文的原始报文" entity="TblMbTransactionResponse"/>：</dt><dd><input type="text" name="tblMbTransactionResponse.context" class="textInput" value="${tblMbTransactionResponse.context}" maxlength="1,024"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="返回报文标识订单的成功状态" entity="TblMbTransactionResponse"/>：</dt><dd><input type="text" name="tblMbTransactionResponse.state" class="textInput integer" value="${tblMbTransactionResponse.state}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="发送报文的IP地址" entity="TblMbTransactionResponse"/>：</dt><dd><input type="text" name="tblMbTransactionResponse.sourceIp" class="textInput" value="${tblMbTransactionResponse.sourceIp}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbTransactionResponse"/>：</dt>
			<dd>
				<input type="text" name="tblMbTransactionResponse.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbTransactionResponse.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbTransactionResponse"/>：</dt><dd><input type="text" name="tblMbTransactionResponse.lastUpdatedBy" class="textInput integer" value="${tblMbTransactionResponse.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbTransactionResponse"/>：</dt>
			<dd>
				<input type="text" name="tblMbTransactionResponse.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbTransactionResponse.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMbTransactionResponse.id" value="${tblMbTransactionResponse.id}"/>
				<input type="hidden" name="tblMbTransactionResponse.creator.id" value="${tblMbTransactionResponse.creator.id}"/>
				<input type="hidden" name="tblMbTransactionResponse.deleted" value="${tblMbTransactionResponse.deleted}"/>
				<input type="hidden" name="tblMbTransactionResponse.version" value="${tblMbTransactionResponse.version}"/>

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
