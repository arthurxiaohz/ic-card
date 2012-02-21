<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">消息查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="接收者" entity="Message"/>：</dt><dd>${message.receivers}</dd>
		</dl>
		<dl>
			<dt><hi:text key="收信人" entity="Message"/>：</dt><dd>${message.receiverNames}</dd>
		</dl>
		<dl>
			<dt><hi:text key="发信人" entity="Message"/>：</dt><dd>${message.sender}</dd>
		</dl>
		<dl>
			<dt><hi:text key="消息类型" entity="Message"/>：</dt><dd><hi:select emu="messageType" name="message.messageType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="消息正文" entity="Message"/>：</dt><dd>${message.messageText}</dd>
		</dl>
	    <dl>
			<dt><hi:text key="创建时间" entity="Message"/>：</dt><dd><fmt:formatDate value="${message.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="发送时间" entity="Message"/>：</dt><dd><fmt:formatDate value="${message.sendDate}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="已发送" entity="Message"/>：</dt><dd><hi:select emu="yesNo" name="message.isSent" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="Message"/>：</dt><dd>${message.description}</dd>
		</dl>
		

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="从表"/></span></a></li>
						<li><a href="javascript:void(0)"><span><hi:text key="从表2"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:120px;">
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="从字符串" entity="Item"/></th>
								<th><hi:text key="从整数" entity="Item"/></th>
								<th><hi:text key="从浮点" entity="Item"/></th>
								<th><hi:text key="从日期" entity="Item"/></th>
								<th><hi:text key="从日期时间" entity="Item"/></th>
								<th><hi:text key="部门名称" entity="Item"/></th>
								<th><hi:text key="从枚举" entity="Item"/></th>
								<th><hi:text key="从附件" entity="Item"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${master.items}">
							<tr>						
								<td>${item.itemString}</td>
								<td>${item.itemInt}</td>
								<td>${item.itemFloat}</td>
								<td><fmt:formatDate value="${item.itemDate}" pattern="yyyy-MM-dd"/></td>
								<td><fmt:formatDate value="${item.itemDataTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${item.itemLookup.orgName}</td>
				        		<td><hi:select emu="yesNo" name="item.itemEnum" isLabel="true"/></td>
								<td>
									<a href="attachmentView.action?attachment.id=${item.itemAtt_attachment.id}" target="blank"  >
										${item.itemAtt_attachment.fileNameImage}
									</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="测试" entity="Item2"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${master.item2s}">
							<tr>						
								<td>${item.testStr}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>				
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>















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
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="消息" /></td>
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
				  <td width="15%" class="ViewTableLabel"  id="message.receiversLabel"><hi:text key="接收者" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="message.receivers"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="message.receiverNamesLabel"><hi:text key="收信人" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="message.receiverNames"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="message.senderLabel"><hi:text key="发信人" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="message.sender"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="message.messageTypeLabel"><hi:text key="消息类型" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="messageType" name="message.messageType" isLabel="true"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="message.messageTextLabel"><hi:text key="消息正文" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="message.messageText"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="message.createDateLabel"><hi:text key="创建时间" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				      <ws:date name="message.createDate" format="yyyy-MM-dd HH:mm:ss"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="message.sendDateLabel"><hi:text key="发送时间" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				      <ws:date name="message.sendDate" format="yyyy-MM-dd HH:mm:ss"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="message.isSentLabel"><hi:text key="已发送" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="yesNo" name="message.isSent" isLabel="true"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="message.descriptionLabel"><hi:text key="描述" entity="Message" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="message.description"/>
				  </td>
				</tr>
				<input type="hidden" id="message.id" name="message.id" value="<ws:property value="message.id"/>">
				<input type="hidden" id="message.creator" name="message.creator" value="<ws:property value="message.creator"/>">
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
			  <div id="message_detailTabsDIV">
			    <div id="tabViewmain1_0" class="dhtmlgoodies_aTab">
			  	  <input type="hidden" name="messageParameter_Length" id="messageParameter_Length" value='<ws:property value="message.messageParameters.size" default="0"/>' />
				  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="DetailTable">
				    <tr>
				    &nbsp;
					</tr>
					<thead>
				    <tr> <!-- detail header -->
				      <td class="DetailTableLable"><hi:text key="参数键" entity="MessageParameter" /></td>
				      <td class="DetailTableLable"><hi:text key="参数值" entity="MessageParameter" /></td>
				    </tr>        <!-- detail header end -->
				    </thead>
				    <tbody id="messageParameter_Tbody" > 
				    <ws:iterator value="message.messageParameters" id="messageParameter" status="messageParameterIndex">
				    <tr> <!-- detail body -->								
				      <td class="DetailTableData">&nbsp;
					    <input type="hidden"
									id="message.messageParameters[${messageParameterIndex.count-1}].id"
									name="message.messageParameters[${messageParameterIndex.count-1}].id"
									value="<ws:property id="messageParameter" value="id"/>"/>
						            <ws:property id="messageParameter" value="parameterKey"/>
				      </td>
				      <td class="DetailTableData">&nbsp;
						            <ws:property id="messageParameter" value="parameterValue"/>
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
	 	    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><ws:if test="workflow==null">	<input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='messageList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>