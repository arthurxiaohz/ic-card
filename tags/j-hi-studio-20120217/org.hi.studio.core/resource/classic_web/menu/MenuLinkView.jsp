<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="menu/MenuLink.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="菜单链接" /></td>
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
				  <td width="15%" class="ViewTableLabel"  id="menuLink.linkUrlLabel"><hi:text key="菜单URL" entity="MenuLink" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menuLink.linkUrl"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="menuLink.displayRefLabel"><hi:text key="显示信息" entity="MenuLink" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menuLink.displayRef"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="menuLink.descriptionLabel"><hi:text key="描述" entity="MenuLink" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menuLink.description"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="menuLink.authorityLabel"><hi:text key="权限" entity="MenuLink" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menuLink.authority.id"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="menuLink.authorityNameLabel"><hi:text key="权限名称" entity="MenuLink" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="menuLink.authority.id" name="menuLink.authority.id" value="<ws:property value="menuLink.authority.id"/>">
					<ws:property value="menuLink.authority.authorityName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="menuLink.sequenceLabel"><hi:text key="序列" entity="MenuLink" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menuLink.sequence"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="menuLink.menuNameLabel"><hi:text key="菜单项名称" entity="MenuLink" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="menuLink.menu.id" name="menuLink.menu.id" value="<ws:property value="menuLink.menu.id"/>">
					<ws:property value="menuLink.menu.menuName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="menuLink.menuDescriptionLabel"><hi:text key="菜单项描述" entity="MenuLink" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="menuLink.menu.description"/>
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="menuLink.id" name="menuLink.id" value="<ws:property value="menuLink.id"/>">
				<input type="hidden" id="menuLink.menu" name="menuLink.menu" value="<ws:property value="menuLink.menu"/>">
				<input type="hidden" id="menuLink.creator" name="menuLink.creator" value="<ws:property value="menuLink.creator"/>">
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
		    <td><ws:if test="workflow==null">	<input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='menuLinkList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>