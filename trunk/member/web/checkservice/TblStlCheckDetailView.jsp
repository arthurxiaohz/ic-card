<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="对账明细记录表"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="对账批次号" entity="TblStlCheckDetail"/>：</dt><dd>${tblStlCheckDetail.checkBatchId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="机构代码" entity="TblStlCheckDetail"/>：</dt><dd>${tblStlCheckDetail.orgId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="机构类型" entity="TblStlCheckDetail"/>：</dt><dd>${tblStlCheckDetail.orgType}</dd>
		</dl>
		<dl>
			<dt><hi:text key="对账日期" entity="TblStlCheckDetail"/>：</dt><dd>${tblStlCheckDetail.checkDate}</dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblStlCheckDetail"/>：</dt><dd><hi:select emu="detailStatus" name="tblStlCheckDetail.status" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlCheckDetail"/>：</dt><dd><fmt:formatDate value="${tblStlCheckDetail.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlCheckDetail"/>：</dt><dd><fmt:formatDate value="${tblStlCheckDetail.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlCheckDetail"/>：</dt><dd>${tblStlCheckDetail.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="是否正在处理" entity="TblStlCheckDetail"/>：</dt><dd><hi:select emu="inProcess" name="tblStlCheckDetail.inProcess" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易机构流水号" entity="TblStlCheckDetail"/>：</dt><dd>${tblStlCheckDetail.txOrgOrderId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblStlCheckDetail"/>：</dt><dd>${tblStlCheckDetail.txAmount}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
