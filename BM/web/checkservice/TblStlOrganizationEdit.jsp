<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="发卡行支持表"/></h2>
<form action="tblStlOrganizationSave.action?navTabId=tblStlOrganizationList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="机构代码" entity="TblStlOrganization"/>：</dt><dd><input type="text" name="tblStlOrganization.orgId" class="textInput required" value="${tblStlOrganization.orgId}" maxlength="11"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="机构类型" entity="TblStlOrganization"/>：</dt><dd><input type="text" name="tblStlOrganization.orgType" class="textInput" value="${tblStlOrganization.orgType}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="机构名称" entity="TblStlOrganization"/>：</dt><dd><input type="text" name="tblStlOrganization.orgName" class="textInput" value="${tblStlOrganization.orgName}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="可用状态" entity="TblStlOrganization"/>：</dt><dd><hi:select emu="status" name="tblStlOrganization.status"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="场次数" entity="TblStlOrganization"/>：</dt><dd><input type="text" name="tblStlOrganization.fieldTimes" class="textInput integer" value="${tblStlOrganization.fieldTimes}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblStlOrganization"/>：</dt><dd><input type="text" name="tblStlOrganization.extDesc" class="textInput" value="${tblStlOrganization.extDesc}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlOrganization"/>：</dt>
			<dd>
				<input type="text" name="tblStlOrganization.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlOrganization.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlOrganization"/>：</dt>
			<dd>
				<input type="text" name="tblStlOrganization.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlOrganization.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlOrganization"/>：</dt><dd><input type="text" name="tblStlOrganization.lastUpdatedBy" class="textInput required integer" value="${tblStlOrganization.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblStlOrganization.id" value="${tblStlOrganization.id}"/>
				<input type="hidden" name="tblStlOrganization.creator.id" value="${tblStlOrganization.creator.id}"/>
				<input type="hidden" name="tblStlOrganization.deleted" value="${tblStlOrganization.deleted}"/>
				<input type="hidden" name="tblStlOrganization.version" value="${tblStlOrganization.version}"/>

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
