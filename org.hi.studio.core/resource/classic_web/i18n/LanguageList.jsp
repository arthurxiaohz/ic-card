<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ include file="/includes/main.jsp"%>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="i18n/Language.js"></script>
</head>
<body>
<form name="formSearch" method="post" action="languageList.action">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>  
    <td valign="top">   
      <input type="hidden" name="pageInfo.sorterName" id="pageInfo.sorterName" value="<ws:property value="pageInfo.sorterName" default=""/>" />
      <input type="hidden" name="pageInfo.sorterDirection" id="pageInfo.sorterDirection" value="<ws:property value="pageInfo.sorterDirection" default="ASC"/>" />
      <!-- action -->						
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="120" class="SearchTableTop"><hi:text key="查询条件"/> </td>	
          <td >&nbsp;</td>
          <td width="64"><ws:if test="lookup==null"><input type="button" value="<hi:text key="新建"/>" class="button1" onclick="language_addNew('<hi:url>languageEdit.action?language.id=-1</hi:url>')"/></ws:if><ws:else><input type="button" value="<hi:text key="重置"/>" class="button" onclick="lookupLanguage('-1','','','')"/></ws:else></td>
          <td width="15">&nbsp;</td>
          <td width="64"><input type="button" value="<hi:text key="查询"/>" class="button1" onclick="javascript:formSearchSubmit()"/></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td valign="top" class="SearchForm">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="SearchTable">
        <tr>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="Key值" entity="Language"/>:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_keyStr"    cssClass="SearchTableDataText" needSelect="false"/>
	  	  </td>
	  	  <td width="15%" class="SearchTableLabel"><hi:text key="实体" entity="Language"/>:&nbsp;</td>
	  	  <td width="35%" class="SearchTableData">
	  	    <hi:search name="pageInfo.f_entity"    cssClass="SearchTableDataText" needSelect="false"/>
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
	            <td class="ListTableHeaderText"><hi:text key="列表" parameterLanguageKeys="多语言信息"/></td>
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
				  <a href="javascript:sortBy('keyStr')" id="title_keyStr"><hi:text key="Key值" entity="Language"/>
				  <ws:if test="pageInfo.sorterName.equals('keyStr')">
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
				  <a href="javascript:sortBy('entity')" id="title_entity"><hi:text key="实体" entity="Language"/>
				  <ws:if test="pageInfo.sorterName.equals('entity')">
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
				 <hi:text key="操作"/>   
				  </ws:if>
				  <ws:else>
				   <hi:text key="查找带回"/>
				  </ws:else>
				</td>
              </tr>

              <ws:iterator value="languages" status="language">
			    <tr class="<ws:if test="#language.odd==false">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
        		  <td class="ListTableBodyData">
          		    <input name="orderId" value="<ws:property id="language" value="id"/>" type="checkbox">
         		  </td>
				  <td class="ListTableBodyData"> 
				    <ws:property id="language" value="keyStr" />
				    &nbsp;
				  </td>
				 
				  <td class="ListTableBodyData"> 
				    <ws:property id="language" value="entity" />
				    &nbsp;
				  </td>
				  <td class="ListTableBodyData">
				    
				     	<ws:if id="language" test="isSystem!=1">
				            <a href="<hi:url>languageRemove.action?language.id=<ws:property id="language" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/del.gif" alt="<hi:text key="删除"  parameterLanguageKeys="多语言信息" />" border="0"/></a>
				     	</ws:if>
				      &nbsp;
				      <a href="<hi:url>languageView.action?language.id=<ws:property id="language" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/view.gif" alt="<hi:text key="查看"  parameterLanguageKeys="多语言信息" />" border="0"/></a>
				      &nbsp;
				      <a href="<hi:url>languageEdit.action?language.id=<ws:property id="language" value="id"/>&pageInfo.crruntPage=1</hi:url>" style="cursor: pointer"><img src="images/modify.gif" alt="<hi:text key="编辑"  parameterLanguageKeys="多语言信息" />" border="0"/></a>
				   
				  
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
	           	    <font style="cursor:hand" onclick="javascript:selectAll('true')"><hi:text key="全选"/></font>/<font style="cursor:hand" onclick="javascript:selectCancel()"><hi:text key="取消全选"/></font><ws:if test="lookup==null"></ws:if>
	           	 </td>
	        	 <td align="right">
	        	  <ws:if test="lookup==null">	        	 
	        	   <hi:page pageBeanName="pageInfo" currentPage="1" url="languageList.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />
	        	  </ws:if>
				  <ws:else>
<hi:page pageBeanName="pageInfo" currentPage="1" url="languageLookup.action" currentPageClass="PageLabe" textClass="PageText" buttonClass="PageButton" />				  
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