<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="security/Authority.js"></script>
</head>
<body>
<form name="formSearch" method="post" action="authorityList.action">
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
          <td width="64"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建" />" class="button1" onclick="authority_addNew()"/></ws:if><ws:else><input type="button" value="<hi:text key="重置" />" class="button1" onclick="lookupAuthority('-1','','','','')"/></ws:else></td>
          <td width="15">&nbsp;</td>
          <td width="64"><input type="button" value="<hi:text key="查询" />" class="button1" onclick="document.formSearch.submit()"/></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td valign="top" class="SearchForm">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="SearchTable">
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="权限名称" entity="Authority" />:&nbsp;</td>
	  	  <td width="35%">
	  	    <hi:search name="pageInfo.f_authorityName"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="属性资源" entity="Authority" />:&nbsp;</td>
	  	  <td width="35%">
	  	    <hi:search name="pageInfo.f_propertedResource"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	</tr>
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="菜单项" entity="Authority" />:&nbsp;</td>
	  	  <td width="35%">
	  	    <hi:search name="pageInfo.menuLink.f_description"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="描述" entity="Authority" />:&nbsp;</td>
	  	  <td width="35%">
			<hi:search name="pageInfo.f_description"    cssClass="SearchTableDataText" needSelect="false"/>
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
	            <td class="ListTableHeaderText"><hi:text key="列表" parameterLanguageKeys="权限"/></td>
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
				  <a href="javascript:sortBy('authorityName')" id="title_authorityName"><hi:text key="权限名称" entity="Authority" />
				  <ws:if test="pageInfo.sorterName.equals('authorityName')">
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
				  <a href="javascript:sortBy('propertedResource')" id="title_propertedResource"><hi:text key="属性资源" entity="Authority" />
				  <ws:if test="pageInfo.sorterName.equals('propertedResource')">
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
				  <a href="javascript:sortBy('description')" id="title_description"><hi:text key="描述" entity="Authority" />
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
				  <a href="javascript:sortBy('menuLink.description')" id="title_menuLink.description"><hi:text key="菜单项" entity="Authority" />
				  <ws:if test="pageInfo.sorterName.equals('menuLink.description')">
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

              <ws:iterator value="authoritys" status="authority">
			    <tr class="<ws:if test="#authority.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="authority" value="id"/>" type="checkbox">
         		  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="authority" value="authorityName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="authority" value="propertedResource" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="authority" value="description" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="authority" value="menuLink.description" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
				    <ws:if test="lookup==null">
				      <a href="authorityView.action?authority.id=<ws:property id="authority" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/view.gif"  border="0"/></a>
				      &nbsp;
<ws:if test="!#published">				      
				      <a href="authorityRemove.action?authority.id=<ws:property id="authority" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/del.gif"  border="0"/></a>
				      &nbsp;
				      <a href="authorityEdit.action?authority.id=<ws:property id="authority" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/modify.gif"  border="0"/></a>
</ws:if>				      
				    </ws:if>
				    <ws:else>
				      <span style="cursor: pointer" onclick="lookupAuthority('<ws:property id="authority" value="id"/>','<ws:property id="authority" value="authorityName"/>','<ws:property id="authority" value="propertedResource"/>','<ws:property id="authority" value="description"/>','<ws:property id="authority" value="menuLinkName"/>')"><img src="images/icon_Select.gif" border="0"></span>								
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
	           	   <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"  /></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"  /></font><ws:if test="lookup==null"> - <font id="delete" style="cursor:hand" onclick="javascript:deleteChecked('authority')"><hi:text key="批量删除" /></font></ws:if>
	           	 </td>
	        	 <td align="right">
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="authorityList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
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