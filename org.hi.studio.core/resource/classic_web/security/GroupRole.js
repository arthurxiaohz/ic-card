
﻿
var groupRole_lookup = {
"securityGroup":{
		"url":"securityGroupList.action?lookup=1",
		"domain":"groupRole",
		"arrayName":"securityGroup.groupRoles",
		"mapping":[{"b":"id", "t":"securityGroup.id"},
				   {"b":"groupName", "t":"groupName"}
				  ]
		},
"role":{
		"url":"roleList.action?lookup=1",
		"domain":"groupRole",
		"arrayName":"securityGroup.groupRoles",
		"mapping":[{"b":"id", "t":"role.id"},
				   {"b":"roleName", "t":"roleName"}
				  ]
		}
}
﻿
var groupRole_detailObject ; 
var groupRole_lookupObject ;
var groupRole_detailCounts = new Array();

function groupRole_parse(){
	groupRole_lookupObject = new framework_lookup(groupRole_lookup);
	groupRole_initDetailTabs();
}
﻿

function groupRole_lookupPOP(name,index){
	framework_lookup_tempobj = groupRole_lookupObject;
	groupRole_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupGroupRole(id,groupName,roleName){
	var groupRole = {"id":id,"groupName":groupName,"roleName":roleName};
	window.opener.bringBack(groupRole);
	window.close();
}
﻿﻿
function groupRole_addNew()
{
	document.formSearch.action="groupRoleView.action?groupRole.id=-1";
	document.formSearch.submit();
}

var groupRole_detailTabs;
function groupRole_initDetailTabs(){
	if($("groupRole_detailTabsDIV")!=null){
	   groupRole_detailTabs = new CUBBYTab("groupRole_detailTabsDIV");
	   groupRole_detailTabs.setTabsName(detailNames);
	   groupRole_detailTabs.setCloseButtons(detailTabButtons);
	   groupRole_detailTabs.setSize(1500,200);   
	   groupRole_detailTabs.show();
   }
}
Event.observe(window,"load",groupRole_parse);