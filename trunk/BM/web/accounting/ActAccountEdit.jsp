<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="账户"/></h2>
<form action="actAccountSave.action?navTabId=actAccountList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="账号" entity="ActAccount"/>：</dt><dd><input type="text" name="actAccount.accountNo" class="textInput" value="${actAccount.accountNo}" maxlength="22" readonly="readonly" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="账户分类" entity="ActAccount"/>：</dt><dd><hi:select emu="accountCatalog" name="actAccount.accountCatalog"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="开户方类型" entity="ActAccount"/>：</dt><dd><hi:select emu="accountPartyType" name="actAccount.accountPartyType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="开户方" entity="ActAccount"/>：</dt><dd><input type="text" name="actAccount.accountParty" class="textInput" value="${actAccount.accountParty}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="开户名称" entity="ActAccount"/>：</dt><dd><input type="text" name="actAccount.accountName" class="textInput" value="${actAccount.accountName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="ActAccount"/>：</dt><dd><hi:select emu="accountStatus" name="actAccount.status"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="ActAccount"/>：</dt><dd><input type="text" name="actAccount.remark" class="textInput" value="${actAccount.remark}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="ActAccount"/>：</dt>
			<dd>
				<input type="text" name="actAccount.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${actAccount.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="ActAccount"/>：</dt>
			<dd>
				<input type="text" name="actAccount.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${actAccount.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="actAccount.id" value="${actAccount.id}"/>
				<input type="hidden" name="actAccount.lastUpdatedBy.id" value="${actAccount.lastUpdatedBy.id}"/>
				<input type="hidden" name="actAccount.creator.id" value="${actAccount.creator.id}"/>
				<input type="hidden" name="actAccount.deleted" value="${actAccount.deleted}"/>
				<input type="hidden" name="actAccount.version" value="${actAccount.version}"/>

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
