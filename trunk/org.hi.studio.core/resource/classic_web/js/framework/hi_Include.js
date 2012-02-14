/**
  Copyright (c) 2007, wei.li,wei386@163.com
  All rights reserved.
  @author wei.li
  @version 20070604
 */
 document.write('<link rel="stylesheet" type="text/css" media="all" href="js/calendar/skins/aqua/theme.css" title="win2k-cold-1" />');
function _inc(pa) { 
	document.write('<script type="text/javascript" src="js/' + pa + '"></script>'); 
};

//_inc();
_inc("ajax/prototype/prototype.js");
_inc("ajax/scriptaculous/scriptaculous.js");
_inc("ajax/widget/tab/tab-view.js");
_inc("datepicker/wdatePicker.js");

/**
_inc("widget/tab/tab-view.js");
_inc("submodal/common.js");
_inc("submodal/subModal.js");
_inc("widget/tooltip/balloonTooltip.js");
**/
//_inc("jslog.js");

_inc("framework/hi_Util.js");
_inc("framework/hi_Widget.js");
_inc("framework/hi_Application.js");
_inc("framework/hi_detail.js");
_inc("framework/hi_lookup.js");
_inc("framework/hi_lookupSuggest.js");

/*
_inc("calendar/calendar.js");
_inc("calendar/lang/calendar-en.js");
_inc("calendar/lang/calendar-zh.js");
_inc("calendar/calendar-setup.js");
*/
_inc("common/common.js");
_inc("common/validator.js");
