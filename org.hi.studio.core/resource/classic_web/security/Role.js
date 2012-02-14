
var role_lookup = {
}

var role_detailObject ; 
var role_lookupObject ;
var role_detailCounts = new Array();

function role_parse(){
	role_lookupObject = new framework_lookup(role_lookup);
	role_initDetailTabs();
}

function role_lookupPOP(name,index){
	framework_lookup_tempobj = role_lookupObject;
	role_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupRole(id,roleName,displayRef,description){
	var role = {"id":id,"roleName":roleName,"displayRef":displayRef,"description":description};
	window.opener.bringBack(role);
	window.close();
}

function role_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var role_detailTabs;
function role_initDetailTabs(){
	if($("role_detailTabsDIV")!=null){
	   role_detailTabs = new CUBBYTab("role_detailTabsDIV");
	   role_detailTabs.setTabsName(detailNames);
	   role_detailTabs.setCloseButtons(detailTabButtons);
	   role_detailTabs.setSize("100%",200);   
	   role_detailTabs.show();
   }
}
Event.observe(window,"load",role_parse);


function deleteUser(id){
		if(!window.confirm("确定要删除这个记录吗?")){
		return ;
	}
		var ele = Event.element(event).parentElement.parentElement;
		Element.remove(ele);
		
		if(id!=null&&id!=""){
			var ajax = new CUBBYAjax("userRoleRemove.action?userRole.id="+id,null,function(response){});
			ajax.request();	
		}
}

function deleteRole(url){
	if(!window.confirm("删除角色会使与该角色对应所有用户的权限无效,确定要删除这个记录吗?")){
		return ;
	}
	document.formSearch.action=url;
	document.formSearch.submit();
}