
var appSetting_lookup = {
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"appSetting",
		"arrayName":"hiUser.appSettings",
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"creatorName"}
				  ]
		}
}

var appSetting_detailObject ; 
var appSetting_lookupObject ;
var appSetting_detailCounts = new Array();

function appSetting_parse(){
	appSetting_lookupObject = new framework_lookup(appSetting_lookup);
	appSetting_initDetailTabs();
}

function appSetting_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = appSetting_lookupObject;
	appSetting_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupAppSetting(id,appGroup,appName,appValue){
	var appSetting = {"id":id,"appGroup":appGroup,"appName":appName,"appValue":appValue};
	window.opener.bringBack(appSetting);
	window.close();
}

function appSetting_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var appSetting_detailTabs;
function appSetting_initDetailTabs(){
	if($("appSetting_detailTabsDIV")!=null){
	   appSetting_detailTabs = new CUBBYTab("appSetting_detailTabsDIV");
	   appSetting_detailTabs.setTabsName(detailNames);
	   appSetting_detailTabs.setCloseButtons(detailTabButtons);
	   appSetting_detailTabs.setSize("100%",200);   
	   appSetting_detailTabs.show();
   }
}
Event.observe(window,"load",appSetting_parse);