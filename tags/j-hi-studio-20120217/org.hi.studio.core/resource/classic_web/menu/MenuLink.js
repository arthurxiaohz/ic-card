
var menuLink_lookup = {
"authority":{
		"url":"authorityLookup.action?lookup=1",
		"domain":"menuLink",
		"lookupClassName":"org.hi.framework.security.model.Authority",
		"lookupSearchFields":"authorityName",
		"lookupSuggestFields":"authorityName",		
		"arrayName":"menu.menuLinks",
		"mapping":[{"b":"id", "t":"authority.id"},
				   {"b":"authorityName", "t":"authorityName"}
				  ]
		},
"menu":{
		"url":"menuLookup.action?lookup=1",
		"domain":"menuLink",
		"lookupClassName":"org.hi.base.menu.model.Menu",
		"lookupSearchFields":"menuName,description",
		"lookupSuggestFields":"menuName,description",		
		"arrayName":"menu.menuLinks",
		"mapping":[{"b":"id", "t":"menu.id"},
				   {"b":"menuName", "t":"menuName"},
				   {"b":"description", "t":"menuDescription"}
				  ]
		},
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"menuLink",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"fullName",
		"lookupSuggestFields":"fullName",		
		"arrayName":"menu.menuLinks",
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		}
}

var menuLink_detailObject ; 
var menuLink_lookupObject ;
var menuLink_detailCounts = new Array();

function menuLink_parse(){
	menuLink_lookupObject = new framework_lookup(menuLink_lookup);
	menuLink_initDetailTabs();
}

function menuLink_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = menuLink_lookupObject;
	menuLink_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function menuLink_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = menuLink_lookupObject;
	menuLink_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupMenuLink(id,linkUrl,description,authorityName,sequence,menuName,menuDescription){
	var menuLink = {"id":id,"linkUrl":linkUrl,"description":description,"authorityName":authorityName,"sequence":sequence,"menuName":menuName,"menuDescription":menuDescription};
	window.opener.bringBack(menuLink);
	window.close();
}

function menuLink_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var menuLink_detailTabs;
function menuLink_initDetailTabs(){
	if($("menuLink_detailTabsDIV")!=null){
	   menuLink_detailTabs = new CUBBYTab("menuLink_detailTabsDIV");
	   menuLink_detailTabs.setTabsName(detailNames);
	   menuLink_detailTabs.setCloseButtons(detailTabButtons);
	   menuLink_detailTabs.setSize("100%",200);   
	   menuLink_detailTabs.show();
   }
}
Event.observe(window,"load",menuLink_parse);