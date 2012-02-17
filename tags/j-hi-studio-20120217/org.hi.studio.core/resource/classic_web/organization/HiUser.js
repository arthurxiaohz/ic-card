
var hiUser_lookup = {
"org":{
		"url":"hiOrgLookup.action?lookup=1",
		"domain":"hiUser",
		"lookupClassName":"org.hi.base.organization.model.HiOrg",
		"lookupSearchFields":"orgName",
		"lookupSuggestFields":"orgName",		
		"mapping":[{"b":"id", "t":"org.id"},
				   {"b":"orgName", "t":"orgName"}
				  ]
		},
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"hiUser",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"fullName",
		"lookupSuggestFields":"fullName",		
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"creatorName"}
				  ]
		}
}

var hiUser_detailObject ; 
var hiUser_lookupObject ;
var hiUser_detailCounts = new Array();

function hiUser_parse(){
	hiUser_lookupObject = new framework_lookup(hiUser_lookup);
	hiUser_initDetailTabs();
}

function hiUser_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = hiUser_lookupObject;
	hiUser_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function hiUser_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = hiUser_lookupObject;
	hiUser_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupHiUser(id,userName,fullName,orgName,gender){
	var hiUser = {"id":id,"userName":userName,"fullName":fullName,"orgName":orgName,"gender":gender};
	window.opener.bringBack(hiUser);
	window.close();
}

function hiUser_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var hiUser_detailTabs;
function hiUser_initDetailTabs(){
	if($("hiUser_detailTabsDIV")!=null){
	   hiUser_detailTabs = new CUBBYTab("hiUser_detailTabsDIV");
	   hiUser_detailTabs.setTabsName(detailNames);
	   hiUser_detailTabs.setCloseButtons(detailTabButtons);
	   hiUser_detailTabs.setSize("100%",200);   
	   hiUser_detailTabs.show();
   }
}
Event.observe(window,"load",hiUser_parse);