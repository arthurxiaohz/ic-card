<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="menu/Menu.js"></script>
</head>
<body>
<form name="formSearch" method="post" action="menuList.action">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <input type="hidden" name="pageInfo.sorterName" id="pageInfo.sorterName" value="<ws:property value="pageInfo.sorterName" default=""/>" />
      <input type="hidden" name="pageInfo.sorterDirection" id="pageInfo.sorterDirection" value="<ws:property value="pageInfo.sorterDirection" default="ASC"/>" />
      <!-- action -->						
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="120" class="SearchTableTop"><hi:text key="查询条件"/></td>
          <td >&nbsp;</td>
          <td width="64"><authz:authorize ifAnyGranted="MENU_SAVE"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建" />" class="button1" onclick="menu_addNew('<hi:url>menuEdit.action?menu.id=-1</hi:url>')"/></ws:if><ws:else><input type="button" value="<hi:text key="重置" />" class="button1" onclick="lookupMenu('-1','','','','')"/></ws:else></authz:authorize></td>
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
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="菜单名称" entity="Menu" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_menuName"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="父菜单项" entity="Menu" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.parentMenu.f_menuName"    cssClass="SearchTableDataText" needSelect="false"/>
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
	            <td class="ListTableHeaderText"><hi:text key="列表" parameterLanguageKeys="菜单项"/></td>
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
				  <a href="javascript:sortBy('menuName')" id="title_menuName"><hi:text key="菜单名称" entity="Menu" />
				  <ws:if test="pageInfo.sorterName.equals('menuName')">
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
				  <a href="javascript:sortBy('description')" id="title_description"><hi:text key="描述" entity="Menu" />
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
				  <a href="javascript:sortBy('parentMenu.menuName')" id="title_parentMenu.menuName"><hi:text key="父菜单项" entity="Menu" />
				  <ws:if test="pageInfo.sorterName.equals('parentMenu.menuName')">
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
				  <a href="javascript:sortBy('sequence')" id="title_sequence"><hi:text key="序列" entity="Menu" />
				  <ws:if test="pageInfo.sorterName.equals('sequence')">
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

              <ws:iterator value="menus" status="menu">
			    <tr class="<ws:if test="#menu.odd==false">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="menu" value="id"/>" type="checkbox">
         		  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="menu" value="menuName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="menu" value="description" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="menu" value="parentMenu.menuName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="menu" value="sequence" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
				    <ws:if test="lookup==null">
				    <authz:authorize ifAnyGranted="MENU_DEL">
				      <a href="<hi:url>menuRemove.action?menu.id=<ws:property id="menu" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/del.gif" alt="<hi:text key="删除" parameterLanguageKeys="菜单项" />" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="MENU_VIEW">				      
				      &nbsp;
				      <a href="<hi:url>menuView.action?menu.id=<ws:property id="menu" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/view.gif" alt="<hi:text key="查看" parameterLanguageKeys="菜单项" />" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="MENU_SAVE">				    
				      &nbsp;
				      <a href="<hi:url>menuEdit.action?menu.id=<ws:property id="menu" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/modify.gif" alt="<hi:text key="编辑" parameterLanguageKeys="菜单项" />" border="0"/></a>
				    </authz:authorize>				      
				    </ws:if>
				    <ws:else>
				      <span style="cursor: pointer" onclick="lookupMenu('<ws:property id="menu" value="id"/>','<ws:property id="menu" value="menuName"/>','<ws:property id="menu" value="description"/>','<ws:property id="menu" value="parentMenuName"/>','<ws:property id="menu" value="sequence"/>')"><img src="images/icon_Select.gif" border="0"></span>								
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
				   <authz:authorize ifAnyGranted="MENU_DEL">	           	 
	           	    <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"  /></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"  /></font><ws:if test="lookup==null"> - <font id="delete" style="cursor:hand" onclick="javascript:deleteChecked('menu')"><hi:text key="批量删除" /></font></ws:if>
				   </authz:authorize>
	           	 </td>
	        	 <td align="right">
	        	  <ws:if test="lookup==null">	        	 
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="menuList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
	        	  </ws:if>
				  <ws:else>
					<hi:page pageBeanName="pageInfo" currentPage="1" url="menuLookup.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />				  
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