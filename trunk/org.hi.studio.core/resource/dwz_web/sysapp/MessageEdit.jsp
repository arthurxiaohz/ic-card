<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="sysapp/Message.js"></script>
  <script type="text/javascript" src="sysapp/MessageParameter.js"></script>
</head>
<body>
  <form name="saveForm" action="messageSave.action" method="post" onsubmit="return checkValue('message.receivers')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="消息"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="message.receiversLabel"><hi:text key="接收者" entity="Message" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="message.receivers" name="message.receivers" value="<ws:property value="message.receivers"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="message.receiverNamesLabel"><hi:text key="收信人" entity="Message" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="message.receiverNames" name="message.receiverNames" value="<ws:property value="message.receiverNames"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="message.senderLabel"><hi:text key="发信人" entity="Message" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="message.sender" name="message.sender" value="<ws:property value="message.sender"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="message.messageTypeLabel"><hi:text key="消息类型" entity="Message" />:</td>
				  <td width="35%" class="EditTableData">
				    <hi:select cssClass="EditTableDataEnum" emu="messageType" name="message.messageType" id="message.messageType"/>

				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="message.messageTextLabel"><hi:text key="消息正文" entity="Message" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="message.messageText" name="message.messageText" value="<ws:property value="message.messageText"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="message.createDateLabel"><hi:text key="创建时间:" entity="Message" /></td>
				  <td width="35%" class="EditTableData">
				    <table border="0" cellpadding="0" cellspacing="0">
				      <input name="message.createDate" maxlength="10"	class="EditTableDataText" id="message_createDate" type="text" size="10"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<ws:date name="message.createDate" format="yyyy-MM-dd HH:mm:ss"/>" />
					</table>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="message.sendDateLabel"><hi:text key="发送时间" entity="Message" />:</td>
				  <td width="35%" class="EditTableData">
				    <table border="0" cellpadding="0" cellspacing="0">
				      <input name="message.sendDate" maxlength="10"	class="EditTableDataText" id="message_createDate" type="text" size="10"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<ws:date name="message.sendDate" format="yyyy-MM-dd HH:mm:ss"/>" />
					</table>

				  </td>
				  <td width="15%" class="EditTableLabel"  id="message.isSentLabel"><hi:text key="已发送" entity="Message" />:</td>
				  <td width="35%" class="EditTableData">
				    <hi:select cssClass="EditTableDataEnum" emu="yesNo" name="message.isSent" id="message.isSent"/>

				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="message.descriptionLabel"><hi:text key="描述" entity="Message" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="message.description" name="message.description" value="<ws:property value="message.description"/>">
				  </td>
				</tr>
				<input type="hidden" id="message.id" name="message.id" value="<ws:property value="message.id"/>">
				<input type="hidden" id="message.creator.id" name="message.creator.id" value="<ws:property value="message.creator.id"/>">
				<input type="hidden" id="message.version" name="message.version" value="<ws:property value="message.version"/>">
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
			  <div id="message_detailTabsDIV">
			    <div id="tabViewmain1_0" class="dhtmlgoodies_aTab">
			  	  <input type="hidden" name="messageParameter_Length" id="messageParameter_Length" value='<ws:property value="message.messageParameters.size" default="0"/>' />
				  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="DetailTable">
				    <tr>
					  <input type="button" onclick="message_addDetail('messageParameter')" value="<hi:text key="新建" />"></input>
					</tr>
					<thead>
				    <tr> <!-- detail header -->
				      <td class="DetailTableLable"><hi:text key="参数键" entity="MessageParameter" /></td>
				      <td class="DetailTableLable"><hi:text key="参数值" entity="MessageParameter" /></td>
				      <td class="DetailTableLable"><hi:text key="操作" />   </td>
				    </tr>        <!-- detail header end -->
				    </thead>
				    <tbody id="messageParameter_Tbody" > 
				    <ws:iterator value="message.messageParameters" id="messageParameter" status="messageParameterIndex">
				    <tr> <!-- detail body -->								
				      <td class="DetailTableData">
					    <input type="hidden"
									id="message.messageParameters[${messageParameterIndex.count-1}].id"
									name="message.messageParameters[${messageParameterIndex.count-1}].id"
									value="<ws:property id="messageParameter" value="id"/>"/>
					    <input type="text"
						            id="message.messageParameters[${messageParameterIndex.count-1}].parameterKey"
						            name="message.messageParameters[${messageParameterIndex.count-1}].parameterKey"
						            value="<ws:property id="messageParameter" value="parameterKey"/>"
						            size="12" />
				      </td>
				      <td class="DetailTableData">
					    <input type="text"
						            id="message.messageParameters[${messageParameterIndex.count-1}].parameterValue"
						            name="message.messageParameters[${messageParameterIndex.count-1}].parameterValue"
						            value="<ws:property id="messageParameter" value="parameterValue"/>"
						            size="12" />
				      </td>
				      <td class="DetailTableData">
				        <image src="images/delete.gif" onclick="message_delDetail('<ws:property id="messageParameter" value="id"/>','messageParameter')" style="cursor:hand">
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
          var detailNames = Array('<hi:text key="消息参数" />');
		  var detailTabButtons = Array('true');
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="button" onclick="if(saveForm.onsubmit()) saveForm.submit();" id="save" value="<hi:text key="保存"    />" class="Button2"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='messageList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  
  </form>
</body>
</html>