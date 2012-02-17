
var authority_lookup = {
"menuLink":{
		"url":"menuLinkList.action?lookup=1",
		"domain":"authority",
		"arrayName":"menuLink.authoritys",
		"mapping":[{"b":"id", "t":"menuLink.id"},
				   {"b":"description", "t":"menuLinkName"}
				  ]
		}
}

var authority_detailObject ; 
var authority_lookupObject ;
var authority_detailCounts = new Array();

function authority_parse(){
	authority_lookupObject = new framework_lookup(authority_lookup);
	authority_initDetailTabs();
}

function authority_lookupPOP(name,index){
	framework_lookup_tempobj = authority_lookupObject;
	authority_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupAuthority(id,authorityName,propertedResource,description,menuLinkName){
	var authority = {"id":id,"authorityName":authorityName,"propertedResource":propertedResource,"description":description,"menuLinkName":menuLinkName};
	window.opener.bringBack(authority);
	window.close();
}

function authority_addNew()
{
	document.formSearch.action="authorityEdit.action?authority.id=-1";
	document.formSearch.submit();
}

var authority_detailTabs;
function authority_initDetailTabs(){
	if($("authority_detailTabsDIV")!=null){
	   authority_detailTabs = new CUBBYTab("authority_detailTabsDIV");
	   authority_detailTabs.setTabsName(detailNames);
	   authority_detailTabs.setCloseButtons(detailTabButtons);
	   authority_detailTabs.setSize("100%",200);   
	   authority_detailTabs.show();
   }
}
Event.observe(window,"load",authority_parse);