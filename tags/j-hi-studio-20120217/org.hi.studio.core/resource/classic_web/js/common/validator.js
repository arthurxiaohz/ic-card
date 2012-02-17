
function email(value){
//	var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+.)+[A-Za-z0-9]{2,3}$/;
    var myReg = /\w+\@\w+\.\w/;
	if(myReg.test(value)) return null;
    return "\u4f60\u8f93\u5165\u7684\u90ae\u7bb1\u5730\u5740\u6709\u8bef!";
}

function phone(value){
	var myReg =  /^([0-9]+)(([0-9]|[-])+)([0-9]+)$/;
    if(myReg.test(value)) return null;
    return "\u4f60\u8f93\u5165\u7684\u7535\u8bdd\u53f7\u7801\u6709\u8bef!";
}

function integer(value){
	var myReg =  /^[-+]?([0-9]+)$/;
    if(myReg.test(value)) return null;
    return "\u4f60\u8f93\u5165\u7684\u6574\u6570,\u4e0d\u80fd\u6709\u5c0f\u6570\u70b9\u6216\u662f\u5b57\u7b26!";
}

function float(value){
	if(!isNaN(parseFloat(value)) || value == '')   return null;
    return "\u4f60\u8f93\u5165\u7684\u6574\u6570\u6216\u662f\u5c0f\u6570,\u4e0d\u80fd\u662f\u5b57\u7b26!";
}

function mobile(value){
	var myReg =  /^(13[0-9]|15[0-9]|168|189)\d{8}$/;
    if(myReg.test(value)) return null;
    return "\u4f60\u8f93\u5165\u7684\u624b\u673a\u53f7\u7801\u6709\u8bef!";
}
