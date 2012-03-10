<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="短信明细"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="发送方标识" entity="TblTxSmsLog"/>：</dt><dd>${tblTxSmsLog.senderId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="发送方流水号" entity="TblTxSmsLog"/>：</dt><dd>${tblTxSmsLog.seqNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="手机号码" entity="TblTxSmsLog"/>：</dt><dd>${tblTxSmsLog.phoneNum}</dd>
		</dl>
		<dl>
			<dt><hi:text key="短信内容" entity="TblTxSmsLog"/>：</dt><dd>${tblTxSmsLog.phoneMessage}</dd>
		</dl>
		<dl>
			<dt><hi:text key="发送状态" entity="TblTxSmsLog"/>：</dt><dd>${tblTxSmsLog.status}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxSmsLog"/>：</dt><dd><fmt:formatDate value="${tblTxSmsLog.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxSmsLog"/>：</dt><dd><fmt:formatDate value="${tblTxSmsLog.lastUpdatedDdatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxSmsLog"/>：</dt><dd>${tblTxSmsLog.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
