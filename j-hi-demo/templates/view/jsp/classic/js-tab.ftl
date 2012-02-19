
function ${entity.entityName?uncap_first}_addNew(url)
{
	document.formSearch.action=url;
	document.formSearch.submit();
}

var ${entity.entityName?uncap_first}_detailTabs;
function ${entity.entityName?uncap_first}_initDetailTabs(){
	if($("${entity.entityName?uncap_first}_detailTabsDIV")!=null){
	   ${entity.entityName?uncap_first}_detailTabs = new CUBBYTab("${entity.entityName?uncap_first}_detailTabsDIV");
	   ${entity.entityName?uncap_first}_detailTabs.setTabsName(detailNames);
	   ${entity.entityName?uncap_first}_detailTabs.setCloseButtons(detailTabButtons);
	   ${entity.entityName?uncap_first}_detailTabs.setSize("100%",200);   
	   ${entity.entityName?uncap_first}_detailTabs.show();
   }
}