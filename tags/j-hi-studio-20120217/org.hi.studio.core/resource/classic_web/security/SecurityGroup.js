
﻿
var securityGroup_lookup = {
}
﻿
var securityGroup_detailObject ; 
var securityGroup_lookupObject ;
var securityGroup_detailCounts = new Array();

function securityGroup_parse(){
	securityGroup_lookupObject = new framework_lookup(securityGroup_lookup);
	securityGroup_initDetailTabs();
}
﻿

function securityGroup_lookupPOP(name,index){
	framework_lookup_tempobj = securityGroup_lookupObject;
	securityGroup_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupSecurityGroup(id,groupName,displayRef,description){
	var securityGroup = {"id":id,"groupName":groupName,"displayRef":displayRef,"description":description};
	window.opener.bringBack(securityGroup);
	window.close();
}
﻿﻿
function securityGroup_addNew()
{
	document.formSearch.action="securityGroupView.action?securityGroup.id=-1";
	document.formSearch.submit();
}

var securityGroup_detailTabs;
function securityGroup_initDetailTabs(){
	if($("securityGroup_detailTabsDIV")!=null){
	   securityGroup_detailTabs = new CUBBYTab("securityGroup_detailTabsDIV");
	   securityGroup_detailTabs.setTabsName(detailNames);
	   securityGroup_detailTabs.setCloseButtons(detailTabButtons);
	   securityGroup_detailTabs.setSize(1500,200);   
	   securityGroup_detailTabs.show();
   }
}
Event.observe(window,"load",securityGroup_parse);