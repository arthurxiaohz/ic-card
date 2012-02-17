<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="enumeration/Enumeration.js"></script>
  <script type="text/javascript" src="enumeration/EnumerationValue.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="枚举实体" /></td>
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
				  <td width="15%" class="ViewTableLabel"  id="enumeration.enNameLabel"><hi:text key="枚举名称" entity="Enumeration" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="enumeration.enName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="enumeration.displayRefLabel"><hi:text key="显示信息" entity="Enumeration" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="enumeration.displayRef"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="enumeration.descriptionLabel"><hi:text key="描述" entity="Enumeration" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="enumeration.description"/>
				  </td>
				</tr>
				<input type="hidden" id="enumeration.id" name="enumeration.id" value="<ws:property value="enumeration.id"/>">
				<input type="hidden" id="enumeration.enumerationType" name="enumeration.enumerationType" value="<ws:property value="enumeration.enumerationType"/>">
				<input type="hidden" id="enumeration.creator" name="enumeration.creator" value="<ws:property value="enumeration.creator"/>">
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
		
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td>
			  <div id="enumeration_detailTabsDIV">
			    <div id="tabViewmain1_0" class="dhtmlgoodies_aTab">
			  	  <input type="hidden" name="enumerationValue_Length" id="enumerationValue_Length" value='<ws:property value="enumeration.enumerationValues.size" default="0"/>' />
				  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="DetailTable">
				    <tr>
				    &nbsp;
					</tr>
					<thead>
				    <tr> <!-- detail header -->
				      <td class="DetailTableLable"><hi:text key="枚举值名称" entity="EnumerationValue" /></td>
				      <td class="DetailTableLable"><hi:text key="显示信息" entity="EnumerationValue" /></td>
				      <td class="DetailTableLable"><hi:text key="描述" entity="EnumerationValue" /></td>
				    </tr>        <!-- detail header end -->
				    </thead>
				    <tbody id="enumerationValue_Tbody" > 
				    <ws:iterator value="enumeration.enumerationValues" id="enumerationValue" status="enumerationValueIndex">
				    <tr> <!-- detail body -->								
				      <td class="DetailTableData">&nbsp;
					    <input type="hidden"
									id="enumeration.enumerationValues[${enumerationValueIndex.count-1}].id"
									name="enumeration.enumerationValues[${enumerationValueIndex.count-1}].id"
									value="<ws:property id="enumerationValue" value="id"/>"/>
						            <ws:property id="enumerationValue" value="valueName"/>
				      </td>
				      <td class="DetailTableData">&nbsp;
						            <ws:property id="enumerationValue" value="displayRef"/>
				      </td>
				      <td class="DetailTableData">&nbsp;
						            <ws:property id="enumerationValue" value="description"/>
				      </td>
				    </tr>   <!-- detail body end -->
				    </ws:iterator>
				    </tbody>
				  </table>
			    </div>
			  </div>
		    </td>
		  </tr>
		</table>
		
		<script language="JavaScript">
          var detailNames = Array('<hi:text key="枚举值" />');
		  var detailTabButtons = Array('true');
		</script>
	 	    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><ws:if test="workflow==null">	<input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='enumerationList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>