<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<script>

var xmlHttp;
function cerateXMLHttpRequest(){

	  alert("11111111111");
  if(window.ActiveXObject){
	  alert("222222222");
     xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  else if(window.XMLHttpRequest){
     
     xmlHttp = new XMLHttpReqest();
  }

}
function validate(){
	
	  cerateXMLHttpRequest();
	  alert("333333333333");
	  var phoneNo = document.getElementById("payerPhone").value;
	  var orderid = document.getElementById("orderid").value;
	  alert(phoneNo);
	  if(document.getElementById("payerPhone").value==''){
	     var mess = "";
	     var flag = "true";
	     setMessage(mess,flag);
       return false; 
    }else{
   // alert("date = "+date);
	  var url = "tblTxPayMentOrderSms.action?tblTxPayMentOrder.id="+ orderid +"&phoneNo="+phoneNo;
	 // alert("url = "+url);
	  xmlHttp.open("GET",url,true);
	  xmlHttp.onreadystatechange = callback;
	  xmlHttp.send(null);
	  
    }
	}
	function callback(){
	  
	  if(xmlHttp.readyState == 4){
	     
	     if(xmlHttp.status == 200){
	       var mes = xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
	       //alert("mes="+mes);
	       var val = xmlHttp.responseXML.getElementsByTagName("passed")[0].firstChild.data;
	       //alert("val="+val);
	       // alert("check="+document.commandBB100102.checkFlag.value);
	       if(val=="true"){
	         document.commandBB100102.checkFlag.value = "2";
	       }
	       if(val=="false"){
	         //alert("=====");
	         document.commanBB100102.checkFlag.value = "1";
	       }
	       //alert("checkflag="+document.commandBB100102.checkFlag.value);
	       setMessage(mes,val);
	     }
	  }
	}
	function setMessage(message,isValid){
	  
	  var messageArea = message;
	  //alert("messageArea="+messageArea);
	  var fontColor = "green";
	  if(isValid == "true"){
	    fontColor = "red";
	  }
	  document.getElementById("dateMessage").innerHTML = "<font color=" + fontColor+">"+ message +"</font>";
	 
	 // alert("messageArea="+messageArea);
	 // alert("setMessage star2");
	}
</script>
<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="订单查询"/></h2>
<form action="tblTxPayMentOrderSave.action?navTabId=tblTxPayMentOrderList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
		
		<input type="hidden" name="functionCode" id="orderid" value="${tblTxPayMentOrder.id}"/>
							<div class="goumaitijiao">
							<ul>
									<li style="border-bottom: 1px solid rgb(204, 204, 204);">
									</li>
									<li>
										<div class="contenter_a_content">
											<table cellspacing="0" cellpadding="0" border="0"
												width="100%" class="coupons-table">
												<tbody>
													<br>
													<tr>
														<td>
																<dl>
																	<dt><hi:text key="商品描述" entity="TblTxPayMentOrder"/>：</dt><dd> <a href=${tblTxPayMentOrder.showUrl} target="_blank" >${tblTxPayMentOrder.txBody}</a></dd>
																</dl>
														</td>
												
														<td>
															<dl>
			<dt><hi:text key="交易金额" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.txAmount}</dd>
		</dl>
														</td>
													
													</tr>
													
												<tr height="50px;">
														<td align="left"
															style="font-weight: bold; padding-left: 10px; width: 200px; text-align: left"
															bgcolor="#ffffff" colspan="5">
															应付总额：
														</td>
														<td>
															${tblTxPayMentOrder.txAmount} 
														</td>
												</tr><!-- 未付款 -->
													
														<tr height="50px;">
															<td align="left"
																style="font-weight: bold; padding-left: 10px; width: 200px;text-align: left;"
																bgcolor="#ffffff" colspan="5">
																付款状态：
															<br></td>
															<td>
																未支付
															<br></td>
														</tr>
														
														
														<dl>
																	<dt><hi:text key="手机号码" entity="TblTxPayMentOrder"/>：</dt><dd><input id="payerPhone"   type="text" name="tblTxPayMentOrder.payerPhone" class="textInput" value="${tblTxPayMentOrder.payerPhone}" maxlength="13"/>
														
														
															<INPUT type="button"  style="width:100px" name="validMobileId" id="validMobileId" onClick="validate(); " value="获取验证码" length="20"><span class="red" id="registerMobile"></span></dd>
														</dl>
														
														
														
														<tr>
															<th colspan="5" style="border-right:0;"> 
																付款 <br></th>
															<th style="border-left:0;"><br></th>
															</tr>
															<tr height="50px;">
														<td align="left"
															style="font-weight: bold; padding-left: 10px; width: 200px; text-align: left"
															bgcolor="#ffffff" colspan="5">
															应付总额：
														</td>
														<td>
															32.0 
														</td>
												</tr>
													
												</tbody>
											</table>
										</div>
									</li>
								</ul>
							</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
</div>
</form>
