
var menu_lookup = {
"parentMenu":{
		"url":"menuLookup.action?lookup=1",
		"domain":"menu",
		"lookupClassName":"org.hi.base.menu.model.Menu",
		"lookupSearchFields":"menuName",
		"lookupSuggestFields":"menuName",		
		"mapping":[{"b":"id", "t":"parentMenu.id"},
				   {"b":"menuName", "t":"parentMenuName"}
				  ]
		},
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"menu",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"fullName",
		"lookupSuggestFields":"fullName",		
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		}
}

var menu_detailObject ; 
var menu_lookupObject ;
var menu_detailCounts = new Array();

function menu_parse(){
	menu_lookupObject = new framework_lookup(menu_lookup);
	menu_initDetailTabs();
}

function menu_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = menu_lookupObject;
	menu_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function menu_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = menu_lookupObject;
	menu_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupMenu(id,menuName,description,parentMenuName,sequence){
	var menu = {"id":id,"menuName":menuName,"description":description,"parentMenuName":parentMenuName,"sequence":sequence};
	window.opener.bringBack(menu);
	window.close();
}

function menu_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var menu_detailTabs;
function menu_initDetailTabs(){
	if($("menu_detailTabsDIV")!=null){
	   menu_detailTabs = new CUBBYTab("menu_detailTabsDIV");
	   menu_detailTabs.setTabsName(detailNames);
	   menu_detailTabs.setCloseButtons(detailTabButtons);
	   menu_detailTabs.setSize("100%",200);   
	   menu_detailTabs.show();
   }
}
Event.observe(window,"load",menu_parse);