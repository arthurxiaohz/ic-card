<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="Excel报表设计"/></h2>
<form action="excelReportDesignSave.action?navTabId=excelReportDesignList&callbackType=closeCurrent&ajax=1" method="post"  enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this, navTabAjaxDone)" >
<input type="hidden" name="excelReportDesign.id" value="${excelReportDesign.id}"/>
<input type="hidden" name="excelReportDesign.creator.id" value="${excelReportDesign.creator.id}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="报表名称" entity="ExcelReportDesign"/>：</dt><dd><input type="text" name="excelReportDesign.reportName" class="textInput required" value="${excelReportDesign.reportName}" /></dd>
	    </dl>
	    <dl>
			<dt><hi:text key="报表 编号" entity="ExcelReportDesign"/>：</dt><dd><input type="text" name="excelReportDesign.reportNum" class="textInput" value="${excelReportDesign.reportNum}" /></dd>
	    </dl>
	    <dl>
			<dt><hi:text key="模板文件" entity="ExcelReportDesign"/>：</dt><dd>
			<input type="file" class="EditTableDataText" name="template" size="12">	
			<ws:if test="excelReportDesign.template !=null && excelReportDesign.template !=''">
				<a href="<ws:property value="excelReportDesign.template"/>" target="_blank"><hi:text key="查看模版" entity="ExcelReportDesign" /></a>
			</ws:if>								  
			</dd>
	    </dl>
		<dl>
			<dt><hi:text key="Action类(全限定名)" entity="ExcelReportDesign"/>：</dt><dd><input type="text" name="excelReportDesign.actionName" size="50" class="textInput required" value="${excelReportDesign.actionName}" /></dd>
	    </dl>

		<dl>
			<dt><hi:text key="激活" entity="ExcelReportDesign"/>：</dt><dd><hi:select emu="yesNo" name="excelReportDesign.enabled"/></dd>			
		</dl>
		 <dl>
			<dt><hi:text key="描述" entity="ExcelReportDesign"/>：</dt><dd><input type="text" name="excelReportDesign.description" class="textInput" value="${excelReportDesign.description}" /></dd>
	    </dl>
	    <dl>
			<dt><hi:text key="创建时间" entity="ExcelReportDesign"/>：</dt>
			<dd>
				<input type="text" name="excelReportDesign.createDate" class="textInput date" readonly="readonly"
					value="<fmt:formatDate value='${excelReportDesign.createDate}' pattern='yyyy-MM-dd'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>			
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
  
</div>
</form>
