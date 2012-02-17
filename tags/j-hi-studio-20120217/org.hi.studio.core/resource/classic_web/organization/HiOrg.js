
var hiOrg_lookup = {
"manager":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"hiOrg",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"fullName",
		"lookupSuggestFields":"fullName",		
		"mapping":[{"b":"id", "t":"manager.id"},
				   {"b":"fullName", "t":"managerName"}
				  ]
		},
"parentOrg":{
		"url":"hiOrgLookup.action?lookup=1",
		"domain":"hiOrg",
		"lookupClassName":"org.hi.base.organization.model.HiOrg",
		"lookupSearchFields":"orgName",
		"lookupSuggestFields":"orgName",		
		"mapping":[{"b":"id", "t":"parentOrg.id"},
				   {"b":"orgName", "t":"parentOrgName"}
				  ]
		},
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"hiOrg",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"fullName",
		"lookupSuggestFields":"fullName",		
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		}
}

var hiOrg_detailObject ; 
var hiOrg_lookupObject ;
var hiOrg_detailCounts = new Array();

function hiOrg_parse(){
	hiOrg_lookupObject = new framework_lookup(hiOrg_lookup);
	hiOrg_initDetailTabs();
}

function hiOrg_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = hiOrg_lookupObject;
	hiOrg_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function hiOrg_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = hiOrg_lookupObject;
	hiOrg_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupHiOrg(id,orgName,orgNum,managerName,parentOrgName,userName){
	var hiOrg = {"id":id,"orgName":orgName,"orgNum":orgNum,"managerName":managerName,"parentOrgName":parentOrgName,"userName":userName};
	window.opener.bringBack(hiOrg);
	window.close();
}

function hiOrg_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var hiOrg_detailTabs;
function hiOrg_initDetailTabs(){
	if($("hiOrg_detailTabsDIV")!=null){
	   hiOrg_detailTabs = new CUBBYTab("hiOrg_detailTabsDIV");
	   hiOrg_detailTabs.setTabsName(detailNames);
	   hiOrg_detailTabs.setCloseButtons(detailTabButtons);
	   hiOrg_detailTabs.setSize("100%",200);   
	   hiOrg_detailTabs.show();
   }
}
Event.observe(window,"load",hiOrg_parse);