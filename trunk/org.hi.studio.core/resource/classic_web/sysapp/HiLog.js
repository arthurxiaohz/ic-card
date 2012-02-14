
var hiLog_lookup = {
"operator":{
		"url":"hiUserLookup.action?lookup=1",

		"domain":"hiLog",
		"mapping":[{"b":"id", "t":"operator.id"},
				   {"b":"fullName", "t":"operatorName"}
				  ]
		}
}

var hiLog_detailObject ; 
var hiLog_lookupObject ;
var hiLog_detailCounts = new Array();

function hiLog_parse(){
	hiLog_lookupObject = new framework_lookup(hiLog_lookup);
	hiLog_initDetailTabs();
}

function hiLog_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = hiLog_lookupObject;
	hiLog_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupHiLog(id,operatorName,operateDate,action,actionContext){
	var hiLog = {"id":id,"operatorName":operatorName,"operateDate":operateDate,"action":action,"actionContext":actionContext};
	window.opener.bringBack(hiLog);
	window.close();
}

function hiLog_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var hiLog_detailTabs;
function hiLog_initDetailTabs(){
	if($("hiLog_detailTabsDIV")!=null){
	   hiLog_detailTabs = new CUBBYTab("hiLog_detailTabsDIV");
	   hiLog_detailTabs.setTabsName(detailNames);
	   hiLog_detailTabs.setCloseButtons(detailTabButtons);
	   hiLog_detailTabs.setSize("100%",200);   
	   hiLog_detailTabs.show();
   }
}
Event.observe(window,"load",hiLog_parse);