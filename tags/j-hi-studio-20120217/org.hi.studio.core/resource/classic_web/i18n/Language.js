
var language_lookup = {
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"language",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"",
		"lookupSuggestFields":"",		
		"mapping":[{"b":"id", "t":"creator.id"},
				  ]
		}
}

var language_detail = {
"languageStr":{
	"name":"language.languageStrs",
	"containerID":"languageStr_Tbody",
	"sizeInput":"languageStr_Length",	
	"POPmethod":"languageStr_lookupPOP",
	"removeMethod":"language_delDetail",
	"removeAction":"languageStrRemove.action?languageStr.id=",	
	"fields":[
			  {"name":"languageCode","type":"text","size":12},
			  {"name":"value","type":"text","size":12}
			 ]
	}
}

var language_detailObject ; 
var language_lookupObject ;
var language_detailCounts = new Array();

function language_parse(){
	language_lookupObject = new framework_lookup(language_lookup);
	language_detailObject = new framework_detail(language_detail);
	language_detailCounts.push({"name":"languageStr","size":CUBBYUtil.getValue(eval("language_detail.languageStr.sizeInput"))});
	language_initDetailTabs();
}

function language_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = language_lookupObject;
	language_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function language_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = language_lookupObject;
	language_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupLanguage(id,keyStr,service,entity){
	var language = {"id":id,"keyStr":keyStr,"service":service,"entity":entity};
	window.opener.bringBack(language);
	window.close();
}
function language_addDetail(detailName){
	var size;
	var index;
	for(i = 0;i<language_detailCounts.length;i++){
		if(detailName==language_detailCounts[i].name){
				size = language_detailCounts[i].size;
				index = i;
				break;
		}
	}
	language_detailObject.addLine(detailName, size);
	language_detailCounts[index].size++;
}

function language_delDetail(id, detailName){
	language_detailObject.deleteLine(id, detailName, event);
}

function language_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var language_detailTabs;
function language_initDetailTabs(){
	if($("language_detailTabsDIV")!=null){
	   language_detailTabs = new CUBBYTab("language_detailTabsDIV");
	   language_detailTabs.setTabsName(detailNames);
	   language_detailTabs.setCloseButtons(detailTabButtons);
	   language_detailTabs.setSize("100%",200);   
	   language_detailTabs.show();
   }
}
Event.observe(window,"load",language_parse);