<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="security/Authority.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="权限" /></td>
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
				  <td width="15%" class="ViewTableKeyLabel"  id="authority.authorityNameLabel"><hi:text key="权限名称" entity="Authority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="authority.authorityName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="authority.displayRefLabel"><hi:text key="显示信息" entity="Authority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="authority.displayRef"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="authority.propertedResourceLabel"><hi:text key="属性资源" entity="Authority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="authority.propertedResource"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="authority.descriptionLabel"><hi:text key="描述" entity="Authority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="authority.description"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="authority.menuLinkNameLabel"><hi:text key="菜单项" entity="Authority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="authority.menuLink.id" name="authority.menuLink.id" value="<ws:property value="authority.menuLink.id"/>">
					<ws:property value="authority.menuLink.description"/>
				  </td>
				</tr>
				<input type="hidden" id="authority.id" name="authority.id" value="<ws:property value="authority.id"/>">
				<input type="hidden" id="authority.authorityType" name="authority.authorityType" value="<ws:property value="authority.authorityType"/>">
				<input type="hidden" id="authority.menuLink" name="authority.menuLink" value="<ws:property value="authority.menuLink"/>">
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
		    <td><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='authorityList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>