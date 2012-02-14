/**
  Copyright (c) 2007, wei.li,wei386@163.com
  All rights reserved.
  @author wei.li
  @version 20070604
 */

var framework_lookup = Class.create();
framework_lookup.prototype = {
	initialize:function(lookupMapping){
		this.lookupMappings = lookupMapping;
	},
	lookupPOP:function(name){
		this.currentlookupName = name;
		var windowName="";
		var oUrl = this.getAttributeValue(name,"url");
		if(oUrl.match(/[$]+[/{]+/g) == null){
			windowName = oUrl;
		}
		else{
			var urlArray = oUrl.split("${");
			for(var i=0; i<urlArray.length; i++) {
				var index = urlArray[i].indexOf("}")			
				if( index < 0)
					windowName+=urlArray[i];
				else{
					windowName += eval(urlArray[i].substring(0,index));
					windowName += urlArray[i].substring(index+1);
				}
			}
		}
		window.open(windowName);
	},
  lookupSuggest:function(name,inputValue,suggestID){
		this.currentlookupName = name;
	    lookupSuggestID = suggestID;
	    var className = this.getAttributeValue(this.currentlookupName,"lookupClassName");
	    var lookupSearchFields = this.getAttributeValue(this.currentlookupName,"lookupSearchFields");
	    lookupSuggestFields=this.getAttributeValue(this.currentlookupName,"lookupSuggestFields");
		var windowName="";
		var oUrl = this.getAttributeValue(name,"url");
		if(oUrl.match(/[$]+[/{]+/g) == null){
			windowName = oUrl;
		}
		else{
			var urlArray = oUrl.split("${");
			for(var i=0; i<urlArray.length; i++) {
				var index = urlArray[i].indexOf("}")			
				if( index < 0)
					windowName+=urlArray[i];
				else{
					windowName += eval(urlArray[i].substring(0,index));
					windowName += urlArray[i].substring(index+1);
				}
			}
		}
		var ajax = new CUBBYAjax("common/lookupSuggest.jsp?className="+className+"&inputValue="+inputValue+"&lookupSearchFields="+lookupSearchFields ,null,function(response){
			var xml = response.responseXML;
			displaySuggest(xml.documentElement);
		});
			ajax.request();	

	},
	getAttributeValue:function(name,attribute){
		return eval("this.lookupMappings."+name+"."+attribute);
	},
	bringBackToDetail:function(obj,index){
		var detailName = this.getAttributeValue(this.currentlookupName,"arrayName");
		var mapping = this.getAttributeValue(this.currentlookupName,"mapping");
		for(i=0;i<mapping.length;i++){
			var b= mapping[i].b;
			var t = mapping[i].t;
			$(detailName+"["+index+"]."+t).value = eval("obj."+b);
		}
	},
	bringBack:function(obj){
		var mapping = this.getAttributeValue(this.currentlookupName,"mapping");
		var domain = this.getAttributeValue(this.currentlookupName,"domain");
		for(i=0;i<mapping.length;i++){
			var b= mapping[i].b;
			var t = mapping[i].t;
			$(domain+"."+t).value = eval("obj."+b);
		}
	},
	bringBackSuggest:function(obj){
	var mapping = this.getAttributeValue(this.currentlookupName,"mapping");
	var domain = this.getAttributeValue(this.currentlookupName,"domain");
		for(i=0;i<mapping.length;i++){
			var b= mapping[i].b;
			var t = mapping[i].t;
			var value;
			var childen = suggestResults[obj].childNodes;
			for(var j = 0; j < childen.length; j++){
				if(childen[j].tagName == b){
					value = childen[j].text;
					break;
				}
			}
			$(domain+"."+t).value = value;
		}
	},
	bringBackSuggestToDetail:function(obj,index){
		var detailName = this.getAttributeValue(this.currentlookupName,"arrayName");
		var mapping = this.getAttributeValue(this.currentlookupName,"mapping");
		for(i=0;i<mapping.length;i++){
			var b= mapping[i].b;
			var t = mapping[i].t;
			var value;
			var childen = suggestResults[obj].childNodes;
			for(var j = 0; j < childen.length; j++){
				if(childen[j].tagName == b){
					value = childen[j].text;
					break;
				}
			}
			$(detailName+"["+index+"]."+t).value = value;
		}
	}
}
var suggestResults;
var framework_lookup_tempobj;
var framework_lookup_tempIndex;
function bringBack(obj){
	if(framework_lookup_tempIndex!=null){
		framework_lookup_tempobj.bringBackToDetail(obj,framework_lookup_tempIndex);
	}else{
		framework_lookup_tempobj.bringBack(obj);
	}
	framework_lookup_tempIndex = null;
}	

function bringBackSuggest(obj){
	 if(framework_lookup_tempIndex!=null){
		framework_lookup_tempobj.bringBackSuggestToDetail(obj,framework_lookup_tempIndex);
	}else{
		framework_lookup_tempobj.bringBackSuggest(obj);
	}
	framework_lookup_tempIndex = null;

}	