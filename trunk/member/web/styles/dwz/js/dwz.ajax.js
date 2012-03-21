/**
 * @author ZhangHuihua@msn.com
 * 
 */

/**
 * 普�1�7�ajax表单提交
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
 * 同步ajax提交表单并返回是否成劄1�7
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
 * 带文件上传的ajax表单提交
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
 * navTabAjaxDone是DWZ框架中预定义的表单提交回调函数．
 * 服务器转回navTabId可以把那个navTab标记为reloadFlag=1, 下次切换到那个navTab时会重新载入内容. 
 * callbackType如果是closeCurrent就会关闭当前tab
 * 只有callbackType="forward"时需要forwardUrl倄1�7
 * navTabAjaxDone这个回调函数基本可以通用了，如果还有特殊霄1�7要也可以自定义回调函敄1�7.
 * 如果表单提交只提示操作是否成劄1�7, 就可以不指定回调函数. 框架会默认调用DWZ.ajaxDone()
 * <form action="/user.do?method=save" onsubmit="return validateCallback(this, navTabAjaxDone)">
 * 
 * form提交后返回json数据结构statusCode=DWZ.statusCode.ok表示操作成功, 做页面跳转等操作. statusCode=DWZ.statusCode.error表示操作失败, 提示错误原因. 
 * statusCode=DWZ.statusCode.timeout表示session超时，下次点击时跳转到DWZ.loginUrl
 * {"statusCode":"200", "message":"操作成功", "navTabId":"navNewsLi", "forwardUrl":"", "callbackType":"closeCurrent"}
 * {"statusCode":"300", "message":"操作失败"}
 * {"statusCode":"301", "message":"会话超时"}
 * 
 */
function navTabAjaxDone(json){
	DWZ.ajaxDone(json);
	if (json.statusCode == DWZ.statusCode.ok){
		if (json.navTabId){ //把指定navTab页面标记为需要�1�7�重新载入�1�7��1�7�注意navTabId不能是当前navTab页面的1�7
			navTab.reloadFlag(json.navTabId);
		} else { //重新载入当前navTab页面
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
 * dialog上的表单提交回调函数
 * 服务器转回navTabId，可以重新载入指定的navTab. statusCode=DWZ.statusCode.ok表示操作成功, 自动关闭当前dialog
 * 
 * form提交后返回json数据结构,json格式和navTabAjaxDone丄1�7臄1�7
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
 * 处理navTab弹出层上的查评1�7, 会重新载入当前navTab
 * @param {Object} form
 */
function navTabSearch(form, navTabId){
	if (form[DWZ.pageInfo.pageNum]) form[DWZ.pageInfo.pageNum].value = 1;
	navTab.reload(form.action, {data: $(form).serializeArray(), navTabId:navTabId});
	return false;
}
/**
 * 处理dialog弹出层上的查评1�7, 会重新载入当前dialog
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
 * @param String formId 分页表单选择器，非必填项默认值是 "pagerForm"
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
 * 处理navTab中的分页和排庄1�7
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
 * 处理dialog中的分页和排庄1�7
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
