
var userRole_lookup = {
"securityUser":{
		"url":"hiUserList.action?lookup=1",
		"domain":"userRole",
		"arrayName":"hiUser.userRoles",
		"mapping":[{"b":"id", "t":"securityUser.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		},
"role":{
		"url":"roleList.action?lookup=1",
		"domain":"userRole",
		"arrayName":"hiUser.userRoles",
		"mapping":[{"b":"id", "t":"role.id"},
				   {"b":"roleName", "t":"roleName"}
				  ]
		}
}

var userRole_detailObject ; 
var userRole_lookupObject ;
var userRole_detailCounts = new Array();

function userRole_parse(){
	userRole_lookupObject = new framework_lookup(userRole_lookup);
	userRole_initDetailTabs();
}

function userRole_lookupPOP(name,index){
	framework_lookup_tempobj = userRole_lookupObject;
	userRole_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupUserRole(id,userName,roleName){
	var userRole = {"id":id,"userName":userName,"roleName":roleName};
	window.opener.bringBack(userRole);
	window.close();
}

function userRole_addNew()
{
	document.formSearch.action="userRoleEdit.action?userRole.id=-1";
	document.formSearch.submit();
}

var userRole_detailTabs;
function userRole_initDetailTabs(){
	if($("userRole_detailTabsDIV")!=null){
	   userRole_detailTabs = new CUBBYTab("userRole_detailTabsDIV");
	   userRole_detailTabs.setTabsName(detailNames);
	   userRole_detailTabs.setCloseButtons(detailTabButtons);
	   userRole_detailTabs.setSize("100%",200);   
	   userRole_detailTabs.show();
   }
}
Event.observe(window,"load",userRole_parse);