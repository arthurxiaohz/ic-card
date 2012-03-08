<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="账户余额"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="可用余额" entity="TblActAccountBalance"/>：</dt><dd>${tblActAccountBalance.availableBalance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账号" entity="TblActAccountBalance"/>：</dt><dd>${tblActAccountBalance.accountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账户分类" entity="TblActAccountBalance"/>：</dt><dd><hi:select emu="accountCatalog" name="tblActAccountBalance.accountCatalog" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="开户方类型" entity="TblActAccountBalance"/>：</dt><dd><hi:select emu="accountPartyType" name="tblActAccountBalance.accountPartyType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="开户方" entity="TblActAccountBalance"/>：</dt><dd>${tblActAccountBalance.accountParty}</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户名称" entity="TblActAccountBalance"/>：</dt><dd>${tblActAccountBalance.accountName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblActAccountBalance"/>：</dt><dd><hi:select emu="accountStatus" name="tblActAccountBalance.status" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblActAccountBalance"/>：</dt><dd>${tblActAccountBalance.remark}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblActAccountBalance"/>：</dt><dd><fmt:formatDate value="${tblActAccountBalance.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblActAccountBalance"/>：</dt><dd><fmt:formatDate value="${tblActAccountBalance.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
