<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<style type="text/css">
<!--
.bu1{
width:30px;display:block;margin-bottom:5px;
}
.bu2{
width:30px;display:block;margin-bottom:5px;
}
.clear{
clear:both;
}
.left{
float:left;
}
.center{
float:left;margin-left:10px;margin-right:0;padding:0;margin-top:35px;
}
.right{
float:left;margin-left:40px;margin-right:0;padding:0;
}
.blank{
height:20px;
width:50px;
}
h1{
width:200px;
text-align:center;
font-size:12px;
margin-top:5px;
margin-bottom:0;
padding:0;
height:25px;
}
h2{
width:200px;
text-align:center;
font-size:12px;
margin-top:5px;
margin-bottom:0;
padding:0;
height:25px;
}
.but{
width:470px;
text-align:right;
height:35px;
}
-->
</style>
<script type="text/javascript" src="security/Role.js"></script>
		<script type="text/javascript">

		    function processResult(result){
		    	if (result.statusCode == DWZ.statusCode.ok)
	           		alert("<hi:text key="保存成功!" />");
		    	else
		    		alert("<hi:text key="保存失败!" />");

		    } 	
			function userRoleAssign(assForm){
				var orgID = $('#orgID').val();
				 
				if (orgID=="")
				{
					alert("<hi:text key="请先选择一个部门!" />")
					return false;
				}
				  //得到OPTION数据
				   var options="";
				   $('#selectedAssociation option').each(function(){
					   options+=$(this).val()+",";
					   });
				   var URL="dwzRoleAssignSave.action";
				   var datas="userIndexs="+options;
		           
				   $.ajax({
		    			type: 'POST',
		    			url:'dwzRoleAssignSave.action?ajax=1',
		    			data:{"userIndexs":options,"role.id":${role.id},"orgID":orgID},
		    			dataType:"json",
		    			cache: false,
		    			success: processResult,
		    			error: DWZ.ajaxError
		    		});
				
				return false;
			}
			function deletedOK(id,userID)
			{
				 $('#selectedAssociation option').remove();
		    	 $('#association option').remove();
		    	 $('#orgID').val('');
				$('#userRole_'+id).remove();
				
			}


			function deleteUser(id,userID){
				if(!window.confirm("确定要删除这个记录吗?")){
				return ;
			   }
				 $.ajax({
		    			type: 'POST',
		    			url:'userRoleRemove.action?ajax=1',
		    			data:{"userRole.id":id},
		    			dataType:"json",
		    			cache: false,
		    			success: deletedOK(id,userID),
		    			error: DWZ.ajaxError
		    		});
		    		
				
		     } 
		     function getUsers(orgID)
		     {
		    	 $('#orgID').val('');
		    	  
		    	 $.ajax({
		    			type: 'POST',
		    			url:'getDwzUserRoles.action',
		    			data:{"orgID":orgID,"roleID":${role.id}},
		    			dataType:"json",
		    			cache: false,
		    			success: setUserInfo,
		    			error: DWZ.ajaxError
		    		});
		     }
		     function setUserInfo(json)
		     {
		    	  
		    	 $('#selectedAssociation option').remove();
		    	 $('#association option').remove();
		    	  
			     for(var i=0;i<json.hasRoleUsers.length;i++)
			     {
			    	 $("<option value="+json.hasRoleUsers[i].id+">"+json.hasRoleUsers[i].fullName+"</option>").appendTo('#selectedAssociation');
			     }

			     for(var i=0;i<json.otherUsers.length;i++)
			     {
			    	 $("<option value="+json.otherUsers[i].id+">"+json.otherUsers[i].fullName+"</option>").appendTo('#association');
			     }
			     $('#orgID').val(json.orgID);
			  
			     
			     
			   
		     }




		 	$(function(){
				//监听左右按钮
				$('#moveRightOne').click(function(){
					return $('#association option:selected').appendTo('#selectedAssociation');
				});
				$('#moveRightAll').click(function(){
					return $('#association option').appendTo('#selectedAssociation');
				});
				$('#moveLeftOne').click(function(){
					return $('#selectedAssociation option:selected').appendTo('#association');
				});
				$('#moveLeftAll').click(function(){
					return $('#selectedAssociation option').appendTo('#association');
				});
				
				//监听两列内双击数据项事件
				$('#association').dblclick(function(){
					return $('#association option:selected').appendTo('#selectedAssociation')
				});
				$('#selectedAssociation').dblclick(function(){
					return $('#selectedAssociation option:selected').appendTo('#association');
				});

								
				});
			
			  

		</script>
	
	<h2 class="contentTitle"><hi:text key="为角色" />:${role.roleName}<hi:text key="分派"/></h2>
   <form name="roleAssignForm" action="dwzRoleAssignSave.action?navTabId=roleList&callbackType=closeCurrent&ajax=1" method="post" onsubmit="return userRoleAssign(this)" >
   <input type="hidden" name="userIndexs" id="userIndexs" value="" />
   <input type="hidden" name="userRole.id" id="userRole.id" value="" />
   <input type="hidden" name="orgID" id="orgID" value="" />
  
   
   			<div class="pageContent" >
   			 
   			    <table width="100%" border="0" cellpadding="1"  align="left" >
								<tr>
									<td nowrap="nowrap" valign="top" width="30%">
									<menu:useMenuDisplayer name="Velocity" config="templates/dwztree.html" bundle="">
									<hi:displayMenu name="com.hi.tree.menu" menuName="roleUserListByOrg" type="common" cssStyle="width:200px; height:200px;"/>
									</menu:useMenuDisplayer>
									</td>
									
									<td nowrap="nowrap" valign="top" width="70%">
   									<div class="left" ><h1>未选人员</h1>
												<select  id="association" name="association" size="12" style="width: 200px">
												</select>
									 </div>
										
									<div class="center"   >
											<div class="blank"></div>
											<div class="bu2"><image id="moveRightOne" src="styles/dwz/themes/default/images/button/torightone.gif"  /></div>
											<div class="bu2"><image type="image" id="moveRightAll" src="styles/dwz/themes/default/images/button/toright.gif" /></div>									
									        <div class="blank"></div>
											<div class="bu1"><image type="image" id="moveLeftOne"  src="styles/dwz/themes/default/images/button/toleftone.gif" /></div>
											<div class="bu1"><image type="image" id="moveLeftAll"  src="styles/dwz/themes/default/images/button/toleft.gif" /></div>
									</div>
										
									<div class="right" ><h2>已选人员</h2>
										 	<select  id="selectedAssociation" name="selectedAssociation" size="12" style="width: 200px">
										 	 
	
										 	</select>
									</div>
								</td>							
							</tr>
								
				</table>
   			</div>
   			
   	<div class="pageContent">
   	
   		<div class="pageFormContent" layoutH="400">
   		
							
   		  <div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span> <hi:text key="权限信息"/></span></a></li>
					 	<li><a href="javascript:void(0)"><span><hi:text key="用户信息"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" >
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="权限" entity="RoleAuthority"/></th>
								<th><hi:text key="部门" entity="RoleAuthority"/></th>
								<th><hi:text key="范围" entity="RoleAuthority"/></th>
							</tr>
						</thead>
						<tbody>
							
							<c:forEach var="item" items="${roleAuthorities}"  varStatus="roleAuthorityIndex">
							<tr>						
								<td>${item.authority.description}</td>
								<td>${item.org.orgName}</td>
				        		<td><hi:select emu="securityScope" name="roleAuthorities[${roleAuthorityIndex.count-1}].scope" isLabel="true"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="overflow: auto">
					<table class="list nowrap" width="98%" >
							<thead>
								<tr class="ListTableHeader" >  
									<th type="text" name="authority.description" size="12"><hi:text key="用户名" entity="RoleAuthority" /></th>
									<th type="text" name="org.orgName" size="12"><hi:text key="事项" entity="RoleAuthority" /></th>						
								 
								</tr>  
							</thead>
							
							<tbody>
							<c:forEach var="userRole" items="${userRoles}"  varStatus="userRoleIndex">
	   							<tr name="userRole_${userRole.id}" id="userRole_${userRole.id}"   >
									<td>
										${userRole.securityUser.fullName}
									</td>
									<td>
							       		<a class="btnDel" href="#"  onclick="javascript:deleteUser('${userRole.id}','${userRole.securityUser.id}')" />				
										 
									</td>					
								 
									 
								</tr>
							</c:forEach>
							</tbody>
					</table>
				</div>
				
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>	
		
		 
		
		
		</div>
	 <div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
	
	</div>
   
		<input type="hidden" id="role.id" name="role.id" value="${role.id}" />
	
		</form>
	