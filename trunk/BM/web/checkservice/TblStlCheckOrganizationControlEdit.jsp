<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="对账任务控制表"/></h2>
<form action="tblStlCheckOrganizationControlSave.action?navTabId=tblStlCheckOrganizationControlList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="对账批次号" entity="TblStlCheckOrganizationControl"/>：</dt><dd><input type="text" name="tblStlCheckOrganizationControl.checkBatchId" class="textInput required" value="${tblStlCheckOrganizationControl.checkBatchId}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="机构代码" entity="TblStlCheckOrganizationControl"/>：</dt><dd><input type="text" name="tblStlCheckOrganizationControl.orgId" class="textInput" value="${tblStlCheckOrganizationControl.orgId}" maxlength="11"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="机构类型" entity="TblStlCheckOrganizationControl"/>：</dt><dd><input type="text" name="tblStlCheckOrganizationControl.orgType" class="textInput" value="${tblStlCheckOrganizationControl.orgType}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="对账日期" entity="TblStlCheckOrganizationControl"/>：</dt><dd><input type="text" name="tblStlCheckOrganizationControl.checkDate" class="textInput" value="${tblStlCheckOrganizationControl.checkDate}" maxlength="8"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="当前处理状态" entity="TblStlCheckOrganizationControl"/>：</dt><dd><hi:select emu="chkStatus" name="tblStlCheckOrganizationControl.status"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlCheckOrganizationControl"/>：</dt>
			<dd>
				<input type="text" name="tblStlCheckOrganizationControl.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlCheckOrganizationControl.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlCheckOrganizationControl"/>：</dt>
			<dd>
				<input type="text" name="tblStlCheckOrganizationControl.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlCheckOrganizationControl.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlCheckOrganizationControl"/>：</dt><dd><input type="text" name="tblStlCheckOrganizationControl.lastUpdatedBy" class="textInput required integer" value="${tblStlCheckOrganizationControl.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="是否正在处理" entity="TblStlCheckOrganizationControl"/>：</dt><dd><hi:select emu="inProcess" name="tblStlCheckOrganizationControl.inProcess"/></dd>			
		</dl>
				<input type="hidden" name="tblStlCheckOrganizationControl.id" value="${tblStlCheckOrganizationControl.id}"/>
				<input type="hidden" name="tblStlCheckOrganizationControl.creator.id" value="${tblStlCheckOrganizationControl.creator.id}"/>
				<input type="hidden" name="tblStlCheckOrganizationControl.deleted" value="${tblStlCheckOrganizationControl.deleted}"/>
				<input type="hidden" name="tblStlCheckOrganizationControl.version" value="${tblStlCheckOrganizationControl.version}"/>

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
