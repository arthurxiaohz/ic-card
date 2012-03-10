<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="账户余额"/></h2>
<form action="tblActAccountBalanceSave.action?navTabId=tblActAccountBalanceList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="可用余额" entity="TblActAccountBalance"/>：</dt><dd><input type="text" name="tblActAccountBalance.availableBalance" class="textInput integer" value="${tblActAccountBalance.availableBalance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="账号" entity="TblActAccountBalance"/>：</dt><dd><input type="text" name="tblActAccountBalance.accountNo" class="textInput" value="${tblActAccountBalance.accountNo}" maxlength="22" readonly="readonly" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="账户分类" entity="TblActAccountBalance"/>：</dt><dd><hi:select emu="accountCatalog" name="tblActAccountBalance.accountCatalog"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="开户方类型" entity="TblActAccountBalance"/>：</dt><dd><hi:select emu="accountPartyType" name="tblActAccountBalance.accountPartyType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="开户方" entity="TblActAccountBalance"/>：</dt><dd><input type="text" name="tblActAccountBalance.accountParty" class="textInput" value="${tblActAccountBalance.accountParty}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="开户名称" entity="TblActAccountBalance"/>：</dt><dd><input type="text" name="tblActAccountBalance.accountName" class="textInput" value="${tblActAccountBalance.accountName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblActAccountBalance"/>：</dt><dd><hi:select emu="accountStatus" name="tblActAccountBalance.status"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblActAccountBalance"/>：</dt><dd><input type="text" name="tblActAccountBalance.remark" class="textInput" value="${tblActAccountBalance.remark}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblActAccountBalance"/>：</dt>
			<dd>
				<input type="text" name="tblActAccountBalance.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblActAccountBalance.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblActAccountBalance"/>：</dt>
			<dd>
				<input type="text" name="tblActAccountBalance.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblActAccountBalance.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblActAccountBalance.id" value="${tblActAccountBalance.id}"/>
				<input type="hidden" name="tblActAccountBalance.creator.id" value="${tblActAccountBalance.creator.id}"/>
				<input type="hidden" name="tblActAccountBalance.deleted" value="${tblActAccountBalance.deleted}"/>
				<input type="hidden" name="tblActAccountBalance.lastUpdatedBy.id" value="${tblActAccountBalance.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblActAccountBalance.version" value="${tblActAccountBalance.version}"/>

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
