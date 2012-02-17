
var enumerationValue_lookup = {
"enumeration":{
		"url":"enumerationLookup.action?lookup=1",
		"domain":"enumerationValue",
		"arrayName":"enumeration.enumerationValues",
		"mapping":[{"b":"id", "t":"enumeration.id"},
				  ]
		},
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"enumerationValue",
		"arrayName":"enumeration.enumerationValues",
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		}
}

var enumerationValue_detailObject ; 
var enumerationValue_lookupObject ;
var enumerationValue_detailCounts = new Array();

function enumerationValue_parse(){
	enumerationValue_lookupObject = new framework_lookup(enumerationValue_lookup);
	enumerationValue_initDetailTabs();
}

function enumerationValue_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = enumerationValue_lookupObject;
	enumerationValue_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupEnumerationValue(id,valueName,displayRef,description){
	var enumerationValue = {"id":id,"valueName":valueName,"displayRef":displayRef,"description":description};
	window.opener.bringBack(enumerationValue);
	window.close();
}

function enumerationValue_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var enumerationValue_detailTabs;
function enumerationValue_initDetailTabs(){
	if($("enumerationValue_detailTabsDIV")!=null){
	   enumerationValue_detailTabs = new CUBBYTab("enumerationValue_detailTabsDIV");
	   enumerationValue_detailTabs.setTabsName(detailNames);
	   enumerationValue_detailTabs.setCloseButtons(detailTabButtons);
	   enumerationValue_detailTabs.setSize("100%",200);   
	   enumerationValue_detailTabs.show();
   }
}
Event.observe(window,"load",enumerationValue_parse);