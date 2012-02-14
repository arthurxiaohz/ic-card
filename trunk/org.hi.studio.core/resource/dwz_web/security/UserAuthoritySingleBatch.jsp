<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

		<script type="text/javascript" src="security/UserAuthority.js"></script>
		
		<script type="text/javascript">

		function scopeChang(obj){
			var orgdiv = $(obj).parents("td:first").prev().find("div");
			//如果是部门或部门及子部门级
			if(obj.value =='2902' || obj.value =='2903'){
				orgdiv.show();
			} else{
				orgdiv.find("select").val("");			
				orgdiv.hide();
			}
				
		}

		
		 function processResult(result){
		    	if (result.statusCode == DWZ.statusCode.ok)
	           		alert("<hi:text key="保存成功!" />");
		    	else
		    		alert("<hi:text key="保存失败!" />");

		    } 	
		    
		 
		var menuids = [ <c:forEach var="menu" items="${menus}" varStatus="menuIndex" > ${menu.id} <c:if test="${!menuIndex.last}">,</c:if></c:forEach>];
		function showAuthority(menuid){
			 
			for(var i = 0; i<menuids.length; i++){
				$(".mt_"+menuids[i]).hide();
			}

			$(".mt_"+menuid).show();
		
		}
		
		var userid = ${user.id};
		var isSubmit = false;
		 
		   
		function userChange(userBackID,userName,userType){
			document.getElementById("user.id").value=userBackID
			document.getElementById("user.fullName").value=userName;
			document.getElementById("user.userMgrType").value=userType;
			
			 $.ajax({
	    			type: 'POST',
	    			url:'getDwzUserPrivileges.action',
	    			data:{"user.id":userBackID,"user.fullName":userName},
	    			dataType:"json",
	    			cache: false,
	    			success: setUserInfo,
	    			error: DWZ.ajaxError
	    		});
			
	    		
			
			}
			
		function setUserInfo(json)
		{
			 
			$("input[name='userAuthorityIndex']").each(function (n){
				 $(this).attr("checked", false);
				});
			$("input[extName='orgID']").each(function (n){
				 $(this).val('');
				});
			$("select[id^='scope']").each(function (n){
				 $(this).val('2904');
				 $(this).trigger("onchange");
				});
			 
			$("input[extName='orgName']").each(function (n){
				 $(this).val('');
				});
			$("input[extName='selectOrg']").each(function (n){
				 $(this).val('');
				});
			$("input[extName='userAuthorityID']").each(function (n){
				 $(this).val('');
				});

			document.getElementById("user.org.id").value = json.user.org.id;
			document.getElementById("user.creator.id").value = json.user.creator.id;
			 for (var i=0;i<json.userPrivileges.length;i++)
			 {

				 var orgID = document.getElementById("orgID"+json.userPrivileges[i].authority.id)
				 if (orgID != null )
				 	orgID.value=json.userPrivileges[i].org.id;
				 var orgName = document.getElementById("orgName"+json.userPrivileges[i].authority.id)
				 if (orgName != null )
					 orgName.value=json.userPrivileges[i].org.orgName;
		 
				 var scope = document.getElementById("scope"+json.userPrivileges[i].authority.id)
			    if (scope != null )
			    {
			    	scope.value=json.userPrivileges[i].scope;
				   $(scope).trigger("onchange");
			    }
			    if ( document.getElementById("selectOrg"+json.userPrivileges[i].authority.id)  != null )
			     document.getElementById("selectOrg"+json.userPrivileges[i].authority.id).value=json.userPrivileges[i].org.id;
			     
			     document.getElementById("userAuthorityID"+json.userPrivileges[i].authority.id).value=json.userPrivileges[i].id;
		         document.getElementById("userAuthorityIndex"+json.userPrivileges[i].authority.id).checked=true;
		      }
			 
		}
		</script>
  
<h2 class="contentTitle"><hi:text key="用户授权" parameterLanguageKeys="用户权限"/></h2>
<form name="batchAuthority" id="batchAuthority" action="singleBatchAuthoritySave.action?ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, processResult)" >
 
 <input type="hidden" id="user.id" name="user.id" value="${user.id}"   />
 <input type="hidden" id="user.org.id" name="user.org.id" value="${user.org.id}"/>
 <input type="hidden" id="user.creator.id" name="user.creator.id" value="${user.creator.id}"/>
 <input type="hidden" id="user.userMgrType" name="user.userMgrType" value="${user.userMgrType}"  />	
 
  <div class="pageContent">
    <table width="20%" border="0" cellpadding="1"  align="left" >
								<tr>
									<td nowrap="nowrap" valign="top" width="30%">
									<menu:useMenuDisplayer name="Velocity" config="templates/dwztree.html" bundle="">
									<hi:displayMenu name="com.hi.tree.menu" menuName="userPrivilegeList" type="common" cssStyle="width:100%; height:100%; border: 0;"/>
									</menu:useMenuDisplayer>
									</td>
									
									 				
							</tr>
								
				</table>
				
  	<div class="pageFormContent" layoutH="97">
		<dl>
				<dt><hi:text key="用户" entity="UserAuthority" />:</dt>
				<dd class="contentTitle" >
				<input type="text" id="user.fullName" name="user.fullName"  readonly="true" style="background-color: #F9FCFD; border: 0; " value="${user.fullName}"   />
				</dd>
		</dl>
		<div class="divider"></div>
		
		   <div style="height: 25">
			  <c:forEach var="menu" items="${menus}" varStatus="menuIndex" >&nbsp;
		  	<a href="javascript:showAuthority('${menu.id}')">${menu.description}</a>
		  </c:forEach >
		  </div>
		 
	  
				
			<div style="overflow: auto">
				<table class="list nowrap" width="98%">
					<thead>
						<tr class="ListTableHeader" >  
							<th><hi:text key="权限" entity="RoleAuthority"/></th>
							<th><hi:text key="部门" entity="RoleAuthority"/></th>						
							<th><hi:text key="范围" entity="RoleAuthority"/></th>
							<th width="60"><hi:text key="操作"/></th>
						</tr>  
					</thead>
					
					<tbody>
					<c:forEach var="userAuthority" items="${userAuthorities}"  varStatus="userAuthorityIndex">
  						<tr name="mt_${userAuthority.authority.menuLink.menu.id}" class="mt_${userAuthority.authority.menuLink.menu.id}" id="mt_${userAuthority.authority.menuLink.menu.id}" style="display:none">
							<td>
								${userAuthority.authority.description}
							</td>
							<td>
							    <c:set  var="orgid" value="${userAuthority.org.id}" />
					 
								<div id="orgdiv${userAuthorityIndex.count-1}" name="orgdiv${userAuthorityIndex.count-1}"  style="display:<c:choose><c:when test="${orgid!=null}">block</c:when> <c:otherwise> none</c:otherwise></c:choose>">
								<c:choose>
									<c:when test="${showMode=='dropdown'}">  
										<select extName="selectOrg"  id="selectOrg${userAuthority.authority.id}" name="userAuthorities[${userAuthorityIndex.count-1}].org.id" >
									  	<option value=""></option>
									  	<c:forEach var="org"  items="${orgs}" > 
										    <option value="${org.id}" <c:if test="${org.id eq orgid}" > selected="selected" </c:if> >${org.orgName}</option>
										</c:forEach>
										</select>
									</c:when> 
									<c:otherwise>  
										<input extName="orgID" type="hidden" id="orgID${userAuthority.authority.id}" name="userAuthorities[${userAuthorityIndex.count-1}].org.id" value="${userAuthority.org.id}">
										<input extName="orgName"  type="text" id="orgName${userAuthority.authority.id}" name="userAuthorities[${userAuthorityIndex.count-1}].hi_org.orgName" value="${userAuthority.org.orgName}"
										autocomplete="off" lookupGroup="userAuthorities" lookupName="org" index="${userAuthorityIndex.index}" suggestClass="org.hi.base.organization.model.HiOrg" searchFields="orgName"/>
									<a class="btnLook" href="tree.action?menuName=userOrgEditByOrg" lookupGroup="userAuthorities" lookupName="org" index="${userAuthorityIndex.index}}" title="<hi:text key="查找带回"/>"><hi:text key="查找带回"/></a>

									</c:otherwise>        
								</c:choose>
								</div>
							</td>					
							<td>
								<c:if test="${userAuthority.authority.authorityType==1}">					
									<hi:select cssClass="scope"  emu="securityScope" id="scope${userAuthority.authority.id}" name="userAuthorities[${userAuthorityIndex.count-1}].scope" onchange="javascript:scopeChang(this)" defaultValue="2904" />
								</c:if>						
							</td>
							<td>
							    <input type="hidden" name="userAuthorities[${userAuthorityIndex.index}].authority.id" value="${userAuthority.authority.id}" />
								<input id="userAuthorityID${userAuthority.authority.id}" type="hidden" extName="userAuthorityID" name="userAuthorities[${userAuthorityIndex.index}].id" value="${userAuthority.id}" />
								<input id="userAuthorityIndex${userAuthority.authority.id}" name="userAuthorityIndex" value="${userAuthorityIndex.count-1}" <c:if test="${userAuthority.securityUser != null}">checked="checked"</c:if>  type="checkbox">
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

			</div>
	
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
		
	</div>
	</form>
 
