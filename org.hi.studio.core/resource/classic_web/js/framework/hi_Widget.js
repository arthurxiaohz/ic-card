/**
  Copyright (c) 2006, wei.li, wei386@163.com
  All rights reserved.
  More information at http://www.CUBBY.com
  @author wei.li
 */
 

/**
 tab控件,将页面的Div变成Tab控件样式构造的时候需要传入,将要被显示为tab的Div's id 如main1
  *只有该div下的所有样式为dhtmlgoodies_aTab的子,才能够显示为tab格式
  <div id="main1">
   <div id="tabViewmain1_0" class="dhtmlgoodies_aTab">this is testA<br/></div>
   <div id="tabViewmain1_1" class="dhtmlgoodies_aTab">this is testBthis is testB<br/></div>
  </div>
  *执行show方法后,会把所有tabs的id变为tabView+_tab名称+编号的形式,如tabViewmain1_1
  setTabsName:tabs的名字,tabs根据classname为dhtmlgoodies_aTab的子DIV自动生成
  setDefaultActive:设置默认显示的Tab,从0到tabs-1
  setSize:设置tab的宽度和高度
  setCloseButtons:设置是否显示关闭按钮
  addNewTab:show运行后加入新的标签
*/
var CUBBYTab = Class.create();
CUBBYTab.prototype = {
  initialize:function(tabid){
    this.tabid = tabid; 
    this.tabsName = null;
    this.activeTab = 0;
    this.width = 100;
    this.height = 100;
    this.closeButton = null; 
  },
  setTabsName:function(tabsname){
    this.tabsName = tabsname;
  },
  setDefaultActive:function(tabIndex){
    this.activeTab = tabIndex;
  },
  setSize:function(width,height){
    this.width = width; this.height = height;
  },
  setCloseButtons:function(isShow){
    this.closeButton = isShow;
  },  
  addTabClickEvent:function(method){
   tabclickevent = method;
  },
  getElementByTitle:function(title){
   var currentTabsIndex ; 
   for(i=0;i<this.tabsName.length;i++){
      if(this.tabsName[i]==title){
        currentTabsIndex = i;
        break;
      }
    }
    
    var elements = $(this.tabid).childNodes;
    //因为生成的tab会自动生成一个tab标题DIV,所以这里+1得到当前的DIV
    if(CUBBYUtil.isfirfox()){
    //firefox tab 0,1,2 div=tab*2+space 
      return elements[currentTabsIndex*2+2];
    }
    return elements[currentTabsIndex+1];  
  },
  removeTabClickEvent:function(){
    tabclickevent = null;
  },
  /**
     tabid,tab标题,tab内容,远程tabURL(以ajax形式返回),是否显示关闭按钮
     */
  addNewTab:function(tabTitle,tabContent,closeButton){    
    createNewTab(this.tabid,tabTitle,tabContent,null,true);
  },
  show:function(){
    initTabs(this.tabid,this.tabsName,this.activeTab,this.width,this.height,this.closeButton);
	//初始化的时候进行一下tab置换，进行激活，避免再次打开的时候没有默认tab
   showTab(this.tabid,1);
   showTab(this.tabid,0);
  }
}

