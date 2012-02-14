
var message_lookup = {
"creator":{
		"url":"hiUserLookup.action?lookup=1",
		"domain":"message",
		"arrayName":"hiUser.messages",
		"mapping":[{"b":"id", "t":"creator.id"},
				   {"b":"fullName", "t":"userName"}
				  ]
		}
}

var message_detail = {
"messageParameter":{
	"name":"message.messageParameters",
	"containerID":"messageParameter_Tbody",
	"sizeInput":"messageParameter_Length",	
	"POPmethod":"messageParameter_lookupPOP",
	"removeMethod":"message_delDetail",
	"removeAction":"messageParameterRemove.action?messageParameter.id=",	
	"fields":[
			  {"name":"parameterKey","type":"text","size":12},
			  {"name":"parameterValue","type":"text","size":12}
			 ]
	}
}

var message_detailObject ; 
var message_lookupObject ;
var message_detailCounts = new Array();

function message_parse(){
	message_lookupObject = new framework_lookup(message_lookup);
	message_detailObject = new framework_detail(message_detail);
	message_detailCounts.push({"name":"messageParameter","size":CUBBYUtil.getValue(eval("message_detail.messageParameter.sizeInput"))});
	message_initDetailTabs();
}

function message_lookupPOP(name,index){
	framework_lookup_tempIndex = null;
	framework_lookup_tempobj = message_lookupObject;
	message_lookupObject.lookupPOP(name);
	if(index!=null){
		framework_lookup_tempIndex = index;
	}
}

function lookupMessage(id,receiverNames,sender,messageType,createDate,sendDate,isSent,description){
	var message = {"id":id,"receiverNames":receiverNames,"sender":sender,"messageType":messageType,"createDate":createDate,"sendDate":sendDate,"isSent":isSent,"description":description};
	window.opener.bringBack(message);
	window.close();
}
function message_addDetail(detailName){
	var size;
	var index;
	for(i = 0;i<message_detailCounts.length;i++){
		if(detailName==message_detailCounts[i].name){
				size = message_detailCounts[i].size;
				index = i;
				break;
		}
	}
	message_detailObject.addLine(detailName, size);
	message_detailCounts[index].size++;
}

function message_delDetail(id, detailName){
	message_detailObject.deleteLine(id, detailName, event);
}

function message_addNew()
{
	document.formSearch.action="messageEdit.action?message.id=-1";
	document.formSearch.submit();
}

var message_detailTabs;
function message_initDetailTabs(){
	if($("message_detailTabsDIV")!=null){
	   message_detailTabs = new CUBBYTab("message_detailTabsDIV");
	   message_detailTabs.setTabsName(detailNames);
	   message_detailTabs.setCloseButtons(detailTabButtons);
	   message_detailTabs.setSize("100%",200);   
	   message_detailTabs.show();
   }
}
Event.observe(window,"load",message_parse);