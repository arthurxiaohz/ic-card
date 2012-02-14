<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <link rel="stylesheet" type="text/css" href="css/calendar.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="js/common/calendar.js"></script>
  <script type="text/javascript" src="report/ExcelReportDesign.js"></script>
  <script type="text/javascript" src="report/ExcelSheet.js"></script>
</head>
<body>
  <form action="excelReportDesignSave.action" name="saveForm" method="post" onsubmit="return checkValue('excelReportDesign.reportName,excelReportDesign.actionName')" enctype="multipart/form-data">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="Excel报表设计"/></td>
    </tr>
    <tr>
      <td valign="top" class="EditTableBackground">
		    
        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTable"> <!-- fields to edit  -->
          <tr>
            <td height="5" >  </td>      
       	  </tr>
		  <tr>
		    <td >
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			    <tr>
				  <td width="15%" class="EditTableKeyLabel"  id="excelReportDesign.reportNameLabel"><hi:text key="报表名称" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="excelReportDesign.reportName" name="excelReportDesign.reportName" value="<ws:property value="excelReportDesign.reportName"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="excelReportDesign.reportNumLabel"><hi:text key="报表编号" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="excelReportDesign.reportNum" name="excelReportDesign.reportNum" value="<ws:property value="excelReportDesign.reportNum"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="excelReportDesign.templateLabel"><hi:text key="模板文件" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="file" class="EditTableDataText" name="template" size="12">	
					<ws:if test="excelReportDesign.template !=null && excelReportDesign.template !=''"><a href="<ws:property value="excelReportDesign.template"/>" target="_blank"><hi:text key="查看模版" entity="ExcelReportDesign" /></a></ws:if>								  
				  </td>
				  <td width="15%" class="EditTableLabel"  id="excelReportDesign.createDateLabel"><hi:text key="创建时间" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="EditTableData">
				    <table border="0" cellpadding="0" cellspacing="0">
				      <input name="excelReportDesign.createDate" class="EditTableDataText"	id="excelReportDesign.createDate" type="text" size="10"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<ws:date name="excelReportDesign.createDate" format="yyyy-MM-dd"/>" />
					</table>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="excelReportDesign.enabledLabel"><hi:text key="激活" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="EditTableData">
				    <hi:select cssClass="EditTableDataText" emu="yesNo" name="excelReportDesign.enabled" id="excelReportDesign.enabled"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableKeyLabel"  id="excelReportDesign.actionNameLabel"><hi:text key="Action类(全限定名)" entity="ExcelReportDesign" />:</td>
				  <td width="100%" colspan="3" class="EditTableData">
					<input type="text" class="EditTableDataText" size="76" id="excelReportDesign.actionName" name="excelReportDesign.actionName" value="<ws:property value="excelReportDesign.actionName"/>">
				  </td>
			    </tr>			    
				<tr>
				  <td width="15%" class="EditTableLabel"  id="excelReportDesign.descriptionLabel"><hi:text key="描述" entity="ExcelReportDesign" />:</td>
				  <td width="100%" colspan="3" class="EditTableData">
					<input type="text" class="EditTableDataText" size="76" id="excelReportDesign.description" name="excelReportDesign.description" value="<ws:property value="excelReportDesign.description"/>">
				  </td>
				</tr>
				<input type="hidden" id="excelReportDesign.id" name="excelReportDesign.id" value="<ws:property value="excelReportDesign.id"/>">
				<input type="hidden" id="excelReportDesign.creator.id" name="excelReportDesign.creator.id" value="<ws:property value="excelReportDesign.creator.id"/>">
			  </table>
			</td>
		  </tr>
		  <tfoot>
			<tr>
			  <td colspan="4">
			    &nbsp;
			  </td>
			</tr>
		  </tfoot>
		</table>  <!-- fields to edit end -->
		<!-- orderDetail edit -->
		
 
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="button" onclick="if(saveForm.onsubmit()) saveForm.submit();" id="save" value="<hi:text key="保存"/>" class="Button2"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='excelReportDesignList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>