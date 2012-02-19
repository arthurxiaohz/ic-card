
var privilegeResource_lookup = {
}

var privilegeResource_detailObject ; 
var privilegeResource_lookupObject ;
var privilegeResource_detailCounts = new Array();

function privilegeResource_parse(){
	privilegeResource_lookupObject = new framework_lookup(privilegeResource_lookup);
	privilegeResource_initDetailTabs();
}

function privilegeResource_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = privilegeResource_lookupObject;
	privilegeResource_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupPrivilegeResource(id,authorityName,viewLayer,businessLayer){
	var privilegeResource = {"id":id,"authorityName":authorityName,"viewLayer":viewLayer,"businessLayer":businessLayer};
	window.opener.bringBack(privilegeResource);
	window.close();
}

function privilegeResource_addNew()
{
	document.formSearch.action="privilegeResourceEdit.action?privilegeResource.id=-1";
	document.formSearch.submit();
}

var privilegeResource_detailTabs;
function privilegeResource_initDetailTabs(){
	if($("privilegeResource_detailTabsDIV")!=null){
	   privilegeResource_detailTabs = new CUBBYTab("privilegeResource_detailTabsDIV");
	   privilegeResource_detailTabs.setTabsName(detailNames);
	   privilegeResource_detailTabs.setCloseButtons(detailTabButtons);
	   privilegeResource_detailTabs.setSize("100%",200);   
	   privilegeResource_detailTabs.show();
   }
}
Event.observe(window,"load",privilegeResource_parse);