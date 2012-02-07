<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">Excel报表设计查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="报表名称" entity="ExcelReportDesign"/>：</dt><dd>${excelReportDesign.reportName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="报表编号" entity="ExcelReportDesign"/>：</dt><dd>${excelReportDesign.reportNum}</dd>
		</dl>
		<dl>
			<dt><hi:text key="模板文件" entity="ExcelReportDesign"/>：</dt><dd>${excelReportDesign.template}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="ExcelReportDesign"/>：</dt><dd><fmt:formatDate value="${excelReportDesign.createDate}" pattern="yyyy-MM-dd"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="激活" entity="ExcelReportDesign"/>：</dt><dd><hi:select emu="yesNo" name="excelReportDesign.enabled" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="Action类(全限定名)" entity="ExcelReportDesign"/>：</dt><dd>${excelReportDesign.actionName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="ExcelReportDesign"/>：</dt><dd>${excelReportDesign.description}</dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>