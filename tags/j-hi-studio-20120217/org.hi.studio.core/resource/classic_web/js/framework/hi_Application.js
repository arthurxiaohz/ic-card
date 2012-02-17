/**
  Copyright (c) 2007, wei.li,wei386@163.com
  All rights reserved.
  @author wei.li
  @version 20070604
 */
 
var CUBBYLoading = Class.create();
CUBBYLoading.prototype={
  initialize:function(){this.div = null;},
  init:function(){
    if(this.div==null){
	    var windowwidth = CUBBYUtil.getClientWidth();
	    var divwidth=100;var divheight = 15;
	    this.div = document.createElement("DIV");
	    this.div.id = "CUBBY_loadingDIV";
	    this.div.style.width=divwidth;this.div.style.height=divheight;
	    this.div.style.top=0;this.div.style.left=windowwidth-divwidth-2;
	    this.div.innerHTML="  load......";
	    this.div.className="CUBBY_Loading";  
	    this.div.style.display="none";
	    CUBBYUtil.addElementToBody(this.div);
	    $("CUBBY_loadingDIV").style.display = "none";
    }
  },
  show:function(content){
	  if(content!=null){
         $("CUBBY_loadingDIV").innerHTML = content;
	  }
    Element.show("CUBBY_loadingDIV");  
    
  },
  hide:function(){
    Element.hide("CUBBY_loadingDIV");
  },
  getLoadElement:function(){
    return this.div;
  }
}
var loading = new CUBBYLoading();
 
/**
 ajax支持通用处理函数
*/
var CUBBYAjaxhandle = Class.create();
	CUBBYAjaxhandle.prototype = {
	 initialize:function(b){
       this.show = b;
	 },
	onCreate:function(){
	  if(this.show){
         loading.init();
         loading.show();
	   }
     },
	onComplete:function(){
	  if(this.show){
       loading.hide();
	  }
	 },
    setShow:function(b){
      this.show = b;
	 }

}
//设定处理函数为全局变量，所有ajax操作都会经过该函数处理，
var CUBBYAjaxhandle = new CUBBYAjaxhandle(true);
Ajax.Responders.register(CUBBYAjaxhandle);
 
/**
 支持ajax操作对象,构造对象是需要传入3个参数,
 URL:请求地址;
 formid:如果将formid传入,会自动将form中的元素进行序列化传入请求地址;
 callMethod:成功后回调方法
 */
var CUBBYAjax = Class.create();
CUBBYAjax.prototype = {
  initialize:function (url, formid, callMethod) {
	try {
		this.url = url;
		this.callMethod = callMethod;
		var form = this.initForm(formid);
		this.method = form.method;
		this.pars = form.parameters;
		this.showLoading = true;
	}
	catch (ex) {
		CUBBYUtil.showMessage(ex.message);
	}
  }, 
  /**
    初始化form信息，根据formid初始化form的基本信息
    parameters 为form中所有包含name和value的Element所组成的串（不包含button） 如：a=1&b=2
    method     为form中提交的类型，GET或POST
    action     为form中提交的目标，如test.jsp
   */
  initForm:function (formid) {
	if (CUBBYUtil.checkNotNull(formid)) {
		var parameters = Form.serialize(formid);
		var method = $(formid).method;
		var action = $(formid).action;
		return {"parameters":parameters, "method":method, "action":action};
	} 
	/**else {
		var exception = new Error("没有找到form");
		throw exception;
	}*/
	return {"parameters":null, "method":"POST", "action":null};
  },
  /**
    向远程服务器通过ajax进行请求，所需的参数是构造CUBBYAjax时的基本参数
   */
  request:function(){
    var ajax = this.customRequest({method:this.method,parameters:this.pars,onComplete:this.callMethod});
    return ajax;
  },
  synchronizedRequest:function(){
  	var ajax = this.customRequest({asynchronous:false,method:this.method,parameters:this.pars,onComplete:this.callMethod});
    return ajax;
  },
  /**
    向远程服务器通过ajax进行请求的原始方法，通过options的信息发送，options由客户端javascript配置
   */
  customRequest:function(options){  
	  
     try{
     var ajax = new Ajax.Request(this.url,options);
     return ajax;
     }catch(ex){jslog.error(ex.message);}
  },
  
  update:function(elementid){
    var ajax = this.cusotmUpdate(elementid,{method:this.method,parameters:this.pars,onComplete:this.callMethod});
    return ajax;
  },
  
  update:function(elementid,errorMethod){
    var ajax = this.cusotmUpdate({success:elementid}
                                ,{method:this.method,parameters:this.pars,onComplete:this.callMethod,onFailure:errorMethod});
    return ajax;  
  },
  cusotmUpdate:function(elementid,options){
	  
     try{
     var ajax = new Ajax.Updater(elementid,this.url,options);
     return ajax;
     }catch(ex){jslog.error(ex.message);}
    
  },
  setShowLoading:function(b){	  
    this.showLoading = b;
	CUBBYAjaxhandle.setShow(b);
  }
   
}
