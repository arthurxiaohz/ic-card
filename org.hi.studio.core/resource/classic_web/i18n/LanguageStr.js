
var languageStr_lookup = {
"language":{
		"url":"languageLookup.action?lookup=1",
		"domain":"languageStr",
		"lookupClassName":"org.hi.i18n.model.Language",
		"lookupSearchFields":"",
		"lookupSuggestFields":"",		
		"arrayName":"language.languageStrs",
		"mapping":[{"b":"id", "t":"language.id"},
				  ]
		},
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"languageStr",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"",
		"lookupSuggestFields":"",		
		"arrayName":"language.languageStrs",
		"mapping":[{"b":"id", "t":"creator.id"},
				  ]
		}
}

var languageStr_detailObject ; 
var languageStr_lookupObject ;
var languageStr_detailCounts = new Array();

function languageStr_parse(){
	languageStr_lookupObject = new framework_lookup(languageStr_lookup);
	languageStr_initDetailTabs();
}

function languageStr_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = languageStr_lookupObject;
	languageStr_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function languageStr_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = languageStr_lookupObject;
	languageStr_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupLanguageStr(id,languageCode,value){
	var languageStr = {"id":id,"languageCode":languageCode,"value":value};
	window.opener.bringBack(languageStr);
	window.close();
}

function languageStr_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var languageStr_detailTabs;
function languageStr_initDetailTabs(){
	if($("languageStr_detailTabsDIV")!=null){
	   languageStr_detailTabs = new CUBBYTab("languageStr_detailTabsDIV");
	   languageStr_detailTabs.setTabsName(detailNames);
	   languageStr_detailTabs.setCloseButtons(detailTabButtons);
	   languageStr_detailTabs.setSize("100%",200);   
	   languageStr_detailTabs.show();
   }
}
Event.observe(window,"load",languageStr_parse);