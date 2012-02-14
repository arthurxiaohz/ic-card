<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="security/PrivilegeResource.js"></script>
</head>
<body>
  <form name="saveForm" action="privilegeResourceSave.action" method="post" onsubmit="return checkValue('privilegeResource.authorityName')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="权限资源"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="privilegeResource.authorityNameLabel"><hi:text key="权限名称" entity="PrivilegeResource" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="privilegeResource.authorityName" name="privilegeResource.authorityName" value="<ws:property value="privilegeResource.authorityName"/>">
				  
				  </td>
				  <td width="15%" class="EditTableLabel"  id="privilegeResource.viewLayerLabel"><hi:text key="表现层" entity="PrivilegeResource" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="privilegeResource.viewLayer" name="privilegeResource.viewLayer" value="<ws:property value="privilegeResource.viewLayer"/>">
				  
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="privilegeResource.veiwExtAuthNamesLabel"><hi:text key="表现层权限扩展" entity="PrivilegeResource" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="privilegeResource.veiwExtAuthNames" name="privilegeResource.veiwExtAuthNames" value="<ws:property value="privilegeResource.veiwExtAuthNames"/>">
				  
				  </td>
				  <td width="15%" class="EditTableLabel"  id="privilegeResource.businessLayerLabel"><hi:text key="业务层" entity="PrivilegeResource" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="privilegeResource.businessLayer" name="privilegeResource.businessLayer" value="<ws:property value="privilegeResource.businessLayer"/>">
				  
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="privilegeResource.bizExtAuthNamesLabel"><hi:text key="业务层权限扩展" entity="PrivilegeResource" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="privilegeResource.bizExtAuthNames" name="privilegeResource.bizExtAuthNames" value="<ws:property value="privilegeResource.bizExtAuthNames"/>">
				  
				  </td>
				</tr>
				<input type="hidden" id="privilegeResource.id" name="privilegeResource.id" value="<ws:property value="privilegeResource.id"/>">
				<input type="hidden" id="privilegeResource.version" name="privilegeResource.version" value="<ws:property value="privilegeResource.version"/>">
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
				
		<script language="JavaScript">
          var detailNames = Array();
		  var detailTabButtons = Array();
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="button" onclick="if(saveForm.onsubmit()) saveForm.submit();" id="save" value="<hi:text key="保存"    />" class="Button2"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='privilegeResourceList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>