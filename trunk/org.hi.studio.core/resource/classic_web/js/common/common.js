

var sort = "";
var direction = "";
function sortBy(sortField) {
	direction = document.getElementById("pageInfo.sorterDirection").value;
	sort = document.getElementById("pageInfo.sorterName").value = sortField;
	  
	if (sort == sortField) {
		if (direction == "ASC" || direction == "") {
			direction = "DESC";
		} else {
			direction = "ASC";
		}
	} else {
		direction = "ASC";
		sort = sortField;
	}
	
	document.getElementById("pageInfo.sorterName").value = sortField;
	document.getElementById("pageInfo.sorterDirection").value = direction;
	
	document.formSearch.submit();
}

// check required field 
function checkValue(fieldStr)
{
	var checkOk=true;
//  if (fieldStr.length==0)
//  return   checkOk;
	if (fieldStr.length > 0){
        var arrayFieldName = fieldStr.split(',');
        var i;		
        for (i=0; i<arrayFieldName.length; i++)
        {
            var obj = document.getElementById(arrayFieldName[i]);
            if (obj.value == null || obj.value.trim() == "")
            {
            	var labelObj = document.getElementById(arrayFieldName[i] + "Label");
               	var msg = "\u8bf7\u8f93\u5165\u7ea2\u8272\u7684\u5fc5\u987b\u586b\u5199\u9879"
               	if(labelObj != null)
               		msg+="\n" + labelObj.innerText;
               	alert(msg);
                obj.focus();
				checkOk=false;
				break;
                //return false;
          
            }
        }
	}
        
        for(i=0; i<document.forms.length; i++){
        	for(j=0; j<document.forms[i].elements.length; j++){
        		var element = document.forms[i].elements[j];
        		if(element.validator && element.value.trim() !=""){
        			var result = eval(element.validator+"('"+element.value+"')");
        			if(result != null){
                       	alert(result);
                       	element.focus();
        				checkOk=false;
        				break;
        			}
        		}
        	}
        }
	return checkOk;
}

function selectAll(flag) {
	if(formSearch.orderId==undefined){
		return;
	}else{
		if(flag=="true"){
			formSearch.chkall.checked=true;
		}
	  	formSearch.orderId.checked= formSearch.chkall.checked
		for (var i = 0; i < formSearch.orderId.length; i++) {
			formSearch.orderId[i].checked = formSearch.chkall.checked;
		}
	}
}
function selectCancel() {
	if(formSearch.orderId==undefined){
		return;
	}
 	formSearch.chkall.checked=false;
  	formSearch.orderId.checked=false;
	for (var i = 0; i < formSearch.orderId.length; i++) {
		formSearch.orderId[i].checked = false;
	}
}
function deleteChecked(tableName) {
	var idString = "";
	if (formSearch.orderId.length==undefined)
	{
	if (formSearch.orderId.checked == true)
	idString = formSearch.orderId.value
	}
	else{
		for (var i = 0; i < formSearch.orderId.length; i++) {
			if (formSearch.orderId[i].checked == true) {
				idString = idString + "," + formSearch.orderId[i].value;
			}
		}
	}
	if (idString.length == 0) {
		alert("\u8bf7\u5148\u9009\u62e9\u8981\u5220\u9664\u7684\u8bb0\u5f55\uff01");
		return;
	}
	if (confirm("\u786e\u5b9e\u8981\u5220\u9664\u8fd9\u4e9b\u8bb0\u5f55\u5417\uff1f")) {
		document.formSearch.action = tableName+"RemoveAll.action?orderIndexs=" + idString;
		document.formSearch.submit();
	}
}

function sortInit(){
	if($("pageInfo.sorterName")!=null){
		sort = document.getElementById("pageInfo.sorterName").value;
		direction = document.getElementById("pageInfo.sorterDirection").value;
	}
}

function formSearchSubmit(){
	if(document.getElementById("pageInfo.currentPage").value!=undefined){
		document.getElementById("pageInfo.currentPage").value="1";
	}
	if(document.getElementById("currentPage").value!=undefined){
		document.getElementById("currentPage").value="1";
	}
	document.formSearch.submit()
}

function pageSubmit(currentPageName,action,formName,targetPage){
	$(currentPageName+".currentPage").value = targetPage;
	document.getElementById("currentPage").value = targetPage;
	$(formName).action = action;
	 
	$(formName).submit();

}
function checkThenSubmit(currentPageName,action,formName,targetPage,totalPage){
	var pageNum = targetPage;
	if(isNaN(parseInt(targetPage))){
		alert("\u8bf7\u8f93\u5165\u6570\u5b57");
		return false;
	}
	if(parseInt(targetPage)>parseInt(totalPage)){
		pageNum = totalPage;
	}
	if(parseInt(targetPage)<=0){
		pageNum = "1";
	}
	pageSubmit(currentPageName,action,formName,pageNum);
}
window.onload = sortInit;


function entityChang(container,obj, inputName, entityName, filterProperty, pageInfo, key, title, pattern, onEvent){
			var val = obj.value;
			var filterStr = filterProperty + "=" + val;
			var ajax = new CUBBYAjax("common/entitySelect.jsp?inputName="+inputName+"&entityName="+entityName+"&filterStr="+filterStr+"&pageInfo="+pageInfo+"&key="+key+"&title="+title+"&pattern="+pattern+"&onEvent="+onEvent,null,function(response){
				
				var content = response.responseText;
				container.innerHTML = content;
				
			});
			ajax.request();
}

function commonAction(formName, url){
	var form = document.forms[formName];
	var oldAction = form.action;
	var oldMethod = form.method;
	
	form.action = url;
	form.method = "post";
	form.submit();
	
	form.action = oldAction;
	form.method = oldMethod;
}