/**
 * @author ZhangHuihua@msn.com
 * 
 */

/**
 * 鏅�歛jax琛ㄥ崟鎻愪氦
 * @param {Object} form
 * @param {Object} callback
 */
function validateCallback(form, callback) {
	var $form = $(form);
	if (!$form.valid()) {
		return false;
	}

	$.ajax({
		type: form.method || 'POST',
		url:$form.attr("action"),
		data:$form.serializeArray(),
		dataType:"json",
		cache: false,
		success: callback || DWZ.ajaxDone,
		error: DWZ.ajaxError
	});
	return false;
}


/**
 * 鍚屾ajax鎻愪氦琛ㄥ崟骞惰繑鍥炴槸鍚︽垚鍔�
 * @param {Object} form
 */
function syncValidate(form) {
	var $form = $(form);
	if (!$form.valid()) {
		return false;
	}
	
	var result = false;
	$.ajax({
		type: form.method || 'POST',
		url:$form.attr("action"),
		data:$form.serializeArray(),
		dataType:"json",
		async:false,
		cache: false,
		success: function(json){
			DWZ.ajaxDone(json);
			if(json.statusCode == DWZ.statusCode.ok)
				result = true;
		}
	});
	return result;
}

/**
 * 甯︽枃浠朵笂浼犵殑ajax琛ㄥ崟鎻愪氦
 * @param {Object} form
 * @param {Object} callback
 */
function iframeCallback(form, callback){
	var $form = $(form), $iframe = $("#callbackframe");
	if(!$form.valid()) {return false;}

	if ($iframe.size() == 0) {
		$iframe = $("<iframe id='callbackframe' name='callbackframe' src='about:blank' style='display:none'></iframe>").appendTo("body");
	}
//	if(!form.ajax) {
//		$form.append('<input type="hidden" name="ajax" value="1" />');
//	}
	form.target = "callbackframe";
	
	_iframeResponse($iframe[0], callback || DWZ.ajaxDone);
}
function _iframeResponse(iframe, callback){
	var $iframe = $(iframe);
	$iframe.bind("load", function(){
		$iframe.unbind("load");
		
		if (iframe.src == "javascript:'%3Chtml%3E%3C/html%3E';" || // For Safari
			iframe.src == "javascript:'<html></html>';") { // For FF, IE
			return;
		}
		
		var doc = iframe.contentDocument ? iframe.contentDocument : window.frames[iframe.id].document;

		// fixing Opera 9.26,10.00
		if (doc.readyState && doc.readyState != 'complete') return; 
		// fixing Opera 9.64
		if (doc.body && doc.body.innerHTML == "false") return;
	   
		var response;
		
		if (doc.XMLDocument) {
			// response is a xml document Internet Explorer property
			response = doc.XMLDocument;
		} else if (doc.body){
			try{
				response = $iframe.contents().find("body").html();
				if (response) {
					response = eval("(" + response + ")");
				} else {
					response = {};
				}
			} catch (e){ // response is html document or plain text
				response = doc.body.innerHTML;
			}
		} else {
			// response is a xml document
			response = doc;
		}
		
		callback(response);
	});
}

/**
 * navTabAjaxDone鏄疍WZ妗嗘灦涓瀹氫箟鐨勮〃鍗曟彁浜ゅ洖璋冨嚱鏁帮紟
 * 鏈嶅姟鍣ㄨ浆鍥瀗avTabId鍙互鎶婇偅涓猲avTab鏍囪涓簉eloadFlag=1, 涓嬫鍒囨崲鍒伴偅涓猲avTab鏃朵細閲嶆柊杞藉叆鍐呭. 
 * callbackType濡傛灉鏄痗loseCurrent灏变細鍏抽棴褰撳墠tab
 * 鍙湁callbackType="forward"鏃堕渶瑕乫orwardUrl鍊�
 * navTabAjaxDone杩欎釜鍥炶皟鍑芥暟鍩烘湰鍙互閫氱敤浜嗭紝濡傛灉杩樻湁鐗规畩闇�瑕佷篃鍙互鑷畾涔夊洖璋冨嚱鏁�.
 * 濡傛灉琛ㄥ崟鎻愪氦鍙彁绀烘搷浣滄槸鍚︽垚鍔�, 灏卞彲浠ヤ笉鎸囧畾鍥炶皟鍑芥暟. 妗嗘灦浼氶粯璁よ皟鐢―WZ.ajaxDone()
 * <form action="/user.do?method=save" onsubmit="return validateCallback(this, navTabAjaxDone)">
 * 
 * form鎻愪氦鍚庤繑鍥瀓son鏁版嵁缁撴瀯statusCode=DWZ.statusCode.ok琛ㄧず鎿嶄綔鎴愬姛, 鍋氶〉闈㈣烦杞瓑鎿嶄綔. statusCode=DWZ.statusCode.error琛ㄧず鎿嶄綔澶辫触, 鎻愮ず閿欒鍘熷洜. 
 * statusCode=DWZ.statusCode.timeout琛ㄧずsession瓒呮椂锛屼笅娆＄偣鍑绘椂璺宠浆鍒癉WZ.loginUrl
 * {"statusCode":"200", "message":"鎿嶄綔鎴愬姛", "navTabId":"navNewsLi", "forwardUrl":"", "callbackType":"closeCurrent"}
 * {"statusCode":"300", "message":"鎿嶄綔澶辫触"}
 * {"statusCode":"301", "message":"浼氳瘽瓒呮椂"}
 * 
 */
function navTabAjaxDone(json){
	DWZ.ajaxDone(json);
	if (json.statusCode == DWZ.statusCode.ok){
		if (json.navTabId){ //鎶婃寚瀹歯avTab椤甸潰鏍囪涓洪渶瑕佲�滈噸鏂拌浇鍏モ�濄�傛敞鎰弉avTabId涓嶈兘鏄綋鍓峮avTab椤甸潰鐨�
			navTab.reloadFlag(json.navTabId);
		} else { //閲嶆柊杞藉叆褰撳墠navTab椤甸潰
			navTabPageBreak();
		}
		
		if ("closeCurrent" == json.callbackType) {
			setTimeout(function()
					{
							navTab.closeCurrentTab();
							var index = navTab._indexTabId(json.navTabId);
							if(index >=0 );
								navTab._switchTab(index);
					}, 
					100);
		} else if ("forward" == json.callbackType) {
			navTab.reload(json.forwardUrl);
		}
	}
}

/**
 * dialog涓婄殑琛ㄥ崟鎻愪氦鍥炶皟鍑芥暟
 * 鏈嶅姟鍣ㄨ浆鍥瀗avTabId锛屽彲浠ラ噸鏂拌浇鍏ユ寚瀹氱殑navTab. statusCode=DWZ.statusCode.ok琛ㄧず鎿嶄綔鎴愬姛, 鑷姩鍏抽棴褰撳墠dialog
 * 
 * form鎻愪氦鍚庤繑鍥瀓son鏁版嵁缁撴瀯,json鏍煎紡鍜宯avTabAjaxDone涓�鑷�
 */
function dialogAjaxDone(json){
	DWZ.ajaxDone(json);
	if (json.statusCode == DWZ.statusCode.ok){
		if (json.navTabId){
			navTab.reload(json.forwardUrl, {navTabId: json.navTabId});
		}
		$.pdialog.closeCurrent();
	}
}

/**
 * 澶勭悊navTab寮瑰嚭灞備笂鐨勬煡璇�, 浼氶噸鏂拌浇鍏ュ綋鍓峮avTab
 * @param {Object} form
 */
function navTabSearch(form, navTabId){
	if (form[DWZ.pageInfo.pageNum]) form[DWZ.pageInfo.pageNum].value = 1;
	navTab.reload(form.action, {data: $(form).serializeArray(), navTabId:navTabId});
	return false;
}
/**
 * 澶勭悊dialog寮瑰嚭灞備笂鐨勬煡璇�, 浼氶噸鏂拌浇鍏ュ綋鍓峝ialog
 * @param {Object} form
 */
function dialogSearch(form){
	if (form[DWZ.pageInfo.pageNum]) form[DWZ.pageInfo.pageNum].value = 1;
	$.pdialog.reload(form.action, {data: $(form).serializeArray()});
	return false;
}
function dwzSearch(form, targetType){
	if (targetType == "dialog") dialogSearch(form);
	else navTabSearch(form);
	return false;
}

/**
 * 
 * @param {Object} args {pageNum:"",numPerPage:"",orderField:""}
 * @param String formId 鍒嗛〉琛ㄥ崟閫夋嫨鍣紝闈炲繀濉」榛樿鍊兼槸 "pagerForm"
 */
function _getPagerForm($parent, args) {
	var form = $("#pagerForm", $parent).get(0);

	if (form) {
		if (args["pageNum"]) form[DWZ.pageInfo.pageNum].value = args["pageNum"];
		if (args["numPerPage"]) form[DWZ.pageInfo.numPerPage].value = args["numPerPage"];
		if (args["orderField"]) form[DWZ.pageInfo.orderField].value = args["orderField"];
		if (args["orderDirection"] && form[DWZ.pageInfo.orderDirection]) form[DWZ.pageInfo.orderDirection].value = args["orderDirection"];
	}
	
	return form;
}
/**
 * 澶勭悊navTab涓殑鍒嗛〉鍜屾帓搴�
 * @param args {pageNum:"n", numPerPage:"n", orderField:"xxx"}
 */
function navTabPageBreak(args){
	args = args || {};
	var form = _getPagerForm(navTab.getCurrentPanel(), args);
	var params = $(form).serializeArray();
	if (args.targetType) params[params.length] = args.targetType;
	if (form) navTab.reload(form.action, {data: $(form).serializeArray(), callback: args.callback});
}
/**
 * 澶勭悊dialog涓殑鍒嗛〉鍜屾帓搴�
 * @param args {pageNum:"n", numPerPage:"n", orderField:"xxx"}
 */
function dialogPageBreak(args){
	args = args || {};
	var form = _getPagerForm($.pdialog.getCurrent(), args);
	var params = $(form).serializeArray();
	if (args.targetType) params[params.length] = args.targetType;
	if (form) $.pdialog.reload(form.action, {data: params, callback: args.callback});
}
function dwzPageBreak(args){
	if (args.targetType == "dialog") dialogPageBreak(args);
	else navTabPageBreak(args);
}

function navTabTodo(url, callback){
	var $callback = callback || navTabAjaxDone;
	if (! $.isFunction($callback)) $callback = eval('(' + callback + ')');
	$.ajax({
		type:'POST',
		url:url,
		dataType:"json",
		cache: false,
		success: $callback,
		error: DWZ.ajaxError
	});
}

/**
 * A function that triggers when all file uploads have completed. There is no default event handler.
 * @param {Object} event: The event object.
 * @param {Object} data: An object containing details about the upload process:
 * 		- filesUploaded: The total number of files uploaded
 * 		- errors: The total number of errors while uploading
 * 		- allBytesLoaded: The total number of bytes uploaded
 * 		- speed: The average speed of all uploaded files	
 */
function uploadifyAllComplete(event, data){
	if (data.errors) {
		var msg = "The total number of files uploaded: "+data.filesUploaded+"\n"
			+ "The total number of errors while uploading: "+data.errors+"\n"
			+ "The total number of bytes uploaded: "+data.allBytesLoaded+"\n"
			+ "The average speed of all uploaded files: "+data.speed;
		alert("event:" + event + "\n" + msg);
	}
}
/**
 * http://www.uploadify.com/documentation/
 * @param {Object} event
 * @param {Object} queueID
 * @param {Object} fileObj
 * @param {Object} response
 * @param {Object} data
 */
function uploadifyComplete(event, queueId, fileObj, response, data){
	DWZ.ajaxDone(DWZ.jsonEval(response));
}

/**
 * http://www.uploadify.com/documentation/
 * @param {Object} event
 * @param {Object} queueID
 * @param {Object} fileObj
 * @param {Object} errorObj
 */
function uploadifyError(event, queueId, fileObj, errorObj){
	alert("event:" + event + "\nqueueId:" + queueId + "\nfileObj.name:" 
		+ fileObj.name + "\nerrorObj.type:" + errorObj.type + "\nerrorObj.info:" + errorObj.info);
}
