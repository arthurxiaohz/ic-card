/**
  Copyright (c) 2006, wei.li, wei386@163.com
  All rights reserved.
  More information at http://www.CUBBY.com
  @author wei.li
 */
 

/**
 tab�ؼ�,��ҳ���Div���Tab�ؼ���ʽ�����ʱ����Ҫ����,��Ҫ����ʾΪtab��Div's id ��main1
  *ֻ�и�div�µ�������ʽΪdhtmlgoodies_aTab����,���ܹ���ʾΪtab��ʽ
  <div id="main1">
   <div id="tabViewmain1_0" class="dhtmlgoodies_aTab">this is testA<br/></div>
   <div id="tabViewmain1_1" class="dhtmlgoodies_aTab">this is testBthis is testB<br/></div>
  </div>
  *ִ��show������,�������tabs��id��ΪtabView+_tab����+��ŵ���ʽ,��tabViewmain1_1
  setTabsName:tabs������,tabs����classnameΪdhtmlgoodies_aTab����DIV�Զ�����
  setDefaultActive:����Ĭ����ʾ��Tab,��0��tabs-1
  setSize:����tab�Ŀ�Ⱥ͸߶�
  setCloseButtons:�����Ƿ���ʾ�رհ�ť
  addNewTab:show���к�����µı�ǩ
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
    //��Ϊ���ɵ�tab���Զ�����һ��tab����DIV,��������+1�õ���ǰ��DIV
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
     tabid,tab����,tab����,Զ��tabURL(��ajax��ʽ����),�Ƿ���ʾ�رհ�ť
     */
  addNewTab:function(tabTitle,tabContent,closeButton){    
    createNewTab(this.tabid,tabTitle,tabContent,null,true);
  },
  show:function(){
    initTabs(this.tabid,this.tabsName,this.activeTab,this.width,this.height,this.closeButton);
	//��ʼ����ʱ�����һ��tab�û������м�������ٴδ򿪵�ʱ��û��Ĭ��tab
   showTab(this.tabid,1);
   showTab(this.tabid,0);
  }
}

