/**
   Copyright (c) 2007, wei.li,wei386@163.com
   All rights reserved.
   @author wei.li
   @version 20070604
   this is static class,et. CUBBYUtil.checkNotNull(id) 
   @author wei.li
 */
var CUBBYUtil = {
   /**
    *检测以elementid为id的ELement是否为空
    */
   checkNotNull:function(elementid){
	   if(null != $(elementid)){
		   return true;
	   }
	   return false;
   },
   getValue:function(elementid){
   	if(this.checkNotNull(elementid)){
   		return $(elementid).value;
   	}
   	return 0;
   },

   showMessage:function(message){
	   alert(message);
   },
   
   getClientHeight:function(){
      if (window.innerHeight!=window.undefined) return window.innerHeight;
	  if (document.compatMode=='CSS1Compat') return document.documentElement.clientHeight;
	  if (document.body) return document.body.clientHeight; 
	  return window.undefined; 
   },
   getClientWidth:function(){
      if (window.innerWidth!=window.undefined) return window.innerWidth; 
	  if (document.compatMode=='CSS1Compat') return document.documentElement.clientWidth; 
	  if (document.body) return document.body.clientWidth; 
	  return window.undefined; 
   },
   addElementToBody:function(element){
     if($('body')!=null){$('body').appendChild(element);}
	    else if(document.getElementsByTagName("BODY")[0]){document.getElementsByTagName("BODY")[0].appendChild(element);}
	    else{document.firstChild().appendChild(element);} 
   },
   evalScripts:function(html){
    var isopera = this.isopera();
	var firefox = this.isfirfox();
	//if(isopera|firefox) {return;} // wei.li firefox and opera is auto load script,but ie cann't
	var matchAll = new RegExp(Prototype.ScriptFragment, 'img');
    var scripts = html.match(matchAll); 
    var headEle = document.getElementsByTagName("head")[0];
    for(var i = 0; scripts && i < scripts.length; i++)
    {       
        var scriptEle = document.createElement("script");
        scriptEle.type = "text/javascript";
        var script = scripts[i];
        
        var res = script.match(/src=\"(.*)\"/ig);   
  
        if(res)
        {
           scriptEle.src = RegExp.$1;
        }else{
            scripts[i].match(/<script.*?>"(.*)\"<\/script>/);
            scriptEle.text = RegExp.$1;
            jslog.info(script);
        }
        headEle.appendChild(scriptEle); 
        
    }
	//html.evalScripts();	
   },
   isopera:function(){
     return navigator.userAgent.toLowerCase().indexOf('opera')>=0?true:false;
   },
   isfirfox:function(){
     return  navigator.userAgent.toLowerCase().indexOf('firefox')>=0?true:false;
   }
}

var CUBBYXML = Class.create();
CUBBYXML.prototype = {
	initialize:function(xmlstr){
		this.xml = null;
		if(document.all){
		 	var xmlDom=new ActiveXObject("Microsoft.XMLDOM");
		 	xmlDom.loadXML(xmlstr) ;
		 	this.xml=xmlDom ;
		 }
		 else{
		 	this.xml= new DOMParser().parseFromString(xmlstr, "text/xml");
		 }
	},
	getXMLObject:function(){
		return this.xml;
	}
	
}

String.prototype.trim  = function(){return this.replace(/^\s+|\s+$/g,"");}
String.prototype.ltrim = function(){return this.replace(/^\s+/g, "");}
String.prototype.rtrim = function(){return this.replace(/\s+$/g, "");}
String.prototype.startsWith = function(s){return this.substring(0, s.length) == s;}
String.prototype.endsWith = function (s) {
    var start = this.length - s.length;
    return this.substring(start) == s;
}


