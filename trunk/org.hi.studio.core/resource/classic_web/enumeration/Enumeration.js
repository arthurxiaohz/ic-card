
var enumeration_lookup = {
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"enumeration",
		"arrayName":"hiUser.enumerations",
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		}
}

var enumeration_detail = {
"enumerationValue":{
	"name":"enumeration.enumerationValues",
	"containerID":"enumerationValue_Tbody",
	"sizeInput":"enumerationValue_Length",	
	"POPmethod":"enumerationValue_lookupPOP",
	"removeMethod":"enumeration_delDetail",
	"removeAction":"enumerationValueRemove.action?enumerationValue.id=",	
	"fields":[
			  {"name":"valueName","type":"text","size":12},
			  {"name":"displayRef","type":"text","size":30},
			  {"name":"description","type":"text","size":12}
			 ]
	}
}

var enumeration_detailObject ; 
var enumeration_lookupObject ;
var enumeration_detailCounts = new Array();

function enumeration_parse(){
	enumeration_lookupObject = new framework_lookup(enumeration_lookup);
	enumeration_detailObject = new framework_detail(enumeration_detail);
	enumeration_detailCounts.push({"name":"enumerationValue","size":CUBBYUtil.getValue(eval("enumeration_detail.enumerationValue.sizeInput"))});
	enumeration_initDetailTabs();
}

function enumeration_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = enumeration_lookupObject;
	enumeration_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupEnumeration(id,enName,displayRef,description){
	var enumeration = {"id":id,"enName":enName,"displayRef":displayRef,"description":description};
	window.opener.bringBack(enumeration);
	window.close();
}
function enumeration_addDetail(detailName){
	var size;
	var index;
	for(i = 0;i<enumeration_detailCounts.length;i++){
		if(detailName==enumeration_detailCounts[i].name){
				size = enumeration_detailCounts[i].size;
				index = i;
				break;
		}
	}
	enumeration_detailObject.addLine(detailName, size);
	enumeration_detailCounts[index].size++;
}

function enumeration_delDetail(id, detailName){
	enumeration_detailObject.deleteLine(id, detailName, event);
}

function enumeration_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var enumeration_detailTabs;
function enumeration_initDetailTabs(){
	if($("enumeration_detailTabsDIV")!=null){
	   enumeration_detailTabs = new CUBBYTab("enumeration_detailTabsDIV");
	   enumeration_detailTabs.setTabsName(detailNames);
	   enumeration_detailTabs.setCloseButtons(detailTabButtons);
	   enumeration_detailTabs.setSize("100%",200);   
	   enumeration_detailTabs.show();
   }
}
Event.observe(window,"load",enumeration_parse);