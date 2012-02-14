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
  <form name="saveForm" action="enumerationSave.action" method="post" onsubmit="return checkValue('enumeration.enName')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="枚举实体"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="enumeration.enNameLabel">枚举名称:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="enumeration.enName" name="enumeration.enName" value="<ws:property value="enumeration.enName"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="enumeration.displayRefLabel">显示信息:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="enumeration.displayRef" name="enumeration.displayRef" value="<ws:property value="enumeration.displayRef"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="enumeration.descriptionLabel">描述:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="enumeration.description" name="enumeration.description" value="<ws:property value="enumeration.description"/>">
				  </td>
				</tr>
				<input type="hidden" id="enumeration.id" name="enumeration.id" value="<ws:property value="enumeration.id"/>">
				<input type="hidden" id="enumeration.enumerationType" name="enumeration.enumerationType" value="<ws:property value="enumeration.enumerationType"/>">
				<input type="hidden" id="enumeration.version" name="enumeration.version" value="<ws:property value="enumeration.version"/>">
				<input type="hidden" id="enumeration.creator.id" name="enumeration.creator.id" value="<ws:property value="enumeration.creator.id"/>">
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
		
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td>
			  <div id="enumeration_detailTabsDIV">
			    <div id="tabViewmain1_0" class="dhtmlgoodies_aTab">
			  	  <input type="hidden" name="enumerationValue_Length" id="enumerationValue_Length" value='<ws:property value="enumeration.enumerationValues.size" default="0"/>' />
				  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="DetailTable">
				    <tr>
					  <input type="button" onclick="enumeration_addDetail('enumerationValue')" value="<hi:text key="新建" />"></input>
					</tr>
					<thead>
				    <tr> <!-- detail header -->
				      <td class="DetailTableLable">枚举值名称</td>
				      <td class="DetailTableLable">显示信息</td>
				      <td class="DetailTableLable">描述</td>
				      <td class="DetailTableLable"><hi:text key="操作" />   </td>
				    </tr>        <!-- detail header end -->
				    </thead>
				    <tbody id="enumerationValue_Tbody" > 
				    <ws:iterator value="enumeration.enumerationValues" id="enumerationValue" status="enumerationValueIndex">
				    <tr> <!-- detail body -->								
					    <input type="hidden"
									id="enumeration.enumerationValues[${enumerationValueIndex.count-1}].id"
									name="enumeration.enumerationValues[${enumerationValueIndex.count-1}].id"
									value="<ws:property id="enumerationValue" value="id"/>"/>
					    <input type="hidden"
									id="enumeration.enumerationValues[${enumerationValueIndex.count-1}].version"
									name="enumeration.enumerationValues[${enumerationValueIndex.count-1}].version"
									value="<ws:property id="enumerationValue" value="version"/>"/>									
				      <td class="DetailTableData">
					    <input type="text"
						            id="enumeration.enumerationValues[${enumerationValueIndex.count-1}].valueName"
						            name="enumeration.enumerationValues[${enumerationValueIndex.count-1}].valueName"
						            value="<ws:property id="enumerationValue" value="valueName"/>"
						            size="12" />
				      </td>
				      <td class="DetailTableData">
					    <input type="text"
						            id="enumeration.enumerationValues[${enumerationValueIndex.count-1}].displayRef"
						            name="enumeration.enumerationValues[${enumerationValueIndex.count-1}].displayRef"
						            value="<ws:property id="enumerationValue" value="displayRef"/>"
						            size="30" />
				      </td>
				      <td class="DetailTableData">
					    <input type="text"
						            id="enumeration.enumerationValues[${enumerationValueIndex.count-1}].description"
						            name="enumeration.enumerationValues[${enumerationValueIndex.count-1}].description"
						            value="<ws:property id="enumerationValue" value="description"/>"
						            size="12" />
				      </td>
				      <td class="DetailTableData">
				        <image src="images/delete.gif" onclick="enumeration_delDetail('<ws:property id="enumerationValue" value="id"/>','enumerationValue')" style="cursor:hand">
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
          var detailNames = Array('枚举值');
		  var detailTabButtons = Array('true');
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="button" onclick="if(saveForm.onsubmit()) saveForm.submit();" id="save" value="<hi:text key="保存"    />" class="Button2"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='enumerationList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>