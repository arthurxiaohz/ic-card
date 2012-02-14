<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="organization/HiUser.js"></script>
</head>


<body>
<form name="formSearch" method="post" action="hiUserList.action">
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
          <td width="64"><authz:authorize ifAnyGranted="HIUSER_SAVE"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建" />" class="button1" onclick="hiUser_addNew('<hi:url>hiUserEdit.action?hiUser.id=-1</hi:url>')"/></ws:if><ws:else><input type="button" value="<hi:text key="重置" />" class="button" onclick="lookupHiUser('-1','','','','')"/></ws:else></authz:authorize></td>
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
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="姓名" entity="HiUser" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_fullName"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="部门" entity="HiUser" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.org.f_orgName"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	</tr>
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="性别" entity="HiUser" />:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_gender" emu="gender"   cssClass="SearchTableDataText" needSelect="false"/>
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
				  <ws:if test="lookup==null">
				    <hi:text key="操作" />   
				  </ws:if>
				  <ws:else>
				    <hi:text key="查找带回" />
				  </ws:else>
				</td>
              </tr>

              <ws:iterator value="hiUsers" status="hiUser">
			    <tr class="<ws:if test="#hiUser.odd==false">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
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
				    <authz:authorize ifAnyGranted="HIORG_VIEW"><a href="<hi:url>hiOrgView.action?hiOrg.id=<ws:property id="hiUser" value="org.id"/>&workflow=-1</hi:url>" target="_blank"></authz:authorize>
					<ws:property id="hiUser" value="org.orgName" /><authz:authorize ifAnyGranted="HIORG_VIEW"></a></authz:authorize>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData"> 
				    <hi:select emu="gender" name="hiUsers[${hiUser.count-1 }].gender" isLabel="true"/>
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
				    <ws:if test="lookup==null">
				    <authz:authorize ifAnyGranted="HIUSER_DEL">
				      <a href="<hi:url>hiUserRemove.action?hiUser.id=<ws:property id="hiUser" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/del.gif" alt="<hi:text key="删除" parameterLanguageKeys="人员" />" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="HIUSER_VIEW">				      
				      &nbsp;
				      <a href="<hi:url>hiUserView.action?hiUser.id=<ws:property id="hiUser" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/view.gif" alt="<hi:text key="查看" parameterLanguageKeys="人员" />" border="0"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="HIUSER_SAVE">				    
				      &nbsp;
				      <a href="<hi:url>hiUserEdit.action?hiUser.id=<ws:property id="hiUser" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/modify.gif" alt="<hi:text key="编辑" parameterLanguageKeys="人员" />" border="0"/></a>
				    </authz:authorize>				      
				    </ws:if>
				    <ws:else>
				      <span style="cursor: pointer" onclick="lookupHiUser('<ws:property id="hiUser" value="id"/>','<ws:property id="hiUser" value="userName"/>','<ws:property id="hiUser" value="fullName"/>','<ws:property id="hiUser" value="orgName"/>','<ws:property id="hiUser" value="gender"/>')"><img src="images/icon_Select.gif" border="0"></span>								
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
				   <authz:authorize ifAnyGranted="HIUSER_DEL">	           	 
	           	    <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"  /></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"  /></font><ws:if test="lookup==null"> - <font id="delete" style="cursor:hand" onclick="javascript:deleteChecked('hiUser')"><hi:text key="批量删除" /></font></ws:if>
				   </authz:authorize>
	           	 </td>
	        	 <td align="right">
	        	  <ws:if test="lookup==null">	        	 
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="hiUserList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
	        	  </ws:if>
				  <ws:else>
<hi:page pageBeanName="pageInfo" currentPage="1" url="hiUserLookup.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />				  
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