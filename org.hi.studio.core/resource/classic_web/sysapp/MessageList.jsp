<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="sysapp/Message.js"></script>
</head>
<body>
<form name="formSearch" method="post" action="messageList.action">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <input type="hidden" name="pageInfo.sorterName" id="pageInfo.sorterName" value="<ws:property value="pageInfo.sorterName" default=""/>" />
      <input type="hidden" name="pageInfo.sorterDirection" id="pageInfo.sorterDirection" value="<ws:property value="pageInfo.sorterDirection" default="ASC"/>" />
      <!-- action -->						
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="120" class="SearchTableTop"><hi:text key="查询条件" /> </td>
          <td >&nbsp;</td>
          <td width="64"><authz:authorize ifAnyGranted="MESSAGE_SAVE"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建" />" class="button1" onclick="message_addNew()"/></ws:if><ws:else><input type="button" value="<hi:text key="重置" />" class="button1" onclick="lookupMessage('-1','','','','','','','')"/></ws:else></authz:authorize></td>
          <td width="15">&nbsp;</td>
          <td width="64"><input type="button" value="<hi:text key="查询" />" class="button1" onclick="javascript:formSearchSubmit()"/></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td valign="top" class="SearchForm">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="SearchTable">
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="收信人" entity="Message" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_receiverNames"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="发信人" entity="Message" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_sender"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	</tr>
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="消息类型" entity="Message" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_messageType" emu="messageType"   cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="消息正文" entity="Message" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_messageText"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	</tr>
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="创建时间" entity="Message" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_createDate"  cssClass="SearchTableData_Date" isDate="true" br="false" needSelect="false"/>
	  		<input type="hidden" name="pageInfo.f_createDate_op" value="&gt;=">
	  		&nbsp;-&nbsp;
	  		<hi:search name="pageInfo.f_createDate01" cssClass="SearchTableData_Date" needSelect="false" br="false" isDate="true" />
	  		<input type="hidden" name="pageInfo.f_createDate01_op" value="&lt;=">
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="发送时间" entity="Message" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_sendDate"  cssClass="SearchTableData_Date" isDate="true" br="false" needSelect="false"/>
	  		<input type="hidden" name="pageInfo.f_sendDate_op" value="&gt;=">
	  		&nbsp;-&nbsp;
	  		<hi:search name="pageInfo.f_sendDate01" cssClass="SearchTableData_Date" needSelect="false" br="false" isDate="true" />
	  		<input type="hidden" name="pageInfo.f_sendDate01_op" value="&lt;=">
	  	  </td>
	  	</tr>
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="已发送" entity="Message" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_isSent" emu="yesNo"   cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel">&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	  </td>
	  	</tr>
	  </table>
    </td>
  </tr>
  <tr>
    <td height="5" ></td>
  </tr>
  <tr>
    <td valign="top">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="ListTableHeader">
	        <table width="300" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td class="ListTableHeaderText"><hi:text key="列表" parameterLanguageKeys="消息"/></td>
	          </tr>
	        </table>
          </td>
        </tr>
        <tr>
          <td valign="top" class="ListTableBody">
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
          	    <td width="15" class="ListTableBodyLabel">
				  <input name="chkall" value="checkbox" onclick="javascript:selectAll()" type="checkbox">            
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('receiverNames')" id="title_receiverNames"><hi:text key="收信人" entity="Message" />
				  <ws:if test="pageInfo.sorterName.equals('receiverNames')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('sender')" id="title_sender"><hi:text key="发信人" entity="Message" />
				  <ws:if test="pageInfo.sorterName.equals('sender')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('messageType')" id="title_messageType"><hi:text key="消息类型" entity="Message" />
				  <ws:if test="pageInfo.sorterName.equals('messageType')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('createDate')" id="title_createDate"><hi:text key="创建时间" entity="Message" />
				  <ws:if test="pageInfo.sorterName.equals('createDate')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('sendDate')" id="title_sendDate"><hi:text key="发送时间" entity="Message" />
				  <ws:if test="pageInfo.sorterName.equals('sendDate')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('isSent')" id="title_isSent"><hi:text key="已发送" entity="Message" />
				  <ws:if test="pageInfo.sorterName.equals('isSent')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
                <td class="ListTableBodyLabel">
				  <a href="javascript:sortBy('description')" id="title_description"><hi:text key="描述" entity="Message" />
				  <ws:if test="pageInfo.sorterName.equals('description')">
				    <ws:if test="pageInfo.sorterDirection.equals('DESC')">
					  <img src="images/order_down.gif" border="0">
					</ws:if>
					<ws:else>
					  <img src="images/order_up.gif" border="0">
					</ws:else>
				  </ws:if>
				  </a>
				</td>
				<td class="ListTableBodyLabel">
				  <ws:if test="lookup==null">
				    <hi:text key="操作" />   
				  </ws:if>
				  <ws:else>
				    <hi:text key="查找带回" />
				  </ws:else>
				</td>
              </tr>

              <ws:iterator value="messages" status="message">
			    <tr class="<ws:if test="#message.odd==false">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="message" value="id"/>" type="checkbox">
         		  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="message" value="receiverNames" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="message" value="sender" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <hi:select emu="messageType" name="messages[${message.count-1 }].messageType" isLabel="true"/>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:date name="createDate" format="yyyy-MM-dd HH:mm:ss"/>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:date name="sendDate" format="yyyy-MM-dd HH:mm:ss"/>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <hi:select emu="yesNo" name="messages[${message.count-1 }].isSent" isLabel="true"/>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="message" value="description" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
				    <ws:if test="lookup==null">
				    <authz:authorize ifAnyGranted="MESSAGE_DEL">
				      <a href="messageRemove.action?message.id=<ws:property id="message" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/del.gif" alt="<hi:text key="删除" parameterLanguageKeys="消息" />" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="MESSAGE_VIEW">				      
				      &nbsp;
				      <a href="messageView.action?message.id=<ws:property id="message" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/view.gif" alt="<hi:text key="查看" parameterLanguageKeys="消息" />" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="MESSAGE_SAVE">				    
				      &nbsp;
				      <a href="messageEdit.action?message.id=<ws:property id="message" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/modify.gif" alt="<hi:text key="编辑" parameterLanguageKeys="消息" />" border="0"/></a>
				    </authz:authorize>				      
				    </ws:if>
				    <ws:else>
				      <span style="cursor: pointer" onclick="lookupMessage('<ws:property id="message" value="id"/>','<ws:property id="message" value="receiverNames"/>','<ws:property id="message" value="sender"/>','<ws:property id="message" value="messageType"/>','<ws:property id="message" value="createDate"/>','<ws:property id="message" value="sendDate"/>','<ws:property id="message" value="isSent"/>','<ws:property id="message" value="description"/>')"><img src="images/icon_Select.gif" border="0"></span>								
				    </ws:else>
				  </td>
			    </tr>
			  </ws:iterator>  		
		    </table>
		  </td>
	    </tr>
	    <tr align="center">
		  <td class="ListTableBody">
		    &nbsp;
		  </td>
	    </tr>
	    <tr>
          <td class="ListTableBody">
          	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="PageInfoLabel">
	           <tr>
	           	 <td align="left">
				   <authz:authorize ifAnyGranted="MESSAGE_DEL">	           	 
	           	    <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"  /></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"  /></font><ws:if test="lookup==null"> - <font id="delete" style="cursor:hand" onclick="javascript:deleteChecked('message')"><hi:text key="批量删除" /></font></ws:if>
				   </authz:authorize>
	           	 </td>
	        	 <td align="right">
	        	  <ws:if test="lookup==null">	        	 
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="messageList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
	        	  </ws:if>
				  <ws:else>
					<hi:page pageBeanName="pageInfo" currentPage="1" url="messageLookup.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />				  
	        	  </ws:else>				  	        	   
	          	 </td>
	           </tr>
          	</table>
          </td>
        </tr>
	  </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>	