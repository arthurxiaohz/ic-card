<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<form id="pagerForm" action="hiUserList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
</form>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	</head>	
	<body>
<form name="formSearch" method="post" action="hiUserBatchList.action">
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
          <td width="64"><input type="button" value="<hi:text key="查询" />" class="button1" onclick="document.formSearch.submit()"/></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td valign="top" class="SearchForm">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="SearchTable">
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="姓名" entity="HiUser" />:&nbsp;</td>
	  	  <td width="35%">
	  	    <hi:search name="pageInfo.f_fullName"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="部门" entity="HiUser" />:&nbsp;</td>
	  	  <td width="35%">
	  	    <hi:search name="pageInfo.org.f_orgName"    cssClass="SearchTableDataText" needSelect="false" />
	  	  <input type="hidden" name="pageInfo.f_userMgrType" value="1400"/>
	  	  <input type="hidden" name="pageInfo.f_userMgrType_op" value="&lt;&gt;"/>
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
	            <td class="ListTableHeaderText"><hi:text key="列表" parameterLanguageKeys="人员"/></td>
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
				  <a href="javascript:sortBy('userName')" id="title_userName"><hi:text key="帐号" entity="HiUser" />
				  <ws:if test="pageInfo.sorterName.equals('userName')">
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
				  <a href="javascript:sortBy('fullName')" id="title_fullName"><hi:text key="姓名" entity="HiUser" />
				  <ws:if test="pageInfo.sorterName.equals('fullName')">
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
				  <a href="javascript:sortBy('org.orgName')" id="title_org.orgName"><hi:text key="部门" entity="HiUser" />
				  <ws:if test="pageInfo.sorterName.equals('org.orgName')">
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
				  <a href="javascript:sortBy('gender')" id="title_gender"><hi:text key="性别" entity="HiUser" />
				  <ws:if test="pageInfo.sorterName.equals('gender')">
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
				  </td>
              </tr>

              <ws:iterator value="hiUsers" status="hiUser">
			    <tr class="<ws:if test="#hiUser.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="hiUser" value="id"/>" type="checkbox">
         		  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="hiUser" value="userName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="hiUser" value="fullName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="hiUser" value="org.orgName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <hi:select emu="gender" name="hiUsers[${hiUser.count-1 }].gender" isLabel="true"/>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
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
	           	   <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"  /></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"  /></font>
	           	 </td>
	        	 <td align="right">
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="hiUserBatchList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
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