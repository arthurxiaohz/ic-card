
var languageCode_lookup = {
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"languageCode",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"",
		"lookupSuggestFields":"",		
		"mapping":[{"b":"id", "t":"creator.id"},
				  ]
		}
}

var languageCode_detailObject ; 
var languageCode_lookupObject ;
var languageCode_detailCounts = new Array();

function languageCode_parse(){
	languageCode_lookupObject = new framework_lookup(languageCode_lookup);
	languageCode_initDetailTabs();
}

function languageCode_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = languageCode_lookupObject;
	languageCode_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function languageCode_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = languageCode_lookupObject;
	languageCode_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupLanguageCode(id,languageCode,description){
	var languageCode = {"id":id,"languageCode":languageCode,"description":description};
	window.opener.bringBack(languageCode);
	window.close();
}

function languageCode_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var languageCode_detailTabs;
function languageCode_initDetailTabs(){
	if($("languageCode_detailTabsDIV")!=null){
	   languageCode_detailTabs = new CUBBYTab("languageCode_detailTabsDIV");
	   languageCode_detailTabs.setTabsName(detailNames);
	   languageCode_detailTabs.setCloseButtons(detailTabButtons);
	   languageCode_detailTabs.setSize("100%",200);   
	   languageCode_detailTabs.show();
   }
}
Event.observe(window,"load",languageCode_parse);