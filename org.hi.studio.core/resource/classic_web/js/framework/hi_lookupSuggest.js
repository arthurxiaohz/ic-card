// for suggest lookup
var lookupSuggestIndex = -1;
function selectItem(e, suggestDIV){
	switch(e.keyCode)   
    { 
    	case 37: //左键 
    		lookupSuggestIndex--; 
            changeItem(suggestDIV, 37); 
            return false;
        case 38: //向上键 
        	lookupSuggestIndex--; 
            changeItem(suggestDIV, 38); 
            return false; 
        case 39: //右键 
        	lookupSuggestIndex++; 
            changeItem(suggestDIV, 39); 
            return false;
        case 40: //向下键 
        	lookupSuggestIndex++; 
            changeItem(suggestDIV, 40); 
            return false; 
        case 13: //回车 
        	changeItem(suggestDIV, 13); 
            return false; 
    }
	return true;
}

function changeItem(suggestDIV, keyCode){
	var uls = suggestDIV.firstChild.firstChild.childNodes;
	for(var i = 0;  i < uls.length; i++){
		if(i == lookupSuggestIndex){
			uls[i].style.background="#F2F5EF";
			if(keyCode == 13){
				uls[i].onmousedown();
				lookupSuggestIndex = -1;
			}
		}
		else
			uls[i].style.background="#FFFFFF";
	}
	if(lookupSuggestIndex >= uls.length) lookupSuggestIndex = -1;
	if(lookupSuggestIndex < -1){ lookupSuggestIndex = uls.length};
}

var showAndHide = function(obj, types) {
	var Layer = window.document.getElementById(obj);
	switch (types) {
	case "show":
		Layer.style.display = "block";
		
		break;
	case "hide":
		Layer.style.display = "none";
		lookupSuggestIndex = -1;
		break;
	}
}


var lookupSuggestID = "";
var lookupSuggestFields = "";

function displaySuggest(beans) {
	var div = document.getElementById(lookupSuggestID);
	var ui = div.firstChild.firstChild;
	if(beans == null){
		ui.innerHTML = "";
		showAndHide(lookupSuggestID, 'hiden');
		return;
	}
	suggestResults = beans.childNodes;

	var str = "";
	ui.innerHTML = "";
	if (suggestResults.length >= 1) {
		for ( var i = 0; i < suggestResults.length; i++) {
			str += "<li onmousedown='bringBackSuggest(" + i
					+ ");showAndHide(\"" + lookupSuggestID + "\",\"hide\")'>"
					+ getSuggestStr(i) + "</li>";
		}
		ui.innerHTML = str;
		showAndHide(lookupSuggestID, 'show');
	}
}

function getSuggestStr(listIndex) {

	var lookupSuggestFieldsArr = lookupSuggestFields.split(",");
	var lookupSuggestDisplayValue = "";
	var value;
	for ( var i = 0; i < lookupSuggestFieldsArr.length; i++) {
		var childen = suggestResults[listIndex].childNodes;
		for(var j = 0; j < childen.length; j++){
			if(childen[j].tagName == lookupSuggestFieldsArr[i]){
				value = childen[j].text;
				break;
			}
		}
	
		if (lookupSuggestDisplayValue == "")
			lookupSuggestDisplayValue = value;
		else
			lookupSuggestDisplayValue = lookupSuggestDisplayValue
					+ "-"
					+ value;

	}
	return lookupSuggestDisplayValue;

}

function registerEvent(mainLookupID, lookupEntity, lookupSuggestID, lookupIndex) {
	Event.observe($(mainLookupID), "click", function() {
		news_lookupSuggest(mainLookupID, lookupEntity, lookupSuggestID,
				lookupIndex)
	});

	Event.observe($(mainLookupID), "keyup", function() {
		news_lookupSuggest(mainLookupID, lookupEntity, lookupSuggestID,
				lookupIndex)
	});

	Event.observe($(mainLookupID), "blur", function() {
		showAndHide(lookupSuggestID, 'hide');
	});

}
