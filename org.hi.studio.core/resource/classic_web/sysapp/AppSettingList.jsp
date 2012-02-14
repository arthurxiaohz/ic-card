<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="sysapp/AppSetting.js"></script>
</head>
<body>
<form name="formSearch" method="post" action="appSettingList.action">
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
          <td width="64"><authz:authorize ifAnyGranted="APPSETTING_SAVE"><ws:if test="!#published"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建" />" class="button1" onclick="appSetting_addNew('<hi:url>appSettingEdit.action?appSetting.id=-1</hi:url>')"/></ws:if><ws:else><input type="button" value="<hi:text key="重置" />" class="button" onclick="lookupAppSetting('-1','','','')"/></ws:else></ws:if></authz:authorize></td>
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
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="组名" entity="AppSetting" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_appGroup"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="配置名" entity="AppSetting" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_appName"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	</tr>
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="配置值" entity="AppSetting" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_appValue"    cssClass="SearchTableDataText" needSelect="false"/>
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
	            <td class="ListTableHeaderText"><hi:text key="列表" parameterLanguageKeys="应用配置"/></td>
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
				  <a href="javascript:sortBy('appGroup')" id="title_appGroup"><hi:text key="组名" entity="AppSetting" />
				  <ws:if test="pageInfo.sorterName.equals('appGroup')">
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
				  <a href="javascript:sortBy('appName')" id="title_appName"><hi:text key="配置名" entity="AppSetting" />
				  <ws:if test="pageInfo.sorterName.equals('appName')">
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
				  <a href="javascript:sortBy('appValue')" id="title_appValue"><hi:text key="配置值" entity="AppSetting" />
				  <ws:if test="pageInfo.sorterName.equals('appValue')">
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
				  <a href="javascript:sortBy('description')" id="title_appValue"><hi:text key="描述" entity="AppSetting" />
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

              <ws:iterator value="appSettings" status="appSetting">
			    <tr class="<ws:if test="#appSetting.odd==false">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="appSetting" value="id"/>" type="checkbox">
         		  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="appSetting" value="appGroup" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="appSetting" value="appName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="appSetting" value="appValue" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="appSetting" value="description" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
				    <ws:if test="lookup==null">
					<ws:if test="!#published">
				    <authz:authorize ifAnyGranted="APPSETTING_DEL">
				      <a href="<hi:url>appSettingRemove.action?appSetting.id=<ws:property id="appSetting" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/del.gif" alt="<hi:text key="删除" parameterLanguageKeys="应用配置" />" border="0"/></a>
				    </authz:authorize>
					</ws:if>
				    <authz:authorize ifAnyGranted="APPSETTING_VIEW">				      
				      &nbsp;
				      <a href="<hi:url>appSettingView.action?appSetting.id=<ws:property id="appSetting" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/view.gif" alt="<hi:text key="查看" parameterLanguageKeys="应用配置" />" border="0"/></a>
				    </authz:authorize>
					<ws:if test="!#published">
				    <authz:authorize ifAnyGranted="APPSETTING_SAVE">				    
				      &nbsp;
				      <a href="<hi:url>appSettingEdit.action?appSetting.id=<ws:property id="appSetting" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/modify.gif" alt="<hi:text key="编辑" parameterLanguageKeys="应用配置" />" border="0"/></a>
				    </authz:authorize>				      
				    </ws:if>
					</ws:if>
				    <ws:else>
				      <span style="cursor: pointer" onclick="lookupAppSetting('<ws:property id="appSetting" value="id"/>','<ws:property id="appSetting" value="appGroup"/>','<ws:property id="appSetting" value="appName"/>','<ws:property id="appSetting" value="appValue"/>')"><img src="images/icon_Select.gif" border="0"></span>								
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
					<ws:if test="!#published">
				   <authz:authorize ifAnyGranted="APPSETTING_DEL">	           	 
	           	    <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"  /></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"  /></font><ws:if test="lookup==null"> - <font id="delete" style="cursor:hand" onclick="javascript:deleteChecked('appSetting')"><hi:text key="批量删除" /></font></ws:if>
				   </authz:authorize>
					</ws:if>
	           	 </td>
	        	 <td align="right">
	        	  <ws:if test="lookup==null">	        	 
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="appSettingList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
	        	  </ws:if>
				  <ws:else>
<hi:page pageBeanName="pageInfo" currentPage="1" url="appSettingLookup.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />				  
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