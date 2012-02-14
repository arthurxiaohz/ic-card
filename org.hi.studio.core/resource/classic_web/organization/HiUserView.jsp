<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="organization/HiUser.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="人员" /></td>
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
				  <td width="15%" class="ViewTableLabel"  id="hiUser.userNameLabel"><hi:text key="帐号" entity="HiUser" />帐号:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.userName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.countryLabel"><hi:text key="国家" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.country"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.timeZoneLabel"><hi:text key="时区" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.timeZone"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.accountEnabledLabel"><hi:text key="帐号可用" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="yesNo" name="hiUser.accountEnabled" isLabel="true"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.accountLockedLabel"><hi:text key="加锁" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="yesNo" name="hiUser.accountLocked" isLabel="true"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.expiredDateLabel"><hi:text key="用效期至" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					  <ws:date name="hiUser.expiredDate" format="yyyy-MM-dd"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.credentialsExpiredLabel"><hi:text key="是否过期" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="yesNo" name="hiUser.credentialsExpired" isLabel="true"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.fullNameLabel"><hi:text key="姓名" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.fullName"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.orgNameLabel"><hi:text key="部门" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="hiUser.org.id" name="hiUser.org.id" value="<ws:property value="hiUser.org.id"/>">
					<ws:property value="hiUser.org.orgName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.genderLabel"><hi:text key="性别" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="gender" name="hiUser.gender" isLabel="true"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.addressLabel"><hi:text key="地址" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.address"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.phoneLabel"><hi:text key="电话" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.phone"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.mobileLabel"><hi:text key="手机" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.mobile"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.zipLabel"><hi:text key="邮编" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.zip"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.sSNLabel"><hi:text key="身份证" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.sSN"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.mailLabel"><hi:text key="E-Mail" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.mail"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.userMgrTypeLabel"><hi:text key="用户类型" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="userType" name="hiUser.userMgrType" isLabel="true"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.notifyModeLabel"><hi:text key="提醒方式" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.notifyMode"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="hiUser.descriptionLabel"><hi:text key="描述" entity="HiUser" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="hiUser.description"/>
				  </td>
				</tr>
				<input type="hidden" id="hiUser.id" name="hiUser.id" value="<ws:property value="hiUser.id"/>">
				<input type="hidden" id="hiUser.password" name="hiUser.password" value="<ws:property value="hiUser.password"/>">
				<input type="hidden" id="hiUser.creatorName" name="hiUser.creatorName" value="<ws:property value="hiUser.creatorName"/>">
				<input type="hidden" id="hiUser.deleted" name="hiUser.deleted" value="<ws:property value="hiUser.deleted"/>">
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
		    <td><ws:if test="workflow==null"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='hiUserList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>