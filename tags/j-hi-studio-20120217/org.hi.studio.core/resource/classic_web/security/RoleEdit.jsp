<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="security/Role.js"></script>

<script type="text/javascript">
			
		function scopeChang(obj){
			var orgdiv = obj.parentNode.previousSibling.firstChild;
			//如果是部门或部门及子部门级
			if(obj.value =='2902' || obj.value =='2903'){
				orgdiv.style.display = 'block';
			}
			else{
				orgdiv.firstChild.value = "";
<ws:if test="showMode.equals('lookup')">				
				orgdiv.firstChild.nextSibling.nextSibling.value="";
</ws:if>				
				orgdiv.style.display = "none";
			}
				
		}
		
		var menuids = [<ws:iterator value="menus" id="menu" status="menuIndex"><ws:property id="menu" value="id"/><ws:if test="!#menuIndex.last">,</ws:if></ws:iterator>];
		function showAuthority(menuid){
			//debugger;
			
			for(var i = 0; i<menuids.length; i++){
				var alltrs = document.getElementsByName("mt_"+menuids[i]);
				for(var j = 0; j<alltrs.length; j++)
					alltrs[j].style.display = "none";
			}
	
			var trs = document.getElementsByName("mt_"+menuid);
			for(var i = 0; i<trs.length; i++)
				trs[i].style.display = 'block';
		
		}
		
		var isSubmit = false;
		function userChange(obj){
		if(obj.value != userid && !isSubmit){
			document.batchAuthority.action="singleBatchAuthority.action";
			document.batchAuthority.submit();
			//alert(obj.value);
			isSubmit = true;
			}
		}
</script>
  
</head>
<body>
  <form action="roleSave.action" method="post" onsubmit="return checkValue('role.roleName')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="角色"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="role.roleNameLabel"><hi:text key="角色名称" entity="Role" />:</td>
				  <td width="35%">
					<input type="text" class="EditTableDataText" id="role.roleName" name="role.roleName" value="<ws:property value="role.roleName"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="role.displayRefLabel"><hi:text key="显示信息" entity="Role" />:</td>
				  <td width="35%">
					<input type="text" class="EditTableDataText" id="role.displayRef" name="role.displayRef" value="<ws:property value="role.displayRef"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="role.descriptionLabel"><hi:text key="描述" entity="Role" />:</td>
				  <td width="85%" colspan="3">
					<input type="text" size="78" class="EditTableDataText" id="role.description" name="role.description" value="<ws:property value="role.description"/>">
				  </td>
				</tr>
				<input type="hidden" id="role.id" name="role.id" value="<ws:property value="role.id"/>">
			  </table>
			</td>
		  </tr>
		</table>  
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTable">
			<div name="menuDiv" id="menuDiv" style="width:100%; overflow:scroll;">
			  <ws:iterator value="menus" id="menu" >
			  	<a href="javascript:showAuthority('<ws:property id="menu" value="id"/>')"><ws:property id="menu" value="description"/></a>
			  </ws:iterator>
			</div>		
		</table>

		<table class="EditDetailTable" cellpadding="2" cellspacing="1" width="100%" >
				<thead>
					<tr class="ListTableHeader" >
						<td>权限</td>
						<td>部门</td>						
						<td>范围</td>
						<td>事项</td>
					</tr>  
				</thead>
				<tbody>
				<ws:iterator value="roleAuthorities" id="roleAuthority" status="roleAuthorityIndex" >
				  <tr  name="mt_<ws:property id="roleAuthority" value="authority.menuLink.menu.id"/>" id="mt_<ws:property id="roleAuthority" value="authority.menuLink.menu.id"/>" class="<ws:if test="#roleAuthorityIndex.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>" style="display:none" >
					<td>
						<ws:property id="roleAuthority" value="authority.description"/>
					</td>
					<td>
<ws:set name="orgid" value="#roleAuthority.org.id"/>
						<div id="orgdiv<ws:property value="#roleAuthorityIndex.count-1"/>" name="orgdiv<ws:property value="#roleAuthorityIndex.count-1"/>" style="display:<ws:if test="#orgid != null">block</ws:if><ws:else>none</ws:else>">
<ws:if test="showMode.equals('dropdown')">
						<select name="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].org.id" id="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].org.id">
						  	<option value=""></option>
						  <ws:iterator value="orgs" id="org">
						    <option value="<ws:property id="org" value="id"/>" <ws:if test="#org.id == #orgid">selected="selected"</ws:if> ><ws:property id="org" value="orgName"/></option>
						  </ws:iterator>
						</select>
</ws:if><ws:else>						
						<input type="hidden" id="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].org.id" name="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].org.id" value="<ws:property id="userAuthority" value="org.id"/>">
						<input type="text" id="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].orgName" name="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].orgName" value="<ws:property id="userAuthority" value="org.orgName"/>">
						     <span onclick="userAuthority_lookupPOP('org',<ws:property value="#roleAuthorityIndex.count-1"/>)"><hi:text key="查找带回" /></span>
</ws:else>						     
						</div>
					</td>					
					<td>
<ws:if test="authority.authorityType == 1">					
						<hi:select emu="securityScope" name="roleAuthorities[${roleAuthorityIndex.count-1}].scope" onchange="javascript:scopeChang(this)" defaultValue="2904" />
</ws:if>						
					</td>
					<td>
						<input id="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].authority.id" name="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].authority.id" value="<ws:property id="roleAuthority" value="authority.id"/>"  type="hidden"/>
						<input id="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].id" name="roleAuthorities[<ws:property value="#roleAuthorityIndex.count-1"/>].id" value="<ws:property id="roleAuthority" value="id"/>"  type="hidden"/>
						<input id="roleAuthorityIndex" name="roleAuthorityIndex" value="${roleAuthorityIndex.count-1}" <ws:if test="role != null">checked="checked"</ws:if> type="checkbox">
					</td>
				  </tr>
				</ws:iterator>
				</tbody>
				
			</table>						
	    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="submit" type="image" id="submit" class="EditTableSubmitImage" src="images/save.gif" border="0" tppabs="images/save.gif"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='roleList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>