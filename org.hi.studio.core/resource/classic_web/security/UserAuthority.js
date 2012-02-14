
var userAuthority_lookup = {
"user":{
	"url":"hiUserLookup.action?lookup=1",
	"domain":"user",
	"lookupClassName":"org.hi.base.organization.model.HiUser",
	"lookupSearchFields":"fullName",
	"lookupSuggestFields":"fullName",		
	"mapping":[{"b":"id", "t":"id"},
			   {"b":"fullName", "t":"fullName"}
			  ]
	},		
"securityUser":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"userAuthority",
		"lookupClassName":"org.hi.base.organization.model.HiUser",
		"lookupSearchFields":"fullName",
		"lookupSuggestFields":"fullName",		
		"mapping":[{"b":"id", "t":"securityUser.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		},
"authority":{
		"url":"authorityLookup.action?lookup=1",
		"domain":"userAuthority",
		"lookupClassName":"org.hi.framework.security.model.Authority",
		"lookupSearchFields":"description",
		"lookupSuggestFields":"description",		
		"mapping":[{"b":"id", "t":"authority.id"},
				   {"b":"description", "t":"authorityName"}
				  ]
		},
"org":{
		"url":"hiOrgLookup.action?lookup=1",
		"domain":"userAuthority",
		"lookupClassName":"org.hi.base.organization.model.HiOrg",
		"lookupSearchFields":"orgName",
		"lookupSuggestFields":"orgName",		
		"mapping":[{"b":"id", "t":"org.id"},
				   {"b":"orgName", "t":"orgName"}
				  ]
		},
"roleAuthority":{
		"url":"roleAuthorityLookup.action?lookup=1",
		"domain":"userAuthority",
		"lookupClassName":"org.hi.framework.security.model.RoleAuthority",
		"lookupSearchFields":"",
		"lookupSuggestFields":"",		
		"mapping":[{"b":"id", "t":"roleAuthority.id"},
				  ]
		}
}

var userAuthority_detailObject ; 
var userAuthority_lookupObject ;
var userAuthority_detailCounts = new Array();

function userAuthority_parse(){
	userAuthority_lookupObject = new framework_lookup(userAuthority_lookup);
	userAuthority_initDetailTabs();
}

function userAuthority_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = userAuthority_lookupObject;
	userAuthority_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function userAuthority_lookupSuggest(event, lookupInputID,name,suggestID,index) {
	var suggestDIV = document.getElementById(suggestID);
	if(!selectItem(event, suggestDIV)) return;
	var inputValue=document.getElementById(lookupInputID).value;
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = userAuthority_lookupObject;
	userAuthority_lookupObject.lookupSuggest(name,inputValue,suggestID);
	
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupUserAuthority(id,userName,authorityName,orgName,scope){
	var userAuthority = {"id":id,"userName":userName,"authorityName":authorityName,"orgName":orgName,"scope":scope};
	window.opener.bringBack(userAuthority);
	window.close();
}

function userAuthority_addNew()
{
	document.formSearch.action="userAuthorityEdit.action?userAuthority.id=-1";
	document.formSearch.submit();
}

var userAuthority_detailTabs;
function userAuthority_initDetailTabs(){
	if($("userAuthority_detailTabsDIV")!=null){
	   userAuthority_detailTabs = new CUBBYTab("userAuthority_detailTabsDIV");
	   userAuthority_detailTabs.setTabsName(detailNames);
	   userAuthority_detailTabs.setCloseButtons(detailTabButtons);
	   userAuthority_detailTabs.setSize("100%",200);   
	   userAuthority_detailTabs.show();
   }
}
Event.observe(window,"load",userAuthority_parse);


function batchAuthority(){
	document.formSearch.action="batchAuthority.action";
	document.formSearch.submit();
}

function singleBatchAuthority(){
	document.formSearch.action="singleBatchAuthority.action";
	document.formSearch.submit();
}