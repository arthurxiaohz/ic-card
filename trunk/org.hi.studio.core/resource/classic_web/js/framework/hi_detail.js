/**
  Copyright (c) 2007, wei.li,wei386@163.com
  All rights reserved.
  @author wei.li
  @version 20070604
 */

var framework_detail_mappings;

var framework_detail = Class.create();
framework_detail.prototype = {
	initialize:function(mappings){
		framework_detail_mappings = mappings;
	},
	addLine:function(name,index){
		var detailName = this.getAttributeValue(name,"name");
		var tableid = this.getAttributeValue(name,"containerID");
		var tr  = document.getElementById(tableid).insertRow();
		this.lookupMethodName = this.getAttributeValue(name,"POPmethod");
		var mappings = this.getAttributeValue(name,"fields");
		for(i=0;i<mappings.length;i++){
			var tabTd = tr.insertCell();
			tabTd.className="DetailTableData";
			var elementName = detailName+"["+index+"]."+ mappings[i].name;
			this.parseHTML(elementName,index,mappings[i],tabTd,detailName);
		}
		var delTd = tr.insertCell();
		delTd.className="DetailTableData";
		var removeMethod = this.getAttributeValue(name,"removeMethod");
		delTd.innerHTML = "<image src=\"images/delete.gif\" style=\"CURSOR: hand\" onclick=\""+removeMethod+"('','"+name+"')\">";
	},
	deleteLine:function(id,detailName,event){
	if(!window.confirm("确定要删除这个记录吗?")){
		return ;
	}
		var ele = Event.element(event).parentElement.parentElement;
		Element.remove(ele);
		if(id!=null&&id!=""){
			var ajax = new CUBBYAjax(this.getAttributeValue(detailName,"removeAction")+id,null,function(response){});
			ajax.request();	
		}
	},
	getAttributeValue:function(name,attribute){
		return eval("framework_detail_mappings."+name+"."+attribute);
	},
	parseHTML:function(elementName,index,mappingIter,td,detailName){
		var type = mappingIter.type;
	    var size = "12";
	    if(mappingIter.size!=null){
	    	size = mappingIter.size;
	    }
		if(type=="text"){
		    var eventStr = "";
		    if(mappingIter.event!=null){
		    	eventStr = mappingIter.event
		    }
			td.innerHTML = "<input type='text' name='"+elementName+"' id='"+elementName+"' size='"+size + "' "+eventStr+"/>";
			return;
		}
		if(type=="hidden"){
			td.innerHTML = "<input type='hidden' name='"+elementName+"' id='"+elementName+"'/>";
			return;
		}			
		if(type=="lookup"){
			var lookupName = mappingIter.lookupName;
			var lookupPoPmethod = this.lookupMethodName;
			var lookupSuggestMethod = lookupPoPmethod.substring(0,lookupPoPmethod.length -3) + "Suggest";
			var isMainLookup = mappingIter.isMainLookup;
			var html = "";
			if(isMainLookup == undefined || isMainLookup == "true")
				html += "<input type='hidden' name='"+elementName+".id' id='"+elementName+".id'>";
			
			html += "<input type='text' name='"+detailName+"["+index+"]."+mappingIter.field+"' id='"+detailName+"["+index+"]."+mappingIter.field+"' size='" + size +"'";
			if(isMainLookup == undefined || isMainLookup == "true")
				html += " onkeyUp=\""+lookupSuggestMethod+"(event, '"+detailName+"["+index+"]."+mappingIter.field+"','"+lookupName+"','"+detailName+"["+index+"]."+mappingIter.field+".suggest',"+index+")\" onclick="+"\""
				+lookupSuggestMethod+"(event, '"+detailName+"["+index+"]."+mappingIter.field+"','"+lookupName+"','"+detailName+"["+index+"]."+mappingIter.field+".suggest',"+index+")\" onblur=\"showAndHide('"+detailName+"["+index+"]."+mappingIter.field+".suggest','hide');\"";
			html += "/>";
			if(isMainLookup == undefined || isMainLookup == "true")
				html += "<span  style=\"cursor: hand\" onclick=\""+lookupPoPmethod+"('"+lookupName+"',"+index+")\"><img src=\"images/lookup.gif\" width=\"18\" height=\"17\" border=\"0\" /></span>"+
				"<br/><div class='SuggestList' id='"+detailName+"["+index+"]."+mappingIter.field+".suggest'> <div class='SuggestMain'> <ul></ul></div></div>";
			td.innerHTML = html;
			return ;
		}
		if(type=="date" || type=="datetime"){
			var returnHTML;
			var defaultvalue = mappingIter.defaultvalue;
			var readonly = mappingIter.readonly;
			var ajax = new CUBBYAjax("common/dateDetail.jsp?size="+size+"&inputName="+elementName+"&dateType="+type+"&defaultvalue="+defaultvalue+"&readonly="+readonly ,null,function(response){
			var content = response.responseText;
			td.innerHTML = content;
			content.evalScripts();
			//CUBBYUtil.evalScripts(content);
			});
			ajax.request();		
		}
		if(type=="Eum"){
			var eumName = mappingIter.selectName;
			var eumDefaultValue = mappingIter.defaultValue;
			var defaultValue = "";
			if(eumDefaultValue != null)
				defaultValue = "&defaultValue="+eumDefaultValue;
			var returnHTML;
			var ajax = new CUBBYAjax("common/select.jsp?emuName="+eumName+"&inputName="+elementName+defaultValue,null,function(response){
				var content = response.responseText;
//				var selectXML = content.getElementsByTagName("option");
//				var selectName = content.getElementsByTagName("select")[0].attributes;
//				
//				var select1 = document.createElement("select");
//				select1.name = selectName[0].text;
//				for(i=0;i<selectXML.length;i++){
//				var options = selectXML[i];
//					select1.options[i] = new Option(options.text,options.attributes[0].text);	
//				}
				
				td.innerHTML = content;
			});
			ajax.request();
			
		}
	}
	
}

