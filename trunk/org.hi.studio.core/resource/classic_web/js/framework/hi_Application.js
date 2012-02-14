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
 ajax֧��ͨ�ô�����
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
//�趨������Ϊȫ�ֱ���������ajax�������ᾭ���ú�������
var CUBBYAjaxhandle = new CUBBYAjaxhandle(true);
Ajax.Responders.register(CUBBYAjaxhandle);
 
/**
 ֧��ajax��������,�����������Ҫ����3������,
 URL:�����ַ;
 formid:�����formid����,���Զ���form�е�Ԫ�ؽ������л����������ַ;
 callMethod:�ɹ���ص�����
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
    ��ʼ��form��Ϣ������formid��ʼ��form�Ļ�����Ϣ
    parameters Ϊform�����а���name��value��Element����ɵĴ���������button�� �磺a=1&b=2
    method     Ϊform���ύ�����ͣ�GET��POST
    action     Ϊform���ύ��Ŀ�꣬��test.jsp
   */
  initForm:function (formid) {
	if (CUBBYUtil.checkNotNull(formid)) {
		var parameters = Form.serialize(formid);
		var method = $(formid).method;
		var action = $(formid).action;
		return {"parameters":parameters, "method":method, "action":action};
	} 
	/**else {
		var exception = new Error("û���ҵ�form");
		throw exception;
	}*/
	return {"parameters":null, "method":"POST", "action":null};
  },
  /**
    ��Զ�̷�����ͨ��ajax������������Ĳ����ǹ���CUBBYAjaxʱ�Ļ�������
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
    ��Զ�̷�����ͨ��ajax���������ԭʼ������ͨ��options����Ϣ���ͣ�options�ɿͻ���javascript����
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
