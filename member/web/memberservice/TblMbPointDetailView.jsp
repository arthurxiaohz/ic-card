<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="会员积分明细"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="积分" entity="TblMbPointDetail"/>：</dt><dd>${tblMbPointDetail.point}</dd>
		</dl>
		<dl>
			<dt><hi:text key="积分交易类型" entity="TblMbPointDetail"/>：</dt><dd><hi:select emu="pointTxType" name="tblMbPointDetail.pointTxType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="积分变动凭证" entity="TblMbPointDetail"/>：</dt><dd>${tblMbPointDetail.voucherNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="积分余额" entity="TblMbPointDetail"/>：</dt><dd>${tblMbPointDetail.balance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbPointDetail"/>：</dt><dd><fmt:formatDate value="${tblMbPointDetail.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbPointDetail"/>：</dt><dd><fmt:formatDate value="${tblMbPointDetail.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="TblMbPointDetail"/>：</dt><dd>${tblMbPointDetail.tblMbInfo.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbPointDetail"/>：</dt><dd>${tblMbPointDetail.tblMbInfo.fullName}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
