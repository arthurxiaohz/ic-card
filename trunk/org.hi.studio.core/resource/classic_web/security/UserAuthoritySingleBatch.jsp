<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
		<script type="text/javascript" src="js/framework/hi_Include.js"></script>
		<script type="text/javascript" src="security/UserAuthority.js"></script>
		<script type="text/javascript" src="security/Authority.js"></script>
		
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
		
		var userid = <ws:property value="user.id"/>;
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
	<div name="menuDiv" id="menuDiv" style="width:100%; overflow:scroll;">
	  <ws:iterator value="menus" id="menu" >
	  	<a href="javascript:showAuthority('<ws:property id="menu" value="id"/>')"><ws:property id="menu" value="description"/></a>
	  </ws:iterator>
	</div>
	
		<form name="batchAuthority" action="singleBatchAuthoritySave.action" method="post" >
		<table class="EditTable" cellpadding="2" cellspacing="1" width="100%">
			<tr>
					<td class="EditTableTDLabel"><hi:text key="用户" entity="UserAuthority" />:</td>
					<td class="EditTableTDData" >
						<input type="hidden" id="user.id" name="user.id" value="<ws:property value="user.id"/>" onpropertychange="javascript:userChange(this)">
						<input type="text"  id="user.fullName" name="user.fullName" value="<ws:property value="user.fullName"/>">
						<input type="hidden"  id="user.org.id" name="user.org.id" value="<ws:property value="user.org.id"/>">
						<input type="hidden"  id="user.creator.id" name="user.creator.id" value="<ws:property value="user.creator.id"/>">
						<input type="hidden" id="user.userMgrType" name="user.userMgrType" value="<ws:property value="user.userMgrType"/>">						
					     <span onclick="userAuthority_lookupPOP('user')"><hi:text key="查找带回" /></span>
					</td>
			</tr>
		</table>				
		<table class="EditDetailTable" cellpadding="2" cellspacing="1" width="100%" >
				<thead>
					<tr class="ListTableHeader" >
						<td><hi:text key="权限" entity="UserAuthority" /></td>
						<td><hi:text key="部门" entity="UserAuthority" /></td>
						<td><hi:text key="范围" entity="UserAuthority" /></td>
						<td><hi:text key="操作" /></td>
					</tr>  
				</thead>
				<tbody>
				<ws:iterator value="userAuthorities" id="userauthority" status="userAuthorityIndex" >
				  <tr  name="mt_<ws:property id="userauthority" value="authority.menuLink.menu.id"/>" id="mt_<ws:property id="userauthority" value="authority.menuLink.menu.id"/>" style="display:none" class="<ws:if test="#userAuthorityIndex.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
					<td>
						<ws:property id="userauthority" value="authority.description"/>
					</td>
					<td>
<ws:set name="orgid" value="#userauthority.org.id"/>
						<div id="orgdiv<ws:property value="#userAuthorityIndex.count-1"/>" name="orgdiv<ws:property value="#userAuthorityIndex.count-1"/>" style="display:<ws:if test="#orgid != null">block</ws:if><ws:else>none</ws:else>">
<ws:if test="showMode.equals('dropdown')">
						<select name="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].org.id" id="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].org.id">
						  	<option value=""></option>
						  <ws:iterator value="orgs" id="org">
						    <option value="<ws:property id="org" value="id"/>" <ws:if test="#org.id == #orgid">selected="selected"</ws:if> ><ws:property id="org" value="orgName"/></option>
						  </ws:iterator>
						</select>
</ws:if><ws:else>						
						<input type="hidden" id="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].org.id" name="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].org.id" value="<ws:property id="userAuthority" value="org.id"/>">
						<input type="text" id="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].orgName" name="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].orgName" value="<ws:property id="userAuthority" value="org.orgName"/>">
						     <span onclick="userAuthority_lookupPOP('org',<ws:property value="#userAuthorityIndex.count-1"/>)"><hi:text key="查找带回" /></span>
</ws:else>						     
						</div>
					</td>
					<td>
<ws:if test="authority.authorityType == 1">					
						<hi:select emu="securityScope" name="userAuthorities[${userAuthorityIndex.count-1}].scope" onchange="javascript:scopeChang(this)" defaultValue="2904" />
</ws:if>						
					</td>
					<td>
						<input id="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].authority.id" name="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].authority.id" value="<ws:property id="userauthority" value="authority.id"/>"  type="hidden"/>
						<input id="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].id" name="userAuthorities[<ws:property value="#userAuthorityIndex.count-1"/>].id" value="<ws:property id="userauthority" value="id"/>"  type="hidden"/>
						<input id="userAuthorityIndex" name="userAuthorityIndex" value="${userAuthorityIndex.count-1}" <ws:if test="securityUser != null">checked="checked"</ws:if> type="checkbox">
					</td>
				  </tr>
				</ws:iterator>
				</tbody>
				
			</table>

  		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="submit" id="save" value="<hi:text key="保存"    />" class="Button2" /></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='userAuthorityList.action'"  ></td>
		  </tr>
		</table>  
   	
		</form>
	</body>
</html>