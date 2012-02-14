
var roleAuthority_lookup = {
"role":{
		"url":"roleList.action?lookup=1",
		"domain":"roleAuthority",
		"arrayName":"role.roleAuthoritys",
		"mapping":[{"b":"id", "t":"role.id"},
				   {"b":"roleName", "t":"roleName"}
				  ]
		},
"authority":{
		"url":"authorityList.action?lookup=1",
		"domain":"roleAuthority",
		"arrayName":"role.roleAuthoritys",
		"mapping":[{"b":"id", "t":"authority.id"},
				   {"b":"authorityName", "t":"authorityName"}
				  ]
		},
"org":{
		"url":"hiOrgList.action?lookup=1",
		"domain":"roleAuthority",
		"arrayName":"role.roleAuthoritys",
		"mapping":[{"b":"id", "t":"org.id"},
				   {"b":"orgName", "t":"orgName"}
				  ]
		}
}

var roleAuthority_detailObject ; 
var roleAuthority_lookupObject ;
var roleAuthority_detailCounts = new Array();

function roleAuthority_parse(){
	roleAuthority_lookupObject = new framework_lookup(roleAuthority_lookup);
	roleAuthority_initDetailTabs();
}

function roleAuthority_lookupPOP(name,index){
	framework_lookup_tempobj = roleAuthority_lookupObject;
	roleAuthority_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupRoleAuthority(id,roleName,authorityName,orgName,scope){
	var roleAuthority = {"id":id,"roleName":roleName,"authorityName":authorityName,"orgName":orgName,"scope":scope};
	window.opener.bringBack(roleAuthority);
	window.close();
}

function roleAuthority_addNew()
{
	document.formSearch.action="roleAuthorityEdit.action?roleAuthority.id=-1";
	document.formSearch.submit();
}

var roleAuthority_detailTabs;
function roleAuthority_initDetailTabs(){
	if($("roleAuthority_detailTabsDIV")!=null){
	   roleAuthority_detailTabs = new CUBBYTab("roleAuthority_detailTabsDIV");
	   roleAuthority_detailTabs.setTabsName(detailNames);
	   roleAuthority_detailTabs.setCloseButtons(detailTabButtons);
	   roleAuthority_detailTabs.setSize("100%",200);   
	   roleAuthority_detailTabs.show();
   }
}
Event.observe(window,"load",roleAuthority_parse);