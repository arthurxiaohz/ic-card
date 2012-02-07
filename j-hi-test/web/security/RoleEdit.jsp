<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

    
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
	
	//var menuids = [<ws:iterator value="menus" id="menu" status="menuIndex"><ws:property id="menu" value="id"/><ws:if test="!#menuIndex.last">,</ws:if></ws:iterator>];
	var menuids = [ <c:forEach var="menu" items="${menus}" varStatus="menuIndex" > ${menu.id} <c:if test="${!menuIndex.last}">,</c:if>   </c:forEach>];
	function showAuthority(menuid){
		//debugger;
		//当前选择的菜单项  by ggs
		 nowmenuid = menuid;
		for(var i = 0; i<menuids.length; i++){
			$(".mt_"+menuids[i]).hide();
		}

		$(".mt_"+menuid).show();
	
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

	/**
	@author ggs
	@date 2011 0707
	新增权限全选功能
	*/
	//当前选择的菜单项 by ggs
	var nowmenuid =0;
	function roleCheckAll(flag){	
		var c = $(":checkbox");
		for(var i=0;i<c.length;i++){			
				if(c[i].name=="roleAuthorityIndex"){	
					var classname  = c[i].parentNode.parentNode.className;					
					if(classname=="mt_"+nowmenuid){
						if (flag == 1){
							c[i].checked = true;
						}else{
							c[i].checked = !c[i].checked;
						}
					}
				}			
		}		
	}
	
</script>
  
<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="角色"/></h2>
 
<form action="roleSave.action?navTabId=roleList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
	<input type="hidden" name="role.id" value="${role.id}"/>
	<input type="hidden" name="role.version" value="${role.version}"/>
	<input type="hidden" name="role.creator.id" value="${role.creator.id}"/>
	<div class="pageContent">
	  	<div class="pageFormContent" layoutH="97">
	        <dl>
				<dt><hi:text key="角色名称" entity="Role" />:</dt> <dd><input type="text" name="role.roleName" class="textInput required" value="${role.roleName}" /></dd>
			</dl>
			<dl>
				<dt><hi:text key="显示信息" entity="Role" />:</dt> <dd><input type="text" name="role.displayRef" class="textInput required" value="${role.displayRef}" /></dd>
			</dl>
			<dl>
				<dt><hi:text key="描述" entity="Role" />:</dt> <dd><input type="text" name="role.description" class="textInput required" value="${role.description}" /></dd>
			</dl>
	
			<div class="divider"></div>
			
			<div style="line-height: 25px">
				<c:forEach var="menu"  items="${menus}" varStatus="menuIndex"> 	
				&nbsp;<a href="javascript:showAuthority('${menu.id}')">${menu.description}</a>
				</c:forEach> 
			</div>
		

			<div style="overflow: auto">
				<table class="list nowrap" width="98%">
					<thead>
						<tr class="ListTableHeader" >  
							<th><hi:text key="权限" entity="RoleAuthority"/></th>
							<th><hi:text key="部门" entity="RoleAuthority"/></th>						
							<th><hi:text key="范围" entity="RoleAuthority"/></th>
							<th width="90" align="center"><div class="button"><div class="buttonContent"><button type="button" onclick="roleCheckAll(1);"><hi:text key="全选" /></button>|<button type="button" onclick="roleCheckAll(0);"><hi:text key="反选" /></button></div></th>
						</tr>  
					</thead>
					
					<tbody>
					<c:forEach var="roleAuthority" items="${roleAuthorities}"  varStatus="roleAuthorityIndex">
  						<tr name="mt_${roleAuthority.authority.menuLink.menu.id}" class="mt_${roleAuthority.authority.menuLink.menu.id}" style="display:none">
							<td>
								${roleAuthority.authority.description}
							</td>
							<td>
							    <c:set  var="orgid" value="${roleAuthority.org.id}" />
					 
								<div id="orgdiv${roleAuthorityIndex.count-1}" name="orgdiv${roleAuthorityIndex.count-1}"  style="display:<c:choose><c:when test="${orgid!=null}">block</c:when> <c:otherwise> none</c:otherwise></c:choose>">
								<c:choose>
									<c:when test="${showMode=='dropdown'}">  
										<select name="roleAuthorities[${roleAuthorityIndex.count-1}].org.id" id="roleAuthorities[${roleAuthorityIndex.count-1}].org.id">
									  	<option value=""></option>
									  	<c:forEach var="org"  items="${orgs}" > 
										    <option value="${org.id}" <c:if test="${org.id eq orgid}" > selected="selected" </c:if> >${org.orgName}</option>
										</c:forEach>
										</select>
									</c:when> 
									<c:otherwise>  
										<input type="hidden" name="roleAuthorities[${roleAuthorityIndex.count-1}].org.id" value="${roleAuthority.org.id}">
										<input type="text" name="roleAuthorities[${roleAuthorityIndex.count-1}].hi_org.orgName" value="${roleAuthority.org.orgName}"
										autocomplete="off" lookupGroup="roleAuthorities" lookupName="org" index="${roleAuthorityIndex.index}" suggestClass="org.hi.base.organization.model.HiOrg" searchFields="orgName"/>
									<a class="btnLook" href="tree.action?menuName=userOrgEditByOrg" lookupGroup="roleAuthorities" lookupName="org" index="${roleAuthorityIndex.index}}" title="<hi:text key="查找带回"/>"><hi:text key="查找带回"/></a>

									</c:otherwise>        
								</c:choose>
								</div>
							</td>					
							<td>
								<c:if test="${roleAuthority.authority.authorityType==1}">					
									<hi:select emu="securityScope" name="roleAuthorities[${roleAuthorityIndex.count-1}].scope" onchange="javascript:scopeChang(this)" defaultValue="2904" />
								</c:if>						
							</td>
							<td>
							    <input type="hidden" name="roleAuthorities[${roleAuthorityIndex.index}].authority.id" value="${roleAuthority.authority.id}" />
								<input type="hidden" name="roleAuthorities[${roleAuthorityIndex.index}].id" value="${roleAuthority.id}" />
								<input name="roleAuthorityIndex" value="${roleAuthorityIndex.count-1}" <c:if test="${roleAuthority.id!= null}">checked="checked"</c:if> type="checkbox">
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
		