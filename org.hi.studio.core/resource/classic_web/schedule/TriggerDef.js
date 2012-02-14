
var triggerDef_lookup = {
"jobDetail":{
		"url":"jobDetailDefLookup.action?lookup=1",
		"domain":"triggerDef",
		"arrayName":"jobDetailDef.triggerDefs",
		"mapping":[{"b":"id", "t":"jobDetail.id"},
				   {"b":"jobName", "t":"jobDetailName"}
				  ]
		},
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"triggerDef",
		"arrayName":"jobDetailDef.triggerDefs",
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		}
}

var triggerDef_detailObject ; 
var triggerDef_lookupObject ;
var triggerDef_detailCounts = new Array();

function triggerDef_parse(){
	triggerDef_lookupObject = new framework_lookup(triggerDef_lookup);
	triggerDef_initDetailTabs();
}

function triggerDef_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = triggerDef_lookupObject;
	triggerDef_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupTriggerDef(id,triggerName,jobDetailName,priority,startTime,endTime,cronExpression,enabled,description){
	var triggerDef = {"id":id,"triggerName":triggerName,"jobDetailName":jobDetailName,"priority":priority,"startTime":startTime,"endTime":endTime,"cronExpression":cronExpression,"enabled":enabled,"description":description};
	window.opener.bringBack(triggerDef);
	window.close();
}

function triggerDef_addNew()
{
	document.formSearch.action="triggerDefEdit.action?triggerDef.id=-1";
	document.formSearch.submit();
}

var triggerDef_detailTabs;
function triggerDef_initDetailTabs(){
	if($("triggerDef_detailTabsDIV")!=null){
	   triggerDef_detailTabs = new CUBBYTab("triggerDef_detailTabsDIV");
	   triggerDef_detailTabs.setTabsName(detailNames);
	   triggerDef_detailTabs.setCloseButtons(detailTabButtons);
	   triggerDef_detailTabs.setSize("100%",200);   
	   triggerDef_detailTabs.show();
   }
}
Event.observe(window,"load",triggerDef_parse);