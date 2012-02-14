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
		<form action="personalSettingSave.action" method="post" onsubmit="return checkValue('hiUser.userName')">
   <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="个人设置"/></td>
    </tr>
    <tr>
      <td valign="top" class="EditTableBackground">   
    	<input type="hidden" id="hiUser.id" name="hiUser.id" value="<ws:property value="hiUser.id" />">
			<input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
				
			<table class="EditTable" cellpadding="2" cellspacing="1" width="100%"> <!-- fields to edit  -->
				<tbody>
				  <tr>
						<td class="EditTableTDKeyLabel"><hi:text key="帐号" entity="HiUser" />:</td>
						<td class="EditTableTDData" >
							<input type="text" class="EditTableDataText" id="hiUser.userName" name="hiUser.userName" value="<ws:property value="hiUser.userName"/>">
						</td>
						<td class="EditTableTDKeyLabel"><hi:text key="密码" entity="HiUser" />:</td>
						<td class="EditTableTDData" >
							<input type="password"  class="EditTableDataText" class="EditTableDataText" id="hiUser.newPassword" name="hiUser.newPassword" value="<ws:property value="hiUser.password"/>">
						</td>
					</tr>
					<tr>
						<td class="EditTableTDLabel"><hi:text key="电话" entity="HiUser" />:</td>
						<td class="EditTableTDData" >
							<input type="text"  class="EditTableDataText" id="hiUser.phone" name="hiUser.phone" value="<ws:property value="hiUser.phone"/>">
						</td>
						<td class="EditTableTDLabel"><hi:text key="手机" entity="HiUser" />:</td>
						<td class="EditTableTDData" >
							<input type="text" class="EditTableDataText" id="hiUser.mobile" name="hiUser.mobile" value="<ws:property value="hiUser.mobile"/>">
						</td>
					</tr>
					<tr>
						<td class="EditTableTDLabel"><hi:text key="邮编" entity="HiUser" />:</td>
						<td class="EditTableTDData" >
							<input type="text"  class="EditTableDataText" id="hiUser.zip" name="hiUser.zip" value="<ws:property value="hiUser.zip"/>">
						</td>
						<td class="EditTableTDLabel"><hi:text key="邮箱地址" entity="HiUser" />:</td>
						<td class="EditTableTDData" >
							<input type="text" class="EditTableDataText" id="hiUser.mail" name="hiUser.mail" value="<ws:property value="hiUser.mail"/>">
						</td>
					</tr>
					<tr>
						<td class="EditTableTDLabel"><hi:text key="时区" entity="HiUser" />:</td>
						<td class="EditTableTDData" >
							<hi:entitySelect entityName="org.hi.i18n.model.Timezone" key="timezone" title="description" name="hiUser.timeZone" />
						</td>
						<td class="EditTableTDLabel"><hi:text key="语言" entity="HiUser" />:</td>
						<td class="EditTableTDData" >
						<hi:entitySelect entityName="org.hi.i18n.model.LanguageCode" key="id" title="description" name="hiUser.country" />
							 
						</td>
					</tr>
					<tr>
						<td class="EditTableTDLabel" ><hi:text key="地址" entity="HiUser" />:</td>
						<td colspan="3">
							<textarea id="hiUser.address"  class="EditTableDataText" rows="2" cols="80" name="hiUser.address" ><ws:property value="hiUser.address"/></textarea>
						</td>
					</tr>
		
		</table> 
			<input type="hidden" id="hiUser.userMgrType" name="hiUser.userMgrType" value="<ws:property value="hiUser.userMgrType"/>">
			<input type="hidden" id="hiUser.version" name="hiUser.version" value="<ws:property value="hiUser.version"/>">
			<input type="hidden" id="hiUser.fullName" name="hiUser.fullName" value="<ws:property value="hiUser.fullName"/>">
			</td>
		  </tr>
		</table>  
			<!-- orderDetail edit -->

	<script language="JavaScript">
		var detailNames = Array();
		var detailTabButtons = Array();
	</script>
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="submit" type="submit" id="submit" value="<hi:text key="保存"    />" class="Button2" /></td>
		  </tr>
		</table>
    	
		</form>
	</body>
</html>