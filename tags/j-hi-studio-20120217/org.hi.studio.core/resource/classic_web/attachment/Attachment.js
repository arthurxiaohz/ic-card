
var attachment_lookup = {
}

var attachment_detailObject ; 
var attachment_lookupObject ;
var attachment_detailCounts = new Array();

function attachment_parse(){
	attachment_lookupObject = new framework_lookup(attachment_lookup);
	attachment_initDetailTabs();
}

function attachment_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = attachment_lookupObject;
	attachment_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupAttachment(id,fileName,attachmentPath,attachDesc,attchSize,imageICO){
	var attachment = {"id":id,"fileName":fileName,"attachmentPath":attachmentPath,"attachDesc":attachDesc,"attchSize":attchSize,"imageICO":imageICO};
	window.opener.bringBack(attachment);
	window.close();
}

function attachment_addNew()
{
	document.formSearch.action="attachmentEdit.action?attachment.id=-1";
	document.formSearch.submit();
}

var attachment_detailTabs;
function attachment_initDetailTabs(){
	if($("attachment_detailTabsDIV")!=null){
	   attachment_detailTabs = new CUBBYTab("attachment_detailTabsDIV");
	   attachment_detailTabs.setTabsName(detailNames);
	   attachment_detailTabs.setCloseButtons(detailTabButtons);
	   attachment_detailTabs.setSize("100%",200);   
	   attachment_detailTabs.show();
   }
}
Event.observe(window,"load",attachment_parse);