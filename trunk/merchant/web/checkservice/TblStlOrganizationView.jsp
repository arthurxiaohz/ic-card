<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="发卡行支持表"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="机构代码" entity="TblStlOrganization"/>：</dt><dd>${tblStlOrganization.orgId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="机构类型" entity="TblStlOrganization"/>：</dt><dd>${tblStlOrganization.orgType}</dd>
		</dl>
		<dl>
			<dt><hi:text key="机构名称" entity="TblStlOrganization"/>：</dt><dd>${tblStlOrganization.orgName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="可用状态" entity="TblStlOrganization"/>：</dt><dd><hi:select emu="status" name="tblStlOrganization.status" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="场次数" entity="TblStlOrganization"/>：</dt><dd>${tblStlOrganization.fieldTimes}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblStlOrganization"/>：</dt><dd>${tblStlOrganization.extDesc}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlOrganization"/>：</dt><dd><fmt:formatDate value="${tblStlOrganization.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlOrganization"/>：</dt><dd><fmt:formatDate value="${tblStlOrganization.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlOrganization"/>：</dt><dd>${tblStlOrganization.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
