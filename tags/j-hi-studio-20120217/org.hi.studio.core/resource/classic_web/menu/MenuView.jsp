<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="menu/Menu.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="菜单项" /></td>
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
				  <td width="15%" class="ViewTableLabel"  id="menu.menuNameLabel"><hi:text key="菜单名称" entity="Menu" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menu.menuName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="menu.displayRefLabel"><hi:text key="显示信息" entity="Menu" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menu.displayRef"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="menu.descriptionLabel"><hi:text key="描述" entity="Menu" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menu.description"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="menu.parentMenuNameLabel"><hi:text key="父菜单项" entity="Menu" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="menu.parentMenu.id" name="menu.parentMenu.id" value="<ws:property value="menu.parentMenu.id"/>">
					<ws:property value="menu.parentMenu.menuName"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="menu.sequenceLabel"><hi:text key="序列" entity="Menu" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menu.sequence"/>
				  </td>
				</tr>
				<input type="hidden" id="menu.id" name="menu.id" value="<ws:property value="menu.id"/>">
				<input type="hidden" id="menu.parentMenu" name="menu.parentMenu" value="<ws:property value="menu.parentMenu"/>">
				<input type="hidden" id="menu.menuType" name="menu.menuType" value="<ws:property value="menu.menuType"/>">
				<input type="hidden" id="menu.creator" name="menu.creator" value="<ws:property value="menu.creator"/>">
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
		    <td><ws:if test="workflow==null">	<input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='menuList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>