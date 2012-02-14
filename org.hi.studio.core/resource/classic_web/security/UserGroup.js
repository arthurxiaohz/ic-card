
﻿
var userGroup_lookup = {
"securityUser":{
		"url":"hiUserList.action?lookup=1",
		"domain":"userGroup",
		"arrayName":"hiUser.userGroups",
		"mapping":[{"b":"id", "t":"securityUser.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		},
"securityGroup":{
		"url":"securityGroupList.action?lookup=1",
		"domain":"userGroup",
		"arrayName":"hiUser.userGroups",
		"mapping":[{"b":"id", "t":"securityGroup.id"},
				   {"b":"groupName", "t":"groupName"}
				  ]
		}
}
﻿
var userGroup_detailObject ; 
var userGroup_lookupObject ;
var userGroup_detailCounts = new Array();

function userGroup_parse(){
	userGroup_lookupObject = new framework_lookup(userGroup_lookup);
	userGroup_initDetailTabs();
}
﻿

function userGroup_lookupPOP(name,index){
	framework_lookup_tempobj = userGroup_lookupObject;
	userGroup_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupUserGroup(id,userName,groupName){
	var userGroup = {"id":id,"userName":userName,"groupName":groupName};
	window.opener.bringBack(userGroup);
	window.close();
}
﻿﻿
function userGroup_addNew()
{
	document.formSearch.action="userGroupView.action?userGroup.id=-1";
	document.formSearch.submit();
}

var userGroup_detailTabs;
function userGroup_initDetailTabs(){
	if($("userGroup_detailTabsDIV")!=null){
	   userGroup_detailTabs = new CUBBYTab("userGroup_detailTabsDIV");
	   userGroup_detailTabs.setTabsName(detailNames);
	   userGroup_detailTabs.setCloseButtons(detailTabButtons);
	   userGroup_detailTabs.setSize(1500,200);   
	   userGroup_detailTabs.show();
   }
}
Event.observe(window,"load",userGroup_parse);