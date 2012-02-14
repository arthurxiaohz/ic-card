<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="security/PrivilegeResource.js"></script>
</head>
<body>
<form name="formSearch" method="post" action="privilegeResourceList.action">
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
          <td width="64"><authz:authorize ifAnyGranted="PRIVILEGERESOURCE_SAVE"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建" />" class="button1" onclick="privilegeResource_addNew()"/></ws:if><ws:else><input type="button" value="<hi:text key="重置" />" class="button" onclick="lookupPrivilegeResource('-1','','','')"/></ws:else></authz:authorize></td>
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
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="权限名称" entity="PrivilegeResource" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_authorityName"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="业务层" entity="PrivilegeResource" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_businessLayer"    cssClass="SearchTableDataText" needSelect="false"/>
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
	            <td class="ListTableHeaderText"><hi:text key="列表" parameterLanguageKeys="权限资源"/></td>
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
				  <a href="javascript:sortBy('authorityName')" id="title_authorityName"><hi:text key="权限名称" entity="PrivilegeResource" />
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
				  <a href="javascript:sortBy('viewLayer')" id="title_viewLayer"><hi:text key="表现层" entity="PrivilegeResource" />
				  <ws:if test="pageInfo.sorterName.equals('viewLayer')">
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
				  <a href="javascript:sortBy('businessLayer')" id="title_businessLayer"><hi:text key="业务层" entity="PrivilegeResource" />
				  <ws:if test="pageInfo.sorterName.equals('businessLayer')">
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

              <ws:iterator value="privilegeResources" status="privilegeResource">
			    <tr class="<ws:if test="#privilegeResource.odd==false">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="privilegeResource" value="id"/>" type="checkbox">
         		  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="privilegeResource" value="authorityName" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="privilegeResource" value="viewLayer" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="privilegeResource" value="businessLayer" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
				    <ws:if test="lookup==null">
				    <authz:authorize ifAnyGranted="PRIVILEGERESOURCE_DEL">
				      <a href="privilegeResourceRemove.action?privilegeResource.id=<ws:property id="privilegeResource" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/del.gif" alt="<hi:text key="删除" parameterLanguageKeys="权限资源" />" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="PRIVILEGERESOURCE_VIEW">				      
				      &nbsp;
				      <a href="privilegeResourceView.action?privilegeResource.id=<ws:property id="privilegeResource" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/view.gif" alt="<hi:text key="查看" parameterLanguageKeys="权限资源" />" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="PRIVILEGERESOURCE_SAVE">				    
				      &nbsp;
				      <a href="privilegeResourceEdit.action?privilegeResource.id=<ws:property id="privilegeResource" value="id"/>&pageInfo.crruntPage=1" style="cursor: pointer"><img src="images/modify.gif" alt="<hi:text key="编辑" parameterLanguageKeys="权限资源" />" border="0"/></a>
				    </authz:authorize>				      
				    </ws:if>
				    <ws:else>
				      <span style="cursor: pointer" onclick="lookupPrivilegeResource('<ws:property id="privilegeResource" value="id"/>','<ws:property id="privilegeResource" value="authorityName"/>','<ws:property id="privilegeResource" value="viewLayer"/>','<ws:property id="privilegeResource" value="businessLayer"/>')"><img src="images/icon_Select.gif" border="0"></span>								
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
				   <authz:authorize ifAnyGranted="PRIVILEGERESOURCE_DEL">	           	 
	           	    <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"  /></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"  /></font><ws:if test="lookup==null"> - <font id="delete" style="cursor:hand" onclick="javascript:deleteChecked('privilegeResource')"><hi:text key="批量删除" /></font></ws:if>
				   </authz:authorize>
	           	 </td>
	        	 <td align="right">
	        	  <ws:if test="lookup==null">	        	 
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="privilegeResourceList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
	        	  </ws:if>
				  <ws:else>
<hi:page pageBeanName="pageInfo" currentPage="1" url="privilegeResourceLookup.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />				  
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