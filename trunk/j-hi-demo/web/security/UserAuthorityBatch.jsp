<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<script type="text/javascript" src="security/UserAuthority.js"></script>
		
		<script type="text/javascript">
			function batchAuthory(){
				var users = window.frames['uesrFrame'].document.formSearch.orderId;
				var userids = "";
					if (users.length==undefined ){
						if( users.checked == true)
							userids = users.value;
					}
					else{
						for (var i = 0; i < users.length; i++) {
							if (users[i].checked == true) {
								userids += "," + users[i].value;
								}
						}
					}
				if(userids == ""){
					alert("<hi:text key="请选择要授权的用户" entity="Role"/>");
					return;
				}
			
			document.batchAuthority.action="batchAuthoritySave.action?userIndexs="+userids;
			document.batchAuthority.submit();
				
			}
			
			
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
		</script>
	</head>

	<body>
	<iframe src="hiUserBatchList.action" id="uesrFrame" height="200" width="100%" ></iframe>
	<p>
	<div name="menuDiv" id="menuDiv" style="width:100%; overflow:scroll;">

	   <c:forEach var="menu"  items="${menus}" varStatus="menuIndex">
	  	<a href="javascript:showAuthority('${menu.id}')">${menu.description}</a>
	  </c:forEach>
	</div>
	
		<form name="batchAuthority" action="batchAuthoritySave.action" method="post" >
		<table class="EditDetailTable" cellpadding="2" cellspacing="1" width="100%" >
				<thead>
					<tr class="ListTableHeader" >
						<td><hi:text key="权限" entity="UserAuthority" /></td>
						<td><hi:text key="部门" entity="UserAuthority" /></td>
						<td><hi:text key="范围" entity="UserAuthority" /></td>
						<td> <hi:text key="操作" /> </td>
					</tr>  
				</thead>
				<tbody>
				<ws:iterator value="authorities" id="authority" status="authorityIndex" >
				  <tr name="mt_<ws:property id="authority" value="menuLink.menu.id"/>" id="mt_<ws:property id="authority" value="menuLink.menu.id"/>" style="display:none" class="<ws:if test="#authorityIndex.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
					<td>
						<ws:property id="authority" value="description"/>
					</td>
					<td>
						<div id="orgdiv<ws:property value="#authorityIndex.count-1"/>" name="orgdiv<ws:property value="#authorityIndex.count-1"/>" style="display:none">
<ws:if test="showMode.equals('dropdown')">
						<select name="userAuthorities[<ws:property value="#authorityIndex.count-1"/>].org.id" id="userAuthorities[<ws:property value="#authorityIndex.count-1"/>].org.id">
						  	<option value=""></option>
						  <ws:iterator value="orgs" id="org">
						    <option value="<ws:property id="org" value="id"/>"><ws:property id="org" value="orgName"/></option>
						  </ws:iterator>
						</select>
</ws:if><ws:else>						
						<input type="hidden" id="userAuthorities[<ws:property value="#authorityIndex.count-1"/>].org.id" name="userAuthorities[<ws:property value="#authorityIndex.count-1"/>].org.id" value="<ws:property value="userAuthority.org.id"/>">
						<input type="text" id="userAuthorities[<ws:property value="#authorityIndex.count-1"/>].orgName" name="userAuthorities[<ws:property value="#authorityIndex.count-1"/>].orgName" value="<ws:property value="userAuthority.org.orgName"/>">
						     <span onclick="userAuthority_lookupPOP('org',<ws:property value="#authorityIndex.count-1"/>)"><hi:text key="查找带回" /></span>
</ws:else>						     
						</div>
					</td>
					<td>
<ws:if test="authorityType == 1">					
						<hi:select emu="securityScope" name="userAuthorities[${authorityIndex.count-1}].scope" onchange="javascript:scopeChang(this)" defaultValue="2904"/>
</ws:if>
					</td>
					<td>
						<input id="userAuthorities[<ws:property value="#authorityIndex.count-1"/>].authority.id" name="userAuthorities[<ws:property value="#authorityIndex.count-1"/>].authority.id" value=<ws:property id="authority" value="id"/>  type="checkbox"/>
					</td>
				  </tr>
				</ws:iterator>
				</tbody>
				
			</table>

  		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="button" id="save" value="<hi:text key="保存"    />" class="Button2" onclick="javascript:batchAuthory()" /></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='userAuthorityList.action'"  ></td>
		  </tr>
		</table>  	
		</form>
	</body>
</html>