
var timezone_lookup = {
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"timezone",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"",
		"lookupSuggestFields":"",		
		"mapping":[{"b":"id", "t":"creator.id"},
				  ]
		}
}

var timezone_detailObject ; 
var timezone_lookupObject ;
var timezone_detailCounts = new Array();

function timezone_parse(){
	timezone_lookupObject = new framework_lookup(timezone_lookup);
	timezone_initDetailTabs();
}

function timezone_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = timezone_lookupObject;
	timezone_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function timezone_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = timezone_lookupObject;
	timezone_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupTimezone(id,timezone,description){
	var timezone = {"id":id,"timezone":timezone,"description":description};
	window.opener.bringBack(timezone);
	window.close();
}

function timezone_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var timezone_detailTabs;
function timezone_initDetailTabs(){
	if($("timezone_detailTabsDIV")!=null){
	   timezone_detailTabs = new CUBBYTab("timezone_detailTabsDIV");
	   timezone_detailTabs.setTabsName(detailNames);
	   timezone_detailTabs.setCloseButtons(detailTabButtons);
	   timezone_detailTabs.setSize("100%",200);   
	   timezone_detailTabs.show();
   }
}
Event.observe(window,"load",timezone_parse);