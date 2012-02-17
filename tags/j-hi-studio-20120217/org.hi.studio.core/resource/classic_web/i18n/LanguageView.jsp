<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="i18n/Language.js"></script>
  <script type="text/javascript" src="i18n/LanguageStr.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="多语言信息" /> </td>
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
				  <td width="15%" class="ViewTableLabel"  id="language.keyStrLabel"><hi:text key="Key值" entity="Language"/>:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="language.keyStr"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="language.entityLabel"><hi:text key="实体" entity="Language"/>:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="language.entity"/>
				  </td>
			    </tr>
				  
				<input type="hidden" id="language.id" name="language.id" value="<ws:property value="language.id"/>">
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
			  <div id="language_detailTabsDIV">
			    <div id="tabViewmain1_0" class="dhtmlgoodies_aTab">
			  	  <input type="hidden" name="languageStr_Length" id="languageStr_Length" value='<ws:property value="language.languageStrs.size" default="0"/>' />
				  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="DetailTable">
				    <tr>
				    &nbsp;
					</tr>
					<thead>
				    <tr> <!-- detail header -->
				      <td class="DetailTableLable"><hi:text key="语言代码" entity="LanguageStr" /></td>
				      <td class="DetailTableLable"><hi:text key="值" entity="LanguageStr" /></td>
				    </tr>        <!-- detail header end -->
				    </thead>
				    <tbody id="languageStr_Tbody" > 
				    <ws:iterator value="language.languageStrs" id="languageStr" status="languageStrIndex">
				    <tr> <!-- detail body -->								
				      <td class="DetailTableData">&nbsp;
					    <input type="hidden"
									id="language.languageStrs[${languageStrIndex.count-1}].id"
									name="language.languageStrs[${languageStrIndex.count-1}].id"
									value="<ws:property id="languageStr" value="id"/>"/>
						            <ws:property id="languageStr" value="languageCode" escape="false"/>
					    
				      </td>
				      <td class="DetailTableData">&nbsp;
						            <ws:property id="languageStr" value="value" escape="false"/>
					    
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
          var detailNames = Array('<hi:text key="多语言值" />');
		  var detailTabButtons = Array('true');
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><ws:if test="workflow==null"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='languageList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>