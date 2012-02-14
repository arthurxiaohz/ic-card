
var excelReportDesign_lookup = {
"creator":{
		"url":"hiUserList.action?lookup=1",
		"domain":"excelReportDesign",
		"arrayName":"hiUser.excelReportDesigns",
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		}
}

var excelReportDesign_detailObject ; 
var excelReportDesign_lookupObject ;
var excelReportDesign_detailCounts = new Array();

function excelReportDesign_parse(){
	excelReportDesign_lookupObject = new framework_lookup(excelReportDesign_lookup);
	excelReportDesign_initDetailTabs();
}

function excelReportDesign_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = excelReportDesign_lookupObject;
	excelReportDesign_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupExcelReportDesign(id,reportName,reportNum,createDate,enabled,description){
	var excelReportDesign = {"id":id,"reportName":reportName,"reportNum":reportNum,"createDate":createDate,"enabled":enabled,"description":description};
	window.opener.bringBack(excelReportDesign);
	window.close();
}

function excelReportDesign_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var excelReportDesign_detailTabs;
function excelReportDesign_initDetailTabs(){
	if($("excelReportDesign_detailTabsDIV")!=null){
	   excelReportDesign_detailTabs = new CUBBYTab("excelReportDesign_detailTabsDIV");
	   excelReportDesign_detailTabs.setTabsName(detailNames);
	   excelReportDesign_detailTabs.setCloseButtons(detailTabButtons);
	   excelReportDesign_detailTabs.setSize("100%",200);   
	   excelReportDesign_detailTabs.show();
   }
}
Event.observe(window,"load",excelReportDesign_parse);