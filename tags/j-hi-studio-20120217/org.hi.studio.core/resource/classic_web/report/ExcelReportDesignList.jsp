<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="report/ExcelReportDesign.js"></script>
</head>
<body>
<form name="formSearch" method="post" action="excelReportDesignList.action">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <input type="hidden" name="pageInfo.sorterName" id="pageInfo.sorterName" value="<ws:property value="pageInfo.sorterName" default=""/>" />
      <input type="hidden" name="pageInfo.sorterDirection" id="pageInfo.sorterDirection" value="<ws:property value="pageInfo.sorterDirection" default="ASC"/>" />
      <!-- action -->						
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="120" class="SearchTableTop"><hi:text key="查询条件" /> </td>
          <td >&nbsp;</td>
          <td width="64"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建" />" class="button1" onclick="excelReportDesign_addNew('<hi:url>excelReportDesignEdit.action?excelReportDesign.id=-1</hi:url>')"/></ws:if><ws:else><input type="button" value="<hi:text key="重置" />" class="button1" onclick="lookupExcelReportDesign('-1','','','','','')"/></ws:else></td>
          <td width="15">&nbsp;</td>
          <td width="64"><input type="button" value="<hi:text key="查询" />" class="button1" onclick="document.formSearch.submit()"/></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td valign="top" class="SearchForm">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="SearchTable">
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="报表名称" entity="ExcelReportDesign" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_reportName"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="报表编号" entity="ExcelReportDesign" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_reportNum"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	</tr>
	  </table>
    </td>
  </tr>
  <tr>
    <td height="5" ></td>
  </tr>
  <tr>
    <td valign="top">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="ListTableHeader">
	        <table width="300" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td class="ListTableHeaderText"><hi:text key="列表" parameterLanguageKeys="Excel报表设计"/></td>
	          </tr>
	        </table>
          </td>
        </tr>
        <tr>
          <td valign="top" class="ListTableBody">
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
          	    <td width="15" class="ListTableBodyLabel">
				  <input name="chkall" value="checkbox" onclick="javascript:selectAll()" type="checkbox">            
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('reportName')" id="title_reportName"><hi:text key="报表名称" entity="ExcelReportDesign" />
				  <ws:if test="pageInfo.sorterName.equals('reportName')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('reportNum')" id="title_reportNum"><hi:text key="报表编号" entity="ExcelReportDesign" />
				  <ws:if test="pageInfo.sorterName.equals('reportNum')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('createDate')" id="title_createDate"><hi:text key="创建时间" entity="ExcelReportDesign" />
				  <ws:if test="pageInfo.sorterName.equals('createDate')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('enabled')" id="title_enabled"><hi:text key="激活" entity="ExcelReportDesign" />
				  <ws:if test="pageInfo.sorterName.equals('enabled')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('description')" id="title_description"><hi:text key="描述" entity="ExcelReportDesign" />
				  <ws:if test="pageInfo.sorterName.equals('description')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
				<td class="ListTableBodyLabel">
				  <ws:if test="lookup==null">
				    <hi:text key="操作" />   
				  </ws:if>
				  <ws:else>
				    <hi:text key="查找带回" />
				  </ws:else>
				</td>
              </tr>

              <ws:iterator value="excelReportDesigns" status="excelReportDesign">
			    <tr class="<ws:if test="#excelReportDesign.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="excelReportDesign" value="id"/>" type="checkbox">
         		  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="excelReportDesign" value="reportName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="excelReportDesign" value="reportNum" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:date name="createDate" format="yyyy-MM-dd"/>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <hi:select emu="yesNo" name="excelReportDesigns[${excelReportDesign.count-1 }].enabled" isLabel="true"/>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="excelReportDesign" value="description" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
				    <ws:if test="lookup==null">
				      <a href="<hi:url>excelReportDesignRemove.action?excelReportDesign.id=<ws:property id="excelReportDesign" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/del.gif"  border="0"/></a>
				      &nbsp;
				      <a href="<hi:url>excelReportDesignView.action?excelReportDesign.id=<ws:property id="excelReportDesign" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/view.gif"  border="0"/></a>
				      &nbsp;
				      <a href="<hi:url>excelReportDesignEdit.action?excelReportDesign.id=<ws:property id="excelReportDesign" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/modify.gif"  border="0"/></a>
				    </ws:if>
				    <ws:else>
				      <span style="cursor: pointer" onclick="lookupExcelReportDesign('<ws:property id="excelReportDesign" value="id"/>','<ws:property id="excelReportDesign" value="reportName"/>','<ws:property id="excelReportDesign" value="reportNum"/>','<ws:property id="excelReportDesign" value="createDate"/>','<ws:property id="excelReportDesign" value="enabled"/>','<ws:property id="excelReportDesign" value="description"/>')"><img src="images/icon_Select.gif" border="0"></span>								
				    </ws:else>
				  </td>
			    </tr>
			  </ws:iterator>  		
		    </table>
		  </td>
	    </tr>
	    <tr align="center">
		  <td class="ListTableBody">
		    &nbsp;
		  </td>
	    </tr>
	    <tr>
          <td class="ListTableBody">
          	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="PageInfoLabel">
	           <tr>
	           	 <td align="left">
	           	   <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"  /></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"  /></font><ws:if test="lookup==null"> - <font id="delete" style="cursor:hand" onclick="javascript:deleteChecked('excelReportDesign')"><hi:text key="批量删除" /></font></ws:if>
	           	 </td>
	        	 <td align="right">
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="/excelReportDesignList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
	          	 </td>
	           </tr>
          	</table>
          </td>
        </tr>
	  </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>	