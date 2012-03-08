<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="对账任务控制表"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="对账批次号" entity="TblStlCheckOrganizationControl"/>：</dt><dd>${tblStlCheckOrganizationControl.checkBatchId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="机构代码" entity="TblStlCheckOrganizationControl"/>：</dt><dd>${tblStlCheckOrganizationControl.orgId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="机构类型" entity="TblStlCheckOrganizationControl"/>：</dt><dd>${tblStlCheckOrganizationControl.orgType}</dd>
		</dl>
		<dl>
			<dt><hi:text key="对账日期" entity="TblStlCheckOrganizationControl"/>：</dt><dd>${tblStlCheckOrganizationControl.checkDate}</dd>
		</dl>
		<dl>
			<dt><hi:text key="当前处理状态" entity="TblStlCheckOrganizationControl"/>：</dt><dd><hi:select emu="chkStatus" name="tblStlCheckOrganizationControl.status" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlCheckOrganizationControl"/>：</dt><dd><fmt:formatDate value="${tblStlCheckOrganizationControl.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlCheckOrganizationControl"/>：</dt><dd><fmt:formatDate value="${tblStlCheckOrganizationControl.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlCheckOrganizationControl"/>：</dt><dd>${tblStlCheckOrganizationControl.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="是否正在处理" entity="TblStlCheckOrganizationControl"/>：</dt><dd><hi:select emu="inProcess" name="tblStlCheckOrganizationControl.inProcess" isLabel="true"/></dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
