<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="report/ExcelReportDesign.js"></script>
  <script type="text/javascript" src="report/ExcelSheet.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="Excel报表设计" /></td>
    </tr>
    <tr>
      <td valign="top" class="ViewTableBackground">
		    
        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTable"> <!-- fields to edit  -->
          <tr>
            <td height="5" >  </td>      
       	  </tr>
		  <tr>
		    <td >
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			    <tr>
				  <td width="15%" class="ViewTableLabel"  id="excelReportDesign.reportNameLabel"><hi:text key="报表名称" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="excelReportDesign.reportName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="excelReportDesign.reportNumLabel"><hi:text key="报表编号" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="excelReportDesign.reportNum"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="excelReportDesign.templateLabel"><hi:text key="模板文件" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="excelReportDesign.template"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="excelReportDesign.createDateLabel"><hi:text key="创建时间" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					  <ws:date name="excelReportDesign.createDate" format="yyyy-MM-dd"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="excelReportDesign.enabledLabel"><hi:text key="激活" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="yesNo" name="excelReportDesign.enabled" isLabel="true"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="excelReportDesign.actionNameLabel"><hi:text key="Action类(全限定名)" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="excelReportDesign.actionName"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="excelReportDesign.descriptionLabel"><hi:text key="描述" entity="ExcelReportDesign" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="excelReportDesign.description"/>
				  </td>
				</tr>
				<input type="hidden" id="excelReportDesign.id" name="excelReportDesign.id" value="<ws:property value="excelReportDesign.id"/>">
				<input type="hidden" id="excelReportDesign.creator" name="excelReportDesign.creator" value="<ws:property value="excelReportDesign.creator"/>">
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
		
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='excelReportDesignList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>