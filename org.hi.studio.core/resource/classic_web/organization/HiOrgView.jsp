<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="organization/HiOrg.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="部门" /></td>
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
				  <td width="15%" class="ViewTableLabel"  id="hiOrg.orgNameLabel"><hi:text key="部门名称" entity="HiOrg" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiOrg.orgName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiOrg.orgNumLabel"><hi:text key="部门编号" entity="HiOrg" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiOrg.orgNum"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiOrg.managerNameLabel"><hi:text key="部门经理" entity="HiOrg" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="hiOrg.manager.id" name="hiOrg.manager.id" value="<ws:property value="hiOrg.manager.id"/>">
					<ws:property value="hiOrg.manager.fullName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiOrg.parentOrgNameLabel"><hi:text key="上级部门" entity="HiOrg" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="hiOrg.parentOrg.id" name="hiOrg.parentOrg.id" value="<ws:property value="hiOrg.parentOrg.id"/>">
					<ws:property value="hiOrg.parentOrg.orgName"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiOrg.addressLabel"><hi:text key="地址" entity="HiOrg" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiOrg.address"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiOrg.descriptionLabel"><hi:text key="描述" entity="HiOrg" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiOrg.description"/>
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="hiOrg.id" name="hiOrg.id" value="<ws:property value="hiOrg.id"/>">
				<input type="hidden" id="hiOrg.userName" name="hiOrg.userName" value="<ws:property value="hiOrg.userName"/>">
				<input type="hidden" id="hiOrg.deleted" name="hiOrg.deleted" value="<ws:property value="hiOrg.deleted"/>">
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
				
		<script language="JavaScript">
          var detailNames = Array();
		  var detailTabButtons = Array();
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><ws:if test="workflow==null"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='hiOrgList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>